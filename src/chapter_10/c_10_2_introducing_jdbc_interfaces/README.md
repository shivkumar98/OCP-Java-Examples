<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 10.2 Introducing the Interfaces of JDBC
* There are 4 kkey interfaces in JDBC which are implemented in JDBC driver
* Different vendors of databases provided different implementations. E.g. the jar for `PostgreSQL` is `postgresql-9.4-1201.jdbc4.jar`
* Here are interfaces of JDBC:
    1. `Driver` - knows how to get a connection to DB
    2. `Connection` - knows how to communicatte with DB
    3. `Statement` - knows how to run SQL
    4. `ResultSet` - knows whhat is returned from select statement

* The implementing classes of these interfaces all have the name of `vendor name + name of interface` , e.g. `FooDriver`

* Here is an example of using JDBC akin to what you would see in the exam:

```java
public static void main(String[] args) throws SQLException {
    String url = "jdbc:derby:zoo";
    try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select name from animal")) {
        
        while(rs.next()) {
            System.out.println(rs.getString(1));
        }
    }
}
```
* This program will print the following:
```
Elsa
Zelda
Ester
Eddie
Zoe
```
* If the URL was using `FooDriver`, the `DriverManager` would return an instance of `FooConnection`
* The `conn.createStatement()` returns an instance of `FooStatement`
* The `stmt.executeQuery()` returns an instance of `FooResultSet`