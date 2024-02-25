<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 9: Review Questions - Attempt 1

## Results:

Date: 25/02/2024 <br>
Score: 5/20 (25%) <br>

| Question # | Correct |
| ---------- | ------- |
| 1          |  ❌     |
| 2          |  ❌     |
| 3          |  ❌     |
| 4          |  ❌     |
| 5          |  ❌     |
| 6          |  ✅     |
| 7          |  ❌     |
| 8          |  ❌     |
| 9          |  ❌     |
| 10         |  ❌     |
| 11         |  ❌     |
| 12         |  ✅     |
| 13         |  ❌     |
| 14         |  ✅     |
| 15         |  ❌     |
| 16         |  ✅     |
| 17         |  ❌     |
| 18         |  ❌     |
| 19         |  ✅     |
| 20         |  ❌     |

<hr>

## 🟨 Question 1 🟨
❓ What is the output of the following code? ❓
```java
Path path = Path.get("/user/.././root", "../kodiacbear.txt");
path.normalize().relativize("/lion");
System.out.println(path);
```
* A. `/user/.././root/../kodiacbear.txt`
* B. `/user/./root/kodiacbear.txt/lion`
* C. `/kodiacbear.txt`
* D. `kodiacbear.txt`
* E. `../lion`
* F. The code does not compile


### My answer:
* /user/.././root is equivalent to /root
* so path is `/kodiacbear.txt` when normalised
* I think it is E
* **E**❌❌❌❌
<br>

* CORRECT ANSWER: F - the code does not compile!
* The first line does not compile, it should be `Paths.get()`
* The second line does not compile as relativize takes a path, not a string!
* If there we no compiler errors, the answer would be A because `path` has not been reassigned and thus remains unchanged
* Here is an example of a slightly different program:
```java
Path path = Paths.get("/user/.././root", "../kodiacbear.txtx");
// /user/.././root/../kodiacbear.txt
Path normalised = path.normalized();
// /kodiacbear.txt
Path relativised = normalized.relativized(Paths.get("/lion"));
// ../lion
```
<hr>

## 🟨 Question 2 🟨
❓ For which values of Path inserted on the blank line would it be possible for the following code to output `Success` (Choose all that apply)❓
```java
Path path = ____________;
if(Files.isDirectory(path))
    System.out.println(Files.deleteIfExists(path) ? "Success": "Try Again");
```
* A. `path` refers to a regular file in the file system
* B. `path` refers to a symbolic link in the file system
* C. `path` refers to an empty directory in the file system
* D. `path` refers to a directory with content in the file system
* E. `path` does not refer to a record that exists within the file system
* F. The code does not compile

### My answer:
* I don't believe the code compiles because `Files.deleteIfExists(Path)` has a void return type
* **F**❌❌❌❌
<br>

* The code DOES compile
* A is false, if a regular file existed, the condition would be false
* B is true because it could point to a directory
* C is true, delete only works for empty directory
* E is false, because if the directory does not exist, the condition is false
* **CORRECT ANSWER: B,C**
<hr>


## 🟨 Question 3 🟨
❓ What is the result of the following code (Choose all that apply)  ❓
```java
1: Path path = Paths.get("sloth.schedule");
2: BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
3: if(attributes.size()>0 && attributes.creationTime().toMillis()>0) {
4:     attributes.setTimes(null,null,null);
5: }
```
* A. It compiles and runs without issue
* B. The code will not compile because of line 2
* C. The code will not compile because of line 3
* D. The code will not compile because of line 4
* E. The code compiles but throws an exception at runtime


### My answer:
* I believe the method on line 2 obtains a read only view of the attributes
* I'm not sure what occurs when attempting to set attributes, but I believe it would be fine
* **A** ❌❌❌❌
<br>

* The code does not compile because of line 4
* `.setTimes()` does not exist for BasicFileAttributes class! This method is only visible to BasicFileAttributeView
* **CORRECT ANSWER: D**

<hr>

## 🟨 Question 4 🟨
❓ If the current work directory is `/user/home`, then what is the output of the following code ❓
```java
Path path = Paths.get("/zoo/animals/bear/koala/food.txt");
System.out.println(path.subpath(1,3).getName(1).toAbsolutePath());
```
* A. `animals/bear`
* B. `koala`
* C. `/user/home/bear`
* D. `/user/home/koala/koala`
* E. `/user/home/food.txt`
* F. `/user/home/koala/food.txt`
* G. The code does not compile

