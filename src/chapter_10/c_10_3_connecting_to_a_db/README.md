<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 10.3 Connecting to a Database
* We shall see how to build a JDBC URL and then show how the exam expects me to get a connection to the database
  
## 🟥 10.3.1 Building a JDBC URL
* The JDBC URL is like the URL of a website or the username/password to an email
* The JDBC URL has various formats and all have the same components in common:
    1. Protocol - this is always the same `jdbc`
    2. Vendor name - the name of the database, e.g. postgres, mysql, derby
    3. Database specific connection details - i.e. the location and name of database
* E.g. `jdbc:postgres://localhost:5432/zoo`
<br>

* Here are some examples of connection details:
  * `jdbc:postgres://localhost/zoo` - port number is optional using default
  * `jdbc:oracle:thin:@123.123.123.123:1521:zoo`
  * `jdbc:mysql://localhost:3306/zoo?profileSQL=true` 

<hr>

## 🟥 10.3.2 Getting a Database Connection
* There are two ways of obtaining a connection to the db: `DriverManager` or `DataSource`
* The DriverManager is the one which will be used in code but should not be used in practice as DataSource provides more features like pooling connections or store the db connection info outside the application
* `DriverManager` uses factory pattern enabling you to statically obtain a connectionL `DriverManager.getConnection("jdbc:derby:zoo")`
* Here is an example of getting a connection from the embedded database:
```java
public class TestConnect {
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
		System.out.println(conn);
		// org.apache.derby.impl.jdbc.EmbedConnection@98826337 (XID = 266),
        // (SESSIONID = 1), (DATABASE = zoo), (DRDAID = null) 
	}
}
```
* You also can obtain a connection by specifying the username and password in `.getConnection()`. E.g.:
```java
Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ocp-book",
"username",
"password");
```
