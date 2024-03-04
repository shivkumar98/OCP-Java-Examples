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
1) `Path getFileName()` - returns a path representing the path furthest away from root
2) `Path getParent()` - returns the enclosing parent of a path. Returns null if there is no enclosing parent:
```java
Paths.get(".").getParent(); // NULL
Paths.get("src/revision/random"); // src/revision
```
3) `Path getRoot()` - returns the root of a denoted path, will always return null for relative paths
```java
Paths.get("src/revision/random").getRoot(); // NULL
Paths.get("/home/zoo").getRoot(); // /
```
4) `Path toAbsolutePath()` - converts a relative path to an absolute one by appending it to the current working directory. 
```java
Paths.get(".").toAbsolutePath(); //  C:/Users/Shiv/Documents/GitHub/OCP-Java-Examples/.
```
5) `Path relativize(other)` - returns a relative path between 2 paths of same type. Throws runtime exception if given incompatible types.
```java
Paths.get(".").relativize(Paths.get("src/revision"));
// src/revision
```
6) `Path normalize()` - removes redundancies of a path but does NOT go beyond the file system
```java
Paths.get("../../..").normalize(); // ../../..
```\
7) `Path toRealPath()` - converts a path to a real one if it exists, otherwise throws a checked IOException:
```java
try {
	Paths.get(".").toRealPath();
	// C:/Users/Shiv/Documents/GitHub/OCP-Java-Examples
} catch (IOException e) {}
```

### ⭐ Path File Methods ⭐
* The `Files` class is a helper class for Path instances representing files
* Here are some of the methods in this class:
1) `boolean exists(Path)` - returns true if file actually exists in the file system
```java
File.exists(Paths.get("fake/madeup")); // FALSE
File.exists(Paths.get("src")); // TRUE
```

2) `boolean isSameFile(Path,Path)` - returns true when two paths point to the same file in the file system. This methhod first calls `equals()`, if true it will return true otherwise it will check if the files actually exist:
```java
try {
	Path relative = Paths.get("src");
	Path absolute =	Paths.get("C:/Users/Shiv/Documents/GitHub/OCP-Java-Examples/src");
	Files.isSameFile(relative,absolute); // TRUE

	Path p1 = Paths.get("fake/madeup");
	Path p2 = Paths.get("fake/madeup/");
	p1.equals(p2); // TRUE
	Files.isSameFile(p1, p2); // TRYE
} catch (IOException e) { }
```
* If we try to call this method on two methods which are not `equal`, then an exception is thrown:
```java
Path relFakePath = Paths.get("home/zoo");
Path absFakePath = Paths.get("/home/zoo");
relFakePath.equals(absFakePath);
try {
	Files.isSameFile(relFakePath, absFakePath);
} catch (IOException e) {
	// EXCEPTION CAUGHT!!!	
}
```

3) `Path createDirectory(Path)` - makes a single directory denoted by the path
4) `Path createDirectories(Path)` - is able to construct non-existent folders denoted by the path
* These methods can throw an IOException, e.g. if the folder already exists
* If a symbolic link is provided, the file/dir it points to will be the one which is created
```java
Path newFolder = Paths
	.get("src/revision_notes/chap09_v2/new_folder");
try {
	Path createdDir = Files.createDirectory(newFolder);
	// prints the following if the folder does not exist
	System.out.println(createdDir);
	// src/revision_notes/chap09_v2/new_folder
} catch (IOException e ) {
	// exception thrown if folder already exists
}
```

5) `Path copy(source, target)` - will copy the source to target
* By default:
  - Symbolic links ARE traversed
  - Attributes are NOT copied
  - Will NOT overwrite an existing file
```java
Path newFolder = Paths
	.get("src/revision_notes/chap09_v2/new_folder");
Path target = Paths
	.get("src/revision_notes/chap09_v2/newfolderV2");

try {
	Path copied = Files.copy(source,target,REPLACE_EXISTING);
	System.out.println(copied);
	// src/revision_notes/chap09_v2/newfolderv2
} catch (IOException e) { }
```

