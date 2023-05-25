<link href="../style.css" rel="stylesheet"></link>

# 4.1 Using Variables in Lambdas


* A variable is effectively final if it is not modified after initialisation in the local block. Effectively final variables can use therse variables inside a lambda expression

* How many effectively final local cariables can you find in this example:

```java
interface Gorilla { String move(); }
class GorillaFamily {
    String walk = "walk";
    void everyonePlay(boolean baby) {
        String approach = "amble";
        // approach = "run";

        play(() -> walk);
        play(() -> baby ? "hitch a ride":"run");    // line 9
        play(() -> approach);
    }
    void play(Gorilla g) {
        System.out.println(g.move());
    }
}
```

# 4.2 Working with Built-in Functional Interfaces

* A functional interface has exactly one abstract method. The below table are functional interfaces introduced in Java 8.


| Function Interfaces   | No. of parameters  | Return Type | Method    |
| --------------------- | ------------------ | ----------- | --------- |
| `Supplier<T>`         | 0                  | T           | `get`     |
| `Consumer<T>`         | 1                  | void        | `accept`  |
| `BiConsumer<T, U>`    | 2                  | void        | `accept`  |
| `Predicate<T>`        | 1                  | boolean     | `test`    |
| `BiPredicate<T,U>`    | 2                  | boolean     | `test`    |
| `Function<T,R>`       | 2                  | R           | `apply`   |
| `BiFunction<T, U, R>` | 2 (T, U)           | R           | `apply`   |
| `UnaryOperator<T>`    | 1                  | T           | `apply`   |
| `BinaryOperator<T>`   | 2 (T, T)           | T           | `apply`   |

## 4.2.1 Implementing Supplier

* The `Supplier` class is used when you want to generate a value without requiring input. This interface is defined as:

```java
@FunctionalInterface class Supplier<T>() {
    public T get();
}
```

* The Supplier is often implemented as a object factory. E.g. we could create a supplier which returns `LocalDate.now()`:

```java
Supplier<LocalDate> s1 = LocalDate::now;
Supplier<LocalDate> s1Again = () -> LocalDate.now();

LocalDate d1 = s1.get();
System.out.println(d1); // 2023-05-25
```

* Here is another example which instantiates an ArrayList:

```java
Supplier<ArrayList<String>> s1 = ArrayList<String>::new;
ArrayList<String>           a1 = s1.get();
System.out.println(a1); // []
```

* If we print out the functional interface itself we get something like `chapter_4.FunctionalInterfaces$$Lambda$44/0x0000000800113990@5ef60048`