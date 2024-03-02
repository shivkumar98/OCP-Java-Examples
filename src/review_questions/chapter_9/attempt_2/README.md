<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 9: Review Questions - Attempt 2

## Results:

Date: 02/03/2024 <br>
Score: 14/20 (70%) <br>

| Question # | Correct |
| ---------- | ------- |
| 1          |  ❌     |
| 2          |  ✅     |
| 3          |  ✅     |
| 4          |  ✅     |
| 5          |  ❌     |
| 6          |  ✅     |
| 7          |  ✅     |
| 8          |  ❌     |
| 9          |  ✅     |
| 10         |  ❌     |
| 11         |  ❌     |
| 12         |  ✅     |
| 13         |  ✅     |
| 14         |  ✅     |
| 15         |  ✅     |
| 16         |  ✅     |
| 17         |  ❌     |
| 18         |  ✅     |
| 19         |  ✅     |
| 20         |  ✅     |

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
* Path is an absolute path
* `/kodiacbear.txt` is the normalized path
* `../lion` is the relativized path
* However, path has not been re-assigned, so path is just the normal path
* `path` is `/user/.././root/../kodiacbear.txt`
* **A**❌❌❌❌


<br>

* 💡💡**CORRECT ANSWER: F**💡💡
* Path.get() is not correct, should be `Paths.get()`
* The `relativize()` method takes a path not a string!!!
* NOTE: I wrote the question wrong initially!!!
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
* A - false
* B - possible if it points to a directory which is empty
* C - true
* D - false, this will print try again
* E - false
* F - false
* **B,C**✅✅✅
* If `path` was a symbolic link pointing to a directory, the symbolic link would be deleted 💡
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
* `BasicFileAttributes` class does not have a `setTimes()` interface
* Line 3 is fine
* **D**✅✅✅
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
* `path.subpath(1,3)` = `animals/bear`
* `path.subpath(1,3).getName(1)` = `bear`
* As `bear` is an relative path, it is treated as if we are in current directory
* This gets converted, to an absolute path: `/user/home/bear` I THINK
* **C**✅✅✅✅
<hr> 


## 🟨 Question 5 🟨
❓ Assuming `/kang` exists as a symbolic link to the directory `/mammal/kangaroo` within the file system. Which of the following statements are correct about this code snippet? (Choose all that apply)❓
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
* Since `/kanga` does point to an actual directory AND is a symbolic link, the condition is true
* So a directory is created for the symbolic link
* A - false
* B - true
* C - false
* D - true
* E - false
* F - false
* **B,D**❌❌❌❌
<br>

* **💡💡CORRECT ANSWER: B,C,D💡💡**
* I was correct that a directory of `/mammal/kangaroo/joey` would be created
* I forgot it would also be accessible via the symbolic link `/kang/joey`💡
<hr>


## 🟨 Question 6 🟨
❓ Given that `/animals` is a directory that exists and it is empty, what is the result of the following code? ❓
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
* `Files.walk()` returns a `Stream<Path>`
* You can not filter with a BiPredicate, so w1 does not compile
* **C**✅✅✅✅
<hr>


## 🟨 Question 7 🟨
❓ If the current directory is `\zoo`, and the path `\zoo\turkey` does not exist, then what is the result of executing the following code? (Choose all that apply) ❓
```java
Path path = Paths.get("turkey");
if(Files.isSameFile(path,Paths.get("/zoo/turkey"))) // x1
    Files.createDirectory(path.resolve("info")); // x2
```
* A. The code compiles and runs withhout issue, but it does not create any directories
* B. The directory `/zoo/turkey` is created
* C. The directory `/zoo/turkey/info` is created
* D. The code will not compile because of line x1
* E. The code will not compile because of line x2
* F. It compiles but throws an exception at runtime


### My answer:
* `path` is relative, while the argument is absolute
* So `equals()` will return false, and it will check if the files actually exist
* So the code will compile but throw an exception at runtime
* **F**✅✅✅✅

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

<br>

