<link href="../../styles.css" rel="stylesheet"></link>

# 2️⃣ Chapter 9 - NIO.2 - Revision Notes ✍️

## 🟥 9.1 NIO.2 and Paths
### ⭐ Using Path.get() ⭐
* Path is an object used to represent a file/directory which may or MAY NOT actually be in the file system
* The main a Path instance is obtained is via `Paths.get(String)` and `Paths.get(URI)`
* Using `Paths.get(String)` we can specify either a absolute or relative path
```java
Path relativePath = Paths.get("src/chapter_9");
Path absolutePath = Paths.get("/home/zoo");
Path windowsAbsolutePath = Paths
	.get("C:\\Users\\Shiv\\Documents\\"
	+ "GitHub\\OCP-Java-Examples\\"
	+ "src\\chapter_9");
```
* You can also use this version if you do not want to specify the OS-dependent path seperator:
```java
Path relativePath = Paths.get("src","chapter_9");
Path absolutePath = Paths.get("/","home","zoo");
Path windowsAbsolutePath = Paths
	.get("C:","Users","Shiv","Documents",
		 "Github","OCP-Java-Examples",
		 "src","chapter_9");
```
* Here is an example of using `Paths.get(URI)`:
```java
URI badUri = new URI("file://src/chapter_9"); // CANT USE REL PATH
Path invalidUriPath = Paths.get(badUri); // throws runtime exception

URI validUri = new URI("file:///C:/Users");
Path validUriPath = new Path(validUri);

URI websiteUri = new URI("http://wiley.com");
Path webPath = new Path(websiteUri);
```
* Using URI, you must handle `URISyntaxException` ⚠️
```java
URI uri = null;
try {
	uri = new URI("hello");
} catch (URISyntaxException e) {}
Path uriPath = Paths.get(uri);
```

### ⭐ Using FileSystem ⭐
* You can obtain a Path via a FileSystem instance:
```java
FileSystem defaultFS = FileSystems.getDefault();
Path relPath = defaultFS.getPath("src/chapter_9");
Path absolutePath = defaultFS.getPath("/home/zoo");
Path windowsAbsolutePath = defaultFS
	.getPath("C:\\Users\\Shiv\\Documents\\"
	+ "GitHub\\OCP-Java-Examples\\"
	+ "src\\chapter_9");
```
* You can also obtain a remote file system:
```java
FileSystem remoteFS = FileSystems.getFileSystem(
	new URI("http://www.selikoff.net"));
```

### ⭐ Converting Path and File ⭐
* A File instance can be converted to a Path via `.toPath()`, a Path instance can be converted to a File via `.toFile()`:
```java
File file = new File("pandas/polar.txt");
Path fileToPath = file.toPath();

Path path = Paths.get("pandas/polar.txt");
File pathToFile = path.toFile();
```


<hr>

## 🟥 9.2 Interacting with Paths and Files

<hr>

## 🟥 9.3 Understanding File Attributes

<hr>

## 🟥 9.4 Stream Methods


## 🟥 H2
### ⭐ H3
#### 🌱 H4
