uyhgq<link href="style.css" rel="stylesheet"></link>

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

<br>
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

### 🟨 Generic Interfaces


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

<hr>

### 🟨 Generic Methods

* Generic methods are typically declared statically but can be non-static also

* E.g.

```java
public static <T> Crate<T> ship(T t) {
    System.out.println("Preparing "+t);
    return new Crate<T>();
}
```

* The return type is `Crate<T>` and has a parameter of type `T` also. We must declare `<T>` before the return type again for this to be valid.

* Here are 2 valid declarations:

```java
public static <T> void sink(T t) { }
public static <T> T identity(T t) { return t; }
```

* Here is an invalid example:

```java
public static T noGood(T t) { return t; } // DOES NOT COMPILE
```

### 🟨 Optional Syntax for Invoking a Generic Method

* The compiler will figure out which method you need when calling the method normally. Alternatively, you can explicitly type

```java
Box.<String>ship("package");
Box.<String[]>ship(args);
```


<hr>

### 🟨 Interacting with Legacy Code

* Collections without generics are known as raw collections

* Even if we write code which will not throw an `ClassCastException`, a compiler warning eill appear.

* We can still get a `ClassCastException` even if we use generics!

```java
    public class LegacyUnicorns {
        public static void main(String[] args){
            List<Unicorn> unicorns = new ArrayList<>();
            addUnicorn(unicorns);
            Unicorn unicorn = unicorns.get(0); // ClassCastException
        }
        private static void addUnicorn(List unicorn) {
            unicorn.add(new Dragon());
        }
    }
```

* Even though we are using generics, the addUnicorn method adds a new Dragon

* We can also have issues with autoboxing:

```java
    public class LegacyAutoBoxing {
        public static void main(String[] args){
            List numbers = new ArrayList();
            numbers.add(5);
            int result = numbers.get(0);
        }
    }
```

* `numbers.get(0)` returns an object, hence autoboxing cannot take place!

<hr>

### 🟨 Bounds

* We've seen that generics are treated as objects and hence do not have many methods available to them! Bounds come to the rescue 🦸

* We can restrict generic types!

* A `bounded parameter type` is a generic type which specifies a bound for the genereic.

* A `wildcard generic type` is an unknown generic type represented using `?`

### 🟨 Types of Bounds

* We have 3 wildcard types:

1) Unbounded wildcard `?`

* E.g.:

```java
List<?> l = new ArrayList<String>();
```

2) Wildcard with an upper bound `? extends type`

```java
List<? extends Exception> l = new ArrayList<RuntimeException>();
```

3) Wilcard with a lower bound `? super type`

```java
List<? super Exception> l = new ArrayList<Object>();
```

<hr>

### 🟨 Unbounded Wilcards

* You use `?` to specify any type is OK!

* E.g. suppose we wanted to write a method which looks through a list of any type

```java
    public static void printList(List<Object> list){
        for (Object x: list) System.out.println(x);
    }
    public static void main(String[] args) {
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        printList(keywords); // DOES NOT COMPILE
    }
```

* Even though String is a subclass of Object, `List<String>` cannot be assigned to `List<Object>`

* But why? Well consider the following example:

```java
    List<Integer> numbers = new ArrayList<>();
    numbers.add(new Integer(42));
    List<Object> objects = numbers // DOES NOT COMPILE
    objects.add("forty two");
    System.out.println(numbers.get(1));
```

* If the above did compile, then we would be breaking our initial promise that `numbers` can only contain Integer objects!

* We overcome the issue that `List<String>` can not be assigned to `List<Object>` by using `List<?>`!

```java
    public static void printList(List<?> list){
        for (Object x: list) System.out.println(x);
    }
    public static void main(String[] args) {
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        printList(keywords);
    }
```

<hr>

### 🟨 Upper-Bounded Wildcards

* Suppose we wanted to write a method which sums a list of numbers. We cannot write the following:

```java
ArrayList<Number> list = new ArrayList<Integer>(); // DOES NOT COMPILE
```

* We MUST use an upperbounded wildcard so that we only get number types:

```java
ArrayList<? extends Number> list = new ArrayList<Integer>();
```

