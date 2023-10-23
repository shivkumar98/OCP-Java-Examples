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


<hr>

## Question 1
❓ Given an instance of a Stream s, and a Collection c, which are valid ways of creating a parallel stream (Choose all that apply)❓

A. `new ParallelStream(s)` <br>
B. `c.parallel()` <br>
C. `s.parallelStream()` <br>
D. `c.parallelStream()` <br>
E. `new ParallelStream(c)` <br>
F. `s.parallel()` <br>
❓

### My answer:
* A - definitely false, there is no ParallelStream class
* B - invalid, only stream has `parallel()` method
* C - invalid, not a methd for streams
* D - possible, so I say yes
* E - invalid, same as A
* F - valid
* **D,F**

<hr>

## Question 2:

❓ Which of the following statements about the `Callable call()` and `Runnable run()` methods are correct? (choose all that apply)

A. Both can throw unchecked exceptions <br>
B. Callable takes a generic method argument <br>
C. Callable can throw a checked exception <br>
D. Both can be implemented with lambda expressions <br>
E. Runnable returns a generic type <br>
F. Callable returns a generic type <br>
G. Both methods return void <br>
❓

### My answer:
* A - yes!
* B - I don't think so
* C - I think so
* D - yes!
* E - I don't think so!
* F - no!
* G - yes!
* **A, D, F, G**

* 
<hr>

## Question 3
❓ Which lines need to be changed to make the code compile? (Choose all that apply)

```java
ExecutorService service = Executors.newSingleThreadScheduledExecutor();
servie.scheduleWithFixedDelay(() -> { // w1
    System.out.println("Open Zoo");
    return null; // w2
}, 0, 1, TimeUnit.MINUTES);
Future<?> result = service.submit(() -> System.out.println("Wake Staff")); // w3
System.out.println(result.get()); // w4
```

A. It compiles and runs without issue <br>
B. Line w1 <br>
C. Line w2 <br>
D. Line w3 <br>
E. Line w4 <br>
F. It compile but throws an exception at runtime <br>
❓

### My answer:
* I have NO idea
* **A**
<hr>

## Question 4:
❓Which statement about the following code is true?

```java
AtomicLong value1 = new AtomicLong(0);
final long[] value2 = {0};
IntStream.iterate(1, i -> 1).limit(100).parallel()
    .forEach(i -> value1.incrementAndGet());
IntStream.iterate(1, i -> 1).limit(100).parallel()
    .forEach(i -> ++value2[0]);
System.out.println(value1+" "+value2[0]);
```

A. It outputs `100 100` <br>
B. It outputs `100 99` <br>
C. The output cannot be determined ahead of time. <br>
D. The code does not compile <br>
E. It compiles but throws an exception at runtime <br>
F. It compiles but enters an infinite loop at runtime <br>

### My answer:
* I don't believe the output can be determined. We have a non thread safe counter for value2
* **C**
<hr>


## Question 5
❓ Fill in the blanks: __________ occur(s) when two or more threads are blocked forever but both appear active. ___________ occur(s) when two or more threads try to complete a related task at the same time.
❓
A. Livelock, Deadlock <br>
B. Deadlock, Starvation <br>
C. Race conditions, Deadlock <br>
D. Livelock, Race conditions <br>
E. Starvation, Race conditions <br>
F. Deadlock, Livelock <br>

### My answer:
* The first blank is livelock. The second has to be race conditions because it can't be deadlock
* **D**
<hr>

## Question 6
❓ What is the output of the following code?
```java
import java.io.*;
public class AutocloseableFlow {
    static class Door implements AutoCloseable {
        public void close() {
            System.out.println("D");
        }
    }
    static class Window implements Closeable {
        public void close() {
            System.out.println("W");
            throw new RuntimeException();
        }
    }
    public static void main(String[] args) {
        try {
            Door d = new Door(); Window w = new Window()
        }
        {
            System.out.print("T");
        } catch (Exception e) {
            System.out.print("E");
        } finally {
            System.out.print("F");
        } } }
```

A. `TWF` <br>
B. `TWDF`<br>
C. `TWDEF` <br>
D. `TWF` followed by an exception <br>
E. `TWDF` followed by an exception <br>
F. `TWEF` followed by an exception <br>
G. The code does not compile <br>
❓

### My answer:

<hr>

## Question 7
❓ What is the result of running `java EchoInput hi there` with the following code?
```java
public class EchoInput {
    public static void main(String [] args) {
        id(args.length <= 3) assert false;
        System.out.println(args[0] + args[1] + args[2]);
    }
}
```

A. `hithere` <br>
B. The `assert` statement throws an AssertionError <br>
C. The code throws an `ArrayIndexOutOfBoundsException` <br>
D. The code compiles and runs successfully, but there is not output <br>
E. The code does not compile <br>

### My answer:

<hr>

## Question 8:
❓Which of the following command lines cause this program to fail on the assertion (Choose all that apply)
```java
public class On {
    public static void main(String[] args) {
        String s = null;
        assert s != null;
    }
}
``` 
A. `java -da On` <br>
B. `java -ea On` <br>
C. `java -da -ea:On On` <br>
D. `java -ea -da:On on` <br>
E. The code does not compile <br>

### My answer:

<hr>

## Question 9
❓Which of the following prints `OhNo` with the assertion failure when the number is negative? (Choose all that apply)

A. `assert n < 0: "OhNo2";` <br>
B. `assert n < 0; "OhNo";` <br>
C. `assert n < 0 ("OhNo");` <br>
D. `assert(n < 0): "OhNo";` <br>
E. `assert(n < 0, "OhNo");` <br>

