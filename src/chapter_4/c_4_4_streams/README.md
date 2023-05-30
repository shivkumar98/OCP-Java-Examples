
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