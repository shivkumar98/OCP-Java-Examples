<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 10.4 Obtaining a Statement
* We can easily obtain a statement from a connection:
```java
Statement stmt = conn.createStatement();
```
* Here is another retrieval of statement needed for the exam:
```java
Statement stmt = conn.createStatement(
  ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
```
  * The first parameter specifies the ResultSet type
  * The second parameter specified the ResultSet concurrency mode
    
## 🟥 10.4.1 Choosing a ResultSet Type
* The default ResultSet type is `TYPE_FORWARD_ONLY` - you can go through the data in the order it was retrieved
* `TYPE_SCROLL_SENSITIVE` and `TYPE_SCROLL_INSENSITIVE` allow you to go through the data in any order - forwards or backwards
  * `TYPE_SCROLL_SENSITIVE` lets you see the latest data as it is being updated - most databases do not support this
  * `TYPE_SCROLL_INSENSITIVE` gives you a static view of the data returned when it was query
<hr>

## 🟥 10.4.2 Choosing a ResultSet Concurrency Mode
* The default ResultSet mode is `CONCUR_READ_ONLY` - you can NOT update the result set.
  * Most of the time you will use an insert/update/delete method anyway
* `CONCUR_UPDATABLE` mode lets you modify the db THROUGH the result set - not supported by all Drivers
### ⭐ H3 ⭐