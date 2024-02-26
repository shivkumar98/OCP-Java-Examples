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
### ⭐ Common Optional Arguments ⭐
* Many methods within the NIO.2 API which interact with actual files and directories take additional option flags.
* Here are the common optional arguments:
1) `NOFOLLOW_LINKS` - symbolic links encountered will NOT be traversed.
2) `FOLLOW_LINKS` - symbolic links WILL be traversed
3) `COPY_ATTRIBUTES` - all metadata of the file being copied, will be copied with it
4) `REPLACE_EXISTING` - if the target files exist, it will be replaced. If not provided, and the target file already exists then an exception will be thrown
5) `ATOMIC_MOVE` - will ensure any prcoess will never see an incomplete record. Will throw an exception if not supported by thhe file systen
* The options can be accessed via the enum `StandardCopyOption`

<br>

### ⭐ Path Object Methods ⭐
#### 🌱 Name Methods 🌱
* These methods are on the `Path` interface:
1. `String toString()` - converts the Path to a String, i.e. it will return the String which is passed into the `Paths.get(String)`
```java
Paths.get("./").toString(); // .
Paths.get("/.").toString(); // /.
Paths.get("src/../").toString(); // src/..
Paths.get("/home/zoo").toString(); // /home/zoo
```
2) `int getNameCount()` - returns number of names of the path
3) `Path getName(int)` - returns the name component of a path (zero-indexed)
```java
Path path1 = Paths.get("./");
Path absolutePath = Paths.get("/home/zoo");
path1.getNameCount(); // 1
path1.getName(0); // .
path1.getName(1); // THROWS EXCEPTION
absolutePath.getNameCount(); // 2
absolutePath.getName(0); // home
absolutePath.getName(1); // zoo
```


#### 🌱 Path Component Methods 🌱
1. `Path getFileName()` - returns Path furthest away from the LHS
```java
Path absolutePath = Paths.get("home/zoo");
absolutePath.getFileName(); // zoo
Path relPath = Paths.get("src/main/chap9/file.txt");
relPath.getFileName(); // file.txt
```

2) `Path getParent()` - returns parent path of a given path. I.e. everything to the left of the last name of the path. Will return null if a relative path is given with no enclosing directories
```java
Paths.get("relative-file.txt").getParent(); 
// null as it can not go outside the file system
Paths.get("/home/zoo/java/folder").getParent();
// /home/zoo/java
Paths.get("src/folder1/../folder2").getParent();
// src/folder1/.. 
// there is no awareness of what the path actually represents
Paths.get("src/folder1/../../../../..").getParent();
// src/folder1/../../../..
```

3) `Path getRoot()` - returns root of a path (furthest to left), null if given relative path
```java
Paths.get("relative").getRoot(); 
// null - ALWAYS for relative paths
Paths.get("/src/folder/random").getRoot();
// /
```

#### 🌱 Using isAbsolute() and toAbsolutePath() 🌱
* `boolean isAbsolute()` - true is path is absolute, regardless of whether the path actually exists
```java
Path fakeRelPath = Paths.get("fake/madeup");
fakeRelPath.isAbsolute(); // FALSE
Path fakeAbsPath = Paths.get("/home/zoo");
fakeAbsPath.isAbsolute(); // TRUE
```
* NOTE: there is NO `isRelative()` method!!!

* `Path toAbsolutePath()` - converts a relative path to an absolute path by appending the relative path to current directory. Will return same path, if path is already absolute. If an absolute path does not exist, it will append to the root directory
```java
Path fakeRelPath = Paths.get("fake/madeup");
fakeRelPath.toAbsolutePath();
//  C:\Users\Shiv\Documents\GitHub\OCP-Java-Examples\src\chapter_9

Path realAbsPath = Paths
	.get("C:/Users/Shiv/Documents/"
	   + "GitHub/OCP-Java-Examples/src/"
       + "chapter_9");
realAbsPath.toAbsolutePath();
// returns given path^

Path fakeAbsPath = Paths.get("/home/zoo");
fakeAbsPath.toAbsolutePath();
// C:\User\home\zoo
```
#### 🌱 Using subpath() 🌱
* `Path subpath(int,int)` returns a relative path of another path (either relative or absolute). It will throw an IllegalArgumentException for the following cases:
  * Start index is same as end index
  * Start index is more than end index
  * index exceeds the name count
