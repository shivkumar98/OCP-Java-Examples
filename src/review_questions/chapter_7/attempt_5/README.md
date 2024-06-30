<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 7: Review Questions - Attempt 5

* Date: 01/07/2024
* Score: 11/20 (55%)

| Question # | Correct |
| ---------- | ------- |
| 1          |  ✅     |
| 2          |  ❌     |
| 3          |  ❌     |
| 4          |  ✅     |
| 5          |  ❌     |
| 6          |  ❌     |
| 7          |  ✅     |
| 8          |  ✅     |
| 9          |  ❌     |
| 10         |  ❌     |
| 11         |  ✅     |
| 12         |  ❌     |
| 13         |  ❌     |
| 14         |  ✅     |
| 15         |  ✅     |
| 16         |  ❌     |
| 17         |  ✅     |
| 18         |  ✅     |
| 19         |  ✅     |
| 20         |  ❌     |
| 21         |  ✅     |
| 22         |  ❌     |

<hr>

## Question 1
❓ Given an instance of a Stream s, and a Collection c, which are valid ways of creating a parallel stream? (Choose all that apply) ❓

* A. `new ParallelStream(s)`
* B. `c.parallel()`
* C. `s.parallelStream()` 
* D. `c.parallelStream()`
* E. `new ParallelStream(c)` 
* F. `s.parallel()`
❓

### My answer:
* A - false
* B - false
* C - false
* D - true
* E - false
* F - true
* **D,F**✅✅✅✅
<hr>

## Question 2:
❓ Which of the following statements abolut the `Callable call()` and `Runnable run()` methods are correct? (Choose all that apply) ❓

* A. Both can throw unchecked exceptions 
* B. Callable takes a generic method argument 
* C. Callable can throw a checked exception 
* D. Both can be implemented with lambda expressions 
* E. Runnable returns a generic type 
* F. Callable returns a generic type 
* G. Both methods return void 
❓

### My answer:
* call throws a checked exception
* A - false
* B - true
* C - true
* D - false
* E - false
* F - true
* G - false
* **A,B,F**❌❌❌❌
* **CORRECT ANSWER: A,C,D,F**
* Callable has the following method:
```java
V call() throws Exception 
```
* Runnable has the following method:
```java
void run()
```
* Both can throw unchecked exceptions, so A is true
* Callable can throw a checked exception, so C is true
* Both can be implemented via lambda so D is true
* F is true
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

* A. It compiles and runs without issue
* B. Line w1
* C. Line w2
* D. Line w3
* E. Line w4
* F. It compiiles but throws an exception at runtime
❓

### My answer:
* A schedule cannot have a return
* so w2 needs to be changed
* w3 and w4 are fine
* **C**❌❌❌❌
* **CORRECT ANSWER: B,C**
* The ScheduledExecutorService is referenced as `ExecutorService`, and from this interface the `.newSingleThreadScheduleExecutor()` method is not available, so w1 is a compiler error
* The scheduled executor only takes Runnable implementations, so the return on w2 is invalid, so w2 is compiler error
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

* A. It outputs 100 100 
* B. It outputs 100 99 
* C. The output cannot be determined ahead of time 
* D. The code does not compile 
* E. It compiles but throws an exception at runtime 
* F. It compiles but enters an infinite loop at runtime
❓

### My answer:
* **C**✅✅✅✅
<hr>

## Question 5
❓ Fill in the blanks: ________ occur(s) when two or more threads are blocked forever but both appear active. _________ occur(s) when two or more threads try to complete a related task at the same time ❓

* A. Livelock, Deadlock
* B. Deadlock, Starvation
* C. Race conditions, Deadlock
* D. Livelock, Race conditions
* E. Starvation, Race conditions
* F. Deadlock, Livelock
❓

### My answer:
* Livelock, Deadlock
* **A**❌❌❌❌
* **CORRECT ANSWER: D**
<hr>

## Question 6
❓ Which happens when more tasks are submitted to a thread executor than available threads? ❓

* A. The thread executor will throw an exception when a task is submitted that is over its thread limit
* B. The task will be added to an internal queue and completed when there is an available thread
* C. The thread executor will discard any task over its thread limit
* D. The call to submit the task to the thread executor will wait until there is a thread available before continuing.
* E. The thread executor creates new temporary threads to complete the additional tasks.
❓

### My answer:
* A - false
* B - true
* C - false
* D - true
* E - false
* **B,D**❌❌❌❌
* **CORRECT ANSWER: B**
* Did not realise this was single option!!
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

