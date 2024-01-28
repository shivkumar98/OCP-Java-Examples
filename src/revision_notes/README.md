<link href="../styles.css" rel="stylesheet"></link>

# Revision Notes ✍️

# 🧑‍🎨 Chapter 1 - Advanced Class Design 🧑‍🎨
## 🟥 1.1 Reviewing OCA Concepts
* Protected variables can be accessed in same package AND of subclass in ANY package
* Package-private variables can only be accessed in same package
<br>

## 🟥 1.2 Using instanceof
* `A instanceof B` is true if A is a subclass, implementation or instance of B
* `null instanceof X` is ALWAYS false
* If the REFERENCE of left side is a concrete class, then a compiler error will occur if the types are not compatible!
	```java
	Elephant e = new Elephant
	boolean x = e instanceof Hippo; // COMPILER ERROR
	```
* If the reference is an INTERFACE, then there will be no compilation issues!
	```java
	List l = new ArrayList();
	boolean y = l instanceof Hippo;
	```
* Java only checks if an object is an instance of an INTERFACE at runtime!
	```java
	List<String> list = new ArrayList<>(); // compiles!
	System.out.println(list instanceof Set); // false
	```
<br>

## 🟥 1.3 Coding equals() and hashCode
* The `.equals()` method can be overidden using any business logic the application requires
* The `hashCode()` method must satisfy the following requirements:
  
      1. If two objects return true when calling `.equals()`, then the hashCode() NEEDS to return the same value
      2. It is NOT required that if `.equals()` returns false that the hashCode() returns the same value
      3. The value of `hashCode()` does not change within the same program. I.e. the hashing should not rely on things which will vary
<br>

## 🟥 1.4 Working with Enums
* We can create a simple enum:
	```java
	public enum Seasons {
		SUMMER, WINTER, AUTUMN, SPRING
	}
	```
* We can add a variable to each enum:
	```java
	public enum Animals {
		DOG(true), FISH(false);
		public boolean hasHair;
		Animals(boolean hasHair) { this.hasHair = hasHair; }
	}
	```
* The only modifier which can be applied to the constructor is `private`

* You can also have an abstract class which will require all enums to implement
	```java
	enum SeasonsAbstract {
		WINTER {
			public void printHours() {}
		};
		abstract void printHours(); // can only use public/protected modifier
		// abstract keyword is REQUIRED unless a default implementation is provided
	}
	```
<br>

## 🟥 1.5 Creating Nested Classes
### 🟡 Member Inner Classes
* Member inner class are like regular classes, they can extend and implement other classes. They are defined at member level:
	```java
	class Outer {
		class MemberInnerClasses { }
		private class SubClass extends MemberInnerClasses { }
		protected interface AnInterface { }
		public class Implementation implements AnInterface{}
	}
	```
* You can apply whatever modifiers✅
* You can NOT have static fields/methods in the inner class❌
* You cannot instantiate an inner class directly!❌
	```java
	class Outer {
		class Inner {}
		public static void main(String[] args) {
			Inner inner = new Outer().new Inner();
		}
	}
	```
* You can access the enclosing class's variables:
	```java
	class Outer {
		String x = "OUTER";
		class Inner {
			String x = "INNER";
			printX() {
				System.out.println(x); // INNER
				System.out.println(this.x); // INNER
				System.out.println(Outer.this.x); // OUTER
				System.out.println(Outer.x); // COMPILER ERROR
			}
		}
	}
	```
### 🟡 Local Inner Classes
* These are classes defined within methods
* Can NOT have an access modifier specified❌
* You can NOT have static fields/methods in the inner class❌
* They can access the enclosing class's fields:
	```java
	public class OuterClass {
		String x = "outer";
		public static void main(String[] args) {
			class Inner {
				String x = "inner";
				void printX() {
					OuterClass outer = new OuterClass();
					System.out.println(outer.x); // outer
					System.out.println(x); // inner
				}
			}
			inner.printX();		
		}
	}
	```
* They can not access local variables unless they are effectively final or final
	```java
	public static void main(String[] args) {
		int effectivelyFinalVariable = 0;
		int nonEffectivelyFinalVariable = 1;
		nonEffectivelyFinalVariable = 2;
		class Inner {
			void() {
				System.out.println(effectivelyFinalVariable); // 0
				System.out.println(nonEffectivelyFinalVariable); // COMPILER ERROR
			}
		}
	}
	```
### 🟡 Anonymous Inner Class
* These are implementations/extensions of existing classes
	```java
	public class UsingAnonymousInnerClasses {
		interface Vehicle { void move(); }
		public static void main(String[] args) {
			public void move() { System.out.println("Lift clutch"); }
		}
	}
	```
### 🟡 Static Nested Classes
* This is the ONLY nested class which can have static variables
* You can use any visibility modifier
* You can instantiate the nested class directly:
	```java
	public class Outer {
		static class StaticInner {
			static int x = 1;
		}
		public static void main(String[] args) {
			System.out.println(new StaticInner().x); // 1
		}
	}
	```

---------------------------------------------------------------

# 🌀 Chapter 2 - Design Patterns and Principles 🌀

## 🟥 2.1 Interfaces
* Interfaces are classes which implicitly `abstract` and contain:
  - Methods which are implicitly `public abstract`✅
  - `public static` methods which have implementations✅
  - `public default` methods which have implementations✅
  - Variables which are `public static final`✅
* You CAN extend multiple interfaces💡
* However, if you have ⚠️default methods⚠️ with the same name you will encounter the diamond problem so the compiler prevents that:
	```java
	interface InterfaceA {
		default void sameNameMethod() {} }
	interface InterfaceB {
		default void sameNameMethod() {} }
	interface InterfaceC extends InterfaceA, InterfaceB {}
	//        ^^^^^^^^^^ compiler error
	```
