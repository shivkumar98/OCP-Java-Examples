<link href="../../styles.css" rel="stylesheet"></link>

# 🟪 4.5 Working with Primitives

## 📜 Contents 📜

- [🌸 Introduction 🌸](/src/chapter_4/c_4_1_using_variables_in_lambdas/)
- [🔴 4.5.1 Creating Primitive Streams]()
    - [⭐ Main Primitive Streams ⭐]()
    - [⭐ Create using `generate()` and `iterate()` ⭐]()
    - [⭐ Create using `range()` and `rangeClosed()` ⭐]()
- [🔴 4.5.2 Using Optional with Primitive Streams]()
- [🔴 4.5.3 Summarizing Statistics]()
- [🔴 4.5.4 Learning the Functional Interfaces for Primitives]()
    - [⭐ Functional Interfaces for Boolean ⭐]()
- [🔴 4.5.5 Functional Interfaces for double, int, and long]()
    - [⭐ Common Functional Interfaces for Primitives ⭐]()

## 🌸 Introduction 🌸

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

### ⭐ Create using `generate()` and `iterate()` ⭐

* We can generate streams by passing in a lamda:

```java
DoubleStream random = DoubleStream.generate(Math::random);
random.limit(3).forEach(System.out::println);
// 0.4458924136281954 0.24499242076227645 0.7380799157851783

DoubleStream fractions = DoubleStream.iterate(0.5, d->d/2);
fractions.limit(4).forEach(System.out::println);
// 0.5 0.25 0.125 0.0625
```

### ⭐ Create using `range()` and `rangeClosed()` ⭐

* Suppose we wanted to create a stream for {1,2,3,4,5,6}. We COULD do this using iterate:

```java
IntStream simpleRange = IntStream.iterate(1,n->n+1).limit(6);
```

* We can use range instead:

```java
IntStream intRange = IntStream.range(1, 7);
```

* We could also use rangeClosed, such that the second argument is inclusive:

```java
IntStream closedIntRange = IntStream.rangeClosed(1,6);
```

* ⚠️We CAN create ranges for `IntStream` and `LongStream` but NOT `DoubleStream`⚠️:

```java
// DoubleStream doubleRange = DoubleStream.range(1.0, 1.2); // DOES NOT COMPILE
```

* Here is a realistic example of using a primitive stream:

```java
Stream<String> objStream = Stream.of("Fish", "Sticks");
IntStream lengths = objStream.mapToInt(s->s.length());
```

## 🔴 4.5.2 Using Optional with Primitive Streams

* We saw earlier that we wrote the average of an int[], we can wrtie this in a better way:

```java
int[] ints = {1,2,3,4,5};
IntStream streamOfInts = Arrays.stream(ints);
OptionalDouble average = streamOfInts.average();
System.out.println("average: "+average.getAsDouble()); // average: 3.0
// getAsDouble() makes it obvious it returns primitive as a return	
```

## 🔴 4.5.3 Summarizing Statistics

* We can define a method which calculates the max of a stream, and throws an exception when if is `optional.empty`:

```java
private static int max(IntStream ints){
    OptionalInt optional = ints.max();
    return optional.orElseThrow(RunTimeException::new)
}
```

* Suppose we want to calculate the range of an instream. We can NOT call `min()` and `max()` on the same stream as it will cause the stream to terminate:

```java
private static int rangeBroken(IntStream ints) {
    return ints.max().getAsInt() - ints.min().getAsInt();
}
```

* We can use `IntSummaryStatistics` on an IntStream:

```java
private static int range(IntStream ints) {
    IntSummaryStastics stats = ints.summaryStatistics();
    if (stats.getCount()==0) throw new RuntimeException();
    return stats.getMax()-stats.getMin();
}
```


## 🔴 4.5.4 Learning the Functional Interfaces for Primitives

### ⭐ Functional Interfaces for Boolean ⭐

* The `BooleanSupplier` is a functional interface with the following method:

```java
boolean getAsBoolean()
```

* Here are some examples of implementations:

```java
BooleanSupplier b1 = () -> true;
BooleanSupplier b2 = () -> Math.random() > .5;
```

### ⭐ Functional Interfaces for double, int, and long ⭐

