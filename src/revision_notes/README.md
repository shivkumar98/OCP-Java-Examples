<link href="../styles.css" rel="stylesheet"></link>

# Revision Notes ✍️



<hr>


-----------------------------------------------------------



--------------------------------------------------

# 🖨️ Chapter 8 - IO 🖨️

## 🟥 8.1 Files and Directories
* You can instantiate a file using either a String representing the location or using another File instance which is the parent directory
```java
File parent = new File("/home/smith");
File child = new File(parent, "data/zoo.txt");
```

* We have methods to make directories, confirm existence, delete, rename and list files.
* We do NOT have methods to MOVE/COPY

* Here are the **methods available to File class**:
```java
boolean exists();
String getName(); // gets the name of file or directory. E.g. zoo.txt
boolean isDirectory();
boolean isFile();
boolean delete(); // deletes file OR directory if empty
boolean renameTo(File file);
boolean mkdir(File directoryFile); // makes directory file denoted by file
boolean mkdirs(File file); // makes directory AND file even for dirs which don't exist
String getParent(); // returns absolute filepath of parent directory
File[] listFiles(); // returns a File[] denoting files in directory
long lastModified(); // returns no. of ms since the epoch the file was last modified
```

<hr>

## 🟥 8.2 Streams
### 🟡 Input/Output Stream Vs Reader/Writer
* There **four abstract classes** in java.io:
1) `Reader` 📖
2) `Writer` ✍️
3) `InputStream` 👉0️⃣
4) `OutputStream` 1️⃣👉

* These classes can be divided into two types
1) Classes which have `InputStream`/`OutputStream` in their name
- Used for reading/writing **BINARY DATA**
2) Classes which have `Reader`/`Writer` in their name
- Used for reading/writing **CHARACTER/STRING DATA**

### 🟡 Low-Level Streams
* LOW LEVEL streams connect directly to source of data

| Class 			| Description 								|
| ----------------- | ----------------------------------------- |
| FileInputStream   | This is an `InputStream` and reads binary data from file				|
| FileOutputStream  | This is an `OutputStream` and writes binary data to file				|
| FileReader        | This is a `Reader` and reads character data from file		    |
| FileWriter		| This is a `Writer` and writes character data from file 			|

* HIGH LEVEL streams are used to wrap another stream (the final 2 are not in the exam)
  
| Class 			| Description 								|
| ----------------- | ----------------------------------------- |
| BufferedReader |  This is a `Reader` and takes in a low level `FileReader` |
| BufferedWriter | This is a `Writer` and takes in a low level stream `FileWriter` |
| BufferedInputStream | This is a `InputStream` which takes a low level `FileInputStream` |
| BufferedOutputStream |  This is a `OutputStream` which takes a low level `FileOutputStream` |
| ObjectInputStream | This deserializer is an `InputStream` and takes either `FileInputStream` OR `BufferedInputStream` |
| ObjectOutputStream | This serializer is an `OutputStream` and takes either `FileOutputStream` OR `BufferedOutputStream` |
| PrintStream  | This is a `OutputStream` which gives useful methods for writing and formatting data  |
| PrintWriter | This is a `Writer` which gives useful methods for writing and formatting data  |
| InputStreamReader | This is a `Reader` which takes an `InputStream` (e.g. FileInputStream, ObjectInputStream) |
| OutputStreamWriter | This is a `Writer` which takes an `OutputStream` (e.g. FileOutputStream) |

### 🟡 Common Stream Operations
* Streams should be closed via `close()` method to prevent resouce leaks and the program deadlocking. You can also use the try-with-resources syntax to do this automatically💡
* You should use the `flush()` method to ensure all data is written to disk when writing data with `OutputStream`
* Only some streams support marking and resetting. Check that it is supported using `boolean markSupported()` otherwise you can encounter an UnsupportedOperationException⚠️
<hr>

## 🟥 8.3 Working With Streams

### 🟡 FileInputStream and FileOutputStream Classes
* These are LOW LEVEL `InputStream`/`OutputStream` classes which read/write binary data to files
```java
try (InputStream fileInputStream = new FileInputStream(new File("data.txt")) {
	int b;
	while((b=fileInputStream()) != -1) {
		System.out.print((char)b);
	}
}
```

