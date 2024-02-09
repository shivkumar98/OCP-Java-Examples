<link href="../styles.css" rel="stylesheet"></link>

# Revision Notes ✍️



<hr>


-----------------------------------------------------------



--------------------------------------------------














-------------------------------------------------------------

# 💾 Chapter 10 - JDBC 💾

## 🟥 10.1 Introducing the interfaces of JDBC
* The four key interfaces of JDC are:
1. Driver - knows how to obtain connection to the DB
2. Connection - knows how to interact with DB
3. Statement - knows how to run SQL
4. ResultSet - knows what to return from a SELECT query
* A database's JAR will have implementations with a name of `VendorName+Interface`, e.g. MySQLDriver

## 🟥 10.2 Connecting to a DB

### ⭐ JDBC URL ⭐
* The URL consists of three required parts:
1. `jdbc`
2. Vendor name
3. Database name
* E.g. `jdbc:derby:zoo`
* The location of the database, port number, connection parameters, password are all optional!💡

### ⭐ Database Connection ⭐
* DriverManager is one way to obtain a connection - it is contained in the JDK
* This class implements the singleton pattern and has a `.getConnection(String jdbcUrl)` method:
```java
public static void main(String[] args) throws SQLException {
	Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
	System.out.println(conn);
	// org.apache.derby.impl.jdbc.EmbedConnection40@1372082959...
}
```
* The DriverManager class seeks the classpath for JARs which contain a `Driver`. 
* JDBC 4 requires that a file called `java.sql.Driver` is contained a directory `META-INF/service` - the filename is fully qualified
* There will also be files for Connection, Statement, and ResultSet
<br>

* Older code may load up a class using `Class.forName(String)` which throws a checkked ClassNotFoundException

## 🟥 10.3 Obtaining a Statement
* We can obtain a Statement easily from our connection:
```java
Statement stmt = conn.createStatement();
```
* This will use the default mode of `ResultSet.TYPE_FORWARD_ONLY` and a concurrency mode of `ResultSet.CONCUR_READ_ONLY`
* There is an overload which lets us specify the scroll and concurrency modes:
```java
Statement createStatement(int resultSetType, int resultSetConcurrency);
```
* We have the following ResultSet types:
1. `ResultSet.TYPE_FORWARD_ONLY` - rows can only be traversed forwards
2. `ResultSet.TYPE_SCROLL_INSENSITIVE` - rows can be traversed both forwards and backwards but will NOT change if table is updated
3. `ResultSet.TYPE_SCROLL_SENSITIVE` - forwards and backwards scrolling but DOES update if table is updated

* We have the following concurrency modes:
1. `ResultSet.CONCUR_READ_ONLY` - provides a read only view of the data
2. `ResultSet.CONCUR_UPDATABLE` - enables you to update the table through the ResultSet

* JDK will automatically downgrade a mode if the database does not support the mode😅


## 🟥 10.4 Executing a Statement
* INSERT/UPDATE/DELETE queries must be done using a `int executeUpdate(String)` method. Attempting to do a selection will throw an SQLException at runtime!😱
* SELECT queries must be done using a `ResultSet executeQuery(String)` method. Attempting to modify the table will throw an SQLException at runtime!😱
* We have a method which can do both select and update queries: `boolean execute(String)` which returns whether a ResultSet is returned:
```java
boolean isAResultSet = stmt.execute(sql);
if (isAResultSet)
	ResultSet rs = stmt.getResultSet();
else
	int numberOfRowsUpdated = stmt.getUpdateCount();
```


## 🟥 10.5 Getting Data from a ResultSet
### ⭐ Reading a ResultSet ⭐
* For a type-forward-only ResultSet, we can look at the results using `next()` which returns whether the cursor is on a row:
```java
ResultSet rs = stmt.executeQuery("select id, name from species");
while (rs.next()) {
	int id = rs.getInt(1); // rs.getInt("id") also works
	String name = rs.getInt(2); // rs.getString("name") also works
	System.out.println(id+" "+name);
	/* prints the following
	   1 African Elphhant
	   2 Zebra
	*/
}
```
* Attempting to obtain data from ResultSet without calling `next()` will throw a `SQLException`⚠️
* Attempting to access a non-existent column with also throw a `SQLException`


### ⭐ Getting Data for a Column ⭐
* The ResultSet interface has many `getType()` methods.
* There are two methods which return sql types:
```java
java.sql.Time getTime(); // for TIME
java.sql.Date getDate(); // for TIMESTAMP
java.sql.TimeStamp getTimeStamp(); // for TIMESTAMP
```

* We can use getTime() for a TIMESTAMP column, it will only return the time component
```java
ResultSet rs = stmt.executgeQuery("select dateborn from animal");
if(rs.next()) {
  java.sql.Date sqlDate = rs.getDate(1);
  LocalDate date = sqlDate.toLocalDate(); // 2001-05-06
  java.sql.Time sqlTime = rs.getTime(1);
  LocalTime time = sqlTime.toLocalTime(); // 02:15
  java.sql.TimeStamp sqlTimeStamp = rs.getTimeStamp(1);
  LocalDateTime dateTime = sqlTimeStamp.toLocalDateTime(); // 2001―05―06T02:15
}
```

### ⭐ Scrolling ResultSet ⭐
* There are 2 modes which allow you scroll backwards and to any point of the result set:
1. `TYPE_SCROLL_INSENSITIVE`
2. `TYPE_SCROLL_SENSITIVE`

* With these modes, we have the following methods for navigating a ResultSet:
```java
boolean next() // can be used for type-forward-only as well
boolean previous()
boolean first()
boolean absolute(int) // giving a negative value will you row in reverse order
boolean relative(int) // can move cursor back and fourth
void afterLast()
void beforeFirst()
```

* Attempting to use the above methods on type-forward-only will throw an SQLException


## 🟥 10.6 Closing Database Resources
* We can use try-with-resources syntax to automatically close Database Resources:
```java
public static void main(String[] args) throws SQLException {
String url = "jdbc:derby:zoo";
  try (Connection conn = DriverManager.getConnection(url);
    Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("select name from animal")) {
	  while(rs.next()) 
	    System.out.println(rs.getString(1));
  }
}
```

* The resources will close in reverse order which they are opened
* But this isn't necessary as closing a Connection closes the Statement and ResultSet, and closing the Statement closes the ResultSet