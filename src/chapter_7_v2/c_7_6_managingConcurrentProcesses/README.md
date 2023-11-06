<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 7.6 Managing Concurrent Processes
* The concurrency API includes the following classes to to coordinate tasks among thread groups:
1) `CyclicBarrier`
2) `ForkJoinPool`

<br><hr>

## 🟥 7.6.1 Creating a CyclicBarrier
* Suppose we have the following situation where we have lions in a cage, and 4 zoo workers who need to coordinate the following tasks:
1) Remove lions from the cage - only 1 worker can move a lion at a time
2) Clean the cage - can only be done when lions are cleared
3) Bring in the lions - can only be done when cage is cleaned
* The Zoo worker would have the following class:
```java
public void LionPenManager {
    void removeLion() {
		System.out.println(Thread.currentThread().getId()+" Removing Lion");
	}
	void cleanCage() {
		System.out.println(Thread.currentThread().getId()+" Cleaning cage");
	}
	void addLion() {
		System.out.println(Thread.currentThread().getId()+" Adds Lion");
	}
	public void performTasks() {
		removeLion();
		cleanCage();
		addLion();
	}
}
```
* Without any intervention, if I wrote an application in which 4 managers did NOT coordinate tasks:
```java
ExecutorService service = Executors.newFixedThreadPool(4);
LionPenManager manager = new LionPenManager();
try {
    for (int i=0;i<4;i++) // 4 lions
        service.submit(() -> manager.performTasks());
} finally {
    if(service!=null) service.shutdown();
}
```
* Running this application will print:
```
26 Removing Lion
24 Removing Lion
24 Cleaning cage
24 Adds Lion
25 Removing Lion
23 Removing Lion
26 Cleaning cage
23 Cleaning cage
25 Cleaning cage
23 Adds Lion
26 Adds Lion
25 Adds Lion
```
* Clearly this is not achieving what we expect!
<br>

* We can create a logical barrier for our program, which will restrict the threads from moving to the next tasks until the current task is completed!
* We update the `performTask()` method such that it accepts a CyclicBarrier:
```java
public void performTasks(CyclicBarrier c1) {
    try {
        removeLion();
        c1.await();
        cleanCage();
        addLion();
    }
}
```
* We update the main program and supply a `CyclicBarrier(int parties)` object:
```java
ExecutorService service = Executors.newFixedThreadPool(4);
LionPenManager manager = new LionPenManager();
CyclicBarrier c1 = new CyclicBarrier(4);
try {
    for(int i=0;i<4;i++)
        service.submit(() -> manager.performTask(c1));
} finally {
    if(service!=null) service.shutdown();
}
```
* Now when a thread calls `removeLion()`, it will be paused by `c1.await()` until the number of `parties` from the 
### 🟡 Introducing CyclicBarrier

### 🟡 Thread Pool Size and Cyclic Barrier Limit

<br><hr>

## 🟥 7.6.2 Applying the Fork/Join Framework

### 🟡 Introducing Recursion

### 🟡 Working with `RecursiveAction`

### 🟡 Working with a RecursiveTask

### 🟡 Identifying Fork/Join Issues