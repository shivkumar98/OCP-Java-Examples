<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 7.6
* The Concurrency API includes classes which enable you to coordinate tasks between related threads.
* These classes are for very specific scenarios
* The classes I need to know for OCP:
1) `CyclicBarrier`
2) `ForkJoinPool`

## 🟥 7.6.1 Creating a CyclicBarrier

### 🟡 Introducing CyclicBarrier
* Suppose we have a lion pen which needs to be emptied, cleaned, and then filled back up with lions. We have 4 zoo workers, we do not want the to start cleaning when lions are present, and we do not want them to return until cleaning is complete.
* We want all four workkers to work concurrently, pausing between the end of one set of tasks and the start of the next.
* We use the `CyclicBarrier` class to achieve this, let's start the code without this though:
```java
import java.util.concurrent.*;
public class LionPenManager {
    private void removeAnimals() { System.out.println("Removing animals"); }
    private void cleanPen() { System.out.println("Cleaning the pen"); }
    private void addAnimals() { System.out.println("Adding animals"); }

    public void performTask() {
        removeAnimals(); cleanPen(); addAnimals();
    }

    public static void main() {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            LionPenManager manager = new LionPenManager();
            for(int i=0;i<4;i++)
                service.submit(() -> manager.peformTask());
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
```
* Here is a sample output based on the above:
```
Removing animals
Removing animals
Cleaning the pen
Adding animals
Removing animals
Cleaning the pen
Adding animals
Removing animals
Cleaning the pen
Adding animals
Cleaning the pen
Adding animals
```
* Due to this being multithreaded, the order is completely random.
* We can improve these results by using `CyclicBarrier`, this class takes a limit value - number of threads to wait for
* As each thread finishes, it calls the await method on the cyclic barrier. Once the specified number of threads have each called `await()`, the barrier is release and all threads can continue.
* Here's an implementation using `CyclicBarrier`:
```java
import java.util.concurrent.*;
public class LionPenManager {
    private void removalAnimals() { System.out.println("Removing animals"); }
    private void cleanPen() { System.out.println("Cleaning the pen"); }
    private void addAnimals() { System.out.printn("Adding animals"); }

    public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            removeAnimals();
            c1.await();
            cleanPen();
            c2.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
            // Handle checked exceptions here
        }
    }
    public static void main() {
        ExecutorService service = null;
        try {
            service = Executor.newFixedThreadPool(4);
            LionPenManager manager = new LionPenManager();
            CyclicBarrier c1 = new CyclicBarrier(4);
            CyclicBarrier c2 = new CyclicBarrier(4,
                () -> System.out.println("*** Pen Cleaned!"));
            for(int i=0;i<4;i++)
                service.submit(() -> manager.performTask(c1,c2));
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
```
* Here is the following sample output based on the above implementation:
```
Removing animals
Removing animals
Removing animals
Removing animals
Cleaning the pen
Cleaning the pen
Cleaning the pen
Cleaning the pen
*** Pen Cleaned!
Adding animals
Adding animals
Adding animals
Adding animals
```


### 🟡 Thread Pool Size and Cyclic Barrier Limit
* The number of available threads must be equal or greater to the CyclicBarrier limit value.
* E.g., if we have the following snippet, the code will hang indefinitely as this is a form of deadlock:
```java
ExecutorService service = Executors.newFixedThreadPool(2);
```

* The `CyclicBarrier` class allows you to peform complex, multi-threaded tasks where threads stop at a logical barrier. This is better than single threaded as the same task types can be done concurrentlyu
* There is a slight performance cost to using `CyclicBarrier` - one thread may be super slow which causes the other threads to wait
* When a CyclicBarrier is broken, all threads are released and the number of threads waiting on the CyclicBarrier goes to zero.

<hr>

## 🟥 7.6.2 Applying the Fork/Join Framework
* Suppose we need to measure the weight of all the animals in our zoo. Furthermore, we ask exactly one person to perform this task and complete it in an hour. When we hace no idea how many tasks need to be performed, we can split the task into multiple other tasks using fork/join framework.


<hr>

### 🟡 Introducing Recursion
* This framework is reliant on recursion to solve complex taskks.
* Recursion is the process by which a task calls itself to solve a problem.
* A recursive solution is created with a base case and recursive case:
* BASE CASE: a non-recursive method that is used to terminate the recursive path
* RECURSIVE CASE: a recursive method that may call itself 1 or more times to solve a problem.
* E.g. heres how we can calculate a factorial using recursion:
```java
public static int factorial(int n) {
    if(n<=1) return 1;
    else return n*factorial(n-1);
}
```
* If the base case never is reached, then the program will run infinitely; java throws a `StackOverflowError` anytime a recursion occurs too deeply
<hr>


