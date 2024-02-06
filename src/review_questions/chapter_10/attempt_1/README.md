<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 10: Review Questions - Attempt 1

## Results:

Date:  <br>
Score: <br>
❌✅
| Question # | Correct |
| ---------- | ------- |
| 1          |        |
| 2          |        |
| 3          |        |
| 4          |        |
| 5          |        |
| 6          |        |
| 7          |        |
| 8          |        |
| 9          |        |
| 10         |        |
| 11         |        |
| 12         |        |
| 13         |        |
| 14         |        |
| 15         |        |
| 16         |        |
| 17         |        |
| 18         |        |
| 19         |        |
| 20         |         |


<hr>

## 🟧 Question 1

❓ Which interfaces or classes are in a database-specific JAR file (Choose all that apply)

A. Driver <br>
B. Driver's implementation <br>
C. DriverManager <br>
D. DriverManager's implementation <br>
E. Statement <br>
F. Statement's implementation <br>


### My Answer:
* A - false, would not contain an interface
* B - true
* C - false
* D - true
* E - false
* F - true
* **B,D,F**
<hr>

## 🟧 Question 2:

❓ Which are required parts of a JDBC URL (Choose all that apply)

* A. Connection parameters <br>
* B. Database name <br>
* C. `jdbc` <br>
* D. Location of database <br>
* E. Port <br>
* F. Password <br>
  
❓

### My Answer:
* A - true
* B - true
* C - true
* D - true
* E - false, port number is optional
* F - false, password may not be needed
* **A,B,C,D**
<hr>


## 🟧 Question 3

❓ Which of the following is a valid JDBC URL?

* A. `jdbc:sybase:localhost:1234/db` <br>
* B. `jdbc::sybase::localhost::/db` <br>
* C. `jdbc::sybase:localhost::1234/db` <br>
* D. `sybase:localhost:1234/db` <br>
* E. `sybase::localhost::/db` <br>
* F. `sybase:localhost::1234/db` <br>
  
❓

### My Answer:
* D, E and F are false as they are missing the protocol
* A is the correct answer
* **A**
<hr>

## 🟧 Question 4:

❓ What file is required inside a JDBC 4.0+ driver JAR

* A. `java.sql.Driver` <br>
* B. `META-INF/java.sql.Driver` <br>
* C. `META-INF/db/java.sql.Driver` <br>
* D. `META-INF/database/java.sql.Driver` <br>
* E. `META-INF/service/java.sql.Driver` <br>
  
❓

### My Answer:
* I don't think any of these are valid!
<hr>

## 🟧 Question 5

❓ Suppose that you have a table named `animal`  with two rows. What is the result of the following code?

```java
6:   Connection conn = new Connection(url, userName, password);
7:   Statement stmt = conn.createStatement();
8:   ResultSet rs = stmt.executeQuery("select count(*) from animal");
9:   if (rs.next()) System.out.println(rs.getInt(1));
```

* A. 0 <br>
* B. 2 <br>
* C. There is a compiler error on line 6 <br>
* D. There is a compiler error on line 9 <br>
* E. There is a compiler error on another line <br>
* F. A runtime exception <br>

❓

### My Answer:
* I don't THINK line 6 compiles
* If it did compile, line 9 WOULD compile
* **C**
<hr>

## 🟧 Question 6:

❓Which of the following are true (Choose all that apply) 

* A. Calling `Class.forName()` is mandatory for JDBC 4.0 <br>
* B. `Class.forName()` throws a `ClassNotFoundException` if the driver class is not found <br>
* C. `Class.forName()` throws an SQLException if the driver class is not found <br>
* D. `DriverManager.getConnection()` throws a `ClassNotFoundException` if the driver class is not found <br>
* E. `DriverManager.getConnection()` throws a `SQLException` if the driver class is not found <br>

❓

### My Answer:
* A - false, this method is not necessary
* I THINK `Class.forName()` throws a ClassNotFoundException
* I think `DriverManager.getConnection()` throws SQLException as this was needed to be declared in the code I wrote for this chapter
* **B,E**
<hr>


## 🟧 Question 7
❓ Which of the following can fill in the blank? (Choose all that apply)

```java
public void stmt(Connection conn, int b) throws SQLException {
    Statement stmt =  conn.createStatement(________, b);
}
```
❓

