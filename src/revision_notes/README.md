<link href="../styles.css" rel="stylesheet"></link>


# 🧠 Chapter 6 - Exceptions and Assertions
## 🟥 6.1 Reviewing Exceptions
### 🟡 Terminology
* All exceptions/errors extend `java.lang.Object`
* `RuntimeException` is a subclass of `Exception`, it is AKA unchecked exception and there is no requirement to be caught (even though you can).
* Checked exceptions are `Exception` classes which DO NOT extend `RuntimeException`.
* `Error` classes are not `Exceptions` but a seperate subclass of `Throwable`

### 🟡 OCP Exceptions
* The pre-requiste exceptions from the OCA exam include:
1) `NumberFormatException` - thrown by program when attempting to convert string to numeric type
2) `IllegalArgumentException` - thrown by program
3) `NullPointerException` - thrown by JVM
4) `ArrayIndexOutOfBoundsException` - thrown by JVM
5) `ArithmeticException` - thrown by JVM when trying to divide by zero
6) `ClassCastException` - thrown by JVM when attempting to make cast an object to an invalid type

<br>

* The **OCP Checked Exceptions** are:
1) `java.text.ParseException` 
- converting a number to string
2) `java.io.IOException`/`java.io.FileNotFoundException`/`java.io.NotSerializableException`
- All io exceptions can be assumed as checked
3) `java.sql.SQLException`
- All sql exception can be assumed as checked

* The **OCP Runtime Exceptions** are:
1) `java.lang.ArrayStoreException`
- When attempting to add incorrect type to an array
2) `java.time.DateTimeException`
- Recieved when an invalid format string for a date
3) `java.util.MissingResourceException` - trying to access a resource or bundle that does not exist
4) `java.lang.UnsupportedOperationException`
5) `java.lang.IllegalStaceException`

<hr>

## 🟥 6.2 Creating Custom Exceptions
* You can create custom exceptions by extending `Exception` or `RuntimeException`
* Here are the 3 most common constructors for Exceptions:
```java
public class CanNotSwimException extends Exception {
	public class CanNotSwimException() { super(); }
	public class CanNotSwimException(Exception e) { super(e); }
	public class CanNotSwimException(String message) { super(message); }
}
```
<hr>

## 🟥 6.3 Using Multi-catch
* We can use multi-catch syntax to reduce code duplication when catching multiple exceptions@
```java
try {
	Path path = Paths.get("dophinsBorn.txt"); // throws IOEXception
	LocalDate date = LocalDate.parse("text"); // throws DateTimeParseException
} catch (DateTimeParseException | IOException e) {
	e.printStackTrace();
	throw new RuntimeException(e);
}
```
* The caught exception is EFFECTIVELY FINAL (i.e. it can not be instantiated or reassigned)⚠️⚠️⚠️
```java
try {
    throw new IOException();
} catch (IOException | RuntimeException e) {
    e = new RuntimeException(); // COMPILER ERROR
}
```
* A compiler error is generated if any of the exception types are UNREACHABLE, i.e. it can only catch checked exceptions which are declared and you can not have redudancies!⚠️⚠️⚠️
```java
try {
    throw new IOException();
} catch (FileNotFoundException | IOException e) { } // COMPILER ERROR
```
<hr>

## 🟥 6.4 Using Try-With-Resources
* You can use classes which implement `Closeable` OR `AutoCloseable` in try-with-resources clauses
* The `AutoCloseable` interface has a method: `void close() throws Exception;`
* It does not require the implemention to throw any exception at all:
```java
public class Turkey implements AutoCloseable {
	@Override
	public void close() {
		System.out.println("closed");
	}
	public static void main(String[] args) {
		try(Turkey t = new Turkey()) {
			System.out.println("opening turkey");
		}
	}
	// PRINTS:
	// opening turkey
	// closed
}
```

<br>

