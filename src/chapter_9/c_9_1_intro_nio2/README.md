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

<hr>

## 🟥 9.1.2 Creating Paths


### ⭐ Using the Paths Class ⭐
* The Paths factory class can allow us to obtain a reference to a file/directory
* The `Paths.get(String)` method can be used to get an instance
* Here is an example of a relative path to a file in the current working directory:
```java
Path path = Paths.get("src/chapter_9/c_9_1_intro_nio2/javacode/file.txt");
System.out.println(path1.isAbsolute()); // false
```
* An example of an absolute path on Windows🪟:
```java
Path path2 = Paths.get("C:\\Users\\Shiv\\Downloads\\SlackSetup.exe");
System.out.println(path2.getFileName()); // SlackSetup.exe
System.out.println(path2.isAbsolute()); // true
```
* An example of an absolute path on Linux🐧:
```java
Path path3 = Paths.get("/home/zoodirector");
```

### ⭐ Absolute Vs Relative Path ⭐
* The file system determines the syntax for a relative path. 
* E.g. `c:\zoo\employee` is a relative path in Linux
* E.g. 2 `/home/zoo` is a relative path in Windows
<br>

* For the exam, and throughout this chapter, I can use the following rules to determine whether a path is absolute or relative:
1. If a path begins with a forward slash, `/zoo/parrot`, then it is an absolute path.
2. If a path begins with a drive letter, `c:\bird`, then it is an abbsolute path
3. Otherwise it is a relative path such as `..\eagle`

<br>

* You can also create paths by providing a list of strings, and the system-dependent seperator is automatically inserted:
```java
Path pathUsingList = Paths.get("src", "chapter_9", "c_9_1_intro_nio2","javacode", "file.txt");
Files.exists(pathUsingList);
// ^^^^^^^^^^^^^^^^^^^^^^^^^ true
```

<br>

* You can also construct a Path using a URI - uniform resource identifier
* This begins with a schema which determines the resource type, followed by a path value
* If a URI of type file is given, then it MUST be an absolute path⚠️
```java
Path path1 = Paths.get(new URI("file://pandas/cuddly.png")); // throws runtime exception
```

* We can also have URIs from a website or FTP server
```java
Path webPath = Paths.get(new URI("http://www.wiley.com"));
Path ftpPath = Paths.get(new URI("ftp://username:password@ftp.the-ftp-server.com"));
```

* Constructing a URI instance throws a checkked `URISyntaxException`

### ⭐ Accessing the Underlying FileSystem Object ⭐
* Whenever we are using `Path.getPath()` method, this is just a shorthand for the getPath() method from `java.nio.FileSystem`
* We use tthe `FileSystems` factory class as shown:
```java
Path p1 = FileSystems.getDefault()
  .getPath("pandas/cuddly.png");
```

### ⭐ Working with Legacy File Instances ⭐
* Java 7 added `.toPath()` to the legacy `java.io.File` class:
```java
File file = new File("pandas/cuddly.png");
Path path = file.toPath();
```
* You can also convert a path back to a file:
```java
Path path = Paths.get("pandas/cuddly.png");
File file = path.toFile();
```