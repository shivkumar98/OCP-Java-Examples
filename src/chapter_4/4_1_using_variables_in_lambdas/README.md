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
| `Consumer<T>`
| `BiConsumer<T, U>`
| `Predicate<T>`
| `BiPredicate<T,U>`
| `Function`
| `BiFunction<T, U, R>`
| `UnaryOperator`
| `BinaryOperator`