### My answer:

<hr>

## Question 10
❓ Which of the following are true of the code? (Choose all that apply)
```java
4:   private int addPlusOne(int a, int b) {
5:       boolean assert = false;
6:       assert a++ > 0;
7:       assert b > 0;
8:       return a + b;
9:   }
```

A. Line 5 does not compile <br>
B. Line 6 and 7 do not compile because they are missing the String message <br>
C. Line 6 and 7 do not compile because of missing parentheses <br>
D. Line 6 is an appropiate use of an assertion <br>
E. Line 7 is an appropiate use of an assertion <br>

### My answer:

<hr>

## Question 11
❓Which of the following are runtime exceptions (choose all that apply)
A. `Exception` <br>
B. `IllegalStateException`<br>
C. `IOException` <br>
D. `MissingResourceException` <br>
E. `DateTimeParseException` <br>
F. `SQLException` <br>

### My answer:

<hr>

## Question 12:

❓ Which of the following can legally fill in the blank? (choose all that apply)
```java
public class AhChoo {
    static class SneezeException extends Exception { }
    static class SniffleException extends SneezeException { }
    public static void main(String[] args) throws SneezeException {
        try {
            throw new SneezeException();
        } catch (SneezeException e) {
            __________
            throw e;
        } } }
```

A. `// leave line blank` <br>
B. `e = new Exception();` <br>
C. `e = new RuntimeException();` <br>
D. `e = new SneezeException();` <br>
E. `e = new SniffleException();` <br>
F. None of the above; the code does not compile. <br>

### My answer:

<hr>

## Question 13
❓Which of the following can legally fill in the blank? (Choose all that apply)
```java
public class AhChoo {
    static class SneezeException extends Exception { }
    static class SniffleException extends SneezeException { }
    public static void main(String[] args) throws SneezeException {
        try {
            throw new SneezeException();
        } catch (SneezeException | RuntimeException e) {
            ____________
            throw e;
        }
```
A. `// leave line blank` <br>
B. `e = new Exception();` <br>
C. `e = new RuntimeException();` <br>
D. `e = new SneezeException();` <br>
E. `e = new SniffleException();` <br>
F. None of the above; the code does not compile. <br>

### My answer:

<hr>

## Question 14:
❓Which of the following can legally fill in the blank? (Choose all that apply)
```java
public class AhChoo {
    static class SneezeException extends Exception { }
    static class SniffleException extends SneezeException { }
    public static void main(String[] args) throws SneezeException {
        try {
            throw new SneezeException();
        } catch (SneezeException | SniffleException e) {
            ____________
            throw e;
        }
```
A. `// leave line blank` <br>
B. `e = new Exception();` <br>
C. `e = new RuntimeException();` <br>
D. `e = new SneezeException();` <br>
E. `e = new SniffleException();` <br>
F. None of the above; the code does not compile. <br>

### My answer:

<hr>

## Question 15
❓ Which of the following are checked exceptions? (Choose all that apply)
```java
class One extends RuntimeException{}
class Two extends Exception{}
class Three extends Error{}
class Four extends One{}
class Five extends Two{}
class Six extends Three{}
```

A. `One` <br>
B. `Two` <br>
C. `Three` <br>
D. `Four` <br>
E. `Five` <br>
E. `Six` <br>

### My answer:

<hr>

## Question 16
❓ What is the output of the following?
```java
public class SnowStorm {
    static class Walk implements AutoCloseable {
        public void close() {
            throw new RuntimeException("snow");
        }
    }
    public static void main(String[] args) {
        try (Walk walk1 = new Walk(); Walk walk2 = new Walk();) {
            throw new RuntimeException("rain");
        } catch(Exception e) {
            System.out.println(e.getMessage()
                + " " + e.getSupressed().length);
        } } }
```

A. `rain 0` <br>
B. `rain 1` <br>
C. `rain 2` <br>
D. `snow 0` <br>
E. `snow 1` <br>
F. `snow 2` <br>
F. The code does not compile <br>

### My answer:

<hr>

## Question 17
❓ Fill in the blank: A class that implements ____________ may be in a try-with-resource statement? (Choose all that apply)
    
A. AutoCloseable <br>
B. Closeable <br>
C. Exception <br>
D. RuntimeException <br>
E. Serializable <br>

### My answer:

<hr>

## Question 18
❓ Which pairs fill in the blanks? The `close()` method is not allowed to throw a(n) _________ in a class that implements ___________. (Choose all that apply)

A. Exception, Autocloseable <br>
B. Exception, Closeable <br>
C. IllegalStateException, AutoCloseable <br>
D. IllegalStateException, Closeable <br>
E. IOException, AutoCloseable <br>
F. IOException, Closeable <br>

### My answer:

<hr>

## Question 19
❓ Which of the following cannot fill in the blank? (Choose all that apply)
```java
public void read() throws SQLException {
    try {
        readFromDatabase();
    } catch (________________ e) {
        throw e;
    }
}
public void readFromDatabase() throws SQLException { }
```

A. `Exception` <br>
B. `RuntimeException` <br>
C. `SQLException` <br>
D. `SQLException | IOException` <br>
E. `SQLException | RuntimeException` <br>

### My answer:

<hr>

## Question 20
❓ Which of the following is true when creating your own exception class?

A. One or more constructors must be coded. <br>
B. Only checked exceptions may be created <br>
C. Only unchecked exception may be created <br>
D. The `toString()` method must be coded <br>
E. None of the above <br>

### My answer:

<hr>