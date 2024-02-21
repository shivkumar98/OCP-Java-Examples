<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 9.4 Presenting the New Stream Methods
* Before Java 8, the techniques to perform complex file operations in NIO.2 required alot of code, often requiring its own class.

<hr>

## 🟥 9.4.1 Conceptualising Directory Walking
* A common task in a file system is to iterate over descendants of a particular path
* E.g. you may want to look in a directory and collect all `.java` files.
* **Walking a directory** is the process of starting at a parent directory and iterate over all of its descendants until condition is met, or all files are iterated

### ⭐ Search Strategy ⭐
* There are 2 common strategies for walking a directory tree:
1) **Depth-first search** will go all the way down to a particular path, once it hits the end, it will back track up a node and traverse the paths its skipped
2) **Breadth-first** will traverse down 1 depth level, look at all records at that level, and then go down another depth level. Result will be ordered by depth
* For the exam, I need to know that the Streams API uses depth-first search, with a default maximum depth of `Integer.MAX_VALUE`

## 🟥 9.4.2 Walking a Directory
* In chapter 4 we saw the methods which were available to us from the `Streams` API
* The `File.walk(Path)` method is a newly added NIO.2 API method as part of Java 8 which aims to reduce the amount of code needed to walk a directory
* This method will traverse in a **depth-first** and **lazy** manner - child elements are not loaded unless the target can not be found (improves performance)
* This method has the following signatures:
```java
Stream<Path> walk(Path) throws IOException
Stream<Path> walk(Path, int maxDepth) throws IOException
```
<br>

* Here is code which will print all the files ending with `.java` in my chapter_9 directory of this repo:
```java
Path chap9 = Paths.get("src//chapter_9");
try {
    Files.walk(chap9)
    .filter(p->p.toString().endsWith(".java"))
    .forEach(System.out::println);
} catch (IOException e) { /* handle */ }
```
* This printed the following:
```
src\chapter_9\c_9_1_intro_nio2\javacode\UsingPaths.java
\chapter_9\c_9_3_understanding_file_attributes\java\c_9_3_1\ReadingFileLength.java
src\chapter_9\c_9_3_understanding_file_attributes\java\c_9_3_1\TestingFileAccessibility.java
src\chapter_9\c_9_3_understanding_file_attributes\java\c_9_3_2\ModifyingAttributes.java
src\chapter_9\c_9_3_understanding_file_attributes\java\c_9_3_2\ReadingAttributes.java
src\chapter_9\c_9_4_new_stream_methods\java\WalkingADirectory.java
...
```
* I could've supplied the max depth argument to this method. If I chose `3` as max depth, I would get the following instead:
```
src\chapter_9\c_9_1_intro_nio2\javacode\UsingPaths.java
src\chapter_9\c_9_2_interacting_with_paths_files\javacode\CheckingPathType.java
src\chapter_9\c_9_2_interacting_with_paths_files\javacode\CreatingNewPathsWithSubpath.java
src\chapter_9\c_9_2_interacting_with_paths_files\javacode\DuplicatingFileContents.java
```

### ⭐ Avoiding Circular Paths ⭐
* By default, symbolic links will not be traversed as this could lead to a cycle where a symbolic link points a to a ancestor and an infinite loop
* You can disable this default behaviour, by overloading an option of `FOLLOW_LINKS` to the walk() method
* Java can detect if an circular path has occured, by seeing if the path it is traversing has already been traversed
* If it detects a circular path, a `FileSystemLoopException` is thrown⚠️

## 🟥 9.4.3 Searching a Directory
* We have a `find()` method in the Files class:
```java
Stream<Path> find(Path,int,BiPredicate<Path, BasicFileAttribute>)
```
* This allows us to to filter based both on the path and it's attributes:
```java
Path chap_9 = Paths.get("src//chapter_9");
try {
    BiPredicate<Path, BasicFileAttributes> biPred =
        (p,basicFileAttr) -> path.toString().endsWith(".java")
            && basicFileAttr.size() > 1234;
    Stream<Path> stream = Files.walk(chap_9, 3, biPred);
    stream.forEach(System.out::println);
} catch (IOException e) { }
/* this prints the following:
src\chapter_9\c_9_2_interacting_with_paths_files\javacode\MakingDirectories.java
src\chapter_9\c_9_2_interacting_with_paths_files\javacode\PathFilePathTest.java
src\chapter_9\c_9_2_interacting_with_paths_files\javacode\UsingDeleteAndDeleteIfExists.java
src\chapter_9\c_9_2_interacting_with_paths_files\javacode\UsingPathObjects.java
src\chapter_9\c_9_4_new_stream_methods\java\WalkingADirectory.java
*/
```
* This method also supports the `FOLLOW_LINKS` option

## 🟥 9.4.4 Listing Directory Contents

## 🟥 9.4.5 Printing File Contents