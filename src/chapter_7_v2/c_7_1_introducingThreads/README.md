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
* The simplest way to execute a thread is by using the `java.lang.Thread` class.
* You first define the thread with a process to start and then call `Thread.start()`
* Java does not guarantee that a task will be processed when the thread is started,
* We can define the `Thread` instance will execute can be done in 2 ways
1) Provide a `Runnable` object or lambda expression to the `Thread` constructor
2) Create a subclass of `Thread` and override `run()` method
* Examples:
```java
public class PrintData implements Runnable {
	public void run() {
		for(int i=0;i<3;i++) 
			System.out.println("Printing record: "+i);
	}
	public static void main(String[] args) {
		new PrintData().run(); // prints 3 times
		new Thread(new PrintData()).start(); // prints 3 times
		new Thread(() -> System.out.println("using lambda")).start();
		// prints "using lambda"
	}
}
```
```java
public class ReadInventoryThread extends Thread {
	public void run() {
		System.out.println("Print manga inventory");
	}
	public static void main(String[] args) {
		(new ReadInventoryThread()).start();
		// Print manga inventory
	}
}
```
* When you start a task with `Thread.start()`, this starts the task in a seperate OS thread. E.g. what does the following print?
```java
public static void main() {
    System.out.println("begin");
    (new ReadInventoryThread()).start();
    (new Thread(new PrintData)).start();
    (new ReadInventoryThread()).start();
    System.out.println("end");
}
```
* The answer is that we do not know until runtime. This is just one possible output:
```
begin
Print manga inventory
Printing record: 0
end
Print manga inventory
Printing record: 1
Printing record: 2
```
* This uses a total of four threads (one for main method)
* As we saw in the first example, we CAN call the `run()` method from a Runnable implementation, as well as call it from a constructed thread:
```java
new PrintData().run();
(new Thread(new PrintData())).run();
(new ReadInventoryThread()).run();
```
* It will not execute on a seperate thread, doing it this way
* In general, you shouldn't extend the Thread class but instead implement the `Runnable` interface.
<hr>

## 🟥 7.1.5 Polling with Sleep
