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

## 🟥 7.5.3 Processomg Parallel Reductions
