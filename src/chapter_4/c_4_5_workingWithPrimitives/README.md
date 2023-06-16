
# 🧠 4.5 Working with Primitives

* So far, we have been making streams using wrapper classes, but we also have the ability to make streams of primitives!

* Suppose we want to calculate the sum of numbers in a finite stream:

```java
Stream<Integer> stream = Stream.of(1,2,3);
System.out.println(stream.reduce(0, (s,n)-> s+n));
```

* We can do this in another way:

```java
Stream<Integer> stream = Stream.of(1,2,3);
IntStream intStream = stream.mapToInt(x->x);
System.out.println(intStream.sum());
```

* The `IntStream` has an `average()` method:

```java
Stream<Integer> stream = Stream.of(1,2,3);
IntStream intStream = stream.mapToInt(x->x);
OptionalDouble avg = intStream.average();
System.out.println(avg.getAsDouble()); // 2.0
```

## 🔴 4.5.1 Creating Primitive Streams

### ⭐ Main Primitive Streams ⭐


* There are 3 types of primitive streams:

- IntStream: used for `byte`, `short`, `int`, `char`

- LongStream: used for `long`

- DoubleStream: used for `float` and `long`

* You can create a streams like:

```java
DoubleStream empty = DoubleStream.empty();
DoubleStream one = DoubleStream.of(3.14);
DoubleStream three = DoubleStream.of(2.18, 3.02, 3.11);
```

* We can also generate streams by passing in a lamda:

```java
DoubleStream random = DoubleStream.generate(Math::random);
random.limit(3).forEach(System.out::println);
// 0.4458924136281954 0.24499242076227645 0.7380799157851783

DoubleStream fractions = DoubleStream.iterate(0.5, d->d/2);
fractions.limit(4).forEach(System.out::println);
// 0.5 0.25 0.125 0.0625
```