* This says any class which extends `Number` or is `Number` can be used as the formal type parameter:

```java
public static long total(List<? extends Number> list){
    long count = 0;
    for (Number number: list)
        count += number.longValue();
    return count;
}
```

* Here is an example of upper-bounded wilcarding:

```java
    static class Sparrow extends Bird { }
    static class Bird { }

    public static void main(String[] args){
        List<? extends Bird> birds = new ArrayList<Bird>();
        birds.add(new Bird());      // DOES NOT COMPILE
        birds.add(new Sparrow());   // DOES NOT COMPILE
    }
```

* Java does not know what `List<? extends Bird>` really is. 

* Let's try with an interface:

```java
interface Flyer { void fly(); }
class HangGlider implements Flyer { public void fly() {} }
class Goose implements Flyer { public void fly() {} }
```

* We have two methods which use the `Flyer` interface, one which uses it and another which uses upperbound:

```java
private void anyFlyer(List<Flyer> flyer) {}
private void groupOfFlyers(List<? extends Flyer> flyers) {}
```

* `List<Flyer>` can be passed to both methods

* `List<Goose>` and `List<HangGlider>` can be poassed to only the one with an upperbound

<hr>

### 🟨 Lower-Bounded Wildcards

* Let's try to write a method which adds "quack" to two lists:

```java
List<String> strings = new ArrayList<String>();
strings.add("tweet");
List<Object> objects = new ArrayList<Object>(strings);
addSound(strings);
addSound(objects);
```

* Here are 3 ways which do NOT solve the problem:

1) Using wildcard ?

```java
public static void addSound(List<?> list){ 
    list.add("quack"); // DOES NOT COMPILE
}
```

* Unbounded generics are immutable

2) Using upperbounded wildcard `? extends Object`

```java
private static void addSound2(List<? extends Object> list) {
    list.add("quack"); // does not compile
}
```

* Upper bounded generic types are immutable

3) Using `List<Object>`

```java
private static void addSound3(List<Object> list){
    list.add("quack"); // Does not work with List<String>
}
```

4) Using `List<String>`

```java
private static void addSound4(List<String> list){
    list.add("quack"); // Does not work with List<Object>
}
```

* ✅ We use lower-bounded generics to solve this problem✅

```java
private static void addSound5(List<? super String> list) {
		list.add("quack");
	}
```


### 🟨 Putting it all togetger

#### 🟡 Example 

```java
class A {}
class B extends A {}
class C extends B {}
```

* Why do the following lines compile or not:

```java
List<?>             list1 = new ArrayList<A>();
List<? extends A>   list2 = new ArrayList<A>();
List<? super A>     list3 = new ArrayList<A>();
List<? extends B>   list4 = new ArrayList<A>(); // DOES NOT COMPILE
List<? super B>     list5 = new ArrayList<A>();
List<?>             list6 = new ArrayList<? extends A>(); // DOES NOT COMPILE
```

* For Line 4, we can only instantiate a List of `B` or `C`

* For line 6, we need to now the type of the List.

* Does the following method compile:

```java
<T> T method1(List<? extends T> list) {
    return list.get(0);
}
```

* YES it does!

* Does this compile:

```java
<T> <? extends T> method2(List<? extends T> list) { // DOES NOT COMPILE
    return list.get(0);
}
```

* NO! The return is type is not a real type.

* Does this compile:

```java
<X> void method5(List<X super B> list) { // DOES NOT COMPILE
}
```

* NO! We can not use X as a wildcard! We should've used `?`

<br>
<hr>

## 🟦 3.3 Using Lists, Sets, Maps, and Queues

### 🟨 Introduction

* A collection is a group of objects stored in a single object.

* The **Java Collections Framework** is a set of classes in `java.util` for storing collections. This Collections framework consists of four interfaces:

1) `List` - ordered list which allows duplicates.

2) `Set` - set is a collection which does not allow duplicates

3) `Queue` - FIFO collection

4) `Map` - key value pairs, where duplicate pairs are not allowed!

* `Map` is the only collection which does not implement the `Collection` interface

![](screenshots/2023-04-08-15-47-34.png)

<hr>

### 🟨 Common Colllection Methods

