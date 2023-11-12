<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 7: Review Questions - Attempt 1

## Results:

Date: 
Score: 
✅  ❌ 
| Question # | Correct |
| ---------- | ------- |
| 1          |       |
| 2          |       |
| 3          |       |
| 4          |       |
| 5          |       |
| 6          |       |
| 7          |       |
| 8          |       |
| 9          |       |
| 10         |       |
| 11         |       |
| 12         |       |
| 13         |       |
| 14         |       |
| 15         |       |
| 16         |       |
| 17         |       |
| 18         |       |
| 19         |       |
| 20         |       |
| 21         |       |
| 22         |       |

<hr>

## Question 1
❓ Given an instance of a Stream s, and a Collection c, which are valid ways of creating a parallel stream? (Choose all that apply) ❓

A. `new ParallelStream(s)` <br>
B. `c.parallel()` <br>
C. `s.parallelStream()`  <br>
D. `c.parallelStream()` <br>
E. `new ParallelStream(c)`  <br>
F. `s.parallel()` <br>
❓

### My answer:
* There is no constructor
* You convert a stream using `.parallel()`
* You convert a collection using `.parallelStream()`
* **D,F**
<hr>

## Question 2:
❓ Which of the following statements abolut the `Callable call()` and `Runnable run()` methods are correct? (Choose all that apply) ❓

A. Both can throw unchecked exceptions <br>
B. Callable takes a generic method argument <br>
C. Callable can throw a checked exception <br>
D. Both can be implemented with lambda expressions <br>
E. Runnable returns a generic type <br>
F. Callable returns a generic type <br>
G. Both methods return void <br>
❓

### My answer:
* Callable does not return anything, it can throw a checked exception (as can Runnable)
* Runnable returns a generic argument
* A - true
* B - false, callable does not take arguments
* C - true
* D - true
* E - true
* F - false
* G - false
* **A,C,D,E**
<hr>

## Question 3
❓ Which lines need to be changed to make the code compile? (Choose all that apply) ❓

```java
ExecutorService service = Executors.newSingleThreadScheduleExecutor();
service.scheduleWithFixedDelay(() -> { // w1
    System.out.println("Open Zoo");
    return null; // w2
}, 0, 1, TimeUnit.MINUTES);
Future<?> result = service.submit(() -> System.out.println("Wake staff")); // w3
System.out.println(result.get()); // w4
```

A. It compiles and runs without issue <br>
B. Line w1 <br>
C. Line w2 <br>
D. Line w3 <br>
E. Line w4 <br>
F. It compiiles but throws an exception at runtime <br>
❓

### My answer:
* Definitely does not compile
* A - false
* B - false, this is fine
* C - false, this is fine
* D - true, does not compile
* E - false, this is fine
* F - false
* **D**
<hr>

## Question 4:
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>


## Question 5
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>

## Question 6
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>

## Question 7
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>

## Question 8:
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>

## Question 9
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>

## Question 10
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>

## Question 11
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>

## Question 12:
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>

## Question 13
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>

## Question 14:
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>

## Question 15
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>

## Question 16
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>

## Question 17
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>

## Question 18
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>

## Question 19
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>

## Question 20
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>

## Question 21
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>


## Question 22
❓ ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>