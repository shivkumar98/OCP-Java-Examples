<link href="../../styles.css" rel="stylesheet"></link>

# 3.1 Reviewing OCA Collections

- The **Java Collections Framework** consists of classes which implement List, Map, Queue and Set

- In OCA we saw the ArrayList class which implements List

- We also saw Arrays but these are *not* part of the Collections Framework

## Array and ArrayList:

ArrayList is an object which can contain other objects. It cannot contain primitives, in order to store primitives you must use the wrapper classes.

### Example 1:

```java
List<String> list = new ArrayList<>();  // initialises empty list
list.add("Foo");                        // list=["Foo"]
list.add("Bar");                        // list=["Foo","Bar"]
System.out.println(list.get(0))         // prints "Foo"
```

we can convert between arrays and ArrayLists


### Example 2: Converting Array to ArrayList

```java
String[] arr = {"rat", "mouse"};
List<string> list = Arrays.asList(array);   // list=["rat", "mouse"]
```