* The end index is EXCLUSIVE⚠️
```java
Path path = Paths.get("/mammal/carnivore/racoon.image");
path.getNameCount(); // 3
path.getName(0); // mammal
path.getName(2); // racoon.image
path.subpath(0,3); // mammal/carnivore/racoon.image
path.subpath(1,2); // carnivore
path.subpath(1,1); // THROWS EXCEPTION
```

#### 🌱 Using relativize() 🌱
* `Path relative(Path other)` let's you construct a relative path between two paths. The argument path must be the same type (absolute or relative) to the one its being called on⚠️
```java
Path relPath1 = Paths.get("pizza.txt");
Path absPath1 = Paths.get("/food/pizza.txt");
Path relPath2 = Paths.get("jeans.png");
Path absPath2 = Paths.get("/clothes/jeans.png");

relPath1.relativize(absPath1); // THROWS EXCEPTION
// ^^^ types are incompatible

relPath1.relativize(relPath1); // BLANK
// ^^^ recognises paths are the same

relPath1.relativize(relPath2); 
// ../jeans.png

absPath1.relativize(absPath2);
// ../../clothes/jeans/png
```

#### 🌱 Using resolve() 🌱
* The `Path resole(Path other)` simply appends the relative path (argument) to the path it is called on (can be either relative or absolute).
* If the argument is absolute, then the argument is returned⚠️
```java
Path relPath1 = Paths.get("pizza.txt");
Path absPath1 = Paths.get("/food/pizza.txt");
Path relPath2 = Paths.get("jeans.png");

relPath1.resolve(relPath2);
// pizza.txt/jean.png
relPath1.resolve(absPath1);
// /food/pizza.txt
absPath1.resolve(relPath1);
// /food/pizza.txt/pizza.txt
```

#### 🌱 Using normalize() 🌱
* `Path normalize()` eliminates redudancies of a given path. If called on a relative Path it will return a relative path as it has no awareness beyond the file system
* This method does not check if the file actually exists
```java
Path relPath = Paths.get("home/../../..");
relPath.normalize(); // ../..
Path relPath2 = Paths.get("home/..");
relPath2.normalize(); // BLANK

Path absPath = Paths.get("/home/../home");
absPath.normalize(); // /home
Path absPath2 = Paths.get("/home/../../..");
absPath2.normalize(); // /
```

#### 🌱 Using toRealPath() 🌱
* `toRealPath()` - takes a relative path to an absolute one. If a real file does not exist, then a checked `IOException` is thrown
* This method supports `NOFOLLOW_LINKS` option
* This method IMPLICITLY calls `normalize()`💡
```java
Path nonExistentAbsPath = Paths.get("/home/zoo");
try {
	nonExistentAbsPath.toRealPath();
} catch (IOException e) {
	// EXCEPTION CAUGHT
}

Path nonExistentRelPath = Paths.get("fake");s
try {
	nonExistentRelPath.toRealPath();
} catch (IOException e) {
	// EXCEPTION CAUGHT
}

// this method CAN go beyond file system:
Path currentDir = Paths.get(".");
Path outsideCurrentDir = Paths.get("./..");
try {
	System.out.println(currentDir.toRealPath());
	// C:/Users/Shiv/Documents/GitHub/OCP-Java-Examples
	System.out.println(outsideCurrentDir.toRealPath());
	// C:/Users/Shiv/Documents/GitHub
}
```


<br>

### ⭐ Files Path Methods ⭐
* `Files` is the helper class for the `Path` interface
* Most of the methods in `Files` WILL throw an exception if the path does not exist!!⚠️

#### 🌱 Using Files.exists() 🌱
* This method is true only if the file exists in file system
* Will NOT throw any exception if file does not exist:
```java
Path existentRelPath = Paths.get("src/chapter_9");
Files.exists(existentRelPath); // TRUE
Path existentAbsPath = Paths.get("C:/Users/Shiv/Documents/GitHub");
Files.exists(existentAbsPath); // TRUE
Path nonExistentRelPath = Paths.get("fake/madeup");
Files.exists(nonExistentRelPath); // FALSE
Pathh nonExistentAbsPath = Paths.get("/home/zoo");
Files.exists(nonExistentAbsPath); // FALSE
```

