<link href="../../styles.css" rel="stylesheet"></link>

# 📝 Chapter 4: Revision Notes V2

# 🧠 4.1 Using Variables in Lambdas

* We can use local variables, method variables, static and instance variables which are effectively final

# 🧠 4.2 Working with Built in Functional Interfaces

*  There are several built in functional interfaces which are used for streams:

1) `Supplier<T>` - gets T
2) `Consumer<T>` - accepts T
3) `BiConsumer<T,U>` - accepts T and U
4) `Predicate<T>` - tests T
5) `BiPredicate<T,U>` - test T and U
6) `Function<T,R>` - applies function to T and returns R
7) `BiFunction<T,U,R>` - applies function to T and U and returns R
8) `UnaryOperator<T>` - applies function to T and returns T
9) `BinaryOperator<T,T>` - applies function to two T parameters and returns T

## 🟥 Implementing Consumer and BiConsumer

```java
Consumer<String> c1 = System.out::println;
```

```java
Map<String, Integer> map = new HashMap<>();
BiConsumer<String, Integer> b1 = map::put;
BiConsumer<String, Integer> b2 = (k,v)-> map.put(k,v);
```

## 🟥 Checking Functional Interfaces

* What functional interfaces would fill in the blanks:

```java
6:  ___<List> ex1 = x -> "".equals(x.get(0));
7:  ___<Long> ex2 = (Long l) -> System.out.println(l)
8:  ___<String, String> ex3 = (s1,s2) -> false;
```

* `Predicate`, `Consumer`, `BiPredicate`

# 🧠 4.3 Returning an Optional

* We can create Optionals for generics:

```java
Optional<Double> opt = Optional.of(1.2);
opt.ifPresent(opt.get()); // 1.2
Optional<Double> emptyOpt = Optional.empty();
emptyOpt.ifPresent(System.out::println); // nothing printed
```

* We can throw an exception using `orElseThrow`:
```java
Optional.empty().orElseThrow(RuntimeException::new); // throws runtime exception
```

<hr>

# 🧠 4.4  Using Streams

## 🟥 Creating streams

* We can create streams in multiple ways:

```java
Stream<String> str1 = Stream.of("a", "b", "c");
Stream<String> str2 = Arrays.asList("a","b","c").stream();
Stream<String> str3 = Stream.empty();
```

## 🟥 Common Terminal Operations

* Some terminal operations are reductions, these include `collect()`, `reduce()`, `count()`, `min()/max()`.

* We also have non-reduction terminal operations: `allMatch/anyMatch/noneMatch`, `findAny/findFirst` and `forEach`

### 🟡 collect()

* The collect method has the following signatures:

```java
R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R,R> combiner)
R collect(Collector<? super T, A, R> collector)
```

* Here is an example of using the first signature:

```java
Stream<String> str = Stream.of("w","o","l","f");
StringBuilder word = str.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
```


## 🟥 Using Common Intermediate Operations

* Intermediate operations include: `filter()`,`distinct()`, `limit/skip`, `map`, `flatMap`, `sorted(Comparator c)`, `peek(Consumer c)`

### 🟡 Using `map()`

```java
Stream<String> strings = Stream.of("Hello", "World!");
Stream<Integer> lengths = strings.map(x->x.length());
```

### 🟡 Using `sorted()`

```java
Stream<String> str = Stream.of("a","b","c");
str.sorted(Comparator.reverseOrder())
   .forEach(System.out::print); // c b a
```

<hr>

# 🧠 4.5 Working with Primitives

* We have used generics with Streams so far, but we also have primitive versions of streams which offer useful methods like `average()`

* We can convert an existing Stream into a primitive stream:

```java
Stream<Integer> ints = Stream.of(1,2,3);
IntStream intStream = ints.mapToInt(x->x);
OptionalDouble avg = intStream.average();
System.out.println(avg.getAsDouble()); // 2.0
```

## 🟥 Creating Primitive Streams

* There are 3 types of primitive streams:

1) IntStream - for `int`, `short`, `byte` and `char`
2) LongStream - for `long`
3) DoubleStream - for `float` and `double`

* We can generate primitive streams through the following ways

```java
DoubleStream empty = DoubleStream.empty();
DoubleStream str1 = DoubleStream.of(1.2, 2.4);
DoubleStream str2 = Stream.of(1).mapToInt(x->x);
DoubleStream str3 = DoubleStream.generate(() -> 1.2);
DoubleStream str4 = DoubleStream.iterate(1.0, n->n/2);
```

* We can create ranges easily for `IntStream` and `LongStream` using `range()` and `rangeClosed()`:

```java
IntStream range = IntStream.range(1,2);
LongStream rangeClosed = LongStream.rangeClosed(1,3);
```

* We can convert from Object streams to primitive streams and vice versa:

```java
Stream<String> objStream = Stream.of("penguin", "fish");
// creating IntStream
ToIntFunction<String> toLength = x -> x.length(); 
IntStream lengthsStream = objStream.mapToInt(toLength);
// creating DoubleStream
Stream<String> objStream2 = Stream.of("penguin", "fish");
DoubleStream doubleStream = objStream2.mapToDouble(x-> x.length()/2.0);
```

## 🟥 Using Optional with Primitive Streams

* We also have `OptionalInt`, `OptionalLong` and `OptionalDouble` alongside the primitive streams.

* E.g. if we were to find the average of an `int[]` array:

```java
int[] grades = { 1, 3, 6};
OptionalDouble avg = IntStream.of(grades).average();
double avgAsDouble = avg.getAsDouble();
System.out.println(avgAsDouble); // 3.3333333333333335
```

* We also have `IntSupplier`, `LongSupplier` and `DoubleSupplier` for each of the Optional primitives!

```java
OptionalInt emptyOptionalInt = OptionalInt.empty();
IntSupplier intSupplier = () -> 1;
int x = emptyOptionalInt.orElseGet(intSupplier);
System.out.println(x); // 1
```

* The `sum()` method will always return a value!!!

```java
IntStream emptyIntStream = IntStream.empty();
int intSum = emptyIntStream.sum();
System.out.println(intSum); // 0
```


## 🟥 Summarising Statistics

* We can use the `summaryStatistics()` method on `IntStream`, `LongStream` and `DoubleStream`

```java
IntStream ints = IntStream.of(1, 4, 9);
IntSummaryStatistics intSummary = ints.summaryStatistics();
System.out.println(intSummary); // IntSummaryStatistics{count=3, sum=14, min=1, average=4.666667, max=9}
double average = intSummary.getAverage();
System.out.println(average); // 4.666666666666667
```

* If the stream is empty, we get some strange results in the statistics:

```java
IntStream empty = IntStream.empty();
System.out.println(empty.summaryStatistics());
// IntSummaryStatistics{count=0, sum=0, min=2147483647, average=0.000000, max=-2147483648}
```