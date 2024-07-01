<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 10: Review Questions - Attempt 3

* Date: 01/07/2024
* Score: 11/20 (55%)

| Question # | Correct |
| ---------- | ------- |
| 1          | ❌   |
| 2          | ❌   |
| 3          | ❌   |
| 4          | ✅   |
| 5          | ✅   |
| 6          | ✅   |
| 7          | ✅   |
| 8          | ✅   |
| 9          | ✅   |
| 10         | ✅   |
| 11         | ❌   |
| 12         | ✅   |
| 13         | ✅   |
| 14         | ❌   |
| 15         | ✅   |
| 16         | ✅   |
| 17         | ❌   |
| 18         | ❌   |
| 19         | ❌   |
| 20         | ❌   |


<hr>

## 🟧 Question 1

❓ Which interfaces or classes are in a database-specific JAR file (Choose all that apply)

A. Driver
B. Driver's implementation
C. DriverManager
D. DriverManager's implementation
E. Statement
F. Statement's implementation 

### My Answer:
* The Driver's implementation only
* **B**❌❌❌❌
* **CORRECT ANSWER: B,F**
<br>

<hr>

## 🟧 Question 2:

❓ Which are required parts of a JDBC URL (Choose all that apply)

* A. Connection parameters 
* B. Database name 
* C. `jdbc` 
* D. Location of database 
* E. Port 
* F. Password 
  
❓

### My Answer:
* url, username, password
* A - false
* B - false
* C - true
* D - true
* E - false
* F - true
* **C,D,F**❌❌❌❌
* **CORRECT ANSWER: B,C**
<br>

<hr>


## 🟧 Question 3

❓ Which of the following is a valid JDBC URL?

* A. `jdbc:sybase:localhost:1234/db` 
* B. `jdbc::sybase::localhost::/db` 
* C. `jdbc::sybase:localhost::1234/db` 
* D. `sybase:localhost:1234/db` 
* E. `sybase::localhost::/db` 
* F. `sybase:localhost::1234/db` 
  
❓

### My Answer:
* **C**❌❌❌❌
* **CORRECT ANSWER: A**
* The components of jdbc URL is `jdbc:database-name:database-specific-location-details`
* So only A is correct
<br>

<hr>

## 🟧 Question 4:

❓ What file is required inside a JDBC 4.0+ driver JAR

* A. `java.sql.Driver` 
* B. `META-INF/java.sql.Driver` 
* C. `META-INF/db/java.sql.Driver` 
* D. `META-INF/database/java.sql.Driver` 
* E. `META-INF/service/java.sql.Driver` 
  
❓

### My Answer:
* **E**✅✅✅✅
* Driver implementations are required in a faile called `java.sql.Driver` in `META-INF/service` folder
<br>

<hr>

## 🟧 Question 5

❓ Suppose that you have a table named `animal` with two rows. What is the result of the following code?

```java
6:   Connection conn = new Connection(url, userName, password);
7:   Statement stmt = conn.createStatement();
8:   ResultSet rs = stmt.executeQuery("select count(*) from animal");
9:   if (rs.next()) System.out.println(rs.getInt(1));
```

* A. 0
* B. 2
* C. There is a compiler error on line 6
* D. There is a compiler error on line 9
* E. There is a compiler error on another line
* F. A runtime exception

❓

### My Answer:
* Connection is not instantiated
* **C**✅✅✅✅
* Connection is obtain via a static method on DriverManager
<br>

<hr>

## 🟧 Question 6:

❓Which of the following are true (Choose all that apply) 

* A. Calling `Class.forName()` is mandatory for JDBC 4.0
* B. `Class.forName()` throws a `ClassNotFoundException` if the driver class is not found
* C. `Class.forName()` throws an SQLException if the driver class is not found
* D. `DriverManager.getConnection()` throws a `ClassNotFoundException` if the driver class is not found
* E. `DriverManager.getConnection()` throws a `SQLException` if the driver class is not found

❓

### My Answer:
* A - false
* B - true
* C - false
* D - false
* E - true
* **B,E**✅✅✅✅
<br>

<hr>

## 🟧 Question 7
❓ Which of the following can fill in the blank? (Choose all that apply)

```java
public void stmt(Connection conn, int b) throws SQLException {
    Statement stmt =  conn.createStatement(________, b);
}
```
❓

