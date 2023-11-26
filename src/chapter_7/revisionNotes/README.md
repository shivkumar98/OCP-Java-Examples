<link href="../../styles.css" rel="stylesheet"></link>

# 📝 Chapter 7: Revision Notes

# 🧠 7.1 Introducing Threads
* A thread is the smallest unit of execution that can be scheduled by OS
* A task is a single unit of work performed by a thread
* A process is a group of threads executing in a shared environment, sharing the same memoery space and can communicate with each other.
* Single-threaded processes contain exactly one thread
* Multi-threaded processes have more than one thread

## 🟥 7.1.1 Distinguishing Thread Types
* A system thread is created by the JVM and runs in background of application, e.g. for garbage collection
* A user-defined thread is created by the developer, e.g. the main method is a user-defined thread but we can create more user-defined thrads
* Hence we call single-threaded applications ones which have only the main method.

<hr>

## 🟥 7.1.2 Understanding Thread Concurrency
* Concurrency is thte propertty of executing multtiple threads and processes at the same time
* Concurrency can benefit an application, even on single core CPUs
* OSs use a thread scheduler to determine which tthreads should be running currently.
* A thread priorty is a numeric value associated with a thread, which is to be used by the thread scheduler.

<hr>

## 🟥 7.1.3 Introducing Runnable
* `Runnable` is a functional interface which takes no arguments, does not throw checked exception and returns void,
:
```java
public interface Runnable {
    void run();
}
```
* Here are some examples:
```java
Runnable r = () ->  System.out.println("hello");
Runnable r2 = new Runnable() {
    public void run() {
        // TODO Auto-generated method stub
        
    }
};
Runnable r3 = () -> {int i=10; i++;};
Runnable r4 = () -> null; // COMPILER ERROR
```

<hr>

## 🟥 7.1.4 Creating a Thread
* You can instantiate the `Thread` class in order to complete a task
* You can execute a task by either:
1) Padding in a Runnable lambda/ohject
2) Create a class which extends Thread, and implement run() method

```java
Thread thr = new Thread(()->System.out.println("hello"));
thr.run(); // hello
```

```java
public class Printer extends Thread {
    public void run() {
        for(int i=0;i<3;i++) System.out.print(i+" ");
    }
    public static void main() {
        (new Printer()).start(); // 0 1 2
    }
}
```

* The order in which results of a thread are not guaranteed

<hr>

## 🟥 7.1.5 Polling with Sleep
* Polling is the process of checking data intermittently at some fixed interval
* The `Thread.sleep()` method is used to implement polling.
* This method throws `InterruptedException`
* E.g.:
```java
public class CheckResults {
    static long counter = 0L;
    static long limit = 1_000_000_000L;;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for(long i=0;i<limit;i++) CheckResults.counter++;
        }).start();
        while(counter<limit) {
            System.out.println(counter+" not reached yet");
            Thread.sleep(1); // 1ms
        }
        System.out.println(counter+" reached!");
    }
}
```
* This prints the following:
```
0 not reached yet
55480739 not reached yet
202760739 not reached yet
350824739 not reached yet
473640739 not reached yet
559944739 not reached yet
707944739 not reached yet
847736739 not reached yet
1000000000 reached!
```

<br><hr>

# 🧠 7.2 Creating Threads with the `ExecutorService`
* The `ExecutorService` creates and managed threads for you

## 🟥 7.2.1 Introducing the Single-Thread Executor
* The `Executors` is a factory class to obtain instances of ExeuctorServices
* Here is how to get a single threaded thread executor:
```java
ExecutorService service = null;
try {
    service = Executors.newSingleThreadExecutor();
    service.execute(
        () -> System.out.println("Began printing zoo")
    );
    service.execute(
        () -> {for(int i=0;i<3++;i++)
            System.out.println("Printing record: "+i);}
    );
    service.execute(
        () -> System.out.println("Finished printing zoo");
    )
} finally {
    if(service!=null) service.shutdown();
}
```
* The results do not have a guaranteed order:
```
Began printing zoo
Printing record: 0
Finished printing zoo
Printing record: 1
Printing record: 2
```
* If we do not shutdown the ExecutorService, the program will not terminate!

<hr>

## 🟥 7.2.2 Shutting Down a Thread Executor
* It is essential to call `shutdown()` on a thread executor, otherwise the application will never terminate
* A daemon thread is a background thread which can continue running even when application terminates
* A thread executor creates a NON-DAEMON thread!
* There are 3 stages of the ExecutorService lifecycle:
1) `Create new thread executor`
- Accepts and executes new tasks
2) `Shutting down`
- Rejects new tasks
- Still continues to executes tasks
- `isShutdown() = true`
3) `Shutdown`
- This is when all tasks are finished
- No running tasks
- `isTerminated() = true`
<br>

* `shutdownNow()` returns a `List<Runnable>` os taskks which were submitted but never started

<hr>