#### `add()`

```java
boolean add(E element)
```

#### `remove()`

```java
boolean remove(Object object)
```

* Returns true if removal is successful, otherwise false

#### `isEmpty() and size()`

```java
boolean isEmpty()
int size()
```

#### `isEmpty() and size()`

```java
boolean isEmpty()
int size()
```

#### `clear()`

```java
void clear()
```

#### `contains()`

```java
boolean contains(Object object)
```


<hr>

### 🟨 Using the List Interface

* List is a collection, where elements can be accessed via an index. It allows duplicate entries. The most common implementation is `ArrayList`


#### 🟡 Comparing List Implementations 🟡

* `ArrayList` is a resizeable structure, we can add elements and it grows automatically. Adding/removing elements is slow (O(N)) but accessing elements is very fast - constant time!

* `LinkedList` implements both `List` and `Queue`. You can access, add, and remove elements at end/beginning of list in constant time.

* `Vector` is the old ArrayList, which is slow but threadsafe

* `Stack` has a push() method which adds to the top of the stack, pop() lets you remove the top of the stack. peek() lets you access the top element

#### 🟡 Working with List Methods 🟡

* The `List` interface has the following additional methods:

```java
void add(E element) // adds element to end
void add(int index, E element) // adds element at index, shifts rest of list to end
E get(int index) // returns element at index
int indexOf(Object o) // returns position of element or -1 if not found
int lastIndexOf(Object o) // returns last occurent of object
void remove(int index) // removes element
E set(int index, E e) // replaces element, returns replaced element
```

* Here's an example of using list methods

```java
List<String> list = new ArrayList<>();
list.add("SD"); // [SD]
list.add(0, "NY"); //[NY,SD]
list.set(1, "FL"); // [NY, FL]
list.remove("NY"); // [FL]
list.remove(0); // []
```

#### 🟡 Looping Through a List 🟡

* We can use `Iterator` to loop through a list:

```java
Iterator<String> iter = list.iterator();
while (iter.hasNext()){
    String string = iter.next();
    // do something with string
}
```

<hr> 

### 🟨 Using the Set Interface


* You use Sets when you want to prevent duplicates.

#### 🟡 Comparing Set Implementations 🟡

* `HashSet` stores hashCodes of the values. It does not allow sorting. Adding and accessing values is in constant time

* 'TreeSet' allows for sorting. Checking for elemenents and insertion is slower at O(log n)

#### 🟡 Working with Set Methods 🟡

*  Using `HashSet`:

```java
Set<Integer> set = new HashSet<>();
boolean b1 = set.add(66); // true
boolean b2 = set.add(10); // true
boolean b3 = set.add(66); // false
boolean b4 = set.add(8);  // true
for (Integer integer: set) System.out.println(integer+","); // 66,8,10,
```

* The insertion order was not preserved!

* Using `TreeSet`:

```java
Set<Integer> set = new TreeSet<>();
boolean b1 = set.add(66); // true
boolean b2 = set.add(10); // true
boolean b3 = set.add(66); // false
boolean b4 = set.add(8);  // true
for (Integer integer: set) System.out.println(integer+",") // 8, 10, 66
```

* Insertion order was now preserved! We can also apply a custom ordering with Comparable interface!!

#### 🟡 The `NavigableSet` Interface 🟡

* The TreeSet implements the `NavigableSet` interface. This has the following methods:

1) `lower(E e)` Method - returns greatest element which is `<e`, otherwise null

```java
E lower(E e)
```

2) `floor(E e)` Method - returns greatest element which is `≤e`, otherwise null

```java
E floor(E e)
```

3) `ceiling(E e)` method - returns smallest element `≥e` otherwise null

```java
E ceiling(E e)
```

4) `higher(E e)` method - returns smallest element `>e` otherwise null

```java
E higher(E e)
```

* Example:

```java
NavigableSet<Integer> set = new TreeSet<>();
for (int i = 1; i <= 20l; i++) set.add(i);
System.out.println(set.lower(10)); // largest <10 => 9
System.out.println(set.floor(10)); // largest <= 10  
System.out.println(set.ceiling(20)); // smallest >=20 20
System.out.println(set.higher(20)); // smallest > 20 null
```