* A. `ResultSet.CONCUR_READ_ONLY`
* B. `ResultSet.CONCUR_UPDATABLE`
* C. `ResultSet.TYPE_FORWARD_ONLY`
* D. `ResultSet.TYPE_REVERSE_ONLY`
* E. `ResultSet.TYPE_SCROLL_INSESNTIVE`
* F. `ResultSet.TYPE_SCROLL_SENSITIVE`

### My Answer:
* I think the first parameter is for thhe scroll
* **C,E,F**✅✅✅✅
<br>

<hr>

## 🟧 Question 8:

❓ Given a valid `conn` object of type Connection, what will happen if you run this code when the requested mode is not supported?

```java
conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
```

* A. A `ClassNotFoundException` is thrown
* B. A `NoSuchTypeException` is thrown
* C. A `SQLException` is thrown
* D. A `TypeNoutFoundException` is thrown
* E. The code will run without throwing an exception
* F. None of the abopve. The code will not compile

### My Answer:
* **E**✅✅✅✅
<br>

<hr>


## 🟧 Question 9

❓ Which of the options can fill in the blanks in order to make the code compile?

```java
boolean bool = stmt.______(sql);
int num = stmt.________ (sql); 
ResultSet rs = stmt._____(sql);
```

* A. `execute, executeQuery, executeUpdate`
* B. `execute, executeUpdate, executeQuery`
* C. `executeQuery, execute, executeUpdate`
* D. `executeQuery, executeUpdate, execute`
* E. `executeUpdate, execute, executeQuery`
* F. `executeUpdate, executeQuery, execute`

### My Answer:
* execute for firtst one
* executeUpdate for sdecond
* executeQuery for third
* **B**✅✅✅✅
<br>

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

* A. `0` 
* B. `1` 
* C. `5` 
* D. The code does not compile 
* E. A `SQLException` is thrown 
* F. A different exception is thrown 

### My Answer:
* **C**✅✅✅✅
<br>

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

* A. 0
* B. 1
* C. 5
* D. The code does not compile
* E. A `SQLException` is thrown
* F. A different exception is thrown

### My Answer:
* **C**❌❌❌❌
* **CORRECT ANSWER: D**
* The `SQLException` is neither declared or handled
<br>

<hr>


## 🟧 Question 12:

❓ Which is the correct order in which to close database resources?

* A. `Connection,ResultSet,Statement`
* B. `Connection,Statement,ResultSet`
* C. `ResultSet,Connection,Statement`
* D. `ResultSet,Statement,Connection`
* E. `Statement,Connection,ResultSet`
* F. `Statement,ResultSet,Connection`

### My Answer:
* First ResultSet,Then statement then connection
* **D**✅✅✅✅
<br>

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

* A. 100
* B. 101
* C. The code does not compile
* D. A `SQLException` is thrown
* E. A different exception is thrown

### My Answer:
* An SQLException is thrown as stmt is closed after first execution
* **D**✅✅✅✅
* A new ResultSet is created which needs to be accessed in order for the code to work
<br>

<hr>

## 🟧 Question 14: 

❓ Which of the following can fill in the blank correctly? (Choose all that apply)

```java
ResultSet rs = stmt.executeQuery(sql);
if (rs.next()) {
_______________________________
}
```

* A. `String s = rs.getString(0);`
* B. `String s = rs.getString(1);`
* C. `String s = rs.getObject(0);`
* D. `String s = rs.getObject(1);`
* E. `Object s = rs.getObject(0);`
* F. `Object s = rs.getObject(1);`

### My Answer:
* A - valid
* B - valid
* C - invalid
* D - invalid
* E - valid
* F - valid
* **A,B,E,F**❌❌❌❌
* **CORRECT ANSWER: B,F**
* You cannot access zeroth index, index begins at 1 so A and E are wrong
<br>

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
* **F**✅✅✅✅
<br>

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
* I think an exception is thrown since only 1 column is returned from the selection
* **E**✅✅✅✅
* I got this right but for wrong reason
* The Statement object, by default, is not scrollable!
<br>

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
* A - valid
* B - invalid
* C - valid
* D - valid
* E - invalid
* F - invalid
* **A,C,D**❌❌❌❌
* **CORRECT ANSWER: C,D**
<br>

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
* **E**❌❌❌❌
* **CORRECT ANSWER: A**
<br>

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
* **CORRECT ANSWER: C**
* First one prints false
* second pprints true
* third prints true
* fourth prints true
* fifth prints false
<br>

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
* **G**❌❌❌❌
* **CORRECT ANSWER: F**
* `beforeFirst()`/`afterLast()` have void return
<br>

<hr>