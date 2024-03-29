<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 4: Review Questions Attempt 3

## Results:

Date: 15/07/2023
Score: 16/20

| Question # | Correct |
| ---------- | ------- |
| 1          |   ✅    |
| 2          |    ✅   |
| 3          |  ✅     |
| 4          | ✅      |
| 5          |  ❌     |
| 6          |  ✅     |
| 7          |   ✅    |
| 8          |    ❌   |
| 9          | ✅      |
| 10         |  ❌     |
| 11         |  ❌     |
| 12         |  ✅     |
| 13         |  ✅     |
| 14         |   ✅    |
| 15         |   ✅     |
| 16         |  ✅      |
| 17         |  ✅     |
| 18         |  ✅      |
| 19         |  ✅     |
| 20         |   ✅    |

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

### My Answer:

* D! ✅

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

### My Answer:

* F!✅

* b1 is true, but b2 will hang

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
### My Answer:

* E!✅

* b2 tries to access a stream already used, so exception is thrown

<hr>

## Question 4:

❓Which are true statements about terminal operations in a stream?

A. At most one terminal operation can exist in a stream pipeline

B. Terminal operations are a required part of the stream pipeline in order to get a result

C. Terminal operations must have `Stream` as the return type.

D. The referenced `Stream` may be used after the calling a terminal operation

E. The `peek()` method is an example of a terminal operation
❓

<hr>

### My Answer:

* A, B!✅

## Question 5

❓ Which terminal operations on the `Stream` class are reductions?❓

A. collect()

B. count()

C. findFirst()

D. map()

E. peek()

F. sum()

<br>

### My Answer:

* A, B, F!❌ - while sum() is a reduction, it is only available for primitive streams!

* collect is a reduction, count is reduction, sum is a reduction



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

<hr>

### My Answer:

* A!✅

* allMatch would return false, anyMatch would hang, noneMatch would hang

<br>


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

### My answer:

* F!✅


## Question 8:

❓Which of the following are true given the declaration `IntStream is = IntStream.empty()` (Choose all that apply)❓

A. `is.average()` returns the type `int`

B. `is.average()` returns the type `OptionalInt`

C. `is.findAny()` returns the type `int`

D. `is.findAny()` returns the type `OptionalInt`

E. `is.sum()` returns the type `int`

F. `is.sum()` returns the type `OptionalInt`


### My Answer:

* B, D, E!❌ B is not valid! average() returns OptionalDouble
* is.average() returns OptionalInt, is.findAny returns OptionalInt, is.sum() returns int

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

### My Answer:

* B, D!✅
* (1,2,3) -> (10,20,30) -> () -> OptionalLong.empty()
* A - would not compile, B - compiles and prints nothing, C - does not compile, D - compiles and prints nothing

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

<hr>

### My Answer:

* F, G!❌ G is not valid! peek() is only called if terminal operation is present!
* A - prints nothing
* B - everything gets printed out, so nothing printed
* C, D, E - filetered out
* F - prints out 10 times
* G - prints 10 times

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

<hr>

### My Answer:

* C, D!❌ B, C, E is the correct answer! If we are using joining then a String is returned!
* A is not required! C is required. D is required. E would not work. F false, B is not required

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

<hr>

### My Answer:

* A, F, G!✅
* Line 6 is a supplier so F
* Line 7 is a consumer of 2 arguments, so A
* Line 8 is a Function, so its G


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

<hr>

### My Answer:

* F!✅
* The code does not compile!


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

<hr>

### My Answer:

* D!✅
* Line 7 does not compile

## Question 15

❓The `partitioningBy()` collector creates a `Map<Boolean, List<String>>` when passed to `collect()` by default. When specific parameters are passed to `partioningBy()`, which return types can be created? (Choose all that apply)❓

A. `Map<boolean, List<String>>`

B. `Map<Boolean, Map<String>>`

C. `Map<Long, TreeSet<String>>`

D. `Map<Boolean, List<String>>`

E. `Map<Boolean, Set<String>>`

F. None of the above
<hr>

### MyAnswer:
* D, E!✅
* D and E are obviously true
* C is also a possibility but i will say not

## Question 16

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

### MyAnswer:
* C!✅
* C and D are possible
* D is not possible as keys are only created if needed!
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

<hr>

### My Answer:
* E!✅
* A - invalid, B - invalid, C - invalid, D, Invalid, E - valid

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

### My Answer:
* D!✅

<hr>


## Question 19

❓Which of the following return primitives❓

A. `BooleanSupplier`

B. `CharSupplier`

C. `DoubleSupplier`

D. `FloatSupplier`

E. `IntSupplier`

F. `StringSupplier`

<hr>

### My Answer:

* A, C, E!✅

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

<hr>

### My Answer:

* B!✅
