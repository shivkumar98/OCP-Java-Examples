<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 9.4 Presenting the New Stream Methods
* Java 8 provides you methods for performing complex operations like searching for a file in a directory tree with one-line code which prior to Java 8 would've needed entire classes!

## 🟥 9.4.1 Conceptualizing Directory Walking
* Files and directories can be represented as a tree, where every file/directory has exactly one parent directory
* A common task is to iterate across all files.
* Walking or traversing a directory is the process by which you start at a parent directory and iterating over all descendants until some condition is met
### ⭐ Selecting a Search Strategy ⭐
* Depth-first search goes all the way through an arbritary leaf and navigates back to the root and then traversing down fully any skipped directories
* Breadth first search starts at the roor and processes all elements of each particular depth
* The Streams API employs the depth-first strategy with a max value of `Integer.MAX_VALUE`
<br>

## 🟥 9.4.2 Walking a Directory
* Files.walk(path) returns a `Stream<Path>` which traverse the directory in a depth first and lazy manner
* By lazy it means the set of elements is built and read while the directory is being traversed
* Here is an example of walking of using a stream to walk a directory structure:
```java
try {
    Files.walk(path)
        .filter(p->p.toString().endsWith(".java"))
        .forEach(System.out::println);
} catch (IOException e) {
    // handle file IO exception
}
```
* There is an overloaded method of walk `walk(Path,int)` which takes a maximum directory depth. E.g. you would specify an int of 1 if you wanted to print any child records

* By default, the `walk()` method will not traverse symbolic links

## 🟥 9.4.3 Searching a Directory
* We used a stream filter to filter the results of the directory walk. `Files.find(Path,int,BiPredicate)` method. The BiPredicate takes Path and BasicFileAttributes as parameters.
* Here is an example:
```java
Path path = Paths.get("/bigcats");
long dateFilter = 14200700000l;
try {
    Stream<Path> stream = Files.find(path, 10,
        (p,a)->p.toString().endsWith(".java")
        && a.lastModifiedTime.toMillis()>dateFilter);
}
```

## 🟥 9.4.4 Listing Directory Content

## 🟥 9.4.5 Printing File Contents