<hr> 

### 🟨 Using the Queue Interface

* You would use a queue when elements are added and removed in a specific order. Typically used for sorting elements before processing them

* A queue is FIFO unless otherwise stated.

#### 🟡 Comparing Queue Implementations 🟡

* We saw previously, that `LinkedList` is a List implementation which allows for adding or remove elements at beginning/end of list in O(1) time.

* The `LinkedList` is also a Queue implementation. It's double-ended meaning you can add/remove elements from either side. It's tradeoff is that it is not as efficient as a Pure queue

* The `ArrayDeque` is a PURE double-ended queue

#### 🟡 Working with Queue Methods 🟡

1) `boolean add(E e)` - adds element to back of queue and returns true, otherwise throws exception

2) `E element()` - returns next element

3) `boolean offer(E e)` - adds an element to back of queue and returns if successful

4) `E remove()` - removes and returns next element. Otherwise returns exception if empty

5) `E peek()`- returns front value of queue, returns null if empty queue

6) `E pop()` - removes front value of queue, throws exception if empty

* ArrayDeque also has the `push()` method

#### 🟡 Example 🟡

* Here is an example:

```java
    Queue<Integer> arrQueue = new ArrayDeque<>();
    System.out.println(arrQueue.offer(10)); // true
    System.out.println(arrQueue); // [10]
    System.out.println(arrQueue.offer(4)); // true
    System.out.println(arrQueue); // [10, 4]
    System.out.println(arrQueue.peek()); // 10
    System.out.println(arrQueue.poll()); // 10
    System.out.println(arrQueue); // [4]
    System.out.println(arrQueue.poll()); // 4
    System.out.println(arrQueue); // []
    System.out.println(arrQueue.poll()); // null
```

* Since `ArrayDeque` is double-ended, we can add elements to the front of queue.


<hr> 

### 🟨 Map

* A `Map` store key-value pairs

#### 🟡 Comparing Map Implementations 🟡

* `HashMap` store keys in a hash table, so it uses `hashCode()` method of the keys to retrieve values more efficiently. This means retrieval and insertion is in O(1) but insertion order is lost.

* `LinkedHashMap` keeps insertion order

* `TreeMap` stores key in a sorted tree structure. Meaning the keys are sorted. Retrieval and insertion is O(log n)

* `Hashtable` is an old threadsafe implementation. It's preferred to use HashMap


#### 🟡 Working with Map Methods 🟡

* Since Map does not extend the Collection interface, it has its own methods!

1) `void clear()` - removes all pairs from map

2) `boolean isEmpty()` 

3) `int size()` - returns number of pairs

4) `V get(Object key)`

5) `V remove(Object key)` - removes mapped value and returns it. Otherwise returns null

6) `V put(K key, V value)` - adds or replaces a value

7) `boolean containsKey(Object key)` - checks whether key exists

8) `boolean containsValue(Object value)` - checks if value exists

9) `Set<K> keySet` - returns all keys

10) `Collection<V> values()` - returns Collection of all values

<br>
<hr>

## 🟦 3.4 Comparator Vs Comparable

* Java has a `Comparable` interface. Classes can implement the Comparable interface and override the `compareTo()` method.

* The `Comparator` is a class which lets you define a different ordering than the object itself provides.

### 🟨 Comparable

* The Comparable interface only has one method:

```java
public interface Comparable<T> {
    public int compareTo(T o);
}
```

* Here is an example of defining an ordering for a `Duck` class based on the name:

```java
public class Duck implements Comparable<Duck> {
    private String name;
    public Duck(String name){
        this.name = name;
    }
    public String toString(){ return name; }
    public int compareTo(Duck d) {
        return name.compareTo(d.name);
    }
    public static void main(String[] args){
        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("Quack"));
        ducks.add(new Duck("Puddles"))
        Collections.sort(ducks); // sorts 
        System.out.println(ducks); // [Puddles, Quack]
    }
}
```

* We could define our own implementation of compareTo(Object o):

1) Return `0` if the objects is same

2) Return `<0` if the current object is less than the argument

3) Return `>0` if the current object is greater than the argument

