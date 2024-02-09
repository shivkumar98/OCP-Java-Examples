<link href="../../styles.css" rel="stylesheet"></link>

# 🌀 Chapter 2 - Design Patterns and Principles ✍️

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
