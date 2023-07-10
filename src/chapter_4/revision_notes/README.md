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

### 🟡 allMatch(), anyMatch() and noneMatch()

* These methods SOMETIMES terminate on infinite streams. These are NOT REDUCTIONS!. The operation will NOT ALWAYS terminate:

```java
List<String> list = Arrays.asList("monkey", "2", "chimp");
System.out.println(list.stream().allMatch(x->x.length()>1)); // false
System.out.println(list.stream().anyMatch(x->x.length()>1)); // true
System.out.println(list.stream().noneMatch(x->x.length()>1)); // false

Stream<String> all1CharLength = Stream.generate(()->"1");
System.out.println(all1CharLength.allMatch(x->x.length()==1)); // PROGRAM HANGS
```

### 🟡 forEach()

* This does not terminate for infinite streams! It returns void and is NOT A REDUCTION!

* We can supply the method with a consumer!

```java
Stream<String> str2 = Stream.of("Monkey", "Gorilla", "Bonobo");
str2.foEach(System.out::println); // MonkeyGorillaBonobo
```

### 🟡 reduce()

* The reduce method is a REDUCTION, it does not terminate for infinite streams.

* This method has multiple signatures:

```java
T reduce(T identity, BinaryOperator<T> accumulator)
```

* Suppose we want to take a String array and concatenate them into a single string. We COULD use a for loop, but a stream makes this alot cleaner:

```java
List<String> strings = Arrays.asList("w","o","l","f");
String word = strings.stream().reduce("",(s,c)->s+c);
System.out.println(word); // wolf
```

* Suppose we have a stream of integers and we want to find their product:

```java
Stream<Integer> ints = Stream.of(1,2,3,4);
int product = ints.reduce(1, (p,x)->p*x);
System.out.println(product); // 24
```

* The identity is an optional field:

```java
Optional<T> reduce(BinaryOperator<T> accumulator)
```

* If you do not specify the identity there are 3 possibilities for the returned value:

1) if stream is empty, empty optional

2) if stream has one element, the element is returned

3) if multiple elements are found, then the accumulator is applied

```java
BinaryOperator<Integer> op = (a, b) -> a * b;
Stream<Integer> empty = Stream.empty();
Stream<Integer> oneElement = Stream.of(3);
Stream<Integer> threeElements = Stream.of(3, 5, 6);
empty.reduce(op).ifPresent(System.out::print); // no output
oneElement.reduce(op).ifPresent(System.out::println); // 3
threeElements.reduce(op).ifPresent(System.out::println); // 90
```

### 🟡 collect()

* The `collect()` method is a MUTABLE REDUCTION. It DOES NOT TERMINATE on infinite streams.

* It has the following method signatures:

```java
R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R,R> combiner)
R collect(Collector<? super T, A, R> collector)
```

* Here's the wolf example using the first signature:

```java
Stream<String> str = Stream.of("w","o","l","f");
StringBuilder word = str.collect(()->new StringBuilder(), (x,y)->x.append(y), (a,b)->a.append(b));
System.out.println(word); // wolf
```

* Instead of implementing a Collector ourselves, Java provides an interface with common collectors. E.g we could rewrite:

```java
TreeSet<String> set = str.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
System.out.println(set); // [f, l, o, w]
```

* as:

```java
TreeSet<String> set = str.collect(Collectors.toCollection(TreeSet::new));
System.out.println(set); // [f, l, o, w]
```


<br>

## 🟥 4.4.3 Using Common Intermediate Operations

* Intermediate operations can return an infinite stream from infinite streams! We have the following operations

### 🟡 filter()

It has the following signature:

```java
Stream<T> filter (Predicate<? super T> predicate)
```

* E.g:

```java
Stream.of("monkey", "gorilla","chimp")
    .filter(x->x.startsWith("m")).forEach(System.out::print); // monkey
```

### 🟡 distinct()

* This method removes duplicate values. Java calls `.equals()` to find the duplicates