* Here is an example of using a custom implementation:

```java
public Class Animal implements Comparable<Animal> {    
    private int id;
    public Animal(int id){ this.id = id; }
    public int compareTo(Animal a){
        return id - a.id; 
    }
    public static main(String[] args){
        Animal a1 = new Animal(5);
        Animal a2 = new Animal(7);
        System.out.println(a1.compareTo(a2)); // -2
        System.out.println(a2.compareTo(a1)); // 2
    }
}
```

* Legacy code also has implementations of the Comparable interface using:

```java
public class LegacyDuck implements Comparable {
    private String name;
    public int compareTo(Object obj){
        LedgacyDuck d = (LegacyDuck) obj;
        return name.compareTo(d.name);
    }
}
```

* It's encouraged that the implementation of compareTo(Object o) is consistent with the equals() implementation. I.e. if two are equal under compareTo() then the equals() should return true.

<hr>

### 🟨 Comparator


* Comparator is an interface which let's use define a custom ordering, which overrides the natural overriding of the class

* Suppose we have the Duck class with an additional weight field:

```java
class Duck implements Comparable<Duck> {
	String name;
	int weight;
	public Duck(String name, int weight) {
		this.name=name; this.weight=weight;
	}
	public String toString() {
		return name+ ", "+ weight;
	}
	@Override
	public int compareTo(Duck o) {
		return name.compareTo(o.name);
	}
}
```

* We can create a `Comparator` to create a Comparator object which implements the interface:

```java
    public static void main(String[] args) {
            List<Duck> ducks = new ArrayList<>();
            Duck d1 = new Duck("Puddle",   10);
            Duck d2 = new Duck("Quack", 7);
            ducks.add(d1); ducks.add(d2);
            System.out.println(ducks); // [Puddle, 10, Quack, 7]
            
            // defining a comparator using anonymous inner class
            Comparator<Duck> byWeight = new Comparator<Duck>() {
                @Override
                public int compare(Duck o1, Duck o2) {
                    return o1.weight - o2.weight;
                }
            };
            // sorting using comparator object
            Collections.sort(ducks, byWeight);
            System.out.println(ducks); // [Quack, 7, Puddle, 10]
            
    }
```

#### 🟡 Using Comparable with Lambdas  🟡

* Comparable is a functional interface, hence we can use lambdas!

* We could write the Comparator implementation without an annoynmous inner class using lamdas:

```java
Comparator<Duck> byWeight = (d1, d2) -> d1.weight - d2.weight;
Comparator<Duck> byWeight = (Duck d1, Duck d2) -> d1.weight - d2.weight;
Comparator<Duck> byWeight = (d1, d2) -> { return d1.weight - d2.weight; }
Comparator<Duck> byWeight = (Duck d1, Duck d2) -> { return d1.weight - d2.weight; }
```

* ⚠️ Comparator is also a functional interface, so we COULD write a lambda.. BUT classes implement the Comparator interface so this does not make sense! 

<br>
<hr>

## 🟦 3.5 Searching and Sorting

* The `Collections` interface has a `sort(someCollection)` method which sorts a collection using its 'natural' ordering.

* ⚠️ If a class does not implement the `Comparable` interface, then it can not be sorted by the above method without compiler error! ⚠️

* We can surpass this compilation error, by overloading the `sort()` method with a Comparator implementation: `sort(someCollection, someComparator)`

* E.g.:

```java
class SortRabbits {
    static class Rabbit{ int id; }
    public static void main(String[] args){
        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit());
        Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id
        Collections.sort(rabbits, c);
    }
}
```

* The `binarySearch()` method can also be overloaded, so that it searches for an item in a specified order.

```java
List<String> names = Arrays.asList("Fluffy", "Hoppy");
Comparator<String> c = Comparator.reverseOrder();
int index = Collections.binarySearch(names, "Hoppy", c);
System.out.println(index);
```

* The third line says apply the Comparator to `names`. This sorts the array as: `[Hoppy, Fluffy]`

* We are then doing a binary search, but the names are not sorted naturally!

* Hence the result is undefined!

