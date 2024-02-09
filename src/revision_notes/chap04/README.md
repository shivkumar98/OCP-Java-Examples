<link href="../../styles.css" rel="stylesheet"></link>

# 🧮 Chapter 4 - Functional Programming - Revision Notes ✍️

## 🟥 4.1 Built-In Functional Interfaces
* All Java 8 functional interfaces are in the `java.util.function` package.
* These interface use `T`,`U` as parameters, and `R` as return type
* Here are the functional interfaces I need to be aware of:
### ⭐ 1. `T Supplier<T>`
* This interface is used to supply data. E.g.:
```java
Supplier<String> s1 = () -> "hello";
Supplier<LocalDate> s2 = LocalDate::now;
LocalDate d1 = s2.get();
```

### ⭐ 2. `void Consumer<T>` and `void BiConsumer<T, U>`
* Consumers consume data and return nothing
* The `BiConsumer<T,U>` accepts two parameters
```java
class NumberClass {
	static void print(int i) {
		System.out.println("num: "+i);
	}
	static void multiply(int i, int j) {
		System.out.println("product: "+i*j);
	}
}
public class UsingConsumers {
	public static void main(String[] args) {
		Consumer<Integer> c1 = i -> NumberClass.print(i);
		c1.accept(2); // num: 2
		BiConsumer<Integer, Integer> c2 = NumberClass::multiply;
		c2.accept(3, 4); // product: 12
	}
}
```

### ⭐ 3. `boolean Predicate<T>` and `boolean BiPredicate<T, U>`
* Predicates test for a condition on data
```java
Predicate<String> stringIsEmpty = String::isEmpty;
BiPredicate<String> stringIsOfLength = (string, length) -> string.length()==length;
```

* These functional interfaces also contain default methods: `negate()` and `and()`
```java
Predicate<String> containsVowel 
	= t -> t.matches(".*[aeiou].*");
Predicate<String> containsConstant
	= t -> t.matches(".*[bcdfghjklmnpqrstvwxyz].*");
Predicate<String> containsVowelsOnly
	= containsVowel.and(containsConstant.negate());
Predicate<String> containsNeitherVowelsOnConstants
			= containsVowel.negate().and(containsConstant.negate());
		
System.out.println(containsVowelsOnly.test("ae")); // true
System.out.println(containsVowelsOnly.test("abs")); // false
System.out.println(containsNeitherVowelsOnConstants.test("!")); // true
System.out.println(containsNeitherVowelsOnConstants.test("h!")); // false
```

### ⭐ 4. `R Function<T,R>` and `R BiFunction<T, U, R>`
* Function and BiFunction are like mathematical functions, they can transform one type to another
```java
Function<String, Integer> f1 = String::length;
System.out.println(f1.apply("hello")); // 5
Function<String, Character> f2 = str->str.charAt(0);
System.out.println(f2.apply("hello")); // h
```
### ⭐ 5. `T UnaryOperator<T>` and `T BinaryOperator<T>`
* UnaryOperator and BinaryOperators only accept and return one type! `T`
```java
UnaryOperator<String> b1 = str->str+" world";
System.out.println(b1.apply("hello")); // hello world

BinaryOperator<String> b2 = String::concat;
System.out.println(b2.apply("hello ", "world")); // hello world 
```

## 🟥 4.2 Optional
* The `Optional` class is used to wrap a value which may not exist
* The Optional class has the following methods:
	- `E get()` - throws exception if empty
	- `boolean ifPresent(Consumer)` - calls consumer if empty
	- `boolean isPresent()`
	- `E orElse(E other)` - returns other if empty
	- `E orElseThrow(Supplier)` - throws exception using supplier if empty

## 🟥 4.3 Streams
### ⭐ Creating Streams
* We can create finite streams by specifying elements, or converting an existing collection to a stream
```java
Stream<String> emptyStream = Stream.empty();
Stream<Integer> numStream = Stream.of(1,2,3);
Stream<String> letterStream = Arrays.asList("a","b","c").stream();
```
* We can create **infinite streams** using `.generate()` and `.iterate()`
```java
Stream<Double> randoms = Stream.generate(()->Math.random());
Stream<Integer> sequence = Stream.iterate(1, i->i+2);
```

### ⭐ Terminal Operations
* Streams are lazily evaluated, so intermediary operations like `peek()` do not run unless there is a terminal operation
* Here are the terminal operations:
1. 📟 `count()`📟
* This IS a reduction❗
```java
long count();
```
* This method hangs for infinite streams

