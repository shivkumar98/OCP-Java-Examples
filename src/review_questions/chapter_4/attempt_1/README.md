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
❓

My answer: the stream is terminated after 2 elements. The elements are "1", "12". The elements are then mapped to "12", "122". I don't think it generates a String. So my answer is **D**

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

My answer: stream2 generates an infinite stream, b2 is checking if all the infinite elements begin with "g". Therefore the code hangs! My answer is **F**




## Question 3

❓❓

A. 
B. 
C. 
D. 
E. 
F. 
G. 


## Question 4:

❓❓

A. 
B. 
C. 
D. 
E. 
F. 
G. 


## Question 5

❓❓

A. 
B. 
C. 
D. 
E. 
F. 
G. 


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