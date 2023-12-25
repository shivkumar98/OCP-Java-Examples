<link href="../styles.css" rel="stylesheet"></link>

# 🧠 Chapter 7 Revision Notes

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