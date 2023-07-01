<link href="style.css" rel="stylesheet"></link>

# 🟪  Chapter 4: Functional Programming

## 🟦 Contents:

 [4.1: Using Variables in Lambdas](/src/chapter_4/c_4_1_using_variables_in_lambdas/)

 [4.2: Working with Built-in Functional Interfaces]()

 [4.3: Returning an Optional]()
 
 [4.4: Using streams]()

 [4.5: Working with Primitives]()
 
 [4.6: Working with Advanced Pipeline Concepts]()

<hr>

## 🟦 Exam Objectives:

This chapter will introduce more functional interfaces and the `Optional` class.

* Generics and Collections:

    - Collections Steams and Filters
    - Iterate using forEach methods on Streams and List
    - Describe Stream interface and Stream pipeline
    - Use method references with Streams

* Lambda Built-In Functional Interfaces

    - Use the built-in interfaces in `java.util.function` such as `Predicate`, `Consumer`, `Function` and `Supplier`
    - Develop code which uses primitive versions of functional interfaces
    - Develop code which uses binary version of functional interfaces.
    - Develop code that uses the `UnaryOperator` interface

* Java Stream API:

    - Develop code to extract data from an object using `peek()` and `map()` methods including the primitive versions of `map()`
    - Search for data by using search methods in Streams such as `findFirst`, `findAny`, `anyMatch`, `allMatch`, and `noneMatch`
    - Develop code which uses the `Optional` class
    - Develop code which uses Stream data and calculation methods
    - Sort a collection using Stream API
    - Save results to a collection using the collect method
    - Use `merge()` and `flat()` methods of Stream API


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