## 🟥 7.2.3 Submitting Tasks
### 🟡 ExecutorService Methods
* We have 5 different methods for ExecutorService:
1) `void execute(Runnable command)`
```java
Runnable r = () -> System.out.println("runnable");
sevice.execute(r); // prints runnable
```
2) `Future<?> submit(Runnable task)`
```java
Runnable r = () -> System.out.println("runnable");
Future<?> f1 = sevice.submit(r); // prints runnable
System.out.println(f1.get()); // prints null
```
3) `<T> Future<?> submit(Callable<T> task)`
```java
Callable<Integer> c = () -> 1;
Future<?> f1 = sevice.submit(r);
System.out.println(f1.get()); // prints 1
```
4) `<T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)`
- This method will wait indefinitely until all tasks are complete
```java
Callable<Integer> c = () -> 1;
List<Callable<Integer>> list = Arrays.asList(c, c);
List<Future<Integer>> f3 = service.invokeAll(list);
System.out.println(f3.get(0).get()); // 1
System.out.println(f3.get(1).get()); // 1
```
5) `<T> T invokeAny(Collection<? extends Callable<T>> tasks)`
- This method will execute the tasks asynchrously, returning the result of one of them and cancelling any unfinished tasks
```java
Callable<Integer> c1 = () -> 1;
Callable<Integer> c2 = () -> 2;
List<Callable<Integer>> list2 = Arrays.asList(c2, c2);
Integer x = service.invokeAny(list2);
System.out.println(x); // prints either 1 or 2
```

<hr>

## 🟥 7.2.4 Waiting For Results
* A `Future` object is returned when calling `submit`. E.g.:
```java
Future<?> future = service.submit(() -> System.out.println("Hello Zoo"));
```
### 🟡 Future Methods
1) `boolean isDone()` - if the task is completed, throws an exception, or is cancelled, then returns true
2) `boolean isCancelled()` - if the task was cancelled before completing normally, then returns true
3) `boolean cancel()` - attempt to cancel execution of task
4) `V get()` - retrieves result of task
5) `V get(long timeout, TimeUnit unit)` - waits the specified amount of time to retrieve the result. Throws `TimeoutException` if out of time

<br>

* Here is the counter example which uses a Future object to poll for the results:
```java
public class CheckResultsV2 {
    private static long counter = 0;
    static long limit = 1_000_000_000L;
    public static void main(String[] args) {
        ExuctorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for(long i=0;i<limit;i++) counter++;
            });
            result.get(100, TimeUnit.MILLISECONDS);
            System.out.println(counter+" limit reached");   
        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if(service!=null) service.shutdown();
        }
    }
}
```
* If the for loop has finished within the 100ms limit, then it will print:
```java
1000000000 limit reached
```
* If the task does not complete in time, then it will print the following for example:
```java
7367732825 not reached in time
```

<br>

### 🟡 Introducing Callable
* The `Callable` is a functional defined as:
```java
public interface Callable<V> {
    V call() throws Exception;
}
```
* Here is an example of using Callable:
```java
public class AddData {
    public static void main(String[] args) throws InterruptedException,
        ExecutionException {
            ExecutorService service = null;
            try {
                service = Executors.newSingleThreadExecutor();
                Future<Integer> result = 
                    service.submit(()->30+11);
                System.out.println(result.get()); // 41
            } finally {
                if(service!=null) service.shutdown();
            }
        }
}
```
* Since Callable throws a checked exception, it means we can write lambdas with code which throws checkeed exceptions without try/catch:
```java
service.submit(()-> {Thread.sleep(1000); return null; });
service.submit(()-> {Thread.sleep(1000); }); // COMPILER ERROR
```

<br>

### 🟡 Waiting for All Tasks to Finish
* Suppose we do not need the results of the tasks and are finished with using the thread executor, then we can used `awaitTermination(long timeout, TimeUnit unit)`. 
* This method waits for the specified amount of time to complete all tasks
* E.g.:
```java
ExecutorService service = null;
try {
    service = Executors.newSingleThreadExecutor();
    // tasks for thread executor
} finally {
    if(service != null) service.shutdown();
}
if(service != null) {
    service.awaitTerminated(1, TimeUnit.MINUTES);
    // check if all tasks are finished
    if (service.shutdown())
        System.out.println("All tasks finished");
    else
        System.out.println("At least one task is still running");
}
```

<hr>

## 🟥 7.2.5 Scheduling Tasks
* The `ScheduledExecutorService` class is used to schedule tasks with delays repeatedly
* We again use the `Executors` factory class to obtain an instance:
```java
ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
```

### 🟡 ScheduledExecutorService methods
1) `schedule(Callable<V> callable, long delay, TimeUnit unit)` 
2) `schedule(Runnable command, long delay, TimeUnit unit)`
```java
ScheduledExecutorService service
        = Executors.newSingleThreadScheduledExecutor();
Future<?> f = service.schedule(()->{
    System.out.println("hello world");
}, 10, TimeUnit.SECONDS);
// prints hello world after 10s
```
3) `scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit)`
4) `scheduleAtFixedDelay(Runnable command, long delay, TimeUnit unit)`


## 🟥 7.2.6 Increasing Concurrency with Pools



<br><hr>

# 🧠 7.3 Synchronizing Data Access

## 🟥 7.3.1 Protecting Data with Atomic Classes

## 🟥 7.3.2 Improving Access with Synchronized Blocks



<br><hr>

# 🧠 7.4 Using Concurrent Collections

## 🟥 7.4.1 Introducing Concurrent Collections

## 🟥 7.4.2 Understanding Memory Consistency Errors

## 🟥 7.4.3 Working with Concurrent Classes

## 🟥 7.4.4 Obtaining Synchronized Collections



<br><hr>

# 🧠 7.5 Working with Parallel Streams

## 🟥 7.5.1 Creating Parallel Streams

## 🟥 7.5.2 Processing Tasks in Parallel

## 🟥 7.5.3 Processing Parallel Reductions



<br><hr>

# 🧠 7.6 Managing Concurrent Processes

## 🟥 7.6.1 Creating a CyclicBarrier

## 🟥 7.6.2 Applying the Fork/Join Framework




<br><hr>

# 🧠 7.7 Identifying Threading Problems

<br><hr>

## 🟥 7.7.1 Understanding Liveness

## 🟥 7.7.2 Managing Race Conditions
