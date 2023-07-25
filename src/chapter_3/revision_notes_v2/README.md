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
