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
<br>

* `Path getName(int)` - returns an element of the path using an index beginning at 0:
```java
Path path = Paths.get("src/chapter_9/c_9_1_intro_nio2/javacode/file.txt");
for(int index=0;index<path.getNameCount();index++) {
  System.out.println(paths.getName(index));
}
/* prints src chapter_9 .... */
```
* If the path has a root of `/`, this will be ignored:
```java
Path pathWithRoot = Paths.get("/root/file.txt");
pathWithRoot.getName(0); // root
pathWithRoot.getName(1); // file.txt
```