* A. `ResultSet.CONCUR_READ_ONLY` <br>
* B. `ResultSet.CONCUR_UPDATABLE` <br>
* C. `ResultSet.TYPE_FORWARD_ONLY` <br>
* D. `ResultSet.TYPE_REVERSE_ONLY` <br>
* E. `ResultSet.TYPE_SCROLL_INSESNTIVE` <br>
* F. `ResultSet.TYPE_SCROLL_SENSITIVE` <br>

### My Answer:
* So the first argument of the createStatement method determines the scrollability of the ResultSet
* **C,E,F**
<hr>

## 🟧 Question 8:

❓ Given a valid `conn` object of type Connection, what will happen if you run this code when the requested mode is not supported?

```java
conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
```

* A. A `ClassNotFoundException` is thrown <br>
* B. A `NoSuchTypeException` is thrown <br>
* C. A `SQLException` is thrown <br>
* D. A `TypeNoutFoundException` is thrown <br>
* E. The code will run without throwing an exception <br>
* F. None of the abopve. The code will not compile <br>

### My Answer:
* There will not be any compilation issues
* I do believe the code will still run without exception throwing as the modes will fallback to a supported mode
* **E**
<hr>


## 🟧 Question 9

❓ Which of the options can fill in the blanks in order to make the code compile?

```java
boolean bool = stmt.______(sql);
int num = stmt.________ (sql); 
ResultSet rs = stmt._____(sql);
```

* A. `execute, executeQuery, executeUpdate` <br>
* B. `execute, executeUpdate, executeQuery` <br>
* C. `executeQuery, execute, executeUpdate` <br>
* D. `executeQuery, executeUpdate, execute` <br>
* E. `executeUpdate, execute, executeQuery` <br>
* F. `executeUpdate, executeQuery, execute` <br>

### My Answer:
* The first blank is definitely execute, which returns whether a result set is returned or not
* The second is executeUpdate which returns number of rows updated
* The third is executeQuery which returns a result set
* **B**
<hr>

## 🟧 Question 10

❓ Suppose that the table `animal` has 5 rows and this SQL statement updates all of them. What is the result of this code?

```java
public static void main(String[] args) throws SQLException {
    Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
    Statement stmt = conn.createStatement();
    int result = stmt.executeUpdate("update animal set name = name");
    System.out.println(result);
}
```

* A. `0` <br>
* B. `1` <br>
* C. `5` <br>
* D. The code does not compile <br>
* E. A `SQLException` is thrown <br>
* F. A different exception is thrown <br>

### My Answer:
* The code looks all good to me
* It will update all 5 rows
* **C**
<hr>

## 🟧 Question 11

❓ Suppose that the table `food` has five rows and this SQL statement updates all of them. What is the result of this code?

```java
public static void main(String[] args) {
    Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
    Statement stmt = conn.createStatement();
    int result = stmt.executeUpdate("update food set amount = amount + 1");
    System.out.println(result);
}
```

* A. 0 <br>
* B. 1 <br>
* C. 5 <br>
* D. The code does not compile <br>
* E. A `SQLException` is thrown <br>
* F. A different exception is thrown <br>

### My Answer:
* I believe the code does compile and returns 5
* **C**
<hr>


## 🟧 Question 12:

❓ Which is the correct order in which to close database resources?

* A. `Connection,ResultSet,Statement` <br>
* B. `Connection,Statement,ResultSet` <br>
* C. `ResultSet,Connection,Statement` <br>
* D. `ResultSet,Statement,Connection` <br>
* E. `Statement,Connection,ResultSet` <br>
* F. `Statement,ResultSet,Connection` <br>

### My Answer:
* The resources shall be closed in the reverse order they were created. So the Connection is first connected, then Statement, and finally ResultSet
* **D**
<hr>

## 🟧 Question 13

❓ There are currently 100 rows in the table `species` before inserting a new row. What is the output of the following code?

```java
try (Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
     Statement stmt = conn.createStatement()) {
  ResultSet rs = stmt.executeQuery("select count(*) from species");
  int num = stmt.executeQuery("INSERT INTO species VALUES (3, 'Ant', .05)");
  rs.next();
  System.out.println(rs.getInt(1));
}
```