* A. It outputs `3 6 4`
* B. It outputs `6 6 6`
* C. It outputs `6 3 4`
* D. The code does not compile
* E. It compiles but throws an exception at runtime on line x1
* F. It compiles but throws an exception at runtime on line x2
* G. It compiles but enters an infinite loop at runtime
❓

### My answer:
* l1 size is 3
* l2 size is 6
* l3 is 4
* **A**✅✅✅✅
* `CopyOnWriteArrayList` avoids concurrent modifications when modifiying the collection while looping through it
* the l2 list adds 3 `4`'s to the List
* The Set only takes unique values, so 5 is only added once!
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

* A. It outputs `1 6`
* B. It outputs `1 10`
* C. The code will not compile because of line y1
* D. The code will not compile because of line y2
* E. The code will not compile because of line y3
* F. It compiles but throws an exception at runtime
* G. The output cannot be determined ahead of time
* H. It compiles but waits forever at runtime

❓

### My answer:
* i1 us 1
* **G**✅✅✅✅
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


* A. The correctly finds the minimum value in the array
* B. MyTask inherits RecursiveAction
* C. MyTask inherits RecursiveTask
* D. The code produces a ForkJoinPool at runtime
* E. The class produces single-threaded performance at runtime
* F. The code does not compile
❓

### My answer:
* A - true
* Its a recursive task
* D is true
* E is false
* F is false
* **A,C,D**❌❌❌❌
* **CORRECT ANSWER: A,C,E**
* The `.join()` method is called straight after `.fork()`
* So ForkJoinPool is not created

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

* A. It compiles and runs without issue, outputting the total length of all the strings in the stream 
* B. The code will not compile because of line q1 
* C. The code will not compile because of line q2 
* D. The code will not compile because of line q3 
* E. It compiles but throws an exception at runtime
❓

### My answer:
* q1 is fine
* q2 is fine
* **A**❌❌❌❌
* **CORRECT ANSWER: C**
* The second argument of the `.reduce()` method is of type `BiFunction<Integer, String, Integer>`
* So if it was `(c1,c2)->c1+c2.length()` it would be correct
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

* A. If the code does output anything, the order cannot be determined
* B. The code will always output Tortoise followed by Hare
* C. The code will always output Hare followed by Tortoise
* D. The code does not compile because of line t1
* E. The code does not compile because of line t2
* F. The code may produce a deadlock at runtime
❓

### My answer:
* **A,F**✅✅✅✅
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
* A. It compiles and runs without issue
* B. The code will not compile because of `m1`
* C. The code will not compile because of `m2`
* D. The code will not compile because of `m3`
* E. It compiles but throws an exception at runtime
* F. It compiles but hangs at runtime
❓

### My answer:
* A is true
* **A**❌❌❌❌
* **CORRECT ANSWER: F**
* The base case is unreachable
<hr>

## Question 13
❓ What statements about the following code snippet are true? (Choose all that apply) ❓

```java
4: Stream<String> cats = Stream.of("leopard","lynx","ocelot","puma").parallel();
5: Stream<String> bears = Stream.of("panda","grizzly","polar").parallel();
6: ConcurrentMap<Boolean, List<String>> data = Stream.of(cats,bears)
7:   .flatMap(s -> s)
8:   .collect(Collectors.groupingByConcurrent(s -> !s.startsWith("p")));
9: System.out.println(data.get(false).size()+" "+data.get(true).size());
```

* A. It outputs 3 4
* B. It outputs 4 3
* C. The code will not compile because of line 6
* D. The code will not compile because of line 7
* E. The code will not compile because of line 8
* F. It compiles but throws an exception at runtime
* G. The `collect()` operation is always executed in a single-threaded fashion
❓

### My answer:
* true = leopard, lynx, oceolot, grizzly,
* false = puma, panda, polar
* It will print **B**❌❌❌❌
* **CORRECT ANSWER: B,G**
* I thought true was printed first which was my mistake
* Since `flatMap()` is used, the grouping is done in a single-threaded fashion as there is no longer a stream
<hr>

## Question 14:
❓ What is thr result of the followsing method ❓

```java
3: public void addAndPrintItems(BlockingDeque<Integer> deque) {
4:    deque.offer(103);
5:    deque.offerFirst(20, 1, TimeUnitSeconds);
6:    deque.offerLast(85, 7, TimeUnit.HOURS);
7:    System.out.print(deque.pollFirst(200, TimeUnit.NANOSECONDS));
8:    System.out.print(" "+deque.pollLast(1, TimeUnit.MINUTES));
9: }
```

