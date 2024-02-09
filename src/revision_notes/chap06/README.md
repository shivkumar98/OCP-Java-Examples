<link href="../../styles.css" rel="stylesheet"></link>


# ⚠️ Chapter 6 - Exceptions and Assertions - Revision Notes ✍️

## 🟥 6.1 Reviewing Exceptions
### 🟡 Terminology
* All exceptions/errors extend `java.lang.Object`
* `RuntimeException` is a subclass of `Exception`, it is AKA unchecked exception and there is no requirement to be caught (even though you can).
* Checked exceptions are `Exception` classes which DO NOT extend `RuntimeException`.
* `Error` classes are not `Exceptions` but a seperate subclass of `Throwable`

### 🟡 OCP Exceptions
* The pre-requiste exceptions from the OCA exam include:
1) `NumberFormatException` - thrown by program when attempting to convert string to numeric type
2) `IllegalArgumentException` - thrown by program
3) `NullPointerException` - thrown by JVM
4) `ArrayIndexOutOfBoundsException` - thrown by JVM
5) `ArithmeticException` - thrown by JVM when trying to divide by zero
6) `ClassCastException` - thrown by JVM when attempting to make cast an object to an invalid type

#### **OCP Checked Exceptions**:
1) `java.text.ParseException` 
- converting a number to string
1) `java.io.IOException`/`java.io.FileNotFoundException`/`java.io.NotSerializableException`
- All io exceptions can be assumed as checked
1) `java.sql.SQLException`
- All sql exception can be assumed as checked

#### **OCP Runtime Exceptions**:
1) `java.lang.ArrayStoreException`
- When attempting to add incorrect type to an array
2) `java.time.DateTimeException`
- Recieved when an invalid format string for a date
3) `java.util.MissingResourceException` - trying to access a resource or bundle that does not exist
4) `java.lang.UnsupportedOperationException`
5) `java.lang.IllegalStaceException`

<hr>

## 🟥 6.2 Creating Custom Exceptions
* You can create custom exceptions by extending `Exception` or `RuntimeException`
* Here are the 3 most common constructors for Exceptions:
```java
public class CanNotSwimException extends Exception {
	public class CanNotSwimException() { super(); }
	public class CanNotSwimException(Exception e) { super(e); }
	public class CanNotSwimException(String message) { super(message); }
}
```
<hr>

## 🟥 6.3 Using Multi-catch
* We can use multi-catch syntax to reduce code duplication when catching multiple exceptions@
```java
try {
	Path path = Paths.get("dophinsBorn.txt"); // throws IOEXception
	LocalDate date = LocalDate.parse("text"); // throws DateTimeParseException
} catch (DateTimeParseException | IOException e) {
	e.printStackTrace();
	throw new RuntimeException(e);
}
```
* The caught exception is EFFECTIVELY FINAL (i.e. it can not be instantiated or reassigned)⚠️⚠️⚠️
```java
try {
    throw new IOException();
} catch (IOException | RuntimeException e) {
    e = new RuntimeException(); // COMPILER ERROR
}
```
* A compiler error is generated if any of the exception types are UNREACHABLE, i.e. it can only catch checked exceptions which are declared and you can not have redudancies!⚠️⚠️⚠️
```java
try {
    throw new IOException();
} catch (FileNotFoundException | IOException e) { } // COMPILER ERROR
```
<hr>

## 🟥 6.4 Using Try-With-Resources
* You can use classes which implement `Closeable` OR `AutoCloseable` in try-with-resources clauses
* The `AutoCloseable` interface has a method: `void close() throws Exception;`
* It does not require the implemention to throw any exception at all:
```java
public class Turkey implements AutoCloseable {
	@Override
	public void close() {
		System.out.println("closed");
	}
	public static void main(String[] args) {
		try(Turkey t = new Turkey()) {
			System.out.println("opening turkey");
		}
	}
	// PRINTS:
	// opening turkey
	// closed
}
```
<br>



* If the `close()` method DOES throw a checked exception then it must be declared or caught!
```java
public class Turkey implements AutoCloseable {

	@Override
	public void close() throws Exception {
		throw new Exception();
	}
	public static void main(String[] args) {
		try(Turkey t = new Turkey()) { // COMPILER ERROR
			System.out.println("opening turkey");
		}
	}
}
```

<br>

* If the try clause itself throws an exception, it will be the one which is caught and the exceptions from `close()` will be SUPRESSED💡
```java
public static void main(String[] args) {
	try (Turkey t = new Turkey()) {
		throw new RuntimeException("inside try");
	} catch (Exception e) {
		System.out.println(e.getMessage()); // inside try 
		System.out.println(e.getSuppressed().length); // 1
	}
}
```
<br>



* In terms of ordering, the code is ran in the following order:
1) The code in try block
2) The close() methods of the resources in reverse order of instantiation
3) The code in catch block
4) The code in finally block 

```java
class Door implements AutoCloseable {
	public void close() {
		System.out.println("D");}}
class Window implements Closeable {
	public void close() {
		System.out.println("W"); 
	 	throw new RuntimeException();}}
public class AutocloseableFlow {
	public static void main(String[] args) {
		try (Door d = new Door(); Window w = new Window()) {
			System.out.print("T");
		} catch (Exception e) {
			System.out.print("E");
		} finally {
			System.out.print("F");
		} 
	} 
	// PRINTS: TWDEF
}
```

<hr>

## 🟥 6.5 Rethrowing Exceptions
* It is a common pattern to log an exception, and rethrowing the same exception:
```java
try {
	parseData();
} catch (IOException | DateTimeParseException e) {
	System.err.println(e);
	throw e;
}
```
<hr>

## 🟥 6.6 Working With Assertions
* By default, failing assertions will not cause any changes in program flow
* They need to be enabled using `-ea` or `-enableassertions` options when compiling the java class
* We can enable assertions for specifc classes by following the option with `:className`
* You can mix these options together. E.g. the following will disable assertions except for specified class: `java -da -ea:ClassName ClassName`

