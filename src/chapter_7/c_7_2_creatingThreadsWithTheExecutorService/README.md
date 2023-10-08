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
* The `end` being printed is due to the `main()` method 