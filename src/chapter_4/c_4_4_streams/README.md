
# 4.4 Using Streams

* A stream is a sequence of data. A stream pipeline is the operations that run on a stream to produce a result. A stream pipeline has three parts:

1) Source - where the stream comes from

2) Intermediate Operations: transform the stream into another one

3) Terminal Operations: actually generate the result

## 4.4.1 Creating Stream Sources

* There are two types of streams: finite and infinite

### Finite Streams

* We can create finite streams by defining the elements explicitly:

```java
Stream<String> empty = Stream.empty();
Stream<Integer> singleElement = Stream.of(1);
Stream<Integer> fromArray	  = Stream.of(1,2,3);
```

* We can convert lists to streams too:

```java
List<String> list = Arrays.asList("a","b","c");
Stream<String> fromList = list.stream();
// we can process a stream elements in paralleL
Stream<String> fromListParallel = list.parallelStream();
```

* We created a parallel stream which lets us do parallel options (we will see this in concurrency)

### Infinite Streams

* We can create infinite streams by specifying a pattern:

```java
Stream<Double> randoms = Stream.generate(Math::random);
randoms.forEach(System.out::println);
```

* If we look at the console:

<img src="../screenshots/random.gif">

* We can also create a stream containing constant values:

```java
Stream<Double> constant = Stream.generate(() -> 1.2);
constant.forEach(System.out::println);
```

<img src="../screenshots/constant.gif">

* We can specify an iteration pattern using `iterate()`:

```java
Stream<Integer> oddNumbers = Stream.iterate(1, n-> n+2);
oddNumbers.forEach(System.out::println);
```

## 4.4.2 Using Common Terminal Operations

* You can perform a terminal operation without any intermediate operations but not the other way round. Reductions are a special type of termonal operation where all of the contents of the streak are combined into a single primitive or `Object`.

* The following table summarises this section of the book:

| Method        | What Happens for Infinite Streams | Return Value  | Reduction |
| ------------- | --------------------------------- | ------------- | --------- |
| `allMatch/anyMatch/noneMatch` | Sometimes terminates | boolean    | No        |
| `collect()`     | Does not terminate                | varies        | Yes       |
| `count()`     | Does not terminate                | `long`        | Yes       |
| `findAny()/findFirst()` | Terminates              | `Optional<T>` | No        |
| `forEach()`   | Does not terminate                | void          | No        |
| `min()/max()` | Does not terminate                | `Optional<T>` | No        |
| `reduce()`    | Does not terminate                | varies        | Yes       |

### `count()`

* This operation terminates only if the stream is optional and returns the number of elements of the stream as a long, it would have the following signature:

```java
long count()
```

* Example:

```java
Stream<Integer> nums = Stream.of(1,2,3);
System.out.println(nums.count()); // 3
```

### `min() and max()`

* These methods let you pass a custom Comparator and returns the largest and smallest value according to the sorting order. These methods have the following signatures:

```java
Optional<T> min(<? super T> comparator)
Optional<T> max(<? super T> comparator)
```

* Example:

```java
Comparator<String> byLength = (x,y) -> x.length()-y.length();
Stream<String> strings = Stream.of("1", "4444", "666666");
System.out.println(strings.max(byLength)); // Optional[666666]
// System.out.println(strings.max()); // COMPILER ERROR
```

* NOTE: if the stream is empty then the comparator is never called from min()/max()


### `findAny() and findFirst()`

* These two methods will return an optional of an element if the stream is non-empty. If the stream is empty then it returns `Optional.empty`. E.g.:

```java
Stream<Integer> nonEmpty = Stream.of(1);
Stream<Integer> empty	 = Stream.empty();
System.out.println(nonEmpty.findFirst()); // Optional[1]
System.out.println(empty.findAny()); // Optional.empty
```

* These two methods have the following signatures:

```java
Optional<T> findAny()
Optional<T> findFirst()
```

* Even with infinite streams, these two methods will always terminate!😱 E.g.:

```java
Stream<String> monkies = Stream.generate(()-> "monkey");
System.out.println(monkies.findAny()); // Optional[monkey]
```

### `allMatch(), anyMatch() and noneMatch()`

* The operator MAY OR MAY NOT terminate on an infinite stream - this is dependent upon the data🤔. This is NOT a reduction as we are not looking at ALL the elements.

* These methods have the following signatures:

```java
boolean anyMatch(Predicate <? super T>)
boolean allMatch(Predicate <? super T>)
boolean noneMatch(Predicate <? super T>)
```

* Example:

```java
List<String> list 	    = Arrays.asList("monkey", "2", "chimp");
Stream<String> infinite = Stream.generate(()->"chimp");
Predicate<String> pred  = x -> Character.isLetter(x.charAt(0));

System.out.println(list.stream().anyMatch(pred));     // true
System.out.println(list.stream().allMatch(pred));     // false
// System.out.println(infinite.anyMatch(pred)); 	  // true
System.out.println("infi" + infinite.allMatch(pred)); // does not terminate
```

### `forEach()`

* Calling forEach on an infinite stream does not terminate ❗

* This method has the following signature:

```java
void forEach(Consumer<? super T> action)
```

* You can not use a for loop on a Stream! ❗

### `reduce()`

* The reduce method reduces the stream to a single object. It has the following signatures:

```java
T reduce(T identity, BinaryOperator<T> accumulator)
Optional<T> reduce(BinaryOperator<T> accumulator)
<U> U Reduce(U identity, BiFunction<U,? super T, U> accumulator, BinaryOperator<U> combiner)
```

* The most common way of doing a reduction is to start with an initial value and keep mergeing the next value. E.g. suppose we want to concatenate an array of strings:

```java
String[] arr = {"Shiv ", "hates ", "Java "};
Stream<String> stream = Stream.of(arr);
String reduction = stream.reduce("", (x,y) -> x.concat(y));
System.out.println(reduction); // "Shiv hates Java 
```

* We could write this as a method reference:

```java
Stream<String> stream2 = Stream.of(arr);
String red = stream2.reduce("", String::concat);
System.out.println(red);  // "Shiv hates Java " 
```

* Here's an example of finding the product of an array of numbers:

```java
Integer[] nums = {3,4,2};
Stream<Integer> intStream = Stream.of(nums);
int product = intStream.reduce(1, (a,b) -> a*b);
System.out.println(product); // 24
```

* If we DO NOT SET THE IDENTITY, Then an Optional is returned!