* It will first print: `/pets/../cat.txt/./dog.txt`
* But an exception is then thrown at runtime!!!
* **E**❌❌❌❌
<br>

* 💡💡**CORRECT ANSWER: A**💡💡
* While I was right about what the first result was, I was wrong about `p2.resolve(p1)`
* If an ABSOLUTE PATH is provided to the resolve, THEN THE ARGUMMENT PROVIDED IS RETURNED!!! 💡
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
* Files.readAllLines() returns a `List<String>` this can lead to memory issues if the file is too big
* A - false
* B - true
* C - true
* D - false
* E - false
* F - false
* **B,C**✅✅✅✅
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
* A - false, the overwrite existing option has not been specified
* B - true
* C - true
* D - false
* E - true, metadata is copied by default I THINK
* **B,C,E**❌❌❌❌
<br>

* 💡💡**CORRECT ANSWER: C,E**💡💡
* Since NO_FOLLOWLINKS was provided, the symbolic link itself would be copied at not the file it points to
* I was correct about `REPLACE_EXISTING` not being provided so A is false
* I was also correct that metadata is copied even without the `COPY_ATTRIBUTES` option

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
* **B**❌❌❌❌
<br>

* 💡💡**CORRECT ANSWER: A**💡💡
* Even though the files are an exact copy, they are not the same file!!!
<hr>


## 🟨 Question 12 🟨
❓ Which of the following methods *cannot* be used to obtain a Path instance? (Choose all that apply) ❓
* A. `new Path("jaguar.txt")`
* B. `FileSystems.getDefault().getPath("puma.txt")`
* C. `Paths.get(new URI("cheetah.txt"))`
* D. `Paths.get("cats","lynx.txt")`
* E. `new java.io.File("tiger.txt").toPath()`
* F. `new FileSystem().getPath("leopard")`
* G. `Paths.get("ocelot.txt")` (BOOK HAS TYPO)

### My answer:
* A - true
* B - false
* C - false
* D - false
* E - false
* F - true
* G - false
* **A,F**✅✅✅✅
<br>

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
* It will not print anything!
* **B**✅✅✅✅
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
<br>

<hr>



## 🟨 Question 15 🟨
❓ What are some advantages of using NIO.2 views to read metadata rather than individually from `java.nio.Files` methods? (Choose all that apply) ❓
* A. It can be used on both files and directories
* B. For reading a single attribute, it is often more performant
* C. It allows you to read symbolic links
* D. It makes fewer rount-trips to the file system
* E. It can be used to accss file system-dependent attributes
* F. For reading multiple attributes, it is often more performant

### My answer:
* A - false, we have method in Files which can be used for symbolic links, files, dirs
* B - false, views are less efficient for single attribute
* C - false, see A
* D - true
* E - true
* F - true
* **D,E,F**✅✅✅✅
<br>

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
* A - false
* B - false
* C - false
* D - false
* E - false
* F - true
* **F**✅✅✅✅
<br>

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
* A - false
* No compilation issues
* E - true
* F - true - no maxDepth parameter specified
* G - false
* **E,F**❌❌❌❌
<br>

* The files which would be walked are files in the root directory
* The above code will print all files ending with `.java` from the root directory
* So technically E,F and G are all correct
* An exception could be thrown at runtime such as no permission to read the file
* But **💡💡CORRECT ANSWER: A,G💡💡**

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
* `path1` = `/lizard/./walking.txt`
* `path2` = `/lizard/././actions/../walking.txt`
* the second print is definitely false
* So only B,D,E are possible
* the first print is true
* This third print is going to be true
* **D**✅✅✅✅
<br>

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
* A - possible
* B - false, file can do this
* C - true
* D - false, file can do this
* E - true
* F - false, file can do this
* *A,C,E**✅✅✅✅
<br>

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
* path = `/./`
* path.getNameCount() is 1
* **B**✅✅✅✅
<br>

* The normalize() on the relative path, just returns an empty path. This path has a length of 1:
```java
Path path = Paths.get(".").normalize();
System.out.println(path); // BLANK
System.out.println(path.getNameCount()); // 1
```
<hr>
