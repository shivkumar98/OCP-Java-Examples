<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 9.3 Understanding File Attributes

* In the prior section we reviewed methods which could create, modify, read or delete a file or directory
* **File attributes** are file and directory metadata
* The `Files` class has methods for accessing file attributes
* File metadata includes things like whether the file is hidden or has permissons to be read by a single user.
* The `Files` class has methods to determine this
<hr>

## 🟥 9.3.1 Disovering File Attributes
* We shall begin with methods in the `Files` class for reading file attributes.
* While these methods are available on ALL OS's, it may have limited meaning in some file systems


### ⭐ Reading Common Attributes with isDirectory(), isRegularFile(), and isSymbolicLink() ⭐
* Java defines a **Regular File** as one which contains data rather than a sybmolic link, director or non-regular file content
* The `isRegularFile` will return true for Regular Files BUT it may also return true for symbolic linksk which point to a real file or directory
```java
Files.isDirectory(Paths.get("/canine/coyote/fur.jpg"));
// true even if fur.jpg is a symbolic link to a directory
Files.isRegularFile(Paths.get("canine/types.txt"));
// true even if types.txt points to a regular file or even if 
// it is a symbolic link pointing to a refular file
Files.isSymbolicLinkk(Paths.get("/canine/coyote"))
// will return true if coyote is a symbol linkk
// even if it points to a file/dir which does not exist
```

### ⭐ Checking File Visibility with isHidden() ⭐
* The `Files` class has a `.isHidden(Path)` method which determines whether a file or directory which exists
* This method throws IOException if there is an IO error when reading this method
```java
try {
    System.out.println(Files.isHidden(Paths.get("/walrus.txt")));
} catch (IOException e) {
    // handle exception
}
```

### ⭐ Testing File Accessibility with isReadable() and isExecutable() ⭐
* `isReadable(Path)` is used to determine if the contents of a file can be read
* `isExecutable(Path)` is used to determine whether a file can be executed
* These methods do not throw exceptions if the file does not exist

### ⭐ Reading File Length with size() ⭐
* The `Files.size(Path)` returns the size of a file in bytes.
* The value may differ from the actual size the file takes up in storage.
* The `size()` method throws a IOException if the file does not exist or the information can not be read
### ⭐ Managing File Modifications wwith getLastModifiedTime() and setLastModifiedTime() ⭐
* `Files.getLastModifiedTime(Path)` returns a `FileTime` object to accomplish this - this class stores date/time information of when the file was accessed, created, or modified.
* We can set the last modified date/time information using `Files.setLastModified(Path,FileTime)`
* Both of these methods throw IOException
```java
try {
    final Path path = Paths.get("/rabbit/food.jpg");
    System.out.println(Files.getLastModifiedTime(path).toMillis());
    File.setLastModifiedTime(path,
        FileTime.fromMillis(System.getCurrentMillis()));
    System.out.println(Files.getLastModifiedTime(path).toMillis());
} catch (IOException e) {
    // handle IOException
}
```
### ⭐ Managing Ownership with getOwner() and setOwner() ⭐
* `Files.getOwner(Path)` returns a `UserPrincipal` instance
* We also have a set method: `Files.setOwner(Path, UserPrincipal)`
* Both of these methods throw IOException
* We can obtain the owner of a file using `UserPrincipalLookupService`. You need to obtain an instance of `FileSystem` to use this service
```java
UserPrincipal owner = FileSystems.getDefault()
    .getUserPrincipalLLookupService()
    .lookupPrincipalByName("shiv");
UserPrincipal owner = FileSystems.getFileSystem()
    .getUserPrincipalLLookupService()
    .lookupPrincipalByName("shiv");
```
* Here are examples of using `getOwner()` and `setOwner()`:
```java
try {
    // Read owner
    Path path = Paths.get("/chicken/feathers.txt");
    System.out.println(Files.getOwner(path).getName());
    // Change owner of the file
    UserPrincipal owner = paths.getFileSystem()
        .getUserPrincipalLookupService()
        .lookupPrincipalByName("Shiv");
    Files.setOwner(path, owner);
    // Output the updated owner information
    System.out.println(Files.getOwner(path).getName());
} catch (IOException e) {
    // Handle file IOException
}
```

## 🟥 9.3.2 Improving Access with Views
* NIO.2 API allows you to retrieve all file metadata in a single call by allowing you to construct views for various file systems.
* A view is a group of related attributes for a specific file system.
* Views can also improve performance as there are less calls to the OS.
### ⭐ Understanding Views ⭐
* To request a view, you need to provide both a path of a file (or directory) and a class object.
* `Files.readAttributes()` returns a read-only view of the file attributes
* `Files.getFileAttributeView()` returns a direct view for modifying file information
* Both of these throw a IOEXception (e.g. for when trying read windows-based attributes within a Linux file system)
* Here are the attributes and view classes:

| Attribute Class | View Class | Description |
| --------------- | ---------- | ----------- |
| BasicFileAttributes | BasicFileAttributeView | Basic set of attributes supported by all file systems |
| DosFileAtttributes | DosFileAttributeView | Attributes supported by DOS/Windows-based systems |
| PosixFileAttributes | PosixFileAttributeView | Attributes supported by POSIX systems likek UNIX, Linux, Mac, and so on |

### ⭐ Reading Attributes ⭐
* NIO.2 API provides a `Files.readAttributes(Path,Class<A>)` which returns a read-only file view. 
* All attribute classes extend `BasicFileAttributes`
* Here is a code sample of reading attributes:
```java
public class BasicFileAttributesSamples {
    public static void main() throws IOException {
        Path path = Paths.get("/turtles/sea.txt");
        BasicFileAttributes data =
            Files.readAttributes(path, BasicFileAttributes.class);
        
        System.out.println("Is path a directory: "+data.isDirectory());
        System.out.println("Is path a file: "+data.isFile());
        System.out.println("Is path a symbolic link: "+data.isSymbolicLink());
        System.out.println("Path not a file, directory not symbolic link: "+data.isOther());

        System.out.println("Size in bytes: "+data.size());

        System.out.println("Creation Datetime: "+data.creationTime());
        System.out.println("Modified Datetime: "+data.lastModifiedTime());
        System.out.println("Last accessed time: "+data.lastAccessTime());
        System.out.println("Unique file identifier: "+data.f
    }
}
```

### ⭐ Modifying Attributes ⭐
* NIO.2 provides us with `Files.getAttributeView(Path,Class<V>)` which returns a view object to update the file attributes (which depend on operating system)

* `BasicFileAttributeView` is used to modify a file's set of date/time values.
* In general, we can not modify the other attributtes directly (like size or type without modifying the file itself)
* Here is a sample program which reads a file's attributes and increments the last modified datetime by 10 seconds:
```java
public class BasicFileAttributeViewSample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/turtles/sea.txt");

        BasicFileAttributeView view 
            = Files.getFileAttributeView(path,BasicFileAttributeView.class);
        BasicFileAttributes data = view.readAttributes();

        FileTime lastModifiedTime = FileTime.fromMillis(
            data.lastModifiedTime().toMillis()+10_000
        );
        view.setTimes(lastModifiedTime,null,null);
    }
}
```


<hr>