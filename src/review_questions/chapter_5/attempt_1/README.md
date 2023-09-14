<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 5: Review Questions - Attempt 1

## Results:

Date: 
Score: /20

| Question # | Correct |
| ---------- | ------- |
| 1          |      |
| 2          |      |
| 3          |      |
| 4          |      |
| 5          |      |
| 6          |      |
| 7          |      |
| 8          |      |
| 9          |      |
| 10         |      |
| 11         |      |
| 12         |      |
| 13         |      |
| 14         |      |
| 15         |      |
| 16         |      |
| 17         |      |
| 18         |      |
| 19         |      |
| 20         |      |


<hr>

## Question 1

❓ Which of the following create valid locales, assuming that the language and country codes follow standard conventions (Choose all that apply) ❓

A. `new Locale("hi")`

B. `new Locale("hi, "IN")`

C. `new Locale("IN")`

D. `new Locale("IN", "hi")`

E. `Locale.create("hi")`

F. `Locale.create("IN")`
❓

<hr>

### My answer:
* A is valid, specifying country code is not necessary
* B is valid, follows convention
* C invalid, does not follow convention
* D invalid as above
* E and F, I don't think so!
* **A,B**

<br>


## Question 2:

❓ Which of the following are common types to localize (Choose all that apply)

A. Booleans

B. Class names

C. Currency

D. Dates

E. Numbers

F. Variable names
❓

<hr>

### My answer:
* D, and E are definitely localised
* Not sure if currency is localized, the formatting may be localised
* **C, D, E**
<br>


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

<hr>

My answer: false true. my answer is **A**

Correct answer: E - the code throws an exception. This is because b2 is trying to reference a stream which is already closed. If this was fine, then A would be the correct answer!

<br>

## Question 4:

❓Which are true statements about terminal operations in a stream?

A. At most one terminal operation can exist in a stream pipeline

B. Terminal operations are a required part of the stream pipeline in order to get a result

C. Terminal operations must have `Stream` as the return type.

D. The referenced `Stream` may be used after the calling a terminal operation

E. The `peek()` method is an example of a terminal operation
❓

<hr>
My answer: A - true, B - false, C - false, D - false, E - false:

**A**

Correct answers: A and B. Terminal operations are the final step in a stream pipeline. Exactly 1 is needed because it triggers the execution of the entire stream pipeline

<br>


## Question 5

❓ Which terminal operations on the `Stream` class are reductions?❓

A. collect()

B. count()

C. findFirst()

D. map()

E. peek()

F. sum()

<hr>
My answer: A - false, B - true, C - true, D - false, E - false, F - true

**B,C,F**

Correct answers: A and B. collect() is a reduction and so is count(). D and E are intermiadiate operations. While sum() is a reduction, it only available on primitive streams! C is not a reduction because it does not look at each element in the stream!
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

<hr>
My answer:  F - true

Correct answer: A. The allMatch does terminate! anyMatch() runs forever! findAny() and FindFirst() do not take predicates! noneMatch() woiuld run forever!

**F**

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

<hr>
My answer:  F 

**F**

Correct answer: F - the sorted() method lets us pass in a comparator!

<br>

## Question 8:

❓Which of the following are true given the declaration `IntStream is = IntStream.empty()` (Choose all that apply)❓

A. `is.average()` returns the type `int`

B. `is.average()` returns the type `OptionalInt`

C. `is.findAny()` returns the type `int`

D. `is.findAny()` returns the type `OptionalInt`

E. `is.sum()` returns the type `int`

F. `is.sum()` returns the type `OptionalInt`

<hr>
My answer:  A - False, B - True, C - False, D - True, E - False

Correct answer: D and E - isAverage() returns an OptionalDouble!

<br>

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

<hr>

My answer:  I believe the coede compiles, option B would not work as `getAsLong()` is not a method! C also would not compile. A and D seem fine!

**A and D**

Correct andswer: B and D - since we are using a LongStream we must use getAsLong

<br>

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

My answer: A - this does not print anything, B - i don't think so, C -  no all elements get filtered out! D - no, E - no, F - yes, G - no

**F**

Correct answer: F - the terminal operation must be the last statement so only C, E and F would be valid. E is out as it would be infinite.  C is invalid as all elements would be filtered out and it will run infinitely!

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

My answer: A - this makes no change to the result, so it works. B - this is fine and works. C - this is fine. D - yes. E - yes. F - no

**A, B, C, D, E**

Correct answer: B, C, E - the code does not compile. We need to fix it by using B, without C the stream would just contain "111...". collect() converts this to a string. So we can't use forEach()

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

My answer: F applies for line 6,  C applies to line 7, B and G apply to line 8

**B,C,F,G**

Correct answer: A, F, G - D is an invalid interface, C does not exist! A applied to line 7! `BiFunction<String, String>` is not valid. While E can work with line 6, it would be completely useless! Line 6 is creating something, so it is a supplier! So F is valid. H is completely invalid. G does apply to line 8!

<br>


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

My answer: D

**D**

Correct Answer: F - the code does not compile!!!. It fails when trying to map the elements. If `flatMap` was called first it would've worked!!!


<br>

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

My answer: The code definitely does not compile. Line 4 is fine, line 5 is fine, line 6 is fine, line 7 does not compile, so line 8 also does not compile

**D, E**

Correct answer: D - Line 8 actually does compile!!!

<br>

## Question 15

❓The `partitioningBy()` collector creates a `Map<Boolean, List<String>>` when passed to `collect()` by default. When specific parameters are passed to `partioningBy()`, which return types can be created? (Choose all that apply)❓

A. `Map<boolean, List<String>>`

B. `Map<Boolean, Map<String>>`

C. `Map<Long, TreeSet<String>>`

D. `Map<Boolean, List<String>>`

E. `Map<Boolean, Set<String>>`

F. None of the above


<hr>

My answer: A, B

**A, B**

Correct answer: D, E - A and B are not valid!!! Option C is invalid as it partitions to true,false.  The result can be changed to List or Set, making D and E correct!

<br>


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

<hr>

My answer: the first Map is partitioned, so it is grouped by false,true - so C and D seem valid. I go for C!

**C**

Correct answer: C!!! - partition will always return map with boolean key. The groupBy returns only keys which are needed

<br>

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

My answer: A is not valid, B is not valid, C is not valid, D is not valid, E is valid!

**E**

Correct answer: E - the other options do not even compile

<br>


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


<hr>

My answer: C

**C**

Correct answer: D - there is a terminal operation, which means the intermediate operations DO run! The peek() comes before the filter so both numbers get printed

<br>

## Question 19

❓Which of the following return primitives❓

A. `BooleanSupplier`

B. `CharSupplier`

C. `DoubleSupplier`

D. `FloatSupplier`

E. `IntSupplier`

F. `StringSupplier`


<hr>

My answer: A, C, E

**A, C, E**

Correct answer: ACE!!!

<br>

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

My answer: B

**B**

Correct answer - B!!!

<br>