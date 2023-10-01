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

## 🟥 H2

### 🟡 H3
