<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 7.1 Introducing Threads
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
* 


<hr>

## 🟥 7.1.2 Understanding Thread Concurrency

<hr>

## 🟥 7.1.3 Introducing Runnable

<hr>

## 🟥 7.1.4 Creating a Thread

<hr>

## 🟥 7.1.5 Polling with Sleep
