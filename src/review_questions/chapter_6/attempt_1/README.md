<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 6: Review Questions - Attempt 1

## Results:

Date: 27/09/2023
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
❓ Which of the following pairs fills in the blanks to make this code compile❓

```java
5: public void read() _________ SQLException {
6:     ________ new SQLException();
7: }
```

A. throw on line 5 and throw on line 6 <br>
B. throw on line 5 and throws on line 6 <br>
C. throws on line 5 and throw on line 6 <br>
D. throws on line 5 and throws on line 6 <br>
E. None of the above. SQLException is a checked exception and cannot be thrown <br>
F. None of the above. SQLException is a runtime exception and cannot be thrown <br>
❓

### My answer:
* **C**

<hr>

## Question 2:

❓ Which of the following changes when made independently would make this code compile (choose all that apply)

```java
1 : public class StuckTurkeyCage implements AutoCloseable {
2 :     public void close() throws Exception {
3 :         throw new Exception("Cage door does not close");
4 :     }
5 :     public static void main(String[] args) {
6 :         try (StuckTurkeyCage t = new StuckTurkeyCage()) {
7 :             System.out.println("put turkeys in");
8 :         }
9 :     }
10: }
```
A. Remove throws Exception from the declaration on line 2 <br>
B. Add throws Exception to the declaration on line 5 <br>
C. Change line 8 to } catch (Exception e) {} <br>
D. Change line 8 to } finally {} <br>
E. None of the above will make the code compile <br>
F. The code already compiles as is <br>
❓

### My answer:
* The code does NOT compile as is!
* We need to catch the checled exception!
* **B, C**
<hr>

## Question 3
❓ Which of the following fills in the blank to make the code compile? (Choose all that apply)

```java
public static void main(String[] args) {
    try {
        throw new IOException();
    } catch (___________________) { }
}
```

A. `FileNotFoundException | IOException e` <br>
B. `FileNotFoundException e | IOException e` <br>
C. `FileNotFoundException | RuntimeException e` <br>
D. `FileNotFoundException e | RuntimeException e` <br>
E. `IOException | RuntimeException e` <br>
F. `IOException e | RuntimeException e` <br>
❓

### My answer:
* A - false, FileNotFoundException is a IOException
* B - false, invalid syntax
* C - true
* D - false, invalid syntax
* E - true
* F - false, invalid syntax
* **C,E**
<hr>

## Question 4:
❓Which of the following are true statements (choose all that apply)

A. A traditional `try` statement without a catch block requires a finally block <br>
B. A traditional `try` statement without a finally block requires a catch block <br>
C. A traditional `try` statement with only one state with only one statement can omit {} <br>
D. A try-with-resources statement without a catch block requires a finally block <br>
E. A try-with-resources statement without a finally block requires a catch block <br>
F. A try-with-resources statement with only one statement can omit the {}

### My answer:
* A - true
* B - true
* C - I don't THINK so
* D - true
* E - false
* F - I don't THINK so
<hr>


## Question 5
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
        try (Door d = new Door(); Window w = new Window()) {
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
* The code DOES compile
* TWDEF is printed
* **C**
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
* Code does not compile due to missing semi-colon:
* **G**
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
* The command does not enable the assertions, so no assertion exception is thrown
* Therefore it prints nothing an ArrayIndexOutOfBoundsException is thrown
* **C**
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
* The code DOES compile
* **B**
<hr>

## Question 9
❓Which of the following prints `OhNo` with the assertion failure when the number is negative? (Choose all that apply)

A. `assert n < 0: "OhNo2";` <br>
B. `assert n < 0; "OhNo";` <br>
C. `assert n < 0 ("OhNo");` <br>
D. `assert(n < 0): "OhNo";` <br>
E. `assert(n < 0, "OhNo");` <br>

### My answer:
* A - valid
* D - valid
* **A, D**
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
* A - true, assert is a keyword
* B - false
* C - false
* D - false
* E - true
* **A,E**
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
* A - false
* B - true
* C - false
* D - false
* E - true
* F - false
* **B,E**

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
* The code does compile
* A - valid
* B - invalid, e is of type SneezeException
* C - invalid
* D - valid
* E - valid
* **A,D,E**
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
* **A**
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
* **F**
<hr>

## Question 15
❓Given the following code, which of the answer choices can fill in the blank to print true (choose all that apply)?
```java
String m1 = Duration.of(1, ChronoUnit.MINUTES).toString();
String m2 = Duration.ofMinutes(1).toString();
String s = Duration.of(60, ChronoUnit.SECONDS).toString();

String d = Duration.ofDays(1).toString();
String p = Period.ofDays(1).toString();
```
    A. m1 == m2
    B. m1.equals(m2)
    C. m1.equals(s)
    D. d == p
    E. d.equals(p)

### My answer:

<hr>

## Question 16
❓Given the following, which answers can correctly fill in the blank? (Choose all that apply)
```java
LocalDate date = LocalDate.now();
LocalTime time = LocalTime.now();
LocalDateTime dateTime = LocalDateTime.now();
ZoneId zoneId = ZoneId.systemDefault();
ZonedDateTime zonedDateTime - ZonedDateTime.of(dateTime, zoneId);
long epochSeconds = 0;
Instant instant = ___________________;
```
    A. `Instant.now()`
    B. `Instant.ofEpcochSecond(epochSeconds)`
    C. `date.toInstant()`
    D. `dateTime.toInstant()`
    E. `time.toInstant()`
    F. `zonedDateTime.toInstant()`

### My answer:

<hr>

## Question 17
❓What is the output of the following method if props contains `{veggies=brontosaurus, meat=velociraptor}`
```java
private static void print(Properties props) {
    System.out.println(props.get("veggies", "none")
        + " " + props.get("omini", "none"));
}
```
    A. `brontosaurus none`
    B. `brontosaurus null`
    C. `none none`
    D. `none null`
    E. The codes not compile
    F. A runtime exception is thrown

### My answer:

<hr>

## Question 18
❓Which of the following prints our all of the values in props?
A. 
```java
props.keys().stream().map(k -> k.forEach(System.out::println))
```
B. 
```java
props.keys().stream().map(k -> props.get(k))
    .forEach(System.out::println);
```
C. 
```java
props.keySet().stream().map(k -> k)
    .forEach(System.out::println);
```
D.
```java
props.keySet().stream().map(k -> props.get(k))
    .forEach(System.out::println);
```
E.
```java
props.stream().map(k -> k) .forEach(System.out::println);
```
F.
```java
props.stream().map(k -> k) .forEach(System.out::println);
```

### My answer:

<hr>

## Question 19
❓ Which of the following are stored in a Period object (Choose all that apply)
    A. Year
    B. Month
    C. Day
    D. Hour
    E. Minute
    F. Second

### My answer:

<hr>

## Question 20
❓Which of the following objects could contain the information "eastern standard time"? (Choose all that apply)
    A. Instant
    B. LocalDate
    C. LocalDateTijme
    D. LocalTime
    E. ZonedDateTime

### My answer:

<hr>