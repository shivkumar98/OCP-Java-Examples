<link href="../../styles.css" rel="stylesheet"></link>

# 📝 Chapter 1: Advanced Class Design

# 🧠 1.1 Reviewing OCA Concepts

## 🟥 Access Modifiers
* If a class has a private variable, it can only be accessed inside that class
* If a class has a protected variable, it can be accessed in the same package or subclasses in anypackage!
* If a class has package private variable, it is only accessible in the same package. Not accessible even in a subpackage
* If a class has a public variable, it is accessible everywhere

## 🟥 Overriding and Overloading
* An override should return a covariant type.
* If the parent throws a checked exception, it is NOT REQUIRED to throw checked exception but if it does it can not be new or broader than parent class
* If parent DOES NOT declare any exceptions, override CAN NOT throw any  checked exception
* When multiple overloads are available, Java will call the closest match first. It will then try the following:
    - Matching superclass type
    - Convert to a larger primitive type
    - Convert to autoboxed type
    - Varargs.

<hr>

# 🧠 1.2 Using instanceof
* `a instanceof B` will return true if:
    - `a` is an instance of B
    - `a` is an instance of a subclass of B (including indirectly)
    - `a` is an instance of a class which implements B
* Calling `a instanceof Object` will always return true EXCEPT when a is null.
* If your are seeing if a object is an instance of a concrete class which is not of the same type (through inheritance) then a compilation error will occur
* A complilation error does not occur if your are comparing against an object which is referenced through an interface!