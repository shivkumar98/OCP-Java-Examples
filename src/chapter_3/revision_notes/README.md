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