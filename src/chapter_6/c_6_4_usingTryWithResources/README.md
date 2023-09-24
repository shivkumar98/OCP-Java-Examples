<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 6.4 Using Try-With-Resources

## 🟥 6.4.1 Introduction

* Multi-catch helps reduce code duplication, however we can still have problems with duplication in `finally` clause.
* A resource is typically a file or database, and should be closed after it is used.
<br>
* Suppose you write a method, which reads first line of one file and write it to another file.
    - Before Java 7, this method would look like:

```java
public void oldApproach(Path p1, Path p2) throws IOException {
    BufferedReader in = null;
    BufferedWriter out = null;
    try {
        in = Files.newBufferedReader(p1);
        out = Files.newBufferedWriter(p2);
        out.write(in.readLine());
    } finally {
        if (in != null) in.close();
        if (out !=null) out.close();
    }
}
```
- This code is lengthy and doesn't handle any exceptions!😢
- If we use `try-with-resources` we can make the above code cleaner:

```java
public void newApproach(Path p1, Path p2) {
    try (BufferedReader in = Files.newBufferedReader(p1);
         BufferedWriter out = Files.newBufferedWriter(p2);) {
            out.write(in.readLine());
         }
}
```

- The `try-with-resources` closes AUTOMATICALLY CLOSES REWSOURCES.
- This feature is called *automatic resource management*

## 🟥 6.4.2 Try-With-Resources Basics
* The `try-with-resources` statement does not contain an explicit finally block❗
* Here are some basic syntaxes:

```java
try (BufferedReader r = Files.newBufferedReader(p1);
     BufferedWriter w = Files.newBufferedWriter(p2)) {
    // protected code
} // RESOURCES CLOSE HERE
```

```java
try (BufferedReader r = Files.newBufferedReader(p1);
     BufferedWriter w = Files.newBufferedWriter(p2)) {
    // protected code
} catch (IOException e) {
    // exception handler
} finally {
    // finally block
}
```

* The implicit finally runs before any catch or finnaly blocks.
* Can you see why the following does not compile❓❓❓
```java
try (Scanner s = new Scanner; s.nextLine()) {
    s.nextLine();
} catch (Exception e) {
    s.nextInt(); // COMPILER ERROR
} finall {
    s.nextInt(); // COMPILER ERROR
}
```
* The issue is that the Scanner has gone out of scope at the end of the try clause.