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
<hr>

## 🟥 9.2 Interacting with Paths and Files

<br>
<hr>

## 🟥 9.3 Understanding File Attributes
<br>
<hr>

## 🟥 9.4 Stream Methods
<br><hr>

## 🟥 9.5 Comparing Legacy Files and NIO.2 Methods
