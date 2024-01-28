<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 4: Review Questions - Attempt 6

## Results:

Date:  <br>
Score: /20 <br>
❌✅
| Question # | Correct |
| ---------- | ------- |
| 1          |         |
| 2          |         |
| 3          |         |
| 4          |         |
| 5          |         |
| 6          |         |
| 7          |         |
| 8          |         |
| 9          |         |
| 10         |         |
| 11         |         |
| 12         |         |
| 13         |         |
| 14         |         |
| 15         |         |
| 16         |         |
| 17         |         |
| 18         |         |
| 19         |         |
| 20         |         |


<hr>

## 🟧 Question 1

❓ What is the output of the following?
```java
Stream<String> stream = Stream.iterate("", (s)->s+"1"));
System.out.println(stream.limit(2).map(x->x+"2"));
```

A. 12112 <br>
B. 212 <br>
C. 212112 <br>
D. java.util.stream.ReferencePipeline$3@4517d9a3 <br>
E. The code does not compile <br>
F. An exception is thrown <br>
G. The code hangs <br>

### My Answer:
* stream = ["", "1", "11", "111", ...]
* stream = ["", "1"]
* stream = "["2", "12"]
* Printing a stream will give you a memory reference
* **D**
<hr>

## 🟧 Question 2:

❓ What is the output of:

```java
Predicate<? super String> predicate = s -> s.startsWith("g");
Stream<String> stream1 = Stream.generate(() -> "growl! ");
Stream<String> stream2 = Stream.generate(() -> "growl! ");
boolean b1 = stream1.anyMatch(predicate);
boolean b2 = stream2.allMatch(predicate);
System.out.println(b1 + " "+ b2);
```

* A. `true` `false` <br>
* B. `true` `true` <br>
* C. `java.util.stream.ReferencePipeline$3@4517d9a3` <br>
* D. The code does not compile <br>
* E. An exception is thrown <br>
* F. The code hangs <br>
❓

### My Answer:
* stream1 = ["growl!", "growl!",...]
* b1 is true as the first element matches
* b2 will hang as it will look at all elements to see if they begin with g
* **D**
<hr>


## 🟧 Question 3

❓What is the output of the following:
```java
Predicate<? super String> predicate = s -> s.length() > 3;
Stream<String> stream = Stream.iterate("-", (s)->s+s);
boolean b1 = stream.noneMatch(predicate);
boolean b2 = stream.anyMatch(predicate);
System.out.println(b1 + " "+ b2);
```
* A. `false true` <br>
* B. `false false` <br>
* C. `java.util.stream.ReferencePipeline$3@4517d9a3` <br>
* D. The code does not compile <br>
* E. An exception is thrown <br>
* F. The code hangs <br>
❓

### My Answer:
* b1 will be false
* b2 will throw an exception as you are calling a terminal operation twice on the same stream
* **E**
<hr>

## 🟧 Question 4:

❓Which are true statements about terminal operations in a stream?

* A. At most one terminal operation can exist in a stream pipeline <br>
* B. Terminal operations are a required part of the stream pipeline in order to get a result <br>
* C. Terminal operations must have `Stream` as the return type. <br>
* D. The referenced `Stream` may be used after the calling a terminal operation <br>
* E. The `peek()` method is an example of a terminal operation <br>
❓

### My Answer:
* A - true
* B - true
* C - false, they can return boolean, objects, collections
* D - false
* E - false, this is an intermediate operation
* **A,B**
<hr>

## 🟧 Question 5

❓ Which terminal operations on the `Stream` class are reductions?❓

* A. collect() <br>
* B. count() <br>
* C. findFirst() <br>
* D. map() <br>
* E. peek() <br>
* F. sum() <br>

### My Answer:
* A - true
* B - true
* C - false
* D - false, this is an intermediate operation
* E - false, intermediate
* F - false, this is not a method available to stream class!
* **A,B**
<hr>

## 🟧 Question 6:

❓Which of the following can fill in the blank so that the code prints out `false`❓

```java
Stream<String> s = Stream.generate(()->"meow");
boolean match = s._______(String::isEmpty);
System.out.println(match);
```

* A. `allMatch` <br>
* B. `anyMatch` <br>
* C. `findAny` <br>
* D. `findFirst` <br>
* E. `noneMatch` <br>
* F. None of the above <br>

### My Answer:
* A - true, this will print false
* B - false, this will hang
* C - false, this can not take a parameter I THINK
* D - false, this method does not take a parameter
* E - false, this will print true
* F - false
* **A**
<hr>


## 🟧 Question 7
❓We have a method that returns a sorted list without changing the original. Which of the following can replace the method implementation to do the same with streams?

