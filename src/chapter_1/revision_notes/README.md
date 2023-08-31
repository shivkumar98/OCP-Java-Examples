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