<br>


## 🟥 2.2 Functional Interfaces
### ⭐ Functional Interface ⭐
* A **FUNCTIONAL INTERFACE** is an interface with a single abstract method
  * All functional interfaces can be implemented with a lambda
  * We can use `@FunctionalInterface` to ensure that an interface is a valid functional interface
  * Abstract classes with a single method can NOT be functional interfaces
	```java
	@FunctionalInterface
	/*^^^^^^^^^^^^^^^^^ compiler error */
	abstract class AbstractClass { }
	```
### ⭐ Lambda Expressions ⭐
* Functional Interfaces can be implemented as lambdas💡
* There are rules for syntax of lambdas:
  1. If there are multiple parameters, they must be in round brackets✅
  2. The types of the parameters are optional, if provided then they must be in round brackets✅
  3. If one of the parameter types are specified, then all parameters must have type specified✅
  4. If you want to use `return`, then you must use braces will regular java syntax✅
* Here are some examples:
	```java
	@FunctionalInterface
	public interface VoidInterface {}

	// MAIN METHOD
	VoidInterface v1 = () -> ;
	/*                    ^^ COMPILER ERROR */
	VoidInterface v2 = () -> {};
	VoidInterface v3 = () -> {return;} ;
	```
### ⭐ Predicate Interface ⭐
* The `Predicate` Interface is a functional interface defined as:
```java
public interface T Predicate<T> {
	void test(T t);
}
```
* You can use this interface in a method and call the `test(T t)` method which return true/false
* This method parameter can then be passed as a lambda
<br>


## 🟥 2.3 Polymorphism
* Polymorpism is the property of a single interface being able to support multiple underlying forms
* It enables subtypes of a class to be passed into a method
### ⭐ Casting Object References ⭐
* The compiler will prevent casts to unrelated types but casting to unrelated types can still occur at runtime
* You can implicitly cast an object to it superclass
<br>


## 🟥 2.4 Design Principles 
* A **DESIGN PRINCIPLE** is an established idea or practice which is applied throughout an application. It leads to code which is easier to maintain and reuse
* Encapsulation, Inheritance and Composition are all design principles💡
### ⭐ Applying `Has-a` Relationship ⭐
* This is also known as the object-composition test
### ⭐ Composing Objects ⭐
* Object Composition is constructing a class using references to other classes to reuse their functionality
* It can be use to simulate polmorphic behaviour which can not be achieve multiple inheritance
<br>


## 🟥 2.5 Design Patterns
* A design pattern is an established solution to a commonly occuring development problem. E.g. the MVC model for web applications
* We shall look at **CREATIONAL PATTERNS** which manage creation of objects
### ⭐ Singleton Pattern ⭐
* The Singleton pattern let's us create an object in memory only once in the application
* A singleton requires the following:
	1. A `private static final` instance
	2. A `public static getInstance()` method
	3. A `private` constructor
	4. Methods which modify fields must be `synchronized`
* E.g.
```java
public class Singleton {
	private int field;
	private Singleton() {}
	private static Singleton instance = new Singleton();
	public static Singleton getInstance() {
		return instance;
	}
	public synchronized void setField(int field) {
		this.field = field;
	}
}
```
* We can also employ lazy instantiation to singletons too:
```java
public class LazySingleton {
	private static LazySingleton instance;
	private LazySingleton() {}
	public static LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton(); // NOT THREAD SAFE
		}
		return instance;
	}
}
```
* Lazy instantiation prevents us from making the instance `final`
```java
public class LazySingleton {
	private static final LazySingleton instance; // COMPILER ERROR
	private LazySingleton() {}
	public static LazySingleton getInstance() {
		if (instance==null)
			instance = new LazySingleton();
		//  ^^^^^^^^ COMPILER ERROR
		return instance;
	}
}
```
* We can circumvent this compiler limitation, by makking the `getInstance()` method synchronized:
```java
public class LazySingleton {
	private static LazySingleton instance;
	private LazySingleton() {}
	public static synchronized LazySingleton getInstance() {
		if (instance==null)
			instance = new LazySingleton();
		return instance;
	}
}
```
### ⭐ Immutability Pattern ⭐
* An immutability strategy can be implemented by having:
1. A public constructor for setting all the fields
2. Mark all instance variables as `private final`
3. Define no setters (impossible due to `final` modifier)
4. Do no allow referenced objects to be modified or accessed directly
5. Make class final to prevent method overriding
* Here is an example:
```java
public final class ImmutableClass {
	private final int field;
	public ImmutableClass(int field) {
		this.field = field;
	}
}
```
* We need to be sure not to expose mutable objects directly:
```java
final class BadImmutableClass {
	private final List<String> list;
	public BadImmutableClass(List<String> list) {
		this.list = new ArrayList<>(list);
	}
	public List getList() { // makes class immutable
		return list;
	}
	@Override
	public String toString() {
		return "BadImmutableClass [list=" + list + "]";
	}
	public static void main(String[] args) {
		BadImmutableClass immutable = new BadImmutableClass(Arrays.asList("hello"));
		immutable.getList().remove(0);
		System.out.println(immutable.toString());
		// BadImmutableClass [list=[]]
	}
}	
```
* We can fix this problem by returning a new reference of the list:
```java
public List getList() {
	return new ArrayList<>(list); // makes it immutable again!
}
```
### ⭐ Builder Pattern ⭐
* The Builder Pattern enables us to construct objects without having to specify all fields in a large constructor
* Also it enables us to add fields without having to force users of the constructor to update their code!
* A class which adopts the builder pattern has:
1. Setter methods to set the fields
2. A `build()` method which calls the constructor