### My answer:
* path.subpath(1,3) will start at index 1 and finish at index 2: `/animals/bear`
* getName(1) will return `/animals` i THINK
* I am completely guessing its A
* **A**❌❌❌❌
<br>

* **CORRECT ANSWER: C**
* path.subpath(1,3) returns `animals/bear`
* path.subpath(1,3).getName(1) returns `bear`
* and the absolutePath methhod will return `user/home/bear`
* Here is what occurs when running the code on my pc:
```java
Path path = Paths.get("/zoo/animals/bear/koala/food.txt");
Path subPath = path.subpath(1, 3);
System.out.println(subPath); // animals/bear
Path name = subPath.getName(1);
System.out.println(name.toAbsolutePath());
// C:\Users\Shiv\Documents\GitHub\OCP-Java-Examples\bear	
```
<hr> 


## 🟨 Question 5 🟨
❓ Assuming `/kang` exists as a symbolic link to the directory `/mammal/kangaroo` within the file system. Which of the following statements are correct about thhis code snippet? (Choose all thhat apply)❓
```java
Path path = Paths.get("/kang");
if(Files.isDirectory(path) && Files.isSymbolicLink(path))
    Files.createDirectory(path.resolve("joey"));
```
* A. A new directory will always be created
* B. A new directory will be created only if `/mammal/kangaroo` exists
* C. If the code creates a directory, it will be reachable at `/kang/joey`
* D. If the code creates a directory, it will be reachable at `/mammal/kangaroo/joey`
* E. The code does not compile
* F. The code will compile but always throws an exception at runtime


### My answer:
* Files.isDirectory(path) is true if the symbolic link points to a directory in the file system
* Given that is true, the condition is true, so a directory is created
* A - false, B - true
* Whether C or D is true is what I am unsure of
* D is true I think
* E and F are false
* **B,D**❌❌❌❌
<br>

* My answer was mostly correct, I just did not realise that the directory would be accessible via `/kang/joey`
* **CORRECT ANSWER: B,C,D**
<hr>


## 🟨 Question 6 🟨
❓ Given thhat `/animals` is a directory that exists and it is empty, what is the result of the following code? ❓
```java
Path path = Paths.get("/animals");
boolean myBoolean = Files.walk(path)
    .filter((p,a) -> a.isDirectory() && !path.equals(p)) // w1
    .findFirst().isPresent(); // w2
System.out.println(myBoolean ? "No Sub-directory": "Has Sub-directory");
```
* A. It prints `No Sub-directory`
* B. It prints `Sub-directory`
* C. The code will not compile because of line `w1`
* D. The code will not compile because of line `w2`
* E. The output cannot be determined.
* F. It produces an infinite loop at runtime

### My answer:
* The code does not compile because of line w1. A bi-predicate cannot be applied to a Stream
* **C**✅✅✅✅
<hr>


## 🟨 Question 7 🟨
❓ If the current directory is `\zoo`, and the path `\zoo\turkey` does not exist, then what is the result of executing the following code? (Choose all that apply) ❓
```java
Path path = Paths.get("turkey");
if(Files.isSameFile(path,Paths.get("/zoo/turkey"))) // x1
    Files.createDirectory(path.resolve("info")); // x2
```
* A. The code compiles and runs without issue, but it does not create any directories
* B. The directory `/zoo/turkey` is created
* C. The directory `/zoo/turkey/info` is created
* D. The code will not compile because of line x1
* E. The code will not compile because of line x2
* F. It compiles but throws an exception at runtime


### My answer:
* The only reason why I'd think this would not compile is that IOException is not being handled but the exception might be swallowed else where
* x1 and x2 do compile
* If the current directory is `\zoo` and a relative path is give, then the condition IS true
* So a directory will be created
* C SEEMS right
* **C**❌❌❌❌
<br>

* It compiles but throws an exception at runtime
* `path` is a relative path while `Paths.get("/zoo/turkey")` is absolute
* `isSameFile()` will return true without checking if the files exist, IF they are equal under `equals()`. E.g.:
```java
Path relFakePath1 = Paths.get("path/hello");
Path relFakePath2 = Paths.get("path/hello/");
Files.isSameFile(relFakePath1, relFakePath2); // true

Path relPath1 = Paths.get("path/hello/shiv/..");
Path relPath2 = Paths.get("path/hello");
Files.isSameFile(relPath1, relPath2); // THROWS NoSuchFileException
```
* **The correct answer is F** - the code compiles but throws NoSuchFileException at runtime
<hr>


