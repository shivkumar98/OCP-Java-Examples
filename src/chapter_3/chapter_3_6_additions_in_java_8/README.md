<link href="../../styles.css" rel="stylesheet"></link>

# 🟪 3.6 Additions in Java 8

## 🟦 Table of Contents

[Introduction](#introduction)

[1 Using Method References](#1-using-method-references)
- [Example: Using Method References to Sort](#example-using-method-references-to-sort)
- [Static Methods:](#static-methods)
- [Instance methods on a particular instance:](#instance-methods-on-a-particular-instance)
- [Instance Method without knowling at runtime:](#instance-method-without-knowling-at-runtime)
- [Constructors:](#constructors)

[2 Removing Conditionally](#2-removing-conditionally)
  - [removeIf](#removeif)
  - [Updating All Elements: replaceAll](#updating-all-elements-replaceall)
  - [Looping through a Collection: forEach](#looping-through-a-collection-foreach)
  - [Using New Java 8 Map APIs](#using-new-java-8-map-apis)
  - [merge](#merge)

<br><hr>

## 🟦 Introduction

Everything seen previously was not unique to Java 8. This section will focus on **streams**.

We will see how to use the following methods:

🎃 removeIf()

🎃 forEach()

🎃 merge()

🎃 computeIfPresent()

🎃 computeIfAbsent()

<br><hr>

## 🟦 1 Using Method References

We can make code more compact using method references - simply mentioning the method name.

<h3 class="example"> 🟠 Example: Using Method References to Sort 🟠 </h3>

Suppose we have a Duck class with name, weight attributes.

Here is a helper class:

```java
    public class DuckHelper {
        public static int compareByWeightr(Duck d1, Duck s2){
            return d1.getWeight()-d2.getWeight();
        }
        public static int compareByName(Duck d1, Duck d2){
            return d1.getName().compareToo(d2.getName());
        }
    }
```

We could write a Comparator for sorting by weight:

```java
    Comparator<Duck> byWeight = (d1,d2) -> DuckHelper.compareByWeight(d1,d2);
```

This is alot of redundant code!

**Java 8 has method references:**

```java
    Compator<Duck> byWeight = DuckHelper::compareByWeight;
``` 

The ```::``` operator instructs Java to pass the parameters to compareByWeight automatically. 

😱 There are 4 formats for method references: 😱

* ✅ Static methods
* ✅ Instance methods on a particular instance
* ✅ Instance methods on an instance to be determined at runtime
* ✅ Constructors

⚠️ Predicate takes one input and returns one output. ⚠️

⚠️ Consumer takes one input and has void return. ⚠️

⚠️ Supplier has no parameters and returns any type. ⚠️

### 🟥 Static Methods:

```java
    Consumer<List<Integer>> methodRef1 = Collections::sort;
    Consumer<List<Integer>> lambda1 = l -> Collections.sort(l)
```

Top line infers which sort method to call based on context! We are using the Consumer so it looks for the implementation which only accepts one argument

### 🟥 Instance methods on a particular instance:

```java
    String str = "abc";
    Predicate<String> methodRef2 = String::startsWith;
    Predicate<String> lambda2 = s -> str.startsWith(s);
```

The top line calls the String.startsWith() method with a single parameter.

### 🟥 Instance Method without knowling at runtime:

```java
    Predicate<String> methodRef3 = String::startsWith;
    Predicate<String> lambda3 = s -> s.isEmpty();
```

### 🟥 Constructors:

```java
    Supplier<ArrayList> method4 = ArrayList::new;
    Supplier<ArrayList> lambda4 = () -> new ArraayList();
```

<br><hr>

## 🟦 2 Removing Conditionally

### 🟥 removeIf

Java 8 introduces **removeIf**, method signature looks like:

```java
    boolean removeIf(Predicate<? super E> filter)
```

#### 🟠 Example 🟠

```java
    List<String> list = new ArrayList<>();
	list.add("Magician");
	list.add("Assistant");
	// list.removeIf(String::startsWith("M")); // this does not compile
	list.removeIf(s->s.startsWith("M"));
	System.out.println(list); // [Assistant]
```

The predicate version does not work as we are passing strings to the predicate.

## 🟦 3 Updating All Elements: replaceAll

**replaceAll()** is a new method in List which allows a lambda expression to be applied to all elements

The method signature is:

```java
    void replaceAll(UnaryOperator<E> o)
```

### 🟠 Example 🟠

```java
    List<Integers list = Arrays.asList(1,2,3);
    list.replaceAll(x->x*2);
    System.out.println(list); [2,4,6]
```

## 🟦 4 Looping through a Collection: forEach

Java 8 introduces the forEach() method to loop through a collection.

### 🟠 Example 🟠

```java
    List<String> cat = Array.asList("Annie", "Ripley");
    cats.forEach(c-> Sytstem.out.println(c));
    cats.forEach(System.out::println);
```

The last two lines are equivalent.

## 🟦 4 Using New Java 8 Map APIs

The Map interface has the following methods:

* merge()
* computeIfAbsent()
* computeIfPresent()

Suppose we wanted to update the value for a key in a map:

```java
    Map<String, String> favorites = new HashMap<>();
    favorites.put("Jenny", "Bus Tour");
    
    // suppose we want to update the value for Jenny
    // one way is to reinsert a key-value pair:
    favorites.put("Jenny", "Tram");
    System.out.println(favorites); // {Jenny=Tram}
```

The ```putIfAbsent()``` adds/updates a value if the value is null or absent:

```java
    // the putIfAbsent method lets you set a value if it is null or absent
    favorites.put("Tom", null);
    favorites.putIfAbsent("Jenny", "Train");
    System.out.println(favorites); // {Tom=null, Jenny=Tram}
    favorites.putIfAbsent("Tom", "Tram");
    System.out.println(favorites); // {Tom=Tram, Jenny=Tram}
```

### 🟢 merge()

The merge function of the Map API, lets you update a value of a key based off some logic!

The merge function has the following signature:

```java
    V merge(K key, V value, Bifunction mappingFunction)
```

#### 🟠 Example 🟠

Suppose that the guests agree to let the person with longest name decide the mode of transport

We can write this by passing a mapping function to the merge function

```java
    BiFunction<String, String, String> mapper = (v1,v2)
        -> v1.length() > v2.length() ? v1 : v2;

    Map<String, String> favourites = new HashMap<>();
    favourites.put("Jenny", "Bus tour");

    // we shall merge in a pair ("Jenny", "Skyride")
    // our mapper will update the value with the largest length
    favorites.merge("Jenny", "Skyride", mapper);
    System.out.println(favorites); // {Jenny=Bus Tour}

    // since Skyride has a shorter length it was not updated
    // let's try with a longer word!
    favorites.merge("Jenny", "Submarine ride", mapper);
System.out.println(favorites); // {Jenny=Submarine ride}
```          



* 🎃 Suppose that the biFunction maps to a null value! 🎃
* ⚠️ Using this as the mapper will remove the key-pair value! ⚠️

#### 🟠 Example 2 🟠

```java
    // what if the bifunction returns null?
    favorites.merge("Jenny", "Helicopter", (v1,v2) -> null);
    System.out.println(favorites); // {Tom=Tram}
```

* 🎃 We can still call the ```merge()``` method without issues evem if the key is not present! In this case it behaves like a `put()` method and the mapper is not called! 🎃

### 🟢 computeIfPresent and computeIfAbsent

* `computeIfPresent()` calls the BiFunction if the key is present!

```java
    Map<String, Integer> counts = new HashMap<>();
    counts.put("Jenny", 1);
    BiFunction<String, Integer, Integer> mapper = (k, v) -> v + 1;

    // If the key is present, the value is updated according to mapper
    System.out.println(counts.computeIfPresent("Jenny", mapper)); // 2
    System.out.println(counts.computeIfPresent("Sammy", mapper)); // null
    System.out.println(counts); // {Jenny=2}
```

* If the BiFunction maps to null, then the key is removed from the map!


* `computeIfAbsent` calls a Function if the key is absent

```java
    Map<String, Integer> counts2 = new HashMap<>();
    Function<String,Integer> mapper2 = (k) -> 1;
    counts2.put("Jenny", 15);
    counts2.put("Tom", null);

    // if the key is absent, then its value 
    counts2.computeIfAbsent("Jenny", mapper2);
    counts2.computeIfAbsent("Sam", mapper2);
    System.out.println(counts2); // {Tom=null, Jenny=15, Sam=1}
```