* Let's use an array of Double values called weights, an suppose we have 10 animals in the zoo:
```java
Double[] weights = new Double[10];
```
* We have a constraint that a person can weigh at most three animals in an hour.
* Conceptually, we start off with a single zoo worker. They peform a recursive step by dividing the set of animals into two sets of 5
* The set is then subdivided until each worker has at most 3 animals to weigh - this is the base case.
* Applying the fork/join framework requires us to perform three steps:
1) Create a `ForkJoinTask`
2) Create the `ForkJoinPool`
3) Start the `ForkJoinTask`
* For the exam I need to know how to implement the fork/join solution by extending one of two classes: `RecursiveAction` and `RecursiveTask` - both are implementations of `ForkJoinTask` interface.

<br>

### 🟡 Working with `RecursiveAction`

* The `RecursiveAction` is an abstract class which requires us to implement the `void compute()` method to perform the bulk of the workk
* The `RecursiveTask` is an abstract class which requires us to implement the `<T> T compute()` method to perform the bulk of the work.
* Let's define a `WeightAnimalAction` which extends `RecursiveAction`:
```java
import java.util.*;
import java.util.concurrent.*;
public class WeighAnimalAction extends RecursiveAction {
    private int start;
    private int end;
    private Double[] weights;
    public WeighAnimalAction(Double[] weights, int start, int end) {
        this.weights = weights;
        this.start = start;
        this.end = ends;
    }
    protected void compute() {
        if(end-start < 3)
            for(int i=start; i<end; i++) {
                 weights[i] = (double)new Random().nextInt(100);
                 System.out.println("Animal Weighed: "+i);
            }
        else {
            int middle = start+((end-start)/2);
            System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
            invokeAll(new WeighAnimalAction(weights,start,middle),
                      new WeighAnimalAction(weights,middle,end));
        }
    }
}
```
* We start by defining the task and the arguments on which the task will operate, such as `start`, `end` and `weights`.
* We then override the `compute()` method which defines are base and recursive processes.
* For the base case, we split the work from one `WeighAnimalAction` object into two `WeighAnimalAction` instances. The amount of work is not split evenly!
* We create the `ForkJoinPool` and start the task:
```java
public static void main() {
    Double[] weights = new Double[10];

    ForkJoinTask<?> task = new WeighAnimalAction(weights,0,weights.length);
    ForkJoinPool pool = new ForkJoinPool();
    pool.invoke(task);

    // Print results
    System.out.println();
    System.out.println("Weights: ");
    Arrays.asList(weights).stream().forEach(
        d -> System.out.print(d.intValue()+" "));
}
```
* By default the `ForkJoinPool` class will use the number of processes as the number of threads to create. The following is a sample output of this code:
```
[start,middle=5,end=10]
[start=0,middle=2,end=5]
Animal Weighed: 0
Animal Weighed: 2
[start=5,middle=7,end=10]
Animal Weighed: 1
Animal Weighed: 3
Animal Weighed: 5
Animal Weighed: 6
Animal Weighed: 7
Animal Weighed: 8
Animal Weighed: 9
Animal Weighed: 4

Weights: 94 73 8 92 75 63 76 60 73 3
```

<br>

### 🟡 Working with a RecursiveTask
* Suppose we want to compute the sum of all weight values while processing the data.
* Instead of extending `RecursiveAction`, we could extend the generic `RecursiveTask` to calculate and return each sum in the `compute()` methyod.
* Here we use `RecursiveTask<Double>`:
```java
public class WeighAnimalTask extends RecursiveTask<Double> {
    private int start;
    private int end;
    private Double[] weights;
    public WeighAnimalTask(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }
    protected Double compute() {
        if(end-start<3) {
            double sum = 0;
            for(int i=start; i<end; i++) {
                weights[i] = (double)new Random().nextInt(100);
                System.out.println("Animal Weighed: "+i);
                sum += weights[i];
            }
            return sum;
        } else {
            int middle = start+((end-start)/2);
            System.out.println("[start"+start+",middle="+middle+",end="+end+"]");
            RecursiveTask<Double> otherTask = new WeighAnimalTask(weights,start,middle);
            otherTask.fork();
            return new WeighAnimalTaskk(weights,middle,end).compute() + otherTask.join;
        }
    }
}
```


<br>

### 🟡 Identifying Fork/Join Issues



