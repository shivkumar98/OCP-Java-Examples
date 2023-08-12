<link href="../../styles.css" rel="stylesheet"></link>

# 📝 Chapter 2

# 🧠 2.1 Introducing Functional Programming

## 🟥 Defining a Functional Interface
* A functional interface is an INTERFACE containing ONLY ONE abstract method! We CAN have default and static methods on top and still be a functional interface.
* We can use `@FunctionalInterface` to explicitly define a functional interface.

## 🟥 Lambda Expression

* Here are lambda expressions:

```java
Consumer<String> lambda  = x ->; // COMPILER ERROR
Consumer<String> lambda2 = x -> {};
Consumer<String> lambda3 = x -> {return;};
```

## 🟥 Applying the Predicate Interface

* The `Predicate` interface lays out a blueprint for functional interfaces which return a boolean, we no longer need to create an interface for writing a test!

* E.g.:

```java
public static void main(String[] args) {
    testAnimal(new Animal("fish", false), a->a.canHop()); // false
    testAnimal(new Animal("rabbit", true), a->a.canHop()); // true
}
```

<hr>

# 🧠 2.2 Polymorphism

## 🟥 What is Polymorphism
* Polymorphism lets you reference an object by its super type or an interface which it implements without casting!

* Here's an example of using polymorphism:

```java
class Animal {
	public boolean hasHair() {
		return true;
	}
}

interface HasTail {
	boolean isTailStriped();
}

class Lemur extends Animal implements HasTail {
	public int age = 10;
	public boolean isTailStriped() {
		return false;
	}
    public static void main(String[] args) {
        Animal animal = new Lemur();
        Lemur lemur = new Lemur();
        HasTail hasTail = new Lemur();
        
        System.out.println(lemur.age); // 10
        // System.out.println(animal.age); // COMPILER ERROR
        // System.out.println(hasTail.age); // COMPILER ERROR
        
        System.out.println(lemur.hasHair()); // true
        System.out.println(animal.hasHair()); // true
        // System.out.println(hasTail.hasHair()); // COMPILER ERROR
        
        System.out.println(lemur.isTailStriped()); // false
        // System.out.println(animal.isTailStriped()); // COMPILER ERROR
        System.out.println(hasTail.isTailStriped()); // false
	}
}
```

<hr>

# 🧠 2.3 Understanding Design Principles

* A design principle is a best practice which is applied globally to the design of an applicationl

## 🟥 Encapsulating Data
* An encapsulated class has private fields, public setters and getters

## 🟥 Java Beans
* A JavaBean is a design principle for encapsulating data. It has the following rules for naming:
1) Properties are private/.
2) Getters for non-boolean properties are prefixed with `get`
3) Getters for boolean properties are prefixed with either `is` OR `get`
4) Setters begin with `set`
5) After the prefix, the first letter for setter/getter is upper-cased


## 🟥 Has-a Relationship

* The `has-a` relationship is the property where an object had a named data object as a member. Also know as the Composition Test.

## 🟥 Composing Objects

* Object Composition is the property of constructing a class using references to other classes.

* Composition can help us simulate polymorphic behaviour without having to relate classes through inheritance

<hr>

# 🧠 2.4 Working with Design Patterns

* A design pattern is an established general solution to a specific problem.


## 🟥 Singleton Design Pattern

* We can create a class which follows the Singleton design pattern so that multiple classes can access a shared single instance in memory

* A Singleton has:
    - A private constructor
    - A static final instance
    - A static `getInstance()` method
    - `synchronized` methods which modify data (to ensure thread-safety)

### 🟡 Example: 

```java
public class HayStorage {
    private int quantity = 0;
    private HayStorage() {}
    private static final HayStorage instance = new HayStorage();
    public synchronized void addHay(int amount) {
        quantity += amount;
    }
    public synchronized boolean removeHay(int amount) {
        if (quantity < amount) return false
        quantity -= amount; return true;
    }
}
``` 

