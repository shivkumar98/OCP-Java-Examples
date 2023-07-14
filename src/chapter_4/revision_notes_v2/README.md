<link href="../../styles.css" rel="stylesheet"></link>

# 📝 Chapter 4: Revision Notes V2

# 🧠 4.1 Using Variables in Lambdas

* We can use local variables, method variables, static and instance variables which are effectively final

# 🧠 4.2 Working with Built in Functional Interfaces

*  There are several built in functional interfaces which are used for streams:

1) `Supplier<T>` - gets T
2) `Consumer<T>` - accepts T
3) `BiConsumer<T,U>` - accepts T and U
4) `Predicate<T>` - tests T
5) `BiPredicate<T,U>` - test T and U
6) `Function<T,R>` - applies function to T and returns R
7) `BiFunction<T,U,R>` - applies function to T and U and returns R
8) `UnaryOperator<T>` - applies function to T and returns T
9) `BinaryOperator<T,T>` - applies function to two T parameters and returns T

## 🟥 Implementing Consumer and BiConsumer

```java
Consumer<String> c1 = System.out::println;
```

```java
Map<String, Integer> map = new HashMap<>();
BiConsumer<String, Integer> b1 = map::put;
BiConsumer<String, Integer> b2 = (k,v)-> map.put(k,v);
```

## 🟥 Checking Functional Interfaces

* What functional interfaces would fill in the blanks:

```java
6:  ___<List> ex1 = x -> "".equals(x.get(0));
7:  ___<Long> ex2 = (Long l) -> System.out.println(l)
8:  ___<String, String> ex3 = (s1,s2) -> false;
```

* `Predicate`, `Consumer`, `BiPredicate`