* Example:
```java
class Animal {
	private int age;
	private String species;
	// constructor
}
public class AnimalBuilder {
	private int age;
	private String species;
	public AnimalBuilder setAge(int age) {
		this.age = age;
		return this;
	}
	public AnimalBuilder setSpecies(String species) {
		this.species = species;
		return this;
	}
	public Animal build() {
		return new Animal(age, species);
	}
	
}
```
### ⭐ Factory Pattern ⭐
* Suppose we need a specific instance, but we only have the information at runtime.
* The factory method let's us return a specific instance using polymorphism
```java
public abstract class Food {
	private int quantity;
	public Food(int quantity) { this.quantity = quantity; }
}
class Hay extends Food {
	public Hay(int quantity) { super(quantity); }
}
class Pellets extends Food {
	public Pellets(int quantity) { super(quantity); }
}
class Fish extends Food {
	public Fish(int quantity) { super(quantity); }
}
class FoodFactory {
	public static Food gettFood(String animal) {
		switch(animal) {
			case "zebra": return new Hay(1000);
			case "rabbit": return new Pellets(5);
			case "goat": return new Pellets(30);
			case "polar bear": return new Fish(10);
		}
	}
}
```

--------------------------------------------------------------


# 🧮 Chapter 4 - Functional Programming 🧮

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


# ⚠️ Chapter 6 - Exceptions and Assertions ⚠️
## 🟥 6.1 Reviewing Exceptions
### 🟡 Terminology
* All exceptions/errors extend `java.lang.Object`
* `RuntimeException` is a subclass of `Exception`, it is AKA unchecked exception and there is no requirement to be caught (even though you can).
* Checked exceptions are `Exception` classes which DO NOT extend `RuntimeException`.
* `Error` classes are not `Exceptions` but a seperate subclass of `Throwable`

### 🟡 OCP Exceptions
* The pre-requiste exceptions from the OCA exam include:
1) `NumberFormatException` - thrown by program when attempting to convert string to numeric type
2) `IllegalArgumentException` - thrown by program
3) `NullPointerException` - thrown by JVM
4) `ArrayIndexOutOfBoundsException` - thrown by JVM
5) `ArithmeticException` - thrown by JVM when trying to divide by zero
6) `ClassCastException` - thrown by JVM when attempting to make cast an object to an invalid type

#### **OCP Checked Exceptions**:
1) `java.text.ParseException` 
- converting a number to string
1) `java.io.IOException`/`java.io.FileNotFoundException`/`java.io.NotSerializableException`
- All io exceptions can be assumed as checked
1) `java.sql.SQLException`
- All sql exception can be assumed as checked

#### **OCP Runtime Exceptions**:
1) `java.lang.ArrayStoreException`
- When attempting to add incorrect type to an array
2) `java.time.DateTimeException`
- Recieved when an invalid format string for a date
3) `java.util.MissingResourceException` - trying to access a resource or bundle that does not exist
4) `java.lang.UnsupportedOperationException`
5) `java.lang.IllegalStaceException`

<hr>

## 🟥 6.2 Creating Custom Exceptions
* You can create custom exceptions by extending `Exception` or `RuntimeException`
* Here are the 3 most common constructors for Exceptions:
```java
public class CanNotSwimException extends Exception {
	public class CanNotSwimException() { super(); }
	public class CanNotSwimException(Exception e) { super(e); }
	public class CanNotSwimException(String message) { super(message); }
}
```
<hr>

## 🟥 6.3 Using Multi-catch
* We can use multi-catch syntax to reduce code duplication when catching multiple exceptions@
```java
try {
	Path path = Paths.get("dophinsBorn.txt"); // throws IOEXception
	LocalDate date = LocalDate.parse("text"); // throws DateTimeParseException
} catch (DateTimeParseException | IOException e) {
	e.printStackTrace();
	throw new RuntimeException(e);
}
```
* The caught exception is EFFECTIVELY FINAL (i.e. it can not be instantiated or reassigned)⚠️⚠️⚠️
```java
try {
    throw new IOException();
} catch (IOException | RuntimeException e) {
    e = new RuntimeException(); // COMPILER ERROR
}
```
* A compiler error is generated if any of the exception types are UNREACHABLE, i.e. it can only catch checked exceptions which are declared and you can not have redudancies!⚠️⚠️⚠️
```java
try {
    throw new IOException();
} catch (FileNotFoundException | IOException e) { } // COMPILER ERROR
```
<hr>

## 🟥 6.4 Using Try-With-Resources
* You can use classes which implement `Closeable` OR `AutoCloseable` in try-with-resources clauses
* The `AutoCloseable` interface has a method: `void close() throws Exception;`
* It does not require the implemention to throw any exception at all:
```java
public class Turkey implements AutoCloseable {
	@Override
	public void close() {
		System.out.println("closed");
	}
	public static void main(String[] args) {
		try(Turkey t = new Turkey()) {
			System.out.println("opening turkey");
		}
	}
	// PRINTS:
	// opening turkey
	// closed
}
```
<br>



* If the `close()` method DOES throw a checked exception then it must be declared or caught!
```java
public class Turkey implements AutoCloseable {

	@Override
	public void close() throws Exception {
		throw new Exception();
	}
	public static void main(String[] args) {
		try(Turkey t = new Turkey()) { // COMPILER ERROR
			System.out.println("opening turkey");
		}
	}
}
```

<br>

* If the try clause itself throws an exception, it will be the one which is caught and the exceptions from `close()` will be SUPRESSED💡
```java
public static void main(String[] args) {
	try (Turkey t = new Turkey()) {
		throw new RuntimeException("inside try");
	} catch (Exception e) {
		System.out.println(e.getMessage()); // inside try 
		System.out.println(e.getSuppressed().length); // 1
	}
}
```
<br>



* In terms of ordering, the code is ran in the following order:
1) The code in try block
2) The close() methods of the resources in reverse order of instantiation
3) The code in catch block
4) The code in finally block 

