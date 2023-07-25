<link href="../../styles.css" rel="stylesheet"></link>

# 📝 Chapter 3: Revision Notes V2

# 🧠 3.1 Reviewing OCA Collections

## 🟥 Array and ArrayList

* Converting an Array to an ArrayKist is simple, as arrays are fixed in size!

```java
String[] arr = {"hello", "world", "!"};
List<String> list  = Arrays.asList(arr);

List<String> list2 = new ArrayList<>();
list2.add("hello");
list2.add("world");
String[] arr2 = (String[]) list2.toArray(new String[0]);
```