6) `Path move(source, destination)` - moves/renames a path
* By default:
  - Symbolic links ARE traversed
  - Attributes ARE copied over
  - Will NOT overwrite existing file
* If `NO_FOLLOWLINKS` is flagged, then the symbolic link itself is moved, not the file it points to
* `ATOMIC_MOVE` must be flagged to prevent processed seeing an incomplete file
```java
Path source = Paths
	.get("src/revision_notes/chap09_v2/newfolderV2");
Path destination = Paths
	.get("src/revision_notes/chap09_v2/newfolderV3");
try {
	Path moved = Files.move(source, destination);
	// prints the following if destination does not already exist
	System.out.println(moved);
	// src/revision_notes/chap09_v2/newfolderV3
} catch (IOException e) {
	// exception caught if already exists!
}
```

7) `void delete(Path)`
8) `boolean deleteIfExists(Path)`
```java
Path folderToBeDeleted = Paths
		.get("src/revision_notes/chap09_v2/newfolderV3");
try {
	boolean isDeleted = Files.deleteIfExists(folderToBeDeleted);
	System.out.println(isDeleted); // true
} catch (IOException e) { }
```

9) `List<String> readAllLines(Path)`
```java
Path textFile = Paths
	.get("src/revision_notes/chap09_v2/file.txt");
try {
	List<String> list = Files.readAllLines(textFile);
	System.out.println(list);
	// [line 1 , line 2]

} catch (IOException e) { }
```

<br><hr>

## 🟥 9.3 Understanding File Attributes

### ⭐ Basic File Attributes ⭐
* The `Files` class has quite a few methods for evaluating basic file attributes which are not file system dependent.
1) `boolean isSymbolicLink()`
2) `boolean isDirectory()`
3) `boolean isRegularFile()`
* Most of the time, only one of the above 3 methods will return true
* The exception is for symbolic links where at most 2 can be true depending on what file/directory the symbolic link points to in the file system
```java
Path regularFile = Paths.get("README.md");
Files.isRegularFile(regularFile); // TRUE
Files.isDirectory(regularFile); // FALSE
Files.isSymbolicLink(regularFile); // FALSE
```

4) `boolean isHidden(Path) throws IOException`
```java
try {
	boolean isHidden = Files.isHidden(regularFile);
	// false
} catch (IOException e) { }
```
5) `long size(Path) throws IOException`

6) `UserPrincipal getOwner(Path) throws IOException`
```java
try {
	UserPrincipalOwner owner =
		Files.getOwner(regularFile);
	// DESKTOP-RSM8H8J\Shiv (User)
} catch (IOException e) { }
```
7) `Path setOwner(Path,UserPrincipal) throws IOException`
* The `UserPrincipal` can be obtained via the `UserPrincipalLookupService`:
```java
try {
	UserPrincipalLookupService lookup = FileSystems
			.getDefault()
			.getUserPrincipalLookupService();
	UserPrincipal user = lookup.lookupPrincipalByName("Shiv");
	// ^ can be used to set owner
	System.out.println(user);
	// DESKTOP-RSM8H8J\Shiv (User)
} catch (IOException e) { }
```

8) `FileTime getLastModifiedTime(Path) throws IOException`
9) `Path setLastModifiedTime(Path, FileTime) throws IOException`
```java
FileTime dateTime = Files
	.getLastModifiedTime(regularFile);
// 2024-02-10T10:58:40.7507014Z
Path setTime = Files.setLastModifiedTime(regularFile, dateTime);
```
* FileTime can be converted to a long representing epoch time:
```java
FileTime dateTime = FileTime.fromMillis(System.currentMillis());
long epochTime = dateTime.toMillis();
```

### ⭐ File Attributes with Views ⭐
* A **View** is a group of related attributes for a specific file system
* Views offer performance enhancements over querying for singular attributes as less round trips are necessary between java and OS.

