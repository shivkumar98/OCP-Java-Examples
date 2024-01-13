<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 9.3

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

### ⭐ Testing File Accessibility with isReadable() and isExecutable() ⭐

### ⭐ Reading File Length with size() ⭐

### ⭐ Managing File Modifications wwith getLastModifiedTime() and setLastModifiedTime() ⭐

### ⭐ Managing Ownership with getOwner() and setOwner() ⭐


## 🟥 9.3.2 Improving Access with Views

### ⭐ Understanding Views ⭐

### ⭐ Reading Attributes ⭐

### ⭐ Modifying Attributes ⭐

<hr>