* If the `close()` method DOES throw a checked exception then it must be declared or caught!
```java
public class Turkey implements AutoCloseable {

	@Override
	public void close() throws Exception {
		throw new Exception();
	}
	public static void main(String[] args) {
		try(Turkey t = new Turkey()) { // COMPILER ERROR
			System.out.println("opening turkey");
		}
	}
}
```

<br>

* If the try clause itself throws an exception, it will be the one which is caught and the exceptions from `close()` will be SUPRESSED💡
```java
public static void main(String[] args) {
	try (Turkey t = new Turkey()) {
		throw new RuntimeException("inside try");
	} catch (Exception e) {
		System.out.println(e.getMessage()); // inside try 
		System.out.println(e.getSuppressed().length); // 1
	}
}
```

<br>

* In terms of ordering, the code is ran in the following order:
1) The code in try block
2) The close() methods of the resources in reverse order of instantiation
3) The code in catch block
4) The code in finally block 

```java
class Door implements AutoCloseable {
	public void close() {
		System.out.println("D");}}
class Window implements Closeable {
	public void close() {
		System.out.println("W"); 
	 	throw new RuntimeException();}}
public class AutocloseableFlow {
	public static void main(String[] args) {
		try (Door d = new Door(); Window w = new Window()) {
			System.out.print("T");
		} catch (Exception e) {
			System.out.print("E");
		} finally {
			System.out.print("F");
		} 
	} 
	// PRINTS: TWDEF
}
```

<hr>

## 🟥 6.5 Rethrowing Exceptions
* It is a common pattern to log an exception, and rethrowing the same exception:
```java
try {
	parseData();
} catch (IOException | DateTimeParseException e) {
	System.err.println(e);
	throw e;
}
```
<hr>

## 🟥 6.6 Working With Assertions
* By default, failing assertions will not cause any changes in program flow
* They need to be enabled using `-ea` or `-enableassertions` options when compiling the java class
* We can enable assertions for specifc classes by following the option with `:className`
* You can mix these options together. E.g. the following will disable assertions except for specified class: `java -da -ea:ClassName ClassName`


<br><hr>

# 🧠 Chapter 7 - Concurrency

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

### 🟡 Concurrent Classes
* We have the following Concurrent Collection Classes:
```java
ConcurrentHashMap // ConcurrentMap
ConcurrentLinkedDeque // Deque
ConcurrentLinkedQueue // Queue
ConcurrentSkipListMap // ConcurrentMap/SortedMap/NavigableMap
ConcurrentSkipListSet // SortedSet/NavigableSet
CopyOnWriteArrayList // List
CopyOnWriteArraySet // Set
LinkedBlockingDeque // BlockingQueue/BlockingDeque
LinkedBlockingQueue // BlockkingQueue
```
### 🟡 ConcurrentModificationException
* Using Concurrent classes enables us to avoid `ConcurrentModificationException` when workking with for-loops:
```java
Map<String, Integer> food = new HashMap<>();
food.putAll(Map.of("pizza", 1, "chicken", 2));
for (String key: food.keySet()) {
	food.remove(key); // throws ConcurrentModificationException
}
```
* If we used `new ConcurrentHashMap<>()` instead, we would not have this problem!💡

### 🟡 Blocking Queues
* The `LinkedlockingDeque` and `LinkedBlockingQueue` implement the `BlockingQueue` and `BlockingDeque` interfaces
1) `BlockingQueue` waiting methods:
```java
boolean offer(E e, long timeout, TimeUnit unit); 
// adds item to queue in alotted time if space is available

E poll(long timeout, TimeUnit unit);
// retrieves and removes an item from the queue in alotted time if available
```
* These methods can throw an `InterruptedException` as they can be interrupted before finishing:
```java
try {
	BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
	blockingQueue.offer(39);
	blockingQueue.offer(3,4,TimeUnit.SECONDS);
	System.out.println(blockingQueue.poll(10, TimeUnit.SECONDS));
} catch (InterruptedException e) {
	// handle
}
```