* A. It outputs 20 85
* B. It outputs 103
* C. It outputs 20 103
* D. The code will not compile
* E. It compiles but throws an exception at runtime
* F. The output cannot be determined ahead of time
❓

### My answer:
* I do not think this compiles
* **D**✅✅✅✅
* The `offer()` methods adds an element to the end of BlockingQueue
* `offerFirst()` add element to start, `offerLast()` adds element to end
* If the code did compile, by declaring the `InterruptedException`, it would print 20 then 85
<hr>

## Question 15
❓ Which of the following are valid `Callable` expressions? (Choose all that apply) ❓

* A. `a -> {return 10;}` 
* B. `() -> {String s = "";}` 
* C. `() -> 5` 
* D. `() -> {return null}` 
* E. `() -> "The" + "Zoo"` 
* F. `(int count) -> count+1` 
* G. `() -> {System.out.println("Giraffe"); return 10;}` 
❓

### My answer:
* A - false
* B - false
* C - true
* D - false, semi-colon missing
* E - true
* F - false
* G - true
* **C,E,G**
* D does not compile, but if the semi-colon was present it would be valid!!
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

* A. It compiles and outputs the two numbers, followed by `Printed`
* B. The code will not compile because of line b1
* C. The code will not compile because of line b2
* D. The code will not compile because of line b3
* E. The code will not compile because of line b4
* F. It compiles but the output cannot be determined ahead of time
* G. It compiles but throws an exception at runtime
* H. It compiles but waits forever at runtime
❓

### My answer:
* **F**❌❌❌❌
* **CORRECT ANSWER: F,H**
* It waits forever since shutdown is not called!             
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

* A. It outputs `100 99`
* B. It outputs `100 100`
* C. The output cannot be determined ahead of time
* D. The code will not compile because of line w1
* E. The code will not compile because of line w2
* F. The code will not compile because of line w3
* G. It compiles but throws an exception at runtime
❓

### My answer:
* It's single threaded
* So it will print 100 100
* **B**✅✅✅✅
<hr>

## Question 18
❓ What is the result of executing the following application? (Choose all that apply) ❓
```java
import java.util.concurrent.*;
import java.util.stream.*;
public class StockRoomTracker {
   public static void await(CyclicBarrier cb) { // j1
      try { cb.await(); } catch (InterruptedException | BrokenBarrierException e) {
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

* A. It outputs Stock Room Full!
* B. The code will not compile because of line `j1`
* C. The code will not compile because of line `j2`
* D. The code will not compile because of line `j3`
* E. It compiles but throws an exception at runtime
* F. It compiles but waits forever at run time
❓

### My answer:
* **F**✅✅✅✅
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

* A. It compiles without issue
* B. The code will not compile because of line k2
* C. The code will not compile because of line k3
* D. The locks acquired on k1 and k4 are the same object
* E. The class correctly prevents concurrency issues for the value of `tickets` when accessed by multiple threads
* F. At most one instance of `TicketManager` will be created in the application
❓

### My answer:
* **A,F**✅✅✅✅
<hr>

## Question 20
❓ Which of the following properties of concurrency are true? (Choose all that apply) ❓

* A. By itself, concurrency does not guarantee which task will be completed first
* B. Concurrency always improves the performance of an application
* C. Computers with a single processor do not benefit from concurrency
* D. Applications with many resource-heavy tasks tend to benefit more from concurrency than ones with CPU-intensive task
* E. Concurrent tasks do not share the same memory
❓

### My answer:
* A - true
* B - false
* C - false
* D - false
* E - false
* **A**❌❌❌❌
* Resource heavy (RAM) tasks benefit from concurrency over CPU-heavy ones
* **CORRECT ANSWER: A,D**

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

* A. It outputs a number 10 times
* B. It outputs a Boolean value 10 times
* C. It outputs a null value 10 times
* D. It outputs Exception! 10 times
* E. It hangs indefinitely at runtime
* F. It throws an unhandled exception at runtime
* G. The code will not compile because of line o1
* H. The code will not compile because of line o2
❓

### My answer:
* A - true
* B - false
* C - true
* D - treu
* E - true
* F - false
* **A,C,D,E**✅✅✅✅

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

* A. It prints `0 1 2 3 4` 
* B. It prints `1 2 3 4 5` 
* C. It prints `null null null null` 
* D. It hangs indefinitely at runtime 
* E. The output cannot be determined 
* F. The code will not compile because of line n1 
* G. The code will not compile because of line n2
❓

### My answer:
* **A**❌❌❌❌
* **CORRECT ANSWER: F**
* Code does not compile because `service.execute(Callable)` has void return
* Only the `.submit()` method returns `Future<T>`
<hr>