## 🟨 Question 8 🟨
❓ What is the output of the following code? ❓
```java
Path path1 = Paths.get("/pets/../cat.txt");
Path path2 = Paths.get("./dog.txt");
System.out.println(path1.resolve(path2));
System.out.println(path2.resolve(path1));
```
* A. `/pets/../cat.txt/./dog.txt    /pets/../cat.txt`
* B. `/pets/../cat.txt    ./dogs.txt/pets/../cat.txt`
* C. `/cats.txt    /dog.txt`
* D. `/cats.txt/dog.txt    /cat.txt`
* E. It compiles but throws an exception at runtime

### My answer:
* path2 is a relative path
* So I think an exception is thrown at runtime!
* **E**❌❌❌❌
<br>

* The code compiles fine and there is no exceptions thrown
* So the first path is resolved as: `/pets/../cat.txt/./dog.txt`
* The second path is resolved as `/pets/../cat.txt`
* path2 is a relative path, so it is treated as if it is in the root directory
* **CORRECT ANSWER: A**

<hr>



## 🟨 Question 9 🟨
❓ What are the advantages of using Files.lines() over Files.readAllLines()? (choose all that apply) ❓
* A. It is often faster
* B. It can be run on large files with very little memory available
* C. It can be chained withh stream methods directly
* D. It does not modify the contents of a file
* E. It ensures the file is not read-locked by the file system
* F. There are no differences, because one method is a pointer to the other.

### My answer:
* F is false
* D - false, neither can write to the file
* A - this COULD be true as streams are efficient
* B - true
* C - true
* E - false
* **A,B,C**❌❌❌❌
<br>

* **Correct answer is B,C** 
* A is false because performance concerns are an actual reason to choose ONE method over the other
<hr>

## 🟨 Question 10 🟨
❓ What is correct about the following code snippet? (choose all that apply)❓
```java
File.move(Paths.get("monkey.txt"), Paths.get("/animals"),
    StandardCopyOption.ATOMIC_MOVE,
    LinkOption.NO_FOLLOWLINKS);
```
* A. If `/animals` exists, it will be overwritten at runtime
* B. If `monkey.txt` is a symbolic link, the file it points to will be moved at runtime
* C. If another process is monitoring the file system, it will not see an incomplete file at runtime
* D. The code will always throw an exception, since no filename is specified in the target folder path
* E. The metadata of the `monkey.txt` will be moved along with the file

### My answer:
* A - false, the replace existing option is not specified
* B - true, I THINK
* C - true
* D - false, I THINK
* E - false
* **B,C**❌❌❌❌
<br>

* **CORRECT ANSWER: C,E**
* I was right that processes will never see an incomplete file at runtime
* I was not right that if a symbolic link pointing to a file, that file will be moved, `NO_FOLLOWLINKS` is enabled
* I also incorrectly said metadata would not be followed
* Moving files will ALWAYS copy attributes even without the `COPY_ATTRIBUTES` flag

<hr>

## 🟨 Question 11 🟨
❓ For the `copy()` method shown here, assume that the source exists as regular file and that the target does not. What is the result of the following code? ❓
```java
Path path1 = Paths.get("./goat.txt").normalize(); // k1
Path path2 = Paths.get("mule.png");
Files.copy(path1,path2,StandardCopyOption.COPY_ATTRIBUTES); // k2
System.out.println(Files.isSameFile(path1,path2)); // k3
```

* A. It will output `false`
* B. It will output `true`  
* C. It does not compile because of line k1
* D. It does not compile because of line k2
* E. It does not compile because of line k3
* F. It compiles but throws an exception at runtime


### My answer:
* **F**❌❌❌❌
<br>

* **CORRECT ANSWER: A**
* The code does compile!
* The file is copied
* But line k3 is checking if the paths point to the same file, not that they have the same content!!
* I ran the following code and got the same result:
```java
Path path1 = Paths.get("src/./goat.txt");
Path path2 = paths.get("src/mule.png");
Files.copy(path1,path2,StandardCopyOption.COPY_ATTRIBUTES);
// The file was copied!
File.isSameFile(path1,path2);
```
<hr>


