<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 7.2 Creating Threads with the `ExecutorService`

* Java introduced `ExecutorService` with the `Concurrency API`, this service creates/manages threads for you.
* You first obtain an instance of `ExecutorService` interface, and then send the service task to be processed.
* This framework consists of thread pooling and scheduling features.

<hr>

## 🟥 7.2.1 Introducing the Single-Thread Executor
* We can obtain an instance of the `ExecutorService` using the `Executors` factory class.
* Here is an example using `newSingleThreadExecutor()`:
```java
import java.util.concurrent.*;

public class ZooInfo {
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            service.execute(() -> System.out.println("Printing zoo inventory"));
            service.execute(() -> {for(int i=0;i<3;i++)
                System.out.println("Printing record: "+i);}
            );
            service.execute(() -> System.out.println("Printing zoo inventory"));
            System.out.println("end");
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
```
* In this example, we only use one thread. Here is a possible output for this code snippet:
```
begin
Printing zoo inventory
Printing record: 0
Printing record: 1
end
Printing record: 2
Printing zoo inventory
```
* The operations run in the order that they are called
* The `end` being printed is due to the `main()` method having its own thread.

<hr>

## 🟥 7.2.2 Shutting Down a Thread Executor
* Once you are finished using a thread executor, it is important to call the `shutdown()` method.
* Using thread executor, we create a `non-daemon` thread on the first task which is executed. Failing to call `shutdown()` will result in your application never terminating.
* The shutdown process for a thread executor involves first rejecting any new tasks submitted to the thread executor while continuing to execute any previous submitted tasks.
* During this time, calling `isShutdown()` will return true and `isTerminated()` will return false.
* If a new task is submiutted while thread executor is shutting down, a `RejectedExecutionException` is thrown.
* Once all active tasks have been completed, `isShutdown()` and `isTerminated()` will both return true.
* The `ExecutorService` life cycle looks like:
```          shutdown()                       All Tasks Finished
|Active| ---------------->  |Shutting Down| ---------------------> |Shutdown|
Accepts new tasks           Rejects new tasks                      Rejects new tasks
Executes tasks              Executes tasks                         No tasks running
isShutdown() = false        isShutdown() = true                    isShutdown()=true
isTerminated() = false      isTerminated() = false                 isTerminated()=true
```

* For the exam, I need to be aware that `shutdown()` does not stop any tasks which have already been SUBMITTED
* The `ExecutorService` provides a `shutdownNow()` method which ATTEMPTS to stop all running tasks and discards any which have not started yet.
* This method returns a `List<Runnable>` of tasks which were submitteed to the thread executor but were never started.

### 🟡 Finally Shutting Down a Thread Executor
* ExecutorService does NOT implement `AutoCloseable`, so you can not use a try-with-resources statement. You can use a `finally` block which is not required but considered good practice:
```java
ExecutorService service = null;
try {
    service = Executors.newSingleThreadExecutor();
    // Add tasks to thread executor
} finally {
    if(service!=null) service.shutdown();
}
```


<hr>

## 🟥 7.2.3 Submitting Tasks
* You can submit tasks to an ExecutorService in multiple ways
* The first way is to use `execute()` which is inherited from the `Executor` interface (ExecutorService extends Execute)
    - The `execute()` method takes a `Runnable` lambda expression or instance which completes the task asynchrously
    - This is a **fire-and-forget** type use as the results are not readily available
* The ExecutorService also has a `submit()` method whichh can also do tasks asynchrously, it returns a `Future` object which can determine if the task is complete.

### 🟡 execute() vs submit()
* The submit() does the same thing as execute() but returns an object which can be used to track the result.
* It is recommended to use `submit()` over `execute()`, which shall be used for the rest of this chapter.


### 🟡 Submitting Task Collections
* The `invokeAll()` and `invokeAny()` take a `Collection` object which contains a list of tasks to execute.
* Both of these methods execute synchrously - the program will wait for the results before returning control to enclosing program.
* The `invokeAll()` method executes a collections of tasks and returns a `List` of ordered `Future` objects and `Future.isDone()` returns true for all the items.
* The `invokeAny()` method executes a collections of tasks, and returns the result of one of the tasks which succesfully completed execution (unfinished tasks get cancelled). The result is not guranteed!
* The `ExecutorService` interface includes overloaded versions of these methods which takes a timeout value and `TimeUnit` parameter.

<hr>

## 🟥 7.2.4 Waiting For Results
* The `submit()` method returns a `java.util.concurrent.Future<V>`:
```java
Future<?> future = service.submit(() -> System.out.println("Hello Zoo"));
```
* The `Future` class has the following methods:
1) `boolean isDone()` - returns if the task is completed, threw exception or cancelled
2) `boolean isCancelled()` - returns true if the task is cancelled before finishing normally
3) `boolean cancel()` - attempts to cancel execution of the task
4) `V get()` - returns result of task, waits endlessly if not yet available
5) `V get(long timeout, TimeUnit unit)` - retrieves result of task, waiting the timeout. If result is not ready after timeout, a checked `TimeoutException` is thrown

* Here's the example of the polling example using submit:
```java
import java.util.concurrent.*;
public class CheckResults {
    private static int counter = 0;
    public static void main() throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for(int i=0; i<500; i++) CheckResults.counter++;
            });
            results.get(10, TimeUnit.SECONDS);
            System.out.println("Reached");
        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
```
* Instead of doing complex things with Threads directly, the Concurrency API enables us to do it through a more simple interface. It waits at most for 10s, or throws a TimeoutException if the task is not done.


