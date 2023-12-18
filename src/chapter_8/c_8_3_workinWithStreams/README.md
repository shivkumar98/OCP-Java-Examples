<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 8.3 Working with Streams

<hr>

## 🟥 8.3.1 The FileInputStream and FileOutputStream Classes
* The FileInputStream and FileOutputStream are used to read/write bytes to a file
* The classes have constructors which accept either a File or String which points to location of file
* E.g.:
```java
String location = System.getProperty("user.dir")+"\\src"+ "\\chapter_8\\c_8_3_workinWithStreams\\javaCode\\data.txt";
try (InputStream in = new FileInputStream(location)) {
  int b;
  while((b=in.read())!=-1) {
    System.out.print(b);
  }
}
// prints TIGERS
```
* The `FileOutStream` object is accessed via writing successive bytes using `write(int)`, here is an example of writing `TIGER` to a new file:
```java
String destination = System.getProperty("user.dir")+"\\src"+
	"\\chapter_8\\c_8_3_workinWithStreams\\javaCode\\output.txt";
try (FileOutputStream out = new FileOutputStream()) {
  char[] chars = new char[] {'t', 'i', 'g', 'e', 'r', 's'};
  for(char c: chars) {
    out.write(c);
  }
}
```
* Running the above code will create a new file with text of `tigers` inside!

### 🟡 The BufferedInputStream and BufferedOutputStream Classes
* We can wrap the `FileInputStream` and `FileOutputStream` classes with `BufferedInputStream` and `BufferedOutputStream`
* The `BufferedInputStream` class has a `read(byte[])` method which reutnrs the number of bytes read into the argument array.
* If the return is 0, then we are at the end of file.

```java
public class WorkingWithBufferedInputStream {
  static void copy(File source, File destination) throws IOException {
    try (InputStream in = new BufferedInputStream(new FileInputStream(source));
        OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
          byte[] buffer = new byte[1024];
          int lengthRead;
          while((lengthRead = in.read(buffer)) > 0) {
            System.out.println(lengthRead);
            out.write(buffer,0,lengthRead); 
            out.flush();
          }
        }
  }
  public static void main(String[] args) throws IOException {
    String source = System.getProperty("user.dir")+"\\src"+
				"\\chapter_8\\c_8_3_workinWithStreams\\javaCode\\data.txt";
		String destination = System.getProperty("user.dir")+"\\src"+
				"\\chapter_8\\c_8_3_workinWithStreams\\javaCode\\Returned-data.txt";
		File sourceFile = new File(source); // this file contains the alphabet!
    Fille destinationFile = new File(destination); 
    copy(sourceFile, destinationFile);
    // prints 27 - the length of the source file
    // the data is copied to the destination file
  }
}
```

<hr>

## 🟥 8.3.2 The FileReader and FilerWriter Classes

### 🟡 H3

<hr>

## 🟥 8.3.3 The ObjectInputStream and ObjectOutputStream Classes

<hr>

## 🟥 8.3.4 The PrintStream and PrintWriter Classes

<hr>

## 🟥 8.3.5 Review of Stream Classes