### 🟡 Applying Lazy Instantiation

* In the above, the instance is always instantiated when the class is loaded. We can enforce lazy instantiation but we will lose thread safety!

```java
public class HayStorage {
    private int amount = 0;
    private HayStorage() {}
    private static HayStorage instance;
    public static HayStorage getInstance() { // not thread-safe
        if (instance == null) 
            instance = new HayStorage(); 
        return instance;
    }
    // Data access methods
}
```

* We can ensure thread-safety by applying `synchronized` to the getInstance method.

## 🟥 Creating Immutable Objects

* This is a creational design pattern where objects are constructed with all data needed during instantiation, properties are all final, setters are not defined, methods can not be overridden.

* We must be careful, we can construct a mutable class by mistake:

```java
public final class Human {
	private final List<String> favouriteFoods;
	public Human(List<String> favouriteFoods) {
		if (favouriteFoods == null)
			throw new RuntimeException("food is required!!!");
		this.favouriteFoods = new ArrayList<String>(favouriteFoods);
	}
	
	public List<String> getFavouriteFoods() {
		return favouriteFoods;
	}
    public static void main(String[] args) {
		Human shiv = new Human(Arrays.asList("chicken", "falafel"));
		shiv.getFavouriteFoods().add("pizza");
		System.out.println(shiv.getFavouriteFoods()); // [chicken, falafel, pizza]
		// ^Immutability is broken!!!
	}
}
```

* We can fix this issue, by returning a new instance of ArrayList:

```java
public List<String> getFavouriteFoods() {
    return new ArrayList(favouriteFoods);
}
```


## 🟥 Builder Pattern

* This is a pattern which can help when the properties of a class become far too large to define in its constructor!

### 🟡 Example:

````java
public class HumanBuilder {
	private String name;
	private int age;
	private List<String> favoriteFoods;
	public HumanBuilder setName(String name) {
		this.name = name;
		return this;
	}
	public HumanBuilder setAge(int age) {
		this.age = age;
		return this;
	}
	public HumanBuilder setFavoriteFoods(List<String> foods) {
		this.favoriteFoods = foods;
		return this;
	}
	public HumanV2 build() {
		return new HumanV2(name, age, favoriteFoods);
	}
}
class HumanV2 {
	private String name;
	private int age;
	private List<String> favouriteFoods;
	public HumanV2(String name, int age, List<String> favouriteFoods) {
		this.name = name;
		this.age = age;
		this.favouriteFoods = favouriteFoods;
	}
}
````

* We can now construct a `HumanV2`:

```java
HumanV2 shiv = new HumanBuilder()
    .setAge(25)
    .setName("shiv")
    .setFavoriteFoods(Arrays.asList("pizza","chicken"))
    .build();
```


## 🟥 Factory Pattern

* The Factory pattern lets us create an object of a precise type known until runtime.

### 🟡 Example:

* Suppose we have the following classes/implementations:
```java
public abstract class Food {
	private int quantity;
	public Food(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() { return quantity; }
	public abstract void consumed();
}

class Pizza extends Food {
	public Pizza(int quantity) { super(quantity); }
	public void consumed() {
		System.out.println("pizza eaten "+getQuantity());
	}
}
class Falafel extends Food {
	public Falafel(int quantity) { super(quantity); }
	public void consumed() {
		System.out.println("falafel eaten "+getQuantity());
	}
}
class Fish extends Food {
	public Fish(int quantity) { super(quantity); }
	public void consumed() {
		System.out.println("pizza eaten "+getQuantity());
	}
}
```

* We can define a `FoodFactory` class as:

```java
public class FoodFactory {
	public static Food getFood(String animalName) {
		switch(animalName) {
			case "Human": return new Pizza(2);
			case "Goat": return new Falafel(20);
			case "Whale": return new Fish(20);
		}
		throw new UnsupportedOperationException();
	}
}
```

