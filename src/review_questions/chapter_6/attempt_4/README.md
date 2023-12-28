<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 6: Review Questions - Attempt 4

## Results:

Date: 28/12/2023
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
* **B,C**
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
* A - true
* B - false
* C - false
* D - false
* E - true
* F - false
* **A,E**
<hr>

## Question 4:
❓Which of the following are true statements (choose all that apply)

A. A traditional `try` statement without a catch block requires a finally block <br>
B. A traditional `try` statement without a finally block requires a catch block <br>
C. A traditional `try` statement with only one statement can omit {} <br>
D. A try-with-resources statement without a catch block requires a finally block <br>
E. A try-with-resources statement without a finally block requires a catch block <br>
F. A try-with-resources statement with only one statement can omit the {}

### My answer:
* A - true
* B - true
* C - false
* D - false
* E - false
* F - false
* **A,B**
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
* **B,C**
<hr>

## Question 9
❓Which of the following prints `OhNo` with the assertion failure when the number is negative? (Choose all that apply)

A. `assert n < 0: "OhNo2";` <br>
B. `assert n < 0; "OhNo";` <br>
C. `assert n < 0 ("OhNo");` <br>
D. `assert(n < 0): "OhNo";` <br>
E. `assert(n < 0, "OhNo");` <br>

### My answer:
* **A,D**
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
* **B,D,E**
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
* **B,E**
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