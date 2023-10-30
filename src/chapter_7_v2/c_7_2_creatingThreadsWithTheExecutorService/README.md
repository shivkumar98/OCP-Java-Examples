<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 7.2 Creating Threads with the `ExecutorService`
* The Concurrency API has the `ExecutorService` class which creates and manages threads for you.
* You obtain an instance of this class, and send tasks to be processed.
* This class has built in polling and scheduling.




<hr>

## 🟥 7.2.1 Introducing the Single-Thread Executor
* We have an `Executor` factory class to get an instance of ExecutorService.
* Here is an example of using `Executor.newSingleThreadExecutor`:
```java
import java.util.concurrent.*;
public class ZooInfo {
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            service.execute(
                () -> System.out.println("Printing zoo inventory"));
            service.execute(() -> {
                for(int i=0;i<3;i++)
                System.out.println("Printing record: "+i);
                }
            );
            service.execute(() -> System.out.println("Printing zoo inventory"));
            System.out.println("end");   
        } finally {
            if(service!=null) service.shutdown();
        }
    }
}
```
* This example uses exactly ONE thread, and all the tasks are completely asynchrously. Here is an example output:
```
begin
Printing zoo inventory
end
Printing record: 0
Printing record: 1
Printing record: 2
Printing zoo inventory
```
* Notice how the end text is displayed but the executor service - this is because the `main()` thread is INDEPENDENT of the thread from ExecutorService.

<hr>

## 🟥 7.2.2 Shutting Down a Thread Executor
* You need to call the `shutdown()` method when you are finished with a thread executor. If you do not the application will never terminate.
* The `ExecutorService` has the following shutdown process:
1) Reject any new tasks while continuing with previously submitted tasks.
    - If a new task is submitted to the thread executor, a `RejectedExecutionException` is thrown
    - `isShutdown() = true`
    - `isTerminatedFalse() = false`
2) When all active tasks are completed, the lifecycle is complete
    - `isShutDown() = true`
    - `isTerminated() = true`



<hr>

## 🟥 7.2.3 Submitting Tasks
1) We can execute tasks to be done asynchrously using the `execute()` methood which takes a `Runnable` lambda or implementation. The return type is `void` - so we do not know the result of the task
2) We can submit tasks to be done asynchrously and obtain a `Future<T>` object using `submit()`
3) We can send off a set of taks using `invokeAll()` and `invokeAny()`
    - `invokeAll()` will synchrously return the results of all tasks as a Collection of Future objects. 
    - `invokeAny()` will synchrously return the result of any one of the finished tasks, cancelling any unfinished tasks.
### 🟡 execute() vs submit()
* `execute()` does not support `Callable` expressions.

### 🟡 Submitting Task Collections
* The `invokeAny()` and `invokeAll()` methods are **SYNCHRONOUS** - they will wait for results to be available before returning control to the enclosing program.
* `invokeAll()` executes all tasks in the collection and returns a `List` of ordered `Future` objects. This method will wait indefinitely till all tasks are completed.
* `invokeAny()` executes a collection of tasks and returns the result of one of the tasks that successfully completed execution. This method will only wait till one task is complete.

* Here is an example of using `invokeAll()`:
```java
class CallableClass implements Callable<String> {
	private int i;
	public CallableClass(int i) {
		this.i = i;
	}
	public String call() throws Exception {
		return ""+i;
	}
}

// MAIN METHOD:
public static void main(String[] args) {
    ExecutorService service = null;
    try {
        service = Executors.newFixedThreadPool(2);
        List<Callable<String>> list = 
                List.of(new CallableClass(1),
                        new CallableClass(2),
                        new CallableClass(3),
                        new CallableClass(4)
                        );
        List<Future<String>> futureList = service.invokeAll(list);
        for (Future<String> future: futureList)
            System.out.println(future.get());
    } finally {
        service.shutdown();
    }
}
```
* The above code prints:
```
1
2
3
4
```


<hr>

## 🟥 7.2.4 Waiting For Results
* The `submit()` method returns a `Future<V>` object:
```java
Future<?> future = service.submit(() -> System.out.println("Hello Zoo"));
```
* This `future` object has the following methods:
1) `boolean isDone()` - true if the task was complete, threw an exception or cancelled
2) `boolean isCancelled()` - true if cancelled before completed normally
3) `boolean cancel()` - attempts to cancel execution of the task
4) `V get()` - obtains result, will wait endlessly if not available
5) `V get(long timeout, TimeUnit unit)` - obtains the result waiting the specified time. If unavailable then `TimeoutException` is thrown.

