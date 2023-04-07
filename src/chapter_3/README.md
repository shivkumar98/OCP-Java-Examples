<link href="style.css" rel="stylesheet"></link>

# 🟪  Chapter 3: Generics and Collections

## 🟦 Contents:

 [3.1: Reviewing OCA Collections]()

 [3.2: Working With Generics]()

 [3.3: Using Lists, Sets, Maps and Queues]()
 
 [3.4: Comparator vs Comparable]()

 [3.5: Searching and Sorting]()
 
 [3.6 Additions in Java 8]()

<hr>

## 🟦 Summary:

✅  We use `generics` when we do not want to specify the type for a class

✅  We can define generic interfaces and methods

✅  We can specify the bounds for a generic type to restrict what types can be used in place of a generic

* We use `?` to represent an unknown generic type
* We can restrict the generic type be specifying an upper and lower bound.
    * We can specify an upperbound using with the following syntax `? extends type`
    * We can specify a lower bound using the following syntax `? super type`
* These upper and lower bounds yield compiler errors if we attempt to add unrestricted types to our array list.

✅ The Collection framework consists of four interfaces:

1) `List interface`: an ordered collection which allows duplicates

    - `ArrayList`: standard resizeable list
    - `LinkedList`: fast add/removal of end elements
    - `Vector`: old type

2) `Set interface`: unordered and no duplicates

    - `HashSet`: fast retrieval and unordered
    - `TreeSet`: ordered set

3) `Queue interface`: assumed FIFO

    - `LinkedList': both list and queue, and double-ended
    - `ArrayDeque`: pure double-ended queue

4) `Map interface`: key-value pairs

    - `HashMap`: unordered map
    - `TreeMap`: ordered map

✅ The `Comparable interface` is an interface defining the `compareTo()` method. It can be implemented to define a "natural" ordering for a class

- Most classes already have an implementation of `compareTo()`. E.g. strings ordered aphabetically and numbers by size.

- We can can call `Collections.sort()` to apply the natural ordering to a collection type

- We can implement `compareTo()` by ourselves.

    - If we want an object to come before the argument, then return should be `<0`. 
    - If we want an object is the same as the argument, then the return should `=0`
    - If we want an object to come after the argument, then the return should be `>0`

✅ The `Comparator interface` is a class which defines a `compare()` method. We can use this to create an "artificial" ordering inside a method rather than a class!

✅ You can only call `Collections.sort(someCollection)` if the class implements the `Comparable` interface - otherwise you get compiler error!

✅ We can overload the Collections.sort() method with a lambda which defines the sorting using a comparator

✅ The `binarySearch()` method is only defined if the collection is sorted in ascending order!

✅ A `method reference` is compact syntax for writing to lambdas which call methods

```java
    Compator<Duck> byWeight = DuckHelper::compareByWeight;
