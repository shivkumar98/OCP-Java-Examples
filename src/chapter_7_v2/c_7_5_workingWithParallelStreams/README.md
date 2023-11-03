<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 7.5 Workking with Parallel Streams
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

## 🟥 7.5.3 Processomg Parallel Reductions

### 🟡 Performing Order-Based Tasks


### 🟡 Combining Results with `reduce()`

### 🟡 Combining Results with `collect()`