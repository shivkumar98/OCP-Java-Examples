<link href="../../styles.css" rel="stylesheet"></link>

# 📝 Chapter 8 - IO: Revision Notes

# 🧠 8.1 Understanding Files and Directories

## 🟥 8.1.1 Conceptuazlizing the File System
* Root directory is the upper most directory 

## 🟥 8.1.2 Introducing the File Class
* The File class is used to represent the pathname of a file/directory
* It can not read/write to the file itself
* The `File` class has the following methods:
1) `exists()`
2) `getName()` 
3) `getAbsolutePath()`
4) `isFile()`/`isDirectory()`
5) `length()` - returns number of bytes of file
6) `lastModified()`
7) `delete()` - can only delete a directory if it is empty
8) `renameTo(File)` - a `move()` method does not exist⚠️
9) `mkdir()`/`mkdirs()`
10) `getParent()`
11) `listFiles()`


<hr>

# 🧠 8.2 Introducing Streams

## 🟥 8.2.1 Stream Fundamentals
* The contents of a file can be accessed or written via a Stream - a list of data elements presented sequentially

## 🟥 8.2.2 Stream Nomenclature

### 🟡 Byte Streams vs Character Streams
* The `java.io` API has two sets of classes:
1) Stream classes with `Reader`/`Writer` in their name are used for inputting/outputting CHARACTER and STRING data
2) Stream classes with `Stream` in their name are used for inputting/outputting BINARY or BYTE data

<br>

* MOST `Input` stream classes have a CORRESPONDING `Output` stream class💡
* MOST `Writer` classes have a CORRESPONDING `Reader` class💡 

### 🟡 Low Level vs High Level Streams
* Low level streams connects directly with the source of the data. E.g. `FileInputStream`
* High level streams is built on top of another stream using wrapping. E.g. BufferecReader is a high level stream:
```java
try (BufferedReader bufferedReader = new BufferedReader(
                                        new FileReader("zoo-data.txt"))) {
    System.out.println(bufferedReader.readLine());
}
```

### 🟡 Stream Base Classes

* The `java.io` library defines four abstract classes:
1) `InputStream`
2) `OutputStream`
3) `Reader`
4) `Writer`

* The constructor of HIGH-LEVEL streams take a reference of the abstract class which they implement. E.g.:
```java
BufferedInputStream bs = new BufferedInputStream();
new BufferedInputStream(bs); // perfectly fine to re-wrap
new BufferedInputStream(new FileInputStream("zoo.txt")); // wrapping a low level stream
// You can NOT wrap a high level stream in a low level stream:
new FileInputStream(bs); // COMPILER ERROR
```

### 🟡 Decoding Java I/O Class Names
* Rules:
1) A class containing `InputStream`/`OutputStream` in its name is used for reading/writing binary data
2) A class with the word `Reader`/`Writer` in its name is used for reading/writing character/string data
3) A class with `Buffered` in its name reads/writes data in groups of bytes which often improves performance

### 🟡 The `java.io` Stream Classes
| Class Name    | Low/High Level | Description                                              |
| ------------- | -------------- | -------------------------------------------------------- |
| InputStream   | N/A            | Abstract class                                           |
| OutputStream  | N/A            | Abstract class                                           |
| Reader        | N/A            | Abstract class                                           |
| Writer        | N/A            | Abstract class                                           |
| FileInputStream | Low          | Used for reading file data as bytes                      |
| FileOutputStream | Low         | Used for writing file data as bytes                      |
| FileReader    | Low            | Reads file data as characters                            |
| FileWriter    | Low            | Writes file data as character                            |
| BufferedReader | High          | Reads character data from existing Reader                |
| BufferedWriter | High          | Writes character data from existing Writer              |
| ObjectInputStream | High       | Deserializes primitive data type and objects from existing InputStream |
| ObjectOutputStream | High      | Serializes primitive data and objects from existing OutputStream |
| InputStreamReader | High | Reads character data from existing InputStream                 |
| OutputStreamWriter | High | Writes character data from existing OutputStream |
| PrintWriter           | High   | Writes formatted representations of Java objects to a text-based output stream |



## 🟥 8.2.3 Common Stream Operations



<hr>

# 🧠 8.3 Working with Streams

## 🟥 8.3.1 The FileInputStream and FileOutputStream Classes

## 🟥 8.3.2 The FileReader and FilerWriter Classes

## 🟥 8.3.3 The ObjectInputStream and ObjectOutputStream Classes

## 🟥 8.3.4 The PrintStream and PrintWriter Classes

## 🟥 8.3.5 Review of Stream Classes



<hr>

# 🧠 8.4 Interacting With Users

## 🟥 8.4.1 The Old Way

## 🟥 8.4.2 The New Way