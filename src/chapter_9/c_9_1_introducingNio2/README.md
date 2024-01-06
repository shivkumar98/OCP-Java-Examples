<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 9.1 Introducing NIO.2
* NIO.2 is an acryonym for the second version of "Non-blocking Input/Output API"
* This chapter will should how to read and modify attributes of a file
* This chapter will then show the new methods which rely on stream to perform complex operations!
<br>


* The first iteration of file I/O api was discusses in chapter 8
* Java introduced a replacement for java.io streams in 1.4 called `Non-blocking I/O` (NIO) which introduced buffers and channels in place of streams
* This API loads data into a file channel into a temporary buffer which can be read forwards AND backwards without blocking the underlying resource
<br>


* NIO.2 API was introduced in Java 7 as a replacement for `java.io.File`
* The OCP exam will only cover NIO.2 and NOT the first NIO API


<hr>

## 🟥 9.1.1 Introducing Path
* `java.nio.Path` is the primary class for working with NIO.2 
* It represents the hiearchial representation of a file/directory in storage
* Path is a direct replacemenet for `java.io.File`!
* A **symbolic link** is a special file in OS which acts as a pointer to another file/directory
* NIO.2 has full support for creating, detecting and navigating symbolic links

### ⭐ Creating Instances with Factory and Helper Classes ⭐
* The `Paths` is a factory includes static methods to obtain instances of `Path` objects
* NIO.2 included hepler classes like `java.nio.file.Files` which operate on instances of `Path` objects.
  
<hr>

## 🟥 9.1.2 Creating Paths

### ⭐ Using the Paths Class ⭐
* You can obtain an instance of `Path` using `Paths.get(String)` method
```java
String locationOfThisPackage = System.getProperty("user.dir")
    + "\\src"
    + "\\chapter_9"
    + "\\c_9_1_introducingNio2\\javaCode";
Path path = Paths.get(locationOfThisPackage+"\\text.txt");|
```
* We can also use a relative path! 
* You can assume that a path beginning with a forward slash is a relative path (e.g. `/bird/parrot`)
* If it begins with a drive letter then it is absolute!
<br>


* You can also construct a Path instance using `Paths.get(String, String...)` which automatically inserts the file seperator for you automatically:
```java
Path path2 = Paths.get(
    System.getProperty("user.dir"),
    "src", "chapter_9", "c_9_1_introducingNio2",
    "javaCode", "text.txt");
```
<br>


* You can also use `Paths.get(URI)` which uses a **uniform resource identifier** (URI).
  *  A URI begins with a schema (indicating file type)
  *  Examples of schemas include: `file://`, `http://`, `https://` and `ftp://` 
  *  URIs MUST reference absolute paths
        ```java
        Path p1 = Paths.get(new URI("file://pandas/cuddly.png"));
        // ^^THROWS EXCEPTION AT RUNTIME
        Path p2 = Paths.get(new URI("file://c:zoo-info/November/employees.txt"));
        Path path3 = Paths.get(new URI("file:///home/zoodirectory"));
        ```
    * We can convert a path that takes a URI back to a URI instance:
        ```java
        Path p = Paths.get(new URI("http://www.wiley.com"));
        URI uri = p.toUri();
        ```

### ⭐ Accessing the Underlying FileSystem Object ⭐
* The `java.nio.file.FileSystem` has a `getPath()` method
* We obtain a FileSystem instance using factory methods of `FileSystems`
```java
Path p1 = FileSystems.getDefault().getPath("pandas/cuddly.png");
Path p2 = FileSystems.getDefault().getPath("c:","zooinfo","November","employees.txt");
Path p3 = FileSystems.getDefault().getPath("/home/zoodirector");
```

* The `Paths.getPath()` methods are simply a shorthand!!
* The `FileSystems` factory lets us connect to a remote file sysem:
```java
FileSystem fileSystem = FileSystems.getFileSystem(
    new URI("http://www.selikoff.net"));
Path path = fileSystem.getPath("duck.txt");
```

### ⭐ Working with Legacy File Instances ⭐
* We can convert a file to a path using `.toPath()`:
```java
File file = new File("pandas/cuddly.png");
Path p = file.toPath();
```
* For backwards compatibility, we can convert a path to file:
```java
Path path = new Paths.get("random.png");
File f = path.toFile();
```
