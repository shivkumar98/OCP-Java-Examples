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

### 🟡 execute() vs submit()

### 🟡 Submitting Task Collections



<hr>

## 🟥 7.2.4 Waiting For Results

### 🟡 Introducing Callable

### 🟡 Ambigious Lambda Expressions: Callable vs Supplier

### 🟡 Waiting for All Tasks to Finish


<hr>

## 🟥 7.2.5 Scheduling Tasks


<hr>

## 🟥 7.2.6 Increasing Concurrency with Pools

### 🟡 Choosing a Pool size
