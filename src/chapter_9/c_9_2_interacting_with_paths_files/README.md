<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 9.2 Interacting with Paths and Files

* A Path object does not necessarily point to a file but instead represents a location in the file system
* Some methods require for the file to exist, e.g. `Path.toRealPath()`, and will throw a checked exception if thhe file is not available.

## 🟥 9.2.1 Providing Optional Arguments
* I am not required to memorize which of the NIO.2 methods have optional arguments but I do need to know what they do
* Here are the common optional arguments in NIO.2:
  
| Enum Value | Description | Usage       |
| ---------- | ---------------------- | ----------- |
| NOFOLLOW_LINKS | Symbolic links will NOT be traversed. | Copying/moving/reading files and test for existence |
| FOLLOW_LINKS | Symbolic links WILL be traversed | Traversing a directory tree |
| COPY_ATTRIBUTES | Metadata for a file will be copied with file copied | Copy file |
| REPLACE_EXISTING | Will replace if the target file exists. If not provided will throw exception when attempting to replace existing file | Copying/Moving files |
| ATOMIC_MOVE | File is moved atomically, ensuring any process using the file sees the complete record. Throws exception if OS does not support it | Moving files |

<hr>

## 🟥 9.2.2 Using Path Objects
* Many of the methods in the Path interface transform the path object and return a new path object
* Methods are often chained, e.g.:
```java
Paths.get("/zoo/../home").getParent().normalize().toAbsolutePath();
```

### ⭐ Viewing the Path with toString(), getNameCount(), and getName() ⭐
* `String toString()` - returns a String representation of the path
```java
Path path = Paths.get("src/chapter_9/c_9_1_intro_nio2/javacode/file.txt");
System.out.println(path.toString());
```
* `int Path.getNameCount()` - returns number of elements in path
* `Path getName(int)` - returns an element of the path using an index beginning at 0:
```java
Path path = Paths.get("src/chapter_9/c_9_1_intro_nio2/javacode/file.txt");
for(int index=0;index<path.getNameCount();index++) {
  System.out.println(paths.getName(index));
}
/* prints 
src
chapter_9
...
*/
```
* If the path has a root of `/`, this will be ignored:
```java
Path pathWithRoot = Paths.get("/root/file.txt");
pathWithRoot.getName(0); // root
pathWithRoot.getName(1); // file.txt
```

### ⭐ Accessing Path Components with getFileName(), getParent(), and getRoot() ⭐
* `Path getFileName()` - returns the element furthest away from root:
```java
Path pathWithRoot = Paths.get("/root/file.txt");
pathWithRoot.getFileName(); // file.txt
```
* `Path getParent()` - returns parent element or null if not available
```java
Path path = Paths.get("/root/file.txt");
Path parentPath = path.getParent(); // root
parentPath.getParent(); // null
```
* This method will not traverse to outside the file-system!!!
```java
Path path = Paths.get("src/chapter_9/c_9_1_intro_nio2/javacode/file.txt");
path.get(0).getParent(); // null
```

* `Path getRoot()` - returns the root element for a Path object, will return null for a relative path:
```java
Path relativePath = Paths
  .get("src/chapter_9/c_9_1_intro_nio2/javacode/file.txt");
relativePath.getRoot(); // null
		
 Path pathWithRoot = Paths
  .get("/root/file.txt");
pathWithRoot.getRoot(); // \
		
Path fullPath = Paths
  .get("C:\\Users\\Shiv\\Documents\\GitHub");
fullPath.getRoot(); // C:\
```

<br>

