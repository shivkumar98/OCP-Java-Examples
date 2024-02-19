<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 9.3 Understanding File Attributes
* File attributes are metadata of files and directories - which is not stored in the contents of the file but rather the file system
* Files class has methods for accessing file attributes

<hr>

## 🟥 9.3.1 Discovering Basic File Attributes
* We shall discuss methods DIRECTLY WITHIN the Files class for reading file attributes
* These methods can be used in ANY operating system but may have limited information in some systems.

### ⭐ Reading Common Attributes with isDirectory(), isRegularFile(), and isSymbolicLink() ⭐
* These methods all take a Path and return a `boolean` 
* `Files.isRegularFile(Path)` is true if path points to a regular file (any non-directory, non-symbolic link, non-resource or any non-regular file)
* `Files.isDirectory(Path)` is true if path points to directory
* `Files.isSymbolicLink(Path)` is true if path is a symbolic link
```java
Path directory = Paths
    .get("src//chapter_9");
Files.isRegularFile(directory); // false
Files.isDirectory(directory); // true
Files.isSymbolicLink(directory); // false

Path file = Paths
    .get("src//chapter_9//README.md");
Files.isRegularFile(file); // true
Files.isDirectory(file); // false
Files.isSymbolicLink(file); // false

Path symbolicLink = Paths
    .get("src//symbolic-link"); // just a placeholder
Files.isRegularFile(symbolicLink);
// ^ COULD be true if points to regular file
Files.isDirectory(symbolicLink);
// ^ COULD be true if points to directory
Files.isSymbolicLink(symbolicLink); // true
```

### ⭐ Checking File Visibility with isHidden() ⭐
* Method signature:
```java
boolean isHidden(Path) throws IOException
```
* This method can throw a `NoSuchFileException` for example

* In linux based systems, hidden files are denoted by the filename - starting with a `.` makes it hidden
* In windows systems, you have to set a hidden attribute.
* I create a hidden file:

<img src="screenshots/hidden-file.png" width="200px">

```java
Path hiddenFile = Paths.get("src//"
    + "chapter_9//"
    + "c_9_3_understanding_file_attributes//"
    + "java//"
    + "c_9_3_1//"
    + "hidden-file.txt");
try {
    boolean x = Files.isHidden(hiddenFile);
    System.out.println(x); // prints true
} catch (IOException e) { }
```

### ⭐ Testing File Accessibility with isReadable() and isExecutable() ⭐
* These methods do not throw a checked exception!
* A file could be visibile to a user but not actually readable/executable
* A file's extension does not determine if it is executable, a PNG or txt can both be executable
```java
Path file = Paths
        .get("src//"
            + "chapter_9//"
            + "c_9_3_understanding_file_attributes//"
            + "java//"
            + "c_9_3_1//"
            + "hidden-file.txt");
Files.isReadable(file); // true
Files.isExecutable(file); // true
```

### ⭐ Reading File Length with size() ⭐
* Signature:
```java
long size(Path) throws IOException
```
* This method will throw a IOException if the file does not exist or the file information can not be accessed.
```java
Path file = Paths
    .get("src//"
        + "chapter_9//"
        + "c_9_3_understanding_file_attributes//"
        + "java//"
        + "c_9_3_1//"
        + "ReadingFileLength.java");
try {
    long size = Files.size(file);
    System.out.println(size); // 845
} catch (IOException e) { }
```

### ⭐ Managing File Modifications with getLastModifiedTime() and setLastModifiedTime() ⭐
* Method signatures:
```java
FileTime getLastModifiedTime(Path) throws IOException
Path setLastModifiedTime(Path, FileTime) throws IOException
```
* Majority of OS's support the ability to track the last modified date of a file
* This can be used by applications to distinguish when a file needs processing when its contents have been modified - this is more efficient than loading the entire file!
* Example:
```java
Path file = Paths
        .get("src//"
            + "chapter_9//"
            + "c_9_3_understanding_file_attributes//"
            + "java//"
            + "c_9_3_1//"
            + "ReadingFileLength.java");
try {
    FileTime fileTime = Files.getLastModifiedTime(file);
    // ^ 2024-02-18T14:49:56.173496Z
    long epochTime = fileTime.toMillis(); 
    // ^ 1708267796173
} catch (IOException e) { }

try {
    FileTime fileTimeNow =
        FileTime.fromMillis(System.currentTimeMillis());
    // ^ 2024-02-18T15:01:47.891Z
    Files.setLastModifiedTime(file, fileTimeNow);
    Files.getLastModifiedTime(file); // 2024-02-18T15:01:47.891Z
} catch (IOException e) { }
```

