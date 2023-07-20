<link href="../../styles.css" rel="stylesheet"></link>

# 📝 Chapter 3: Revision Notes

# 🧠 3.1 Reviewing OCA Collections

* The **Java Collections Framework** includes `List`, `Map`, `Set`, and `Queue`

## 🟥 Array and ArrayList

* We access elements of an `ArrayList` using `get(int index)`:

```java
List<String> list = Arrays.asList("Fluffy", "Webby");
String[] array = new String[list.size()];
for (int i=0;i<array.length;i++)
    array[i] = list.get(i);
```

* We can convert an Array to an ArrayList EASILY using `Arrays.asList(arr)`!

```java
String[] arr = {"chimp", "ape"};
List<String> list = Arrays.asList(arr);
```

* Converting an ArrayList to an Array is COMPLICATED as ArrayLists can vary in size!

```java
List<String> list = Arrays.asList("hello", "world");
String[] arr =  list.toArray(new String[0]);
System.out.println(Arrays.toString(arr)); // [hello, world]

// list is now backed
list.remove(0); // throws UnsupportedOperationException
```


## 🟥 Searching and Sorting

* We can retrieve the index of a SORTED array using `Arrays.binarySearch(arr, target)`:

```java
int[] nums = {6,9,1,8};
Arrays.sort(nums); // [1,6,8,9]
System.out.println(Arrays.binarySearch(nums, 6)); // 0
System.out.println(Arrays.binarySearch(nums, 3)); // -2
// 3 would be placed in index 1, -1-1=-2 
// 0 would be placed in index 0, 0-1=-1
```

* We can retrieve the index of a SORTED list using `Collections.binarySearch(list, target)`:

```java
List<Integer> list = Arrays.asList(9,7,5,3);
Collections.sort(list); // [3, 5, 7, 9]
System.out.println(Collections.binarySearch(list,3)); // 0
System.out.println(Collections.binarySearch(list,2)); // 0-1 = -1
```

## 🟥 Wrapper Classes and Autoboxing

* What does the following code do?

```java
List<Integer> numbers = new ArrayList<Integer>();
numbers.add(1);
numbers.add(new Integer(3));
numbers.add(new Integer(5));
numbers.remove(1); // [1, 5]
numbers.remove(new Integer(5)); // [1]
System.out.println(numbers); // [1]
```

# 🧠 3.2 Working With Generics

## 🟥 Generic Classes

* We can introduce a **formal type parameter** using diamond brackets to a class:

```java
public class Crate<T> {
    private T contents;
    public T emptyCrate() {
        return contents;
    }
    public void packCrate(T contents) {
        this.contents = contents;
    }
}
```

* we can introduce multiple generic parameters:

```java
public class SizeLimitedCrate<T,U> {
    private T contents;
    private U sizeLimit;
    public SizeLimitedCrate(T contents, U sizeLimit) {
        this.contents = contents;
        this.sizeLimit = sizeLimit;
    }
}
```

## 🟥 Generic Interfaces

* We can also have formal type parameters in interfaces:

```java
public interface Shippable<T> {
    void ship(T t);
}
class ShippableRobotCrate implements Shippable<Robot> {
    void ship(Robot t) { }
}
```

* We can also create a CONCRETE class which allows the caller to specify the generic type:

```java
public class Generics {
	public static void main(String[] args) {
		ShippableAbstractCrate s = new ShippableAbstractCrate();
		s.ship(new Robot());
	}
}
class ShippableAbstractCrate<U> implements Shippable<U> {
	public void ship(U u) {	}
}
```

## 🟥 What You Can't Do With Generic Types❌

* You CAN NOT call the constructor: `new T()`

* You CAN NOT create a static variable as a generic type parameter:

```java
public class Generics {
    static T variable; // COMPILER ERROR
}
```

* You CAN NOT use a primitive type in place of generic!

* You CAN NOT create an array using generic type:

```java
class WithGeneric<T> {
	void method(T t) {
		T[] arr = new T[2]; // CAN NOT CREATE A GENERIC ARRAY WITH T
	}
}
```

## 🟥 Generic Methods

* We can declare a generic at METHOD LEVEL.

