<link href="../../styles.css" rel="stylesheet"></link>

# 📝 Chapter 6: Revision Notes

# 🧠 6.1 Reviewing Exceptions

## 🟥 Categories of Exceptions
* Checked exceptions, RuntimeExceptions and Error all extends `java.lang.Throwable`
* Checked exceptions extend `java.lang.Exception` but not `java.lang.RuntimeException`. These MUST be declared or handled in a try/catch clause.
* If a checked exception is not declared, then it can not be caught without compiler error!
* Errors are fatal and should not be caught by the program.

## 🟥 Categories of Exceptions
### 🟡 OCP CHECKED EXCEPTIONS
* The OCP exam will have the following **CHECKED EXCEPTIONS**:
1) `java.text.ParseException` - thrown when trying to convert an invalid String to a number
2) `java.io.IOException`, `java.io.FileNotFoundException`, `java.io.NotSerializableException` are for when dealing with IO/NIO.2 issues.
3) `java.sql.SQLException` - thrown when there are any database exception

### 🟡 OCP RUNTIME EXCEPTIONS
1) `java.lang.ArrayStoreException` - thrown when trying to insert the wrong type into an array
2) `java.time.DateTimeException` - thrown when receiving incorrect formatting String for a date
3) `java.util.MissingResourceException` - when a file can not be found for a resource bundle
4) `java.lang.UnsupportedOperationException` and `java.lang.IllegalStateException` - thrown when trying to run invalid operations in collections and concurrency

## 🟥 Try statement
* A traditional try-statement must have a catch clause if there is no finally clause or a finally clause if there is no catch clause
* Java will give a compiler error if a catch clause is unreachable
* Suppose we have a method which declares a checked exception:
```java
static void throwChecked() throwsException {}
```
* We must have a catch clause wherever it is called:
```java
public static void main(String[] args) {
    try {
        throwChecked(); // COMPILER ERROR
    } finally {}
}
```
* Or we can declare the exception in main method:
```java
public static void main(String[] args) throws Exception {
    try {
        throwChecked();
    } finally { }
}
```
* Or we can catch the checked exception:
```java
public static void main(String[] args) {
    try {
        throwChecked();
    } catch (Exception e) {	}
}
```

## 🟥 Throw vs Throws
* The syntax for declaring the exception and throwing it is as follows:
```java
public String getDataFromDB() throws SQLException {
    throw new UnsupportedOperationException(); // RUNTIME EXCEPTION
}
```

<hr>

# 🧠 6.2 Creating Custom Exceptions
* You can create a custom exception error by extending pre-existing errors, runtime and checked exceptions.

<hr>

# 🧠 6.3 Using Multi-catch
* Multi-catch enables us to catch multiple exception types, and reduce code duplication
* E.g.:
```java
try {
    Path path = Paths.get("dophinsBorn.txt");
    String text = new String(Files.readAllBytes(path));
    LocalDate date = LocalDate.parse(text);
    System.out.println(date);
} catch (DateTimeParseException | IOException e) {
    e.printStackTrace();
    throw new RuntimeException(e); // catch and re-thrown
}
```
* Java does not alloq you to use mulit-catch for subclasses of an exception, as this would be redundant:
```java
try {
    throw new IOException();
} catch (FileNotFoundException | IOException e) { } // COMPILER ERROR
```

* The caught exception of a multi-catch clause is **EFFECTIVELY FINAL**, meaning it can NOT be reassigned:
```java
try {
    throw new IOException();
} catch (IOException | RuntimeException e) {
    e = new RuntimeException(); // COMPILER ERROR
}
```

<hr>

# 🧠 6.4 Using Try-With-Resources
## 🟥 Introduction
* The try-with-resources statements enables use classes which need to be closed, without explicitly closing them.
* E.g. suppose we have the following method which reads the first line of file 1 and writes it to file 2:
```java
public void oldApproach(Path p1, Path p2) throws IOException {
    BufferedReader in = null;
    BufferedWriter out = null;
    try {
        in = Files.newBufferedReader(p1);
        out = Files.newBufferedWriter(p2);
        out.write(in.readLine());
    } finally {
        if (in != null) in.colose();
        if (out != null) out.close();
    }
}
```
* This can be re-written to use try-with-resources:
```java
public void newApproach(Path p1, Path p2) throws IOException {
    try (BufferedReader in = Files.newBufferedReader(p1);
        BufferedWriter out = Files.newBufferedWriter(p2)) {
            out.write(in.readLine());
    }
}
```

## 🟥 Try-With-Resources Basics

