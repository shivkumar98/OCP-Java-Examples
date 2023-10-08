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