#### 🟢 BufferedInputStream and BufferedOutputStream Classes
* This are HIGH LEVEL InputStream/OutputStream classes which take in low level FileInputStream/FileOutputStream classes!
```java
BufferedInputStream bufferedInputStream
	= new BufferedInputStream(
		new FileInputStream(
			new File(alphabetFile)));
int b;
while ((b=bufferedInputStream.read()) != -1) {
	System.out.println((char)b);
}
```

### 🟡 FileReader and FileWriter Classes
* These classes offer AUTOMATIC CHARACTER ENCODING💡
* These are LOW LEVEL `Reader`/`Writer` classes which read and write String data
* We have a `int read()` method for the reader ,and a `void write(String)` method for the writer
```java
FileReader fileReader = new FileReader(alphabetFile);
int b;
while((b=fileReader.read()) != -1) {
	System.out.println((char)b);
}
```

#### 🟢 BufferedReader and BufferedWriter
* These classes are HIGH LEVEL wrappers, there is also a `ReadLine()` method which is useful!
```java
try (BufferedWriter writer = new BufferedWriter(new FileWriter(alphabetFile));
	 BufferedReader reader = new BufferedReader(new FileReader(alphabetFile));) {
	writer.write("abcd\nefghi");
	String line;
	while((line=reader.readLine())!=null) {
		System.out.println(line);
	}
}
```

### 🟡 ObjectInputStream and ObjectOutputStream Classes
* These classes allow for SERIALIZATION and DESERIALIZATION of Java objects:
* The ObjectInputStream takes in an InputStream in the form of a FileInputStream or BufferedInputStream
```java
ObjectOutputStream writer = new ObjectOutputStream(
	new FileOutputStream(outputFile));
writer.writeObject("hello world");

ObjectInputStream reader = new ObjectInputStream(
	new FleInputStream(outputFile));
// reader.read(); // returns -1
reader.readObject(); // hello world is returned
```

#### 🟢 Serializable Interface
* Any abstract, concrete or final class can be marked as serializable
* Attempting to serialize a non-serializable instance will not cause compilation errors but WILL THROW NotSerializableException:
```java
objectOutputStream.writeObject(new NotSerializable()); // THROWS NotSerializableException
```

#### 🟢 How Objects are Created When Deserializing
* Static and `transient` variables are ignored during serialization/deserialization
  * Transient variables will be the default value java gives to the instance type (e.g. null for Strings)
  * Static variables will have the value of the last value it was assigned to in the program
* When an object is deserialized, the constructor of the class is NOT called
  * java will call the first no-argument constructor for the first nonserializable parent class


### 🟡 PrintStream and PrintWriter Classes
* These classes offer nice methods like `format(String, args)` and `printf(String, args)` which are functionally the same
* PrintStream is an `OutputStream`
* PrintWriter is a `Writer`
<hr>

## 🟥 8.4 Interacting With Users

### 🟡 Old Way: Using Buffered Reader
* System.out returns a `PrintStream`
* System.in returns an `InputStream`.
* We use `InputStreamReader` to capture input from the user:
```java
Reader reader = InputStreamReader(System.in);
System.out.println("Enter a character");
		int input = reader.read();
		System.out.println("You entered: "+(char)input);
```

* BufferedReader enables us to read String terminated by enter key by the user
```java
BufferedReader bufferedReader = 
	new BufferedReader(new InputStreamReader(System.in));
System.out.println("Please enter a string:");
String input = bufferedReader.readLine();
System.out.printf("You entered: %s", input);
```

### 🟡 New Way: Using Console
* The `Console` is a singleton which is accessible using `Sytem.console()`
* There is a risk the console can be null⚠️
* The console has the `format()`/`printf()` that PrintStream also has
* The console has the following methods:
  * `String readLine()`
  * `char[] readPassword()` - a secure way of reading password without invoking String pool!
  * `PrintWriter writer()` - gives a writer instance for methods like `print()`
* Example program:
```java
Console console = System.console();
console.printf("Hi, %s! Please enter some text:", "shiv");
String input = console.readLine();
console.writer().println("You typed: "+input);
```















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