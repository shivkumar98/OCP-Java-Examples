# Revision Notes

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