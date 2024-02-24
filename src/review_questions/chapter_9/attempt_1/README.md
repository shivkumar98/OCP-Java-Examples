<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 9: Review Questions - Attempt 1

## Results:

Date: <br>
Score: <br>
❌
✅
| Question # | Correct |
| ---------- | ------- |
| 1          |       |
| 2          |       |
| 3          |       |
| 4          |       |
| 5          |       |
| 6          |       |
| 7          |       |
| 8          |       |
| 9          |       |
| 10         |       |
| 11         |       |
| 12         |       |
| 13         |       |
| 14         |       |
| 15         |       |
| 16         |       |
| 17         |       |
| 18         |       |
| 19         |       |
| 20         |       |

<hr>

## 🟨 Question 1 🟨
❓ What is the output of the following code? ❓
```java
Path path = Paths.get("/user/.././root", "../kodiacbear.txt");
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
* **E**

<br>

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
* C. `path` regers to an empty directory in the file system
* D. `path` refers to a directory with content in the file system
* E. `path` does not refer to a record that exists within the file system
* F. The code does not compile

### My answer:
* I don't believe the code compiles because `Files.deleteIfExists(Path)` has a void return type
* **F**
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
* **A** 
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
* **A**
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
* **B,D**
<br>

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
* **C**
<hr>


## 🟨 Question 7 🟨
❓ In the current directory is `\zoo`, and the path `\zoo\turkey` does not exist, then what is the result of executing the following code? (Choose all that apply) ❓
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
* The only reason why I'd think this would not compile is that IOException is not being handled but the exception might be swallowed else where
* x1 and x2 do compil
* If the current directory is `\zoo` and a relative path is give, then the condition IS true
* So a directory will be created
* C SEEMS right
* **C**
<hr>


## 🟨 Question 8 🟨
❓ What is the output of the following code? ❓
```java
Path path1 = Paths.get("/pets/../cat.txt");
Path path2 = Paths.get(".dog.txt");
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
* **E**
<br>

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
* **A,B,C**
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
* **B,C**
<br>

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
* **F**
<br>

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
* **A,F,G**
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
* Line y1 DOES compile!
* Line y2 DOES compile
* Line y3 DOES compile
* Line y4 DOES compile
* A - true
* **A**
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
* **E**
<hr>


## 🟨 Question 15 🟨
❓ Assuming `zoo-data.txt` is a multiline text file, what is true of the following method? ❓
```java
private void echo() throws IOException {
    try (FileReader fileReader = new FileReader("zoo-data.txt");
      BufferedReader bufderedReader = new BufferedReader(fileReader)) {
        System.out.println(bufferedReader.readLine());
      }
}
```


A. It prints the first line of the file to the console <br>
B. It prints the entire contents of the file <br>
C. The code does not compile because the reader is not closed <br>
D. The code does compile, but the reader is not closed <br>
E. The code does not compile for another reason <br>
❓

### My answer:
* I believe the code does compile, because the method correctly throws an `IOException`
* A - true
* D - true
* **A,D**❌❌❌❌
<br>

* CORRECT ANSWER: **A**
* The try-with-resources block will automatically close resources.
<hr>


## 🟨 Question 16 🟨
❓ Why shouldn't every class be marked Serializable (Choose all that apply) ❓

A. The compiler will throw an excepiton if certain classes are marked `Serializable` <br>
B. Only final classes can be marked `Serializable` <br>
C. Classes can implement only one interface, so marking them `Serializable` would prevent them from using any other interface <br>
D. The data of some classes cannot be easily serialized, such as those managing threads or processes <br>
E. Only concrete classes can be marked `Serializable` <br>
F. Classes that store most of their data in static fields would not be easily serializable <br>
❓

### My answer:
* A - false, this is just an interface with no methods
* B - false
* C - false, multiple interface implementation is a thing
* D - true
* E - false
* F - true, static variables are not easily serialized!
* **D,F**✅✅✅✅✅
<hr>


## 🟨 Question 17 🟨
❓ Which of the following stream classes are high-level? (Choose all that apply) ❓

A. `ObjectInputStream` <br>
B. `PrintStream` <br>
C. `FileWriter` <br>
D. `PrintWriter` <br>
E. `OutputStream` <br>
F. `FileInputStream` <br>
G. `ObjectOutputStream` <br>
❓

### My answer:
* A - true
* D - true
* **A,D**❌❌❌❌
<br>

* CORRECT ANSWER: **A,B,D,G**
* ObjectInputStream and ObjectOutputStream are high level streams
* PrintStream and PrintWriter are also high level streams which operate on files directly


<hr>


## 🟨 Question 18 🟨
❓ Which values when inserted into the blank would allow the code to compile? (Choose all that apply) ❓

```java
1: Console console = System.console();
2: String color = console.readLine("What is your favorite color? ");
3: Console.____________("Your favorite color is "+color);
```

A. `print` <br>
B. `printf` <br>
C. `println` <br>
D. `format` <br>
E. `writer().println` <br>
F. `out` <br>
❓

