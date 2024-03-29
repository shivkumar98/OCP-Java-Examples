<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 4: Review Questions Attempt 2

## Results:

Date: 10/07/2023
Score: 12/20

| Question # | Correct |
| ---------- | ------- |
| 1          |   ✅    |
| 2          |   ✅    |
| 3          |   ❌    |
| 4          |   ✅    |
| 5          |   ❌    |
| 6          |   ❌    |
| 7          |   ✅    |
| 8          |   ❌    |
| 9          |   ✅    |
| 10         |   ❌    |
| 11         |   ❌    |
| 12         |   ❌    |
| 13         |   ✅    |
| 14         |  ✅     |
| 15         |   ✅      |
| 16         |   ❌      |
| 17         |    ✅     |
| 18         |   ✅      |
| 19         |   ✅      |
| 20         |    ✅     |

<hr>

## Question 1

❓ What is the output of the following?
```java
Stream<String> stream = Stream.iterate("", (s)->s+"1"));
System.out.println(stream.limit(2).map(x->x+"2"));
```

A. 12112

B. 212

C. 212112

D. java.util.stream.ReferencePipeline$3@4517d9a3

E. The code does not compile

F. An exception is thrown

G. The code hangs

### MY ANSWER:

* A stream pipeline is printed, therefore answer is D
* ANSWER: D✅

### CORRECT ANSWER:

* D 


<hr>

## Question 2:

❓ What is the output of:

```java
Predicate<? super String> predicate = s -> s.startsWith("g");
Stream<String> stream1 = Stream.generate(() -> "growl! ");
Stream<String> stream2 = Stream.generate(() -> "growl! ");
boolean b1 = stream1.anyMatch(predicate);
boolean b2 = stream2.allMatch(predicate);
System.out.println(b1 + " "+ b2);
```
A. `true` `false`

B. `true` `true`

C. `java.util.stream.ReferencePipeline$3@4517d9a3`

D. The code does not compile

E. An exception is thrown

F. The code hangs
❓

### MY ANSWER:

* b1 wold be true
* b2 would hang
* ASNWER: F✅

### CORRECT ANSWER:
* F

<hr>

## Question 3

❓What is the output of the following:
```java
Predicate<? super String> predicate = s -> s.length() > 3;
Stream<String> stream = Stream.iterate("-", (s)->s+s);
boolean b1 = stream.noneMatch(predicate);
boolean b2 = stream.anyMatch(predicate);
System.out.println(b1 + " "+ b2);
```
A. `false true`
B. `false false`
C. `java.util.stream.ReferencePipeline$3@4517d9a3`
D. The code does not compile
E. An exception is thrown
F. The code hands
❓

### MY ANSWER:

* false, true
* ANSWER: A❌

### CORRECT ANSWER: E
* The code references the same stream twice


<hr>

## Question 4:

❓Which are true statements about terminal operations in a stream?

A. At most one terminal operation can exist in a stream pipeline

B. Terminal operations are a required part of the stream pipeline in order to get a result

C. Terminal operations must have `Stream` as the return type.

D. The referenced `Stream` may be used after the calling a terminal operation

E. The `peek()` method is an example of a terminal operation
❓

### MY ANSWER:

* A - true, B - true, C - false, D - false, E - false
* ANSWER: A, B✅

### CORRECT ANSWER: A, B

<hr>



## Question 5

❓ Which terminal operations on the `Stream` class are reductions?❓

A. collect()

B. count()

C. findFirst()

D. map()

E. peek()

F. sum()

### My Answer:

* A - not a reduction, B - reduction, C - not a reduction, map - nope, E - nope, sum - not available on Stream
* ANSWER: B❌

### CORRECT ANSWER: A, B
* collect IS a MUTABLE REDUCTION!

<br>



## Question 6:

❓Which of the following can fill in the blank so that the code prints out `false`❓

```java
Stream<String> s = Stream.generate(()->"meow");
boolean match = s._______(String::isEmpty);
System.out.println(match);
```

A. `allMatch`

B. `anyMatch`

C. `findAny`

D. `findFirst`

E. `noneMatch`

F. None of the above

### My answer:
* A - does not terminate, B - does not terminate, C - does not accept argument, D - does not accept argument, E - does not terminate, F - true
* MY ANSWER: F❌

### CORRECT ANSWER: A
* A does terminate!

<hr>


## Question 7

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
    .sort();
```

C. 

```java
return list.stream()
    .compareTo((a,b)->b.compareTo(a))
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

### MY ANSWER: F✅

### CORRECT ANSWER: F


## Question 8:

❓Which of the following are true given the declaration `IntStream is = IntStream.empty()` (Choose all that apply)❓

A. `is.average()` returns the type `int`

B. `is.average()` returns the type `OptionalInt`

C. `is.findAny()` returns the type `int`

D. `is.findAny()` returns the type `OptionalInt`

E. `is.sum()` returns the type `int`

F. `is.sum()` returns the type `OptionalInt`

### MY ANSWER:
* A - false, B - should return OptionalDouble, C - false, D - true, E - false, F - true
* ANSWER: D, F❌

### CORRECT ANSWER: D, E
* The sum() of empty list is 0 so its an int!

<hr>




## Question 9

❓Which of the following can we add line 5 for the code to run without error and non produce any output? (Choose all that apply)❓