```java
private static List<String> sort(List<String> list) {
    List<String> copy = new ArrayList<>(list);
    Collections.sort(copy, (a,b)->b.compareTo(a));
    return copy;
}
```

* A. 
```java
return list.stream()
    .compare((a,b)->b.compareTo(a))
    .collect(Collectors.toList());
```
* B. 
```java
return list.stream()
    .compare((a,b)->b.compareTo(a))
    .collect(Collectors.toList());
```
* D. 
```java
return list.stream()
    .compareTo((a,b)->b.compareTo(a))
    .sort();
```
* E. 
```java
return list.stream()
    .sorted((a,b)-> b.compareTo(a))
    .collect();
```
* F. 
```java
return list.stream()
    .sorted((a,b)->b.compareTo(a))
    .collect(Collectors.toList());
```

### My Answer:
* The stream class has a sorted method which takes a comparator
* E is false as you need to provide a collector
* F is true
* **F**
<hr>


## 🟧 Question 8:

❓Which of the following are true given the declaration `IntStream is = IntStream.empty()` (Choose all that apply)❓

* A. `is.average()` returns the type `int` <br>
* B. `is.average()` returns the type `OptionalInt` <br>
* C. `is.findAny()` returns the type `int` <br>
* D. `is.findAny()` returns the type `OptionalInt` <br>
* E. `is.sum()` returns the type `int` <br>
* F. `is.sum()` returns the type `OptionalInt` <br>

### My Answer:
* `.average()` returns an OptionalDouble
* `is.findAny()` returns an OptionalInt
* `is.sum()` returns an int
* **D,E**
<hr>


## 🟧 Question 9

❓Which of the following can we add line 5 for the code to run without error and not produce any output? (Choose all that apply)❓

```java
4:  LongStream ls = LongStream.of(1,2,3);                           
5:  OptionalLong opt = ls.map(n -> n * 10).filter(n -> n < 5).findFirst();  
```

* A. `if (opt.isPresent()) System.out.println(opt.get());` <br>
* B. `if (opt.isPresent()) System.out.println(opt.getAsLong());` <br>
* C. `opt.ifPresent(System.out.println);` <br>
* D. `opt.ifPresent(System.out::println)` <br>
* E. None of these; the code does not compile <br>
* F. None of these; line 5 throws an exception <br>

### My Answer:

<hr>


## 🟧 Question 10

❓ Select from the following statements and indicate the order in which they would appear to output 10 lines:❓

```java
Stream.generate(()-> "");
L:  .filter(x -> x.length() > 1)  
M:  .forEach(System.out::println)
N:  .limit(10)                    
O:  .peek(System.out::println)
;
```

* A. `L, N` <br>
* B. `L, N, O` <br>
* C. `L, N, M` <br>
* D. `L, N, M, O` <br>
* E. `L, O, M` <br>
* F. `N, M` <br>
* G. `N, O` <br>

### My Answer:
* Anything with L will be wrong
* We need N
* F - true
* G - false, peek is intermediate
* **F**
<hr>

## 🟧 Question 11

❓What changes need to be made for this code to print the string `12345` (choose all that apply)❓
```java
Stream.iterate(1, x->x++).limit(5).map(x -> x).collect(Collectors.joining());
```

* A. Change `Collectors.joining()` to `Collectors.joining("")` <br>
* B. Change `map(x -> x)` to `map(x -> "" + x)` <br>
* C. change `x -> x++` to `x -> ++x` <br>
* D. Add `forEach(System.out::print)` after the call to `collect()` <br>
* E. Wrap the entire line in a `System.out.print` statement <br>
* F. None of the above. The code already prints "12345" <br>

### My Answer:
 * The joining needs a parameter of ""
 * We need C
 * We need to convert the number to a string so we need B
 * We need E
 * **B,C,E**
<hr>


## 🟧 Question 12:

❓What functional interfaces complete the following code? (Choose all that apply)❓

```java
6: ______ x = String::new; 
7: ______ y = (a,b) -> System.out.println();
8: ______ z = a -> a+a;
```

* A. `BiConsumer<String, String>` <br>
* B. `BiFunction<String, String>` <br>
* C. `BinaryConsumer<String, String>` <br>
* D. `BinaryFunction<String, String>` <br>
* E. `Consumer<String>` <br>
* F. `Supplier<String>` <br>
* G. `UnaryOperator<String>` <br>
* H. `UnaryOperator<String, String>`  <br>

### My Answer:
* x is a supplier so F is true
* y is a consumer with 2 arguments applied, so A
* z is a Function or UnaryOperator, so its H
* **A,F,H**
<hr>


