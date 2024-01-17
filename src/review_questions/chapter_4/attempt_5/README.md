<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 4: Review Questions - Attempt 5

## Results:

Date:  <br>
Score: /20 <br>

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
* `stream = ["", "1", "11", "111", ...]`
* stream.limit(2) = ["", "1"]
* map => ["2", "12"]
* It will print a stream pipeline
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

A. `true` `false` <br>
B. `true` `true` <br>
C. `java.util.stream.ReferencePipeline$3@4517d9a3` <br>
D. The code does not compile <br>
E. An exception is thrown <br>
F. The code hangs <br>
❓

### My Answer:
* `stream1` = ["growl!", "growl!", ...]
* `stream2` = ["growl!", "growl!", ...]
* b1 checks if any of the elements match the pred, this will be true
* b2 checks if all match the pred, this will cause the code to hang I THINK
* **F**
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
A. `false true` <br>
B. `false false` <br>
C. `java.util.stream.ReferencePipeline$3@4517d9a3` <br>
D. The code does not compile <br>
E. An exception is thrown <br>
F. The code hangs <br>
❓

### My Answer:
* stream = [-, --, ----, ...]
* b1 checks if none of the stream elements have a length > 3. This will be false
* b2 checks if there are any elements which match which is true
* **B**
<hr>

## 🟧 Question 4:

❓Which are true statements about terminal operations in a stream?

A. At most one terminal operation can exist in a stream pipeline <br>
B. Terminal operations are a required part of the stream pipeline in order to get a result <br>
C. Terminal operations must have `Stream` as the return type. <br>
D. The referenced `Stream` may be used after the calling a terminal operation <br>
E. The `peek()` method is an example of a terminal operation <br>
❓

### My Answer:
* A - false, you can have multiple operations likke filter and map
* B - true
* C - false, they can return any type
* D - false
* E - false
* **B**

<hr>

## 🟧 Question 5

❓ Which terminal operations on the `Stream` class are reductions?❓

A. collect() <br>
B. count() <br>
C. findFirst() <br>
D. map() <br>
E. peek() <br>
F. sum() <br>

### My Answer:
* Reduces account for all elements, and return a single element
* A - true, i THINK
* B - true
* C - false
* D - false, not a single result
* E - false
* F - true
* **B,F**
<hr>

## 🟧 Question 6:

❓Which of the following can fill in the blank so that the code prints out `false`❓

```java
Stream<String> s = Stream.generate(()->"meow");
boolean match = s._______(String::isEmpty);
System.out.println(match);
```

A. `allMatch` <br>
B. `anyMatch` <br>
C. `findAny` <br>
D. `findFirst` <br>
E. `noneMatch` <br>
F. None of the above <br>

### My Answer:
* A - true
* B - false, the code will hang
* C - false, the code will hang
* D - false, code will hang
* E - false, code will hang
* F - false
* **A**
<hr>


## 🟧 Question 7

❓We have a method that returns a sorted list without changing the original. Which of the following can replace the method implementation to do the same with streams?

```java
private static List<String> sort(List<String> list) {
    List<String> copy = new ArrayList<>(list);
    Collectors.sort(copy, (a,b)->b.compareTo(a));
    return copy;
}
```

A. 
```java
return list.stream()
    .compare((a,b)->b.compareTo(a))
    .collect(Collectors.toList());
```
B. 
```java
return list.stream()
    .compare((a,b)->b.compareTo(a))
    .collect(Collectors.toList());
```
D. 
```java
return list.stream()
    .compareTo((a,b)->b.compareTo(a))
    .sort();
```
E. 
```java
return list.stream()
    .sorted((a,b)-> b.compareTo(a))
    .collect();
```
F. 
```java
return list.stream()
    .sorted((a,b)->b.compareTo(a))
    .collect(Collectors.toList());
```

### My Answer:
* I would write `list.stream().compare((a,b)->b.compareTo(a)).collect(Collectors.toList())`
* A - valid
* B - false, this would return a stream I THINK
* C - invalid, I don't think `compareTo` is an operation
* D - invalid
* E - false, sorted is not an operation I THINK
* F - invalid as above
* **A**
<hr>


## 🟧 Question 8:

❓Which of the following are true given the declaration `IntStream is = IntStream.empty()` (Choose all that apply)❓

A. `is.average()` returns the type `int` <br>
B. `is.average()` returns the type `OptionalInt` <br>
C. `is.findAny()` returns the type `int` <br>
D. `is.findAny()` returns the type `OptionalInt` <br>
E. `is.sum()` returns the type `int` <br>
F. `is.sum()` returns the type `OptionalInt` <br>

### My Answer:
* `is.average()` will return an OptionalDouble
* `is.findAny()` will return OptionalInt
* `is.sum()` will return int
* **D,E**
<hr>


## 🟧 Question 9

❓Which of the following can we add line 5 for the code to run without error and not produce any output? (Choose all that apply)❓

```java
4:  LongStream ls = LongStream.of(1,2,3);                           
5:  OptionalLong opt = ls.map(n -> n * 10).filter(n -> n < 5).findFirst();  
```

A. `if (opt.isPresent()) System.out.println(opt.get());` <br>
B. `if (opt.isPresent()) System.out.println(opt.getAsLong());` <br>
C. `opt.ifPresent(System.out.println);` <br>
D. `opt.ifPresent(System.out::println)` <br>
E. None of these; the code does not compile <br>
F. None of these; line 5 throws an exception <br>

### My Answer:
* `ls` is mapped to `[10,20,30]` => [] 
* A - false, the opt has a `getAsLong()` method
* B - true
* C - false, invalid syntax
* D - valid
* E - false
* F - false
* **B,D**
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

