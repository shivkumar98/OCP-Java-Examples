<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 6.4 Using Try-With-Resources

## 🟥 6.4.1 Introduction

* Multi-catch helps reduce code duplication, however we can still have problems with duplication in `finally` clause.
* A resource is typically a file or database, and should be closed after it is used.
<br>
* Suppose you write a method, which reads first line of one file and write it to another file.
    - Before Java 7, this method would look like:

```java
public void oldApproach(Path p1, Path p2) throws IOException {
    BufferedReader in = null;
    BufferedWriter out = null;
    try {
        in = Files.newBufferedReader(p1);
        out = Files.newBufferedWriter(p2);
        out.write(in.readLine());
    } finally {
        if (in != null) in.close();
        if (out !=null) out.close();
    }
}
```
- This code is lengthy and doesn't handle any exceptions!😢
- If we use `try-with-resources` we can make the above code cleaner:

```java
public void newApproach(Path p1, Path p2) {
    try (BufferedReader in = Files.newBufferedReader(p1);
         BufferedWriter out = Files.newBufferedWriter(p2);) {
            out.write(in.readLine());
         }
}
```

- The `try-with-resources` closes AUTOMATICALLY CLOSES REWSOURCES.
- This feature is called *automatic resource management*

<hr>

## 🟥 6.4.2 Try-With-Resources Basics
* The `try-with-resources` statement does not contain an explicit finally block❗
* Here are some basic syntaxes:

```java
try (BufferedReader r = Files.newBufferedReader(p1);
     BufferedWriter w = Files.newBufferedWriter(p2)) {
    // protected code
} // RESOURCES CLOSE HERE
```

```java
try (BufferedReader r = Files.newBufferedReader(p1);
     BufferedWriter w = Files.newBufferedWriter(p2)) {
    // protected code
} catch (IOException e) {
    // exception handler
} finally {
    // finally block
}
```

* The implicit finally runs before any catch or finnaly blocks.
* Can you see why the following does not compile❓❓❓
```java
try (Scanner s = new Scanner; s.nextLine()) {
    s.nextLine();
} catch (Exception e) {
    s.nextInt(); // COMPILER ERROR
} finall {
    s.nextInt(); // COMPILER ERROR
}
```
* The issue is that the Scanner has gone out of scope at the end of the try clause.

<hr>

## 🟥 6.4.3 AutoCloseable
* Only resources which can be closed can be put in the try-with-resources statement!⚠️
* E.g. the following does not compile❌
```java
public class Turkey {
     public static void main() {
        try (Turkery t = new Turkey()) { // COMPILER ERROR

        }
     }
}
```
* The compiler will give the following error: `The resource type Turke does not implement java.lang.AutoCloseable`
* We can rectify this by implementing the `AutoCloseable` interface which has the method `public void close() throws Exception;`:
```java
public class TurkeyCage implements AutoCloseable {
    public void close() {
        System.out.print("close gate");
    }
}
```
<br>

* If you decide to throw a Checked Exception in your implementation, you must declare it in your method as with regular exceptions:

```java
public class Turkey implements AutoCloseable {
    public void close() throw Exception {
        throw new Exception("Cage is stuck");
    }

    public static void main() {
        try (Turkey t = new Turker()) { // COMPILER ERROR

        }
    }
}
```

* Java recommends that the `close()` implementation does not actually throw `Exception` but a more specific Exception so that the method can be called with unknown side-effects.


### 🟡 AutoCloseable vs Closeable
* AutoCloseable was introduced in Java 7. Closeable was another interface which existed before 7 and differed in the following ways
    - Closeable restricts the exception thrown to IOException
    - Required to be idempotent
* AutoCloseable is less strict than Closeable💡

<hr>

## 🟥 6.4.4 Supressed Exceptions

```java
class StuckTurket implements AutoCloseable {
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Door does not close");
    }
    public static void main() {
        try (StuckTurkey t = new StuckTurkey()) {
            System.out.println("put turkeys in");
        } catch (IllegalStateException e) {
            System.out.println("caught: "+e.getMessage());
        }
    }
}
```

* The exception is caught and the program, prints `Door does not close`

* What happens if the try statement alsothrows an exception, Java 7 allowed for exceptions to accumulate! 
* When multiple exceptions are thrown, all the exceptions except the first are called **SUPRESSED EXCEPTION**.

```java
15: try (StuckTurkey t = new StuckTurkey()) {
16:     throw new IllegalStateException("turkeys have run off");
17: } catch (IllegalStateException e) {
18:     System.out.println("caught: "+e.getMessage());
19:     for (Throwable t:e.getMessage())
20:         System.out.println(t.getMessage());
21: }
```
* Line 16 throws the primary exception. The `close()` method is called which itself throws another `IllegalStateException`, which is added as a supressed exception.
* Line 17 catched the primary exception, line 18 prints the primary exception's message.
* Line 19 goes through the suppresed exception and prints it out
* The output is:
```
caught: turkeys have run off
Door does not close
```

* What do you think the following code prints:
```java
22: try (StuckTurkey t = new StuckTurkey()) {
23:     throw new RuntimeException("turkeys ran off");
24: } catch (IllegalStateException e) {
25:     System.out.println("caught: " + e.getMessage());
26: }
```

<hr>

## 🟥 6.4.5 Putting it Together

* Resources are closed after the `try` clause ends and before any `catch`/`finally` clauses
* Resources are closed in reverse order in which they are created

<br>

* What does the following print?
```java
public class Auto implements AutoCloseable {
    int num;
    Auto(int num) { this.num = num; }
    public void close() {
        System.out.println("Close: " + num);
    }
    public static void main(String[] args) {
        try (Auto auto1 = new Auto(1); Auto auto2 = new Auto(2)) {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("ex");
        } finally {
            System.out.println("finally");
        }
    }
}
```

* ANSWER: 
```
Close: 2
Close: 1
ex
finally
```