* This is useful for static methods but can be applied to non-static methods also:

```java
public class GenericMethods {
	static <T> void method1(T t) {
		System.out.println(t);
	}
    static <T> T method2() { return t; }
	public static void main(String[] args) {
		method1(new String("hello world")); // hello world
	}
}
```

## 🟥 Bounds

* A ***bounded parameter type*** is a generic type which specifies the bound for the generic!🎃

* A ***wildcard generic type*** is an UNKNOWN generic represented with **?**

### 🟡 Unbounded Wildcards

* We use an unbounded wildcard represents ANY datatype.

* E.g. suppose we want to print a `List` containing any data type:

```java
public class Wildcards {
static void printList(List<Object> list) {
    for (Object x: list)
        System.out.println(x);
}
static <T> void printListWithGenerics(List<T> list) {
    for (Object x:list)
        System.out.println(x);
}
static void printListWithWildCard(List<?> list) {
    for (Object x:list)
        System.out.println(x);
}

public static void main(String[] args) {
    List<String> list = Arrays.asList("hello");
    // printList(list); // COMPILER ERROR
    printListWithGenerics(list); // hello
    printListWithWildCard(list); // hello
}
}
```

### 🟡 Upper-Bounded Wildcards

* We can use upper-bounded wildcards to make more flexible methods:

```java
public class UpperBoundedWildcards {
public static long total(List<Number> list) {
	long count = 0;
	for (Number number: list)
		count += number.longValue();
	return count;
}
public static long totalUpperBounded(List<? extends Number> list) {
	long count = 0;
	for (Number number: list)
		count += number.longValue();
	return count;
}
public static void main(String[] args) {
	List<Integer> intList = Arrays.asList(1,2,3);
	List<Number> numList = Arrays.asList(1,2,3);
	// total(intList); // COMPILER ERROR
	totalUpperBounded(intList); // WORKS FINE!
	total(numList); // WORKS FINE!
	totalUpperBounded(numList); // WORKS FINE!
}
}
```

### 🟡 Lower-Bounded Wildcards

```java
public class LowerBoundedWildcards {
static void addSound(List<? extends Object> list) {
    // list.add("hello"); // COMPILER ERROR
}
static void adddSoundUpperBounded(List<? super String> list) {
    list.add("hello");
}
public static void main(String[] args) {
    List<String> stringList = Arrays.asList("hello", "world");
    List<Object> objectList = Arrays.asList("hello",2,null);
    // adddSound(stringList); // COMPILER ERROR
    addSound(objectList);     // WORKS FINE!
    adddSoundUpperBounded(stringList); // WORKS FINE!
    adddSoundUpperBounded(objectList); // WORKS FINE!
}
}
```

## 🟥 Putting It All Together

```java
class A {}
class B extends A {}
class C extends B {}
6:  List<?> list1 = new ArrayList<A>();
7:  List<? extends A> list2 = new ArrayList<A>();
8:  List<? super A> list3 = new ArrayList<A>();
9:  List<? extends B> list4 = new ArrayList<A>(); // DOES NOT COMPILE
10: List<? super B> list5 = new ArrayList<A>();
11: List<?> list6 = new ArrayList<? extends A>(); // DOES NOT COMPILE
```

* Line 6 is fine, as we are using unbounded generic
* Line 7 is fine
* Line 8 is fine
* Line 9, class A does NOT extend B!
* Line 10 is dine
* Line 11: the RHS can not use a wildcard!!!


# 🧠 3.3 Using Lists, Sets, Maps and Queues

* The ***Java Collections Framework*** is a set of classes from `java.util` consisting of four interfaces:
1) `List`: a collection of ordered elements which can be accessed via its index
2) `Set`: an unordered collection which prevents duplicates!
3) `Queue`: a collection which orders its elements in a specific order for processing
4) `Map`: a collection of key-value pairs. This is the only interface which does not extend `java.util.Collection`

## 🟥 Common Collections Methods

* Here are some common methods for Lists, Sets and Queues:
1) `boolean add(E element)`
2) `boolean remove(Object object)`
3) `boolean isEmpty()`
4) `int size()`
5) `void clear()`
6) `boolean contains(Object object)`