* If we are using the `TreeSet` collection, we are saying a sorting is being done on the collection. IF a collection is not `Comparable` THEN it will throw a runtime exception when adding to the `TreeSet`

```java
public class UseTreeSet {
    static class Rabbit { int id; }
    public static void main(String[] args) {
        Set<Duck> ducks = new TreeSet<>();
        ducks.add(new Duck("Puddles")); // Duck implements Comparable
        Set<Rabbit> rabbits = new TreeSet<>();
        rabbit.add(new Rabbit()); // throws runtime exception
    }
}
```

* We can circumvent this runtime exception by adding a Comparator as an argument to the TreeSet:

```java
public class UseTreeSet {
	static class Rabbit { 
		int id;
		public Rabbit(int id) { this.id = id; }
		public String toString() {
			return "id: "+id;
		}
	}
	public static void main(String[] args) {
		Set<Rabbit> rabbit = new TreeSet<>();
		 // rabbit.add(new Rabbit()); // THROWS RUN TIME EXCEPTION
		Set<Rabbit> rabbitSorted = new TreeSet<>(new Comparator<Rabbit>() {
			@Override
			public int compare(Rabbit o1, Rabbit o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.id, o2.id);
			}			
		});
		rabbitSorted.add(new Rabbit(2));
		rabbitSorted.add(new Rabbit(3));
		rabbitSorted.add(new Rabbit(1));
		
		System.out.println(rabbitSorted); // [id: 1, id: 2, id: 3]
	}
}
```

<br>
<hr>

## 🟦 3.5 Additions in Java 8

* Method references and lambdas are core structures in Java 8

* We shall see how to use `removeIf()`, `forEach()`, `merge()`, `computeIfPresent()` and `computeIfAbsent()`

#### 🟡 Using Method References 🟡

* Method references shorten the code by simply mentioning a method without explicitly passing the parameters.

* E.g. suppose we have a `Duck` class with name and weight attributes. We also have a helper class:

```java
public class DuckHelper {
	public static int compareByWeight(Duck d1, Duck d2) {
		return d1.weight - d2.weight;
	}
	public static int compareByName(Duck d1, Duck d2) {
		return d1.name.compareTo(d2.name);
	}
}
class Duck {
    String name;
    int weight;
    public Duck(String name, int weight) {
        this.name=name;this.weight=weight;
    }
    public String toString() {
        return "name: "+name+ ", weight: "+weight;
    }
}
```

* We could write a `Comparator` if we wanted to sort by weight, we can write a lambda:

```java
Comparator<Duck> byWeight = (d1, d2) -> DuckHelper.compareByWeight(d1, d2);
```

* As we can see the parameters are consumed by `DuckHelper.compareByWeight()`

* 🙌🙌 **We can use a method reference instead!** 🙌🙌

```java
Comparator<Duck> byWeight = DuckHelper::compareByWeight;
```

<hr>

#### 🟡 Method Reference Type 🟡


* There are four formats for method references:

1) Static methods

2) Instance methods on a particular instance

3) Instance methods on an instance to be determined at runtime

4) Constructor

* Recapping on Chapter 2, `Predicate` is a functional interface which takes a parameter of any type and returns boolean. `Consumer` is a functional interface which takes a single parameter of any type and returns void. `Supplier` takes no paramaeters and returns any type.

* Here is a **static method**:

```java
Consumer<List<Integer>> lambda1 = l -> Collections.sort(l);
Consumer<List<Integer>> methodRef1 = Collections::sort;
```

* Java is inferring which overloaded version of `Collections.sort()` it should use from the context set by using `Consumer` which takes a single parameter. Hence it knows to use the single parameter version of sort!

* Here is a **instance method on a particular instance**:

```java
String str = "abc";
Predicate<String> lambda2 = s-> str.startsWith(s)
Predicate<String> methodRef2 = str::startsWith;
```

* Here is an **instance method on an instance determined at runtime**:

```java
Predicate<String> lambda3 = s -> s.isEmpty();
Predicate<String> methodRef3 = String::isEmpty;
```

* Here is a **constructor method**:

```java
Supplier<ArrayList> lambda4 = () -> new ArrayList();
Supplier<ArrayList> methodRef5 = ArrayList::new;
```