## 🟨 Question 12 🟨
❓ Which of the following methods *cannot* be used to obtain a Path instance? (Choose all that apply) ❓
* A. `new Path("jaguar.txt")`
* B. `FileSystems.getDefault().getPath("puma.txt")`
* C. `Paths.get(new URI("cheetah.txt"))`
* D. `Paths.get("cats","lynx.txt")`
* E. `new java.io.File("tiger.txt").toPath()`
* F. `new FileSystem().getPath("leopard")`
* G. `Paths.getPath("ocelot.txt")`

### My answer:
* A - invalid, paths are obtained via factory - TRUE
* B - valid I THINK - FALSE
* C - syntax valid, but unsure if it actually workds - FALSE
* D - valid - FALSE
* E - valid - FALSE
* F - invalid I THINK - TRUE
* G - invalid - TRUE
* **A,F,G**✅✅✅✅
<br>

* Option G in the book has a typo, I checked the code myself and can see that it does not compile!!!!
<hr>


## 🟨 Question 13 🟨
❓ Assume `/monkeys` exist as a regular directory containing multiple files, symbolic links, and subdirectories. What is true about the following code? (Choose all that apply) ❓
```java
Path path = Paths.get("/monkeys");
Files.find(path, 0, (p,a) -> a.isSymbolicLink()).map(p -> p.toString()) // y1
    .collect(Collectors.toList())  // y2
    .stream()  // y3
    .filter(x -> x.toString().endsWith(".txt")) // y4
    .forEach(System.out::println);
```
* A. It will print all symbolic links in the directory tree ending in `.txt`
* B. It will print nothing
* C. It does not compile because of line `y1`
* D. It does not compile because of line `y2`
* E. It does not compile because of line `y3`
* F. It does not compile because of line `y4`
* G. It compiles but throws an exception at runtime

### My answer:
* Line y1 DOES compile!
* Line y2 DOES compile
* Line y3 DOES compile
* Line y4 DOES compile
* A - true
* **A**❌❌❌❌
<br>

* **CORRECT ANSWER: B**
* I was correct that the code does compile.
* However, nothing is printed because a depth of 0 is specified, meaning the only path traversed is the top level `/monkeys` directory
* Here is an example in which java files are printed within a directory:
```java
Path path 
    = Paths.get("src/chapter_9/c_9_4_new_stream_methods/java");
Files.find(path, 1, (p,a) -> true) // prints nothing if 0
    .map(p -> p.toString())
    .collect(Collectors.toList())
    .stream()
    .filter(x -> x.toString().endsWith(".java"))
    .forEach(System.out::println);
/* prints:
src\chapter_9\c_9_4_new_stream_methods...
...
*/
```
<hr>


## 🟨 Question 14 🟨
❓ Which NIO.2 method is most similar to the legacy `java.io.File.listFiles()` method? ❓
* A. `Path.listFiles()`
* B. `Files.walk()`
* C. `Files.find()`
* D. `Files.files()`
* E. `Files.list()`
* F. `Files.lines()`

### My answer:
* **E**✅✅✅✅
<hr>


## 🟨 Question 15 🟨
❓ What are some advantages of using NIO.2 views to read metadata rather than individually from `java.nio.Files` methods? (Choose all that apply) ❓
* A. It can be used on both files and directories
* B. For reading a single attribute, it is often more performant
* C. It allows you to read symbolic links
* D. It makes fewer rount-trips to the file system
* E. It can be used to access file system-dependent attributes
* F. For reading multiple attributes, it is often more performant

### My answer:
* A - false
* B - false
* C - false, I THINK
* D - true, it CAN take less round trips
* E - false, can only collect attributes which are used across sytems
* F - true
* **D,F**❌❌❌❌
<br>

* CORRECT ANSWER: **D,E,F**
* I was correct that symbolic links are not relevant
* I was correct that less trips are needed to the file system
* And that it is more performant for multiple attributes
* But I completely forgot that you can use views to get file-system specific attributes

<hr>


## 🟨 Question 16 🟨
❓ Assuming `/squid/food-schedule.csv` exists as a regular non-empty file that a program has access to read, what is correct about the following code snippet (Choose all that apply) ❓
```java
Path path = Paths.get("/squid/food-schedule.csv");
Files.lines(path) // r1
    .flatMap(p -> Stream.of(p.split(","))) // r2
    .map(s -> s.toUpperCase()) // r3
    .forEach(System.out::println);
```
* A. It compiles but may throw an exception at runtime
* B. The code will not compile because of line `r1`
* C. The code will not compile because of line `r2`
* D. The code will not compile because of line `r3`
* E. It may not print anything at runtime
* F. If it prints anything, it will not include commas.

