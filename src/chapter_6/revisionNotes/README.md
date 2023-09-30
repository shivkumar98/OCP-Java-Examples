<link href="../../styles.css" rel="stylesheet"></link>

# 📝 Chapter 6: Revision Notes

# 🧠 6.1 Reviewing Exceptions

## 🟥 Categories of Exceptions
* Checked exceptions, RuntimeExceptions and Error all extends `java.lang.Throwable`
* Checked exceptions extend `java.lang.Exception` but not `java.lang.RuntimeException`. These MUST be declared or handled in a try/
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

## 🟥 H2

### 🟡 H3
