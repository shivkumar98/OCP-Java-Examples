<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 7.1 Reviewing Exceptions

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

### 🟡 H3