```java
class Door implements AutoCloseable {
	public void close() {
		System.out.println("D");}}
class Window implements Closeable {
	public void close() {
		System.out.println("W"); 
	 	throw new RuntimeException();}}
public class AutocloseableFlow {
	public static void main(String[] args) {
		try (Door d = new Door(); Window w = new Window()) {
			System.out.print("T");
		} catch (Exception e) {
			System.out.print("E");
		} finally {
			System.out.print("F");
		} 
	} 
	// PRINTS: TWDEF
}
```

<hr>

## 🟥 6.5 Rethrowing Exceptions
* It is a common pattern to log an exception, and rethrowing the same exception:
```java
try {
	parseData();
} catch (IOException | DateTimeParseException e) {
	System.err.println(e);
	throw e;
}
```
<hr>

## 🟥 6.6 Working With Assertions
* By default, failing assertions will not cause any changes in program flow
* They need to be enabled using `-ea` or `-enableassertions` options when compiling the java class
* We can enable assertions for specifc classes by following the option with `:className`
* You can mix these options together. E.g. the following will disable assertions except for specified class: `java -da -ea:ClassName ClassName`


-----------------------------------------------------------

# 🧵 Chapter 7 - Concurrency 🧵

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

<hr>

## 🟥 7.2 Creating Threads with ExecutorService
### 🟡 Single Thread Executor
* We can use the Concurrency API to create a single thread to execute multiple tasks
* We call `Executors.newSingleThreadExecutor()` which gives us an instance of `ExecutorService`:
```java
ExecutorService service = Executors.newSingleThreadExecutor();
service.execute(()->System.out.println("begin"));
service.execute(()-> {
	for(int i=0;i<5;i++) {
		if (i==1) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { 
				// handle
			}
		}
		System.out.println(i);
	}
})
service.execute(()->System.out.println("end"));
```

* This will ALWAYS print in a sequential order:
```java
begin
0
1
2
3
4
end
```

* If we used a `Executors.fixedThreadPool(10)` instead it will print the following:
```java
begin
end
0
4
2
1
3
```
* Now the ordering is no longer predictable!

### 🟡 Submitting Tasks
* The `ExecutorService` has the following methods:
```java
void execute(Runnable r);
Future<?> submit(Runnable r);
Future<T> submit(Callable<T> c);
List<Future<T>> invokeAll(Collection<? extends Callable<T>> c);
T invokeAny(Collection<? extends Callable<T>> c);
```
* Here are some examples of using these methods:
```java
service = Executors.newSingleThreadExecutor();
Future<Integer> f1 = service.submit(c);
// Future<Integer> f2 = service.execute(r); // COMPILER ERROR
Future<?> f2 = service.submit(r);
service.execute(r);
System.out.println(f1.get()); // 1
System.out.println(f2.get()); // null
System.out.println(counter); // 3
List<Callable<Integer>> list = Arrays.asList(c,c,c);
List<Future<Integer>> returnedList = service.invokeAll(list);
Integer f = service.invokeAny(list);
System.out.println(f); // 7
List<Integer> l = getTheValuesOfFutureList( returnedList);
System.out.println(l); // [4,5,6]
```

### 🟡 Waiting for Results
* When we use the `submit()` method we return a future object. If we use the `get()` method, there is a chance that the program will halt!
* We can get around this by using an overloaded version of get()!
* We can determine whether the task which has been submitted is actually complete with the following methods:
```java
boolean isDone();
boolean isCancelled();
boolean cancel(); // attempts to cancel the task
V get(); // retrieves result of task, waiting endlessly if not yet available
V get(long millis, TimeUnit unit); // retrieves result in alotted time, otherwise throws TimeoutException
```
* E.g.:
```java
static int counter = 0;
public static void main(String[] args) throws InterruptedException, ExecutionException {
	ExecutorService service = null;
	try {
		service = Executors.newSingleThreadExecutor();
		Future<?> result = service.submit(() -> {
			for(int i=0;i<500;i++) counter++;
		});
		result.get(10, TimeUnit.SECONDS);
		System.out.println("Reached");
	} catch (TimeOutException e) {
		System.out.println("Not reached in time");
	} finally {
		if(service!=null) service.shutdown();
	}
}
```

### 🟡 Scheduling Tasks
* We have a subinterface `ScheduledExecutorService` which has methods for running tasks on a schedule:
```java
ExecutorService serviceUsingWrongReference = Executors.newSingleThreadScheduledExecutor();
// serviceUsingWrongReference.schedule(); // COMPILER ERROR
ScheduledExecutorService scheduledService
    = Executors.newSingleThreadScheduledExecutor();
```

* We have the fdllowing methods for scheduling methods with a delay:
```java
schedule(Callable<V> callable, long delay, TimeUnit unit);
schedule(Runnable callable, long delay, TimeUnit unit);
```

* We can assign these two methods to Future objects:
```java
Callable<Integer> c = () -> 1;
Runnable r = () -> System.out.println("hello");
Future<Integer> f = scheduledService.schedule(c, 1, TimeUnit.SECONDS);
Future<?> f2 = scheduledService.schedule(r, 1, TimeUnit.SECONDS);
// prints hello
System.out.println(f.get()); // 1
System.out.println(f2.get()); // null
```

* There also two methods which schedule a runnable task on repeat:
```java
scheduleAtFixedRate(Runnable r, long initialDelay, long period, TimeUnit unit);
scheduledAtFixedDelay(Runnable r, long initialDelay, long delay, TimeUnit unit);
```

* E.g.:
```java
Future<?> f3 = scheduledService.scheduleAtFixedRate(r, 1, 1, TimeUnit.SECONDS);
// this will print hello exactly every second		

Future<?> f4 = scheduledService.scheduleWithFixedDelay(r, 0, 1, TimeUnit.SECONDS);
// this will print hello exactly 1 second after the previous hello is printed
```