### My answer:
* A - true
* B - false
* C - true
* D - true
* E - true
* F - false
* **A,C,D,E**❌❌❌❌❌
<br>

* CORRECT ANSWER: **B,D,E**
* The console has two output methods: `format` and `printf`
* You can also obtain the `PrintWriter` using `.writer` and then printing using `println`
<hr>


## 🟨 Question 19 🟨
❓ Suppose that you need to write data consists of int, double, boolean, and String values to a file that maintains the format of the original data. For performance reasons, you also want to buffer the data. Which three `java.io` classes can be chained together to best achieve this result? ❓

A. `FileWriter` <br>
B. `FileOutputStream` <br>
C. `BufferedOutputStream` <br>
D. `ObjectOutputStream` <br>
E. `DirectoryStream` <br>
F. `PrintWriter` <br>
G. `PipedOutputStream` <br>
❓

### My answer:
* **B,C,D**✅✅✅✅

* Since I need to write primitives and String values, only OutputStream classes are appropiate.
* Data should be written to file using `FileOutputStream`, buffered using `BufferedOutputStream`, and serialized with `ObjectOutputStream`
<hr>


## 🟨 Question 20 🟨
❓ What are some reasons to use a character stream, such as `Reader`/`Writer`, over a byte stream, such as `InputStream`/`OutputStream` (Choose all that apply) ❓

A. More convient code syntax when working with String data <br>
B. Improved performance <br>
C. Automatic character encoding <br>
D. Built-in serialization and deserialization <br>
E. Character streams are high-level streams <br>
F. Multi-threading support <br>
❓

### My answer:
* A - true
* B - true, possibly
* C - true
* D - false
* E - true
* F - false
* **A,B,C,E**❌❌❌❌
<br>

* CORRECT ANSWER: **A,C**
* Character streams offer convience and not improvement in performance
* They also automatically handle encoding
* They do not have built in serialization nor are considered as high level
<hr>


## 🟨 Question 21 🟨
❓ Assuming the following class has proper public getter/setter methods for all of its private fields, which of the following fields will always be null after an instance of the class is serialized and then deserialized (Choose all that apply) ❓

```java
public class Zebra implements Serializable {
    private static final long serialUID = 1L;
    private transient String name = "George";
    private static String birthPlace = "Africa";
    private transient Integer age;
    private java.util.List<Zebra> friends = new java.util.ArrayList<>();
    private Object tail = null;
    { age = 10; }
    public Zebra() {
        this.name = "Sophia";
    }
}
```

A. `name` <br>
B. `tail` <br>
C. `age` <br>
D. `friends` <br>
E. `birthPlace` <br>
F. The code does not compile <br>
G. The code compiles but throws an exception at runtime <br>
❓

### My answer:
* A - false, this is initialised in the constructor
* B - true
* C - true, this is marked transient
* D - false, this is initalised 
* E - false, this is initialised
* F - false
* G - false
* **B,C**❌❌❌❌❌
<br>

* CORRECT ANSWER: **A,C**
* Upon deserialization, constructors and initializers are skipped
<hr>

## 🟨 Question 22 🟨
❓ What is the value of `name` after an instance of Eaglle is serialized and deserialized? ❓

```java
public class Bird implements Serializable {
    protected transient String name = "Bridget";
    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
    public Bird() {
        this.name = "Matt";
    }
}
public class Eagle extends Bird implements Serializable {
    { this.name = "Janette"; }
    public Eagle() {
        this.name = "Daniel";
    }
}
```

A. `Bridget` <br>
B. `Matt` <br>
C. `Janette` <br>
D. `Daniel` <br>
E. `null` <br>
F. The code does not compile <br>
G. The code compiles but throws an exception at runtime <br>
H. The value may not be known until runtime <br>
❓

### My answer:
* **B**❌❌❌❌
<br>

* CORRECT ANSWER: **E**
* The name is transient, meaning its skipped when serialized and deserialized
<hr>

## 🟨 Question 23 🟨
❓ Assume that you have an `InputSream` whose next bytes are `XYZABC`. What is the result of calling the following method on the stream, using a `count` value of 3 ❓

```java
public static String pullBytes(InputStream is, int count) throws IOException {
    is.mark(count);
    final StringBuilder sb = new StringBuilder();
    for(int i=0;i<count;i++)
        sb.append((char)is.read());
    is.reset();
    is.skip(1);
    sb.append((char)is.read());
    return sb.toString();
}
```

A. It will return a String value of `XYZ` <br>
B. It will return a String value of `XYZA` <br>
C. It will return a String value of `XYZX` <br>
D. It will return a String value of `XYZB` <br>
E. It will return a String value of `XYZY` <br>
F. The code does not compile <br>
G. The code compiles but throws an exception at runtime <br>
H. The result cannot be determined with the information given <br>
❓

### My answer:
* it marks 3 bytes ahead
* It then appends `XYZ`
* It then resets
* `X` is skipped
* `Y` is appended
* **E**❌❌❌❌❌
<br>

* CORRECT ANSWEER: H
* The code did not check if the stream supports mark.
* If it did, then the answer would indeed be E