### 🟡 Introducing Callable
* When the Concurrency API was release in Java 5, it introduced the `java.util.concurrent.Callable` interface. It is similar to `Runnable` except it has a `call()` method which returns a value and can throw a checked exception.
* Callable is a functional interface defined as:
```java
@FunctionalInterface public interface Callable<V> {
    V call() throws Exception;
}
```
* `ExecutorService` has an overloaded `submit()` method which takes a `Callable` object and returns a generic `Future<T>` object.
* Calling the get() method on Future does NOT ALWAYS rturn null, it CAN return a generic type

### 🟡 Ambigious Lambda Expressions: Callable vs Supplier
* Callable is very similar to `Supplier` as it takes no arguments and returns a generic type
* A difference is that Callable can throw aa checked exception
* This makes telling lambda expressions apart is difficult
* Consider the example which uses the same lambda expression for three different method calls:
```java
public class AmbigouosLambdaSample {
    public static void useCallable(Callable<Integer> expression){}
    public static void useSupplier(Supplier<Integer> expression){}

    public static void use(Supplier<Integer> expression) {}
    public static void use(Callable<Integer> expression) {}
    public static void main() {
        useCallable(() -> {throw new IOException();});
        useSupplier(() -> {throw new IOException();}); // COMPILER ERROR
        use(() ->{throw new IOException();}); // COMPILER ERROR
    }
}
```
* The second line clearly does not compile, as supplier does not throw checked exceptions!
* For the last line, the compiler does not take the body of the lambda expression into account. As a result it can not tell if it is a Supplier or Callable
* This is called **ambigious lambda expression**
* We can resolve this compiler error by using an explicit cast:
```java
use((Callable<Integer>)() -> {throw new IOException("");});
```
* Here is an example of using `Callable`:
```java
import java.util.concurrent.*;

public class AddData {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = null;
	    try {
	        service = Executors.newSingleThreadExecutor();
	        Future<Integer> result = service.submit(() -> 30+11);
	        System.out.println(result.get()); // 41
	    } finally {
	        if(service != null) service.shutdown();
	    }
    }
}
```
* The Callable interface supports a return type when using ExecutorService.

### 🟡 Waiting for All Tasks to Finish

* After submitting a set of tasks to the thread executor, it is common to wait for the results; we can call `.get()` on each Future object returned by submit.
* If do not need results of the tasks and are finished with the thread executor we can shutdown the thread using `shutdown()` and use `awaitTermination(long timeout, TimeUnit unit)` which waits for all tasks to finish in allotted time, and returns sooner if all tasks finish or InterruptedException is detected.
```java
ExecutorService service = null;
try {
    service = Executor.newSingleThreadExecutor();
    // add tasks to the thread executor
} finally {
    if(service != null) service.shutdown();
}
if (service != null) {
    service.awaitTermination(1, TimeUnit.MINUTES)s;
    // check if all tasks are finished:
    if(service.isTerminated())
        System.out.println("All tasks finished");
    else
        System.out.println("At least one task is still running");
}
```


<hr>

## 🟥 7.2.5 Scheduling Tasks
* The `ScheduledExecutorService` is a subinterface of `ExecutorService`. We can use an instance of this class to schedule a task which needs to happen repeatedly for a given interval.
* We can get an instance via a factory method:
```java
ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
```
* The `ScheduledExecutorService` has the following methods:
1) `schedule(Callable<V> callable, long delay, TimeUnit unit)` - creates and executes a Callable task after the given delay
2) `schedule(Runnable command, long delay, TimeUnit unit)` - creates and executes a Runnable task after the given delay
3) `scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)` - creates a new task after initial delay, and new tasks after each period delay
4) `scheduleAtFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)` - creates a new task after initial delay, and commences new task after termination of previous task + period delay

* Here is an example of using the `schedule()` method:
```java
ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
Runnable task1 = () -> System.out.println("Hello Zoo");
Callable<String> task2 = () -> "Monkey";

Future<?> result1 = service.schedule(task1, 10, TimeUnit.SECONDS);
Future<?> result2 = service.schedule(task2, 8, TimeUnit.SECONDS);
```

<hr>

## 🟥 7.2.6 Increasing Concurrency with Pools
* So far we have only instantiated single thread executors. We shall now look at thread pools which will allow us to do more concurrent tasks.
* A **thread pool** is a group of pre-instantiated threads which are available to perform any number of tasks.
* Here are some methods from the `Executors` class:
1) `newSingleThreadExecutor()` - returns `ExecutorService`. Creates a single-threaded executor operating off an unbounded queue. Results are processed in order they're submitted
2) `newSingleThreadScheduledExecutor()` - returns `ScheduledExecutorService`. Creates a single-threaded executor which can schedule commands after delay/period
3) `newCachedThreadPool()` - returns `ExecutorService`. Creates a thread pool which can create new threads as needed (able to resue available threads)
4) `newFixedThreadPool(int nThreads)` - returns `ExecutorService`. Creates a thread pool which resuses a fixed number of threads
5) `newScheduledThreadPool(int nThreads)` - returns `ScheduledExecutorService`. Creates a\ thread pool that can schedule commands to run after a given delay/period

* A single thread executor will wait for the thread to become available before running next task. A pooled thread executor can run tasks concurrently. If the pool is out of threads, the task will be queued by the thread executor.

* The `newCachedThreadPool()` will created an unbounded thread pool, allocating new threads whenever required. This is strongly discouraged, but can be used for short-lived asynchrous tasks
* The `newFixedThreadPool()` will bound the number of threads. If the number of tasks < nThreads, all tasks will execute concurrently.
* The `newScheduledThreadPool()` is identical to the above but returns an instance of `ScheduledExecutorService()`.

### 🟡 Choosing a Pool size
* You generally want a handful more threads than you could possibly ever need.
