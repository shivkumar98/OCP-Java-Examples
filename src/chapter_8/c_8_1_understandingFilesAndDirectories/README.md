<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 8.1 Understanding Files and Directories
* This chapter focuses on `java.io` API to interact with files and streams
<hr>

## 🟥 8.1.1 Understanding Files and Directories

### 🟡 Conceptuazlizing the File System
* A file is a record within a file system which stores data
* A directory is also a record, but it contains files and directories.
* We shall refer to directories as a file record for the rest of this chapter.
* The file system is in charge of reading and writing data within a compute. 
* Different OS's have different file systems, we shall see how to connect automatically to thesde
* A path is the string representation of a file or directory
* In most file systems, the hierarchy is represented using strings concatenated with forward slashes

### 🟡 Introducing the File Class
* The `java.io.File` class is used to read information about existing files and directories, list contents, create/delete files/directories
* An instance of the `File` class represents the pathname of a particular file or directory on the file system.
* The `File` class cannot read or write data within the file directly, but it can be a passed as a reference to stream class to read and write data.


### 🟡 Creating a File Object
* The File object is often initialised using either the absolute or relative path.
* The seperate character varies from OS's, we can obtain the seperator character using either:
```java
System.getProperty("file.seperator");
System.out.println(java.io.File.separator);
// both print \ on my windows machine
```

## 🟥 8.1.2