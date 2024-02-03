<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 10.1 Introducing Relational Databases and SQL
* JDBC = Java Database Connectivity
* We shall look at interfaces for connecting, performing queriesm and process results
* SQL book recommendation: SQL For Dummies by Allen G. Taylor (Wiley, 2013)
* Database java programming bookk recommendation: Practical
Database Programming with Java by Ying Bai 
<br>

* A relational database is data which is organised into tables.
* There are 2 ways of accessing a relational DB from java
1. JDBC - accessed data as rows and columns
2. JPA - accessed data through Java objects (not in the exam)

## 🟥 Setting Derby Database 🟥
* The remainder of this chapter will involve querying a database, I utilise Derby database as free hosted database.
* I set up a database, by downloading the Derby jar file and added it to the root of my project.
* I update the classpath to include the jar
* I run the following program to initialise the database:
```java
// MAIN METHOD:
String url = "jdbc:derby;create=true";
try (Connection conn = DriverManager.getConnection(url);
    Statement stmt = conn.createStatement()) {

    stmt.executeUpdate(
    "CREATE TABLE species ("
        + "id INTEGER PRIMARY KEY, "
        + "name VARCHAR(255), "
        + "num_acres DECIMAL)");
    stmt.executeUpdate("DROP TABLE animal");
    stmt.executeUpdate(
    "CREATE TABLE animal ("
            + "id INTEGER PRIMARY KEY, "
            + "species_id integer, "
            + "name VARCHAR(255))");
		
    stmt.executeUpdate("INSERT INTO species VALUES (1, 'African Elephant', 7.5)");
    stmt.executeUpdate("INSERT INTO species VALUES (2, 'Zebra', 1.2)");
    
    stmt.executeUpdate("INSERT INTO animal VALUES (1, 1, 'Elsa')");
    stmt.executeUpdate("INSERT INTO animal VALUES (2, 2, 'Zelda')");
    stmt.executeUpdate("INSERT INTO animal VALUES (3, 1, 'Ester')");
    stmt.executeUpdate("INSERT INTO animal VALUES (4, 1, 'Eddie')");
    stmt.executeUpdate("INSERT INTO animal VALUES (5, 2, 'Zoe')");	 
}
```