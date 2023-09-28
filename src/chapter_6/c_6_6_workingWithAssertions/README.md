<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 6.6 Working With Assertions

* An assertion is a expressions which you place in your code to state something which is true.
* In this section, we will learn the syntax for assertion and how to turn them on/off.

## 🟥 6.6.1 The assert Statement
* The syntax for an assert statement has two forms:
```java
assert boolean_expression;
assert boolean_expression: error_message;
```
* The `error_message` must be a String which is used in the `AssertionError` (if thrown)
* There are 3 possible outcomees of an assert statement:
1) If assertions are disable, Java will skip over
2) If the boolean expression is true, nothing happens
3) If the boolean expression is false, then a java.lang.AssertionError is thrown

* You enable assertions by running `java -ea className`.
* Here is an example:
```java
public class Assertions {
    public static void main(String[] args) {
        int numGuests = -5;
        assert numGuests > 0;
        System.out.println(numGuests);
    }
}
```

<hr>

## 🟥 6.6.2 Enabling Assertions
* By default, assert statements are ignored by JVM. You can enable assertions using:
```
java -enableassertions ClassName
java -ea ClassName
```
* We can also target the assertions for a specific class or package. E.g. if you wanted to enable assertions only for classes in com.wiley.demos:
```
java -ea:com.wiley.demos... my.prgrams.Main
```
* The elipsis means any class in com.wiley.demos and its subpackages.

<hr>

## 🟥 6.6.3 Using Assertions
* You can use assertion for many reasons, such as the following:
1) Internal Invariants: used to assert the validity of an object's state.
2) Internal Invariants: used to assert that a value is within a certain constraint.
3) Control Flow Invariants: used to assert a line is indeed unreachable

* Suppose we have a zoo which is closed in Winter:
```java
public enum Seasons {
    SPRING, SUMMER, FALL
}
public class TestSeasons {
    public static void test(Seasons s) {
        switch (s) {
            case SPRING:
            case FALL:
                System.out.println("Shorter hours");
                break;
            case SUMMER:
                System.out.println("Longer hours");
                break;
            default:
                assert false: "Invalid season";
        }}}
```

4) Preconditions: ensuring conditions are met before method is invoked
5) Post Conditions: ensuring conditions are met after method is invoked
