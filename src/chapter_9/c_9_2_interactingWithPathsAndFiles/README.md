<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 9.2 Interacting with Paths and Files

* We shall see the methods which are available to us for `Path` objects
* A Path object is NOT a file, but a representation of a location in the file system.
    * E.g. finding the parent directory of a non-existing file can still be computed!
    * Some methods do require to file to exist, and will throw a checked exception if not present

<hr>

## 🟥 9.2.1 Providing Optional Arguments

* Many of the methods in NIO.2 API take an option `varargs` argument.
* I am not required to memorise which methods have the optional argument, but I am expected to understand what they do


### ⭐ Common Optional Arguments in NIO.2 ⭐
1) **ENUM VALUE:** `NOFOLLOW_LINKS`
* **USAGE:**
    - Testing file exists
    - Read file data
    - Copy and move File
* **DESCRIPTION:**
    - If provided, symbolic links will NOT be traversed. Used for performing operations on symbolic links themselves


2) **ENUM VALUE:** `FOLLOW_LINKS`
* **USAGE:**
    - Traverse a directory tree
* **DESCRIPTION:**
    - If provided symbolic links will be traversed

3) **ENUM VALUE:** `COPY_ATTRIBUTES`
* **USAGE:**    
    - Copy files
* **DESCRIPTION:**
    - If provided, all metadata about file is copied along side it


4) **ENUM VALUE:** `REPLACE_EXISTING`
* **USAGE:**
    - Copy File
    - Move File
* **DESCRIPTION:**
    - If provided, and target file exists, then it will be replaced
    - If not provided, and target file exists, then an exception will be thrown

5) **ENUM VALUE:** `ATOMIC_MOVE`
* **USAGE:**
    - Move file
* **DESCRIPTION:**
    - This ensures that any process using existing file, will see a complete record
    - May throw an exception if file system does not support it

## 🟥 9.2.2 Using Path Objects

## 🟥 9.2.3 Interact with Files



### ⭐ H3 ⭐
