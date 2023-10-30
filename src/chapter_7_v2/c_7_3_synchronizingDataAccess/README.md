<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 7.3 Synchronizing Data Access
* **Thread safety** is the property of an object which ensures safe execution from multiple threads at the SAME TIME
* Here is a program which illustrates a lack of thread safety:
```java
public class SheepManager {
    private int sheepCount = 0;
    private void incrementAndReport() {
        System.out.println((++sheepCount)+" ");
    }
    public static void main() {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManager manager = new SheepManager();
            for(int i=0;i<10;i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            if(service!=null) service.shutdown();
        }
    }
}
```
* The increment operator (`++sheepCount`) is not thread safe!
* This introduces a **Race Condition** - two tasks being executed at the same time generating unexpected results.
* Here is an example output of this program
```
1 9 8 1 7 6 4 3 5 2
```

## 🟥 7.3.1 Protecting Data with Atomic Classes
* The pre-increment operator is not thread safe. We can ensure the sheepCount is thread safe by using atomic classes which have thread safe increment operators!
* We have the following **Atomic Classes**:
1) `AtomicBoolean`
2) `AtomicInteger`
3) `AtomicIntegerArray`
4) `AtomicLong`
5) `AtomicLongArray`
6) `AtomicReference`
7) `AtomicReferenceArray`
* We have the following methods available to us:
1) `get()` - returns current value
2) `set()` - set to given value
3) `getAndSet()` - sets new value and gets old value
4) `incrementAndGet()` - pre-increment
5) `decremendAndGet()` - pre-decrement
6) `getAndDecrement()` - post-decrement

* We update our `SheepManager` class to:
```java
public class SheepManager {
    private AtomicInteger sheepCount = 0;
    private void incrementAndReport() {
        System.out.print(sheepCount.incrementAndGet()+ " ");
    }
    public static void main() {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManager manager = new SheepManager();
            for(int i=0;i<10;i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            if(service!=null) service.shutdown();
        }
    }
}
```
* If we run the above code, here is a sample of what we would get:
```
1 10 9 8 2 5 6 3 4 7 
1 10 9 8 6 3 2 7 5 4 
```
* This is BETTER, but our results are unordered! Using the atomic class, we have ensured the data is consistent between threads!



<hr>

## 🟥 7.3.2 Improving Access with Synchronized Blocks


<hr>

## 🟥 7.3.3 Synchronizing Methods



<hr>

## 🟥 7.3.4 Understanding the Cost of Synchronization
