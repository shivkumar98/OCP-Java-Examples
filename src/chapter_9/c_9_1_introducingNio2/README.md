<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 9.1 Introducing NIO.2
* NIO.2 is an acryonym for the second version of "Non-blocking Input/Output API"
* This chapter will should how to read and modify attributes of a file
* This chapter will then show the new methods which rely on stream to perform complex operations!
<br>

* The first iteration of file I/O api was discusses in chapter 8
* Java introduced a replacement for java.io streams in 1.4 called `Non-blocking I/O` (NIO) which introduced buffers and channels in place of streams
* This API loads data into a file channel into a temporary buffer which can be read forwards AND backwards without blocking the underlying resource
<br>

* NIO.2 API was introduced in Java 7 as a replacement for `java.io.File`
* The OCP exam will only cover NIO.2 and NOT the first NIO API

<hr>

## 🟥 9.1.1 Introducing Path
* `java.nio.Path` is the primary class for working with NIO.2 
* It represents the hiearchial representation of a file/directory in storage
* Path is a direct replacemenet for `java.io.File`!
* A **symbolic link** is a special file in OS which acts as a pointer to another file/directory
* NIO.2 has full support for creating, detecting and navigating symbolic links

### ⭐ Creating Instances with Factory and Helper Classes
* The `Paths` is a factory includes static methods to obtain instances of `Path` objects
* NIO.2 included hepler classes like `java.nio.file.Files` which operate on instances of `Path` objects.
* 


## 🟥 9.1.2 Creating Paths