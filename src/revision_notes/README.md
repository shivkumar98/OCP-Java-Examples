<link href="../styles.css" rel="stylesheet"></link>

# 🧠 Chapter 7 Revision Notes

## 🟥 7.1 Introducing Threads

### 🟡 Runnable
* The runnable interface has a single method `void run()`
* Examples include:
```java
Runnable r = () -> counter++;
Runnable r = () -> Sytem.out.print("hello");
Runnable r = () -> { return; };
Runnable r = () -> { };
```

* The `Executor` interface has an `void execute(Runnable r)` method.
* Attempting to use a Callable or assigning it to a variable results in a compilation error:
```java
Runnable r = () -> counter++;
Callable<Integer> c = () -> counter++;
service.execute(r);
service.execute(c); // COMPILATION ERROR
Future<?> f = service.execute(r); // COMPILATION ERROR
```

### 🟡 Creating Threads
* You can execute a thread using the `java.lang.Thread` class
* You can execute a thread in 2 ways
1) Instantiate the thread class with a Runnable in the constructor and call `run()`:
```java
Thread t = new Thread(()->System.out.print("hello"));
t.run(); // prints hello
```
2) Extend Thread class and call the `.start()` method:
```java
public class PrintThread extends Thread {
	@Override
	public void run() {
		System.out.println("running from run");
	}
	public static void main(String[] args) {
		PrintThread pt = new PrintThread();
		new PrintThread().start(); // running from run
	}
}
```

### 🟡 Polling With Sleep
* We have access to the `Thread.sleep(long)` which makes the CPU idle
```java
public static void main(String[] args) throws InterruptedException {
    System.out.println("before sleep");
    Thread.sleep(1000);
    System.out.println("after sleep"); // prints after 1 second passes
}
```

<hr>

## 🟥 7.2 Creating Threads with ExecutorService
### 🟡 Single Thread Executor
* We can use the Concurrency API to create a single thread to execute multiple tasks
* We call `Executors.newSingleThreadExecutor()` which gives us an instance of `ExecutorService`:
```java
ExecutorService service = Executors.newSingleThreadExecutor();
service.execute(()->System.out.println("begin"));
service.execute(()-> {
	for(int i=0;i<5;i++) {
		if (i==1) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { 
				// handle
			}
		}
		System.out.println(i);
	}
})
service.execute(()->System.out.println("end"));
```

* This will ALWAYS print in a sequential order:
```java
begin
0
1
2
3
4
end
```

* If we used a `Executors.fixedThreadPool(10)` instead it will print the following:
```java
begin
end
0
4
2
1
3
```
* Now the ordering is no longer predictable!

### 🟡 Submitting Tasks
* The `ExecutorService` has the following methods:
```java
void execute(Runnable r);
Future<?> submit(Runnable r);
Future<T> submit(Callable<T> c);
List<Future<T>> invokeAll(Collection<? extends Callable<T>> c);
T invokeAny(Collection<? extends Callable<T>> c);
```
* Here are some examples of using these methods:
```java
service = Executors.newSingleThreadExecutor();
Future<Integer> f1 = service.submit(c);
// Future<Integer> f2 = service.execute(r); // COMPILER ERROR
Future<?> f2 = service.submit(r);
service.execute(r);
System.out.println(f1.get()); // 1
System.out.println(f2.get()); // null
System.out.println(counter); // 3
List<Callable<Integer>> list = Arrays.asList(c,c,c);
List<Future<Integer>> returnedList = service.invokeAll(list);
Integer f = service.invokeAny(list);
System.out.println(f); // 7
List<Integer> l = getTheValuesOfFutureList( returnedList);
System.out.println(l); // [4,5,6]
```

