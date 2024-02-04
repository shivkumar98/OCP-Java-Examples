<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 10.8 Dealing with Exceptions
* We can catch and handle the SQL exception:
```java
String url = "jdbc:derby:zoo";
try (Connection conn = DriverManager.getConnection(url);
     Statement stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery("SELECT bad FROM animal")) {
  while(rs.next())
    System.out.println(rs.getString(1));
} catch (SQLException e) {
  System.out.println(e.getMessage());
  System.out.println(e.getSQLState());
  System.out.println(e.getErrorCode());
}
```
* This will print the following:
```
ERROR: column "bad" does not exist
  Position: 8
42703
0
```