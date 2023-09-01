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

<hr>

# 🧠 1.3 Coding equals and hashCode

## 🟥 equals
* We can override the `boolean equals(Object object)` method from the `Object class`.
* Java has a contract for having valid implementations of the `equals()` metho:
- If two objects are equals, then they MUST have the same hashCode.
- Two objects having the same hashCode do not require to be equal
## 🟥 hashCode
* When implementing equals, you should also implement the hashcode! This is because if you create a hashMap, the hashCode is used to store the mapping key.

<hr>

# 🧠 1.4 Working with Enums
* You can define an enum as simply a list of constants:
```java
public enum EnumClass {
	enum1, enum2, enum3
}
```
* We can add a private constructor which allows each enum to store a property:
```java
public enum Restaurants {
    KFC(true), McD(false), Starbucks(false);
    private boolean servesChicken;
    private Restaurants(boolean servesChicken) {
        this.servesChicken = servesChicken;
    }
}
```
* The constructor is called exactly once when the enum is referenced.
* We can also define an abstract method within the enum class, which requires all the enums to implement:
```java
public enum Seasons {
	WINTER {void printHours() {
		System.out.println("11am-4pm");
		}
	},
	SPRING {void printHours() {
		System.out.println("9am-6pm");
	}},
	SUMMER {
		void printHours() {} 
	};
	abstract void printHours();
}
```
* We can also remove the `abstract` modifier so that all of the enums will use a default implementation.