### 🟡 Waiting for Results
* When we use the `submit()` method we return a future object. If we use the `get()` method, there is a chance that the program will halt!
* We can get around this by using an overloaded version of get()!
* We can determine whether the task which has been submitted is actually complete with the following methods:
```java
boolean isDone();
boolean isCancelled();
boolean cancel(); // attempts to cancel the task
V get(); // retrieves result of task, waiting endlessly if not yet available
V get(long millis, TimeUnit unit); // retrieves result in alotted time, otherwise throws TimeoutException
```
* E.g.:
```java
static int counter = 0;
public static void main(String[] args) throws InterruptedException, ExecutionException {
	ExecutorService service = null;
	try {
		service = Executors.newSingleThreadExecutor();
		Future<?> result = service.submit(() -> {
			for(int i=0;i<500;i++) counter++;
		});
		result.get(10, TimeUnit.SECONDS);
		System.out.println("Reached");
	} catch (TimeOutException e) {
		System.out.println("Not reached in time");
	} finally {
		if(service!=null) service.shutdown();
	}
}
```

### 🟡 Scheduling Tasks
* We have a subinterface `ScheduledExecutorService` which has methods for running tasks on a schedule:
```java
ExecutorService serviceUsingWrongReference = Executors.newSingleThreadScheduledExecutor();
// serviceUsingWrongReference.schedule(); // COMPILER ERROR
ScheduledExecutorService scheduledService
    = Executors.newSingleThreadScheduledExecutor();
```

* We have the fdllowing methods for scheduling methods with a delay:
```java
schedule(Callable<V> callable, long delay, TimeUnit unit);
schedule(Runnable callable, long delay, TimeUnit unit);
```

* We can assign these two methods to Future objects:
```java
Callable<Integer> c = () -> 1;
Runnable r = () -> System.out.println("hello");
Future<Integer> f = scheduledService.schedule(c, 1, TimeUnit.SECONDS);
Future<?> f2 = scheduledService.schedule(r, 1, TimeUnit.SECONDS);
// prints hello
System.out.println(f.get()); // 1
System.out.println(f2.get()); // null
```

* There also two methods which schedule a runnable task on repeat:
```java
scheduleAtFixedRate(Runnable r, long initialDelay, long period, TimeUnit unit);
scheduledAtFixedDelay(Runnable r, long initialDelay, long delay, TimeUnit unit);
```

* E.g.:
```java
Future<?> f3 = scheduledService.scheduleAtFixedRate(r, 1, 1, TimeUnit.SECONDS);
// this will print hello exactly every second		

Future<?> f4 = scheduledService.scheduleWithFixedDelay(r, 0, 1, TimeUnit.SECONDS);
// this will print hello exactly 1 second after the previous hello is printed
```

<hr>

## 🟥 7.3 Synchronizing Data Access

### 🟡 Atomic Classes
* We have the following Atomic classes in the Concurrency API:
1) `AtomicBoolean`
2) `AtomicInteger`
3) `AtomicLong`
4) `AtomicReference`
5) `AtomicIntegerArray`
6) `AtomicLongArray`
7) `AtomicReferenceArray`

* Here are common methods for these classes:
```java
get();
set();
getAndSet(newValue); // gets old value while setting new value
incrementAndGet(); // increments and returns the incremented value
getAndIncrement(); // gets old value and increments after
decrementAndGet(); // decrements and returns decremented value
getAndDecrement(); // gets old value and decrements after
```
* Here is an example of using an Atomic class to ensure a counter is kept THREAD-SAFE and to prevent race conditions:
```java
public class SheepManager {
	AtomicInteger sheepCount = new AtomicInteger(0);
	void incrementAndReport() {
		System.out.print(sheepCount.incrementAndGet()+" ");
	}
	public static void main(String[] argS) {
		SheepManager manager = new SheepManager();
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(20);
			for(int i=0;i<10;i++)
				service.submit(()->manager.incrementAndReport()))
		} finally {
			if(service!=null) service.shutdown();
		}
	}
}
```
* Here are samples of what would be printed:
```java
1 10 9 3 2 8 7 4 6 5 
2 10 9 7 8 6 5 4 1 3 
```

### 🟡 Synchronized Methods
* We can synchronize access to methods using `synchronized` keyword. The following are equivalent:
```java
synchronized void print() {
	System.out.print("hello");
}
void incrementAndReport() {
	synchronized(this) {
		System.out.print("hello");}
}
```

<hr>

## 🟥 7.4 Using Concurrent Collections

<hr>

## 🟥 7.5 Working with Parallel Streams

<hr>

## 🟥 7.6 Managing Concurrent Processes

<hr>

## 🟥 7.7 Identifyuing Threading Problems