# 3.2 Using Lists, Sets, Maps and Queues

A collection is a group of objects stored in a single object.
The **Java Collections Framework** is a group of classes in java.util for storing collections
This framework consists of 4 main interfaces:

1. **List**: An ordered collection which allows duplicates and can be accessed via index

2. **Set**: An unordered collection which does not allow duplicates

3. **Queue**: A collection with a specific ordering for processing, e.g. first-in first-out.

4. **Map**: a collection which maps keys to values where duplicate key is not allowed

The below diagram displays the hierarchy of the framework:

![](2023-01-03-10-40-46.png)

The map interfacee does not implement the Collection interface. It is part of the Collections framework even though its not actually a Collection

<br><hr>

# 1 Common Collection Methods

The Collection interface has many useful methods when working with lists, sets and queues.

## **add()**

The add method inserts a new element, and returns whether its successful:

    boolean add(E element)

For some type, the add() method always returns true but now with generics:

    3:  List<String> list = new ArrayList<>();
    4:  System.out.println(list.add("Sparrow")); // TRUE
    5:  System.out.println(list.add("Sparrow")); // TRUE
    6:
    7:  Set<String> set = new HashSet<>();
    8:  System.out.println(set.add("Sparrow")); // TRUE
    9:  System.out.println(set.add("Sparrow")); // FALSE

A set cannot contain duplicates!

<br>

## **remove()**

The remove() method removes a **single matching value** in the Collection and returns whether its successful:

    boolean remove(Object object)

Here is an example:

    3:  List<String> birds = new ArrayList<>();
    4:  birds.add("hawk"); // [hawk]
    5:  birds.add("hawk"); // [hawk, hawk]
    6:  System.out.println(birds.remove("cardinal")); // FALSE
    7:  System.out.println(birds.remove("hawk"));  // TRUE
    8:  System.out.println(birds); // [hawk]

<br>

## **isEmpty() and size()**

The isEmpty() and size() methods look into how many elements are in Collection:

    boolean isEmpty()
    int size()

Here is an example:

    System.out.println(birds.isEmpty()); // true
    System.out.println(bird.size());     // 0
    bird.add("hawk");                    // [hawk]
    bird.add("hawk");                    // [hawk, hawk]
    System.out.println(bird.isEmpty());  // false
    System.out.println(bird.size());     // 2

<br>

## **clear()**

This method discards all elements in collection:

    void clear()

E.g.:

    birds.add("hawk");  // [hawk]
    birds.add("hawk");  // [hawk, hawk]
    birds.clear();      // []

<br>

## **contains()**

This method checks if a Collection has a certain value:
    
    boolean contains(Object object)

E.g.:

    System.out.println(birds) // [hawk]
    System.out.println(bird.contains("hawk")); // TRUE
    System.out.println(bird.contains("robin")); // FALSE

<br><hr>

# 2 Using the List Interface

**A list is an ordered collection which allows duplicates**. Items can be accessed and inserted via an index

<br>

## **Comparing List Implementations**

ArrayList automatically resizes when there is no more space. **Elements can be looked up in constant time**. Adding or removing elements is slower

<br>

### **Big O Notation**

Big O notation is used to talk about performance of algorithms. The letter n is used to represent number of items.

1. O(1) - constant time: regardless of size, the time is the same

2. O(log n) - logarithmic time: better than linear time

3. O(n) - linear time: performance grows linear with time

4. O(n<sup>2</sup>) - quadratic time: code where each loop goes through the data is n squared time.

<br>

### **LinkedList**

A LinkedList implements both List and Queue. It has an additional method to facilitate adding/removing items at beginning/ending in constant time! An older implementation was Vector which was replaced by ArrayList!

<br>

### **Stack**

A stack is useful when you want to add/remove elements from top of the stack

<br>

## **Working with List Methods**

Below are methods part of List interface:

| Method                          | Description                                        |
|---------------------------------|----------------------------------------------------|
| void add(E element)             | Adds element to end                                |
| void add(int index, E elements) | Adds at index, moving rest towards end             |
| E get(int index)                | Returns element at index                           |
| int indexOf(Object o)           | Returns first matching index, otherwise -1         |
| int lastIndex(Object o)         | Returns last matching index, otherwise -1          |
| void remove(int index)          | Removes element at index and moves rest forwards   |
| void remove(Element e)          | Removes specified element                          |
| E set(int index, E e)           | Replaces element at index with e. Returns original |

<br>

Here is an example

    list<String> list = new ArrayList<>();
    list.add("SD"); // [SD]
    list.add(0, "NY"); // [NY, SD]
    list.set(1,"FL"); // [NY, FL]
    list.remove("NY"); // [FL]
    list.remove(0); // []

