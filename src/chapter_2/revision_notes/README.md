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