<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 8: Review Questions - Attempt #

## Results:

Date:
Score: 
✅  ❌ 
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
| 21         |       |
| 22         |       |

<hr>

## Question 1
❓ Which clases will allow the following to compile (Choose all that apply) ❓

```java
InputStream is = new BufferedInputStream(new FileInputStream("zoo.txt"));
InputStream wrapper = new __________(is);
```

A. `BufferedInputStream` <br>
B. `FileInputStream` <br>
C. `BufferedWriter` <br>
D. `ObjectInputStream` <br>
E. `ObjectOutputStream` <br>
F. `BufferedReader` <br>
❓

### My answer:

<hr>

## Question 2
❓ Why doews `Console.readPassword()` return a `char[]` instead of String object (Choose all that apply)❓

A. It improves performance <br>
B. It is more secure <br>
C. To encrypt the password data <br>
D. To support all character encodings <br>
E. Because Java puts all String values in a reusable pool <br>
F. So that the value can be removed from memory immediately after use <br>
❓

### My answer:

<hr>


## Question 3
❓ Which of the following are true (Choose all that apply)  ❓

A. A new Console object is created every time `System.console()` is called <br>
B. Console can only be used for reading input and not writing output <br>
C. Console is obtained using the singleton pattern <br>
D. When getting a `Console` object, it might be `null` <br>
E. When getting a `Console` object, it willl never be `null`  <br>
❓

### My answer:

<hr>


## Question 4
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

<hr> 


## Question 5
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

<hr>


## Question 6
❓ Which of the following are true statements about serialisation in Java (Choose all that apply) ❓
A. The process of converting serialised data back into memory is called deserialization <br>
B. All non-thread classes should be marked `Serializable` <br>
C. The `Serializable` interface requires implementing `serialize()` and `deserialize()` methods <br>
D. The `Serializable` interface is marked final and cannot be extended <br>
E. The `readObject()` method of `ObjectInputStream` may throw a `ClassNotFoundException` even if the return object is not explicitly cast <br>
❓

### My answer:

<hr>


## Question 7
❓ Fill in the blank: _________ is the topmost directory on a file system ❓

A. Absolute <br>
B. Directory <br>
C. Parent <br>
D. Root <br>
E. Top <br>
❓

### My answer:

<hr>


## Question 8
❓ Assuming / is the root directory, which of the following are true statements? (Choose all that apply) ❓

A. `/home/parrot` is an absolute path <br>
B. `/home/parrot` is a directory <br>
C. `/home/parrot` is a relative path <br>
D. The path pointed to froma `File` object must exist <br>
E. The parent of the path pointed to by a File object must exist <br>
❓

### My answer:

<hr>


## Question 9
❓ What are the requirements for a class that you want to serialize with `ObjectOutputStream` (choose all that apply) ❓
A. The class must implement the `Serializable` interface <br>
B. The class must extend the `Serializable` class <br>
C. The class must declare a static `serialVersionUID` variable <br>
D. All instance members of the class must be `Serializable` <br>
E. All instance members of the class must be marked `transient` <br>
F. Any class can be serialized with `ObjectOutputStream` <br>
❓

### My answer:

<hr>


## Question 10
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
*
<hr>


## Question 11
❓ Which of the following are methods available to instances of the `java.io.File` class? (Choose all that apply) ❓

A. `mv()` <br>
B. `createDirectory()` <br>
C. `mkdirs()` <br>
D. `move()` <br>
E. `renameTo()` <br>
F. `copy()` <br>
F. `mkdir()` <br>
❓

### My answer:

<hr>


## Question 12
❓ Suppose that the file `c:/book/java` exists. Which of the following lines of code creates an object that represents the file? (Choose all that apply) ❓

A. `new File("c:\book\java");` <br>
B. `new File("c:\\book\\java");` <br>
C. `new File("c:/book/java");` <br>
D. `new File("c://book//java");` <br>
E. None of the above <br>
❓

### My answer:

<hr>


## Question 13
❓ Which of the following are built-in streams in Java (Choose all that apply) ❓

A. `System.err` <br>
B. `System.error` <br>
C. `System.in` <br>
D. `System.input` <br>
E. `System.out` <br>
F. `System.ouput` <br>
❓

### My answer:

<hr>


## Question 14
❓ Which of the following are not java.io classes? (Choose all that apply) ❓

A. `BufferedReader` <br>
B. `BufferedWriter` <br>
C. `FileReader` <br>
D. `FileWriter` <br>
E. `PrintReader` <br>
F. `PrintWriter` <br>
❓

### My answer:

<hr>


## Question 15
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

<hr>


## Question 16
❓ Why shouldn't every class be marked Serializable (Choose all that apply) ❓

A. The compiler will throw an excepiton if certain classes are marked `Serializable` <br>
B. Only final classes can be marked `Serializable` <br>
C. Classes can implement only one interface, so marking them `Serializable` would prevent them from using any other interface <br>
D. The data of some classes cannot be easily serialized, such as those managing threads or processes <br>
E. Only concrete classes can be marked `Serializable` <br>
F. Classes that store most of their data in static fields would not be easily serializable <br>
❓

### My answer:

<hr>


## Question 17
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

<hr>


## Question 18
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

<hr>


## Question 19
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

<hr>


## Question 20
❓ What are some reasons to use a character stream, such as `Reader`/`Writer`, over a byte stream, such as `InputStream`/`OutputStream` (Choose all that apply) ❓

A. More convient code syntax when working with String data <br>
B. Improved performance <br>
C. Automatic character encoding <br>
D. Built-in serialization and deserialization <br>
E. Character streams are high-level streams <br>
F. Multi-threading support <br>
❓

### My answer:

<hr>


## Question 21
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

<hr>

## Question 22
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

<hr>

## Question 23
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