## 🟥 Comparing List Implementations

* ArrayList lets you retrieve elements in CONSTANT TIME and remove/add elements in LINEAR TIME

* LinkedList lets you retrieve elements in LINEAR TIME and remove/add elements in CONSTANT TIME

* Stack is linear data structure which lets you add/remove elements from the TOP:

```java
Stack<String> stack = new Stack<>();
stack.add("hello");
stack.add("world");
System.out.println(stack.pop());
System.out.println(stack); // [hello]
```

## 🟥 Comparing Set Implementations

* HashSet allows for adding/removing and checking if element is present in constant time. We however lose insertion order!
* TreeSet preserves sorting but adding and checking if element is present is in `O(log n)`. TreeSet implements the `NavigableSet` interface


### 🟡 NavigableSet Interface

* This interface provides the following methods:

1) `E lower(E e)` - returns greatest element which is `< e`
2) `E higher(E e)` - returns lowest element which is `> e`
3) `E ceiling(E e)` - returns lowest element which is `>= e`
4) `E floor(E e)` - returns greatest element which is `>= e`

* Example:

```java
NavigableSet<Integer> set = new TreeSet<>;
for (int i=1;i<=2-;i++) set.add(i);
System.out.println(set.lower(10)); // 9
System.out.println(set.floor(10)); // 10
System.out.println(set.higher(20)); // null
System.out.println(set.ceiling(20)); // 20
```


## 🟥 Comparing Queue Implementations

* Queues are used for sorting elements prior to processing them. Queues are assumed to be FIFO

* LinkedList is double-ended Queue

* ArrayDeque is a pure double-ended Queue

### 🟡 Queue Methods

* The methods available to the Queue implementations are:

1) `boolean add(E e)` - adds element to back of queue
2) `E element()` - returns element at front
3) `boolean offer(E e)` - adds element to back of queue and returns if successful (never throws errors)
4) `void push(E e)` - adds element to front of queue
5) `E poll(E e)` - removes and returns next element (or returns null if empty)
6) `E pop()` - removes and returns front of queue (or throws exception if empty)
7) `E peek()` - returns front element (or null if empty)

```java
Deque<Integer> deque = new ArrayDeque<>();
//System.out.println(deque.element()); // THROWS EXCEPTION
System.out.println(deque.peek()); // null
deque.add(1); deque.add(2); deque.add(3);
System.out.println(deque.peek()); // 1
System.out.println(deque.element()); // 1
System.out.println(deque); // [1, 2, 3]
System.out.println(deque.offer(4)); // true
System.out.println(deque); // [1,2,3,4]
System.out.println(deque.pop()); // 1
System.out.println(deque); // [2, 3, 4]
System.out.println(deque.poll()); // 2
System.out.println(deque); // [3,4]
deque.push(999);
System.out.println(deque); // [999,3,4]
```

## 🟥 Comparing Map Implementations

* `HashMap` is a map implementation which has CONSTANT TIME for retrieving and adding elements. **Insertion order is NOT preserved**! DOES allow null key

* `LinkedHashMap` has the same time complexity as HashMap but insertion order is preserved! DOES allow null key

* `TreeMap` has has LOGARITHMIC TIME for retrieving and adding elements. Maintains sorted order. Does NOT allow null key

```java
Map<Integer, Integer> hashMap = new HashMap<>();
hashMap.put(1, 101);
hashMap.put(22, 102);
hashMap.put(3, 103);
System.out.println(hashMap); // {1=101, 3=103, 22=102} insertion order NOT preserved
Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
linkedHashMap.put(1, 101);
linkedHashMap.put(22, 102);
linkedHashMap.put(3, 103);
System.out.println(linkedHashMap); // {1=101, 22=102, 3=103} insertion order IS preserved

Map<String, Integer> treeMap = new TreeMap<>();
treeMap.put("one", 1);
treeMap.put("two", 2);
treeMap.put("three", 3);
treeMap.put("four", 4);
// treeMap.put(null, 0); // CAN NOT USE NULL
System.out.println(treeMap); // {four=4, one=1, three=3, two=2}
```