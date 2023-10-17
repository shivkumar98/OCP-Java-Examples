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
* We can improve performance by scaling the number of processors - this property is called **scaling**

### 🟡 Understanding Independent Operations

### 🟡 Avoiding Stateful Operations

## 🟥 7.5.3 Processomg Parallel Reductions
