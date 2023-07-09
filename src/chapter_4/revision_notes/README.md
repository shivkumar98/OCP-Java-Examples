<link href="../../styles.css" rel="stylesheet"></link>

# 📝 Chapter 4: Revision Notes

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

<br>

## 🟥 4.2.2 Checking Functional Interfaces:

* What functional interfacres will fill in the blanks:

```java
____<List> ex1 = x -> "".equals(x.get(0));
____<List> ex2 = (Long l) -> System.out.println(l);
____<String, String> ex3 = (s1, s2) -> false;
```

ANSWER: Predicate, Consumer, BiPredicate

* Why does the following not compile:

```java
6: Function<List<String>> ex1 = x -> x.get(0); // DOES NOT COMPILE
7: UnaryOperator<Long> ex2 = (Long l) -> 3.14; // DOES NOT COMPILE
8: Predicate ex4 = String::isEmpty; // DOES NOT COMPILE
```

ANSWER: Line 6 - invalid functional interface declaration. Line 7 - returns dounble and not long. Line 8 - does not declare generic

<hr>

# 🧠 4.3 Returning an Optional

* Some of the stream terminal operations return an Optional. An Optional can be empty or contain a value. We can check if a value is present using `isPresent()`. We can execute a consumer with the value if a value is present using `ifPresent(Consumer c)`

```java
Consumer<Integer> c = System.out::print;
Optional<Integer> x = Optional.empty();
x.ifPresent(c); // nothing prints
x = Optional.of(23);
x.ifPresent(c); // 23
```

* We can also get other value/throw exception using `orElse()`, `orElseGet(Supplier s)` and `orElseThrow(Supplier s)`:

```java
Optional<Integer> empty = Optional.empty();
Supplier<Integer> s = () -> 1;
System.out.println(empty.orElseGet(s)); // 1
Supplier<Exception> ex = IndexOutOfBoundsException::new;
// empty.orElseThrow(s);// DOES NOT COMPILE
empty.orElseThrow(ex); // THROWS EXCEPTION
```

<hr>

# 🧠 4.4 Using Streams

* A stream is a sequence of data

* A stream pipeline are operations which act on the stream to produce a result. This pipeline consists of 3 parts:

1) Source

2) Intermediate operations - optional, lazily evaluated when terminal operation is called. If the terminal operatioln is NOT called, then these operations do NOT EXECUTE!

3) Terminal operation - produces the result, stream can not be referenced again when this is called

## 🟥 4.4.1 Creating Stream Sources

* We can create FINITE streams using `Stream.of()`/`Stream.empty()`

```java
List<String> list = Arrays.asList("Hello", "Shiv", "Kumar");
Stream<String> str = list.stream();
Stream<Integer> str2 = Stream.empty();
Stream<Integer> str3 = Stream.of(1);
```

* We can create INFINITE streams using `Stream.generate()`/`Stream.iterate()`

```java
Stream<String>  str4 = Stream.generate(() -> "hello world");
Stream<Double>  str5 = Stream.generate(Math::random);
Stream<Integer> str6 = Stream.iterate(1, n->n+3);
```

<br>

## 🟥 4.4.2 Using Common Terminal Operations

* A reduction is a terminal operation which goes through the entire stream to return a single object or primitive.

* Some of these operations will hang for an infinite stream

### 🟡 count()

* This is a reduction which does not terminate on an infinite stream. It returns a long:

```java
Stream<Integer> infinite = Stream.generate(() -> 1);
// infinite.count(); // PROGRAM HANGS
Stream<String> finite = Stream.of("hello", "world");
System.out.println(finite.count()); // 2
```

### 🟡 min/max()

* The min/max methods return an Optional. It is a reduction and does not terminate on infinite streams.

```java
Stream<String> str = Stream.of("z", "yy", "xxx");
Comparator<String> comparator = (s1,s2) -> s1.compareTo(s2);
System.out.println(str.min(comparator)); // Optional[xxx]
System.out.println(str.max((s1,s2)->s2.length()-s1.length())); // Optional[z]
```

### 🟡 findAny()/findFirst()

* This returns an Optional, it always terminates for infinite streams.  This is NOT A REDUCTION!

```java
Stream<String> s = Stream.of("monkey", "gorilla", "human");
// System.out.println(s.findAny()); // Optional[monkey]
System.out.println(s.findFirst()); // Optional[monkey]

Stream<String> infiniteS = Stream.generate(() -> "chimp");
System.out.println(infiniteS.findAny()); // Optional[chimp]
```