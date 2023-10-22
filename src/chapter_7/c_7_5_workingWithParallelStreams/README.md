<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 7.5 Workking with Parallel Streams
* Streams have built in concurrency options. So far all the streams we have seen were `serial streams` - results are ordered and entries can only be processed one at a time.
* A **parallel stream** is able to processed concurently with multuple threads.
* You can use a parallel stream and the `map()` method to concurrently operated on elements in the stream.
* Parallel streams can improve performance as well as change expected results.

## 🟥 7.5.1 Creating Parallel Streams
* For the exam, I need to be aware of the following two methods for creating parallel streams:
1) `parallel()` - you can call `parallel` on an existing serial stream:
```java
Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6).stream();
Stream<Integer> parallelStream = stream.parallel();
```
2) `parallelStream()` - we can call `parallelStream()` on any `Collection` implementation (the interface includes this method):
```java
Stream<Integer> parallelStream = Arrays.asList(1,2,3,4,5,6).parallelStream();
```

<hr>

## 🟥 7.5.2 Processing Tasks in Parallel

* Parallel streams can have unexpected results:
```java
Arrays.asList(1,2,3,4,5,6)
    .parallelStream()
    .forEach(s->System.out.println(s+ " "));
```
* This can generate the following:
```
4 1 6 2 3 5
5 2 1 6 3 4
1 2 4 5 6 3
```

### 🟡 Ordering `forEach` Results
* The Streams API includes a `forEachOrdered()` method which forces parallel stream to process result in order with a performance hit:
```java
Arrays.asList(1,2,3,4,5,6)
    .parallelStream()
    .forEachOrdered(s->System.out.println(s+ " "));
```

### 🟡 Understanding Performance Improvements
* We have a task which requires processing 4,000 records which take 10 milliseconds to finish. Here is an application which simulates this:
```java
import java.util.*;

public class WhaleDataCalculator {

    public int processRecord(int input) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            
        }
        return input+1;
    }

    public void processAllData(List<Integer> data) {
        data.stream().map(a -> processRecord(a)).count();
    }

    public static void main(String[] args) {
        WhaleCalculator calculator = new WhaleCalculator();

        // define the data
        List<Integer> data = new ArrayList<>();
        for(int i=0;i<4000;i++) data.add(i);

        // process data
        long start = System.currentMillis();
        calculator.processAllData(data);
        double time = (System.currentTimeMillis()-start)/1000.0;

        // Report results
        System.out.println("\nTasks completed in: "+time+" seconds");
    }
}
```
* This will take 40 seconds to complete.
* We can make this a parallel stream by processing the results concurrently:
```java
public void processAllData(List<Integer> data) {
    data.parallelStream().map(a->processRecord(a)).count();
}
```
* Depending on the number of CPUs available, the task can be completed in roughly 10 seconds.
* We can improve performance by scaling the number of processors - this property is called **scaling**🎃
* It's not always beneficial to use parallel stream, for small streams its faster to do serial streams as parallel streams have cost of setting up and allocating🫰

### 🟡 Understanding Independent Operations
* Parallel Streams rely on the propery that many stream operations can be executed independently to improve performance.
* In the above example, the `processRecord()` can be executed seperately without impacting the invocation of the method on other pieces of the stream.
* Here's an example which maps the stream contents to uppercase Strings:
```java
Arrays.asList("jackal","kangaroo","lemur")
    .parallelStream()
    .map(s -> s.toUpperCase())
    .forEach(System.out::println);
```
* Many common streams including `map()`, `forEach()`, and `filter()` can be processed independently but order is never guaranteed.
```java
Arrays.asList("jackal","kangaroo","lemur")
    .parallelStream()
    .map(s -> {System.out.println(s); return s.toUpperCase();})
    .forEach(System.out::print)
```
* This example has an embedded print statement, as the results are not ordered and the print can occurs even before intermediate operations:
```
kangaroo
KANGAROO
lemur
jackal
JACKAL
LEMUR
```

### 🟡 Avoiding Stateful Operations
* Side effect can appear in parallel statements, if the lambda expression is stateful
* A **stateful lambda expression** is one whose result is dependent on any state which may change during execution of a pipeline
* We should avoid stateful lambda expressions, as demonstrated in this example:
```java
List<Integer> data = Collections.synchronizedLise(new ArrayList<>());
Arrays.asList(1,2,3,4,5,6).parallelStream()
    .map(i-> {data.add(i); return i;})
    .forEachOrdered(i -> System.out.print(i+" "));

System.out.println();
for (Integer e: data) {
    System.out.print(e+" ");
}
```
* Here is a sample generated by this code:
```
1 2 3 4 5 6
2 4 3 5 6 1
```

<hr>


