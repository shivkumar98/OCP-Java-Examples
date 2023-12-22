<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 8: Review Questions - Attempt 1

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
* A - false
* B - false
* C - false
* D - true
* E - false
* F - false
* **D**
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
* B - true, it is more secure as it is not echoed to the console
* C - false, it does no encryption
* E - true
* F - true
* **B,E,F**
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
* **C,D**
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
* A - false
* B - false, this returns byte data
* C - true
* D - false, returns `char[]`
* E - false
* F - false
* **C**
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
* I'm not entirely sure if this compiles or not
* A - false
* B - false
* C - false, I don't think this is possible
* D - higly likely as `line` is not initialised
* E - false
* F - false
* **D**


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
* A - true
* B - false
* C - false, the interface has zero methods
* D - false
* E - true
* **A,E**
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
* **D**
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
* A - true
* B - true
* C - false. I think...
* D - false
* E - false, I think...
* **A,B**
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
* A - true!
* B - false! Serializable is an interface!
* C - false! but considered good practice
* D - false, not even possible
* E - false, not a requirement
* F - false! only those which implement the interface
* **A**
<hr>


## Question 10
❓  ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>


## Question 11
❓  ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>


## Question 12
❓  ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>


## Question 13
❓  ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>


## Question 14
❓  ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>


## Question 15
❓  ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>


## Question 16
❓  ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>


## Question 17
❓  ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>


## Question 18
❓  ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>


## Question 19
❓  ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>


## Question 20
❓  ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>


## Question 21
❓  ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓

### My answer:

<hr>


## Question 22
❓  ❓

A.  <br>
B.  <br>
C.  <br>
D.  <br>
E.  <br>
F.  <br>
❓
