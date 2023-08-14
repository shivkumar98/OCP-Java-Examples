<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 1.6 Working with Enums

## 🔴 1.6.1 Enum Basics

* We can make a method accept an enum so that it will only accept restricted values.
* We can create an enum like:
```java
public enum Season {
	WINTER, SPRING, SUMMER, FALL
}
```
* If we call any of the enums, e.g. `Season.WINTER`, then we get an enum of Season back!
* If we wanted to get the String literal, we would call `Season.WINTER.name()`
* We can loop through the enum using `Season.values`
* The `ordinal()` of an enum value is the index of its position. E.g. `Season.SPRING.ordinal()` is 1

## 🔴 1.6.1 Enum in Switch

* We can have a switch statement on an enum value:
```java
Season summer = Season.SUMMER;
switch(summer) {
	case WINTER:
		break;
	// etc
}
```

## 🔴 1.6.2 Adding Constructors, Fields, and Methods

* Suppose we wanted to associate a String representing traffic patterns with each enum value. We need a field to represent the Strings, a constructor so that we can supply the String, and finally a getter method:

```java
enum SeasonV2 {
   WINTER("low"), 
   AUTUMN("medium"), 
   SPRING("high"), 
   SUMMER("max");
   private String pattern;
   SeasonV2(String pattern) {
       this.pattern = pattern;
   }
   String getValue() {
	   return pattern;
   }
}
```

* We can supply methods to our Enum values:

```java
public enum Season {
	WINTER {
		public void printHours() { System.out.println("short"); }
	}, SUMMER {
		public void printHours() { System.out.println("long"); }
	}
}
```
