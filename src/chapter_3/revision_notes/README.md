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