* Any resources opened within the try clause are closed at the end of the try clause!
* Having a catch/finally block is completely optional for try-with-resources!
* We can see the flow of the program in the following program:
```java
public class TwryWithResources {
    public static void main() {
        try (ThrowsException t = new ThrowsException();) {
            System.out.println("T");
        } catch (Exception e) {
            System.out.println("C");
        } finally {
            System.out.println("F");
        }
    }
}
class ThrowsException implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("I");
        throw new IOException();
    }
}
```
1) The `ThrowsException` is instantiated, the try clause is executed so it prints `T`
2) The try clause finishes, so `close()` is called so it prints `I`. This then throws an IOException
3) The catch clause catches the IOException, so it prints `C`
4) The finally clause executes, so it prints `F`
5) The program prints `TICF`

* Attempting to reference `t` outside the Catch clause will cause a compiler error.


## 🟥 AutoCloseable
* You can only instantiate a `AutoCloseable`/`Closeable` implementation, in the try clause
* The AutoCloseable class has a single method:
```java
public void close() throws Exception;
```
* `Closeable` is an older class, it not extends `AutoCloseable`. It restricts the exception thrown to `IOException`. the implementation must also be idempotent!


## 🟥 Supressed Exceptions
* If multiple exceptions are thrown, all but the first one is called supressed exceptions.
```java
public class JammedTurkeyCage implements AutoCloseable {
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close");
    }

    public static void main() {
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            throw new IllegalStateException("turkeys have run off");
        } catch (IllegalStateException e) {
            System.out.println("caught: " +e.getMessage());
            for (Throwable t:e.getSuppressed())
                System.out.println(t.getMessage());
        }
    }
}
```
1. The try instantiates the `JammedTurkeyCage`, it throws the exception which is caught and printed.
2. As a result the `IllegalStateException("Cage door does not close")` is supressed.
3. We can retrieve this suppressed exception by calling the `.getSupressed()` on the caught exception. This then prints `Cage door does not clause`

* We can also see the supressed exception when the wrong type is caught:
```java
try (JammedTurkeyCage t = new JammedTurkeyCage()) {
    throw new RuntimeException("turkeys have run off");
} catch (IllegalStateException e) {
    System.out.println("caught: "+ e.getMessage());
}
```
* Running this will throw an exception, and the following is printed in console:
```
Exception in thread "main" java.lang.RuntimeException: turkeys ran off
    atJammedTurkeyCage.main(JammedTurkeyCage.java:20)
    Suppressed: java.lang.IllegalStateException: Cage door does not close
```

* We also have suppressed exceptions, when there are 2 instances of AutoCloseable:
```java
try (JammedTurkeyCage t1 = new JammedTurkeyCage();
     JammedTurkeyCage t2 = new JammedTurkeyCage()) {
        System.out.println("turkeys entered cages");
     } catch (IllegalStateException e) {
        System.out.println("caught: " + e.getMessage());
        for (Throwable t: e.getSupressed())
            System.out.println(t.getMessage());
     }
```
1. The try clause will print `turkeys entered cages`
2. The resources will be closed. `t2` is closed, and it will throw an exception
3. The exception is caught, so it will print `caught: Cage door does not close`
3. `t1` is closed after but the exception is already thrown and caught, so it becomes supressed!
4. The supressed exception from `t1` is printed: `Cage door does not close`

* You also get supressed exceptions when there is a finally clause but no catches:
```java
try (JammedTurkeyCage t = new JammedTurkeyCage()){
    throw new IllegalStateException("turkeys ran off");
} finally {
    throw new RuntimeException("and we couldn't find them");
}
```
1. The exception is thrown in the try clause but is supressed, the resource is closed but a finally clause runs so the exception is supressed again.
2. Only the RuntimeException is thrown.


## 🟥 Putting It Together
* Resources are closed after the try clause ends and before any catch/finally blocks!
* Resources are closed in reverse order that they are created!

<hr>

# 🧠 6.5 Rethrowing Exceptions
* A common pattern is to log the exception and rethrow it.
* E.g.:
```java
public void multiCatch() throws SQLException, DateTimeParseException {
    try {
        parseData();
    } catch (SQLException | DateTimeParseException e) {
        System.err.println(e);
        throw e;
    }
}
```

<hr>

# 🧠 6.6 Working With Assertions
* You can create assertions with the following syntax:
```java
assert boolean_expression;
assert boolean_expression : error_message;
```
* By default the assertions are disabled. You can enable assertions globally using
```
java -enableassertions ClassName
java -ea ClassName
```
* You can target specific classes too:
```
java -da -ea:SpecificClassName
```
* If an assertion fails, a `java.lang.AssertionError` is thrown.