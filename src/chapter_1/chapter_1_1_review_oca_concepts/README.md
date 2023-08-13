<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 1.1 Reviewing OCA Concepts

## 🔴 1.1.1 Access Modifiers

* Here is a quick summary of the access modifiers when applied to instance variables:
1) `public` - accessible in any package and any class
2) `protected` - accessible in subclasses in ANY package
3) `default` - accessible from any class in SAME package
4) `private` - accessible from the class it's defined in

### ⭐ Overloading and Overriding ⭐
* An overload is where the parameters of the method signature change in type. 
* You can not create an overload by JUST changing the return type! The compiler will complain that the method is already defined!
* Overrides are created in the subclass with a method of same signature and COVARIANT return type. The access modifier must be same, or more forgiving!
* Static methods are hidden, they can NOT be overriden - but we can create another static method of same signature

### ⭐ Static and Final ⭐
* A class which is marked final can not be extended
* You can only apply static to a class which is nested

### ⭐ Imports ⭐
* In order to call a static method without having to reference the class, you must add static after import.
* E.g. to call `Collections.sort()` statically, your import would be:

```java
import static java.util.sort;
// main method:
List<String> list = Arrays.asList("x","b","a");
sort(list);
```