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

❓❓

A. 

B. 

C. 

D. 

E. 

F. 

G. 

## Question 7

❓❓
A. 

B. 

C. 

D. 

E. 

F. 

G. 


## Question 8:

❓❓

A. 

B. 

C. 

D. 

E. 

F. 

G. 

## Question 9

❓❓

A. 

B. 

C. 

D. 

E. 

F. 

G. 


## Question 10

❓❓

A. 

B. 

C. 

D. 

E. 

F. 

G. 

## Question 11

❓❓
A. 

B. 

C. 

D. 

E. 

F. 

G. 


## Question 12:

❓❓

A. 

B. 

C. 

D. 

E. 

F. 

G.  


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