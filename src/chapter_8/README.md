<link href="../../style.css" rel="stylesheet"></link>

# Chapter 8 - IO
### 📜 Contents 📜
- [🧠 8.1 Understanding Files and Directories](/src/chapter_8/c_8_1_understandingFilesAndDirectories/)
- [🧠 8.2 Introducing Streams](/src/chapter_8/c_8_2_introducingStreams/)
- [🧠 8.3 Workking With Streams](/src/chapter_8/c_8_3_workinWithStreams/)
- [🧠 8.4 Interacting with Users](/src/chapter_8/c_8_4_interactingWithUsers/)
- [📝Revision Notes](/src/chapter_8/revisionNotes)
- [✅ Review Questions](/src/review_questions/chapter_8/)

<hr>

### 🎯 Exam Objectives 🎯

* Read and write data from the console
* Use the following classes from java.io.package:
    - `BufferedReader`
    - `BufferedWriter`
    - `File`
    - `FileReader`
    - `FileWriter`
    - `FileInputStream`
    - `FileOutputStream`
    - `ObjectOutputStream`
    - `ObjectInputSttream`
    - `PrinterWriter`

### ✅ Exam Essentials ✅
1) Understand files, directories, and streams.
2) Be able to use `java.io.File` class. 
* This class has methods for creating/deleting files/directories and obtain a list of files within a directory
3) Distinguish between byte and character streams
* Byte streams have the word `InputStream`/`OutputStream` in their name and are useful for binary data 
* Character streams have the word `Reader`/`Writer` in their name=
4) Be able to use the following classes:
* `BufferedReader`
* `BufferedWriter`
* `File`
* `FileWriter`
* `FileReader`
* `FileInputStream`
* `FileOutputStream`
* `ObjectInputStream`
* `ObjectOutputStream`
* `PrintWriter`
5) Be able to perform stream operations like:
* `markSupported`/`mark(int)`
* `reset()`/`skip`
6) Understand how to use Java Serialization using `ObjectInputStream`/`ObjectOutputStream`
7) Be able to interact with user via `Console` class