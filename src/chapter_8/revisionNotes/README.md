<link href="../../styles.css" rel="stylesheet"></link>

# 📝 Chapter 8 - IO: Revision Notes

# 🧠 8.1 Understanding Files and Directories

## 🟥 8.1.1 Conceptuazlizing the File System
* Root directory is the upper most directory 

## 🟥 8.1.2 Introducing the File Class
* The File class is used to represent the pathname of a file/directory
* It can not read/write to the file itself
* The `File` class has the following methods:
1) `exists()`
2) `getName()` 
3) `getAbsolutePath()`
4) `isFile()`/`isDirectory()`
5) `length()` - returns number of bytes of file
6) `lastModified()`
7) `delete()` - can only delete a directory if it is empty
8) `renameTo(File)` - a `move()` method does not exist⚠️
9) `mkdir()`/`mkdirs()`
10) `getParent()`
11) `listFiles()`


<hr>

# 🧠 8.2 Introducing Streams

## 🟥 8.2.1 Stream Fundamentals

## 🟥 8.2.2 Stream Nomenclature

## 🟥 8.2.3 Common Stream Operations



<hr>

# 🧠 8.3 Working with Streams

## 🟥 8.3.1 The FileInputStream and FileOutputStream Classes

## 🟥 8.3.2 The FileReader and FilerWriter Classes

## 🟥 8.3.3 The ObjectInputStream and ObjectOutputStream Classes

## 🟥 8.3.4 The PrintStream and PrintWriter Classes

## 🟥 8.3.5 Review of Stream Classes



<hr>

# 🧠 8.4 Interacting With Users

## 🟥 8.4.1 The Old Way

## 🟥 8.4.2 The New Way