* Here is a program which traverses absolute and relative path objects to show how it handles the root differently
```java
public class PathFilePathTest {
  static void printPathInformation(Path path) {
    System.out.println("Filename is: "+path.getFileName());
    System.out.println("Root is: "+path.getRoot());

    Path currentPath = path;
    while((currentPath = currentPath.getParent()) != null) {
      System.out.println("  Current parent is: "+currentPath);
    }
  }
}
```
* Here we print a relative and absolute path:
```java
// MAIN METHOD:
Path relativePath = Paths
	.get("src/chapter_9/c_9_1_intro_nio2/javacode/file.txt");
printInformation(relativePath);
/* Filename is: file.txt
  * Root is: null
  *   Current parent is: src\chapter_9\c_9_1_intro_nio2\javacode
  *   Current parent is: src\chapter_9\c_9_1_intro_nio2
  *   Current parent is: src\chapter_9
  *   Current parent is: src
*/

Path absolutePath = Paths.get("C:\\Users\\Shiv\\Documents\\GitHub");
printInformation(absolutePath);
/* Filename is: Github
  * Root is: C:\
  *   Current parent is: C:\Users\Shiv\Documents
  *   Current parent is: C:\Users\Shiv
  *   Current parent is: C:\Users
  *   Current parent is: C:\
*/
```

### ⭐ Checking Path Type with isAbsolute() and toAbsolutePath() ⭐
* `boolean isAbsolute()` - checks if path is absolute or relative
* `Path toAbsolute(Path)` - converts a relative path to an absolute path or returns a copy if an absolute path is provided
```java
Path relativePath = Paths
      .get("src/chapter_9/c_9_1_intro_nio2/javacode/file.txt");
relativePath.isAbsolute(); // false
Path relativeToAbsolute = relativePath.toAbsolutePath();
System.out.println(relativeToAbsolute);
/* C:\Users\Shiv\Documents\GitHub\
  *  OCP-Java-Examples\src\chapter_9\
  *  c_9_1_intro_nio2\javacode\file.txt */

Path absolutePath = Paths
    .get("C:\\Users\\Shiv\\Documents\\GitHub");
absolutePath.isAbsolute(); // true
Path absoluteToAbsolutePath = absolutePath.toAbsolutePath();
absoluteToAbsolutePath;
// C:\Users\Shiv\Documents\GitHub
```

### ⭐ Creating a New Path with subpath() ⭐
* `Path subpath(int, int)` - returns a relative path where the second parameter is exclusive of the elements
```java
Path absolutePath = Paths
  .get("\\Users\\Shiv\\Documents\\GitHub")
absolutePath.getNameCount(); // 4
absolutePath.subpath(1,1); // throws exception
absolutePath.subpath(0,1); // Users
absolutePath.subpath(0,4); // Users/Shiv/Documents/GitHub
```

### ⭐ Using Path Symbols ⭐
* We can use `.` for current directory and `..` for directory of parent of current directory
```java
Path parentPathOfGitHub = Paths
				.get("\\Users\\Shiv\\Documents\\GitHub\\..");
parentPathOfGitHub.normalize(); // \Users\Shiv\Documents
```

### ⭐ Deriving a Path with relativize() ⭐
* `Path relativize(Path anotherPath)` - returns a path to get to `anotherPath`
* Here is an example using two absolute paths:
```java
Path absolutePath1 = Paths
  .get("/Documents/pizza.txt");
Path absolutePath2 = Paths
  .get("Documents/Shiv/file.txt");
absolutePath1.relativize(absolutePath2);
// ../Shiv/file.txt
absolutePath2.relativize(absolutePath1);
// ../../pizza.txt
```
* If two relative paths are provided, they are computed as if they are in the same working directory:
```java
Path relPath1 = Paths
  .get("pizza.txt");
Path relPath2 = Paths
  .get("poultry/chicken.txt");
relPath1.relativize(relPath2); // ../poultry/chicken.txt
relPath2.relativize(relPath1); // ../../pizza.txt
```
* If you try to mix a relative and absolute path, you will get an `IllegalArgumentException` at runtime:
```java
relPath1.relativize(absolutePath1); // THROWS EXCEPTION
absolutePath1.relativize(relPath1); // THROWS EXCEPTION
```

### ⭐ Joining Path Objects with resolve() ⭐
* `Path resolve(Path other)` - appends the other path to path it was invoked on.
```java
Path path1 = Paths.get("/cats/../panther");
Path path2 = Paths.get("/food");
path1.resolve(path2); // \food
path2.resolve(path1); // \cats\..\panther
```

### ⭐ Cleaning Up a Path with normalize() ⭐

### ⭐ Checking for File Existence with toRealPath() ⭐




<hr>


## 🟥 9.2.3 Interacting With Files