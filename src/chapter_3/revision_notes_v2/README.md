<link href="../../styles.css" rel="stylesheet"></link>

# 📝 Chapter 3: Revision Notes V2

# 🧠 3.1 Reviewing OCA Collections

## 🟥 Array and ArrayList

* Converting an Array to an ArrayList is simple, as arrays are fixed in size!

```java
String[] arr = {"hello", "world", "!"};
List<String> list  = Arrays.asList(arr);

List<String> list2 = new ArrayList<>();
list2.add("hello");
list2.add("world");
String[] arr2 = (String[]) list2.toArray(new String[0]);
```

<hr>

# 🧠 3.2 Working With Generics

##  🟥 Generic Classes

* We can introduce a FORMAL TYPE PARAMETER to a class by including the diamond brackets infront of the class name!

```java
class Crate<T> {
	private T contents;
	public T emptyCrate() {
		return contents;
	}
	void packCrate(T contents) {
		this.contents = contents;
	}
}
```

##  🟥 Generic Interfaces 

* We can also add formal type parameters to interfaces, this will make the implementing class required to specify the parameter!

##  🟥 Generic Methods

* We can define generic methods within a class which return the generic type, or a type using the generic type.

* We MUST declare the generic type in angled brackets BEFORE the return type. If its a static method, this also applies!

```java
public class GenericMethods {
	static <T> List<T> returnArrayList(T t) {
		List<T> arr = new ArrayList<>();
		arr.add(t);
		return arr;
	}
	public static void main(String[] args) {
		List<String> list = GenericMethods.returnArrayList("hello world");
		System.out.println(list); // [hello world]
		// we can explicitly type the parameter:
		List<String> list2 = GenericMethods.<String>returnArrayList("I'm a string");
		System.out.println(list2); // [I'm a string]
	}
}
```

##  🟥 Bounds

* We specify an unbounded wildcard using `?`. E.g. suppose we create a method which initialise an array of ANY type:

```java
class Bounds {
	static void printList(List<?> list) {
		System.out.println(list);
	}
	public static void main() {
		Bounds.printList(new ArrayList<Exception>()); // []
		Bounds.<String>printList(Arrays.asList("hello")); // [hello]
	}
}
```

* Specifying the generic type before the method call is an optional syntax!

* We can create an upper bound using `? extends SomeClass`. E.g. suppose I always want to print an exception from a list:

```java
public class UpperBound {
	static void printException(List<? extends Exception> list) {
		System.out.println(list.get(0).getMessage());
	}
	public static void main() {
		UpperBound.printException(Arrays.asList(new Exception("exception")));
		// ^ exception is printed
		UpperBound.printException(Arrays.asList(new Throwable("throwable")));
		// ^ throwable is printed
	}
}
```

* We can create lower bound using `? super SomeClass`. E.g. suppose I want to print a List of numbers but not any of its subtypes like integer, float etc:

```java
public class LowerBounds {
	static void printNumbers(List<? extends Number> list) {
		System.out.println(list);
	}
	public static void main() {
		List<Number> numberList = Arrays.asList(1);
		printNumbers(numberList); // [1]
		List<Integer> intList = null;
		 // printNumbers(intList ); // COMPILER ERROR
		List<Boolean> boolList = null;
		// printNumbers(boolList); // COMPILER ERROR
	}
}
```

<hr>

# 🧠 3.3 Using Lists, Sets, Maps and Queues

* The Java Collections framework consists of `List`, `Set`, `Queue` and `Map`. All of these interfaces extends `java.util.Collections` except for the Map interface


##  🟥 List Implementations

* `ArrayList` lets you retrieve elements in O(1) but adding elements is in O(N)
* `LinkedList` lets you retrieve elements in O(N) but allow you to add or remove element at front/back of list in O(1)
* `Stack` lets you retrieve elements in O(N) but add and remove elements from the back in O(1) time

