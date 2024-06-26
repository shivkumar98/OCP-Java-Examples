# 📜 Revision Notes 📜

## 🧠 Chapter 1: Advanced Class Design
* A Nested class cannot have static variables because a nested class always has to be instantiated⚠️
* A nested class can access its enclosing class using the following syntax: `enclosingClassName.this.variableName`. E.g.:
```java
class Outer {
   int x = 10;
   class Inner {
      int x = Outer.this.x;
   }
}
```
* A member nested class can NOT have static variables⚠️
```java
class Outer {
   class Inner {
      static int x = 1; // COMPILER ERROR
   }
}
```
* We can only declare static variable in STATIC nested classes
* If we have a nested class `Inner` we can instantiate it by first instantiating `Outer`; we can use `Inner` as a reference to this instance, provided its imported
```java
class Outer {
   class Inner {}
}

Inner inner = new Inner(); // COMPILER ERROR
Inner inner = new Outer().new Innner(); // WORKS!
```

## 🧠 Chapter 2: Design Patterns and Principles
* If you are using the return keyword in lambda, it MUST be in curly braces
```java
() -> return 0; // COMPILER ERROR
```
* Singleton classes have the following properties:
   - Instance is private and static
   - Ensures only one instance is kept in memory
   - Instance is accessed via public static method which returns a copy of the reference
   - Synchnrozing the Singleton class is not essential but does improve Singleton pattern
* Immutable classes have the folloiwing properties:
   - private final variables
   - If a member is a list, it should not give direct reference in getter, and constructor should take a copy to set fields
   - No setters
* Interfaces can extend abstract classes or interfaces, NOT concrete classes!
* Interface can not implement mmultiple interfaces if it inherits two default methods of same signature
```java
interface CanWalk {
   void walk() { System.out.println("walk"); }
}
interface CanRun {
   void walk() { System.out.println("walk"); }
}
public interface invalidInterface extends CanWalk, CanRun { // COMPILER ERROR
}
```

## 🧠 Chapter 3 Generics and Collections
* The ArrayDeque has a pop method which removes and returns the start of the List, peek method only returns start of List
* The `List` interface has a `remove(index)` method, while `Queue` has `remove(T object)` method

## 🧠 Chapter 4 Functional Programming
* The stream has `.sorted(Comparator)` method

## 🧠 Chapter 5 Dates, Strings and Localization
* You can create Locales which follow the standard naming convention in 2 ways:
   1. `new Locale("language");`
   2. `new Locale("language", "COUNTRY");`
* When java will look for properties file, it will first look for a java file then a properties file
* We can format Date/Time objects using `DateTimeFormatter` which has the following methods:
  - `.ofLocalizedDate(FormatStyle)`
  - `.ofLocalizedTime(FormatStyle)`
  - `.ofLocalizedDateTime(FormatStyle)`
* The FormatStyle class is an enum with the following options:
  - `SHORT`
  - `MEDIUM`
  - `LONG`
  - `FULL`
* You can NOT chain Period methods, only the last method will apply!⚠️
* The `Properties` class has the following methods for getting values from the resource bundle:
   1. `.get(key)`
   2. `.getProperty(key)`
   3. `.getProperty(key, defaultValue)`

## 🧠 Chapter 6 Exceptions and Assertions
* Multi-catch is used to catch multiple UNRELATED exceptions
* You will get compiler erro if you attempt to catch related types:
```java
try {
} catch (IOException | FileNotFoundException e) {} // COMPILER ERROR
```
* You can not reassign the caught exception from multi-catch block, but you CAN rethrow it!!!
* AutoCloseable's close method throws Exception, while Closeable throws only IOException => Closeable's close() method can NOT throw Exception!!!

## 🧠 Chapter 7 Concurrency
* The `Callable` interface returns a generic type and has no parameters:
```java
V call() throws Exception;
```
* The `Runnable` interface has no return and throws no exception
```java
run();
```
* The ScheduledExecutorService, a sub-interface of ExecutorService, has methods which only accept `Runnable` implementations!!!
* Race Conditions are when 2 or more threads try to complete a task at the same time!
* `CopyOnWriteArrayList` avoids concurrent modifications when modifiying the collection while looping through it
* `.reduce(U identity, BiFunction<U, T> accumulator, BinaryOperator<U>)`

## 🧠 Chapter 9 NIO.2
* `Files.deleteIfExists(Path)` method can only delete empty directories
* `Files.isDirectory(Path)` AND `Files.deleteIfExists(Path)` methods support symbolic links!!
* The `Files.readAttributes()` method is intended for only reading attributes, we can not write them!
* The `Path.toAbsolutePath()` converts a relative path to absolute path by appending it to current work directory.
* The `Files.walk(Path)` method returns `Stream<Path>`
* When `Files.isSameFile(path1, path2)` is called, if the paths are different in type (one relative, one absolute), then it will check that the files actually exist

## 🧠 Chapter 10 JDBC
* For JDBC 4.0, vendors MUST provided implementations for Driver and Statement. Note: DriverManager is built into JDK
* The only required components of the JDBC URL is name of database and the string `jdbc`
* The components of jdbc URL is seperated by SINGLE colons and has the following format: `jdbc:database-name:database-specific-location-details`
* In JDBC 4.0+, `DriverManager.getConnection()` throws a `SQLException` if the driver class is not found. In older versions we use `Class.forName()` which throws `ClassNotFoundException`
* The `Connection.createStatement(int resultSetType, int resultSetConcurrency)` has parameters with constants defined in JDK:
  * `ResultSet.TYPE_FORWARD_ONLY`
  * `ResultSet.TYPE_SCROLL_INSENSITIVE`
  * `ResultSet.TYPE_SCROLL_SENSITIVE`
* The above method will NOT throw an exception if the mode parameters specified are not suppported by the database
* The Statement class has 3 methods for executing queries:
```java
boolean execute(query);
int executeUpdate(query);
ResultSet executeQuery(query);
```
* The columns of `ResultSet` begin at an index of 1, attempting to access zeroth index will throw an exception
* The ResultSet's `next()`/`previous()`/`absolute()` methods return a boolean of whether cursor is on row