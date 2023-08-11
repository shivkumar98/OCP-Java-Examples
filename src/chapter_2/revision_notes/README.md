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