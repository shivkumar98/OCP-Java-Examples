<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 4: Review Questions

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


<hr>


My answer: the stream is terminated after 2 elements. The elements are "1", "12". The elements are then mapped to "12", "122". I don't think it generates a String. So my answer is **D**


<br>


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

F. The code hands
❓

<hr>

My answer: stream2 generates an infinite stream, b2 is checking if all the infinite elements begin with "g". Therefore the code hangs! My answer is **F**


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

My answer: false true. my answer is **A**



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

<br>

## Question 10

❓ Select from the following statements and indicate the order in which they would appear to output 10 lines:❓

```java
Stream.generate(()-> "");
    .filter(x -> x.length() > 1);  // L
    .forEach(System.out::println); // M
    .limit(10);                    // N
    .peek(System.out::println);    // O
;
```

A. L, N

B. L, N, O

C. L, N, M

D. L, N, M, O

E. L, O, N

F. N. M

G. N, O

<hr>

My answer: A - this does not print anything, B - i don't think so, C -  no all elements get filtered out! D - no, E - no, F - yes, G - no

**F**

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

<br>


## Question 13

❓❓

A. 

B. 

C. 

D. 

E. 

F. 

G. 


## Question 14:

❓❓

A. 

B. 

C. 

D. 

E. 

F. 

G. 
## Question 15

❓❓

A. 

B. 

C. 

D. 

E. 

F. 

G. 


## Question 16

❓❓

A. 

B. 

C. 

D. 

E. 

F. 

G. 


## Question 17

❓❓

A. 

B. 

C. 

D. 

E. 

F. 

G. 

## Question 18

❓❓

A. 

B. 

C. 

D. 

E. 

F. 

G. 

## Question 19

❓❓
A. 

B. 

C. 

D. 

E. 

F. 

G. 

## Question 20

A. 

B. 

C. 

D. 

E. 

F. 

G. 