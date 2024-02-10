<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 9.1 Introducing NIO.2
* The first version of file I/O operations availabble in java was `java.io` API which was discussed in chapter 8
* The `java.io` API uses byte streams to interact with file data 
* Java then introduced NIO which stands for non-blocking IO
* NIO uses concepts of buffers and channels rather than java.io.streams
* Data from a file is placed in a temporary buffer which can be read forwards and backwards and NOT block the underlying resource
* Java 7 introduced NIO.2 API which was intended to be a replacement for `java.io.File`


## 🟥 9.1.1 Introducing Path
* The `java.nio.file.Path` interface is the main entry point for working with this new API!
* A `Path` obbject represents a hierarchial path on the storage system
* This acts as a direct replacement for `java.io.File` class
* Unlike the File class, the Path interface has support for symbolic linkks
* We can get an instance of Path using the `Paths` factory class

## 🟥 9.1.2 Creating Paths


### ⭐ Using the Paths Class ⭐
* The Paths factory class can allow us to obtain a reference to a file/directory
* The `Paths.get(String)` method can be used to get an instance
* Here is an example of a relative path to a file in the current working directory:
```java
Path path = Paths.get("chapter_9/c_9_1_intro_nio2/file.txt");
System.out.println(path.getFileName()); // file.txt
System.out.println(path.isAbsolute()); // false
```
* An example of an absolute path on Windows🪟:
```java
Path path2 = Paths.get("C:\\Users\\Shiv\\Downloads\\SlackSetup.exe");
System.out.println(path.getFileName()); // SlackSetup.exe
System.out.println(path.isAbsolute()); // true
```
* An example of an absolute path on Linux🐧:
```java
Path path3 = Paths.get("/home/zoodirector");
```

### ⭐ Absolute Vs Relative Path ⭐
* The file system determines the syntax for a relative path.