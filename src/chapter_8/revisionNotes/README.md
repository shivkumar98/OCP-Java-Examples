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


<br><hr>

# 🧠 8.2 Introducing Streams

## 🟥 8.2.1 Stream Fundamentals
* The contents of a file can be accessed or written via a Stream - a list of data elements presented sequentially

<br>

## 🟥 8.2.2 Stream Nomenclature

### 🟡 Byte Streams vs Character Streams
* The `java.io` API has two sets of classes:
1) Stream classes with `Reader`/`Writer` in their name are used for inputting/outputting CHARACTER and STRING data
2) Stream classes with `Stream` in their name are used for inputting/outputting BINARY or BYTE data

<br>

* MOST `Input` stream classes have a CORRESPONDING `Output` stream class💡
* MOST `Writer` classes have a CORRESPONDING `Reader` class💡 

### 🟡 Low Level vs High Level Streams
* Low level streams connects directly with the source of the data. E.g. `FileInputStream`
* High level streams is built on top of another stream using wrapping. E.g. BufferecReader is a high level stream:
```java
try (BufferedReader bufferedReader = new BufferedReader(
                                        new FileReader("zoo-data.txt"))) {
    System.out.println(bufferedReader.readLine());
}
```

### 🟡 Stream Base Classes

* The `java.io` library defines four abstract classes:
1) `InputStream`
2) `OutputStream`
3) `Reader`
4) `Writer`

* The constructor of HIGH-LEVEL streams take a reference of the abstract class which they implement. E.g.:
```java
BufferedInputStream bs = new BufferedInputStream();
new BufferedInputStream(bs); // perfectly fine to re-wrap
new BufferedInputStream(new FileInputStream("zoo.txt")); // wrapping a low level stream
// You can NOT wrap a high level stream in a low level stream:
new FileInputStream(bs); // COMPILER ERROR
```

### 🟡 Decoding Java I/O Class Names
* Rules:
1) A class containing `InputStream`/`OutputStream` in its name is used for reading/writing binary data
2) A class with the word `Reader`/`Writer` in its name is used for reading/writing character/string data
3) A class with `Buffered` in its name reads/writes data in groups of bytes which often improves performance

### 🟡 The `java.io` Stream Classes
| Class Name    | Low/High Level | Description                                              |
| ------------- | -------------- | -------------------------------------------------------- |
| InputStream   | N/A            | Abstract class                                           |
| OutputStream  | N/A            | Abstract class                                           |
| Reader        | N/A            | Abstract class                                           |
| Writer        | N/A            | Abstract class                                           |
| FileInputStream | Low          | Used for reading file data as bytes                      |
| FileOutputStream | Low         | Used for writing file data as bytes                      |
| FileReader    | Low            | Reads file data as characters                            |
| FileWriter    | Low            | Writes file data as character                            |
| BufferedReader | High          | Reads character data from existing Reader                |
| BufferedWriter | High          | Writes character data from existing Writer              |
| ObjectInputStream | High       | Deserializes primitive data type and objects from existing InputStream |
| ObjectOutputStream | High      | Serializes primitive data and objects from existing OutputStream |
| InputStreamReader | High | Reads character data from existing InputStream                 |
| OutputStreamWriter | High | Writes character data from existing OutputStream |
| PrintWriter           | High   | Writes formatted representations of Java objects to a text-based output stream |

<br>

## 🟥 8.2.3 Common Stream Operations
* A resource can be closed automatically using try-with-resources or manually closed using the `.close()` method

<br>

* The `InputStream` and `Reader` classes include `mark(int)` and `reset()` methods which enable you to go back to an earlier position of the stream
* You should only call `mark(int)` if `markSupported()` returns true. Calling `mark(int i)` will create a lookahead buffer with size i
* You call `reset()` so you go back to the stream where `mark(int)` was invoked

<br>

* The InputStream and Reader classes also have a `skip(int)` method

<br><hr>

# 🧠 8.3 Working with Streams

## 🟥 8.3.1 The FileInputStream and FileOutputStream Classes
* We can instantiate these classes by either passing in a File instance, or a String pointing to the location of the file
* We use the `int read()` method to read from the `FileInputStream`
* We use the `void write(int)` method writes to the `FileOutputStream`
<br>

* Here is the program which appends `a` to a `text.txt` file:
```java
public static void main(String[] args) throws IOException {
    String location = System.getProperty("user.dir")
        + "\\src" + "\\chapter_8" + 
        "\\c_8_4_interactingWithUsers\\javaCode\\text.txt";
    FileOutputStream fos = new FileOutputStream(location);
    fos.write('a'); // writes 'a' to the file as an int
    FileInputStream fis = new FileInputStream(location);
    System.out.println("fis.read(): "+(char)fis.read()); // prints a
    System.out.println(fis.read()); // continues to return -1 
}
```

### 🟡 The BufferedInputStream and BufferedOutputStream
* You can wrap the `FileInputStream` and `FileOutputStream` classes using these buffered wrappers.
* Here's the previous program rewritten with buffered classes:
```java
public static void main(String[] args) throws IOException {
    String location = System.getProperty("user.dir")
        + "\\src" + "\\chapter_8" + 
        "\\c_8_4_interactingWithUsers\\javaCode\\text.txt";

    BufferedInputStream bufferedInputStream
        = new BufferedInputStream(new FileInputStream(location));
    BufferedOutputStream bufferedOutputStream
        = new BufferedOutputStream(new FileOutputStream(location));
    bufferedOutputStream.write('A');
    bufferedOutputStream.flush(); // necessary!
        
    System.out.println((char)bufferedInputStream.read()); // A
    System.out.println(bufferedInputStream.read()); // -1
}
```
* The `flush()` memory is necessary so that data is written to the disk

