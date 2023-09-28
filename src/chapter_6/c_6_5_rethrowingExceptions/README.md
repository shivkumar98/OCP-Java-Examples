<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 6.5 Rethrowing Exceptions
* Its a common patterj to log and then throw the same exception.
* Suppose we have a method which declares two checked exceptions:
```java
public void parseData() throws SQLException, DateTimeParseException {}
```
* In order to call this method, we need to handle or declare the two exception types. 
* E.g.:
```java
public void multiCatch() throws SQLException, DateTimeParseException {
    try {
        parseData();
    } catch(SQLException | DateTimeParseException e) {
        System.err.println(e);
        throw e;
    }
}
```
* We have a little bit of duplication with the list of exceptions and the signature.
* Java 7 made it legal to write `Exception` in the catch block but only for a limited set of exceptions:
```java
public void rethrowing() throws SQLException, DateTimeParseException {
    try {
        parseData();
    } catch (Exception e) {
        System.err.println(e);
        throw e;
    }
}
```
* Now null pointer exception will be caught, logger and rethrown.