<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 7: Review Questions - Attempt 1

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


<hr>

## Question 1
❓ Given an instance of a Stream s, and a Collection c, which are valid ways of creating a parallel stream (Choose all that apply)❓

A. `new ParallelStream(s)` <br>
B. `c.parallel()` <br>
C. `s.parallelStream()` <br>
D. `c.parallelStream()` <br>
E. `new ParallelStream(c)` <br>
F. `s.parallel()` <br>
❓

### My answer:
* A - definitely false, there is no ParallelStream class
* B - invalid, only stream has `parallel()` method
* C - invalid, not a methd for streams
* D - possible, so I say yes
* E - invalid, same as A
* F - valid
* **D,F**

<hr>

## Question 2:

❓ Which of the following statements about the `Callable call()` and `Runnable run()` methods are correct? (choose all that apply)

A. Both can throw unchecked exceptions <br>
B. Callable takes a generic method argument <br>
C. Callable can throw a checked exception <br>
D. Both can be implemented with lambda expressions <br>
E. Runnable returns a generic type <br>
F. Callable returns a generic type <br>
G. Both methods return void <br>
❓

### My answer:
* A - yes!
* B - I don't think so
* C - I think so
* D - yes!
* E - I don't think so!
* F - no!
* G - yes!
* **A, D, F, G**

* 
<hr>

## Question 3
❓ Which lines need to be changed to make the code compile? (Choose all that apply)

```java
ExecutorService service = Executors.newSingleThreadScheduledExecutor();
servie.scheduleWithFixedDelay(() -> { // w1
    System.out.println("Open Zoo");
    return null; // w2
}, 0, 1, TimeUnit.MINUTES);
Future<?> result = service.submit(() -> System.out.println("Wake Staff")); // w3
System.out.println(result.get()); // w4
```

A. It compiles and runs without issue <br>
B. Line w1 <br>
C. Line w2 <br>
D. Line w3 <br>
E. Line w4 <br>
F. It compile but throws an exception at runtime <br>
❓

### My answer:
* I have NO idea
* **A**
<hr>

## Question 4:
❓Which statement about the following code is true?

```java
AtomicLong value1 = new AtomicLong(0);
final long[] value2 = {0};
IntStream.iterate(1, i -> 1).limit(100).parallel()
    .forEach(i -> value1.incrementAndGet());
IntStream.iterate(1, i -> 1).limit(100).parallel()
    .forEach(i -> ++value2[0]);
System.out.println(value1+" "+value2[0]);
```

A. It outputs `100 100` <br>
B. It outputs `100 99` <br>
C. The output cannot be determined ahead of time. <br>
D. The code does not compile <br>
E. It compiles but throws an exception at runtime <br>
F. It compiles but enters an infinite loop at runtime <br>

### My answer:
* I don't believe the output can be determined. We have a non thread safe counter for value2
* **C**
<hr>


## Question 5
❓ Fill in the blanks: __________ occur(s) when two or more threads are blocked forever but both appear active. ___________ occur(s) when two or more threads try to complete a related task at the same time.
❓
A. Livelock, Deadlock <br>
B. Deadlock, Starvation <br>
C. Race conditions, Deadlock <br>
D. Livelock, Race conditions <br>
E. Starvation, Race conditions <br>
F. Deadlock, Livelock <br>

### My answer:
* The first blank is livelock. The second has to be race conditions because it can't be deadlock
* **D**
<hr>

## Question 6
❓ Which happens when more tasks are submitted to a thread executor than available threads?

A. The thread executor will throw an exception with a task is submitted that is over its thread limitr <br>
B. The task will be added to an internal queue and completed when there is an available thread <br>
C. The thread executor weill discard any task over its thread limit <br>
D. The call to submit the task to the thread executor will wait unitl there is a thread available before continuing <br>
E. The thread executor creates new temporary threads to complete the additional tasks <br>
❓

### My answer:
* Total guess is that its B
* **B**
<hr>

## Question 7
❓ What is the result of executiong the following code snippet?
```java
List<Integer> l1 = Arrays.asList(1,2,3);
List<Integer> l2 = new CopyOnWriteArrayList<>(l1);
Set<Integer> s3 = new ConcurrentSkipListSet<>();
s3.addAll(l1);

for(Integer item:l2) l2.add(4); // x1
for(Integer item:s3) s3.add(5); // x2
System.out.println(l1.size()+" "+l2.size()+" "+s3.size());
```

A. It outputs `3 6 4` <br>
B. It outputs `6 6 6` <br>
C. It outputs `6 3 4` <br>
D. The code does not compile <br>
E. It compiles but throws an exception at runtime on line x1 <br>
F. It compiles but throws an exception at runtime on line x2 <br>
G. It compiles but enters an infinite loop at runtime

### My answer:
* 3 6 1
* None of the options seem applicable
* **A**
<hr>