<br>

## 🟥 8.3.2 The FileReader and FilerWriter Classes
```java
public static void main(String[] args) throws IOException {
    String location = System.getProperty("user.dir")+"\\src"+"\\chapter_8"
            +"\\revisionNotes\\javaCode\\text3.txt";
    try (
    FileWriter fileWriter = new FileWriter(location);
    FileReader fileReader = new FileReader(location)) {
        fileWriter.write("line 1");
        fileWriter.write("\nline 2");
        fileWriter.flush();
        System.out.println((char)fileReader.read()); // l
    }
}
```
* `FileWriter` has a `write(String)` method for writing whole strings to the file

### 🟡 The BufferedReader and BufferedWriter Classes
```java
public static void main(String[] args) throws IOException {
    String location = System.getProperty("user.dir")+"\\src"+"\\chapter_8"
            +"\\revisionNotes\\javaCode\\text4.txt";
    try (
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(location));
    BufferedReader bufferedReader = new BufferedReader(new FileReader(location))) {
        bufferedWriter.write("line 1");
        bufferedWriter.write("\nline 2");
        bufferedWriter.flush();
        System.out.println(bufferedReader.readLine()); // line 1
        System.out.println(bufferedReader.readLine()); // line 2
        System.out.println(bufferedReader.readLine()); // null
    }
} 
```
* The Reader/Writer classes have automatic character encoding

<br>

## 🟥 8.3.3 The ObjectInputStream and ObjectOutputStream Classes
* In order to serialize an object, you MUST implement `Serializable` interface

```java
class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private char type;
    public Animal(String name, int age, char type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }
    public String getName() { return name; }
    public int getAge() { return age; }
    public char getType() { return char; }
    public String toString() {
        return "Animal [name="+name+", age="+age+", type="+type+"]";
    }
}
public class UsingObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String location = System.getProperty("user.dir")+"\\src"+"\\chapter_8"
				+"\\revisionNotes\\javaCode\\Animals-data.log";
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(location));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(location))) {
            List<Animal> animals = Arrays.asList(new Animal("Tiger",2,'m'),
                new Animal("Parrot",1,'b'));
            for(Animal animal:animals)
                objectOutputStream.writeObject(animal);
            System.out.println(objectInputStream.readObject()); // Animal [name=Tiger, age=1, type=m]
			System.out.println(objectInputStream.readObject()); // Animal [name=parrot, age=2, type=b]
			System.out.println(objectInputStream.readObject()); // throws EOF Exception
        }
    }
}
```

### 🟡 Understanding Object Creation
* When Java objects are deserialized, the constructor of the serialized class is NOT calllled!
* Java will call the first nonserializable parent class's constructor.
* This will skip default initializers and static variables
* For transient variables, it will have the default value when deserialised
* For static values, it will just be the last value it was set for the class

<br>

## 🟥 8.3.4 The PrintStream and PrintWriter Classes
* Both the `PrintStream` and `PrintWriter` classes are used to write formatted representation of Java objects to a text-based output stream.
```java
String location = System.getProperty("user.dir")+"\\src"+"\\chapter_8"
				+"\\revisionNotes\\javaCode\\usingPrintWriter.txt";
PrintWriter printWriter = new PrintWriter(location);
Animal animal = new Animal("Tiger",1,'m');
printWriter.print(animal);
printWriter.print("\n line 2");
printWriter.flush();

PrintStream printStream = new PrintStream(location);
printStream.print(animal);
printStream.flush();
```
* Both of these write `Animal [name=Tiger, age=1, type=m]` to the file

<br>

* `System.out` and `System.err` are PrintStream objects
* The `PrintStream` and `PrintWriter` classes have the following methods: `print()`,`println()`, `format()` and `printf()`. These methods do not throw any checked exceptions!
* There is a format() method which is analagous to method in C:
```java
printWriter.format("It is %f degrees today",1/3.0);
// It is 0.333333 degrees today
```
* There is also a `printf()` method which has exact same behaviour as the `format()` method

## 🟥 8.3.5 Review of Stream Classes
* We have the following classes in the `java.io` package:
1) `InputStream`
- FileInputStream
- BufferedInputStream
- ObjectInputStream
2) `OutputStream`
- FileOutputStream
- BufferedOutputStream
- ObjectOutputStream
- PrintStram
3) `Reader`
- InputStreamReader
- FileInputReader
- BufferedReader
- FileReader
4) `Writer`
- OutputStreamWriter
- PrintWriter
- BufferedWriter
- FileWriter

<br><hr>

# 🧠 8.4 Interacting With Users

## 🟥 8.4.1 The Old Way
* Like how System.out returns a PrintStream, System.out returns InputStream to obtain input from user.
* We can use BufferedReader to capture text from the user:
```java
public static void main(String[] args) throws IOException {
try (BufferedReader reader = 
        new BufferedReader(new InputStreamReader(System.in))) {
    System.out.println("enter some text: ");
    String input = reader.readLine();
    System.out.println("You entered: "+input);   
}
```

<br>

## 🟥 8.4.2 The New Way
* The `java.io.Console` can be obtained using `System.console()` via singleton pattern.
* Here is the previous program re-written using Console:
```java
public static void main(String[] args) {
		Console console = System.console();
		if (console!=null) {
			System.out.println("enter some text");
			 String input = console.readLine();
			 console.writer().println("You entered: "+input);
		}
	}
```
* You can obtain an instance of PrintWriter using `console.writer()`. This then gives you access to `printf()`, `format()` and print/println methods!

* The console also has access to a readPassword() method which returns a `char[]` array which can be immediately removed from memory after use and also hides echoing to the console when user is typing