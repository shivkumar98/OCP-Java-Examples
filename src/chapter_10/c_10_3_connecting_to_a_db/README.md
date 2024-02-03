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

### ⭐ H3 ⭐

## 🟥 10.3.2 Getting a Database Connection

### ⭐ H3 ⭐