2) `BlockingDeque` waiting methods:
```java
boolean offerFirst(E e, long timeout, TimeUnit unit);
// adds item to front of queue

boolean offerLast(E e, long timeout, TimeUnit unit);
// adds item to back of queue

E pollFirst(long timeout, TimeUnit unit); 
// retrieves and removes element at front of queue

E pollLast(long timeout, TimeUnit unit);
// retrieves and removes element at back of queue
```
* Again, `InterruptedException` must be caught and handled!

### 🟡 SkipList Collections
* The `ConcurrentSkipListMap` and `ConcurrentSkipListSet` are concurrent versions of `TreeMap` and `TreeSet`
* These 
### 🟡 CopyOnWrite Collections
* The `CopyOnWriteArrayList` and `CopyOnWriteSet` are concurrent versions of Lists and Sets.
* These classes let us add/remove elements in a for loop, the iterator takes a snapshot of the elements and loops over these elements during each iteration
```java
List<Integer> regularList = Arrays.asList(1,2,3);

/* The following code throws exception:
for(int i:l1) 
	l1.add(i); // UnsupportedOperationException
*/

List<Integer> l2 = new CopyOnWriteArrayList<>(l1);
for (int i:l2) {
	System.out.print(i+ " "); // 1 2 3
	l2.add(i);
}
System.out.println(l2); // [1,2,3,1,2,3]

Set<Integer> s3 = new CopyOnWriteArraySet<>();
s3.addAll(l2);
for(int i:s3) {
	System.out.print(i+ " "); // 1 2 3
	s3.add(4);
}
System.out.println("\n"+s3); // [1,2,3,4]
```

### 🟡 Obtaining Synchronized Collections
* We can convert non-concurrent collections into synchronized versions using the following methods:
```java
synchronizedCollection(Collection<T> c)
synchronizedList(List<T> list)
synchronizedMap(Map<Kk,V> map)
synchronizedNavigableMap(NavigableMap<K,V> map)
synchronizedNavigableSet(NavigableSet<T> set)
synchronziedSet(Set<T> set)
synchronizedSortedMap(SortedMap<K,V> map)
synchronizedSortedSet(SortedSet<T> set)
```
* E.g.:
```java
List<Integer> list = Collections.synchronizedList(
	new ArrayList<>(Arrays.asList(4,3,42)));
```

<hr>

## 🟥 7.5 Working with Parallel Streams
### 🟡 Creating Parallel Streams
* You can create a paralle stream by calling `.parallel()` on an existing stream or calling `.parallelStream()` on a collection:
```java
Stream<Integer> stream = Arrays.asList(1,2,3,4).parallelStream();
```

### 🟡 Processing Tasks in Parallel
* Using a parallel stream means that results CAN be unpredictable
```java
Arrays.asList(1,2,3,4,5,6)
	.parallelStream()
	.sorted()
	.forEach(System.out::println);
// PRINTS: 4 1 6 5 2 3
```

* If tasks can be done in parallel and independently, we will always know the result!❗
```java
List<String> list = Arrays.asList("Jackal", "Monkey", "Tiger")
	.parallelStream()
	.map(String::toUpperCase)
	.collect(Collectors.toList());
System.out.println(list); // [JACKAL, MONKEY, TIGER]
```

### 🟡 Processing Parallel Reductions
* With parallel streams, behaviour can not be defined:
```java
Arrays.asList(1,2,3,4,5,6).stream().findAny(); // will ALWAYS be 1
Arrays.asList(1,2,3,4,5,6).parallelStream().findAny(); // unable to predict the result
```

* E.g.:
```java
int x = Arrays.asList("1234","56","789")
	.parallelStream()
	.reduce(0,
	(n,str)-> n + str.length(),
	(str1,str2)-> str1+str2);
System.out.println(x); // 9

String str = Arrays.asList("abc","de","fgh")
	.parallelStream()
	.reduce("", (result,s)->result+s.toUpperCase(), (s1,s2)->s1+s2);
System.out.println(str); // ABCDEFGH
```