<hr>

## 🟥 7.3 Synchronizing Data Access

### 🟡 Atomic Classes
* We have the following Atomic classes in the Concurrency API:
1) `AtomicBoolean`
2) `AtomicInteger`
3) `AtomicLong`
4) `AtomicReference`
5) `AtomicIntegerArray`
6) `AtomicLongArray`
7) `AtomicReferenceArray`

* Here are common methods for these classes:
```java
get();
set();
getAndSet(newValue); // gets old value while setting new value
incrementAndGet(); // increments and returns the incremented value
getAndIncrement(); // gets old value and increments after
decrementAndGet(); // decrements and returns decremented value
getAndDecrement(); // gets old value and decrements after
```
* Here is an example of using an Atomic class to ensure a counter is kept THREAD-SAFE and to prevent race conditions:
```java
public class SheepManager {
	AtomicInteger sheepCount = new AtomicInteger(0);
	void incrementAndReport() {
		System.out.print(sheepCount.incrementAndGet()+" ");
	}
	public static void main(String[] argS) {
		SheepManager manager = new SheepManager();
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(20);
			for(int i=0;i<10;i++)
				service.submit(()->manager.incrementAndReport()))
		} finally {
			if(service!=null) service.shutdown();
		}
	}
}
```
* Here are samples of what would be printed:
```java
1 10 9 3 2 8 7 4 6 5 
2 10 9 7 8 6 5 4 1 3 
```

### 🟡 Synchronized Methods
* We can synchronize access to methods using `synchronized` keyword. The following are equivalent:
```java
synchronized void print() {
	System.out.print("hello");
}
void incrementAndReport() {
	synchronized(this) {
		System.out.print("hello");}
}
```

<hr>

## 🟥 7.4 Using Concurrent Collections

### 🟡 Concurrent Classes
* We have the following Concurrent Collection Classes:
```java
ConcurrentHashMap // ConcurrentMap
ConcurrentLinkedDeque // Deque
ConcurrentLinkedQueue // Queue
ConcurrentSkipListMap // ConcurrentMap/SortedMap/NavigableMap
ConcurrentSkipListSet // SortedSet/NavigableSet
CopyOnWriteArrayList // List
CopyOnWriteArraySet // Set
LinkedBlockingDeque // BlockingQueue/BlockingDeque
LinkedBlockingQueue // BlockkingQueue
```
### 🟡 ConcurrentModificationException
* Using Concurrent classes enables us to avoid `ConcurrentModificationException` when workking with for-loops:
```java
Map<String, Integer> food = new HashMap<>();
food.putAll(Map.of("pizza", 1, "chicken", 2));
for (String key: food.keySet()) {
	food.remove(key); // throws ConcurrentModificationException
}
```
* If we used `new ConcurrentHashMap<>()` instead, we would not have this problem!💡

### 🟡 Blocking Queues
* The `LinkedlockingDeque` and `LinkedBlockingQueue` implement the `BlockingQueue` and `BlockingDeque` interfaces
1) `BlockingQueue` waiting methods:
```java
boolean offer(E e, long timeout, TimeUnit unit); 
// adds item to queue in alotted time if space is available

E poll(long timeout, TimeUnit unit);
// retrieves and removes an item from the queue in alotted time if available
```
* These methods can throw an `InterruptedException` as they can be interrupted before finishing:
```java
try {
	BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
	blockingQueue.offer(39);
	blockingQueue.offer(3,4,TimeUnit.SECONDS);
	System.out.println(blockingQueue.poll(10, TimeUnit.SECONDS));
} catch (InterruptedException e) {
	// handle
}
```

2) `BlockingDeque` waiting methods:
```java
boolean offerFirst(E e, long timeout, TimeUnit unit);
// adds item to front of queue

boolean offerLast(E e, long timeout, TimeUnit unit);
// adds item to back of queue

E pollFirst(long timeout, TimeUnit unit); 
// retrieves and removes element at front of queue

E pollLast(long timeout, TimeUnit unit);
// retrieves and removes element at back of queue
```
* Again, `InterruptedException` must be caught and handled!

### 🟡 SkipList Collections
* The `ConcurrentSkipListMap` and `ConcurrentSkipListSet` are concurrent versions of `TreeMap` and `TreeSet`
* These 
### 🟡 CopyOnWrite Collections
* The `CopyOnWriteArrayList` and `CopyOnWriteSet` are concurrent versions of Lists and Sets.
* These classes let us add/remove elements in a for loop, the iterator takes a snapshot of the elements and loops over these elements during each iteration
```java
List<Integer> regularList = Arrays.asList(1,2,3);

/* The following code throws exception:
for(int i:l1) 
	l1.add(i); // UnsupportedOperationException
*/

List<Integer> l2 = new CopyOnWriteArrayList<>(l1);
for (int i:l2) {
	System.out.print(i+ " "); // 1 2 3
	l2.add(i);
}
System.out.println(l2); // [1,2,3,1,2,3]

Set<Integer> s3 = new CopyOnWriteArraySet<>();
s3.addAll(l2);
for(int i:s3) {
	System.out.print(i+ " "); // 1 2 3
	s3.add(4);
}
System.out.println("\n"+s3); // [1,2,3,4]
```

### 🟡 Obtaining Synchronized Collections
* We can convert non-concurrent collections into synchronized versions using the following methods:
```java
synchronizedCollection(Collection<T> c)
synchronizedList(List<T> list)
synchronizedMap(Map<Kk,V> map)
synchronizedNavigableMap(NavigableMap<K,V> map)
synchronizedNavigableSet(NavigableSet<T> set)
synchronziedSet(Set<T> set)
synchronizedSortedMap(SortedMap<K,V> map)
synchronizedSortedSet(SortedSet<T> set)
```
* E.g.:
```java
List<Integer> list = Collections.synchronizedList(
	new ArrayList<>(Arrays.asList(4,3,42)));
```

