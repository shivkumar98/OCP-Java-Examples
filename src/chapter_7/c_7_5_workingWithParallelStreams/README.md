<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 7.5 Working with Parallel Streams
* So far we have worked with **Serial Streams** - results are ordered, and one entry is processed at a time
* **Parallel streams** are capable of processing entries concurrently using multiple threads.
* While we can improve performance, we will also have different expected results.



<br><hr>

## 🟥 7.5.1 Creating Parallel Streams
* We can create parallel streams in two ways
1) `parallel()` - we can convert an existing stream by calling this method:
```java
Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6).stream();
Stream<Integer> parallelStream = stream.parallel();
```
2) `parallelStream()` - we can convert a collection using this method:
```java
Stream<Integer> parallelStream =
    Arrays.asList(1,2,3,4,5,6).parallelStream();
```


<br><hr>

## 🟥 7.5.2 Processing Tasks in Parallel
* Using a parallel stream means results are no longer determinent. E.g. the following code will have different outputs at each run:
```java
Arrays.asList(1,2,3,4,5,6)
    .parallelStream()
    .forEach(s->System.out.print(s+" "));
// 3 6 5 1 2 4
```

### 🟡 Ordering `forEach` Results
* We can force a parallel stream to process results in order:
```java
Arrays.asList(1,2,3,4,5,6)
    .parallelStream()
    .forEachOrdered(s->System.out.println(s+" "));
// 1 2 3 4 5 6
```

### 🟡 Understanding Performance Improvements
* Suppose we have to process 4000 records, each record takes 10ms to finish.
* We can simulate this with the following program:
```java
public class WhaleDataCalculator {
    public int processRecord(int input) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // Handle interrupted exception
        }
        return input+1;
    }
    public void processAllData(List<Integer> data) {
        data.stream().map(a->processRecord(a));
    }
    public static void main() {
        WhaleDataCalculator calculator = new WhaleDataCalculator();
        // define data:
        List<Integer> data = new ArrayList<Integer>();
        for(int i=0;i<4000;i++) data.add(i);
        // process data:
        long start = System.currentTimeMillis();
        calculator.processAllData(data);
        double time = (System.currentTimeMillis()-start)/1000.0;
        // report results:
        System.out.println("\nTasks completed in: "+time+" seconds");
    }
}
```
* This program will take 40 seconds on average
* If we update the `processRecord()` method to:
```java
public void processAllData(List<Integer> data) {
    data.parallelStream().map(s->processRecord(a))
}
```
* It took 10 seconds

### 🟡 Understanding Independent Operations
* We should use parallel streams whenever the operation is independent of the subsequent operation.
* E.g. suppose we want to make all elements of a stream uppercase:
```java
Arrays.asList("jackal","kangaroo","lemur")
    .parallelStream()
    .map(s -> s.toUpperCase())
    .forEach(System.out::println);
```
* As this is a parallel stream, the order of the printing is not guaranteed
* Suppose we have an imbedded print statement in map operation:
```java
Arrays.asList("jackal","kangaroo","lemur")
    .parallelStream()
    .map(s -> {System.out.println(s); return s.toUpperCase();})
    .forEach(System.out::println);
```
* This will output an indetermined result like:
```
kangaroo
lemur
LEMUR
jackal
KANGAROO
JACKAL
```
### 🟡 Avoiding Stateful Operations
* **Stateful lambda expressions** is an expression whose result id dependent on any state which may change in the pipeline.
* E.g. consider the following:
```java
List<Integer> data = Collections.synchronizedList(new ArrayList<>());
Arrays.asList(1,2,3,4,5,6)
    .parallelStream()
    .map(i -> {data.add(i);return i})
    .forEachOrdered(i->System.out.print(" "));
// PRINTS: 1 2 3 4 5 6
System.out.println(data);
// PRINTS 1 6 3 4 2 5
```
* Stateful operations should be avoided when using parallel streams!

<br><hr>

## 🟥 7.5.3 Processing Parallel Reductions
* **Parallel Reductions** are reduction operations on parallel streams.

### 🟡 Performing Order-Based Tasks
* When we use the `findAny()` on a serial stream, then the first element is called:
```java
int x = Arrays.asList(1,2,3,4,5,6).stream().findAny().get();
System.out.println(x);
```
* But if we use a parallel stream, the result can not be determined:
```java
int x = Arrays.asList(1,2,3,4,5,6).parallelStream().findAny().get();
// prints 4 on my machine
```

### 🟡 Combining Results with `reduce()`
* The stream operation `reduce(U identity, BiFunction accumulator, BinaryOperator combiner)` combines a stream into a single object.
* E.g. concatenating a String:
```java
String str = Arrays.asList('w','o','l','f')
    .stream()
    .reduce("", (partial,c)->partial+c,(x,y)->x+y);
// wolf
```
* If elements are reduced in pairs to create intermediate values in a parallel way - this could lead to unexpected behavior.
* The Stream API still allows for parallel processing provided the arguments satisfy the requirements:
1) The identity can be applied to all elements, u, such that `combiner(u)=u`
2) The accumulator, op, must be associative: `(a op b) op c` = `a op (b op c)`
3) The combiner must me associative and stateless such that: `combiner.apply(u,accumulator.apply(identity,t)` = `accumulator.apply(u,t)` 

* Here is an example where the accumulator is not associative:
```java
Arrays.asList(1,2,3,4,5,6)
    .stream()
    .reduce(0, (a,b)->a-b);
// always is -21

Arrays.asList(1,2,3,4,5,6)
    .parallelStream()
    .reduce(0,(a,b)->(a-b)); // non associative
// can print either 3 or 21
```
* Here is an example where the identity can not be applied:
```java
Arrays.asList("w","o","l","f")
    .stream()
    .reduce("X", String::concat);
// prints Xwolf

Arrays.asList("w","o","l","f")
    .parallelStream()
    .reduce("X", String::concat);
// prints XwXoXlXf
```

### 🟡 Combining Results with `collect()`
* The Streams API has a 3 argument version of collect: `collect(Supplier<R> supplier, BiConsumer<R,R> accumulator, BiConsumer<R,R> consumer)`

* The supplier is used in place of identity; the previous requirements also apply here
* Here's an example:
```java
Stream<String> stream = Stream.of("w","o","l","f")
    .parallel();
SortedSet<String> set = stream
    .collect(ConcurrentSkipListSet::new,
             Set::add,
             Set::addAll);
System.out.println(set); // [f, l, o, w]
```
* We have the following requirements such that a parallel reduction with collect is done efficiently:
1) The stream is parallel
2) The parameter of the collect operation has the characteristic: `Collector.Characteristics.CONCURRENT`
3) Eithr the stream is unordered, or collector has the characteristic `Collector.Charactersics.UNORDERED`
* Here is an example:
```java
Stream<String> ohMy = Stream.of("lions","tigers","bears")
    .parallel();
ConcurrentMap<Integer, String> map =
    ohMy.collect(
        Collectors.toConcurrentMap(String::length,k->k,(s1,s2)->s1+","s2)
    );
// {5=lions,bears, 6=tigers}
// className: ConcurrentHashMap
```
* Here is an example of replacing `groupingBy()`:
```java
Stream<String> ohMy = Stream.of("lions","tigers","bears")
    .parallel();
ConcurrentMap<Integer,List<String>> map =
    ohMy.collect(Collectors.groupingByConcurrent(String::length));
// {5=[lions, bears], 6=[tigers]}
// className: ConcurrentHashMap
```