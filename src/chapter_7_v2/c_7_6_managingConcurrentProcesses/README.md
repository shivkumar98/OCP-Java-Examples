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
18 Removing Lion
18 Cleaning cage
18 Adds Lion
15 Removing Lion
17 Removing Lion
16 Removing Lion
16 Cleaning cage
16 Adds Lion
17 Cleaning cage
15 Cleaning cage
17 Adds Lion
15 Adds Lion
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
// MAIN METHOD:
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
* We update the main program and supply a `CyclicBarrier(int parties)` object.
* Now when a thread calls `removeLion()`, it will be paused by `c1.await()` until the number of `parties` from the CyclicBarrier is reached (4 in this case)
* Now if we run this code, we get the following result:
```
15 Removing Lion
17 Removing Lion
18 Removing Lion
16 Removing Lion
17 Cleaning cage
16 Cleaning cage
16 Adds Lion
17 Adds Lion
15 Cleaning cage
15 Adds Lion
18 Cleaning cage
18 Adds Lion
```
* We have now ensured, that the threads will not begin the other tasks until the CyclicBarrier limit is achieved.
* We still need the `addLion()` to be coordinated:
```java
public void performTasks(CyclicBarrier c1, CyclicBarrier c2) {
    try {
        removeLion();
        c1.await();
        cleanCage();
        c2.await();
        addLion();
    } catch (Exception e) {
        // handle exception
    }
}
// MAIN METHOD:
ExecutorService service = Executors.newFixedThreadPool(4);
LionPenManager manager = new LionPenManager();
CyclicBarrier c1 = new CyclicBarrier(4);
CyclicBarrier c2 = new CyclicBarrier(4);
try {
    for(int i=0;i<4;i++)
        service.submit(() -> manager.performTasks(c1,c2));
    
} finally {
    if(service!=null) service.shutdown();
}
```
* Running the application:
```
16 Removing Lion
18 Removing Lion
15 Removing Lion
17 Removing Lion
15 Cleaning cage
17 Cleaning cage
16 Cleaning cage
18 Cleaning cage
15 Adds Lion
18 Adds Lion
17 Adds Lion
16 Adds Lion
```

### 🟡 Introducing CyclicBarrier

### 🟡 Thread Pool Size and Cyclic Barrier Limit

<br><hr>

## 🟥 7.6.2 Applying the Fork/Join Framework

### 🟡 Introducing Recursion

### 🟡 Working with `RecursiveAction`

### 🟡 Working with a RecursiveTask

### 🟡 Identifying Fork/Join Issues