* A. 100 <br>
* B. 101 <br>
* C. The code does not compile <br>
* D. A `SQLException` is thrown <br>
* E. A different exception is thrown <br>

### My Answer:
* The statement is using the default read only mode for the result set
* So when printing the result, we get 100
* **A**
<hr>

## 🟧 Question 14: 

❓ Which of the following can fill in the blank correctly? (Choose all that apply)

```java
ResultSet rs = stmt.executeQuery(sql);
if (rs.next()) {
_______________________________
}
```

* A. `String s = rs.getString(0);` <br>
* B. `String s = rs.getString(1);` <br>
* C. `String s = rs.getObject(0);` <br>
* D. `String s = rs.getObject(1);` <br>
* E. `Object s = rs.getObject(0);` <br>
* F. `Object s = rs.getObject(1);` <br>

### My Answer:
* C and D do not compile as the `getObject()` method returns Object
* B is valid, F is valid
* A and E are invalid
* **B,F**
<hr>

## 🟧 Question 15 

❓ Which of the following can fill in the blank to print the month,date,year,hour,minute and second? ❓

* A. `rs.getDate("d");`
* B. `rs.getLocalDate("d");`
* C. `rs.getLocalDateTime("d");`
* D. `rs.getLocalTime("d");`
* E. `rs.getTime("d");`
* F. `rs.getTimeStamp("d");`

### My Answer:
* I cheated and looked at the answers because I didn't understand the question
* B,C,D are not valid options
* Only A and F seem right
* **A,F**
<hr>

## 🟧 Question 16 

❓ Suppose you have a table with three rows. The names in the rows are Anna, Betty and Cat. What does the following output?

```java
String sql = "select name from animal";
try (Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
     Statement stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery(sql)) {
  rs.next();
  rs.previous();
  rs.previous();
  rs.next();
  rs.next();
  rs.absolute(2);
  System.out.println(rs.getString(1));
}
```

* A. Anna
* B. Betty
* C. Cat
* D. The code does not compile
* E. A SQLException is thrown

### My Answer:
* The cursor is orginally at index 0 
* Then 1, then 0, still at 0, then at 1, then at 2, then at 2
So the answer will be Betty
* **B**
<hr>

## 🟧 Question 17

❓Which of the following is equivalent to this code❓

```java
UnaryOperator<Integer> u = x -> x * x;
```

* A. `BiFunction<Integer> f = x -> x*x;`
* B. `BiFunction<Integer, Integer> f = x -> x*x;`
* C. `BinaryOperator<Interger, Integer> f = x -> x*x;`
* D. `Function<Integer> f = x -> x*x;`
* E. `Function<Integer, Integer> f = x -> x*x;`
* F. None of these above

### My Answer:
* **E**✅✅✅✅
<hr>

## 🟧 Question 18

❓What is the result of the following❓

```java
DoubleStream s = DoubleStream.of(1.2, 2.4);
s.peek(System.out.::println).filter(x -> x > 2).count();
```

* A. 1
* B. 2
* C. 2.4
* D. 1.2 and 2.4
* E. There is no output
* F. The code does not compile
* G. An exception is thrown

### My Answer:
* 1.2 and 2.4 will come through
* **D**✅✅✅✅
<hr>

## 🟧 Question 19

❓Which of the following return primitives❓

* A. `BooleanSupplier`
* B. `CharSupplier`
* C. `DoubleSupplier`
* D. `FloatSupplier`
* E. `IntSupplier`
* F. `StringSupplier`

### My Answer:
* **A,C,E**✅✅✅✅
<hr>

## 🟧 Question 20

❓What is the simplest way of rewriting this code❓

```java
List<Integer> l = IntStream.range(1,6)
    .mapToObj(i -> i).collect(Collectors.toList());
l.forEach(System.out::println);
```

* A. 
```java
IntStream.range(1,6);
```
* B. 
```java
IntStream.range(1,6)
    .forEach(System.out::println);`
```
* C. 
```java
IntStream.range(1,6)
    .mapToObj(i->i)
    .forEach(System.out::println);
```
* D. None of the above is equivalent
* E. The provided code does not compile

### My Answer:
* The range is not closed so A and B are false
* C is correct
* **C**❌❌❌❌
* I misread the question, B is the simplest!
<hr>