<br>

## **Loopng Through a List**

We can loop through a list using an enhanced loop:

    for (String string: list) {
        System.out.println(string);
    }

We can also use an iterator:

    Iterator<String> iter = list.iterator();
    while (iter.hasNext()) {
        String string = iter.next();
        System.out.println(string);
    }

<br><hr>

# 3 Using the Set Interface

Sets should be used when you don't want duplicates! There are different implementations of the Set interface: HashSet and TreeSet

<br>

## **HashSet Implementation**
HashSet stores elements in a hashtable, meaning elements are hashed and objects are retrieved using hashCode() method - which is efficient!

The **benefit** is adding elements and checking existence occurs at constant time! But you lose ordering of elements!

<br>

## **TreeSet Implementation**

The TreeSet is a *sorted* tree structure. While ordered, checkig and adding elements is slower at O(log n) time!


See the below which compares HashSet and TreeSet:

![](2023-01-03-13-36-56.png)

<br>

## **Working with Set Methods**

The Set interface doesn't not have any unique methods from Collection methods!

HashSet Example:

    3:      Set<Integer> set = new HashSet<>();
    4:      boolean b1 = set.add(66);   // TRUE
    5:      boolean b2 = set.add(10);   // TRUE
    6:      boolean b3 = set.add(66);   // FALSE
    7:      boolean b4 = set.add(8);    // TRUE
    8:      for (Integer integer: set) System.out.println(integer+", ");    // 66,8,10

Tree Example:

    3:      Set<Integer> set = new TreeSet<>();
    4:      boolean b1 = set.add(66);   // TRUE
    5:      boolean b2 = set.add(10);   // TRUE
    6:      boolean b3 = set.add(66);   // FALSE
    7:      boolean b4 = set.add(8);    // TRUE
    8:      for (Integer integer: set) System.out.println(integer+",");    // 8,10,66 

<br>

## **The NavigableSet Interface**

The TreetSet implements the **NavigableSet interface**. This interface has the following methods:

| Method         | Description                            |
|----------------|----------------------------------------|
| E lower(E e)   | Returns greatest element < e, or null  |
| E floor(E e)   | Returns greatest element <= e, or null |
| E ceiling(E e) | Returns smallest element > e, or null  |
| E higher(E e)  | Returns smallest element >= e, or null |

Example

    NavigableSet<Integer> set = new TreeSet<>();
    for (int i=1; i<=20; i++) set.add(i);
    System.outl.println(set.lower(10));     // 9
    System.outl.println(set.ceiling(10));   // 10
    System.outl.println(set.higher(20));    // 21
    System.outl.println(set.ceiling(20));   // null


<br><hr>

# 4: Using the Queue Interface

The Queue is used when you want to add/remove elements in a certain order. Queues are assumed FIFO (first in, first out):

![](2023-01-03-14-06-20.png)

<br>

## **Comaring Queue Implementations**

The *LinkedList* is a **double-ended queue** - elements can be added to front or back of the queue.

- LinkedList is both a List and a Queue but lacks the efficiency of a pure queue.

*ArrayDeque* is a "pure" double ended queue which is more efficient than LinkedList.


<br>

## **Working with Queue Methods**


ArrayDeque inherits from Collections and has 7 additional methods:

| Method             | Description                                                         | For Queue | For Stack |
|--------------------|---------------------------------------------------------------------|-----------|-----------|
| boolean add(E e)   | Adds element at back of queue and returns true, or throws exception | Yes       | No        |
| E element()        | Returns next element, or if empty throws exception                  | Yes       | No        |
| boolean offer(E e) | Adds an element to back of queue and returns whether succesful      | Yes       | No        |
| E remove()         | Removes and returns next element or, if empty throws exception      | Yes       | No        |
| void push(E e)     | Adds element to front of queue                                      | Yes       | Yes       |
| E poll()           | Removes and returns next element or, if empty returns null          | Yes       | No        |
| E peek()           | Returns next element of returns null if empty returns null          | Yes       | Yes       |
| E pop()            | Removes and returns next element, or if empty throws exception      | No        | Yes       |

<br>

**Example:**

    Queue<Integer> queue = new ArrayDequeue<>();
    System.out.println(queue.offer(10));    // true
    System.out.println(queue.offer(4));     // true
    System.out.println(queue.peek());       // 10
    System.out.println(queue.poll());       // 10
    System.out.println(queue.poll());       // 4
    System.out.println(queue.peek());       // null


![](2023-01-03-14-36-11.png)

We can insert elements at the *FRONT* of the queue using the push method!

**Example:**

    ArrayDeque<Integer> stack = new ArrayDeque<>();
    stack.push(10);
    stack.push(4);
    System.out.println