### ⭐ Managing Ownership with getOwner() and setOwner() ⭐
* Method signatures:
```java
UserPrincipal getOwner(Path) throws IOException
Path setOwner(Path,UserPrincipal) throws IOException
```
* The `UserPrincipalLookupService` can be used to find a UserPrincipal record in the filesystem. This service can be obtained statically as shown:
```java
try {
    UserPrincipalLookupService lookupService
        = FileSystems.getDefault()
            .getUserPrincipalLookupService();
    UserPrincipal me = lookupService
        .lookupPrincipalByName("Shiv");
    // ^ DESKTOP-RSM8H8J\Shiv (User)
}
```
* Example of getting the PrincipalUser:
```java
Path file = Paths.get("src//"
    + "chapter_9//"
    + "c_9_3_understanding_file_attributes//"
    + "java//"
    + "c_9_3_1//"
    + "hidden-file.txt");
try {
    UserPrincipal owner = Files.getOwner(file);
    // ^ DESKTOP-RSM8H8J\Shiv (User)
}
```

<hr>

## 🟥 9.3.2 Improving Access With Views
* So far we have been obtain accessing individual file attributes with single method calls
* We can obtain all metadata efficiently with a single call
* Also attributes are file system dependent and can be easily generalised for all file systems.
<br>

* NIO.2 API addresses both of these concerns by enabling you to construct views for different file systems with a single method call
* A **View** is a group of related attributes for a specific file system. A file can support multiple views
* The performance advantage for using views to read multiple attributes is substantial

### ⭐ Understanding Views ⭐
* To obtain a view, you must provide a Path and a class object which instructs the type of view which is needed
* The `Files` class has two methods for accessing view information:
    1. `Files.readAttributes()` returns a read-only view of the file attributes
    2. `Files.getFileAttributeView()` returns a view which provides direct access to file attributes, enabling modification
* Both of these methods throw IOException, e.g. for if the view is not supported by the OS.
* Below are the attributes and view classes:
| Attribute Class | View Class    | Description           |
| --------------  | ------------- | --------------------  |
| `BasicFileAttributes` | `BasicFileAttributeView` |  Basic set of attributes supported by all file systems. |
| `DosFileAttributes` | `DosFileAttributeView`|Attributes supported by DOS/windows based systems|
| `PosixFileAttributes`|`PosixFileAttributeView`|Attributes supported by POSIX systems (Linux/Mac)|

* Only the first row is covered by the exam!

### ⭐ Reading Attributes ⭐
* NIO.2 API provides a `Files.readAttributes(Path,Class<A>)` method which returns a read-only view of a file view

#### 🌱 BasicFileAttributes 🌱
* This class has attributes common to all file systems, including many of the single-line methods from the `Files` class
```java
Path file = Paths.get("src//"
    + "chapter_9//"
    + "README.md");
BasicFileAttributes attributeData 
    = Files.readAttributes(file, BasicFileAttributes.class);
attributeData.isRegularFile(); // true
attributeData.isDirectory(); // false
attributeData.isSymbolicLink(); // false
attributeData.isOther(); // false
// ^ isOther() can be used to check if file is 
// a resource or a device

attributeData.size(); // 343

FileTime x = attributeDate.creationTime();
// 2024-01-06T08:42:35.6047179Z
FileTime y = attributeData.lastModifiedTime();
// 2024-01-06T08:46:37.0737933Z
FileTime z = attributeData.lastAccessTime();
// 2024-02-10T11:35:04.9077723Z
Object w = attributeData.fileKey(); // null
// returns unique identifier in OS
// null if not supported
```

### ⭐ Modifying Attributes ⭐
* In order to modify attributes of a file we need to obtain a view
* We have the `Files.getAttributeView()` method which lets us do this:
```java
<V extends FileAttributeView> getFileAttributeView(Path,Class<V>)
```
* We can use this method to obtain a `BasicFileAttributeView`!
* We can then call `setTimes(lastModified,lastAccess,creation)` to update FileTime data:
```java
Path file = Paths.get("src//"
    + "chapter_9//"
    + "README.md");
BasicFileAttributeView view
    = Files.getFileAttributeView(file, BasicFileAttributeView.class);
try {
    BasicFileAttributes data = view.readAttributes();
    FileTime lastModified = data.lastModifiedTime();
    // 2024-01-09T07:52:15.2344042Z

    FileTime newLastModified = FileTime.fromMillis(lastModified.toMillis()+10_000);
    view.setTimes(newLastModified, null, null); // null => do not update
} catch (IOException e) {}
```