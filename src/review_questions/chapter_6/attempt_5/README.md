<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 6: Review Questions - Attempt 5

* Date: 30/06/2024
* Score: 14/20 (70%)

| Question # | Correct |
| ---------- | ------- |
| 1          |  ✅     |
| 2          |  ✅     |
| 3          |  ❌     |
| 4          |  ✅     |
| 5          |  ✅     |
| 6          |  ✅     |
| 7          |  ✅     |
| 8          |  ✅     |
| 9          |  ✅     |
| 10         |  ✅     |
| 11         |  ❌     |
| 12         |  ❌     |
| 13         |  ❌     |
| 14         |  ✅     |
| 15         |  ✅     |
| 16         |  ✅     |
| 17         |  ✅     |
| 18         |  ❌     |
| 19         |  ❌     |
| 20         |  ✅     |


<hr>

## Question 1
❓ Which of the following pairs fills in the blanks to make this code compile❓

```java
5: public void read() _________ SQLException {
6:     ________ new SQLException();
7: }
```

* A. throw on line 5 and throw on line 6 
* B. throw on line 5 and throws on line 6 
* C. throws on line 5 and throw on line 6 
* D. throws on line 5 and throws on line 6 
* E. None of the above. SQLException is a checked exception and cannot be thrown 
* F. None of the above. SQLException is a runtime exception and cannot be thrown 
❓

### My answer:
* throws then throw
* **C**✅✅✅✅
<hr>

## Question 2:

❓ Which of the following changes when made independently would make this code compile (choose all that apply)

```java
1 : public class StuckTurkeyCage implements AutoCloseable {
2 :    public void close() throws Exception {
3 :       throw new Exception("Cage door does not close");
4 :    }
5 :    public static void main(String[] args) {
6 :       try (StuckTurkeyCage t = new StuckTurkeyCage()) {
7 :          System.out.println("put turkeys in");
8 :       }
9 :    }
10: }
```
* A. Remove throws Exception from the declaration on line 2
* B. Add throws Exception to the declaration on line 5
* C. Change line 8 to `} catch (Exception e) {}`
* D. Change line 8 to `} finally {}`
* E. None of the above will make the code compile
* F. The code already compiles as is
❓

### My answer:
* It needs to catch exception or declare it in the main signature
* A - false
* B - true
* C - true
* D - false
* E - false
* F - false
* **B,C**✅✅✅✅
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

* A. `FileNotFoundException | IOException e` 
* B. `FileNotFoundException e | IOException e` 
* C. `FileNotFoundException | RuntimeException e` 
* D. `FileNotFoundException e | RuntimeException e` 
* E. `IOException | RuntimeException e` 
* F. `IOException e | RuntimeException e` 
❓

### My answer:
* A - valid
* B - invalid
* C - valid
* D - invalid
* E - valid
* F - invalid
* **A,C,E**❌❌❌❌
* Multi-catch cannot be applied to related exceptions so A does not compile
* C does not compile as IOException is not being caught by `FileNotFoundException`
* **CORRECT ANSWER: E**
<hr>

## Question 4:
❓Which of the following are true statements (choose all that apply)

* A. A traditional `try` statement without a catch block requires a finally block
* B. A traditional `try` statement without a finally block requires a catch block
* C. A traditional `try` statement with only one statement can omit {}
* D. A try-with-resources statement without a catch block requires a finally block
* E. A try-with-resources statement without a finally block requires a catch block
* F. A try-with-resources statement with only one statement can omit the {}

### My answer:
* A is true
* B is true
* C is false
* D - false
* E - false
* F - false
* **A,B**✅✅✅✅
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
      }}}
```

* A. `TWF` 
* B. `TWDF`
* C. `TWDEF` 
* D. `TWF` followed by an exception 
* E. `TWDF` followed by an exception 
* F. `TWEF` followed by an exception 
* G. The code does not compile 
❓

### My answer:
* It prints T W runtime exception is thrown but supressed D is printed
* E is print
* F is printed
* TWDEF
* **C**✅✅✅✅
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
      }}}
```

* A. `TWF` 
* B. `TWDF`
* C. `TWDEF` 
* D. `TWF` followed by an exception 
* E. `TWDF` followed by an exception 
* F. `TWEF` followed by an exception 
* G. The code does not compile 
❓

### My answer:
* **G**✅✅✅✅
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

* A. `hithere`
* B. The `assert` statement throws an AssertionError
* C. The code throws an `ArrayIndexOutOfBoundsException`
* D. The code compiles and runs successfully, but there is not output
* E. The code does not compile

### My answer:
* **C**✅✅✅✅
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
* A. `java -da On` <br>
* B. `java -ea On` <br>
* C. `java -da -ea:On On` <br>
* D. `java -ea -da:On on` <br>
* E. The code does not compile <br>

### My answer:
* B and C
* **B,C**✅✅✅✅
<hr>

## Question 9
❓Which of the following prints `OhNo` with the assertion failure when the number is negative? (Choose all that apply)

* A. `assert n < 0: "OhNo2";`
* B. `assert n < 0; "OhNo";`
* C. `assert n < 0 ("OhNo");`
* D. `assert(n < 0): "OhNo";`
* E. `assert(n < 0, "OhNo");`