```


✅ Collections have the following methods

- `removeIf()` lets us specify a lambda which defines a condition

- `replaceAll()` lets us define a unary lambda to apply an operation to each element

- `forEach()` lets us loop through a collection

✅ Java 8 Map Interface has additional methods which let you merge key-value pairs into maps:

- `merge()` lets us update a value or insert a pair if the key is not present

- `computeIfPresent()` lets us define a bifunction and update a value according to the bifunction if the key is present

- `computeIfAbsent()` lets us insert a value if the key is absent!

<hr>

## 🟦 Introductions:

- The only collections datatype we have seen so far is the **ArrayList**, this chapter will focus on the other data structures of the collections framework for **lists, maps, sets and queues.**

- We will see how to create classes using **generics**

- We will learn how to implement searching and sorting using **Comparable** and **Comparator**

- We will see some methods which use functional interfaces.

### Exam Topics:

1) Generics and Collections

- Create and use a generic class

- Create and use ArrayList, TreeSet, TreeMap and ArrayDeque objects

- Use java.util.Comparator and java.lang.Comparable interfaces

- Iterate using forEach methods on lists and streams

2) Advanced Java Class Design

- Create and use Lambda expressions

3) Generics and Collections

- Filter a collection using lambda expressions

4) Java Stream API

- Use of merge() and flatMap() methods of the Stream API


# 🟪  Chapter 3: Generics and Collections - Review

## 🟦 3.1 Reviewing OCA Collections

* The Java Collections Framework is a set of interfaces. These interfaces are `List`, `Queue`, `Map` and `Set`

### 🟨 Arrays and ArrayList 

* An `ArrayList` is an object which contains other objects. It does not contain primitives - we can store wrapper variants instead. We get the size of an array using the `size()` method.

```java
String[] array = {"gerbil", "mouse"};
List<String> list = Arrays.asList(array);
list.set(1, "test"); // [gerbil, test]
array[0] = "new"; // [new, test] // both strucs are backed by same data
String[] array2 = (String[]) list.toArray(); // converted list back to array!
list.remove(0); // throws UnsupportedOperationException because list is not resizeable!!!
```

### 🟨 Searching and Sorting

```java
int[] numbers = {6,9,1,8};
Arrays.sort(numbers); // numbers = {1,6,8,9}
System.out.println(Arrays.binarySearch(numbers, 6)); // 1
System.out.println(Arrays.binarySearch(numbers, 3)); // -1-1 = -2
```

* Since an ArrayList is a Collection, we call `Collections.sort(list)` and `Collections.binarySearch()`

### 🟨 Wrapper Classes and Auto-boxing

* Here's an example of using the remove method on a list which has 2 overloads

```java
List<Integer> numbers = new ArrayList<Integer>();
numbers.add(1); // [1]
numbers.add(new Integer(3)); // [1, 3]
numbers.add(new Integer(5)); // [1, 3, 5]
numbers.remove(1); // primitive signature used - [1,5]
numbers.remove(new Integer(5)); // [1]
System.out.println(numbers); // [1]
``` 

### 🟨 Diamond Operator

* Generics use the diamond operator `<>`. Generics allow for type safety in a way that previous Java versions could not.

* We can use Generics with Collection types, to restrict the type of objects which can be inserted.

<hr>

## 🟦 3.2 Working with Generics

* Generics help us avoid `ClassCastExeption`'s from occuring.

```java
List<String> names = new ArrayList<String>();
names.add(new StringBuilder("hello")); // compilation error
```

### 🟨 Generic Classes

* We can use generics to introduce a formal type parameter to a class!

```java
    public class Crate<T> {
        private T contents;
        public T emptyCrate(){
            return contents;
        }

        public void packCrate(T contents) {
            this.contents = contents;
        }
    }
```

* We can declare any type for this `T` parameter. E.g. suppose an `Elephant` class exists:

```java
Elephant elephant = new Elephant();
Crater<Elephant> crateForElephant = new Crate<>();
crateForElephantl.packCrate(elephant);
Elephant inNewHome = crateForElephant.emptyCrate();
```

* We can as many formal type parameters as we need! E.g. two in this code:

```java
public class SizeLimitedCrate<T, U> {
    private T contents;
    private U sizeLimit;
    public SizeLimitedCrate(T contents, U sizeLimit) {
        this.contents = contents;
        this.sizeLimit = sizeLimit;
    }
}
```

### 🟨 Type Erasure

* When we specify the formal type parameter, the compiler enforces proper use of the generic type. E.g. if we had `Crate<Robot>`, it is like we are replacing `T` with `Robot`. But this is just during compilation time.

* Behind the scenes, Java is replacing all refs to `T` wwith 😱`Object`😱 types:

```java
public class Crate {
    private Object contents;
    public Object emptyCrate() {
        return contents;
    }
    public void packCrate(Object contents) {
        this.contents = contents;
    }
}
```

* This means that only a single class is created behind the scenes - verses creating one for each type

* The compiler is doing the casting for you!

```java
Robot r = crate.emptyCrate();
// behind the scenes:
Robot r = (Robot) crate.emptyCrate();
```

<hr>

## 🟦 3.3 Generic Interfaces


* An interface can also define a formal type parameter. E.g. if the return of a method is a formal type parameter

```java
public interface Shippable<T> {
    void ship(T t);
}
```

### 🟨 Implementing Generic Interfaces

* There are 3 ways to implement this interface:

1) Specify the formal type parameter:

```java
class ShippableRobotCrate implements Shippable<Robot> {
    public void ship(Robot t) { }
}
```

2) Implement via a generic class:

```java
class ShippableAbstractCrate<U> implements Shippable<T> {
    public void ship(U t);
}
```

3) Old way which uses no generics

```java
class ShippableCrate implements Shippable {
    public void ship(Object t){ }
}
```

### 🟨 What You Can't Do with Generic Types

* ❌ Call the constructor ❌

    - writing `new T()` => compiler error

* ❌ Use primitive type as generic type paarameter ❌

* ❌ Creating a static typed parameter ❌

    - only exists as an instance variable to a class

