@ -1,76 +0,0 @@
<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 7.4 Using Concurrent Collections
* The `Concurrency API` also included classes and interfaces which help you coordinate access to collections across multiple processes
* This section will show the concurrent classes available in the Concurrency API

## 🟥 7.4.1 Introducing Concurrent Collections
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
* When two threads attempt to modify the same non-concurrent collection, Java will throw a `ConcurrentModificationException` at runtime.
* We can get this exception even single threaded, e.g. trying to delete a key from a map while looping through it:
```java
Map<String, Object> food = new HashMap<>();
    food.put("chicken", 21);
    food.put("beef", 12);
    for (String key: food.keySet())
        food.remove(key); 
    // throws ConcurrentModification exception
```

* We can fix this, they keyset is updated after each loop:
```java
Map<String, Object> concurrentFood = 
        new ConcurrentHashMap<>();
concurrentFood.put("chicken", 21);
concurrentFood.put("beef", 12);
for (String key: concurrentFood.keySet()) {
    System.out.println("concurrentFood:"+concurrentFood);		
    concurrentFood.remove(key);
}
// concurrentFood:{chicken=21, beef=12}
// concurrentFood:{beef=12}
```
* At any given instance, each thread has a consistent view of the same data❗

<hr>

## 🟥 7.4.3 Working with Concurrent Classes


### 🟡 Understanding SkipList Collections
* The `SkipList` classes are `ConcurrentSkipListSet` and `ConcurrentSkipListMap`. These are the concurrent versions of `TreeSet` and `TreeMap`.

### 🟡 Understanding CopyOnWrite Collections
* We have `CopyonWriteArrayList`, and `CopyOnWriteArraySet` which are two concurrent classes which behave slightly different from the other concurrent classes.
* These classes copy all of their elements to a new structur anytime an element is removed, accessed or modified - the reference is changed, not that the content is changed.
* While the data is copied to a new structure, the reference to the object is unchanged - this is of benefit to multi-threading which need to iterate a collection.
* Any iterator created will only iterate over the original elements before any modification. E.g.:
```java
List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4,3,52));
for(Integer item: list) {
    System.out.println(item+" ");
    list.add(9);
}
System.out.println("Size: "+list.size());
```
* This prints the following:
```
4 3 52
Size: 6
```
* A regular array list would throw a `ConcurrentModificationException`
* These `CopyOnWrite` classes use alot of memoery since, a new collection is allocated when its modified⚠️

<hr>

## 🟥 7.4.4 Obtaining Synchronized Collections
* The Concurrency API includes methods to convert non-concurrent collections into concurrent variants. These methods contain synchronized methods which return a reference of the same type as underlyind collection:

| Method Name                                   |
| --------------------------------------------- |
| `synchronizedCollection(Collection<T> c)`     |
| `synchronizedList(List<t> list)`              |
| `synchronizedMap(Map<K,V> map)`        |
| `synchronizedNavigableMap(NavigableMap<K,V> m) ` |
| `synchronizedNavigableSet(NavigableSet<T> s)` |
| `synchronizedSet(Set<T> s)`                   |
| `synchronizedSortedMap(SortedMap<K,V> m)`     |
| `synchronizedSortedSet(SortedSet<T> s)`       |

* The above methods will synchroinized the `get()/set()` methods, but it will NOT synchronize any iterators you may create from the synchronized collection⚠️
* You MUST use a synchronized block for iterators like below:
```java
List<Integer> list = Collections.synchronizedList(new ArrayList<>(Arrays.asList(4,3,52)));
synchronized(list) {
    for (int data: list)
        System.out.println(data+" ");
}
```
* Unlike Concurrent Collections, you can not concurrently modify a synchronized collection in an iterator without an exceptions being thrown!
<hr>