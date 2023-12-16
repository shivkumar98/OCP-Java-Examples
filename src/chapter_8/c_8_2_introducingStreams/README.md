<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 8.2 Introducing Streams
* This section will show how streams are used for input/output (IO) processing
* IO refers to how data is read from a  resource, or writter to a resource.
* The streams here are unrelated to the streams in chapter 4!

<hr>

## 🟥 8.2.1 Stream Fundamentals
* Contents of a file may be accessedor written via a stream, which is a list of data elements presented sequentially

## 🟥 8.2.2 Stream Nomenclature
* The `java.io` API has multiple classes for accessing, creating and manipulating streams.

### 🟡 Byte Streams vs Character Streams
* The `java.io` API has two sets of classes denoted by their name for reading and writing streams:
1) Those which contain `Stream` in their name
2) Thos which contain `Reader`/`Writer` in their name
* E.g. we have a `FileInputStream` and `FilleReader` classes

<br>

1) Stream classes are used for inputting and outputting all types of binary or byte data
2) Reader and Writer classes are used for inputting and outputting only Character and String data

### 🟡 Input and Output
* Most classes have either an Input or Output corresponding class.
* E.g. we have `FileOutputStream` for writing data which can be read by `FileInputStream`
* Also most classes have a corresponding Reader or Writer class
* E.g. we have a `FilerWriter` for writing data which can be read by `FileReader` class
* There are exceptions, e.g. `PrintWriter` does NOT have a corresponding `PrintReader` class

### 🟡 Low-Level vs High-Level Streams
* A `low level stream` connects directly with the source of the data like a file, array or String - they process the raw data or resource and are accessed in an unfiltered way. E.g. `FileInputStream` is a class which reads a file one byte at a time.
* A `high level stream`  is built on top of another stream using wrapping - an instance is passed to a constructor of another class
- E.g. here is `FileReader` used as a low-level stream, and BufferedReader is the high-level stream:
```java
try (
  BufferedReader bufferedReader = new BufferedReader(new FileReader("zoo-data.txt"))) {
    System.out.println(bufferedReader.readLine());
}
```

* High-level streams can also take other high-level streams as input. E.g. the following style of wrapping is quite common:
```java
try (ObjectInputStream objectStream = new ObjectInputStream(
  new BufferedInputStream(
    new FileInputStream("zoo-data.txt")))) {
  System.out.println(objectStream.readObject());
}
```

* Using BufferedStreams when working with files improves perofmance and allows you to read/write data in groups💡

### 🟡 Stream Base Classes
* The `java.io` library defines four abstract classes:
1) `InputStream`
2) `OutputStream`
3) `Reader`
4) `Writer`
* The authors of Java API include the name of the abstract class as the suffix. E.g. `ObjectInputStream`
* However `PrintStream` does not use the suffix `OutputStream`
* The high-level streams often take a reference of abstract class in their constructor. E.g. `BufferedWriter` takes a `Writer` object as input.
<br>

* The exam likes to mix and match stream classes which are not compatible with each other:
```java
new BufferedInputStream(new FileReader("zoo-data.txt")); // COMPILER ERROR
new BufferedWriter(new FileOutputStream("zoo-data.txt")); // COMPILER ERROR
new ObjectInputStream(new FileOutputStream("zoo-data.txt")); // COMPILER ERROR
new BufferedInputStream(new InputStream()); // COMPILER ERROR
```
* The first line does not compile as FileReader can not be accepted by BufferedInputStream - it can only accept an instance of InputStream
* The second line does not compile as same reason as above - it can onlyu accept an instanced of Writer
* The third line does not compile as it can only accept an instance of InputStream
* The fourth line does not compile as you can not instantiate an abstract class

### 🟡 Decoding Java I/O Class Names
* The function of an IO class can be understood by decoding the name of the class:
1) A class containing `InputStream`/`OutputStream` is used for reading and writing binary data
2) A class containing `Reader`/`Writer` is used for reading and writing character/string data
3) Most of the input classes havbe a corresponding output class
4) Low level streams connects directly with source of data
5) High level streams is built upon another stream using wrapping
6) A class with `Buffered` in its name reads/writes data in groups of bytes/character which often improves performance

### 🟡 The `java.io` Stream Classes
| Class Name          | Low/High Level? | Description                                                      |
| ------------------- | --------------- | ---------------------------------------------------------------- |
| `InputStream`       | N/A   | Abstract class |
| `OutputStream`      | N/A   | Abstract class |
| `Reader`            | N/A   | Abstract class |
| `Writer`            | N/A   | Abstract class |
| `FileInputStream`   | N/A   | Reads a file as a stream of bytes |
| `FileOutputStream`  | N/A   | Writes a file as a stream of bytes |
| `FileReader`        | Low   | Reads file data as characters |
| `FileWriter`        | Low   | Writes file data as characters |
| `BufferedReader`    | High  | Reads file data from an existing reader in a buffered way |
| `BufferedWriter`    | High  | Writes file data from an existing writer in a buffered way |
| `ObjectInputStream` | High  | Deserializes primitive Java data types from existing `InputStream` |
| `ObjectOutputStream`| High  | Serializes primitive Java data types from existing `OutputStream` |
| `InputStreamReader` | High  | Reads character data from existing `InputStream` |
| `OutputStreamWriter`| High  | Writes character data from existing `OutputStream` |
| `PrintStream`       | High  | Writes formatted representations of Java objects to a binary stream |
| `PrintWriter`       | High  | Writes formatted representations of Java objects to a text-based stream |


## 🟥 8.2.3 Common Stream Operations