```java
LinkedList<Integer> linkedList = new LinkedList<>();
linkedList.push(1); // O(1)
linkedList.push(2); // [2, 1]
linkedList.get(1); // 1 // LINEAR TIME
linkedList.pop(); // [2] // LINEAR TIME

ArrayList<Integer> arrayList = new ArrayList<>();
arrayList.add(1); // LINEAR TIME
arrayList.get(0); // CONSTANT TIME

Stack<Integer> stack = new Stack<>();
stack.push(1); // [1] // LINEAR TIME
stack.push(2); // [1, 2]
stack.pop(); // [1] // LINEAR TIME
```      


##  🟥 Set Implementations

* `HashSet` lets you add elements and check if present in `O(1)`! It does not preserve insertion order

* `TreeSet` leet you add elements and check if present in `O(log n)`! Maintains ordering specified by the Comparable implementation! It is an implementation of `NavigableSet` interface

```java
public class SetImplementations {
	public static void main(String[] args) {
		Person p1 = new Person("shiv", 128);
		Person p2 = new Person("sam", 80);
		TreeSet<Person> treeSet = new TreeSet<>();
		treeSet.add(p1); treeSet.add(p2); // O(log n)
		System.out.println(treeSet); // [[fullName=sam, weight=80.0], [fullName=shiv, weight=128.0]]
		
		HashSet<Person> hashSet = new HashSet<>();
		hashSet.add(p1); hashSet.add(p2); // O(1)
		System.out.println(hashSet); // [[fullName=shiv, weight=128.0], [fullName=sam, weight=80.0]]
	}
}

class Person implements Comparable<Person> {
	String fullName; double weight;
	// constructor and toString()..
	public int compareTo(Person p) {
		return Double.compare(weight, p.weight);
	}
}
```

### 🟡 NavigableSet Interface

* `TreeSet` is an implementation of the `NavigableSet` interface and hass access to the following methods:

1) `E lower(E e)` - returns highest element which is `< e` or null
2) `E higher(E e)` - returns lowest element which is `> e` or null
3) `E ceiling(E e)` - returns lowest element which is `<= e` or null
4) `E floor(E e)` - returns highest element which is `>= e` or null

```java
NavigableSet<Integer> set = new TreeSet<>();
for (int i=1;i<21;i++) set.add(i);
int lower = set.lower(3); // 2
int higher = set.higher(2); // 3
int floor = set.floor(4); // 4
int ceiling = set.ceiling(6); // 6
System.out.println(set.floor(0)); // null
```


##  🟥 Queue Implementations

* `LinkedList` is a double ended queue - it allows you to add and remove elements from front/end in constant time.
* `ArrayDeque` is a pure double ended queue

### 🟡 Queue Methods:

1) `E element()` - returns head element, throws exception if empty
2) `E peek()` - returns head element, or null if empty
3) `E remove()` - removes head element, throws exception if empty
4) `E poll()` - removes and returns head element or returns null if empty
5) `void push(E e)` - adds an element to front of queue.
6) `boolean offer(E e)` - adds element to the back of the queue and returns if successful

```java
ArrayDeque<Integer> queue = new ArrayDeque();
// offer() adds element to BACK of queue
queue.offer(1); // [1]
queue.offer(2); // [1,2]
// push() pushes to FRONT of queue
queue.push(68); // [68,1,2]
// remove() retrieves and deletes the front of a queue
int removed = queue.remove(); // 68
queue; // [1,2]
// element() retrieves the front of queue
int nextInQueue = queue.element(); // 1
// poll() also retrieves front of queue but will return null if empty
int pollOfQueue = queue.poll(); // 1
// pop does the same thing as remove()
```

##  🟥 Map Implementations

* `HashMap` uses a hash table and allows for retrieval and adding in O(1)
* `LinkedHashMap` preserves insertion order but is slightly slower
* `TreeMap` allows keys to be sorted - adding and retrieval is in O(log n)