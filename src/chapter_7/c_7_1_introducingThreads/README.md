<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 7.1 Reviewing Exceptions

* A thread is the smallest unit of execution that can be scheduled by the operating system.
* A process is a group of associated threads that execute in the same shared environment - threads in the same process can access the same memory space and can communicate with each other.
* Single-threaded processes consist of only single threads, multi-threaded processes consist of one or more threads
* A task is a single unit of work performed by a thread.
* Throughtout this chapter, a task will commonly be expressed as a lambda expression.

## 🟥 7.1.1 Distinguishing Thread Types
* All Java applications are multi-threaded, including the ones which print `Hello World!` to the screen - to understand this we shall go through concepts of system and user-defined threads.
* A **system thread** is created by JVM and runs in the background
      - E.g. garbage collection
      - For the most part, system defined threads are invisible to the app developer
      - If a system thread encounters a problem for which ist can not recover,, it will throw an `Error` instead of an `Exception`
* A **user-defined thread** is one created by the developer to achieve a specific task
      - All the apps contained a single user-defined thread which calls the main methof
      - We commonly refer to apps which contain a single user-defined thread as single-threaded applications.

### 🟡 H3