## Question 8:
❓What statements about the following code are true? (Choose all that apply)

```java
Integer i1 = Arrays.asList(1,2,3,4,5).stream().findAny().get();
synchronized(i1) { // y1
    Integer i2 = Arrays.asList(6,7,8,8,10)
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

### My answer:
* I don't believe you can call `sorted()` on a prarallel stream.
* **C**
<hr>

## Question 9
❓Assuming `MyTask` is an abstract class that implements the `ForkJoinTask` interface, what statements about the following code are true? (Choose all that apply)

```java
import java.util.concurrent.*;
public class FindMin extends MyTask {
    private Integer[] elements;
    private int a;
    private int b;
    public FindMin(Integer[] elements, int a, int b) {
        this.elements = elements;
        this.a = a;
        this.b = b;
    }
    public Integer compute() {
        if ((b-a) < 2)
            return Math.min(elements[a], elements[b]);
        else {
            int m = a + ((b-a) / 2);
            System.out.println(a + "," + m + "," + b);
            MyTask t1 = new FindMin(elementrs, a, m);
            int result = t1.fork().join();
            return Math.min(new FindMin(elements, m, b).compute(), result);
        }
    }
    public static void main() throws InterupptedException, ExecutionException {
        Integer[] elements = new Integer[] { 8, -3, 2, -54 };
        MyTask task = new FindMin(elements, 0, elements.length-1);
        ForkJoinPool pool = new ForkJoinPool(1);
        Integer sum = pool.invoke(task);
        System.out.println("Min: " + sum);
    }
}
```

A. The code correctly finds the minimum value in the array <br>
B. `MyTask` inherits `RecursiveAction` <br>
C. `MyTask` inherits `RecursiveTask` <br>
D. The code produces a `ForkJoinPool` at runtime <br>
E. The class produces single-threaded performance at runtime <br>
F. The code does not compile <br>

### My answer:
* A - I think so
* B - false
* C - true
* D - true
* E - false
* F - false
* **A,C,D**
<hr>

## Question 10
❓ What statements about the following code are true? (Choose all that apply)
```java
System.out.println(Arrays.asList("duck","chicken","flamingo","pelican")
    .parallelStream().parallel() // q1
    .reduce(0,
        (c1, c2) -> c1.length() + c2.length(), // q2
        (s1, s2) -> s1 + s2)); // q3
