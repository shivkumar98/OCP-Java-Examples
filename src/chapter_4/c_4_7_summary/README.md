<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 4.7 Summary

*  Lambdas can references static and instance variables from wihtin. They can also access local variables which are effectively final - meaning the variable has not been reassigned or is literally labeled final!

* I must know the following functional interfaces!:

1) `Supplier<T>`: `get()` returns T
2) `Consumer<T>`: `accept(T t) returns void
3) `BiConsumer<T, U>`: `accept(T t, U u) returns void
4) `Predicate<T>`: `test(T t)` returns booolean
5) `BiPredicate<T, U>`: `test(T t, U u)` returns boolean
6) `Function<T, R>`: `apply(T t)` returns R
7) `BiFunction<T, U, R>`: `apply(T t, U u)` returns R
8) `UnaryOperator<T>`: `apply(T t)` returns T
9) `BinaryOperator<T>`: `apply(T t1, T t2)` returns T

* An `Optional` can be used to store a value or its empty. We can can use `ifPresent()` and `get()` to get its value.

* We have 3 methods for Optionals which accept functional interfaces:

1) `ifPresent(Consumer c)`
2) `elseGet(Supplier s)`
3) `orElseThrow(Supplier c)`

* Stream pipelines have 3 parts:

1) Source of data

2) Intermediate Operations - optional and can be multiple. E.g. `filter()`, `flatMap()`, `sorted()`

3) Terminal Operation - e.g. `allMatch()`, `count()`, `forEach()`

* We can create streams for primitive data types, for these we must use `DoubleStream`, `IntStream` and `LongStream`!

* We can quickly generate a stream of INTEGERS within a range using `range(i,j)` and `rangeClosed(i,j)`. These methods are only available on DoubleStream and IntStream!

* We have access to `average()`, `min()`, `max()` for these primitive streams. We can also generate a `SummaryStatistic` by calling `summaryStatistics()`

* We have functional interfaces specifically for boolean, e.g. `BooleanSupplier` can be use to generate a primitive boolean value!