2) 📟 `min()`/`max()`📟
* This IS a reduction⚠️
```java
Optional<T> min(Comparator);
Optional<T> max(Comparator);
```
* In order to use `min`/`max`, you need to supply the Comparator!
```java
Stream<String> letters = Stream.of("b","c","a","d");
Optional<String> opt = letters.min((a,b)->a.compareTo(b));
System.out.println(opt.get()); // a
```

3) 📟 `findAny()`/`findFirst()` 📟
* This is NOT a reduction❗
```java
Optional<T> findAny();
Optional<T> findFirst();
```

```java
Stream<String> infiniteLetters = Stream.generate(()->"hello");
System.out.println(infiniteLetters.findAny().get()); // hello
```

4) 📟 `allMatch()`/`anyMatch()`/`noneMatch()` 📟
* These methods ARE reductions❗
* All 3 of these methods 
```java
boolean allMatch(Predicate);
boolean anyMatch(Predicate);
boolean noneMatch(Predicate);
```

5) 📟 `forEach()` 📟
```java
void forEach(Consumer)
```
* While `forEach()` is not a reduction, it IS a terminal operation!!!
* It is not a reduction as it does not return anything⚠️
* This is the only way to loop through a stream!
```java
public class UsingForEach {
	static String printOddOrEven() {
		System.out.println(i+" is "+(i%2==0?"even":"odd"));
		return (i%2==0?"even":"odd");
	}
	public static void main(String[] args) {
		System.out.println(i+" is "+(i%2==0?"even":"odd"));
		return i%2==0 ? "even" : "odd";
	}

}
```

6) 📟 `reduce()` 📟
* This is clearly a reduction!
* Here is an example of calculating the sum of number of characters of a String stream:
```java
Stream<String> stream = Stream.of("1", "23", "456");
int i = stream.
	reduce(0,
		(Integer sum, String str)->sum+str.length(),
		(Integer sum1, Integer sum2)->sum1+sum2);
// RESULT: 6

Stream words = Stream.of("Hello","World","!");
words.reduce("",
	(String s1, String s2)->s1+s2);
// RESULT: "HelloWorld!"
```
* The `reduce()` method has one signature which returns an `Optional<T>`, this is the one parameter version:
```java
Optional<T> reduce(BinaryOperator<T>)
```
* Here is an example which returns the products of numbers:
```java
Stream<Integr> numbers = Stream.of(1,2,3,4);
int product = numbers.reduce((a,b)->a*b);
//  RESULT: 24
```

7) 📟 `collect()` 📟
* This method IS a reduction⚠️⚠️⚠️
* There are 2 signatures for this method:
```java
R collect(Collector)
R collect(Supplier, BiConsumer, BiConsumer)
```
* Here is an example of the first one:
```java
Stream<String> strings = Stream.of("I","hate","java","8");
Map<Integer, String> map =
	strings.collect(
		Collectors.toMap(str->str.length(), 
			str->str,
			(str1,str2)->str1+str2)
	);
// RESULT: {1=i8, 4=hatejava}
```
* Here is an example of the 3 argument one:
```java
Stream<String> stream = Stream.of("w","o","l","f");
TreeSet<String> set = stream.collect(
	()->new TreeSet<>(),
	(t,u)->t.add(u),
	(t,u)->t.addAll(u)
)
// RESULT: [f, l, o, w]
```

### ⭐ Intermediate Operations
* In order for intermiate operations to be ran, one of the above terminal operations MUST be present!⚠️
* Here are the intermediate operations I need to be aware of:
	- `filter(Predicate)`
	- `distrinct()`
	- `limit(int)`
	- `skip(int)`
	- `map(Function)`
	- `flatMap(Function)`
	- `sorted()`/`sorted(Comparator)`
	- `peek(Consumer)`

* Here is an example of using peak and sort:
```java
Stream<String> stream = Stream.of("z","w","y","x");
stream
	.peek(t -> System.out.println("peek: "+t))
	.sorted()
	.peek(t -> System.out.println("peek: "+t))
	.forEach(s->{;});
/* this prints the following:
peek: z
peek: w
peek: y
peek: x
after sort: w
after sort: x
after sort: y
after sort: z
```

* Here is an example of using `sorted()` with a custom comparator:
```java
Stream<String> nums = Stream.of("y","x","zzzz","www");
nums.sorted((a,b)->Integer.compare(a.length(), b.length()))
	.peek(t->System.out.println("peek: "+t))
	.forEach(s->{;});
/* prints the following:>
peek: y
peek: xx
peek: www
peek: zzzz
```
<br>


## 🟥 4.4 Primitive Streams
### ⭐ Creating Primitive Streams
* While we can use Streams and generics, the primitive streams offer methods which are useful specifically for primitives
* There are 3 types of primitive streams:
1. `IntStream` - char, short, byte, int, and booleans
2. `LongStream` - longs
3. `DoubleStream` - floats and double

