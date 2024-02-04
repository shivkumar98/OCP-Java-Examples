<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 10.7 Closing Database Resources

* JDBC resources are expensive to create, not closing them leads to resource leaks which will slow down a program
* We know resources are closed in the reverse order in which they were created:
```java
public static void main(String[] args) throws SQLException {
  String url = "jdbc:derby:zoo";
  try (Connection conn = DriverManager.getConnection(url);
       Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery("SELECT name FROM animal")) 
      {
    while (rs.next()) 
      System.out.println(rs.getString(1));
  }
}
```
* The ResultSet is closed, then the Statement and finally the Connection
## 🟥 