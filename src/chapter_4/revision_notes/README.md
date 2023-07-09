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