```

A. It compiles and runs without issue, outputting the total length of all strings in the stream <br>
B. The code will not compile because of line q1 <br>
C. The code will not compile because of line q2 <br>
D. The code will not compile because of line q3 <br>
E. It compiles but throws an exception at runtime <br>

### My answer:
* It looks fine to me!
* **A**

<hr>

## Question 11
❓ What statements about the following code snippet are true? (Choose all that apply)

```java
Object o1 = new Object();
Object o2 = new Object();
ExecutorService service = Executors.newFixedThreadPool(2);
Future<?> f1 = service.submit(() -> {
    synchronized (ol) {
        synchronized (o2) { System.out.println("Tortoise"); } // t1
    }
});
Future<?> f2 = service.submit(() -> {
    synchronized (o2) {
        synchronized (o1) { System.out.println("Hare"); } //t2
    }
})
f1.get();
f2.get();
```

A. If the code does output anything, the order cannot be determined <br>
B. The code will always output Tortoise followed by Hare <br>
C. The code will always output Hare followed by Tortoise <br>
D. The code does not compile because of line `t1` <br>
E. The code does not compile because of line `t2` <br>
F. The code may produce a deadlock at runtime
G. The code may produce a livelock at runtime
H. It compiles but throws an exception at runtime

### My answer:
* **F**
<hr>

## Question 12:

❓ What is the result of executing the following application (choose all that apply)
```java
import java.util.concurrent.*;
public class CountNumbers extends RecursiveAction {
    private int start;
    private int end;
    public CountNumbers(int start, int end) {
        this.start = start;
        this.end = end;
        public CountNumbers(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    protected void compute() {
        if (start<0) return;
        else {
            int middle = start + ((end-start)/2);
            invokeAll(new CountNumbers(start, middle),
                new CountNumbers(middle, end)); // m1
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
B. The code will not compile because of m1 <br>
C. The code will not compile because of m2 <br>
D. The code will not compile because of m3 <br>
E. It compiles but throws an exception at runtime <br>
F. It compiles but hangs at runtime <br>

### My answer:
* Total random guess
* **A**
<hr>

## Question 13
❓ What statements about the following code snippet are true? (Choose all that apply)
```java
4: Stream<String> cats = Stream.of("leopard","lynx","ocelot","puma").parallel();
5: Stream<String> bears = Stream.of("panda","grizzly","polar").parallel();
6: ConcurrentMap<Boolean, List<String>> data = Stream.of(cats,bears)
7:     .flatMap(s -> s)
8:     .collect(Collectors.groupingByConcurrent(s -> !s.startsWith("p")));
9: System.out.println(data.get(false).size()+" "+data.get(true).size());
```
A. It outputs `3 4` <br>
B. It outputs `4 3` <br>
C. The code will not compile because of line 6 <br>
D. The code will not compile because of line 7 <br>
E. The code will not compile because of line 8 <br>
F. It compiles but throws an exception at runtime <br>
G. The `collect()` operation is always executed in a single-threaded fashion <br>

### My answer:
* 3 and 4 are printed I thinkk
* **A**
<hr>

## Question 14:
❓ What is the result of calling the following method?

```java
public void addAndPrintItems(BlockingDeque<Integer> deque) {
    deque.offer(103);
    deque.offerFirst(20, 1, TimeUnit.SECONDS);
    deque.offerLast(85, 7, TimeUnit.HOURS);
    System.out.print(deque.pollFirst(200, TimeUnit.NANOSECONDS));
    System.out.print(" "+deque.pollLast(1, TimeUnit.MINUTES));
}
```
A. It outputs `20 85` <br>
B. It outputs `103 85` <br>
C. It outputs `20 103` <br>
D. The code will not compile <br>
E. It compiles but throws an exception at runtime <br>
F. The output cannot be determined ahead of time <br>

### My answer:
* I have no idea!
* **A**
<hr>

## Question 15
❓ Which of the following are valid `Callable` expressions (Choose all that apply)

A. `a -> {return 10;}` <br>
B. `() -> {String s = "";}` <br>
C. `() ->  5` <br>
D. `() -> {return null}` <br>
E. `() -> "The" + "Zoo"` <br>
F. `(int count) -> count+1` <br>
G. `() -> {System.out.println("Giraffe"); return 10;}` <br>

### My answer:
* A - valid
* B - invalud
* C - valid
* D - valid
* E - valid
* F - invalid
* G - valid
* **A,C,D,E,G**
<hr>

## Question 16
❓ What is the result of executing the following application? (Choose all that apply)

```java
import java.util.concurrent.*;
import java.util.stream.*;
public class PrintConstants {
    public static void main(String[] args) {
        ExecutorService service = Executors.newScheduledThread(10);
        DoubleStream.of(3.14159,2.71828) // b1
            .forEach(c -> service.submit( // b2
                () -> System.out.println(10*c))); // b3
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

### My answer:
* **E**
<hr>

## Question 17
❓ Assuming 100 milliseconds is enough time for the tasks submitted to the thread executor to complete, what is the result of executing the following program (Choose all that apply)

```java
import java.util.concurrent.*;
public class SheepManager {
    private static AtomicInteger sheepCount1 = new AtomicInteger(0); // w1
    private static int sheepCount2 = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor(); // w2
            for(int i=0;i<100;i++)
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

### My answer:
* The code does compile I think
* **C**
<hr>

## Question 18
❓ What is the result of executing the following application? (Choose all that apply)

```java
import java.util.concurrent.*;
import java.util.stream.*;
public class StockRoomTracker {
    public static void await(CyclicBarrier cb) { // j1
        try { cb.await(); } catch (InterruptedException | BrokenBarrierException e) {
            // Handle exception
        }
    }
    public static void main() {
        CyclicBarrier cb = new CyclicBarrier(10,
            () -> System.out.println("Stock Room Full!")); // j2
        IntStream.iterate(1, i -> 1).limit(9)
            .parallel().forEach(i -> await(cb)); // j3
    }
}
```

A. It outputs `Stock Room Full!` <br>
B. The code will not compile because of line j1 <br>
C. The code will not compile because of line j2 <br>
D. The code will not compile because of line j3 <br>
E. It compiles but throws an exception at runtime <br>
F. It compiles but waits forever at runtime <br>

### My answer:
* I have zero idea
* **F**
<hr>

## Question 19
❓ What statements about the following class definition are true? (Choose all that apply)
```java
public class TicketManager {
    private TicketManager() { super(); }
    private static TicketManager instance;
    public static synchronized TicketManager getInstance() { // k1
        if (instance == null) instance = new TickketManager(); // k2
        return instace;
    }
    
    private int tickets;
    public int getTicketCount() { return tickets; }
    public void makeTicketsAvailable(int value) { tickets += value; } // k3
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
D. The lock lockks acquired on k1 and k4 are on the same object <br>
E. The class correctly prevents concurrency issues for the value of tickets when accessed by multiple threads. <br>
F. At most one instance of `TicketManager` will be created in the application.

### My answer:
* **A**
<hr>

## Question 20
❓ Which of the following is true when creating your own exception class?

A. One or more constructors must be coded. <br>
B. Only checked exceptions may be created <br>
C. Only unchecked exception may be created <br>
D. The `toString()` method must be coded <br>
E. None of the above <br>

### My answer:

<hr>