<hr>

## 🟥 7.5 Working with Parallel Streams
### 🟡 Creating Parallel Streams
* You can create a paralle stream by calling `.parallel()` on an existing stream or calling `.parallelStream()` on a collection:
```java
Stream<Integer> stream = Arrays.asList(1,2,3,4).parallelStream();
```

### 🟡 Processing Tasks in Parallel
* Using a parallel stream means that results CAN be unpredictable
```java
Arrays.asList(1,2,3,4,5,6)
	.parallelStream()
	.sorted()
	.forEach(System.out::println);
// PRINTS: 4 1 6 5 2 3
```

* If tasks can be done in parallel and independently, we will always know the result!❗
```java
List<String> list = Arrays.asList("Jackal", "Monkey", "Tiger")
	.parallelStream()
	.map(String::toUpperCase)
	.collect(Collectors.toList());
System.out.println(list); // [JACKAL, MONKEY, TIGER]
```

### 🟡 Processing Parallel Reductions
* With parallel streams, behaviour can not be defined:
```java
Arrays.asList(1,2,3,4,5,6).stream().findAny(); // will ALWAYS be 1
Arrays.asList(1,2,3,4,5,6).parallelStream().findAny(); // unable to predict the result
```

* E.g.:
```java
int x = Arrays.asList("1234","56","789")
	.parallelStream()
	.reduce(0,
	(n,str)-> n + str.length(),
	(str1,str2)-> str1+str2);
System.out.println(x); // 9

String str = Arrays.asList("abc","de","fgh")
	.parallelStream()
	.reduce("", (result,s)->result+s.toUpperCase(), (s1,s2)->s1+s2);
System.out.println(str); // ABCDEFGH
```

### Using `.collect()` Method
* A parallel stream can be reduced efficiently using the collect method, providing the following requirements are met:
1) The stream is parallel
2) The collect() paramaeter has the `Collector.Characteristics.CONCURRENT` characteristic
3) The stream is unordered, OR the collect() parameter has the `Collector.Characteristic.UNORDERED` characteristic

* The `Collectors.toSet()` method is an example of a collector which DOES NOT have the `CONCURRENT` charactteristic:
```java
Stream<String> stream = Stream.of("w","o","l","f")
		.parallel();
System.out.println(Collectors.toSet().characteristics());
// [UNORDERED, IDENTITY_FINISH]

Set<String> set =
	stream.collect(Collectors.toSet());
System.out.println(set); // [f, w, l, o]
```

* The Collectors class does have 2 collectors which are both `CONCURRENT` AND `UNORDERED`:
1) `Collectors.toConcurrentMap()`
2) `Collectors.groupingByConcurrent()`

* E.g.:
```java
Stream<String> ohMy = Stream.of("lions","tigers","bears")
	.parallel();
ConcurrentMap<Integer,String> map = ohMy.collect(
	Collectors.toConcurrentMap(s->s.length(),
	k->k,
	(s1,s2)->s1+","+s2)
);
System.out.println(map); // {5=bears,lions, 6=tigers}
```

```java
Stream<String> parallelStream = Stream.of("lions", "tigers", "bears").parallel();
ConcurrentMap<Integer, List<String>> groupedMap = parallelStream
	.collect(Collectors.groupingByConcurrent(str->str.length()));
System.out.println(groupedMap); // {5=[lions, bears], 6=[tigers]}
```
<hr>

## 🟥 7.6 Managing Concurrent Processes
### 🟡 Creating a CyclicBarrier
* We can use the `CyclicBarrierLimit` class to create thresholds in a method to ensure that a type of task if not done until another is done:
```java
void performTask(CyclicBarrier c1) {
	try {
		System.out.println("Task 1");
		c1.await();
		System.out.println("Task 2");
	}
}
// MAIN METHOD:
ExecutorService service = null;
try {
	service = Executors.newFixedThreadPool(4);
	CyclicBarrier c1 = new CyclicBarrier(2);
	for(int i=0;i<4;i++)
		service.submit(()->performTask(c1));
} finally {
	if(service!=null) service.shutdown();
}
```
* This prints the following:
```java
Task 1
Task 1
Task 1
Task 1
Task 2
Task 2
Task 2
Task 2
```

### 🟡 Applying the Fork/Join Framework
* The Fork/Join framework requires us to perform three steps:
1) Createa ForkJoinTask instance using `RecursiveAction`/`RecursiveTask``
2) Create a `ForkJoinPool` instance
3) Invoke the ForkJoinTask instance using the pool

* We have two ForkJoinTask classes:
```java
abstract class RecursiveAction extends ForkJoinTask {
	protected abstract void compute();
}
abstract class RecursiveTask<V> extends ForkJoinTask<V> {
	protected abstract T compute();
}
```
#### 🟢 RecursiveAction Example 🟢
```java
public class WeighAnimalAction extends RecursiveAction {
	private int start;
    private int end;
    private Double[] weights;
    // CONSTRUCTOR HERE
	
	protected void compute() {
		if(end-start<=3){
			System.out.println("BASE CASE FROM: "+start
            +", TO: "+end);
            for(int i=start;i<end;i++) {
                weights[i] = (double)new Random().nextInt(100);
                System.out.println("Animal "+i+" weighs "+weights[i]);
            }
		} else {
			int middle = start+((end-start)/2);
            System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
            invokeAll(new WeighAnimalAction(weights,start,middle),
                      new WeighAnimalAction(weights,middle,end));
		}
	}
}

