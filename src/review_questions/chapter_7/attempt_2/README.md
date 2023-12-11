<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 7: Review Questions - Attempt 2

## Results:

Date: 
Score:
✅  ❌ 
| Question # | Correct |
| ---------- | ------- |
| 1          |       |
| 2          |       |
| 3          |       |
| 4          |       |
| 5          |       |
| 6          |       |
| 7          |       |
| 8          |       |
| 9          |       |
| 10         |       |
| 11         |       |
| 12         |       |
| 13         |       |
| 14         |       |
| 15         |       |
| 16         |       |
| 17         |       |
| 18         |       |
| 19         |       |
| 20         |       |
| 21         |       |
| 22         |       |

<hr>

## Question 1
❓ Given an instance of a Stream s, and a Collection c, which are valid ways of creating a parallel stream? (Choose all that apply) ❓

A. `new ParallelStream(s)` <br>
B. `c.parallel()` <br>
C. `s.parallelStream()`  <br>
D. `c.parallelStream()` <br>
E. `new ParallelStream(c)`  <br>
F. `s.parallel()` <br>
❓

### My answer:
* A - false
* B - false, needs to be converted to stream first
* C - false, not a method available to stream
* D - true
* E - false
* F - true
* **D,F**
<hr>

## Question 2:
❓ Which of the following statements abolut the `Callable call()` and `Runnable run()` methods are correct? (Choose all that apply) ❓

A. Both can throw unchecked exceptions <br>
B. Callable takes a generic method argument <br>
C. Callable can throw a checked exception <br>
D. Both can be implemented with lambda expressions <br>
E. Runnable returns a generic type <br>
F. Callable returns a generic type <br>
G. Both methods return void <br>
❓

### My answer:
* Only one can throw a checked exception. so A is false
* Call returns an argument, while run returns nothing. Neither accepts arguments. So B is wrong and E is wrong, and G is wrong
* C is false, I think
* D is correct, F is correct
* **D,,F**

<hr>

## Question 3
❓ Which lines need to be changed to make the code compile? (Choose all that apply) ❓

```java
ExecutorService service = Executors.newSingleThreadScheduleExecutor();
service.scheduleWithFixedDelay(() -> { // w1
    System.out.println("Open Zoo");
    return null; // w2
}, 0, 1, TimeUnit.MINUTES);
Future<?> result = service.submit(() -> System.out.println("Wake staff")); // w3
System.out.println(result.get()); // w4
```

A. It compiles and runs without issue <br>
B. Line w1 <br>
C. Line w2 <br>
D. Line w3 <br>
E. Line w4 <br>
F. It compiiles but throws an exception at runtime <br>
❓

### My answer:
* You can not return something with scheduled executors!
* w3 is potentially wrong but i dont remember
* **C, D**


<hr>

## Question 4:
❓ What statement about the following code is true? ❓
```java
AtomicLong value1 = new AtomicLong(0);
final long[] value2 = {0};
IntStream.iterate(1, i -> 1).limit(100).parallel()
    .forEach(i -> value1.incrementAndGet());
IntStream.iterate(1, i -> 1).limit(100).parallel()
    .forEach(i -> ++value2[0]);
System.out.println(value1+"  "+value2[0])
```

A. It outputs 100 100 <br>
B. It outputs 100 99 <br>
C. The output cannot be determined ahead of time <br>
D. The code does not compile <br>
E. It compiles but throws an exception at runtime <br>
F. It compiles but enters an infinite loop at runtime <br>
❓

### My answer:
* **C**
<hr>

## Question 5
❓ Fill in the blanks: ________ occur(s) when two or more threads are blocked forever but both appear active. _________ occur(s) when two or more threads try to complete a related task at the same time ❓

A. Livelock, Deadlock <br>
B. Deadlock, Starvation <br>
C. Race conditions, Deadlock <br>
D. Livelock, Race conditions <br>
E. Starvation, Race conditions <br>
F. Deadlock, Livelock <br>
❓

