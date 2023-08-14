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