### Using `.collect()` Method
* A parallel stream can be reduced efficiently using the collect method, providing the following requirements are met:
1) The stream is parallel
2) The collect() paramaeter has the `Collector.Characteristics.CONCURRENT` characteristic
3) The stream is unordered, OR the collect() parameter has the `Collector.Characteristic.UNORDERED` characteristic

* The `Collectors.toSet()` method is an example of a collector which DOES NOT have the `CONCURRENT` charactteristic:
```java
Stream<String> stream = Stream.of("w","o","l","f")
		.parallel();
System.out.println(Collectors.toSet().characteristics());
// [UNORDERED, IDENTITY_FINISH]

Set<String> set =
	stream.collect(Collectors.toSet());
System.out.println(set); // [f, w, l, o]
```

* The Collectors class does have 2 collectors which are both `CONCURRENT` AND `UNORDERED`:
1) `Collectors.toConcurrentMap()`
2) `Collectors.groupingByConcurrent()`

* E.g.:
```java
Stream<String> ohMy = Stream.of("lions","tigers","bears")
	.parallel();
ConcurrentMap<Integer,String> map = ohMy.collect(
	Collectors.toConcurrentMap(s->s.length(),
	k->k,
	(s1,s2)->s1+","+s2)
);
System.out.println(map); // {5=bears,lions, 6=tigers}
```

```java
Stream<String> parallelStream = Stream.of("lions", "tigers", "bears").parallel();
ConcurrentMap<Integer, List<String>> groupedMap = parallelStream
	.collect(Collectors.groupingByConcurrent(str->str.length()));
System.out.println(groupedMap); // {5=[lions, bears], 6=[tigers]}
```
<hr>

## 🟥 7.6 Managing Concurrent Processes
### 🟡 Creating a CyclicBarrier
* We can use the `CyclicBarrierLimit` class to create thresholds in a method to ensure that a type of task if not done until another is done:
```java
void performTask(CyclicBarrier c1) {
	try {
		System.out.println("Task 1");
		c1.await();
		System.out.println("Task 2");
	}
}
// MAIN METHOD:
ExecutorService service = null;
try {
	service = Executors.newFixedThreadPool(4);
	CyclicBarrier c1 = new CyclicBarrier(2);
	for(int i=0;i<4;i++)
		service.submit(()->performTask(c1));
} finally {
	if(service!=null) service.shutdown();
}
```
* This prints the following:
```java
Task 1
Task 1
Task 1
Task 1
Task 2
Task 2
Task 2
Task 2
```

### 🟡 Applying the Fork/Join Framework
* The Fork/Join framework requires us to perform three steps:
1) Createa ForkJoinTask instance using `RecursiveAction`/`RecursiveTask``
2) Create a `ForkJoinPool` instance
3) Invoke the ForkJoinTask instance using the pool

* We have two ForkJoinTask classes:
```java
abstract class RecursiveAction extends ForkJoinTask {
	protected abstract void compute();
}
abstract class RecursiveTask<V> extends ForkJoinTask<V> {
	protected abstract T compute();
}
```
#### 🟢 RecursiveAction Example 🟢
```java
public class WeighAnimalAction extends RecursiveAction {
	private int start;
    private int end;
    private Double[] weights;
    // CONSTRUCTOR HERE
	
	protected void compute() {
		if(end-start<=3){
			System.out.println("BASE CASE FROM: "+start
            +", TO: "+end);
            for(int i=start;i<end;i++) {
                weights[i] = (double)new Random().nextInt(100);
                System.out.println("Animal "+i+" weighs "+weights[i]);
            }
		} else {
			int middle = start+((end-start)/2);
            System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
            invokeAll(new WeighAnimalAction(weights,start,middle),
                      new WeighAnimalAction(weights,middle,end));
		}
	}
}

