<link href="../../styles.css" rel="stylesheet"></link>

# Revision Notes

# 🧠 4.1 Using Variables in Lambdas


* If you can add `final` to a variable without problems, then it is effectively final. Lambdas are inner classes and thus have the same rules

* Lambdas can access static + instance variables, effectively final method parameters, and effectively final local variables.

### 🟡 Example:

* How many accessible variables are there?

```java
interface Gorilla { String move(); }
class GorillaFamily {
    String walk = "walk";
    void everyonePlay(boolean baby) {
        String approach = "amble";
        
        play(() -> walk); // here
        play(() -> baby ? "hitch a ride" : "run"); // here
        play(() -> approach); // here
    }
    void play(Gorilla g){
        System.out.println(g.move());
    }
}
```

<hr>

# 🧠 4.2 Working with Built-in Functional Interfaces

## 🟥 4.2.1 Implementing Functional Interfaces

* A Functional interface has exactly one abstract method. We have the following functional interfaces in the `java.util.function` package! Here are the common functional interfaces:

1) `Supplier<U>`, returns U, takes 0 arguments. Method: `get()`. Example:

```java
Supplier<String> s = () -> "Hello world";
```

2) `Consumer<U>`, takes 1 argument (U), returns void. Method: `accept()`. Example:

```java
Consumer<String> c = System.out::println;
c.accept("hello world"); // hello world
// c.accept(1); // DOES NOT COMPILE
Consumer<String> c2 = (x) -> new String(x);
// System.out.println(c2.accept("hello")); // DOES NOT COMPILE 
```

3) `BiConsumer<T, U>`, takes 2 arguments (T, U), returns void. Method: `accept()`. Example:

```java
BiConsumer<Integer, Integer> bc = (x,y) -> Math.addExact(x,y); 
// While above does compile, its not useful
// BiConsumer<String, String> bc2 = (x,y) -> x + y; // VOID METHODS CANNOT RETURN VALUE
BiConsumer<String, String> printName = (x,y)-> System.out.println(x + " "+y);
printName.accept("Shiv", "Kumar"); // Shiv Kumar
```

4) `Predicate<T>`, takes 1 argument, returns boolean. Method: `test()`. Example:

```java
// Predicate<String> pred = String::endsWith("hello"); // DOES NOT COMPILE
Predicate<String> pred2 = String::isBlank;
System.out.println(pred2.test("  ")); // true
```

5) `Predicate<T, U>`, takes 2 argument, returns boolean. Method `test()`. Example:

```java
BiPredicate<String, String> containsAnotherString = String::contains;
System.out.println(containsAnotherString.test("hello", "hell")); // true
System.out.println(containsAnotherString.test("hello", "world")); // false
```

6) `Function<T, R>`, takes 1 argument (T), returns R. Method `apply()`. Examples:

```java
Function<String, Integer> getLength = String::length;
System.out.println(getLength.apply("hello")); // 5
```

7) `BiFunction<T, U, R>`, takes T and U, returns R. Method `apply()`. Example:

```java
BiFunction<String, String, Boolean> bf = String::contains;
System.out.println(bf.apply("hello", "el")); // true
BiFunction<String, String, String> b2 = String::concat;
System.out.println(b2.apply("hello", " world")); // hello world
```

8) `UnaryOperator<T>`, takes T returns T, Method `apply`. Example:

```java
UnaryOperator<String> u = String::toUpperCase;
System.out.println(u.apply("hello")); // HELLO
```

9) `BinaryOperator<T>`, takes T twice, returns T. Method `apply`. Example:

```java
BinaryOperator<String> bo = String::concat;
System.out.println(bo.apply("hello ", "world")); // hello world
```