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
❓

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
❓

### My answer:
* I don't believe the code compiles because `Files.deleteIfExists(Path)` has a void return type
* **F**
<hr>


## 🟨 Question 3 🟨
❓ What is the result of the following code (Choose all that apply)  ❓

```java
1: Path path = Paths.get("sloth.schedule")l
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
❓

### My answer:
* I believe the method on line 2 obtains a read only view of the attributes
* I'm not sure what occurs when attempting to set attributes, but I believe it would be fine
* **A** 
<hr>


## 🟨 Question 4 🟨
❓ Which of the following can fill in the blank to make the code compile? (Choose all that apply) ❓

```java
Console c = System.console();
String s = _________________;
```

A. `c.input()` <br>
B. `c.read()` <br>
C. `c.readLine()` <br>
D. `c.readPassword()` <br>
E. `c.readString()` <br>
F. None of the above <br>
❓

### My answer:
* A - false
* B - false, this returns byte data
* C - true
* D - false, returns `char[]`
* E - false
* F - false
* **C**✅✅✅✅✅
<hr> 


## 🟨 Question 5 🟨
❓ What is the result of executing the following code? (Choose all that apply) ❓

```java
String line;
Console c = System.console();
Writer w = c.writer();
if ((line = c.readLine()) != null)
    w.append(line);
w.flush();
```

A. The code runs without error but prints nothing <br>
B. The code prints what was entered by the user <br>
C. An ArrayIndexOutOfBoundsException might be thrown <br>
D. A NullPointerException might be thrown <br>
E. An IOException might be thrown <br>
F. The code does not compile <br>
❓

### My answer:
* I'm not entirely sure if this compiles or not
* A - false
* B - false
* C - false, I don't think this is possible
* D - higly likely as `line` is not initialised
* E - false
* F - false
* **D**❌❌❌❌❌

<br>

* CORRECT ANSWER: **B,D,E**
* B is true! This will indeed take input from user and print it to the console
* D is true because console could be nudd
* E is true as the append() method throws an IOException


<hr>


## 🟨 Question 6 🟨
❓ Which of the following are true statements about serialisation in Java (Choose all that apply) ❓
A. The process of converting serialised data back into memory is called deserialization <br>
B. All non-thread classes should be marked `Serializable` <br>
C. The `Serializable` interface requires implementing `serialize()` and `deserialize()` methods <br>
D. The `Serializable` interface is marked final and cannot be extended <br>
E. The `readObject()` method of `ObjectInputStream` may throw a `ClassNotFoundException` even if the return object is not explicitly cast <br>
❓

### My answer:
* A - true
* B - false
* C - false, the interface has zero methods
* D - false
* E - true
* **A,E**✅✅✅✅✅
* E is true as the exception can be thrown by `readObject()` regardless of whether there is casting"
<hr>


## 🟨 Question 7 🟨
❓ Fill in the blank: _________ is the topmost directory on a file system ❓

A. Absolute <br>
B. Directory <br>
C. Parent <br>
D. Root <br>
E. Top <br>
❓

### My answer:
* **D**✅✅✅✅✅
<hr>


## 🟨 Question 8 🟨
❓ Assuming / is the root directory, which of the following are true statements? (Choose all that apply) ❓

A. `/home/parrot` is an absolute path <br>
B. `/home/parrot` is a directory <br>
C. `/home/parrot` is a relative path <br>
D. The path pointed to froma `File` object must exist <br>
E. The parent of the path pointed to by a File object must exist <br>
❓

### My answer:
* A - true
* B - true
* C - false. I think...
* D - false
* E - false, I think...
* **A,B**❌❌❌❌

<br>

* CORRECT ANSWER: **A**
* It could be EITHER a directory or a file without an extension
<hr>



## 🟨 Question 9 🟨
❓ What are the requirements for a class that you want to serialize with `ObjectOutputStream` (choose all that apply) ❓
A. The class must implement the `Serializable` interface <br>
B. The class must extend the `Serializable` class <br>
C. The class must declare a static `serialVersionUID` variable <br>
D. All instance members of the class must be `Serializable` <br>
E. All instance members of the class must be marked `transient` <br>
F. Any class can be serialized with `ObjectOutputStream` <br>
❓

### My answer:
* A - true!
* B - false! Serializable is an interface!
* C - false! but considered good practice
* D - false, not even possible
* E - false, not a requirement
* F - false! only those which implement the interface
* **A**✅✅✅✅
<hr>


## 🟨 Question 10 🟨
❓ The following method is designed to delete a directory tree recursively. Which of the following properties reflect the method definition (choose all that apply)❓
```java
1: public static void deleteTree(File file) {
2:     if(!file.isFile())
3:         for(File entry: file.listFiles())
4:             deleteTree(entry);
5:     else file.delete();
6: }
```

A. It can delete a directory that contains only files <br>
B. It can delete a directory tree of arbritary length <br>
C. It can delete a single file <br>
D. The code will not compile because of line 2 <br>
E. The code will not compile because of line 3 <br>
F. It compiles but may throw an exception at runtime <br>
❓

### My answer:
* I think the code does compile! So that makes D and E false
* A - I think this method can delete files within a directory, so true!
* B - I'm not sure it can delete a directory tree, so false!
* C - true
* F - false
* **A,C**❌❌❌❌❌
<br>

* CORRECT ANSWER: **C,F**
* F is true as methods from the `File` class can throw exceptions such as a directory not existing!
<hr>


## 🟨 Question 11 🟨
❓ Which of the following are methods available to instances of the `java.io.File` class? (Choose all that apply) ❓

A. `mv()` <br>
B. `createDirectory()` <br>
C. `mkdirs()` <br>
D. `move()` <br>
E. `renameTo()` <br>
F. `copy()` <br>
G. `mkdir()` <br>
❓

### My answer:
* A - possible
* B - false
* C - true
* D - possible
* E - true
* F - true
* G - true
* **A,C,E,F,G**❌❌❌❌
<br>

* CORRECT ANSWER: **C,E,G**
* The methods available are `mkdir()`/`mkdirs()`/`renameTo()`
* There is no move type method, you need to use the renameTo() method

<hr>


## 🟨 Question 12 🟨
❓ Suppose that the file `c:/book/java` exists. Which of the following lines of code creates an object that represents the file? (Choose all that apply) ❓

A. `new File("c:\book\java");` <br>
B. `new File("c:\\book\\java");` <br>
C. `new File("c:/book/java");` <br>
D. `new File("c://book//java");` <br>
E. None of the above <br>
❓

### My answer:
* A - false, uses incorrect seperator
* B - false
* C - true, forward slashes do not need to be escaped
* D - false
* E - false
* **C**❌❌❌❌
<br>

* CORRECT ANSWER: **B,C**
* I disagree with this answer but oh well
<hr>


## 🟨 Question 13 🟨
❓ Which of the following are built-in streams in Java (Choose all that apply) ❓

A. `System.err` <br>
B. `System.error` <br>
C. `System.in` <br>
D. `System.input` <br>
E. `System.out` <br>
F. `System.ouput` <br>
❓

### My answer:
* A - true
* B - false, this does not exist
* C - true
* D - false, does not exist
* E - true
* F - false, does not exist
* **A,C,E**✅✅✅✅
<hr>


## 🟨 Question 14 🟨
❓ Which of the following are not java.io classes? (Choose all that apply) ❓

A. `BufferedReader` <br>
B. `BufferedWriter` <br>
C. `FileReader` <br>
D. `FileWriter` <br>
E. `PrintReader` <br>
F. `PrintWriter` <br>
❓

### My answer:
* E - true, PrintReader is not a thing✅✅✅✅✅
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