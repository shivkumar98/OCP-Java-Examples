<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 4.2 Working with Built-in Functional Interfaces

## 📜 Contents 📜

- [🔴 4.2.1 Implementing Supplier](#🔴-421-implementing-supplier)
- [🔴 4.2.2 Implementing Consumer and BiConsumer](#🔴-422-implementing-consumer-and-biconsumer)
- [🔴 4.2.3 Implementing Predicate and BiPriedicate](#🔴-463-collecting-results)
- [🔴 4.2.4 Implementing Function and BiFunction](#🔴-424-implementing-function-and-bifunction)
- [🔴 4.2.5 Implementing UnaryOperator and BinaryOperator](#🔴-425-implementing-unaryoperator-and-binaryoperator)
- [🔴 4.2.6 Checking Functional Interfaces](#🔴-426-checking-functional-interfaces)


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

## 🔴 4.2.1 Implementing Supplier

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

<r>

## 🔴 4.2.2 Implementing Consumer and BiConsumer

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

<hr>

## 🔴 4.2.3 Implementing Predicate and BiPredicate

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

<hr>

## 🔴 4.2.4 Implementing Function and BiFunction

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

<hr>

## 🔴 4.2.5 Implementing UnaryOperator and BinaryOperator

* `UnaryOperator` and `BinaryOperator` are functions which map parameters of one type to a value of the SAME type. These interfaces are defined as:

```java
@FunctionalInterface public class UnaryOperator<T> extends Function<T,T> {}

@FunctionalInterface public class BinaryOperator<T> extends BiFunction<T,T,T> {}
```

* Here is an example:

```java
UnaryOperator<String> u1 = String::toUpperCase;
UnaryOperator<String> u2 = s-> s.concat(" x");
System.out.println(u1.apply("shiv")); // SHIV
System.out.println(u2.apply("shiv")); // shiv x

BinaryOperator<String> b1 = String::concat;
BinaryOperator<String> b2 = (x,y) -> x + " " + y;
System.out.println(b1.apply("Shiv ", "Kumar")); // Shiv Kumar
System.out.println(b2.apply("Shiv", "Kumar")); // Shiv Kumar
```

<hr>

## 🔴 4.2.6 Checking Functional Interfaces

* Which functional interface would you use in these 3 scenarios:

1) Returns a String without taking any "parameters"

2) Returns a Boolean and takes a String

3) Returns an Integer and takes two Integers

* My answer: Supplier, Predicate, BinaryOperator

* Actual answer: Supplier, Function (because it returns wrapper not primitive), BinaryOperator OR BiFunction

* What would fill in these gaps:

```
____<List> ex1 = x -> "".equals(x.get(0))
____<Long> ex2 = (Long l) -> System.out.println(l);
____<String, String> ex3 - (s1, s2) -> false
```

* My answer: Predicate, Consumer, BiPredicate

* Actual answer: Predicate, Consumer, BiPredicate

* Identify the errors in the following:

```java
Function<List<String>> ex1 = x -> x.get(0); // COMPILER ERROR
UnaryOperator<Long> ex2 = (Long l) -> 3.14; // COMPILER ERROR
Predicate ex3 = String::isEmpty; // COMPILER ERROR
```

* My answer: ex1 should be declared as `Function<List<String>, String>`, ex2 should return a Long not Double, ex3 does not declare generic on Predicate

* Actual answer: same as above