* E.g.:

```java
Stream.of("duck", "duck", "Duck", "goose", "goose")
    .distinct().forEach(System.out::print); // duckDuckgoose
```

### 🟡 limit() and skip()

* These methods make our stream smaller!

```java
Stream.of("duck", "duck", "Duck", "goose", "goose")
	skip(2).forEach(System.out::print); // Duckgoosegoose

Stream.iterate(1, n->n+1)
    .limit(5)
    .skip(2)
    .forEach(System.out::println); // 3 4 5
```

### 🟡 map()

* This map lets us create a 1-to-1 mapping from slements in the stream. It has the following signature:

```java
Stream<R> map(Function<? super T, ? extends R> mapper)
```

* E.g.:

```java
Stream.of("monkey", "gorilla", "chimp")
    .map(x->x.length())
    .map(x->x+2)
    .forEach(System.out::println); // 8 9 7
```

### 🟡 flatMap()

* This method makes any sub-elements into top-level elements in a single stream.

* It has the following signature:

```java
Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
```

```java
Stream.of(Arrays.asList(1,2,3))
    .flatMap(l->l.stream())
    .forEach(System.out::println); // 1 2 3
```

### 🟡 sorted()

* This method will sort elements of an array using their natural sorting unless a Comparator is specified:

```java
Stream<T> sorted()
Stream<T> sorted(Comparator<? super T> comparator)
```

* E.g.:

```java
Stream.of("brown bear", "grizzly bear")
    .sorted()
    .forEach(System.out::println); // brown bear grizzly bear
    
Stream.of("brown bear", "grizzly bear")
    .sorted(Comparator.reverseOrder())
    .forEach(System.out::println); // grizzly bear brown bear
```

### 🟡 peek()

* The peek method lets us perform a stream operation without changing it! It has the following signature:

```java
Stream<T> peek(Consumer<? super T> action)
```

* E.g.:

```java
long count = Stream.of("black bear", "brown bear", "grizzly")
    .filter(x->x.startsWith("b"))
    .peek(System.out::println) // black bear brown bear
    .count();
System.out.println(count); // 2
```

* We should not be modifying the stream within peak!!!

<br>

## 🟥 4.4.4 Putting Together the Pipeline

* Suppose we had the following code:

```java
List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
List<String> filtered = new ArrayList<>();
for (String name: list) {
    if (name.length() == 4) filtered.add(name);
}
Collection.sort(filtered);
```

*  We could write this so much easier:

```java
Stream.of(list)
    .filter(x->x.length()==4)
    .sorted()
```



<hr>

# 🧠 4.5 Working with Primitives

## 🟥 Introduction

* So far, we created streams for objects/wrapper classes. But we can also create streams for int, double and long primitives.

* These streams designed specifically for primitves offer more useful methods. 

* Going back to finding the sum of a stream, if we use the wrapper variant we would need to write a reduction:

```java
Stream<Integer> stream = Stream.of(1,2,3);
// stream.sum(); DOES NOT COMPILE
stream.reduce(0, (s,n)->s+n); // 6
```

* If we create an `IntStream`, we can exploit the sum() method:

```java
stream.mapToInt(x->x).sum();
```

* Suppose we want to calculate the average, this would require to pass throughs of a stream! If we use a primitive stream we can call average() method:

```java
IntStream ints = IntStream.of(1,2,3);
OptionalDouble avg = ints.average(); 
System.out.println(avg.getAsDouble()); // 2.0
```


## 🟥 4.5.1 Creating Primitive Streams

* There are 3 primitive stream types:

1) `IntStream` for char, int, byte, short

2) `LongStream` for long

3) `DoubleStream` for float and double

* We can create streams on the above primitive streams using `stream.of()` and `stream.empty()`. We can also use `generate()` and `iterate()`

* We have `range()` and `rangeClosed()` for the integer streams:

```java
IntStream.range(1, 2);
IntStream.rangeClosed(1, 3);
LongStream.range(1, 2);
LongStream.rangeClosed(1, 3);
DoubleStream.range(1,2); // COMPILER ERROR
```

* All the primitive Streams have the following methods:

1) `mapToObj()` (except for Stream)

2) `mapToInt()` (except for IntStream)

3) `mapToLong()` (except for LongStream)

4) `mapToDouble()` (except for DoubleStream)

<br>

## 🟥 4.5.2 Using Optional with Primitive Streams

* We saw in the first example, that the `average()` method returned an OptionalDouble - which was retrieved using `getAsDouble()`

* The min/max functions return a primitive optional of the same type as the stream. E.g.:

```java
OptionalLong min = LongStream.of(1,2)
	.min();
```

<br>

## 🟥 4.5.3 Summarizing Statistics

* Suppose we have the following method:

```java
private static int range(IntStream ints){
}
```

* We want to calculate the range from the stream, so we would need `ints.max() - ints.min()` - but we can't reference a stream twice!! 

* This is where SummaryStatistics help!

```java
private static int range(IntStream ints) {
    IntSummaryStatistics stats = ints.summaryStatistics();
    if (stats.getCount() == 0) throw new RuntimeException();
    return stats.getMax()-stats.getMin();
}
```

<br>

## 🟥 4.5.4 Learning the Functional Interfaces for Primitives

### 🟡 Functional Interfaces for boolean

* The `BooleanSupplier` supplies a primitive boolean. It has a `getAsBoolean()` method:

```java
BooleanSupplier b1 = () -> true;
BooleanSupplier b2 = () -> Math.random() > .5;
System.out.println(b1.getAsBoolean());
```

### 🟡 Functional Interfaces for double, int, and long

* We have functional interfaces for all 3 types of Primitive streams (IntStream, LongStream, DoubleStream).

* The below list will only look at the `Double` type:

1) `DoubleSupplier` - returns double. Method: `getAsDouble()`

2) `DoubleConsumer` - void return, takes one parameter (double). Method: `accept()`

3) `DoublePredicate` - returns boolean, takes one parameter (double). Method: `test()`

4) `DoubleFunction<R>` - returns R, takes one parameter (double). Method: `apply()`

5) `DoubleUnaryOperator` - returns double, takes one parameter (double). Method: `applyAsDouble()`

6) `DoubleBinaryOperator` - returns double, takes two parameters (double). Method - `applyAsDouble`

* We also have primitive specific functional interfaces:

1) `ToDoubleFunction<T>`, takes one parameter (T), returns double. Method - `applyAsDouble()`

2) `ToDoubleBiFunction<T, U>`, takes 2 parameters (T, U), returns double. Method - `applyAsDouble()`

3) `DoubleToIntFunction`, `DoubleToLongFunction`, takes 1 parameter (double) and returns int and long respectively. Methods: `applyAsInt` and `applyAsLong`

4) `ObjDoubleConsumer<T>`, takes 2 parameters (T, double), return is `void`. Method - `accept`

* Which functional interface would you use to fill in the blank to make the following code compile?

```java
double d = 1.0;
______ f1 = x -> 1;
f1.applyAsInt(d);
```

* The method takes a double parmaeter and returns an int. The only functional interface meeting all three criteria is `DoubleToIntFunction`


<hr>

# 🧠 4.6 Working with Advanced Stream Pipeline Concepts

* This section will show the relationship between streams and the underlying data, chaining Optional and grouping collectors.

## 🟥 4.6.1 Linking Streams to the Underlying Data

* What do you think this outputs?

```java
List<String> cats = new ArrayList<>();
cats.add("Annie");
cats.add("Ripley");
Stream<String> = cats.stream();
cats.add("KC");
System.out.println(stream.count());
```

* The answer is 3!!!

* Streams are lazily evaluated!

<br>

## 🟥 4.6.2 Chaining Optionals

* There are few operations for streams are available for Optional!

