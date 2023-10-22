<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 7.6
* The Concurrency API includes classes which enable you to coordinate tasks between related threads.
* These classes are for very specific scenarios
* The classes I need to know for OCP:
1) `CyclicBarrier`
2) `ForkJoinPool`

## 🟥 7.6.1 Creating a CyclicBarrier
### 🟡 Introducing CyclicBarrier
* Suppose we have a lion pen which needs to be emptied, cleaned, and then filled back up with lions. We have 4 zoo workers, we do not want the to start cleaning when lions are present, and we do not want them to return until cleaning is complete.
* We want all four workkers to work concurrently, pausing between the end of one set of tasks and the start of the next.
* We use the `CyclicBarrier` class to achieve this, let's start the code without this though:
```java
import java.util.concurrent.*;
public class LionPenManager {
    private void removeAnimals() { System.out.println("Removing animals"); }
    private void cleanPen() { System.out.println("Cleaning the pen"); }
    private void addAnimals() { System.out.println("Adding animals"); }

    public void performTask() {
        removeAnimals(); cleanPen(); addAnimals();
    }

    public static void main() {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            LionPenManager manager = new LionPenManager();
            for(int i=0;i<4;i++)
                service.submit(() -> manager.peformTask());
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
```
* Here is a sample output based on the above:
```
Removing animals
Removing animals
Cleaning the pen
Adding animals
Removing animals
Cleaning the pen
Adding animals
Removing animals
Cleaning the pen
Adding animals
Cleaning the pen
Adding animals
```
* Due to this being multithreaded, the order is completely random.
* We can improve these results by using `CyclicBarrier`, this class takes a limit value - number of threads to wait for
* As each thread finishes, it calls the await method on the cyclic barrier. Once the specified number of threads have each called `await()`, the barrier is release and all threads can continue.
* Here's an implementation using `CyclicBarrier`:
```java
import java.util.concurrent.*;
public class LionPenManager {
    private void removalAnimals() { System.out.println("Removing animals"); }
    private void cleanPen() { System.out.println("Cleaning the pen"); }
    private void addAnimals() { System.out.printn("Adding animals"); }

    public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            removeAnimals();
            c1.await();
            cleanPen();
            c2.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
            // Handle checked exceptions here
        }
    }
    public static void main() {
        ExecutorService service = null;
        try {
            service = Executor.newFixedThreadPool(4);
            LionPenManager manager = new LionPenManager();
            CyclicBarrier c1 = new CyclicBarrier(4);
            CyclicBarrier c2 = new CyclicBarrier(4,
                () -> System.out.println("*** Pen Cleaned!"));
            for(int i=0;i<4;i++)
                service.submit(() -> manager.performTask(c1,c2));
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
```
* Here is the following sample output based on the above implementation:
```
Removing animals
Removing animals
Removing animals
Removing animals
Cleaning the pen
Cleaning the pen
Cleaning the pen
Cleaning the pen
*** Pen Cleaned!
Adding animals
Adding animals
Adding animals
Adding animals
```


### 🟡 Thread Pool Size and Cyclic Barrier Limit
* The number of available threads must be equal or greater to the CyclicBarrier limit value.
* E.g., if we have the following snippet, the code will hang indefinitely as this is a form of deadlock:
```java
ExecutorService service = Executors.newFixedThreadPool(2);
``
<hr>

## 🟥 7.6.2 Applying the Fork/Join Framework

### 🟡 Introducing Recursion




<br>

### 🟡 Working with a RecursiveTask




<br>

### 🟡 Identifying Fork/Join Issues



