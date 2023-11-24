<link href="../../styles.css" rel="stylesheet"></link>

# 📝 Chapter 7: Revision Notes

# 🧠 7.1 Introducing Threads
* A thread is the smallest unit of execution that can be scheduled by OS
* A task is a single unit of work performed by a thread
* A process is a group of threads executing in a shared environment, sharing the same memoery space and can communicate with each other.
* Single-threaded processes contain exactly one thread
* Multi-threaded processes have more than one thread

## 🟥 7.1.1 Distinguishing Thread Types
* A system thread is created by the JVM and runs in background of application, e.g. for garbage collection
* A user-defined thread is created by the developer, e.g. the main method is a user-defined thread but we can create more user-defined thrads
* Hence we call single-threaded applications ones which have only the main method.

## 🟥 7.1.2 Understanding Thread Concurrency
* Concurrency is thte propertty of executing multtiple threads and processes at the same time
* Concurrency can benefit an application, even on single core CPUs
* OSs use a thread scheduler to determine which tthreads should be running currently.
* A thread priorty is a numeric value associated with a thread, which is to be used by the thread scheduler.

## 🟥 7.1.3 Introducing Runnable
* `Runnable` is a functional interface which takes no arguments, and returns void:
```java
public interface Runnable {
    void run();
}
```
* Here are some examples:
```java
Runnable r = () ->  System.out.println("hello");
Runnable r2 = new Runnable() {
    public void run() {
        // TODO Auto-generated method stub
        
    }
};
Runnable r3 = () -> {int i=10; i++;};
Runnable r4 = () -> null; // COMPILER ERROR
```


## 🟥 7.1.4 Creating a Thread
* You can instantiate the `Thread` class in order to complete a task
* You can execute a task by either:
1) Padding in a Runnable lambda/ohject
2) Create a class which extends Thread, and implement run() method

```java
Thread thr = new Thread(()->System.out.println("hello"));
thr.run(); // hello
```

```java
public class Printer extends Thread {
    public void run() {
        for(int i=0;i<3;i++) System.out.print(i+" ");
    }
    public static void main() {
        (new Printer()).start(); // 0 1 2
    }
}
```

* The order in which results of a thread are not guaranteed

## 🟥 7.1.5 Polling with Sleep



<br><hr>

# 🧠 7.2 Creating Threads with the `ExecutorService`

## 🟥 7.2.1 Introducing the Single-Thread Executor

## 🟥 7.2.2 Shutting Down a Thread Executor

## 🟥 7.2.3 Submitting Tasks

## 🟥 7.2.4 Waiting For Results

## 🟥 7.2.5 Scheduling Tasks

## 🟥 7.2.6 Increasing Concurrency with Pools



<br><hr>

# 🧠 7.3 Synchronizing Data Access

## 🟥 7.3.1 Protecting Data with Atomic Classes

## 🟥 7.3.2 Improving Access with Synchronized Blocks



<br><hr>

# 🧠 7.4 Using Concurrent Collections

## 🟥 7.4.1 Introducing Concurrent Collections

## 🟥 7.4.2 Understanding Memory Consistency Errors

## 🟥 7.4.3 Working with Concurrent Classes

## 🟥 7.4.4 Obtaining Synchronized Collections



<br><hr>

# 🧠 7.5 Working with Parallel Streams

## 🟥 7.5.1 Creating Parallel Streams

## 🟥 7.5.2 Processing Tasks in Parallel

## 🟥 7.5.3 Processing Parallel Reductions



<br><hr>

# 🧠 7.6 Managing Concurrent Processes

## 🟥 7.6.1 Creating a CyclicBarrier

## 🟥 7.6.2 Applying the Fork/Join Framework




<br><hr>

# 🧠 7.7 Identifying Threading Problems

<br><hr>

## 🟥 7.7.1 Understanding Liveness

## 🟥 7.7.2 Managing Race Conditions