### My answer:
* The second is race condition
* **D**
<hr>

## Question 6
❓ Which happens when more tasks are submitted to a thread executor than available threads? ❓

A. The thread executor will throw an exception when a task is submitted that is over its thread limit <br>
B. The task will be added to an internal queue and completed when there is an available thread <br>
C. The thread executor will discard any task over its thread limit <br>
D. The call to submit the task to the thread executor will wait until there is a thread available before continuing. <br>
E. The call to submit the task to the thread executor will wait until there is a thread available before continuing <br>
❓

### My answer:
* **B**
<hr>

## Question 7
❓ What is the result of executing the following code snippet? ❓

```java
List<Integer> l1 = Arrays.asList(1,2,3);
List<Integer> l2 = new CopyOnWriteArrayList<>(l1);
Set<Integer> s3 = new ConcurrentSkipListSet<>();
s3.addAll(l1);

for(Integer item: l2) l2.add(4); // x1
for(Integer item: s3) s3.add(5); // x2
System.out.println(l1.size()+" "+l2.side()+" "+s3.size());
```

A. It outputs `3 6 4` <br>
B. It outputs `6 6 6` <br>
C. It outputs `6 3 4` <br>
D. The code does not compile <br>
E. It compiles but throws an exception at runtime on line x1 <br>
F. It compiles but throws an exception at runtime on line x2 <br>
G. It compiles but enters an infinite loop at runtime <br>

❓

### My answer:
* l2 will have 3 additionaly elements, its size will be 6
* s3 is a set, so it will have size 4
* l1 has a fixed size of 3
* **A**
<hr>

## Question 8:
❓ What statements about the following code are true? (Choose all that apply) ❓

```java
Integer i1 = Arrays.asList(1,2,3,4,5).stream().findAny().get();
synchronized(i1) { // y1
    Integer i2 = Arrays.asList(6,7,8,9,10)
        .parallelStream()
        .sorted() // y2
        .findAny().get(); // y3
    System.out.println(i1+" "+i2);
}
```

A. It outputs `1 6` <br>
B. It outputs `1 10` <br>
C. The code will not compile because of line y1 <br>
D. The code will not compile because of line y2 <br>
E. The code will not compile because of line y3 <br>
F. It compiles but throws an exception at runtime <br>
G. The output cannot be determined ahead of time <br>
H. It compiles but waits forever at runtime <br>

❓

### My answer:
* I don't think it can be determined ahead of time
* The lock is on i1
* Calling sorted on parallel stream does not guarantee result
* **G**

<hr>
 
## Question 9
❓ Assuming MyTask is an abstract class that implements the ForkJoinTask interface, what statements about the following code are true? (Choose all that apply) ❓

```java
import java.util.concurrent.*;
public class FindMin extends MyTask {
    private Integer[] elements;
    private int a;
    private int b;
    public FindMin(Integer[], int a, int b) {
        this.elements = elements;
        this.a = a;
        this.b = b;
    }
    public Integer compute() {
        if ((b-a) < 2)
            return Math.min(elements[a], elements[b]);
        else {
            int m = a + ((b-a)/2);
            System.out.println(a + "," + m + "," + b);
            MyTask t1 = new FindMin(elements, a, m);
            int result = t1.fork().join();
            return Math.min(new FindMin(elements, m, b).compute(), result);
        }
    }

    public static void main(String[] args) throws InterruptedException,
        ExecutionException {
            Integer[] elements = new Integer[] { 8, -3, 2, -54 };
            MyTask task = new FindMin(elements, 0, elements.length-1);
            ForkJoinPool pool = new ForkJoinPool(1);
            Integer sum = pool.invoke(task);
            System.out.println("Min: "+sum);
        }
}
```


A. The correctly finds the minimum value in the array <br>
B. MyTask inherits RecursiveAction <br>
C. MyTask inherits RecursiveTask <br>
D. The code produces a ForkJoinPool at runtime <br>
E. The class produces single-threaded performance at runtime <br>
F. The code does not compile <br>
❓

