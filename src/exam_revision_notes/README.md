# Revision Notes

## Chapter 1: Advanced Class Design
* A Nested class cannot have static variables because a nested class always has to be instantiated
* A nested class can access its enclosing class using the following syntax: `enclosingClassName.this.variableName`. E.g.:
```java
class Outer {
   int x = 10;
   class Inner {
      int x = Outer.this.x;
   }
}
```
* A member nested class can NOT have static variables
```java
class Outer {
   class Inner {
      static int x = 1; // COMPILER ERROR
   }
}
```
* We can only declare static variable in STATIC nested classes
* If we have a nested class `Inner` we can instantiate it by first instantiating `Outer`; we can use `Inner` as a reference to this instance, provided its imported
```java
class Outer {
   class Inner {}
}

Inner inner = new Inner(); // COMPILER ERROR
Inner inner = new Outer().new Innner(); // WORKS!
```

## Chapter 2: Design Patterns and Principles
* If you are using the return keyword in lambda, it MUST be in curly braces
```java
() -> return 0; // COMPILER ERROR
```
* Singleton classes have the following properties:
   - Instance is private and static
   - Ensures only one instance is kept in memory
   - Instance is accessed via public static method which returns a copy of the reference
   - Synchnrozing the Singleton class is not essential but does improve Singleton pattern
* Immutable classes have the folloiwing properties:
   - private final variables
   - If a member is a list, it should not give direct reference in getter, and constructor should take a copy to set fields
   - No setters
* Interfaces can extend abstract classes or interfaces, NOT concrete classes!
* Interface can not implement mmultiple interfaces if it inherits two default methods of same signature
```java
interface CanWalk {
   void walk() { System.out.println("walk"); }
}
interface CanRun {
   void walk() { System.out.println("walk"); }
}
public interface invalidInterface extends CanWalk, CanRun { // COMPILER ERROR
}
```

## Chapter 3 Generics and Collections
* The ArrayDeque has a pop method which removes and returns the start of the List, peek method only returns start of List
* The `List` interface has a `remove(index)` method, while `Queue` has `remove(T object)` method