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
    public void move() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // Handle exception
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

* In this application, Foxy obtains the food and Tails obtains the water. Foxy finishes and moves and tries to get water, but is blocked as Tails is drinking water. But Tails is blocked from Eating as Foxy hasn't started drinking yet
* Thefore the following is printed but hangs forever:
```
Got Food! (from foxy)
Got Water! (from tails)
```

### 🟡 Preventing Deadlocks
* In most situations you can not fix a deadlock after is has occured!
* A strategy to avoid deadlockks is for all threads to order their resource requests. E.g. we can enforce that both foxes need to obtain food before water.

### 🟡 Starvation
* If a thread is continually denied access to a shared resource, it experiences **starvation**

### 🟡 Livelock
* Livelock is a special case of Deadlock, the threads attempt to resolve a deadlock but both end up blocking each other. We have a constant cycle of switching states

<hr>

## 🟥 7.7.2 Managing Race Conditions
* A **race condition** is an undesirable result which occurs when two tasks which should be done sequentially, are completed at the sametime
* Suppose we have a zoo website, where new visitors can register.
* Suppose two user attempt to create an account with the same name: `ZooFan`
* There are 3 possible outcomes for this race condition:
1) Both users are able to register with the same name - this is the worst outcome as it leads to invalid data
2) Both users are unable to create an account - this is a preferred outcome as no data is invalid
3) One user is able to create the account, the other recieves an error message - this is the most preferred outcome

* For the exam, I need to understand that race conditions lead to invalid data if they are not properly handled.
* Race conditions occur in highly concurrent application. One solution to the above system, is that the username is reserved once its entered.