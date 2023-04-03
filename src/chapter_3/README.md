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

## Reviewing OCA Collections

* The Java Collections Framework is a set of interfaces. These interfaces are `List`, `Queue`, `Map` and `Set`

### Arrays and ArrayList 

* An `ArrayList` is an object which contains other objects. It does not contain primitives - we can store wrapper variants instead. We get the size of an array using the `size()` method.

```java
String[] array = {"gerbil", "mouse"};
List<String> list = Arrays.asList(array);
list.set(1, "test"); // [gerbil, test]
array[0] = "new"; // [new, test] // both strucs are backed by same data
String[] array2 = (String[]) list.toArray(); // converted list back to array!
list.remove(0); // throws UnsupportedOperationException because list is not resizeable!!!
```