// MAIN METHOD:
Double[weights] = new Double[10];
ForkJoinTask<?> task = new WeighAnimalAction(weights,0,10);
ForkJoinPool pool = new ForkJoinPool();
pool.invoke(task);
```
* This prints the following:
```
[start=0,middle=5,end=10]
[start=0,middle=2,end=5]
BASE CASE FROM: 0, TO: 2
[start=5,middle=7,end=10]
BASE CASE FROM: 2, TO 5
BASE CASE FROM: 5, TO 7
BASE CASE FROM: 7, TO 10
Animal 0 weighs 53.0
Animal 1 weighs 75.0
Animal 2 weighs 41.0
Animal 5 weighs 56.0
Animal 3 weighs 87.0
Animal 7 weighs 35.0
Animal 4 weighs 59.0
Animal 8 weighs 68.0
Animal 6 weighs 56.0
Animal 9 weighs 9.0
```

#### 🟢 RecursiveTask Example 🟢
```java
public class WeighAnimalTask extends RecursiveTask<Double> {
	private int start;
    private int end;
    private Double[] weights;
    // CONSTRUCTOR HERE

	protected Double compute() {
		if (end-start<=3) {
			System.out.println("BASE CASE FROM: "+start+", TO: "+end);
			double sum = 0;
			for (int i=start;i<end;i++) {
				weights[i] = (double)new Random().nextInt(100);
				System.out.println("Animal Weighed: "+i);
				sum += weights[i];
			}
		} else {
			int middle = start+((start-end)/2);
			System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
			RecursiveTask<Double> otherTask = new WeighAnimalTask(weights,start,middle);
			otherTask.fork();
			return new WeighAnimalTask(weights,middle,end).compute()+otherTask.join();
		}
	}
}