## 🟥 7.5.3 Processomg Parallel Reductions
* Using parallel streams leads to improved performance and changes to the design of you application.
* **Parallel reductions** are reduction operations on parallel streams.

### 🟡 Performing Order-Based Tasks
* Due to order not being guaranteed, methods like `findAny()` on parallel streams may result in unexpected behavior.
* The following will always print 1
```java
System.out.println(Arrays.asList(1,2,3,4,5,6).stream().findAny().get());
```
* With parallel stream, the result is undefined:
```java
System.out.println(Arrays.asList(1,2,3,4,5,6).parallelStream().findAny().get());
```
* Stream operations like `findFirst()`, `limit`, `skip` can be slower in parallel environment dues to this task veing forced to coordinate all of its threads in synchronized-like fashion.

<br>

### 🟡 Combining Results with `reduce()`
* The `reduce()` method combines a stream into a single object. This method takes an `identity`, `accumulator`, and `combiner`
* E.g here's concatenation of a string:
```java
String s = Arrays.asList('w','o','l','f')
    .stream()
    .reduce("", (c,s1)->c+s1, (x,y)->x+y);
```
* If we did this using a parallel stream, we could have w+o, l+f being formed. With a serial stream, the string is built one character at a time.
* The Stream API has a way of preventing issues from occuring as a result of elements being in wrong order. The `reduce()` operation must adhere to the following properties:
1) `identity` must be defined such for all elements in the stream u, `combiner.apply(identity,u)` = `u`
2) `accumulator` operator op must be statless and associative - `(a op b) op c` = `a op (b op c)`
3) `combiner` must be associative, stateless and compatible with identity, such that for all u and t: `combiner.apply(u, accumulator.apply(identity,t))` = `accumulator.apply(u,t)`

* Here is an example of using a non-associative accumulator:
```java
long l = Arrays.asList(1,2,3,4,5,6)
    .parallelStream()
    .reduce(0,(a,b) -> (a-b)); // NOT ASSOCIATIVE ACCUMULATOR
```
* This will print -21, 3 or some other value! A serial stream will always print -21!
* Here's an example with violates the rule on the identity:
```java
System.out.println(Arrays.asList("w","o","l","f")
    .parallelStream()
    .reduce("X",String::concat));
```
* The output is `XwXoXlXf``

<br>

### 🟡 Combining Results with `collect()`
* The Streams API includes a 3 argument version of collect() which takes accumulator and combiner operators, and a supplier operator
* The accumulator and combiner operators need to be stateless and associative, and the combiner operation being compatible with the accumulator operator
* Here's a 3 argument version of collect on a parallel stream:
```java
Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add,
    Set::addAll);
```
* A concurrent collection must be used to combine the results, ensuring ConcurrentModificationException does not occur.

#### 🟢 Using the One-Argument collect() Method
* The one argument version of collect() takes a collector as argument:
```java
Stream<String> stream = Stream.of("w","o","l","f").parallel();
Set<String> set = stream.collect(Collectors.toSet());
System.out.println(set); // [f, w, l, o]
```
* Doing a parallel reduction requires additional considerations, e.g. if you want to preserve the ordering of the original set, you need to use something like `List` which reduces performance, as some operations are unable to be completed in parallel.
* The following rules ensure that a parallel reduction will be performed efficiently in Java using a collector:
1) Stream is parallel
2) The collector parameter has the `Collector.Characteristics.CONCURRENT` characteristic
3) Either stream is unordered, or collector has `Collector.Characteristics.UNORDERED` characteristic
* Any class which implements the `Collector` interface includes a characteristics() method which returns a set of attribute available to the collector.
* E.g. `Collectors.toSet()` has the `UNORDERED` characteristic but not `CONCURRENT` - hence the above example is not a concurrent reduction
* The `Collectors` class includes two sets of methods for retrieving collectors which are both `CONCURRENT` and `UNORDERED`:
1) `Collectors.toConcurrentMap()`
2) `Collectors.groupingByConcurrent()`
* Here is an example of using `toConcurrentMap()`:
```java
Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
ConcurrentMap<Integer, String> map = ohMy
    .collect(Collectors.toConcurrentMap(String::length, k -> k, 
        (s1,s2)->s1+","+s2));
System.out.println(map); // 5=lions,bears, 6=tigers
System.out.println(map.getClass()); // java.util.concurrent.ConcurrentHashMap
```
* The particular class is not guaranteed, only that the class is a `ConcurrentMap` implementation!
* Here's an example of using `groupingBy()`:
```java
Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
ConcurrentMap<Integer, List<String>> map = ohMy
    .collect(Collectors.groupingByConcurrent(String::length));
System.out.println(map); // {5=[lions, bears], 5=[tigers]}
```