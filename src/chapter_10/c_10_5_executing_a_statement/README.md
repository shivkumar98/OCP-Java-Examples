<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 10.5 Executing a Statement

## 🟥 INSERT/UPDATE/DELETE using executeStatement()
* Once we have obained a statement, we can obtain a result by using `.executeStatement(String sqlCommand)`
  * The sql command can be update/insert/delete
* Here is an example@
```java
Statement stmt = conn.createStatement();
int result = stmt.executeUpdate(
  "INSERT INTO species VALUES (10, 'Deer', 3)");
System.out.println(result); // 1
// ^^^^^ 1 is the number of rows affected

result = stmt.executeUpdate(
  "UPDATE species SET name = '' WHERE name = 'None'");
System.out.println(result); // 1

result = stmt.executeUpdate(
  "DELETE FROM species WHERE id = 10");
System.out.println(result); // 1
```
<hr>

## 🟥 SELECT using executeQuery()
* In order to run a SELECT statement and obtain a ResultSet, you need to use `.executeQuery(String sqlCommand)`
* E.g.:
```java
ResultSet rs = stmt.executeQuery("SELECT * FROM species");
```

## 🟥 Using execute()
* The third method we can perform on a statement is `.execute(String sqlCommand)`. The method returns true if a ResultSet can be extracted, otherwise an non select query was ran:
```java
Statement stmt = conn.createStatement();
boolean isResultSet = stmt.execute(sql);
if (isResultSet) {
  ResultSet rs = stmt.getResultSet();
  System.out.println("A query was ran");
} else {
  int result = stmt.getUpdateCount();
  System.out.println("An update was ran");
}

```

## 🟥 The Importance of PreparedStatement
* In real life, you should use a subclass of Statement: `PreparedStatement`
* This class has the following benefits:
1. Performance - PreparedStatement will figure out a plan to run the SQL efficiently
2. Security - can prevent SQL injection as JDBC can handle escaped quotes:
```java
PreparedStatement ps = conn.prepareStatement("delete from animal where name=?");
ps.setString(1, name);
ps.execute();
```
3. Readability - do not need to deal with string concatenation