* We can create primitive streams using the same methods from the Stream class like `.of()`, `.empty()`, `.generate()`, `.iterate()`

* The `IntStream` class has methods to specify an open and closed range:
```java
IntStream openRange = IntStream.range(1,3); // {1,2}
IntStream closedRange = IntStream.rangeClosed(1,3); // {1,2,3}
```

* We can convert a regular stream to a primitive stream using `mapToInt()`:
```java
Stream<String> pizzas = Stream.of("1","22","333");
IntStream pizzaSlices = pizzas.mapToInt(p->p.length()); 
// ^^ [1,2,3]
```

* The Stream class has the following methods:
1. `.map()`
2. `.mapToInt()`
3. `.mapToDouble()`
4. `.mapToLong()`
* The IntStream class has the following methods:
1. `.map()`
2. `.mapToObj`
3. `.mapToLong`
4. `.mapToDouble`
* The LongStream class has the following methods:
1. `.map()`
2. `.mapToObj`
3. `.mapToInt`
4. `.mapToDouble`
* The DoubleStream class has the following methods:
1. `.map()`
2. `.mapToObj`
3. `.mapToInt`
4. `.mapToLong`

### ⭐ Optionals with Primitive Streams
* Some of the methods for the primitive streams return Optional. And instead of a regular Optional, it is specifically a PRIMITIVE OPTIONAL
* E.g. when we call average on IntStream, LongStream, DoubleStream, we get an `OptionalDouble`:
```java
IntStream intStream = IntStream.of(1,2,3);
OptionalDouble intStreamAvg = intStream.average();
Double avg = intStreamAvg.getAsDouble(); // 2.0

IntStream emptyStream = IntStream.empty();
Double emptyStreamAvg = emptyStram.average().orElseGet(()->Double.NaN);
// ^^^^^^^^^^^^^^^^^ NaN
```

* If we call `.max()` on:
1. IntStream => `OptionalInt`
2. LongStream => `OptionalLong`
3. DoubleStream => `DoubleStream`

* Calling `.sum()` on a primitive stream will NOT return an Optional!!!⚠️⚠️⚠️

### ⭐ Summarising Statistics
* Summary Statistics mean you can collect multiple statistics on your stream without it terminating early!!!
```java
IntStream i = IntStream.of(1,2,3,4);
IntSummaryStatistics summary = i.summaryStatistics();
System.out.println(summary.getAverage()); // 2.5
System.out.println(summary.getMax()); // 4
System.out.println(summary.getMin()); // 1	
```

* We can use summary statistics on an empty stream, the getters will always return a value but may not be what we expect!⚠️⚠️⚠️

## 🟥 4.5 Advanced Stream Pipeline Concepts
### ⭐ Lazy Evaluation
* Streams are lazily evaluated, meaning if we call a terminal operation, the stream will be initialised at that point!
```java
List<String> animes = Arrays.asList("Death note", "Future Diary");
Stream<String> stream = animes.stream();
animes.add("Attack on Titan");
System.out.println(stream.count());
// PRINTS 3!!! ^^^^
```

### ⭐ Collecting Results
* We can collect a stream into a single result using `.collect()`
* We can use `Collectors.joining()` to construct a String from the stream:
```java
Stream str = Stream.of("lions","tigers","bears");
String result = str.collect(Collectors.joining(","));
// ^^^^ lions,bears,bears
```

* We have `Collectors.averagingInt(ToIntFunction)` to get an average of a Stream:
```java
Stream<String> str = Stream.of("1","333","7777777");
ToIntFunction<String> getLengths = s -> s.length();
Double averageLength = lengths.collect(Collectors.averagingInt(getLengths))
// 3.666666666666665
``` 

* We have `Collectors.toCollection(Supplier)`:
```java
Stream<String> alphabet = Stream.of("d","c","a","b","e");
Supplier<TreeSet<String>> supplier = TreeSet::new;
alphabet.collect(Collectors.toCollection(supplier));
// [a, b, c, d, e]
```

### ⭐ Collecting into Maps
* We have `Collectors.toMap(keyMapper, valueMapper)`:
```java
public class Employee {
	int id; String name;
	// constructor + toString
}
// MAIN METHOD:
Stream<Employee> employees = Stream.of(new Employee(1, "Shiv"),
		new Employee(2,"Kumar"));

Function<Employee, Employee> valueMapper = e->e;
Map<Integer, Employee> map = employees.collect(
	Collectors.toMap(e->e.id,e->e));
// {1=[id=1, name=Shiv], 2=[id=2, name=Kumar]}
```

