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