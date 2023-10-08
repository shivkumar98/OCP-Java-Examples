<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 7.1 Introducing Threads

* A thread is the smallest unit of execution that can be scheduled by the operating system.
* A process is a group of associated threads that execute in the same shared environment - threads in the same process can access the same memory space and can communicate with each other.
* Single-threaded processes consist of only single threads, multi-threaded processes consist of one or more threads
* A task is a single unit of work performed by a thread.
* Throughtout this chapter, a task will commonly be expressed as a lambda expression.

<hr>

## 🟥 7.1.1 Distinguishing Thread Types
* All Java applications are multi-threaded, including the ones which print `Hello World!` to the screen - to understand this we shall go through concepts of system and user-defined threads.
* A **system thread** is created by JVM and runs in the background
      - E.g. garbage collection
      - For the most part, system defined threads are invisible to the app developer
      - If a system thread encounters a problem for which ist can not recover,, it will throw an `Error` instead of an `Exception`
* A **user-defined thread** is one created by the developer to achieve a specific task
      - All the apps contained a single user-defined thread which calls the main methof
      - We commonly refer to apps which contain a single user-defined thread as single-threaded applications.

<hr>

## 🟥 7.1.2 Understanding Thread Concurrency
* We said that multi-threading allows the OS to execute multiple threads at the same time
* Concurrency is the property of executing multiple threads at the same time
* Only a multi-core, or multi-CPU, systems can execute multiple task at a time
* The OS uses a `thread scheduler` to determine which threads should be executed concurrently
* A thread scheduler enables the OS to run multiple processes at the same time even on a single core CPU
* A thread scheduler may employ a round-robin schedule in which threads are assigned an equal number of CPU cycles to each thread.
* Each thread is given an alotted time, if the thread does not finish then a `context switch` occurs - the thread's current state is stored which can be later restored to continue execution

* A thread can interrupt another thread, if it has higher `thread priority` - this is a numeric value which the thread scheduler uses to figure out which thread should be executed currentlyl
      - Thread priority in java is specified through integer values.
      - Java has the following threaad priorty constants:

| Constant Variable | Value  |
| ----------------- | ------ |
| Thread.MIN_PRIORITY | 1    |
| Thread.NORM_PRIORTY | 5    |
| Thrad.MAX_PRIORITY  | 10   |

<hr>

## 🟥 7.1.3 Introducing Runnable
* Runnable is a functional interface which takes no arguments and returns no data:
```java
@FunctionalInterface public interface Runnable {
      void run();
}
```
* This interface is used commonly to define work a thread will execute.
* The following expressions rely on the above Runnable interface:
```java
() -> System.out.println("Hello World");
() -> {int i=10; i++};
() -> {}
```

<hr>

## 🟥 7.1.4 Creating a Thread
* The easiest way to execute a threads is to use `java.lang.Thread` and starting it using `Thread.start()`.
* Java does not guarantee that a thread will be processed when started, it may be immediate or delayed slightly
* We can define a task that a Thread instance will execute in two ways:
1) Provide a Runnable object or lambda expression to Thread constructor
```java
public class PrintData implements Runnable {
    public void run() {
        for(int i=0; i<3; i++)
            System.out.println("Printing record: "+i);
    }
    public static void main() {
      (new Thread(new PrintData())).start();
    }
}
```
2) Create a class which extends `Thread` and overrides the run method
```java
public class ReadInventoryThread extends Thread {
    public void run() {
        System.out.println("Printing zoo inventory");
    }
    public static void main() {
      (new ReadInventoryThread()).start();
    }
}
```
* The first approach is far more common. Whenever you start a task with `Thread.start()` it starts the task in a seperate OS thread.
* What is the output of the following code snippet❓❓❓
```java
public static void main(String[] args) {
    System.out.println("begin");
    (new ReadInventoryThread()).start();
    (new Thread(new PrintData())).start();
    (new ReadInventoryThread()).start();
    System.out.println("end");
}
```
* ANSWER: the output is unknown till runtime!✅ ✅ ✅ 
* Running the code on my system prints the following:
```
begin
Printing zoo inventory
end
Printing zoo inventory
Printing record: 0
Printing record: 1
Printing record: 2
```
* This code uses 4 threads, the `main()` thread,, and three additional threads.
* We can create threads and not call the `start()` method, if we call `run()` then the threads will execute on the thread it was called from. The thread will wait till its completed the previous task before moving to the next line
* E.g.:
```java
System.out.println("start");
new PrintData().run();
(new Thread(new PrintData())).run();
(new ReadInventoryThread()).run();
System.out.println("end");
```
* This prints the following:
```

```
### 🟡 H3