// MAIN METHOD:
Double[weights] = new Double[10];
ForkJoinTask<?> task = new WeighAnimalAction(weights,0,10);
ForkJoinPool pool = new ForkJoinPool();
pool.invoke(task);
```
* This prints the following:
```
[start=0,middle=5,end=10]
[start=0,middle=2,end=5]
BASE CASE FROM: 0, TO: 2
[start=5,middle=7,end=10]
BASE CASE FROM: 2, TO 5
BASE CASE FROM: 5, TO 7
BASE CASE FROM: 7, TO 10
Animal 0 weighs 53.0
Animal 1 weighs 75.0
Animal 2 weighs 41.0
Animal 5 weighs 56.0
Animal 3 weighs 87.0
Animal 7 weighs 35.0
Animal 4 weighs 59.0
Animal 8 weighs 68.0
Animal 6 weighs 56.0
Animal 9 weighs 9.0
```

#### 🟢 RecursiveTask Example 🟢
```java
public class WeighAnimalTask extends RecursiveTask<Double> {
	private int start;
    private int end;
    private Double[] weights;
    // CONSTRUCTOR HERE

	protected Double compute() {
		if (end-start<=3) {
			System.out.println("BASE CASE FROM: "+start+", TO: "+end);
			double sum = 0;
			for (int i=start;i<end;i++) {
				weights[i] = (double)new Random().nextInt(100);
				System.out.println("Animal Weighed: "+i);
				sum += weights[i];
			}
		} else {
			int middle = start+((start-end)/2);
			System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
			RecursiveTask<Double> otherTask = new WeighAnimalTask(weights,start,middle);
			otherTask.fork();
			return new WeighAnimalTask(weights,middle,end).compute()+otherTask.join();
		}
	}
}