### My answer:
* **A,C,E**

<hr>

## Question 10
❓ What statements about the following code are true? (Choose all that apply) ❓
```java
System.out.println(Arrays.asList("duck","chicken","flamingo","pelican")
    .parallelStream().parallel() // q1
    .reduce(0,
        (c1, c2) -> c1.length() + c2.length(), // q2
        (s1, s2) -> s1 + s2)); // q3
```

A. It compiles and runs without issue, outputting the total length of all the strings in the stream <br>
B. The code will not compile because of line q1 <br>
C. The code will not compile because of line q2 <br>
D. The code will not compile because of line q3 <br>
E. It compiles but throws an exception at runtime <br>
❓

### My answer:
* **A**
<hr>

## Question 11
❓ What statements about the following code snippet are true (Choose all that apply) ❓

```java
Object o1 = new Object();
Object o2 = new Object();
ExecutorService service = Executors.newFixedThreadPool(2);
Future<?> f1 = service.submit(() -> {
    synchronized (o1) {
        synchronized(o2) { System.out.println("Tortoise"); } // t1
    }
});
Future<?> f2 = service.submit(() -> {
    synchronized (o2) {
        synchronized (o1) { System.out.println("Hare"); } // t2
    }
});
f1.get();
f2.get();
```

A. If the code does output anything, the order cannot be determined <br>
B. The code will always output Tortoise followed by Hare <br>
C. The code will always output Hare followed by Tortoise <br>
D. The code does not compile because of line t1 <br>
E. The code does not compile because of line t2 <br>
F. The code may produce a deadlock at runtime <br>
❓

### My answer:
* Whatever task is started first will determine what is outputted
* **A**
<hr>

## Question 12:
❓ What is the result of executing the following application? (Choose all that apply)❓

```java
import java.util.concurrent.*;
public class CountNumbers extends RecursiveAction {
    private int start;
    private int end;
    public CountNumbers(int start, int end) {
        this.start = start;
        this.end = end;
    }
    protected void compute() {
        if (start<0) return;
        else {
            int middle = start + ((end-start)/2);
            invokeAll(new CountNumbers(start, middle), new CountNumbers(middle, end)); // m1
        }
    }
    public static void main(String[] args) {
        ForkJoinTask<?> task = new CountNumbers(0, 4); // m2
        ForkJoinPool pool = new ForkJoinPool();
        Object result = pool.invoke(task); // m3
    }
}
```
A. It compiles and runs without issue <br>
B. The code will not compile because of `m1` <br>
C. The code will not compile because of `m2` <br>
D. The code will not compile because of `m3` <br>
E. It compiles but throws an exception at runtime <br>
F. It compiles but hangs at runtime <br>
❓

### My answer:
* The base case can never be reached!
* **F**
<hr>

## Question 13
❓ What statements about the following code snippet are true? (Choose all that apply) ❓

```java
4: Stream<String> cats = Stream.of("leopard","lynx","ocelot","puma"). parallel();
5: Stream<String> bears = Stream.of("panda","grizzly","polar").parallel();
6: ConcurrentMap<Boolean, List<String>> data = Stream.of(cats,bears)
7:     .flatMap(s -> s)
8:     .collect(Collectors.groupingByConcurrent(s -> !s.startsWith4: ("p")));
9: System.out.println(data.get(false).size()+" "+data.get(true).size());
```

A. It outputs 3 4 <br>
B. It outputs 4 3 <br>
C. The code will not compile because of line 6 <br>
D. The code will not compile because of line 7 <br>
E. The code will not compile because of line 8 <br>
F. It compiles but throws an exception at runtime <br>
G. The `collect()` operation is always executed in a single-threaded fashion
❓

### My answer:
* **B**
<hr>

## Question 14:
❓ What is thr result of the followsing method ❓

