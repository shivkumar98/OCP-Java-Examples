<link href="../../styles.css" rel="stylesheet"></link>

# 2️⃣ Chapter 9 - NIO.2 - Revision Notes V2✍️

## 🟥 9.1 NIO.2 and Paths
* Path instances can be created via the `Paths` helper class
* The `Paths.get()` method takes in Strings for a relative/absolute path or URI:
```java
Path relativePath = Paths.get("src/revision_notes");
Path absolutePath = Paths.get("/home/zoo");
Path uriPath = Paths.get(new URI("file:///home/zoo"));
```
* You can also obtain a Path instance via the `FileSystem` object:
```java
FileSystem fileSystem = FileSystems.getDefault(); // helper class
Path path  = fileSystem.getPath("src/revision_notes");
Path path2 = fileSystem.getPath("src", "revision_notes"); // file-seperator automatically inserted
Path path3 = fileSystem.getPath(new URI("http://www.selikkkoff.net")); 
```
* You can convert a `java.io.File` instance into a path and vice-versa:
```java
File file = new File("src/revision_notes");
Path path = Paths.get("src/revision_notes");

Path fileToPath = file.toPath();
File pathToFile = path.toFile();
```


<br><hr>

## 🟥 9.2 Interacting with Paths and Files

### ⭐ Path Object Methods ⭐
* `Path getFileName()` - returns a path representing the path furthest away from root
* `Path getParent()` - returns the enclosing parent of a path. Returns null if there is no enclosing parent:
```java
Paths.get(".").getParent(); // NULL
Paths.get("src/revision/random"); // src/revision
```
* `Path getRoot()` - returns the root of a denoted path, will always return null for relative paths
```java
Paths.get("src/revision/random").getRoot(); // NULL
Paths.get("/home/zoo").getRoot(); // /
```
* `Path toAbsolutePath()` - converts a relative path to an absolute one by appending it to the current working directory. 
```java
Paths.get(".").toAbsolutePath(); //  C:/Users/Shiv/Documents/GitHub/OCP-Java-Examples/.
```
* `Path relativize(other)` - returns a relative path between 2 paths of same type. Throws runtime exception if given incompatible types.
```java
Paths.get(".").relativize(Paths.get("src/revision"));
// src/revision
```
* `Path normalize()` - removes redundancies of a path but does NOT go beyond the file system
```java
Paths.get("../../..").normalize(); // ../../..
```
* `Path toRealPath()` - converts a path to a real one if it exists, otherwise throws a checked IOException:
```java
try {
	Paths.get(".").toRealPath();
	// C:/Users/Shiv/Documents/GitHub/OCP-Java-Examples
} catch (IOException e) {}
```

<br><hr>

## 🟥 9.3 Understanding File Attributes




<br><hr>

## 🟥 9.4 Stream Methods



<br><hr>

## 🟥 9.5 Comparing Legacy Files and NIO.2 Methods