| Functional Interfaces                          | # Parameters  | Return Type              | Single Abstract Method     |
|------------------------------------------------|---------------|------------------------  |--------------------------- |
|`DoubleSupplier`/`IntSupplier`/`LongSupplier`   | 0             | `double`/`int`/`long`    | Single Abstract Method     |
|`DoubleConsumer`/`IntConsumer`/`LongSupplier`   | 1             | `void`                   | `accept`                   |
| `DoublePredicate`/`IntPredicate`/`LongPredicate`| 1         | `boolean`                   | `test`                     | 
| `DoubleFunction<R>`/`IntFunction<R>`/`LongFunction<R>` | 1         | `R`                  | `apply`                    |
| `DoubleUnaryOperator`/`IntUnaryOperator`/`LongUnaryOperator`| 1 | `double`/`int`/`long`   | `applyAsDouble`, `applyAsInt`, `applyAsLong` |
| `DoubleBinaryOperator`/`IntBinaryOperator`/`LongBinaryOperator`| 2 | `double`/`int`/`long`| `applyAsDouble`, `applyAsInt`, `applyAsLong` |

* Examples:

```java
IntSupplier supplyRandom = () -> (int)(Math.random()*100);
System.out.println(supplyRandom.getAsInt()); // 42

DoublePredicate pred = i -> i%2==0;
System.out.println(pred.test(2.0)); // true

DoubleFunction<Integer> floor = i->(int)Math.floor(i); 
System.out.println(floor.apply(3.2)); // 3

DoubleUnaryOperator divideBy3 = i-> i/3;
System.out.println(divideBy3.applyAsDouble(9.9)); // 3.3000000000000003

LongBinaryOperator add = (i,j) -> (i+j);
System.out.println(add.applyAsLong(1L, 2L)); // 3
```


### ⭐ Primtive-Specific Functional Interfaces ⭐

| Functional Interfaces| # Parameters  | Return Type  | Single Abstract Method     |
| ---------------------| ------------- | -------------| ---------------------------|
|`ToDoubleFunction<T>`/`toIntFunction<T>`/`ToLongFunction<T>` | 1 (T)        | `double`/`int`/`long` | `applyAsDouble`/`applyAsInt`/`applyAsLong` |
|`ToDoubleBiFunction<T,U>`/`ToIntBiFunction<T,U>`/`ToLongBiFunction<T,U>`|2 (T, U) | `double`/`int`/`long` | `applyAsDouble`/`applyAsInt`/`applyAsLong` |
|`DoubleToIntFunction`/`DoubleToLongFunction` | 2 (double) | `int`/`long` | `applyAsInt`/`applyAsLong` |
|`IntToLongFunction`/`IntToDoubleFunction`| 1 (int) | `long`/`double` | `applyAsLong`/`applyAsDouble`|
|`LongToDoubleFunction`/`LongToIntFunction`|1 (long) | `double`/`int` | `applyAsDouble`/`applyAsInt` |
|`ObjDoubleConsumer<T>`/`ObjIntConsumer<T>`/`ObjLongConsumer<T>` | 2 | void | `accept` |

* Examples:

```java
ToDoubleFunction<String> calculateLength = (String i)-> i.length() + i.replace("\\s+", "").length()*0.1;
System.out.println(calculateLength.applyAsDouble(" hello shiv ")); // 13.2

ToIntBiFunction<int[], Integer> countNumberOfTarget 
			= (arr, target)-> (int)Arrays.stream(arr).filter(i->i==target).count();
System.out.println(countNumberOfTarget.applyAsInt(new int[]{1,1,2,1},3)); // 0		
System.out.println(countNumberOfTarget.applyAsInt(new int[]{1,1,2,1},1)); // 3

		
DoubleToIntFunction truncate = i -> (int)i;
System.out.println(truncate.applyAsInt(3.94)); // 3
System.out.println(truncate.applyAsInt(-6.94)); // -6

IntToLongFunction muliplyBy10ToPower9 = i -> i*(int)(Math.pow(10, 9));
System.out.println(muliplyBy10ToPower9.applyAsLong(2)); // 2000000000
System.out.println(muliplyBy10ToPower9.applyAsLong(3)); // -1294967296 overflow :(

LongToDoubleFunction findAreaOfCircleWithRadius = i-> i*Math.PI;
System.out.println(findAreaOfCircleWithRadius.applyAsDouble(1L)); // 3.141592653589793

ObjIntConsumer<String> print = (s,i)-> System.out.println(s+i);
ObjIntConsumer<Integer> print2 = (s,i)-> System.out.println(s+i);
print.accept("shiv is aged: ", 25); // shiv is aged: 25
print2.accept(23, 3); // 26
```