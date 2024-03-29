<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 10.6 Getting Data from a ResultSet
* We shall first look at forward-only ResultSets before looking at the scrollable ResultSets

## 🟥 10.6.1 Reading a ResultSet
* Most of the time you will loop through each row of a ResultSet:
```java
String url = "jdbc:derby:zoo";
try (Connection conn = DriverManager.getConnection(url);
     Statemenet stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery("SELECT id, name FROM animal")) {
      Map<Integer, String> idToNameMap = new HashMap<>();
      while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        System.out.println(id+" "+name);
        idToNameMap.put(id,name);
      }
      System.out.println(idToNameMap); 
      // ^^ {1=Elsa, 2=Zelda, 3=Ester, 4=Eddie, 5=Zoe}
}
```

* Another way of accessing the data from the ResultSet is by simply referring to the index of the column:
```java
int id = rs.getInt(1);
String name = rs.getString(2);
``` 

* If the SQL query were to return a singular alert, you can use an if check instead. E.g.:
```java
ResultSet rs = stmt.executeQuery("SELECT count(*) FROM animal");
if (rs.next())
  System.out.println(rs.getInt(1));
```

* It is essential to call `rs.next()` in order to obtain a result!!!
<hr>

## 🟥 10.6.2 Getting Data for a Column
* The ResultSet interface has countless methods, here are the one I need to know for the exam:
  - getBoolean: returns `boolean`
  - getDate: returns `java.sql.Date`
  - getDouble: returns `double`
  - getInt: returns `int`
  - getLong: returns `long`
  - getObject: returns `Object`
  - getTime: returns `java.sql.Time`
  - getTimestamp: returns `java.sql.Timestamp`

<br>

* Suppose our database had a `date_born` column, here is hows we would get the data:
```java
ResultSet rs = stmt.executeQuery("SELECT date_born FROM animal WHERE name = `Elsa`");
if (rs.next()) {
  java.sql.Date sqlDate = rs.getDate(1);
  LocalDate localDate = sqlDate.toLocalDate();
  System.out.println(localDate); // 2001-05-06
}
```
* Here is we would get the time:
```java
if(rs.next()) {
  java.sql.Time sqlTime = rs.getTime(1);
  LocalTime localTime = sqlTime.toLocalTime();
  System.out.println(localDate); // 02:15
}
```
* Here is how we would get both date AND time:
```java
if(rs.next()) {
  java.sql.Timestamp sqlTimeStamp = rs.getTimestamp(1);
  LocalDateTime localDateTime = sqlTimeStamp.toLocalDateTime();
  System.out.println(localDateTime); // 2001-05-06T02:15
}
```
* Here is an example of using `getObject()`:
```java
ResultSet rs = stmt.executeQuery("SELECT id, name FROM species")
while(rs.next()) {
  Object idField = rs.getObject("id");
  Object nameField = rs.getObject("name");
  // you can cast the above to int and String respectively
}
```
<hr>

## 🟥 10.6.3 Scrolling ResultSet
* A scrollable ResultSet lets you position the cursor at any row
* You can use `.pevious()` to obtain the previous record
* `.first()` and `.last()` methods give you the first and last rows.
* `.beforeFirst()` and `.afterLast()` position cursor before and after the rows beginning and end
* Here is an example in play:

```java
String url = "jdbc:derby:zoo";
String sqlQuery = "SELECT id FROM species"
  + " ORDER BY id";
try (Connection conn = DriverManager.getConnection(url);
     Statement stmt = conn.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sqlQuery)) 
    {
  rs.afterLast();

  System.out.println(rs.previous()); // true
  System.out.println(rs.getInt(1)); // 2
  
  System.out.println(rs.previous()); // true
  System.out.println(rs.getInt(1)); // 1

  System.out.println(rs.previous()); // false
  /* this will throw SqlException:
  rs.getInt(1);
  */

  System.out.println(rs.next()); // true
  System.out.println(rs.getInt(1)); // 1
}
```

<br>

* Another method I must be aware of is `.absolute(int)` - takes the absolute index of a row which you want to move the cursor to
* The method returns whether you can get data from the row:
```java
System.out.println(rs.absolute(0)); // false
System.out.println(rs.next()); // true
System.out.println(rs.getInt(1)); // 1
```
* The absolute index of 2 rows begin with 0 for beforeFirst, and 3 for afterLast
* We also have negative indices. -1 represents the last row and -3 would be the beforeFirst row
<br>

* There is also a `.relative(int)` method which moves the cursor forwards or backwards by the amount specified
