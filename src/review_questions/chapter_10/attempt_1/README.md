<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 10: Review Questions - Attempt 1

## Results:

Date: 07/02/2024 <br>
Score: 11/20 <br>

| Question # | Correct |
| ---------- | ------- |
| 1          |  ❌      |
| 2          |  ❌      |
| 3          |  ✅      |
| 4          |  ❌      |
| 5          |  ✅      |
| 6          |  ✅      |
| 7          |  ✅      |
| 8          |  ✅      |
| 9          |  ✅      |
| 10         |  ✅      |
| 11         |  ❌      |
| 12         |  ✅      |
| 13         |  ❌      |
| 14         |  ✅      |
| 15         |  ❌      |
| 16         |  ❌      |
| 17         |  ❌      |
| 18         |  ✅      |
| 19         |  ❌      |
| 20         |  ✅      |


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
* **B,D,F**❌❌❌
<br>

* Correct answer: **B,F**
* The interface and its concretion `DriverManager` is part of the JDK
* Only Driver's and Statement's implementations are found in the database specific jar file
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
* **A,B,C,D**❌❌❌❌

* CORRECT ANSWER: **B,C**
* The vendor name and the database name are the required components of the JDBC URL
* The Connection paramaeters, IP address/location and port number are all optional
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
* **A**✅✅✅✅
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
* I don't think any of these are valid!❌❌❌❌

<br>

* As of JDBC 4.0, all driver implementations were required to provide the name of the class implementing `Driver` in a file names `java.sql.Driver` in a directory `META-INF/service`
<hr>

## 🟧 Question 5

❓ Suppose that you have a table named `animal` with two rows. What is the result of the following code?

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
* **C**✅✅✅✅
* Connection is not acquired through a constructor, it is statically acquired so C is correct
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
* **B,E**✅✅✅✅
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
* **C,E,F**✅✅✅✅
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
* **E**✅✅✅✅
* The JDBC driver will automatically downgrade the mode to one which is supported
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
* **B**✅✅✅✅
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
* **C**✅✅✅✅
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
* **C**❌❌❌❌
<br>

* CORRECT ANSWER: **D**
* The code does not compile as `SQLException` is not declared or handled!
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
* **D**✅✅✅✅
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
* **A**❌❌❌❌
<br>

* CORRECT ANSWER: **D**
* Statement automatically closes the ResultSet when another SQL statement is ran. The `rs` throws an SQLException when trying to call `rs.getInt(1)`
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
* **B,F**✅✅✅✅
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
* **A,F**❌❌❌❌
<br>

* CORRECT ANSWER: **F**
* The `.getDate()` method only returns month, date and year!
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
* **B**❌❌❌❌
<br>

* CORRECT ANSWER: **E**
* An SQLException is thrown as the ResultSet is not scrollable so we can't call `.previous()`

<hr>

## 🟧 Question 17

❓ Which of the following methods move the cursor without returning a boolean?

* A. `absolute()`
* B. `afterFirst()`
* C. `afterLast()`
* D. `beforeFirst()`
* E. `beforeLast()`
* F. `previous()`

### My Answer:
* I don't think beforeLast or afterFirst are actually methods so B and E are false
* previous and next do return booleans, so F is out
* I dont think beforeFirst or afterLast return booleans so C and D seem right
* I don't think absolute returns a boolean neither so A
* **A,C,D**❌❌❌❌

* CORRECT ANSWER: **C,D**
* Only `afterLast()` and `beforeFirst()` do not return booleans - which makes sense as these do not need there to be rows to be true
<hr>

## 🟧 Question 18

❓ Suppose that you have a table `animal` with three rows. The names in these rows are Anna, Betty and Cat. What does the following output

```java
String sql = "select name from animal order by id";
try (Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
     Statement stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery(sql)) {
  rs.absolute(0);
  rs.next();
  System.out.println(rs.getString(1));
}
```

* A. Anna
* B. Betty
* C. Cat
* D. The code does not compile
* E. A SQLException is thrown

### My Answer:
 * I think it will print the first row
 * **A**✅✅✅✅
<hr>

## 🟧 Question 19

❓ In a table `animal` with 10 rows, how many times does `true` get output by the following? (Choose all that apply)

```java
String sql = "select * from animal";
try (Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
     Statement stmt = conn.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
     ResultSet rs = stmt.executeQuery(sql)) {
  System.out.println(rs.absolute(0));
  System.out.println(rs.absolute(5));
  System.out.println(rs.previous());
  System.out.println(rs.relative(-2));
  System.out.println(rs.relative(-100));
}
```

* A. One
* B. Two
* C. Three
* D. Four
* E. Five
* F. The code does not compile
* G. A `SQLException` is thrown

### My Answer:
* **F**❌❌❌❌
<br>

* CORRECT ANSWER: **C**
* The methods return whether the cursor is on a row or not
* The first print is `false`
* The second print is `true` as its on the fifth row
* The third print is `true` as its on the 4th row
* The fourth print is put on the second row so `true` is printed
* The fifth print is put on the zeroth row so false is printed
* So 3 trues are printed!!!
<hr>

## 🟧 Question 20

❓ In the table `animal` with 10 rows, how many times does `true` get output by the following (Choose all that apply)

```java
String sql = "select * from animal";
try (Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
     Statement stmt = conn.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
     ResultSet rs = stmt.executeQuery(sql)) {
  System.out.println(rs.beforeFirst());
  System.out.println(rs.absolute(5));
  System.out.println(rs.previous());
  System.out.println(rs.relative(-2));
  System.out.println(rs.afterLast());
}
```
* A. One
* B. Two
* C. Three
* D. Four
* E. Five
* F. The code does not compile
* G. A `SQLException` is thrown

### My Answer:
* **F**✅✅✅✅
* `beforeFirst()` and `afterLast()` methods have void return and cannot be printed
<hr>