A. `L, N` <br>
B. `L, N, O` <br>
C. `L, N, M` <br>
D. `L, N, M, O` <br>
E. `L, O, M` <br>
F. `N, M` <br>
G. `N, O` <br>

### My Answer:
* stream = ["", "", "", ""]
* The filter will remove everything
* The forEach will print all elements
* The peek will peek at the last element of the stream
* A - this will not output anything, FALSE
* B - this will not output anything, FALSE
* C - The filter will remove everything, FALSE
* D - this will filter everything, FALSE
* E - false as above
* F - valid
* G - false, will only output once
* **F**
<hr>

## 🟧 Question 11

❓What changes need to be made for this code to print the string `12345` (choose all that apply)❓
```java
Stream.iterate(1, x->x++).limit(5).map(x -> x).collect(Collectors.joining());
```

A. Change `Collectors.joining()` to `Collectors.joining("")` <br>
B. Change `map(x -> x)` to `map(x -> "" + x)` <br>
C. change `x -> x++` to `x -> ++x` <br>
D. Add `forEach(System.out::print)` after the call to `collect()` <br>
E. Wrap the entire line in a `System.out.print` statement <br>
F. None of the above. The code already prints "12345" <br>

### My Answer:
* `stream = [1, 1, 1, 1 , 1]`
* We need the iterator to pre-increment
* We need to create a string, so we can change the map to convert to string
* The joining() method needs a value
* The collect() method will reduce the stream, so forEach would not work - You need to wrap it entirely in System.out.print
* **A,B,C,E**
<hr>


## 🟧 Question 12:

❓What functional interfaces complete the following code? (Choose all that apply)❓

```java
6: ______ x = String::new; 
7: ______ y = (a,b) -> System.out.println();
8: ______ z = a -> a+a;
```

A. `BiConsumer<String, String>` <br>
B. `BiFunction<String, String>` <br>
C. `BinaryConsumer<String, String>` <br>
D. `BinaryFunction<String, String>` <br>
E. `Consumer<String>` <br>
F. `Supplier<String>` <br>
G. `UnaryOperator<String>` <br>
H. `UnaryOperator<String, String>`  <br>

### My Answer:
* x can be a consumer
* z can be a function, or a BinaryOperator
* A - can be appliued to y
* B - can not be applied, I THINK
* C - false, does not exist
* D - false, does not exist
* E - true, can be applied to x
* F - true can be applied to x
* G - true can be applied to z
* H - false, does not exist
* **A,B,E,F,G**
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

A. The code compiles and prints `123456`

B. The code compiles and prints `234567`

C. The code compiles but does not print anything

D. The code compiles but prints stream references

E.  The code runs infinitely

F. The code does not compile

G. The code throws an exception

### My Answer:

<hr>

## 🟧 Question 14: 

❓Which of the following is true❓

```java
4: Stream<Integer> s = Stream.of(1);
5: IntStream is = s.mapToInt(x -> x);
6: DoubleStream ds = s.mapToInt(x -> x);
7: Stream<Iteger> s2 = ds.mapToInt(x -> x);
8: s2.forEach(System.out::print);
```

A. Line 4 does not compile

B. Line 5 does not compile

C. Line 6 does not compile

D. Line 7 does not compile

E. Line 8 does not compile

F. The code throws an exception

G. The code compiles and prints 1.

### My Answer:

<hr>

## 🟧 Question 15 

❓The `partitioningBy()` collector creates a `Map<Boolean, List<String>>` when passed to `collect()` by default. When specific parameters are passed to `partioningBy()`, which return types can be created? (Choose all that apply)❓

A. `Map<boolean, List<String>>`

B. `Map<Boolean, Map<String>>`

C. `Map<Long, TreeSet<String>>`

D. `Map<Boolean, List<String>>`

E. `Map<Boolean, Set<String>>`

F. None of the above

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
```

A. `{} {}`

B. `{} {false=[], true=[]}`

C. `{false=[], true=[]} {}`

D. `{false=[], true=[]} {false=[], true=[]}`

E. The code does not compile

F. An exception is thrown

### My Answer:

<hr>

## 🟧 Question 17

❓Which of the following is equivalent to this code❓

```java
UnaryOperator<Integer> u = x -> x * x;
```

A. `BiFunction<Integer> f = x -> x*x;`

B. `BiFunction<Integer, Integer> f = x -> x*x;`

C. `BinaryOperator<Interger, Integer> f = x -> x*x;`

D. `Function<Integer> f = x -> x*x;`

E. `Function<Integer, Integer> f = x -> x*x;`

F. None of these above

### My Answer:

<hr>

## 🟧 Question 18

❓What is the result of the following❓

```java
DoubleStream s = DoubleStream.of(1.2, 2.4);
s.peek(System.out.::println).filter(x -> x > 2).count();
```

A. 1

B. 2

C. 2.4

D. 1.2 and 2.4

E. There is no output

F. The code does not compile

G. An exception is thrown

### My Answer:

<hr>
## 🟧 Question 19

❓Which of the following return primitives❓

A. `BooleanSupplier`

B. `CharSupplier`

C. `DoubleSupplier`

D. `FloatSupplier`

E. `IntSupplier`

F. `StringSupplier`
## 🟧 Question 20

❓What is the simplest way of rewriting this code❓

```java
List<Integer> l = IntStream.range(1,6)
    .mapToObj(i -> i).collect(Collectors.toList());
l.forEach(System.out::println);
```

A. 
```java
IntStream.range(1,6);
```

B. 
```java
IntStream.range(1,6)
    .forEach(System.out::println);`
```

C. 
```java
IntStream.range(1,6)
    .mapToObj(i->i)
    .forEach(System.out::println);
```

D. None of the above is equivalent

E. The provided code does not compile

### My Answer:

<hr>