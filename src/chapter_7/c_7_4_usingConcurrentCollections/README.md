<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 7.4 Using Concurrent Collections
* The `Concurrency API` also included classes and interfaces which help you coordinate access to collections across multiple processes
* This section will show the concurrent classes available in the Concurrency API

## 🟥 7.4.1 Indtroducing Concurrent Collections
* We could use `synchronized` methods, but the Concurrent collections which offer better performance and more convience
* E.g. here's using a synchronized method and rewriting it to use a concurrent class:
```java
public class ZooManager {
    private Map<String, Object> food = new HAshMap<>();
    public synchronized void put(String key, String value){
        food.put(key,value);
    }
    public sychronized Object get(String key) {
        return food.get(key);
    }
}

public class ZooManager {
    private Map<String,Object> food = new ConcurrentHashMap<>();
    public void put(String key, String value){
        food.put(key,value);
    }
    public Object get(String key) {
        return food.get(key);
    }
}
```
* The put/get methods are using the implementation from the `ConcurrentHashMap`
<hr>

## 🟥 7.4.2 Understanding Memory Consistency Errors
* Concurrent Collections solve `memory consistency errors` - this is their purpose.
* **Memory consistency errors** is when two threads have inconsistent views of data.
<hr>

## 🟥 7.4.3 Working with Concurrent Classes

<hr>

## 🟥 7.4.4 Obtaining Synchronized Collections

<hr>




