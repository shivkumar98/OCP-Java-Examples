<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 7.7 Identifying Threading Problems
* A threading problem can occur in a multi-threaded application when two or more threads interact unexpectedly. E.g. two threads can block each other from accessing a code segment
* The Concurrency API was designed to get rid of such problems, we are able to create threads and manage complex thread interaction with few lines of code.
* The API reduces chance of threading problems but they can still occur!

## 🟥 7.7.1 Understanding Liveness
* Synchronizing on a method ensures all threads wait for other threads to finish before continuing. CyclicBarrier makes threads wait for a barrier limit to be reached before continuing
* **Liveness** is the ability for an application to execute in a timely manner.
* Liveness problems are when an application becomes unresponsice or stuckk in a state
* **There are three types of Liveness Problems**:
1) Deadlock
2) Starvation
3) Livelock

### 🟡 Deadlock
* **Deadlock is when two or more threads get blocked forever, waiting for each other**
* Suppose we have two foxes in a zoo: `Foxy` and `Tails`. 
* `Foxy` likes to eat first, then drink water
* `Tails` likes to drink first, then eat
* Neither likes to share, and will only finish their meal if they have exclusive access to both food and water
* It takes 100 milliseconds to run from one side to the other
* Suppose `Foxy` gets food first, and `Tails` gets the water first
* The following application models this:
```java
import java.util.concurrent.*;

public class Food {}
public class Water {}

public class Fox {
    public void eatAndDrink(Food food, Water water) {
        synchronized(food) {
            System.out.println("Got Food!");
            move();
            synchronized(water) {
                System.out.println("Got Water!");
            }
        }
    }
    public void drinkAndEat(Food food, Water water) {
        synchronized(water) {
            System.out.println("Got Water!");
            move();
            synchronized(food) {
                System.out.println("Got Food!");
            }
        }
    }
    public static void main() {
        // Create participants and resources
        Fox foxy = new Fox();
        Fox tails = new Fox();
        Food food = new Food(); Water water = new Water();

        // Process data
        ExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(10);
            service.submit(() -> foxy.eatAndDrink(food, water));
            service.submit(() -> tails.drinkAndEat(food, water));
        } finally {
            if (service!=null) service.shutdown();
        }
    }
}
```

### 🟡 Preventing Deadlockks

### 🟡 Starvation

### 🟡 Livelock

## 🟥 7.7.2 Managing Race Conditions