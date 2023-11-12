<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 7.7 Identifying Threading Problems
* We can have threading problems with multi-threaded applications.
* E.g. two threads can block each other from accessing code
* The `Concurrency API` helps mitigate these isssues but they can still occur

<br><hr>

## 🟥 7.7.1 Understanding Liveness
* Some thread operations can be performed independently, but some need coordination like when we synchronise a method which means the threads wait for threads to finish before moving on.
* E.g. the CyclicBarrier enforces a lock on the threads until a specified number of threads are waiting reach the barrier limit
* **Liveness** is the ability for the app to run in a timely manner, with no unexpected delays
* There are 3 types of Liveness Problems:
1) Deadlock
2) Starvation
3) Livelock

### 🟡 Deadlock
* Deadlock occurs when two or more threads are blocked forever, waiting for each other.
* Suppose we have two foxes:
1) `Foxy` - likes to eat, then drink. Can not drink while Tails is drinking
2) `Tails` - likes to drink, then eat. Can not eat while Foxy is eating
* It takes 100ms for the foxes to run from one environment to the other
* Here is an application which models this:
```java
public class Food {}
public class Water {}
public class Fox {
    String name;
    public Fox(String name) {
        this.name = name;
    }

    void move() {
        try {
            System.out.println(name+" moving");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // handle exception
        }
    }
    void eatAndDrink(Food food, Water water) {
        synchronized(food) {
            System.out.println(name+" Got Food!");
            move();
            synchronized(water) {
                System.out.println(name+" Got Water!");
            }
        }
    }
    void drinkAndEat(Food food, Water water) {
        synchronized(water) {
            System.out.println(name+" Got Water!");
            move();
            synchronized(food) {
                System.out.println(name+" Got Food!");
            }
        }
    }

    public static void main() {
        Fox foxy = new Fox("foxy");
        Fox tails = new Fox("tails");
        Food food = new Food();
        Water water = new Water();

        // process data
        ExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(10);
            service.submit(() -> foxy.eatAndDrink(food,water));
            service.submit(() -> tails.drinkAndEat(food,water));
        } finally {
            if(service!=null) service.shutdown();
        }
    }
}
```
* Here is a sample output:
```
foxy Got Food!
tails Got Food!
tails moving
foxy moving
```
* As we can see foxy is blocked from drinking, and tails is blocked from eating!
If we removed the synchronized blocks, then both foxy and tail would've been able to both eat and drink.

### 🟡 Starvation
* **Starvation** happens when a single thread is continually denied access to a resource or lock. It is active but unable to finish task due to other threads taking the resource

### 🟡 Livelock
* **Livelock** is a special case of starvation. When two threads attempt to resolve a deadlock by continually attempting to acquire resources but are unable to do so, and restart part of the process

<br><hr>

## 🟥 7.7.2 Managing Race Conditions
* A **Race Condition** is a an undesirable result which occurs when two task are completed at the same time, when they should be done sequentially.
* Suppose we have a website, and two different users attempt to register with username `ZooFan` at the same time
* This is a race condition with the following outcomes:
1) Both uses are able to register the username - UNDESIRABLE
2) Both users are unasble to register - NOT UNDESIREABLE
3) One user is able to register, while the other recieves an error messager - MOST DESIRABLE