```java
3: public void addAndPrintItems(BlockingDeque<Integer> deque) {
4:     deque.offer(103);
5:     deque.offerFirst(20, 1, TimeUnitSeconds);
6:     deque.offerLast(85, 7, TimeUnit.HOURS);
7:     System.out.print(deque.pollFirst(200, TimeUnit.NANOSECONDS));
8:     System.out.print(" "+deque.pollLast(1, TimeUnit.MINUTES));
9: }
```

A. It outputs 20 85 <br>
B. It outputs 103 <br>
C. It outputs 20 103 <br>
D. The code will not compile <br>
E. It compiles but throws an exception at runtime <br>
F. The output cannot be determined ahead of time <br>
❓

### My answer:
* **F**
<hr>

## Question 15
❓ Which of the following are valid `Callable` expressions? (Choose all that apply) ❓

A. `a -> {return 10;}` <br>
B. `() -> {String s = "";}` <br>
C. `() -> 5` <br>
D. `() -> {return null}` <br>
E. `() -> "The" + "Zoo"` <br>
F. `(int count) -> count+1` <br>
G. `() -> {System.out.println("Giraffe"); return 10;}` <br>
❓

### My answer:
* A - true
* B - false
* C - true
* D - true
* E - true
* F - false
* G - true
* **A,C,D,E,G**
<hr>

## Question 16
❓ What us the result of executing the following application? (Choose all that apply) ❓
```java
import java.util.concurrent.*;
import java.util.stream.*;
public class PrintConstants {
    public static void main(String[] args) {
        ExecutorService service = Executors.newScheduledThreadPool(10);
        DoubleStream.of(3.14159, 2.71828) // b1
            .forEach(c -> service.submit( // b2
                () -> System.out.println(10*c)));  // b3
        service.execute(() -> System.out.println("Printed")); // b4
    }
}
```

A. It compiles and outputs the two numbers, followed by `Printed` <br>
B. The code will not compile because of line b1 <br>
C. The code will not compile because of line b2 <br>
D. The code will not compile because of line b3 <br>
E. The code will not compile because of line b4 <br>
F. It compiles but the output cannot be determined ahead of time <br>
G. It compiles but throws an exception at runtime <br>
H. It compiles but waits forever at runtime <br>
❓

### My answer:
* Idk lol
* **C**
<hr>   

## Question 17
❓ Assuming 100 milliseconds is enough time for tasks submitted to the thread executor to complete, what is the result of executing the following program? (Choose all that apply) ❓

```java
import java.util.concurrent.*;
public class SheepManager {
    private static AtomicInteger sheepCount1 = new AtomicInteger(0); // w1
    private static int sheepCount2 = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor(); // w2
            for (int i=0; i<100; i++)
                service.execute(() ->
                    {sheepCount1.getAndIncrement(); sheepCount2++;}); // w3
            Thread.sleep(100);
            System.out.println(sheepCount1+" "+sheepCount2);
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
```

A. It outputs `100 99` <br>
B. It outputs `100 100` <br>
C. The output cannot be determined ahead of time <br>
D. The code will not compile because of line w1 <br>
E. The code will not compile because of line w2 <br>
F. The code will not compile because of line w3 <br>
G. It compiles but throws an exception at runtime <br>
❓

### My answer:
* It's a single threaderd process
* **B**
<hr>

## Question 18
❓ What is the result of executing the following application? (Choose all that apply) ❓
```java
import java.util.concurrent.*;
import java.util.stream.*;
public class StockRoomTracker {
    public static void await(CyclicBarrier cb) { // j1
        try { cb.await(); } catch (InterruptedException |
            BrokenBarrierException e) {
            // Handle exception
        }
    }
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(10,
            () -> System.out.println("Stock Room Full!")); // j2
        IntStream.iterate(1, i -> 1).limit(9)
            .parallel().forEach(i -> await(cb)); // j3
    }
}
```

A. It outputs Stock Room Full! <br>
B. The code will not compile because of line `j1` <br>
C. The code will not compile because of line `j2` <br>
D. The code will not compile because of line `j3` <br>
E. It compiles but throws an exception at runtime <br>
F. It compiles but waits forever at run time <br>
❓

