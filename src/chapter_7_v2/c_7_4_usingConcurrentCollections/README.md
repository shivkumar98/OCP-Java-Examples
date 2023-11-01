<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 7.4 Using Concurrent Collections
* The Concurrency API includes classes and interfaces which provide easy ways to implement thread safety on collection types, as well as improving performance.

<hr>

## 🟥 7.4.1 Introducing Concurrent Collections
* We COULD create concurrent collections, e.g.:
```java
public class ZooManager {
    private Map<String,Object> foodData = new HashMap<>();
    public synchronized void put(String key,String value) {
        foodData.put(key,value);
    }
    public synchronized Object get(String key) {
        return foodData.get(key);
    }
}
```
* Using a concurrent collection:
```java
public class ZooManager {
    private Map<String,Object> foodData = new ConcurrentHashMap<String,Object>();
    public void put(String key, String value) {
        foodData.put(key, value);
    }
    public Object get(String key) {
        return foodData.get(key);
    }
}
```
* We don't even need these methods as they call the implementation from `ConcurrentHashMap`!


<hr>

## 🟥 7.4.2 Understanding Memory Consistency Errors
* **Memory consistency errors** occur when two thread have inconsistentg views of the same data
* JVM will throw a `ConcurrentModificationException` when two threads attempt to modify a non-concurrent collection - this can occur even in a single-thread:
```java
Map<String,Integer> animalData = new HashMap<>();
animalData.put("penguin",1);
animalData.put("flamingo",2);
for(String key:animalData.keySet())
    animalData.remove(key); // THROWS ConcurrentModificationException
```
* We can avoid this issue by using the concurrent collection:
```java
Map<String,Integer> animalData = new ConcurrentHashMap<>();
animalData.put("penguin",1);
animalData.put("flamingo",2);
for(String key:animalData.keySet())
    animalData.remove(key);
```
* They iterator updates after each loop completes.

<hr>

## 🟥 7.4.3 Working with Concurrent Classes

### 🟡 Understanding SkipList Collections


### 🟡 Understanding CopyOnWrite Collections




<hr>

## 🟥 7.4.4 Obtaining Synchronized Collections