## 🟧 Question 13

❓Which of the following is true❓

```java
List<Integer> l1 = Arrays.asList(1,2,3);
List<Integer> l2 = Arrays.asList(4,5,6);
List<Integer> l3 = Arrays.asList();
Stream.of(l1, l2, l3).map(x -> x+1)
    .flatMap(x -> x.stream()).forEach(System.out::println);
```

* A. The code compiles and prints `123456` <br>
* B. The code compiles and prints `234567` <br>
* C. The code compiles but does not print anything <br>
* D. The code compiles but prints stream references <br>
* E.  The code runs infinitely <br>
* F. The code does not compile <br>
* G. The code throws an exception <br>

### My Answer:
 
<hr>

## 🟧 Question 14: 

❓Which of the following is true❓

```java
4: Stream<Integer> s = Stream.of(1);
5: IntStream is = s.mapToInt(x -> x);
6: DoubleStream ds = is.mapToDouble(x -> x);
7: Stream<Iteger> s2 = ds.mapToInt(x -> x);
8: s2.forEach(System.out::print);
```
(The book has a typo!!!)

* A. Line 4 does not compile <br>
* B. Line 5 does not compile <br>
* C. Line 6 does not compile <br>
* D. Line 7 does not compile <br>
* E. Line 8 does not compile <br>
* F. The code throws an exception <br>
* G. The code compiles and prints 1. <br>

### My Answer:
 
<hr>

## 🟧 Question 15 

❓The `partitioningBy()` collector creates a `Map<Boolean, List<String>>` when passed to `collect()` by default. When specific parameters are passed to `partioningBy()`, which return types can be created? (Choose all that apply)❓

* A. `Map<boolean, List<String>>` <br>
* B. `Map<Boolean, Map<String>>` <br>
* C. `Map<Long, TreeSet<String>>` <br>
* D. `Map<Boolean, List<String>>` <br>
* E. `Map<Boolean, Set<String>>` <br>
* F. None of the above <br>

### My Answer:
 
<hr>

## 🟧 Question 16 

❓What is the output of the following❓

```java
Stream<String> s = Stream.empty();
Stream<String> s2 = Stream.empty();
Map<Boolean, List<String>> p = s.collect(
    Collectors.partitionBy(b -> b.startsWith("c")));
Map<Boolean, List<String>> g = s.collect(
    Collectors.groupBy(b -> b.startsWith("c")));
System.out.println(p + " " + g);
```

* A. `{} {}`
* B. `{} {false=[], true=[]}`
* C. `{false=[], true=[]} {}`
* D. `{false=[], true=[]} {false=[], true=[]}`
* E. The code does not compile
* F. An exception is thrown

### My Answer:
 
<hr>

## 🟧 Question 17

❓Which of the following is equivalent to this code❓

```java
UnaryOperator<Integer> u = x -> x * x;
```

* A. `BiFunction<Integer> f = x -> x*x;`
* B. `BiFunction<Integer, Integer> f = x -> x*x;`
* C. `BinaryOperator<Interger, Integer> f = x -> x*x;`
* D. `Function<Integer> f = x -> x*x;`
* E. `Function<Integer, Integer> f = x -> x*x;`
* F. None of these above

### My Answer:
 
<hr>

## 🟧 Question 18

❓What is the result of the following❓

```java
DoubleStream s = DoubleStream.of(1.2, 2.4);
s.peek(System.out.::println).filter(x -> x > 2).count();
```

* A. 1
* B. 2
* C. 2.4
* D. 1.2 and 2.4
* E. There is no output
* F. The code does not compile
* G. An exception is thrown

### My Answer:
 
<hr>

## 🟧 Question 19

❓Which of the following return primitives❓

* A. `BooleanSupplier`
* B. `CharSupplier`
* C. `DoubleSupplier`
* D. `FloatSupplier`
* E. `IntSupplier`
* F. `StringSupplier`

### My Answer:
 
<hr>

## 🟧 Question 20

❓What is the simplest way of rewriting this code❓

```java
List<Integer> l = IntStream.range(1,6)
    .mapToObj(i -> i).collect(Collectors.toList());
l.forEach(System.out::println);
```

* A. 
```java
IntStream.range(1,6);
```
* B. 
```java
IntStream.range(1,6)
    .forEach(System.out::println);`
```
* C. 
```java
IntStream.range(1,6)
    .mapToObj(i->i)
    .forEach(System.out::println);
```
* D. None of the above is equivalent
* E. The provided code does not compile

### My Answer:
 
<hr>