* Suppose you are given an `Optional<Integer>` and aked to print the value, but only if it is a three-digit number. Without functional programming, we would write it as:

```java
private static void threeDigit(Optional<Integer> optional){
    if (optional.isPresent()) {
        Integer num = optional.get();
        String str = "" + num;
        if (str.length()==3)
            System.out.println(str);
    }
}
```

* We can achieve the same result with functional programming:

```java
private static void threeDigit(Optional<Integer> optional) {
    optional.map(n->""+n)
    .filter(n->n.length()==3)
    .ifPresent(System.out::println);
}
```

* We can map an optional using `.map()`, suppose we want to get an `Optional<Integer>` representing the length of a String optional:

```java
Optional<Integer> result = optional.map(String::length);
```

* Suppose we have a method in a class called calculate:

```java
class ChainingOptional {
    static Optional<Integer> calculator(String s){
        return Optional.of(s.length);
    }
}
```

* The following WILL NOT COMPILE:

```java
Optional<Integer> x = optional.map(ChainingOptional::calculator);
```

* This is because the RHS would be an `Optional<Optional<Integer>>`, we can get around this problem by using `flatMap()`:

```java
Optional<Integer> x = optional.flatMap(ChainingOptional::calculator); // WORKS FINE
```

<br>

## 🟥 4.6.3 Collecting Results

* We looked at the collect() terminal operatior. We can use collectors as an argument to change the Collection type

### 🟡 Collecting Using Basic Collectors

* Here is an example of using collectors:

```java
Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
String result = ohMy.collect(Collectors.joining(", "));
System.out.println(result); // lions, tigers, bears
```

* Here, we calculate the average length:

```java
Stream<String> ohMy = Stream.of("lions","bears","tigers");
ToIntFunction<String> findLength = s -> s.length();
double result = ohMy.collect(Collectors.averagingInt(findLength));
System.out.println(result); // 5.333333333333333
```

* We can also collect into a collection using `Collectors.toCollection(Supplier s)`:

```java
Stream<String> str = Stream.of("lions","bears","tigers");
Supplier<TreeSet<String>> s = () -> new TreeSet();
TreeSet<String> tree = str
        .filter(x->x.length()==6)
        .collect(Collectors.toCollection(s));
System.out.println(tree); // [tigers]
```

### 🟡 Collecting into Maps

* The `toMap(Function k, Function v)` is used to create a map using 2 functions to create the key and value. 

* Suppose we want to create a map which maps a String to its length:

```java
Stream<String> str = Stream.of("lions","tigers","bears");
Function<String, String> k = s -> s;
Function<String, Integer> v = s -> s.length();
Map<String, Integer> map = str.collect(Collectors.toMap(k, v));
System.out.println(map); // {lions=5, bears=5, tigers=6}
```

* We need to be careful with creating the key mapping, suppose we reverse the above map - we will have 5 mapped to lions and bears:

```java
Stream<String> str1 = Stream.of("lions","tigers","bears");
Function<String, Integer> keys = s -> s.length();
Function<String, String> values = s -> s;
Map<String, Integer> map1 = str.collect(Collectors.toMap(k, v));
// THROWS EXCEPTION ^^^
```

* We can overload the toMap() method so that it can handle these collisions:

```java
Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
Map<Integer, String> map = ohMy.collect(Collectors.toMap(s->s.length(), s->s, (s1,s2)-> s1+", "+s2));
System.out.println(map); // {5=lions, bears, 6=tigers}
System.out.println(map.getClass()); // class java.util.HashMap
```

* This created a `HashMap` 😱 what if we wanted a TreeMap instead? We just overload the method again:

```java
Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
TreeMap<Integer, String> map = ohMy.collect(Collectors.toMap(s->s.length(), s->s, (s1,s2)-> s1+", "+s2, TreeMap::new));
System.out.println(map); // {5=lions, bears, 6=tigers}
System.out.println(map.getClass()); // class java.util.TreeMap
```