### My answer:
* Files.lines(path) returns `Stream<String>`
* `.flatMap(p -> Stream.of(p.split(",")))` will be a `Stream<String>` with the elements being the values between commas
* The code does compile
* E - false, as the file is non-empty
* F - true
* **F**✅✅✅✅
<hr>


## 🟨 Question 17 🟨
❓ Assuming the current directory is `/animals/cute`, which are possible results of executing the following code? (Choose all that apply)❓
```java
Files.walk(Paths.get("..").toRealPath().getParent()) // u1
    .map(p -> p.toAbsolutePath().toString()) // u2
    .filter(s -> s.endsWith(".java")) // u3
    .collect(Collectors.toList())
    .forEach(System.out::println);
```
* A. It compiles but may throw an exception at runtime 
* B. The code will not compile because of line u1
* C. The code will not compile because of line u2
* D. The code will not compile because of line u3
* E. It prints all `.java` files in the `/animals` directory tree
* F. It prints all `.java` files in the `/animals/cute` directory tree
* G. It prints all `.java` files in the root directory tree

### My answer:
* Line u1 will walk the path of `/`, I do not know the depth
* I think it will print files within `/animals`
* **E**❌❌❌❌
<br>

* The current directory is `/animals/cute`
* We are walking the root `\` directory
* It will print all `.java` files in the root directory
* The `walk()` method will traverse all paths of the given path!
* Also theres a chance there is a file which can not be accessed, leading to an exception at runtime
* **CORRECT ANSWER: A,G**

<hr>


## 🟨 Question 18 🟨
❓ Assuming the directories and files referenced here all exist and are accessible within the file system, what is the result of the following code? ❓
```java
Path path1 = Paths.get("/lizard/./").resolve(Paths.get("walking.txt"));
Path path2 = Paths.get("/lizard/././actions/../walking.txt").toPath();

System.out.print(Files.isSameFile(path1,path2));
System.out.print(" "+path1.equals(path2));
System.out.print(" "+path1.normalize().equals(path2.normalize()));
```
* A. `true true true`
* B. `false false false`
* C. `false true false`
* D. `true false true`
* E. `true false false`
* F. The code does not compile 

### My answer:
* path1 = /lizard/../walking
* path2 = /lizard/actions/../walking
* false is printed first
* then false
* So Its B
* **B**❌❌❌❌
<br>

* **CORRECT ANSWER: D**
* path1 and path2 point to the same path
* So true is printed first
* Path.equals() does not evaluate the filesystem, so false is printed
* The normalized paths will be the same:
```java
Path path1 = Paths.get("/lizard/./").resolve(Paths.get("walking.txt"));
System.out.println(path1); 
// /lizard/./walking.txt
Path path2 = Paths.get("/lizard/././actions/../walking.txt");
System.out.println(path2);
// /lizard/././actions/../walking.txt
path1.equals(path2); // false

Path normalized1 = path1.normalize();
// lizard/walking.txt
Path normalized2 = path2.normalize();
normalized1.equals(normalized2); // true

```
<hr>


## 🟨 Question 19 🟨
❓ What are three advantages of the NIO.2 API over legacy `java.io.File` class fore working with files ❓
* A. NIO.2 supports file system-dependent attributes
* B. NIO.2 can be used to list all the files within a single directory
* C. NIO.2 allows you to traverse a directory tree directly
* D. NIO.2 can be used to delete files and non-empty directories
* E. NIO.2 supports symbolic links
* F. NIO.2 can be used to read the last-modified time


### My answer:
* A - maybe
* B - false, file can do this
* C - true
* D - false, file can do this too
* E - true
* F - false, file can do this too
* **A,C,E**✅✅✅✅
<hr>


## 🟨 Question 20 🟨
❓ Assuming the current directory is `/seals/harp/food`, what is the result of executing the following code? ❓
```java
final Path path = Paths.get(".").normalize(); // h1
int count = 0;
for (int i=0; i<path.getNameCount(); ++i) {
    count++;
}
System.out.println(count);
```
* A. 0
* B. 1
* C. 2
* D. 3
* E. 4
* F. The code throws a runtime exception because of line `h1`

### My answer:
* h1 is fine
* there are 3 paths, but you have to include the root!
* **E**❌❌❌❌
<br>

* The normalized path is `.`
* The name count is 1, for the root
* **CORRECT ANSWER: B**
<hr>