* We previously wrote a `CheckResults` class using thread polling:
```java
public class CheckResults {
    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            for(int i=0;i<500;i++) CheckResults.counter++;
        }).start();
        while (CheckResults.counter<100) {
            System.out.println("Not reached yet");
            Thread.sleep(1000); // 1 SECOND
        }
        System.out.println("Reached");
    }
}
```
* Here is the same class which uses a Future object:
```java
public class CheckResults {
    private static int counter = 0;
    public static void main(String[] args) throw InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> future = service.submit(() -> {
                for(int i=0;i<500;i++) CheckResults.counter++;
            });
            future.get(10, TimeUnit.SECONDS);
            System.out.println("Reached");
        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if(service!=null) service.shutdown();
        }
    }
}
```
* This implementation does not use the Thread class directly - which is the exact purpose of the Concurrency API.

### 🟡 Introducing Callable
* Java 5 introduced the `Callable` interface. It has a `call()` which returns a value:
```java
@FunctionalInterface public interface Callable<V> {
    V call() throws Exception;
}
```
* In comparison, the Runnable interface has a `run()` method which returns void and throws no checked exceptions.
* The `ExecutorService` has an overload for `submit()` which takes a `Callable` and returns `Future<T>`
* Here is an example of using `Callable`:
```java
public class AddData {
    public static void main(String[] args) throws InterruptedException,
        ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<Integer> result =
                service.submit(() -> 30+11);
            System.out.println(result.get());
        } finally {
            if(service!=null) service.shutdown();
        }
    }
}
```

### 🟡 Checked Exceptions in Callable and Runnable
* The `Callable` interface allows you to throw a checked exception. Meaning if you are supplied a lambda to the `Executors.submit()` and it DOES return something, you can write statements which have checked exceptions
* Conversely, the `Runnable` interface does not allow for exceptions. Meaning if you use a lambda expression which does not return anything, you can not write statements which throw checked exceptions
```java
service.submit(() -> {Thread.sleep(1000); return null;}); // compiles fine
service.submit(() -> {Thread.sleep(1000);}); // COMPILER ERROR
```

### 🟡 Waiting for All Tasks to Finish
* We can use the `Future.get()` method to wait for the results to finish
* If we do not ned the results of tasks and finished with our thread executor we can use the `awaitTermination(long timeout, TimeUnit unit)` method which waits for a specified time for all tasks to finish.
* E.g.:
```java
ExecutorService service = null;
try {
    service = Executors.newSingleThreadExecutor();
    // tasks...
} finally {
    if(service!=null) service.shutdown();
}
if (service!=null) {
    service.awaitTermination(1, TimeUnit.MINUTES);
    // check if all tasks are finished:
    if(service.isTerminated())
        System.out.println("All tasks finished")l
    else
        System.out.println("At least one task is still running");
}
```


<hr>

## 🟥 7.2.5 Scheduling Tasks
* The `ScheduledExecutorService` is a subinterface of `ExecutorService` which lets you schedule a task which needs to be done repeatedly for some fixed interval
* We obtain an instance using the `Executors` factory class:
```java
ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
```
* We have the following methods for `ScheduledExecutorService`:
1) `schedule(Callable<V> callable, long delay, TimeUnit unit)` - executes the callable after the given delay - returns a `ScheduledFuture<V>`
2) `schedule(Runnable runnable, long delay, TimeUnit unit)` - executes the runnable after the given delay - returns a `ScheduledFuture<V>`
3) `scheduleAtFixedRate(Runnable runnable, long initialDelay, long period, TimeUnit unit)` - executes the runnable after the initial delay, and creates and executes the runnable every period value
4) `scheduleAtFixedDelay(Runnable runnable, long initialDelay, long delay, TimeUnit unit)` - executes the runnable after the initial delay, and commences the next runnable after the termination + delay value


<hr>

## 🟥 7.2.6 Increasing Concurrency with Pools
* A **thread pool** is a group of pre-instantiated threads which can be reused to perform some tasks
* We can create a thread pool using the following methods from Executors:
1) `newCachedThreadPool()` - Created a thrad pool which creates threads when needed but will also reuse old threads which are available
2) `newFixedThreadPool(n threads)` - Creates a thread pool, and only reuses a fixed amount of threads
3) `newFixedScheduledThreadPool(n threads)` - creates a thread pool whicvh can schedule commands to run after a given delay or period


### 🟡 Choosing a Pool size