### My answer:
* Is this a trick question if n ie negative none of the asserts would fail
* A - valid
* D valid
* **A,D**✅✅✅✅
<hr>

## Question 10
❓ Which of the following are true of the code? (Choose all that apply)
```java
4:   private int addPlusOne(int a, int b) {
5:      boolean assert = false;
6:      assert a++ > 0;
7:      assert b > 0;
8:      return a + b;
9:   }
```

* A. Line 5 does not compile 
* B. Line 6 and 7 do not compile because they are missing the String message 
* C. Line 6 and 7 do not compile because of missing parentheses 
* D. Line 6 is an appropiate use of an assertion 
* E. Line 7 is an appropiate use of an assertion 

### My answer:
* line 5 does not compile as its using keyword
* line 6 does compile
* line 7 does compile
* E is true
* D is false
* A - true
* B - false
* C - false
* E - true
* **A,E**✅✅✅✅
<hr>

## Question 11
❓Which of the following are runtime exceptions (choose all that apply)
* A. `Exception` 
* B. `IllegalStateException`
* C. `IOException` 
* D. `MissingResourceException` 
* E. `DateTimeParseException` 
* F. `SQLException` 

### My answer:
* A - false
* B - true
* C - false, this is a checked exception
* D - false
* E - true
* F - false, checked
* **B,E**❌❌❌❌
* **CORRECT ANSWER: B,D,E**
* MissingResourceException is not checked!!!
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
      }}}
```

* A. `// leave line blank` 
* B. `e = new Exception();` 
* C. `e = new RuntimeException();` 
* D. `e = new SneezeException();` 
* E. `e = new SniffleException();` 
* F. None of the above; the code does not compile. 

### My answer:
* D and E are valid I think
* **D,E**❌❌❌❌
* **CORRECT ANSWER: A,D,E**
* I failed to realise blank line is valid
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
   }}
```
* A. `// leave line blank` 
* B. `e = new Exception();` 
* C. `e = new RuntimeException();` 
* D. `e = new SneezeException();` 
* E. `e = new SniffleException();` 
* F. None of the above; the code does not compile. 

### My answer:
* You can not reassign e
* **F**❌❌❌❌
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
      }}}
```
* A. `// leave line blank`
* B. `e = new Exception();`
* C. `e = new RuntimeException();`
* D. `e = new SneezeException();`
* E. `e = new SniffleException();`
* F. None of the above; the code does not compile.

### My answer:
* **F**✅✅✅✅
* The code does not compile as multicatch is catching related types!!!!
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

* A. `One` 
* B. `Two` 
* C. `Three` 
* D. `Four` 
* E. `Five` 
* F. `Six` 

### My answer:
* Checked exceptions extends Exception but not RuntimeException
* A - false
* B - true
* C - false
* D - false
* E - true
* F - false
* **B,E**✅✅✅✅

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
      }}}
```

* A. `rain 0` 
* B. `rain 1` 
* C. `rain 2` 
* D. `snow 0` 
* E. `snow 1` 
* F. `snow 2` 
* F. The code does not compile 

### My answer:
* runtime exception is thrown but supressed
* snow is thrown but supressed
* snow is thrown but supressed
* rain is printed and 2 is printed
* **C**✅✅✅✅
<hr>

## Question 17
❓ Fill in the blank: A class that implements ____________ may be in a try-with-resource statement? (Choose all that apply)
    
* A. AutoCloseable 
* B. Closeable 
* C. Exception 
* D. RuntimeException 
* E. Serializable 

### My answer:
* **A,B**✅✅✅✅
<hr>

## Question 18
❓ Which pairs fill in the blanks? The `close()` method is not allowed to throw a(n) _________ in a class that implements ___________. (Choose all that apply)

* A. Exception, Autocloseable
* B. Exception, Closeable
* C. IllegalStateException, AutoCloseable
* D. IllegalStateException, Closeable
* E. IOException, AutoCloseable
* F. IOException, Closeable

### My answer:
* If a class implements Closeable then it CAN throw illegal exception
* If a class implements AutoCloseable then it  can not throw an Exception
* **A**❌❌❌❌
* AutoCloseable throws Exception, Closeable throws IOException
* So Closeable cannot throw Exception
* **CORRECT ANSWER: B**
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

* A. `Exception` 
* B. `RuntimeException` 
* C. `SQLException` 
* D. `SQLException | IOException` 
* E. `SQLException | RuntimeException` 

### My answer:
* A - true
* B - false
* C - false
* D - true
* E - true
* **A,D,E**❌❌❌❌
* Just like regular catches, you cannot catch an exception which is not being thrown
* A is valid, so false
* B is valid, the SQLException is declared in signature so not required to be caught, so false
* C is valid, so false
* D is not valid as IOException is not thrown anywhere, so true
* E is valid, so false
* **CORRECT ANSWER: D**
<hr>

## Question 20
❓ Which of the following is true when creating your own exception class?

* A. One or more constructors must be coded.
* B. Only checked exceptions may be created
* C. Only unchecked exception may be created
* D. The `toString()` method must be coded
* E. None of the above

### My answer:
* A - false
* B - false
* C - false
* D - false
* **E**✅✅✅✅
<hr>