#### 🌱 Using Files.isSameFile() 🌱
* The `Files.isSameFile(Path,Path)` will follow symbolic links
* The method checks if the Paths are equal under `equals()`, if so it will return true. 
* If `equals()` returns false, then it will check if the files actually exist to see
* This method will return false if the two paths are different even if the files have the same content and metadata⚠️
```java
Path realRelativePath = Paths.get("src");
Path realAbsolutePath = Paths.get("C:/Users/Shiv/Documents/GitHub/OCP-Java-Examples/src");
realRelativePath.equals(realAbsolutePath); // FALSE
realRelativePath.isSameFile(realAbsolutePath); // TRUE

// Here are two fake paths:
Path fakeAbsolutePath = Paths.get("/home/zoo");
Path fakeAbsolutePath2 = Paths.get("/home/zoo/");
fakeAbsolutePath.equals(fakeAbsolutePath2);
// TRUE
Files.isSameFile(fakeAbsolutePath, fakeAbsolutePath2);
// TRUE

// two fake paths which are equal in terms of normalize:
Path path1 = Paths.get("/home/zoo/../zoo");
Path path2 = Paths.get("/home/zoo");
path1.equals(path2); // FALSE
path1.normalize().equals(path2.normalize()); // TRUE
File.isSameFile(path1,path2); // THROWS EXCEPTION
```

#### 🌱 Using Files.createDirectory() and createDirectories() 🌱
* These methods are equivalent to `file.mkdir()` and `file.mkdirs()`.
* These methods return the path which is being created!
* This method will throw an exception e.g. if the folder already exists!
* You CAN create a folder with an extension:
```java
try {
	Path thisFolder = Paths.get("src/revision_notes/chap09");
	Path newFolder = thisFolder.resolve(Paths.get("new_folder"));
	Path createdPath = Files.createDirectory(newFolder);
	System.out.println(createdPath);
	// src\revision_notes\chap09\new_folder

	Path newFolderWithExtension = thisFolder.resolve(Paths.get("new.txt"));
	Path createdPath2 = Files.createDirectory(newFolderWithExtension);
	System.out.println(createdPath2);
	// src\revision_notes\chap09\new.txt
} catch (IOException e) { }
```
* Trying to run the above code twice will throw an exception!

#### 🌱 Using Files.copy() 🌱
* This method takes a shallow copy of a file/directory!
* This method WILL traverse symbolic links and will NOT copy attributes.
* These behaviours can be overidden using the following options:
  * `REPLACE_EXISTING`
  * `COPY_ATTRIBUTES`
  * `NOFOLLOW_LINKS`
```java
Path readMeFile = Paths
	.get("src/revision_notes/README.md");
Path targetFile = Paths
	.get("src/revision_notes/chap09/new_folder/README.md");
try {
	Path copiedPath = Files
			.copy(readMeFile, targetFile);
	System.out.println("copy: "+copiedPath);
} catch (IOException e) {
	System.out.println("exception caught");
}
```
* Running the above code TWICE will throw an exception

#### 🌱 Using Files.move() 🌱

#### 🌱 Using Files.delete() and deleteIfExists() 🌱

#### 🌱 Using Files.newBufferedReader() and newBufferedWriter() 🌱

#### 🌱 Using Files.readAllLines() 🌱

<br>
<hr>

## 🟥 9.3 Understanding File Attributes

### ⭐ Basic File Attributes ⭐
#### 🌱 File Type Attributes 🌱
#### 🌱 Using Files.isHidden() 🌱
#### 🌱 Using Files.isReadable() and isExecutable() 🌱
#### 🌱 Using Files.size() 🌱
#### 🌱 Using Files.getLastModifiedTime() and setLastModifiedTime() 🌱
#### 🌱 Using Files.getOwner() and setOwner() 🌱

<br>

### ⭐ File Attributes with Views ⭐
#### 🌱 Reading with Files.readAttributes() 🌱
#### 🌱 Modifying with Files.getFileAttributeView() 🌱
<br>
<hr>

## 🟥 9.4 Stream Methods
### ⭐ Walking a Directory ⭐
#### 🌱 Using Files.walk() 🌱
#### 🌱 Using Files.find() 🌱

### ⭐ Using Files.list() ⭐

### ⭐ Using Files.lines() ⭐

## 🟥 9.5 Comparing Legacy Files and NIO.2 Methods