// MAIN METHOD:
Double[] weights = new Double[10];
ForkJoinTask<Double> task = new WeighAnimalTask(weights,0,weights.length);
ForkJoinPool pool = new ForkJoinPool();
Double sum = pool.invoke(task);
System.out.println("Sum: "+sum);
```
* This prints the following:
```
[start=0,middle=5,end=10]
[start=5,middle=7,end=10]
BASE CASE FROM: 7, TO: 10
[start=0,middle=2,end=5]
BASE CASE FROM: 5, TO: 7
BASE CASE FROM: 2, TO: 5
BASE CASE FROM: 0, TO: 2
Animal: 7 weighed 0.0
Animal: 8 weighed 40.0
Animal: 9 weighed 29.0
Animal: 2 weighed 69.0
Animal: 3 weighed 83.0
Animal: 5 weighed 71.0
Animal: 0 weighed 55.0
Animal: 1 weighed 45.0
Animal: 6 weighed 49.0
Animal: 4 weighed 87.0
Sum: 528.0
```
* If the `.join()` method were to be called directly after fork, the application would generate single-threader performance:
```java
int middle = start+((start-end)/2);
System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
RecursiveTask<Double> otherTask = new WeighAnimalTask(weights,start,middle);
otherTask.fork().join(); // DO NOT DO!!!!
return new WeighAnimalTask(weights,middle,end).compute()+otherTask;
```
<hr>

## 🟥 7.7 Identifying Threading Problems
* Liveliness is the property of an application not encountering unexpected delays
* Deadlock is when a resource is blocked from being used from a thread
* Starvation occurs when a thread is perpetually denied access to a shared resouce as a result of other threads constantly taking the resource
* Livelock occurs when two or more threads are blocked forever but appear active. This is often the result of two threads trying to attempt to resolve a deadlock
* Race conditions are when two or more threads try to complete a related task at the same time. It is the undesirablee result which occurs when two tasks which should be done sequentially are done at the same time

--------------------------------------------------

# 🖨️ Chapter 8 - IO 🖨️

## 🟥 8.1 Files and Directories
* You can instantiate a file using either a String representing the location or using another File instance which is the parent directory
```java
File parent = new File("/home/smith");
File child = new File(parent, "data/zoo.txt");
```

* We have methods to make directories, confirm existence, delete, rename and list files.
* We do NOT have methods to MOVE/COPY

* Here are the **methods available to File class**:
```java
boolean exists();
String getName(); // gets the name of file or directory. E.g. zoo.txt
boolean isDirectory();
boolean isFile();
boolean delete(); // deletes file OR directory if empty
boolean renameTo(File file);
boolean mkdir(File directoryFile); // makes directory file denoted by file
boolean mkdirs(File file); // makes directory AND file even for dirs which don't exist
String getParent(); // returns absolute filepath of parent directory
File[] listFiles(); // returns a File[] denoting files in directory
long lastModified(); // returns no. of ms since the epoch the file was last modified
```

<hr>

## 🟥 8.2 Streams
### 🟡 Input/Output Stream Vs Reader/Writer
* There **four abstract classes** in java.io:
1) `Reader` 📖
2) `Writer` ✍️
3) `InputStream` 👉0️⃣
4) `OutputStream` 1️⃣👉

* These classes can be divided into two types
1) Classes which have `InputStream`/`OutputStream` in their name
- Used for reading/writing **BINARY DATA**
2) Classes which have `Reader`/`Writer` in their name
- Used for reading/writing **CHARACTER/STRING DATA**

### 🟡 Low-Level Streams
* LOW LEVEL streams connect directly to source of data

| Class 			| Description 								|
| ----------------- | ----------------------------------------- |
| FileInputStream   | This is an `InputStream` and reads binary data from file				|
| FileOutputStream  | This is an `OutputStream` and writes binary data to file				|
| FileReader        | This is a `Reader` and reads character data from file		    |
| FileWriter		| This is a `Writer` and writes character data from file 			|

* HIGH LEVEL streams are used to wrap another stream (the final 2 are not in the exam)
  
| Class 			| Description 								|
| ----------------- | ----------------------------------------- |
| BufferedReader |  This is a `Reader` and takes in a low level `FileReader` |
| BufferedWriter | This is a `Writer` and takes in a low level stream `FileWriter` |
| BufferedInputStream | This is a `InputStream` which takes a low level `FileInputStream` |
| BufferedOutputStream |  This is a `OutputStream` which takes a low level `FileOutputStream` |
| ObjectInputStream | This deserializer is an `InputStream` and takes either `FileInputStream` OR `BufferedInputStream` |
| ObjectOutputStream | This serializer is an `OutputStream` and takes either `FileOutputStream` OR `BufferedOutputStream` |
| PrintStream  | This is a `OutputStream` which gives useful methods for writing and formatting data  |
| PrintWriter | This is a `Writer` which gives useful methods for writing and formatting data  |
| InputStreamReader | This is a `Reader` which takes an `InputStream` (e.g. FileInputStream, ObjectInputStream) |
| OutputStreamWriter | This is a `Writer` which takes an `OutputStream` (e.g. FileOutputStream) |

### 🟡 Common Stream Operations
* Streams should be closed via `close()` method to prevent resouce leaks and the program deadlocking. You can also use the try-with-resources syntax to do this automatically💡
* You should use the `flush()` method to ensure all data is written to disk when writing data with `OutputStream`
* Only some streams support marking and resetting. Check that it is supported using `boolean markSupported()` otherwise you can encounter an UnsupportedOperationException⚠️
<hr>

## 🟥 8.3 Working With Streams

### 🟡 FileInputStream and FileOutputStream Classes
* These are LOW LEVEL `InputStream`/`OutputStream` classes which read/write binary data to files
```java
try (InputStream fileInputStream = new FileInputStream(new File("data.txt")) {
	int b;
	while((b=fileInputStream()) != -1) {
		System.out.print((char)b);
	}
}
```

#### 🟢 BufferedInputStream and BufferedOutputStream Classes
* This are HIGH LEVEL InputStream/OutputStream classes which take in low level FileInputStream/FileOutputStream classes!
```java
BufferedInputStream bufferedInputStream
	= new BufferedInputStream(
		new FileInputStream(
			new File(alphabetFile)));
int b;
while ((b=bufferedInputStream.read()) != -1) {
	System.out.println((char)b);
}
```

### 🟡 FileReader and FileWriter Classes
* These classes offer AUTOMATIC CHARACTER ENCODING💡
* These are LOW LEVEL `Reader`/`Writer` classes which read and write String data
* We have a `int read()` method for the reader ,and a `void write(String)` method for the writer
```java
FileReader fileReader = new FileReader(alphabetFile);
int b;
while((b=fileReader.read()) != -1) {
	System.out.println((char)b);
}
```

#### 🟢 BufferedReader and BufferedWriter
* These classes are HIGH LEVEL wrappers, there is also a `ReadLine()` method which is useful!
```java
try (BufferedWriter writer = new BufferedWriter(new FileWriter(alphabetFile));
	 BufferedReader reader = new BufferedReader(new FileReader(alphabetFile));) {
	writer.write("abcd\nefghi");
	String line;
	while((line=reader.readLine())!=null) {
		System.out.println(line);
	}
}
```

### 🟡 ObjectInputStream and ObjectOutputStream Classes
* These classes allow for SERIALIZATION and DESERIALIZATION of Java objects:
* The ObjectInputStream takes in an InputStream in the form of a FileInputStream or BufferedInputStream
```java
ObjectOutputStream writer = new ObjectOutputStream(
	new FileOutputStream(outputFile));
writer.writeObject("hello world");

ObjectInputStream reader = new ObjectInputStream(
	new FleInputStream(outputFile));
// reader.read(); // returns -1
reader.readObject(); // hello world is returned
```

#### 🟢 Serializable Interface
* Any abstract, concrete or final class can be marked as serializable
* Attempting to serialize a non-serializable instance will not cause compilation errors but WILL THROW NotSerializableException:
```java
objectOutputStream.writeObject(new NotSerializable()); // THROWS NotSerializableException
```

#### 🟢 How Objects are Created When Deserializing
* Static and `transient` variables are ignored during serialization/deserialization
  * Transient variables will be the default value java gives to the instance type (e.g. null for Strings)
  * Static variables will have the value of the last value it was assigned to in the program
* When an object is deserialized, the constructor of the class is NOT called
  * java will call the first no-argument constructor for the first nonserializable parent class


### 🟡 PrintStream and PrintWriter Classes
* These classes offer nice methods like `format(String, args)` and `printf(String, args)` which are functionally the same
* PrintStream is an `OutputStream`
* PrintWriter is a `Writer`
<hr>

## 🟥 8.4 Interacting With Users

### 🟡 Old Way: Using Buffered Reader
* System.out returns a `PrintStream`
* System.in returns an `InputStream`.
* We use `InputStreamReader` to capture input from the user:
```java
Reader reader = InputStreamReader(System.in);
System.out.println("Enter a character");
		int input = reader.read();
		System.out.println("You entered: "+(char)input);
```

* BufferedReader enables us to read String terminated by enter key by the user
```java
BufferedReader bufferedReader = 
	new BufferedReader(new InputStreamReader(System.in));
System.out.println("Please enter a string:");
String input = bufferedReader.readLine();
System.out.printf("You entered: %s", input);
```

### 🟡 New Way: Using Console
* The `Console` is a singleton which is accessible using `Sytem.console()`
* There is a risk the console can be null⚠️
* The console has the `format()`/`printf()` that PrintStream also has
* The console has the following methods:
  * `String readLine()`
  * `char[] readPassword()` - a secure way of reading password without invoking String pool!
  * `PrintWriter writer()` - gives a writer instance for methods like `print()`
* Example program:
```java
Console console = System.console();
console.printf("Hi, %s! Please enter some text:", "shiv");
String input = console.readLine();
console.writer().println("You typed: "+input);
```