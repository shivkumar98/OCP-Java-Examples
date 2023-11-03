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


<hr>

## 🟥 7.5.2 Processing Tasks in Parallel

### 🟡 Ordering `forEach` Results

### 🟡 Understanding Performance Improvements

### 🟡 Understanding Independent Operations

### 🟡 Avoiding Stateful Operations


<hr>

## 🟥 7.5.3 Processomg Parallel Reductions

### 🟡 Performing Order-Based Tasks


### 🟡 Combining Results with `reduce()`

### 🟡 Combining Results with `collect()`