### My answer:
* j1 is fine as it is handled in code
* j2 is fine also
* j3 is fine
* limit is never reached so it ends up waiting forever
* **F**
<hr>

## Question 19
❓ What statements about the following class definition are true? (Choose all that apply) ❓
```java
public class TicketManager {
    private TicketManager() { super(); }
    private static TicketManager instance;
    public static synchronized TicketManager getInstance() { // k1
        if (instance == null) instance = new TicketManager(); // k2
        return instance;
    }

    private int tickets;
    public int getTicketCount() { return tickets; }
    public void makeTicketsAvailable (int value) { tickets += value; } // k3
    public void sellTickets(int value) {
        synchronized (this) { // k4
            tickets -= value;
        }
    }
}
```

A. It compiles without issue <br>
B. The code will not compile because of line k2 <br>
C. The code will not compile because of line k3 <br>
D. The locks acquired on k1 and k4 are the same object <br>
E. The class correctly prevents concurrency issues for the value of `tickets` when accessed by multiple threads <br>
F. At most one instance of `TicketManager` will be created in the application <br>
❓

### My answer:
* A - true
* B,C - false
* D - false
* E - false
* F - true
* **A,F**

<hr>

## Question 20
❓ Which of the following properties of concurrency are true? (Choose all that apply) ❓

A. By itself, concurrency does not guarantee which task will be completed first <br>
B. Concurrency always improves the performance of an application <br>
C. Computers with a single processor do not benefit from concurrency <br>
D. Applications with many resource-heavy tasks tend to benefit more from concurrency than ones with CPU-intensive task <br>
E. Concurrent tasks do not share the same memory <br>
❓

### My answer:
* A - true
* B - false
* C - false
* D - true
* E - false
* **A,D**
<hr>

## Question 21
❓ Assuming an implementation of the `performCount()` method is provided prior to runtime, which of the following are possible results of executing the following application? (Choose all that apply) ❓

```java
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;
public class CountZooAnimals {
    public static Integer peformCount(int exhibitNumber) {
        // IMPLEMENTATION OMITTED
    }
    public static void printResults(Future<?> f) {
        try {
            System.out.println(f.get()); // o1
        } catch (Exception e) {
            System.out.println("Exception!");
        }
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        final List<Future<?>> results = new ArrayList<>();
        IntStream.range(0, 10)
            .forEach(i -> results.add(
                service.submit(() -> performCount(i)))); // o2
        results.stream().forEach(f -> printResults(f));
        service.shutdown();
    }
}
```

A. It outputs a number 10 times <br>
B. It outputs a Boolean value 10 times <br>
C. It outputs a null value 10 times <br>
D. It outputs Exception! 10 times <br>
E. It hangs indefinitely at runtime <br>
F. It throws an unhandled exception at runtime <br>
G. The code will not compile because of line o1 <br>
H. The code will not compile because of line o2 <br>
❓

### My answer:
* A - true
* B - false
* C - true
* D - true
* E - trye
* F - false
* **A,C,D,E**
<hr>


## Question 22
❓ What is the resultg of executing the following program? ❓
```java
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;
public class PrintCounter {
    static int counter = 0;
    public static void main(String[] args) throws InterruptedException,
        ExecutionException {
            ExecutorService service = Executors.newSingleThreadExecutor();
            List<Future<?>> results = new ArrayList<>();
            IntStream.iterate(0,i -> i+1).limit(5).forEach(
                i -> results.add(service.execute(() -> counter++)); // n1
            );
            for(Future<?> result : results) {
                System.out.println(result.get()+" "); // n2
            }
            service.shutdown();
        }
}
```

A. It prints `0 1 2 3 4` <br>
B. It prints `1 2 3 4 5` <br>
C. It prints `null null null null` <br>
D. It hangs indefinitely at runtime <br>
E. The output cannot be determined <br>
F. The code will not compile because of line n1 <br>
G. The code will not compile because of line n2 <br>
❓

### My answer:
* **F**
<hr>