```java
LongStream ls = LongStream.of(1,2,3);                           // LINE 4
OptionaolLong opt = ls.map(n->n*10).filter(n->n5).findFirst();  // LINE 5
```

A. `if (opt.isPresent()) System.out.println(opt.get());`

B. `if (opt.isPresent()) System.out.println(opt.getAsLong());`

C. `opt.ifPresent(System.out.println);`

D. `opt.ifPresent(System.out::println)`

E. None of these; the code does not compile

F. None of these; line 5 throws an exception 

### MY ANSWER:
* A - does not compile, B - true, C - does not compile, D - true, E - false, F - false
* ANSWER: B, D✅

### CORRECT ANSWER: B, D

<hr>

## Question 10

❓ Select from the following statements and indicate the order in which they would appear to output 10 lines:❓

```java
  Stream.generate(()-> "");
L:    .filter(x -> x.length() > 1)  
M:    .forEach(System.out::println)
N:    .limit(10)                    
O:    .peek(System.out::println)
;
```

A. L, N

B. L, N, O

C. L, N, M

D. L, N, M, O

E. L, O, M

F. N. M

G. N, O

### MY ANSWER:
* A - doesn't print anything
* B - nothing is printed
* C - nothing is printed
* D - nothing is printed
* E - filtered out
* F - true
* G - true
* ANSWER: F, G❌

### CORRECT ANSWER: F
* The stream is only evaluated if a terminal operation is called, so G is invalid


<br>

## Question 11

❓What changes need to be made for this code to print "12345" (choose all that apply)❓
```java
Stream.iterate(1, x->x++).limit(5).map(x -> x).collect(Collectors.joining);
```

A. Change `Collectors.joining()` to `Collectors.joining("")`

B. Change `map(x -> x)` to `map(x -> "" + x)`

C. change `x -> x++` to `x -> ++x`

D. Add `forEach(System.out::print)` after the call to `collect()`

E. Wrap the entire line in a `System.out.print` statement

F. None of the above. The code already prints "12345"

### MY ANSWER:
* A - this would justprint 11111
* B - this would work
* C - this is needed
* D - this would work
* E - this would not work
* F - false
* ANSWER: B,C,D❌

### CORRECT ANSWER: B, C, E
* You can not call forEach on a string so D is wrong!!!

<hr>

<br>

## Question 12:

❓What functional interfaces complete the following code? (Choose all that apply)❓

```java
6: ______ x = String::new; 
7: ______ y = (a,b) -> System.out.println();
8: ______ z = a -> a+a;
```

A. `BiConsumer<String, String>`

B. `BiFunction<String, String>`

C. `BinaryConsumer<String, String>`

D. `BiFunction<String, String>`

E. `Consumer<String>`

F. `Supplier<String>`

G. `UnaryOperator<String>`

H. `UnaryOperator<String, String>` 

### MY ANSWER:
* A - this would work
* B - not valid
* C - not valid
* D - not valid
* E - would work
* F - would work
* G - would work
* H - not valid
* ANSWER: A, E, F, G❌

### CORRECT ANSWER: A, F, G
* While Consumer does work, it would be a useless implementation

<hr>

## Question 13

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

### MY ANSWER:
* The code does not compile
* ANSWER: F✅

### CORRECT ANSWER: F

<hr>


## Question 14:

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

### MY ANSWER:
* A - line 4 does compile
* B - line 5 does compile
* C - line 6 does compile
* D - line 7 does not compile
* ANSWER: D✅

### CORRECT ANSWER: D

<hr>

## Question 15

❓The `partitioningBy()` collector creates a `Map<Boolean, List<String>>` when passed to `collect()` by default. When specific parameters are passed to `partioningBy()`, which return types can be created? (Choose all that apply)❓

A. `Map<boolean, List<String>>`

B. `Map<Boolean, Map<String>>`

C. `Map<Long, TreeSet<String>>`

D. `Map<Boolean, List<String>>`

E. `Map<Boolean, Set<String>>`

F. None of the above

### MY ANSWER:
* D and E ✅

### CORRECT ANSWER: D,E

<hr>

## Question 16

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

A. `{} {}`

B. `{} {false=[], true=[]}`

C. `{false=[], true=[]} {}`

D. `{false=[], true=[]} {false=[], true=[]}`

E. The code does not compile

F. An exception is thrown

### MY ANSWER:
* p is partitioned, so C and D would be correct.
* ANSWER: D❌


### CORRECT ANSWER: C
* groupingBy wil only generate the keys if they are needed!

<hr>

## Question 17

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

### MY ANSWER:
* A - not valid, B - not valid, C - not valid, D - not vaid, E - valid
* ANSWER: E✅

### CORRECT ANSWER: E

<hr>


## Question 18

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

### MY ANSWER
* ANSWER: D✅

### CORRECT ANSWER: D

<hr>


## Question 19

❓Which of the following return primitives❓

A. `BooleanSupplier`

B. `CharSupplier`

C. `DoubleSupplier`

D. `FloatSupplier`

E. `IntSupplier`

F. `StringSupplier`

### MY ANSWER:

* ANSWER: A, C, E✅

### CORRECT ANSWER: A, C, E

<hr>

## Question 20

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

### MY ANSWER:
* ANSWER: B✅

### CORRECT ANSWER: B


<hr>
