<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 4.6 Working with Advanced Stream Pipeline Concepts

## 📜 Contents 📜

- [🌸 Introduction 🌸](#🌸-introduction-🌸)
- [🔴 4.6.1 Linking Streams to the Underlying Data ](#🔴-461-linking-streams-to-the-underlying-data)
- [🔴 4.6.2 Chaining Optionals](#🔴-462-chaining-optionals)
- [🔴 4.6.3 Collecting Results](#🔴-463-collecting-results)


## 🌸 Introduction 🌸

* Here we will see thew relationship between streams and underlying data, chaining Optional and grouping collectors.

<hr>

## 🔴 4.6.1 Linking Streams to the Underlying Data

* What do you think the following outputs

```java
List<String> cats = new ArrayList<>();
cats.add("Annie");
cats.add("Ripley");
Stream<String> stream = cats.stream(); // LINE 28
cats.add("KC");
System.out.println(stream.count());
```

* My answer: 2❌

* The correct answer is 3✅ Streams are lazily-evaluated, which means the stream is not actually created on line 28! The final line where we evaluate `stream.count()` is only where the Stream is created!

<hr>


## 🔴 4.6.2 Chaining Optionals

* Optionals have a few intermediate stream operations.  

* ❓Suppose you are given an `Optional<Integer>` and asked to print the value, ONLY IF its a 3 digit method❓

* WITHOUT functional programming, it could be done as:

```java
private static void threeDigit(Optional<Integer> optional) {
    if (optional.isPresent()) {
        Integer num = optional.get();
        String str = "" + num;
        if (str.length()==3)
            System.out.println(str)
    }
}
```

* WITH functional programming:

```java
private static void threeDigit(Optional<Integer> optional) {
    optional.map(n->""+n)
            .filter(s->s.length()==3)
            .ifPresent(System.out::println);
}
```

* Suppose we have the following method:

```java
public class ChainingOptionals {
	static Optional<Integer> calculator(String s){
		return Optional.of(1);
	}
}
```

* and suppose we have an `Optional<Integer>` storing the length of an optional String:

```java
Optional<String> optional = Optional.of("Shiv");
// we map the to lengths:
Optional<Integer> result = optional.map(String::length);
```

* We can NOT write the following:

```java
Optional<Integer> result2 = optional.map(ChainingOptionals::calculator);  // ^^ DOES NOT COMPILE
```

* We can however write the following:

```java
Optional<Optional<Integer>> result2 = optional.map(ChainingOptionals::calculator);
```

* To get what we want we can call `flatMap()`:

```java
Optional<Integer> result optional.flatMap(ChainingOptionals::calculator);
```

### ⭐ Checked exceptions and Functional interfaces ⭐

* What if the method we have a method which throws an exception:

```java
class ExceptionCaseStudy {
    private static List<String> create() throws IOException {
        throw new IOException();
    }
}
```

* We can use it within a stream: `ExceptionCaseStudy.create().stream().count();`

* However we can not write the following without a compiler error:

```java
Supplier<List<String>> s = ExceptionCaseStudy::create; // DOES NOT COMPILE
```

* We can create a wrapper method with a try/catch:

```java
class ExceptionCaseStudy {
    private static List<String> create() throws IOException { /**/ }
    private static List<String> createSafe() {
        try {
            return ExceptionCaseStudy.create();
        } catch (IOException e) {
            throw new RunTimeException();
        }
    }
}
```

* Here is the safe wrapper version:

```java
Supplier<List<String>> s2 = ExceptionCaseStudy::createSafe;
```

<hr>

## 🔴 4.6.3 Collecting Results

* We've seen the `collect()` terminal operation but there are other avaialable operations to collect results:

| Collector | Description | Return Value when passed to collect |
| --------- |-------------|-------------------------------------|
|`averagingDouble(ToDoubleFunction f)`<br>`averagingInt`<br>`averagingLong` | Calculates mean | Double |
|`counting` | counts number of elements | long |
|`groupingBy(Function f)`<br>`GroupingBy(Function f), Collector dc)`<br>`groupingBy(Function f, Supplier s, Collector dc)`| Creates a map grouped by the function | `Map<K, List<T>>` |
|`joining()`<br>`joining(CharSequence cs)` | Creates a String using `cs` as delimiter | String |
|`maxBy(Comparator c)`<br>`minBy(Comparator c)`| Finds the smallest/largest element | `Optional<T>` |
| `mapping(Function f, Collector dc)` | Creates a map grouping by specified by predicate | `Map<Boolean, List<T>>` |
| `summarizingDouble(ToDoubleFunction f)`<br>`summarizingInt(ToIntFunction)`<br>`summarizingLong<ToDoubleFunction f)` | Calculates the avg, min, max etc | `DoubleSummaryStatistics`<br>`IntSummaryStatistics`<br>`LongSummaryStatistics`|
| `summingDouble(ToDoubleFunction f)`<br>`summingInt(ToIntFunction f)`<br>`summingLong(ToLongFunction f)` | Calculates the sum | `Double`<br>`Integer`<br>`Long` |
| `toList()`<br>`toSet()` | Creates list/set of stream | `List`<br>`Set` |
| `toCollection(Supplier s)` | Creates a Collection of specified type | Collection | 
| `toMap(Function k, Function v)`<br>`toMap(Function k, Function v, BinaryOperator m)`<br>`toMap(Function k, Function v, BinaryOperator m, Supplier s)` | Creates a map using functions to map the keys, values and ooptional merge function | Map |

### ⭐ Collecting Using Basic Collectors ⭐

* Most of the collectors work in the same way!

#### 🟢 E.g. 1:

```java
Stream<String> animals = Stream.of("lions", "tigers", "bears");
String str = animals.collect(Collectors.joining(", "))
System.out.println(str); // lions, tigers, bears
```

* Notice how predefined collectors are in `Collectors` rather than `Collector` class🤔

* It's important to pass the `Collector` to within the `collect()` method!


#### 🟢 E.g. 2:

* Here's an example of finding the average string length of a stream:

```java
Stream<String> animals = Stream.of("lion","bear","tiger");
Double avgLength = animals.collect(Collectors.averagingInt(String::length));
System.out.println(avgLength); // 4.333333333333333
```

#### 🟢 E.g. 3:

* When interacting with legacy code, you will see `Collection` rather than `Stream` type. We can use Collectors to convert our stream to a Collection type:

```java
Stream<String> animals1 = Stream.of("turtoise", "tiger", "lion");
TreeSet<String> result = animals1
    .filter(s -> s.startsWith("t"))
    .collect(Collectors.toCollection(TreeSet::new));
System.out.println(result); // [tiger, turtoise]
```

### ⭐ Collecting into Maps ⭐

#### 🟢 E.g. 1:

* Let's create a map, where the key is the animal and the value is the string length:

```java
Stream<String> animals = Stream.of("Ape", "Bear", "Frog", "Tiger");
Map<String, Integer> map = animals.collect(Collectors.toMap(s->s, s->s.length()));
System.out.println(map); // {Frog=4, Ape=3, Bear=4, Tiger=5}
```
#### 🟢 E.g. 2:

* Now we want to have a map where the keys represent the lengths and the value corresponds to any string with the given length!.

* I.e. we want to generate: `{3=Ape, 4=Frog,bear, 5=Tiger}`

```java
Stream<String> animals2 = Stream.of("Ape", "Bear", "Frog", "Tiger");
Map<Integer, String> map2 = animals2
.collect(Collectors
        .toMap(s->s.length(), s->s, (s1,s2)->s1+","+s2));
System.out.println(map2); // {3=Ape, 4=Bear,Frog, 5=Tiger}
```

* ⚠️If we did not have the `(s1,s2)->s1+","+s2` part, the above would throw an exception!⚠️

* `map2` is actually a HashMap! If we wanted to have a TreeMap returned instead, we would write:

```java
Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
TreeMap<Integer, String> map = ohMy.collect(Collectors.toMap(
String::length, k -> k, (s1, s2) -> s1 + "," + s2, TreeMap::new));
System.out.println(map); // // {5=lions,bears, 6=tigers}
System.out.println(map.getClass()); // class. java.util.TreeMap
```

### ⭐ Collecting Using Grouping, Partitioning and Mapping ⭐

#### 🟢 E.g. 1 Grouping

* Suppose we want to get groups of names by their lengths!

```java
Stream<String> ohMy = Stream.of("lions","tigers","bears");
Map<Integer, List<String>> map = ohMy.collect(Collectors.groupingBy(String::length));
System.out.println(map); // {5=[lions, bears], 6=[tigers]}
```

* If we wanted to collect the values into a set, we can overload the `groupingBy()` method:

```java
Stream<String> ohMy = Stream.of("lions","tigers","bears");
Map<Integer, Set<String>> map =
    ohMy.collect(Collectors.groupingBy(String::length), Collectors.toSet());
System.out.println(map); // {5=[lions, bears], 6=[tigers]}
```

* We can change the return type through another parameter:

```java
// changing return type to TreeMap<>:
Stream<String> ohMy2 = Stream.of("lions","tigers","bears");
TreeMap<Integer, Set<String>> map2 =
    ohMy2.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
System.out.println(map2); // {5=[lions, bears], 6=[tigers]}
```

#### 🟢 E.g. 2 Partitioning

* Paritioning is a type of grouping where the groups are `true` or `false`.

* Suppose we want to partition a stream by the length of the elements:

```java
Stream<String> animals = Stream.of("lions", "tigers", "bears");
Map<Boolean, List<String>> map3 = 
    animals.collect(Collectors.partitioningBy(s->s.length()<6));
System.out.println(map3); // {false=[tigers], true=[lions, bears]}
```

* ⚠️We CAN change the value of the map, but not the returned map itself:⚠️

```java
Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
Map<Boolean, Set<String>> map =
    ohMy.collect(Collectors.partitioningBy(s->s.length()<=7, Collectors.toSet()>))
System.out.println(map);// {false=[], true=[lions, tigers, bears]}
```

* Suppose we wanted to know the number of elements corresponding to each group:

```java
Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
Map<Integer, Long> map = 
    ohMy.collect(Collectors.groupingBy(String::length, Collectors.counting()));
System.out.println(map); // {5=2, 6=1}
```


#### 🟢 E.g. 3 Mapping

* Suppose we want to get the first animal alphabetically of each length:

```java
Stream<String> ohMy4 = Stream.of("lions", "tigers", "bears");
Map<Integer, Optional<String>> map4 = ohMy4.collect(
        Collectors.groupingBy(
        String::length,
        Collectors.mapping(s -> s,
        Collectors.minBy(Comparator.naturalOrder()))));
System.out.println(map4); // {5=Optional[bears], 6=Optional[tigers]}
```