// MAIN METHOD:
Double[] weights = new Double[10];
ForkJoinTask<Double> task = new WeighAnimalTask(weights,0,weights.length);
ForkJoinPool pool = new ForkJoinPool();
Double sum = pool.invoke(task);
System.out.println("Sum: "+sum);
```
* This prints the following:
```
[start=0,middle=5,end=10]
[start=5,middle=7,end=10]
BASE CASE FROM: 7, TO: 10
[start=0,middle=2,end=5]
BASE CASE FROM: 5, TO: 7
BASE CASE FROM: 2, TO: 5
BASE CASE FROM: 0, TO: 2
Animal: 7 weighed 0.0
Animal: 8 weighed 40.0
Animal: 9 weighed 29.0
Animal: 2 weighed 69.0
Animal: 3 weighed 83.0
Animal: 5 weighed 71.0
Animal: 0 weighed 55.0
Animal: 1 weighed 45.0
Animal: 6 weighed 49.0
Animal: 4 weighed 87.0
Sum: 528.0
```
* If the `.join()` method were to be called directly after fork, the application would generate single-threader performance:
```java
int middle = start+((start-end)/2);
System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
RecursiveTask<Double> otherTask = new WeighAnimalTask(weights,start,middle);
otherTask.fork().join(); // DO NOT DO!!!!
return new WeighAnimalTask(weights,middle,end).compute()+otherTask;
```
<hr>

## 🟥 7.7 Identifying Threading Problems
* Liveliness is the property of an application not encountering unexpected delays
* Deadlock is when a resource is blocked from being used from a thread
* Starvation occurs when a thread is perpetually denied access to a shared resouce as a result of other threads constantly taking the resource
* Livelock occurs when two or more threads are blocked forever but appear active. This is often the result of two threads trying to attempt to resolve a deadlock
* Race conditions are when two or more threads try to complete a related task at the same time. It is the undesirablee result which occurs when two tasks which should be done sequentially are done at the same time

<br><hr>

# 🧠 Chapter 8 - IO

## 🟥 8.1 Files and Directories
* You can instantiate a file using either a String representing the location or using another File instance which is the parent directory
```java
File parent = new File("/home/smith");
File child = new File(parent, "data/zoo.txt");
```

* We have methods to make directories, confirm existence, delete, rename and list files.
* We do NOT have methods to MOVE/COPY

* Here are the **methods available to File class**:
```java
boolean exists();
String getName(); // gets the name of file or directory. E.g. zoo.txt
boolean isDirectory();
boolean isFile();
boolean delete(); // deletes file OR directory if empty
boolean renameTo(File file);
boolean mkdir(File directoryFile); // makes directory file denoted by file
boolean mkdirs(File file); // makes directory AND file even for dirs which don't exist
String getParent(); // returns absolute filepath of parent directory
File[] listFiles(); // returns a File[] denoting files in directory
long lastModified(); // returns no. of ms since the epoch the file was last modified
```

<hr>

## 🟥 8.2 Streams
### 🟡 Input/Output Stream Vs Reader/Writer
* There **four abstract classes** in java.io:
1) `Reader` 📖
2) `Writer` ✍️
3) `InputStream` 👉0️⃣
4) `OutputStream` 1️⃣👉

* These classes can be divided into two types
1) Classes which have `InputStream`/`OutputStream` in their name
- Used for reading/writing **BINARY DATA**
2) Classes which have `Reader`/`Writer` in their name
- Used for reading/writing **CHARACTER/STRING DATA**

### 🟡 Low-Level Streams
* LOW LEVEL streams connect directly to source of data

| Class 			| Description 								|
| ----------------- | ----------------------------------------- |
| FileInputStream   | This is an `InputStream` and reads binary data from file				|
| FileOutputStream  | This is an `OutputStream` and writes binary data to file				|
| FileReader        | This is a `Reader` and reads character data from file		    |
| FileWriter		| This is a `Writer` and writes character data from file 			|

* HIGH LEVEL streams are used to wrap another stream (the final 2 are not in the exam)
  
| Class 			| Description 								|
| ----------------- | ----------------------------------------- |
| BufferedReader |  This is a `Reader` and takes in a low level `FileReader` |
| BufferedWriter | This is a `Writer` and takes in a low level stream `FileWriter` |
| BufferedInputStream | This is a `InputStream` which takes a low level `FileInputStream` |
| BufferedOutputStream |  This is a `OutputStream` which takes a low level `FileOutputStream` |
| ObjectInputStream | This deserializer is an `InputStream` and takes either `FileInputStream` OR `BufferedInputStream` |
| ObjectOutputStream | This serializer is an `OutputStream` and takes either `FileOutputStream` OR `BufferedOutputStream` |
| PrintStream  | This is a `OutputStream` which gives useful methods for writing and formatting data  |
| PrintWriter | This is a `Writer` which gives useful methods for writing and formatting data  |
| InputStreamReader | This is a `Reader` which takes an `InputStream` (e.g. FileInputStream, ObjectInputStream) |
| OutputStreamWriter | This is a `Writer` which takes an `OutputStream` (e.g. FileOutputStream) |

### 🟡 Common Stream Operations
* Streams should be closed via `close()` method to prevent resouce leaks and the program deadlocking. You can also use the try-with-resources syntax to do this automatically💡
* You should use the `flush()` method to ensure all data is written to disk when writing data with `OutputStream`
* Only some streams support marking and resetting. Check that it is supported using `boolean markSupported()` otherwise you can encounter an UnsupportedOperationException⚠️
<hr>

## 🟥 8.3 Working With Streams

### 🟡 FileInputStream and FileOutputStream Classes
* These are LOW LEVEL `InputStream`/`OutputStream` classes which read/write binary data to files
```java
try (InputStream fileInputStream = new FileInputStream(new File("data.txt")) {
	int b;
	while((b=fileInputStream()) != -1) {
		System.out.print((char)b);
	}
}
```

#### 🟢 BufferedInputStream and BufferedOutputStream Classes
* This are HIGH LEVEL InputStream/OutputStream classes which take in low level FileInputStream/FileOutputStream classes!
```java
BufferedInputStream bufferedInputStream
	= new BufferedInputStream(
		new FileInputStream(
			new File(alphabetFile)));
int b;
while ((b=bufferedInputStream.read()) != -1) {
	System.out.println((char)b);
}
```

### 🟡 FileReader and FileWriter Classes
* These classes offer AUTOMATIC CHARACTER ENCODING💡
* These are LOW LEVEL `Reader`/`Writer` classes which read and write String data
* We have a `int read()` method for the reader ,and a `void write(String)` method for the writer
```java
FileReader fileReader = new FileReader(alphabetFile);
int b;
while((b=fileReader.read()) != -1) {
	System.out.println((char)b);
}
```

#### 🟢 BufferedReader and BufferedWriter
* These classes are HIGH LEVEL wrappers, there is also a `ReadLine()` method which is useful!
```java
try (BufferedWriter writer = new BufferedWriter(new FileWriter(alphabetFile));
	 BufferedReader reader = new BufferedReader(new FileReader(alphabetFile));) {
	writer.write("abcd\nefghi");
	String line;
	while((line=reader.readLine())!=null) {
		System.out.println(line);
	}
}
```

### 🟡 ObjectInputStream and ObjectOutputStream Classes
* These classes allow for SERIALIZATION and DESERIALIZATION of Java objects:
* The ObjectInputStream takes in an InputStream in the form of a FileInputStream or BufferedInputStream
```java
ObjectOutputStream writer = new ObjectOutputStream(
	new FileOutputStream(outputFile));
writer.writeObject("hello world");

ObjectInputStream reader = new ObjectInputStream(
	new FleInputStream(outputFile));
// reader.read(); // returns -1
reader.readObject(); // hello world is returned
```

#### 🟢 Serializable Interface
* Any abstract, concrete or final class can be marked as serializable
* Attempting to serialize a non-serializable instance will not cause compilation errors but WILL THROW NotSerializableException:
```java
objectOutputStream.writeObject(new NotSerializable()); // THROWS NotSerializableException
```

#### 🟢 How Objects are Created When Deserializing
* Static and `transient` variables are ignored during serialization/deserialization
  * Transient variables will be the default value java gives to the instance type (e.g. null for Strings)
  * Static variables will have the value of the last value it was assigned to in the program
* When an object is deserialized, the constructor of the class is NOT called
  * java will call the first no-argument constructor for the first nonserializable parent class


### 🟡 PrintStream and PrintWriter Classes
* These classes offer nice methods like `format(String, args)` and `printf(String, args)` which are functionally the same
* PrintStream is an `OutputStream`
* PrintWriter is a `Writer`
<hr>

## 🟥 8.4 Interacting With Users

### 🟡 Old Way: Using Buffered Reader
* System.out returns a `PrintStream`
* System.in returns an `InputStream`.
* We use `InputStreamReader` to capture input from the user:
```java
Reader reader = InputStreamReader(System.in);
System.out.println("Enter a character");
		int input = reader.read();
		System.out.println("You entered: "+(char)input);
```

* BufferedReader enables us to read String terminated by enter key by the user
```java
BufferedReader bufferedReader = 
	new BufferedReader(new InputStreamReader(System.in));
System.out.println("Please enter a string:");
String input = bufferedReader.readLine();
System.out.printf("You entered: %s", input);
```

### 🟡 New Way: Using Console
* The `Console` is a singleton which is accessible using `Sytem.console()`
* There is a risk the console can be null⚠️
* The console has the `format()`/`printf()` that PrintStream also has
* The console has the following methods:
  * `String readLine()`
  * `char[] readPassword()` - a secure way of reading password without invoking String pool!
  * `PrintWriter writer()` - gives a writer instance for methods like `print()`
* Example program:
```java
Console console = System.console();
console.printf("Hi, %s! Please enter some text:", "shiv");
String input = console.readLine();
console.writer().println("You typed: "+input);
```