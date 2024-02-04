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

<hr>

## 🟥 10.6.3 Scrolling ResultSet


### ⭐ H3 ⭐