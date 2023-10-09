<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 7.3 Synchronizing Data Access
* Thread safety is the property than object guarantees safe execution by multiple threads at the same time.
* Now that we have multiple threads accessing data, we don't want to end up with unexpected results.
* How do we prevent two threads interacting with each other. Suppose we have the following class which increments a counter:
```java
import java.util.concurrent.*;

public class SheepManager {
    private int sheepCount = 0;
    private void incrementAndReport() {
        System.out.println((++sheepCount)+" ");
    }
    public static void main(String[] args) {
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
* Here are some example outputs:
```
1 10 9 8 3 6 5 4 2 7 
1 10 9 8 7 2 6 4 5 3 
1 5 4 3 6 8 2 7 9 10 
2 8 7 1 5 3 6 1 4 9 
```
* Due to a lack of thread synchronisation, two threads could read the `sheepCount` before it gets updated by another thread.
* The unexpected result of two tasks executing at the same time is called a `race condition`.

## 🟥 7.3.1 Protecting Data with Atomic Classes
* The concurrency API added the `java.util.concurrent.atomic` package to help coordinate access to primitve values/object references
* **Atomic** is the property that an operation is carried out without interference from other threads.
* We have the following **Atomic classes**:

| Class Name       | Description                                |
| ---------------- | ------------------------------------------ |
| `AtomicBoolean`  | For boolean values                         |
| `AtomicInteger`  | For int values                             |
| `AtomicIntegerArray` | For int array value                    |
| `AtomicLong`      | For long values                           |
| `AtomicLongArray` | For long array values                     |
| `AtomicReference` | A generic object reference                |
| `AtomicReferenceArray` | An array of generic object references |
* Here are some **common atomic methods**:
| Class Name                | Description                       |
| ------------------------- | --------------------------------- |
| `get()`                   | Retrieve the current value        |
| `set()`                   | Sets it to given value            |
| `getAndSet()`             | Atomically sets the new value, while returning old value |
| `incrementAndGet()`       | For numeric classes, atomic pre-increment  |
| `decrementAndGet()`       | For numeric classes, atomic pre-decrement  |
| `getAndIncrement()`       | For numeric classes, atomic post-increment |
| `getAndDecrement()`       | For numeric classes, atomic post-decrement |

* We can re-write the `SheepManager` class as:
```java
import java.util.concurrent.*;
public class SheepManagerV2 {
	private AtomicInteger sheepCount =  new AtomicInteger(0);
	private void incrementAndReport() {
		System.out.print(sheepCount.incrementAndGet()+" ");
	}
	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			SheepManagerV2 manager = new SheepManagerV2();
			service = Executors.newFixedThreadPool(20);
			for(int i=0;i<10;i++)
			service.submit(() -> manager.incrementAndReport());
		} finally {
			if(service!=null) service.shutdown();
		}
	}
}
```
* This prints the folling samples:
```
1 2 10 9 8 6 7 3 4 5
2 10 9 8 3 5 6 4 7 1  
```
* Now the numbers will always range from 1 to 10! But they are not ordered. The atomic classes have ensured data is not lost with concurrent modifications!


## 🟥 7.3.2 Improving Access with Synchronized Blocks

<hr>

## 🟥 7.2.3 Synchronizing Methods

<hr>

## 🟥 7.2.4 Understanding the Cost of Synchronization



### 🟡 H3