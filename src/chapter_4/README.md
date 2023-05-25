uyhgq<link href="style.css" rel="stylesheet"></link>

# 🟪  Chapter 4: Functional Programming

## 🟦 Contents:

 [4.1: Using Variables in Lambdas]()

 [4.2: Working with Built-in Functional Interfaces]()

 [4.3: Returning an Optional]()
 
 [4.4: Using streams]()

 [4.5: Working with Primitives]()
 
 [4.6: Working with Advanced Pipeline Concepts]()

<hr>

## 🟦 Exam Objectives:

This chapter will introduce more functional interfaces and the `Optional` class.

* Generics and Collections:

    - Collections Steams and Filters
    - Iterate using forEach methods on Streams and List
    - Describe Stream interface and Stream pipeline
    - Use method references with Streams

* Lambda Built-In Functional Interfaces

    - Use the built-in interfaces in `java.util.function` such as `Predicate`, `Consumer`, `Function` and `Supplier`
    - Develop code which uses primitive versions of functional interfaces
    - Develop code which uses binary version of functional interfaces.
    - Develop code that uses the `UnaryOperator` interface

* Java Stream API:

    - Develop code to extract data from an object using `peek()` and `map()` methods including the primitive versions of `map()`
    - Search for data by using search methods in Streams such as `findFirst`, `findAny`, `anyMatch`, `allMatch`, and `noneMatch`
    - Develop code which uses the `Optional` class
    - Develop code which uses Stream data and calculation methods
    - Sort a collection using Stream API
    - Save results to a collection using the collect method
    - Use `merge()` and `flat()` methods of Stream API


# 4.1 Using Variables in Lambdas


* A variable is effectively final if it is not modified after initialisation in the local block. Effectively final variables can use therse variables inside a lambda expression

* How many effectively final local cariables can you find in this example:

```java
interface Gorilla { String move(); }
class GorillaFamily {
    String walk = "walk";
    void everyonePlay(boolean baby) {
        String approach = "amble";
        // approach = "run";

        play(() -> walk);
        play(() -> baby ? "hitch a ride":"run");    // line 9
        play(() -> approach);
    }
    void play(Gorilla g) {
        System.out.println(g.move());
    }
}
```

# 4.2 Working with Built-in Functional Interfaces

* A functional interface has exactly one abstract method. The below table are functional interfaces introduced in Java 8.


| Function Interfaces   | No. of parameters  | Return Type | Method    |
| --------------------- | ------------------ | ----------- | --------- |
| `Supplier<T>`         | 0                  | T           | `get`     |
| `Consumer<T>`         | 1                  | void        | `accept`  |
| `BiConsumer<T, U>`    | 2                  | void        | `accept`  |
| `Predicate<T>`        | 1                  | boolean     | `test`    |
| `BiPredicate<T,U>`    | 2                  | boolean     | `test`    |
| `Function<T,R>`       | 2                  | R           | `apply`   |
| `BiFunction<T, U, R>` | 2 (T, U)           | R           | `apply`   |
| `UnaryOperator<T>`    | 1                  | T           | `apply`   |
| `BinaryOperator<T>`   | 2 (T, T)           | T           | `apply`   |

## 4.2.1 Implementing Supplier

* The `Supplier` class is used when you want to generate a value without requiring input. This interface is defined as:

```java
@FunctionalInterface class Supplier<T>() {
    public T get();
}
```

* The Supplier is often implemented as a object factory. E.g. we could create a supplier which returns `LocalDate.now()`:

```java
Supplier<LocalDate> s1 = LocalDate::now;
Supplier<LocalDate> s1Again = () -> LocalDate.now();

LocalDate d1 = s1.get();
System.out.println(d1); // 2023-05-25
```

* Here is another example which instantiates an ArrayList:

```java
Supplier<ArrayList<String>> s1 = ArrayList<String>::new;
ArrayList<String>           a1 = s1.get();
System.out.println(a1); // []
```

* If we print out the functional interface itself we get something like `chapter_4.FunctionalInterfaces$$Lambda$44/0x0000000800113990@5ef60048`

## 4.2.2 Implementing Consumer and BiConsumer

* A consumer is used when you want to do something with a parameter but not return anything. These functional interfaces are defined as:

```java
@FunctionalInterface public class Consumer<T> {
    void accept(T t);
}
@FunctionalInterface public class BiConsumer<T, U> {
    void accept(T t, U u);
}
```

* Here is an example:

```java
Consumer<String> c1 = System.out::println;
Consumer<String> c2 = x -> System.out.println("here is x: "+x)
```

```java
Map<String, Integer> map = new HashMap<>();
BiConsumer<String, Integer> b1 = (x,y) -> map.put(x,y);
BiConsumer<String, Integer> b2 = map::put;
```

* Method reference works here too! The following will NOT work:

```java
BiConsumer<Integer, String> b3 = map::put; // COMPILER ERROR
```

## 4.2.3 Implementing Predicate and BiPredicate

* We've used predicates before when calling the `removeIf()` method on collections. Predicates are often used when filtering or matching. Predicate and BiPredicate are defined as:

```java
@FunctionalInterface public class Predicate<T> {
    boolean test(T t);
}
@FunctionalInterface public class BiPredicate<T, U> {
    boolean test(T t, U u);
}
```

* We use predicates to write tests for a parameter (or 2 parameters). Here is some examples:

```java
Predicate<String> p1 = String::isEmpty;
Predicate<String> p2 = s -> s.contains("h");
```

* You can not use a non-static method as a method reference.

* We also have the `BiPredicate` interface:

```java
BiPredicate<String, String> bp1 = String::contains;
BiPredicate<String, String> bp2 = (x,y) -> x.contains(y); // equivalent to above

System.out.println(bp1.test("Shiv","v")); // true
System.out.println(bp2.test("Hello", "o")); // true
```

### Default Methods on Functional Interfaces

* Suppose we have two predicates:

```java
Predicate<String> egg = s.contains("egg");
Predicate<String> brown = s.contains("brown");
```

* Suppose we want to check that string contains "egg" AND "brown", we COULD write it as:

```java
Predicate<String> brownEggs = s.contains("egg") && s.contains("brown");
```

* This has code duplication. We can use default methods on `Predicate`:

```java
Predicate<String> brownEggs = egg.add(brown);
```

* Suppose we want String containing "egg" AND NOT "brown, then we can use the `negate()` method on the predicate:

```java
Predicate<String> eggsWhichAreNotBrown = egg.and(brown.negate());
System.out.println(eggsWhichAreNotBrown.test("I like eggs which are not brown")); // false
```


## 4.2.4 Implementing Function and BiFunction

* The `Function` and `BiFunction` interfaces are defined as:

```java
@FunctionalInterface public class Function<T,R> {
    R apply(T t);
}

@FunctionalInterface public class BiFunction<T,U,R> {
    R apply(T t, U u);
}
```

* Here are some examples of implementing `Function`:

```java
Function<String, Integer> f1 = String::length;
System.out.println(f1.apply("Shiv")); // 4

Function<String, Integer> f2 = s -> s.indexOf("i");
System.out.println(f2.apply("Shiv")); // 2
```

* Here are some examples of implementing `BiFunction`:

```java
BiFunction<String,String,Integer> bf1 = String::indexOf;
System.out.println(bf1.apply("Shiv Kumar", "Ku")); // 5

BiFunction<String,String,Integer> bf2 = String::concat;
System.out.println(bf2.apply("1+1","=2"));
```

