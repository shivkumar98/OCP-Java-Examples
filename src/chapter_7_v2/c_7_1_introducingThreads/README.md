<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 7.1 Introducing Threads V2
* A thread is the smallest unit of execution that can be scheduled by the OS
* A process is a collection of threads executing in a shared environment - sharing same memoery space and communicate with each other.
* **Single threaded process** is one which contains exactly one thread
* **Multi threaded process** is one which contains one or more threads
* Static variables enable us to perform multithreaded tasks. If one thread updates a static variables, than another thread can access this information immediately.
* **Task** is a single unit of work performed by a thread.

## 🟥 7.1.1 Distinguishing Thread Types
* All java applications in this book have been multi-threaded!
* **System thread** is created by JVM and runs in the background of the application.
    - E.g. garbage collection is a system thread
* If a system thread encounters a problem it generates a Java `Error` rather than `Exception`
* **User-defined thread** is created by the developer to achieve a specific task.
* We are often not concerned with system threads,
<hr>

## 🟥 7.1.2 Understanding Thread Concurrency
* **Concurrency** is the property of executing multiple threads and processes at the same time.
* We can achieve concurrency with single core CPUs, in fact we often have more threads than cores.
* Operating Systems use a **thread scheduler** to determine which threads should be currently executing.
    - A thread scheduler may employ a `round-robin schedule`.
    - A thread is given an allotted time, if the task does not finish within that time then a `context switch` occurs.
    - A **context switch** is the process of storing a thread's current state.
* `Thread priority` is a numeric value associated with the thread and is used by the thread scheduler to determine which threads should be executed.
<hr>

## 🟥 7.1.3 Introducing Runnable
* `java.lang.Runnable` is a functional interface which takes no arguments and returns no data:
```java
@Functionalnterface 
public interface Runnable {
    void run();
}
```
* This interface is used to define the work a thread will execute, seperate from the main application thread.
* The following lambda expressions ARE valid implementation of the Runnable interface:
```java
() -> System.out.println("Hello World")
() -> {int i=10; i++;}
() -> {return;}
() -> {}
```
*  The followin are INVALID implementations of Runnable interface:
```java
() -> ""
() -> 5
() -> {return new Object();}
```

### 🟡 Creating Runnable Classes
* The Runnable existed as an interface since Java 1, only Java 8 made it a functional interface
* Here is a class which implements the interface:
```java
public class CalculateAverage implements Runnable {
    public void run() {
        // Define work here
    }
}
```
* It is common to pass data into the constructor:
```java
public class CalculateAverages implements Runnable {
    private double[] scores;
    public CalculateAverages(double[] scores) {
        this.scores = scores;
    }
    public void run() {
        // define work here which uses scores
    }
}
```

<hr>

## 🟥 7.1.4 Creating a Thread

<hr>

## 🟥 7.1.5 Polling with Sleep
