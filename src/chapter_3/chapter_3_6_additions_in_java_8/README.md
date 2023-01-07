# 3.6 Additions in Java 8

## Table of Contents

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

# Introduction

Everything seen previously was not unique to Java 8. This section will focus on **streams**.

We will see how to use the following methods:

* removeIf()
* forEach()
* merge()
* computeIfPresent()
* computeIfAbsent()

<br><hr>

# 1 Using Method References

We can make code more compact using method references - simply mentioning the method name.

## Example: Using Method References to Sort

Suppose we have a Duck class with name, weight attributes.

Here is a helper class:

    public class DuckHelper {
        public static int compareByWeightr(Duck d1, Duck s2){
            return d1.getWeight()-d2.getWeight();
        }
        public static int compareByName(Duck d1, Duck d2){
            return d1.getName().compareToo(d2.getName());
        }
    }

We coiuld write a Comparator for sorting by weight:

    Comparator<Duck> byWeight = (d1,d2) -> DuckHelper.compareByWeight(d1,d2);

This is alot of redundant code!

**Java 8 has method references:**

    Compator<Duck> byWeight = DuckHelper::compareByWeight;

The : : operator instructs Java to pass the parameters tgo compareByWeight automatically. 

There are 4 formats for method references:

* Static methods
* Instance methods on a particular instance
* Instance methods on an instance to be determined at runtime
* Constructors

**Predicate takes one input and returns one output.**

**Consumer takes one input and has void return.**

**Supplier has no parameters and returns any type.**

## Static Methods:

    Consumer<List<Integer>> methodRef1 = Collections:: sort;
    Consumer<List<Integer>> lambda1 = l -> Collections.sort(l)

Top line infers which sort method to call based on context! We are using the Consumer so it looks for the implementation which only accepts one argument

## Instance methods on a particular instance:

    String str = "abc";
    Predicate<String> methodRef2 = String::startsWith;
    Predicate<String> lambda2 = s -> str.startsWith(s);

The top line calls the String.startsWith() method with a single parameter.

## Instance Method without knowling at runtime:

    Predicate<String> methodRef3 = String::startsWith;
    Predicate<String> lambda3 = s -> s.isEmpty();

## Constructors:

    Supplier<ArrayList> method4 = ArrayList::new;
    Supplier<ArrayList> lambda4 = () -> new ArraayList();

<br><hr>

# 2 Removing Conditionally

## removeIf

Java 8 introduces **removeIf**, method signature looks like:

    boolean removeIf(Predicate<? super E> filter)

### Example
        
    List<String> list = new ArrayList<>();
	list.add("Magician");
	list.add("Assistant");
	// list.removeIf(String::startsWith("M")); // this does not compile
	list.removeIf(s->s.startsWith("M"));
	System.out.println(list); // [Assistant]

The predicate version does not work as we are passing strings to the predicate.

## Updating All Elements: replaceAll

**replaceAll()** is a new method in List which allows a lambda expression to be applied to all elements

The method signature is:

    void replaceAll(UnaryOperator<E> o)

### Example:

    List<Integers list = Arrays.asList(1,2,3);
    list.replaceAll(x->x*2);
    System.out.println(list); [2,4,6]

## Looping through a Collection: forEach

Java 8 introduces the forEach() method to loop through a collection.

### Example

    List<String> cat = Array.asList("Annie", "Ripley");
    cats.forEach(c-> Sytstem.out.println(c));
    cats.forEach(System.out::println);

The last two lines are equivalent.

## Using New Java 8 Map APIs

The Map interface has the following methods:

* merge()
* computeIfAbsent()
* computeIfPresent()

Suppose we wanted to update the value for a key in a map:

    Map<String, String> favorites = new HashMap<>();
		favorites.put("Jenny", "Bus Tour");
		
		// suppose we want to update the value for Jenny
		// one way is to reinsert a key-value pair:
		favorites.put("Jenny", "Tram");
		System.out.println(favorites); // {Jenny=Tram}
		
The putIfAbsent() adds/updates a value if the value is null or absent:

		// the putIfAbsent method lets you set a value if it is null or absent
		favorites.put("Tom", null);
		favorites.putIfAbsent("Jenny", "Train");
		System.out.println(favorites); // {Tom=null, Jenny=Tram}
		favorites.putIfAbsent("Tom", "Tram");
		System.out.println(favorites); // {Tom=Tram, Jenny=Tram}

## merge

The merge function of the Map API, lets you update a value of a key based off some logic!

The merge function has the following signature:

    V merge(K key, V value, Bifunction mappringFunction)

Example:

![](2023-01-07-14-32-57.png)
