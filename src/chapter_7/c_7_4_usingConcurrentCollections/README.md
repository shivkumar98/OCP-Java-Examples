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
* You should use concurrent classes when you have multiple threads writing to a collection outside a synchronized block/method
* A read-only, immutable collection is not required to be implemented as a concurrent collection.
* It is good practice to pass the non-concurrent interface into a method
* Here is a list of `Concurrent collection classes`:
1) `ConcurrentHashMap` - interface is `ConcurrentMap`
2) `ConcurrentLinkedDeque` - interface is `Deque`
3) `ConcurrentLinkedQueue` - interface is `Queue`
4) `ConcurrentSkipListMap` - interfaces are `ConcurrentMap`, `SortedMap`, `NavigableMap`
5) `ConcurrentSkipListSet` - interfaces are `SortedSet`, `NavigableSet`
6) `CopyOnWriteArrayList` - interfaces is `List`
7) `CopyOnWriteArraySet` - interfaces is `Set`
8) `LinkedBlockingDeque` - interfaces are `BlockingQueue`, `BlockingDeque`
9) `LinkedBlockkingQueue` - interface is `BlockingQueue`

* The ConcurrentHashMap, ConcurrentLinkedQueue and ConcurrentLinkedDeque behave exactly as their non-concurrent versions:
```java
Map<String,Integer> map = new ConcurrentHashMap<>();
map.put("zebra", 52);
map.put("elephant", 10);
System.out.println(map.get("elephant")); // 10
```

### 🟡 Understanding Blocking Queues
* We have two classes which implement blocking interfaces: `LinkedBlockingQueue` and `LinkedBlockingDeque`
* `BlockingQueue` has methods which wait a specied amount of time to finish an operation:
1) `poll(long timeout, TimeUnit unit)` - retrieves and removes item in alotted time, returns null if time elapses.
* `BlockkingDeque` has the following methods:
1) `offerFirst(E e, long timeout, TimeUnit unit)` - adds item to front of queue, waiting the alotted time. Returns false if time elapses
2) `offerLast(E e, long timeout, TimeUnit unit)` - adds item to back of queue, waiting the alotted time.
3) `pollFirst(long timeout, TimeUnit unit)` - retrieves and removes the first item, returns null if time elapses
4) `pollLast(long timeout, TimeUnit unit)` - retrieves and removes last item.

### 🟡 Understanding SkipList Collections
* The `ConcurrentSkipListMap` and `ConcurrentSkipListSet` are concurrent versions of their ordered counterparts: `TreeMap` and `TreeSet`


### 🟡 Understanding CopyOnWrite Collections
* The `CopyOnWriteArrayList`, and `CopyOnWriteArraySet` classes copy all their eleents to a new underlying structure anytime an element is removed, added or modified - reference has changed.
* These classes are useful when you need to iterate over a collection in a multithreaded environment
* E.g.:
```java
List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4,3,52));
for(Integer item: list) {
    System.out.print(item+" ");
    list.add(9)
}
System.out.println("/nSize: "+list.size());
```
* This will print the following:
```
4 3 52
Size: 6
```


<hr>

## 🟥 7.4.4 Obtaining Synchronized Collections
* The Concurrency API has methods to obtain synchronized versions of non-concurrent objects.
* We have the following methods:
1) `synchronizedCollection(Collection<T> c)`
2) `synchronizedList(List<T> list)`
3) `synchronizedMap(Map<K,V> m)`
4) `synchronizedNavigableMap(NavigableMap<K,V> m)`
5) `synchronizedNavigableSet(NavigableSet<T> s)`
6) `synchronizedSet(Set<T> s)`
7) `synchronizedSortedMap(SortedMap<K,V> m)`
8) `synchronizedSortedSet(SortedSet<T> s)`

* While these methods will synchronize access to the data of the collection, they will not synchronize access of iterators
* Also, unlike the concurrent collections, you will always get a `ConcurrentModificationException` if you attempt to modify the collection in a for loop:
```java
Map<String, Object> foodData = new HashMap<String, Object>();
foodData.put("penguin", 1);
foodData.put("flamingo", 2);
Map<String,Object> synchronizedFoodData = Collections.synchronizedMap(foodData);
for(String key: synchronizedFoodData.keySet())
    synchronizedFoodData.remove(key); // throw ConcurrentModificationException
```