<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 7.6 Managing Concurrent Processes
* The concurrency API includes the following classes to to coordinate tasks among thread groups:
1) `CyclicBarrier`
2) `ForkJoinPool`

<br><hr>

## 🟥 7.6.1 Creating a CyclicBarrier
* Suppose we have the following situation where we have lions in a cage, and 4 zoo workers who need to coordinate the following tasks:
1) Remove lions from the cage - only 1 worker can move a lion at a time
2) Clean the cage - can only be done when lions are cleared
3) Bring in the lions - can only be done when cage is cleaned
* The Zoo worker would have the following class:
```java
public void LionPenManager {
    void removeLion() {
		System.out.println(Thread.currentThread().getId()+" Removing Lion");
	}
	void cleanCage() {
		System.out.println(Thread.currentThread().getId()+" Cleaning cage");
	}
	void addLion() {
		System.out.println(Thread.currentThread().getId()+" Adds Lion");
	}
	public void performTasks() {
		removeLion();
		cleanCage();
		addLion();
	}
}
```
* Without any intervention, if I wrote an application in which 4 managers did NOT coordinate tasks:
```java
ExecutorService service = Executors.newFixedThreadPool(4);
LionPenManager manager = new LionPenManager();
try {
    for (int i=0;i<4;i++) // 4 lions
        service.submit(() -> manager.performTasks());
} finally {
    if(service!=null) service.shutdown();
}
```
* Running this application will print:
```
18 Removing Lion
18 Cleaning cage
18 Adds Lion
15 Removing Lion
17 Removing Lion
16 Removing Lion
16 Cleaning cage
16 Adds Lion
17 Cleaning cage
15 Cleaning cage
17 Adds Lion
15 Adds Lion
```
* Clearly this is not achieving what we expect!
<br>

* We can create a logical barrier for our program, which will restrict the threads from moving to the next tasks until the current task is completed!
* We update the `performTask()` method such that it accepts a CyclicBarrier:
```java
public void performTasks(CyclicBarrier c1) {
    try {
        removeLion();
        c1.await();
        cleanCage();
        addLion();
    }
}
// MAIN METHOD:
ExecutorService service = Executors.newFixedThreadPool(4);
LionPenManager manager = new LionPenManager();
CyclicBarrier c1 = new CyclicBarrier(4);
try {
    for(int i=0;i<4;i++)
        service.submit(() -> manager.performTask(c1));
} finally {
    if(service!=null) service.shutdown();
}
```
* We update the main program and supply a `CyclicBarrier(int parties)` object.
* Now when a thread calls `removeLion()`, it will be paused by `c1.await()` until the number of `parties` from the CyclicBarrier is reached (4 in this case)
* Now if we run this code, we get the following result:
```
15 Removing Lion
17 Removing Lion
18 Removing Lion
16 Removing Lion
17 Cleaning cage
16 Cleaning cage
16 Adds Lion
17 Adds Lion
15 Cleaning cage
15 Adds Lion
18 Cleaning cage
18 Adds Lion
```
* We have now ensured, that the threads will not begin the other tasks until the CyclicBarrier limit is achieved.
* We still need the `addLion()` to be coordinated:
```java
public void performTasks(CyclicBarrier c1, CyclicBarrier c2) {
    try {
        removeLion();
        c1.await();
        cleanCage();
        c2.await();
        addLion();
    } catch (Exception e) {
        // handle exception
    }
}
// MAIN METHOD:
ExecutorService service = Executors.newFixedThreadPool(4);
LionPenManager manager = new LionPenManager();
CyclicBarrier c1 = new CyclicBarrier(4);
CyclicBarrier c2 = new CyclicBarrier(4);
try {
    for(int i=0;i<4;i++)
        service.submit(() -> manager.performTasks(c1,c2));
    
} finally {
    if(service!=null) service.shutdown();
}
```
* Running the application:
```
16 Removing Lion
18 Removing Lion
15 Removing Lion
17 Removing Lion
15 Cleaning cage
17 Cleaning cage
16 Cleaning cage
18 Cleaning cage
15 Adds Lion
18 Adds Lion
17 Adds Lion
16 Adds Lion
```
* The CyclicBarrier limit must be smaller or equal to the number of threads available, otherwise the code will hang indefinintely!


<br><hr>

## 🟥 7.6.2 Applying the Fork/Join Framework
* Suppose we need to weigh all the animals in the zoo.
* If we had a single worker, it would take 1 hour to complete
* Suppose we have 10 animals, so we initialise an array to store the weights:
```java
Double[] weights = new Double[10];
```
* We are constrained that a worker can only weight 3 animals in an hour.
* The 10 animals are split into 5, and then the 5 is split to 2 and 3 animals.
* We apply the fork/join framework with 3 steps:
1) Create a `ForkJoinTask`
2) Create the `ForkJoinPool`
3) Start the `ForkJoinTask`

* We have the choice of extending either `RecursiveAction` or `RecursiveTask` (both implement `ForkJoinTask`)

### 🟡 Working with `RecursiveAction`
* This requires us to implement `void compute()` to perform the task:
```java
public class WeighAnimalAction extends RecursiveAction {
    private int start;
    private int end;
    private Double[] weights;
    public WeighAnimalAction(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }
    protected void compute() {
        if(end-start <= 3)
            for(int i=start;i<end;i++) {
                weights[i] = (double)new Random().nextInt(100);
                System.out.println("Anmal Weighed: "+i);
            }
        else {
            int middle = start + ((end-start)/2);
            System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
            invokeAll(new WeighAnimalAction(weights,start,middle),
                      new WeighAnimalAction(weights,middle,end));
        }
    }
    public static void main(String[] args) {
        Double[] weights = new Double[10];

        ForkJoinTask<?> task = new
            WeighAnimalAction(weights, 0, weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);

        // Printt results:
        System.out.println("Weights: ");
        Arrays.asList(weights).stream().forEach(
            d -> System.out.println(d.intValue()+" ");
        )
    }
}
```
* Here is sample output:
```
[start=0,middle=5,end=10]
[start=0,middle=2,end=5]
Animal Weighed: 0
Animal Weighed: 1
Animal Weighed: 2
Animal Weighed: 3
Animal Weighed: 4
[start=5,middle=7,end=10]
Animal Weighed: 7
Animal Weighed: 8
Animal Weighed: 9
Animal Weighed: 5
Animal Weighed: 6

Weights: 82 45 61 31 93 73 71 20 47 66
```

### 🟡 Working with a `RecursiveTask`

### 🟡 Identifying Fork/Join Issues