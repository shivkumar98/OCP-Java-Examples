<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 4.3 Returning an Optional

* We can use `Optional` class with methods, when we the return is not guranteed. E.g. suppose we wanted to return the average of a class but no tests have taken place yet. It would not make alot of sense to return 0 as an aeverage

* We return `Optional.empty()` if we do not have a value to return and `Optional.of(value)` when we do have a return value. In order for us to extract the value from the Optional, we call the `get()` method on it (provided it is not empty)

* Here is how we would define the `average()` method:


```java
public static Optional<Double> average(int... grades) {
    if (grades.length==0) return Optional.empty();
    double sum = 0;
    for (int grade: grades) sum += grade;
    return Optional.of(sum/grades.length);  
}

main() {
    System.out.println(average(95, 28).get()); // 61.5
    average().get(); // throws exception "no value present"
}
```

## Optional Static Methods

* We can check if an otpional contains a value using `isPresent()`

* We often want to set the value on an `Optional` object to `Optional.empty()` when the value is null:

```java
Optional o = (value==null) ? Optional.empty() : Optional.of(value);
```

* Java provides a method which achieves the same as above:

```java
Optional o = Optional.ofNullable(value);
```

## Optional Instance Methods

* We have the following Optional instance methods:

| Method                    | When Optional is Empty        | When contains value       |
| -------------             | ----------------------------- | ------------------------- |
| `get()`                   | Throws exception              | Returns value             |
| `isPresent()`             | returns `false`               | returns `true`            |
| `ifPresent(Consumer c)`   | Does nothing                  | calls consumer with value |
| `orElse(T other)`         | Returns other                 | returns value             |
| `orElseGet(Supplier s)`   | Returns result of s           | Returns value             |
| `orElseThrow(Supplier s)` | Throws exception of s         | Returns value             |

* E.g. using `ifPresent()`:

```java
average(100).ifPresent(System.out::println); // 100.0
```

* Here is an example using the other instance methods:

```java
Optional<Double> nullOpt = average();
System.out.println(nullOpt.orElse(Double.NaN)); // NaN
System.out.println(nullOpt.orElseGet(Math::random)); // 0.48081772172470216
System.out.println(nullOpt.orElseThrow(() -> new IllegalArgumentException())); // Exception in thread "main" java.lang.IllegalArgumentException
```