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
    public static HayStorage getInstance() {
        if (instance == null)
            instance = new HayStorage();
        return instance;
    }
    // Data access methods
}
```