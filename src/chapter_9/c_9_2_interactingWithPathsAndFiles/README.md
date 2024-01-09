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
    - May throw a `AtomicMoveNotSupportedException` if file system does not support it

<hr>

## 🟥 9.2.2 Using Path Objects
* We have already seen two methods in the `Path` interface: `toFile()` and `toUri()`
* Alot of methods return a Path object, and thus methods can be chained:
    ```java
    Paths.get("/zoo/../home").getParent().normalize().toAbsolutePath();
    ```

### ⭐ Viewing the Path with toString(), getNameCount() and getName() ⭐
* The Path interface has the above methods to obtain basic information about the path representative
```java
Path path = Paths.get("/land/hippo/harry.happy");
System.out.println("The Path Name is: "+path); // /land/hippo/harry.happy
for(int i=0;i<path.getNameCount();i++) {
    System.out.println(path.getName(i));
    /*  Prints the following:
    land
    hippo
    harry.happy
    */
}
```

### ⭐ Accessing Path Components with getFileName(), getParent() and getRoot() ⭐
* The Path interface also includes method for retrieving specific subelements of a Path object
* `getFileName` returns a Path instance representing the filename
* `getParent()` returns a Path instance representing the parent path.
    - Will return null if there is no parent⚠️
    - It will not traverse beyond the file system if a relative path is provided
* `getRoot()` returns the root element for the path
    - Will return null if relative path is provided

```java
public class PathFilePathTest {
    public static void printPathInformation(Path path) {
        System.out.println("Filename is: "+path.getFileName());
        System.out.println("Root is: "+path.getRoot());
        Path currentParent = path;
        while((currentPath = currentPath.getParent()) != null) {
            System.out.println("\tCurrent parent is: "+currentParent());
        }
    }

    public static void main(String[] args) {
        printPathInformation(Paths.get("/zoo/armadillo/shells.txt"));
        /* This will print
        Filename is: shells.txt
        Root is: /
            Current parent is: /zoo/armadillo
            Current parent is: /zoo
            Current parent is: /
        */

        printPathInformation(Paths.get("armadillo/shells.txt"));
        /* This will print
        Filename is: shells.txt
        Root is: null
            Current parent is: armadillo/
        
        */
    }
}
```

### ⭐ Checking Path Type with isAbsolute() and toAbsolutePath() ⭐

### ⭐ Checking Path Type with isAbsolute() and toAbsolutePath() ⭐





<hr>

## 🟥 9.2.3 Interact with Files



### ⭐ H3 ⭐
