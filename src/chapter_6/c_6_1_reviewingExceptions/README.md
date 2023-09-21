<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 6.1 Reviewing Exceptions

* Here are some possibilities for a program to fail which are covered on the exam:
- Trying to read a file which does not exist
- Trying to access a database whose connections is unavailable
- Invalid SQL statement in JDBC code
- Coding errors, e.g. using wrong format specifier when using DateTimeFormatter.

## 🟥 6.1.1 Exceptions Terminology
* When creating a method, you can either deal with the exception or delegate it to method caller. 

<br>

## 🟥 6.1.2 Categories of Exceptions

* The hierarch of Exceptions is:
```
                  java.lang.Object
                        ⬆️
                java.lang.Throwable
                  ↗️         ↖️
      java.lang.Exception   java.lang.Error
            ⬆️
java.lang.RuntimeException     
```

* A runtime (unchecked) exceptions, can be caught but is not required to be caught
* A checked exception is any class which extends `Exception` BUT BOT `RuntimeException`
- Checked exceptions must be either caught or thrown to the caller.
* An error is fatal and should NOT be caught.

<br>

## 🟥 6.1.3 Exceptions on the OCP
* The OCA exam had the following exceptions:
1) `ArithmeticException` - Thrown by JVM when attempting to divide by zero
2) `NullPointerException` - Thrown by JVM when trying to reference an object which is null
3) `ArraysIndexOutOfBoundsException` - Thrown by JVM when trying to access an index which is not present
4) `IllegalArgumentException` - Thrown by programmer when an argument passed to a method is inappropiate
5) `ClassCastException` - Thrown by JVM when trying to cast an object to an incorrect class
6) `NumberFormatException` - Thrown by programmer when trying to format a String, but is in an innapropiate format

* The OCP exam includes a mix of unchecked and checked exceptions.
* Checked exceptions:
1) `java.text.parseException` - trying to parse a String to a number
2) `java.sql.SQLException` - dealing with database issues
3) `java.IO.IOException`/`java.IO.FileNotFoundException`/`java.IO.NotSerializableException` - dealing with IO and NIO.2 issues
* Unchecked exceptions:
1) `java.lang.ArrayStoreException` - when trying to add the wrong type to an array
2) `java.time.DateTimeException` - when recieving invalid formatter string for a date
3) `java.util.MissingResourceException` - when the key/resource bundle is not present
4) `java.lang.IllegalStateException`/`java.lang.UnsupportedOperationException` - attempting to run invalid operatioon in collections or concurrency

<br>

## 🟥 6.1.4 Try Statement
* A try statment has the following syntax, where a line is attempted to be executed and one or more catch statements and an optional finally clause:
```java
try {
      // protected code
} catch (ExceptionType e) {
      // handle exception
} finally {
      // finally block
}
```
* **RULE:** If the try has no catches, it must have finally. If there is no finally, then there MUST be a catch!.
* The above rule does not apply with `try-with-resources`


## 🟥 H2

### 🟡 H3