* There are attributes and views classes. 
* The attributes class which I need to be aware of for the exam is the `BasicFileAttributes` 
* We can obtain an instance from a view, or directly from a path 
* We used `Files.readAttributes(Path,Class<A>)` to obtain it directly:
```java
Path path = Paths.get("README.md");
BasicFileAttributes attributes = null;
try {
	attributes = Files.readAttributes(path, BasicFileAttributes.class);
}
// attributes can ONLY be used for reading attributes, NOT WRITING!
// attribute.setTimes() // COMPILER ERROR
```
* This class has the following methods:
	- `isRegularFile()`
	- `isDirectory()`
	- `isSymbolicLink()`
	- `isOther()`
	- `size()`
	- `fileKey()`

<br>

* The view class is used for WRITING attributes!
* The only view class I need to know is `BasicFileAttributeView`
* This can be obtained via the `Files.getAttributeView(Path,Class<<A>)`:
```java
BasicFileAttribute view = Files
	.getFileAttributeView(readMe, BasicFileAttributeView.class);
```
* This class has a `readAttributes()` method:
```java
try {
	BasicFileAttributes attributes = 
		view.readAttributes();
} catchh (IOException e) { }
```

* This class only has one setter: `setTimes(lastModified, lastAccessed, creation)`
```java
FileTime newLastAccessedTime = 
	FileTime.fromMillis(System.currentTimeMillis());
try {
	view.setTimes(null, newLastAccessedTime, null);
	// using null to not modify other times
} catch (IOException e) { }
```

<br><hr>

## 🟥 9.4 Stream Methods
* **Walking a directory** is where you iterate through the descendants of a directory until you meet a condition or there is no more to iterate over
* `Files.walk(Path)` walks a directory in a DEPTH-FIRST and LAZY manner.
* This method has an overload which specifed the maximum depth Java will go down a directory. If this overload is not specified, a default max limit is `Integer.MAX_VALUE`
```java
Path p = Paths.get("src/revision_notes/chap09_v2");
try {
	Stream<Path> stream = Files.walk(p);
	stream.map(s->s.toString())
	.forEach(System.out::println);
	/* this prints the following:
		* src/revision_notes/chap09_v2
		* src/revision_notes/chap09_v2/file.txt
		* src/revision_notes/chap09_v2/README.md
		* src/revision_notes/chap09_v2/java
		* src/revision_notes/chap09_v2/java/AttributesAndViews.java
		* src/revision_notes/chap09_v2/java/BasicFileAttributes.java
		* src/revision_notes/chap09_v2/java/NewStreamMethods.java
		* src/revision_notes/chap09_v2/java/PathFileMethods.java
		* src/revision_notes/chap09_v2/java/PathObjectMethods.java
	*/
} catch (IOException e) { }

try {
	Files.walk(p, 1)
		.forEach(System.out::println);
	/*
		* src/revision_notes/chap09_v2
		* src/revision_notes/chap09_v2/file.txt
		* src/revision_notes/chap09_v2/java
		* src/revision_notes/chap09_v2/README.md
	*/
	
	Files.walk(p, 0)
	.forEach(System.out::println);
	// src/revision_notes/chap09_v2
} catch (IOException e) { }
```

<br>

* `Files.walk(Path,BiPredicate,Int)` is similar to the walk method above, except you can use a BiPredicate which takes a `Path` and `BasicFileAttributes` argument:
```java
try {
	Stream<Path> stream = Files
		.find(p, 2, (path,attr)->true);
} catch (IOException e) { }
```

<br>

* There is a method which reads the lines of a file `Files.readAllLines()`:
```java
try {
	Stream<String> stream = Files.lines(Paths.get("README.md"));
	System.out.println(stream.collect(Collectors.toList()));
	// [, # ☕️ OCP Java Examples, , I started .... ]
} catch (IOException e) { }
```
* This method can avoid OutOfMemoryError that Files.lines() is suspectable


<br><hr>

## 🟥 9.5 Comparing Legacy Files and NIO.2 Methods
