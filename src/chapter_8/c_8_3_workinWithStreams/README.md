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

```

### 🟡 The BufferedInputStream and BufferedOutputStream Classes

<hr>

## 🟥 8.3.2 The FileReader and FilerWriter Classes

### 🟡 H3

<hr>

## 🟥 8.3.3 The ObjectInputStream and ObjectOutputStream Classes

<hr>

## 🟥 8.3.4 The PrintStream and PrintWriter Classes

<hr>

## 🟥 8.3.5 Review of Stream Classes



