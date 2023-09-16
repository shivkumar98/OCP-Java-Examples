<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 5: Review Questions - Attempt 1

## Results:

Date: 
Score: /20

| Question # | Correct |
| ---------- | ------- |
| 1          |      |
| 2          |      |
| 3          |      |
| 4          |      |
| 5          |      |
| 6          |      |
| 7          |      |
| 8          |      |
| 9          |      |
| 10         |      |
| 11         |      |
| 12         |      |
| 13         |      |
| 14         |      |
| 15         |      |
| 16         |      |
| 17         |      |
| 18         |      |
| 19         |      |
| 20         |      |


<hr>

## Question 1

❓ Which of the following create valid locales, assuming that the language and country codes follow standard conventions (Choose all that apply) ❓

A. `new Locale("hi")`

B. `new Locale("hi, "IN")`

C. `new Locale("IN")`

D. `new Locale("IN", "hi")`

E. `Locale.create("hi")`

F. `Locale.create("IN")`
❓

<hr>

### My answer:
* A is valid, specifying country code is not necessary
* B is valid, follows convention
* C invalid, does not follow convention
* D invalid as above
* E and F, I don't think so!
* **A,B**

<br>


## Question 2:

❓ Which of the following are common types to localize (Choose all that apply)

    A. Booleans
    B. Class names
    C. Currency
    D. Dates
    E. Numbers
    F. Variable names
❓

<hr>

### My answer:
* D, and E are definitely localised
* Not sure if currency is localized, the formatting may be localised
* **C, D, E**
<br>

## Question 3

❓Which of the following are true (Choose all that apply)

A. All keys must be in the same resource bundle file to be used
B. All resource bundles are defined as Java classes can be expressed using the property file format instead
C. All resource bundles defined as porperty files can be expressed using the Java class list bundle format instead
D. Changing the default locale lasts for only a single run of the program
E. It is forbidden to have both Props_en.java and Props_en.properties in the class-path of an application

❓

<hr>

### My answer:
* A - yes, I think
* B - false
* C - yes
* D - yes
* E - no
* **A,C,D**

<br>

## Question 4:

❓Assume that all bundles mentioned in the answers exist and define the same keys. Which one will be used to find the key in line 8?

```java
Locale.setDefault(new Locale("en", "US"));
ResourceBundle b = ResourceBundle.getBundle("Dolphins");
b.getString("name");
```

A. `Dolphins.properties`
B. `Dolphins_en.java`
C. `Dolphins_en.properties`
D. `Whales.properties`
E. `Whales_en_US.properties`
F. The code does not compile
❓

<hr>

### My answer:
* The code DOES compile
* A - false, no language specified
* B - true
* C - true
* D - false, using different name for bundle
* E - false, same as above
* **B,C**

<br>


## Question 5

❓ Suppose that we have the following property files and code. Which bundles are used on lines 8 and 9 respectively

```properties
# Dolphins.properties
name=The Dolphin
age=0

# Dolphins_en.properties
name=Dolly
age=4

# Dolphins_fr.properties
name=Dolly
```

```java
5: Locale fr = new Locale("fr");
6: Locale.setDefault(new Locale("en", "US"));
7: ResourceBundle b = ResourceBundle.getBundle("Dolphins", fr);
8: b.getString("name");
9: b.getString("age");
```

A. `Dolphins.properties` and `Dolphins.properties`
B. `Dolphins.properties` and `Dolphins_en.properties`
C. `Dolphins_en.properties` and `Dolphins_en.properties`
D. `Whales.properties`
E. `Whales_en_US.properties`
F. The code does not compile
❓

<hr>

### My Answer:
* **C**
<br>

## Question 6:

❓Which of the following can fill in the blank to create a date of June 21, 2014 (Choose all that apply)❓

```java
import java.time.*;

public class StartOfSummer {
    public static void main(String[] args) {
        LocalDate date = _______________;
}}
```

A. `new LocalDate(2014, 5, 21);`

B. `new LocalDate(2014, 6, 21);`

C. `LocalDate.of(2014, 5, 21);`

D. `LocalDate.of(2014, 6, 21);`

E. `LocaleDate.of(2014, Calendar.JUNE, 21);`

F. `LocaleDate.of(2014, Month.JUNE, 21);`

<hr>

### My answer:  F - true


**F**

<br>


## Question 7

❓ What is the output of the following code?

```java
LocalDate date = LocalDate.parse(
    "2018-04-30", DateTimeFormatter.ISO_LOCAL_DATE);
date.plusDays(2);
date.plusHours(3);
System.out.println(date.getYear() + " "
    + date.getMonth() + " " + date.getDateOfMonth());
```


A. `2018 APRIL 4`

B. `2018 APRIL 30`

C. `2018 MAY 2`

D. The code does not compile

E. A runtime exception is thrown


<hr>

### My answer:  
* Date is `2018-04-30` and immutablke
* So it prints 2018 APRIL 30
* **B**

<br>

## Question 8:

❓What is the output of the following code

```java
LocalDate date = LocalDate.of(2018, Month.APRIL, 40);
System.out.println(date.getYear() + " " + date.getMonth()
    + " " + date.getDayOfMonth());
```

A. `2018 APRIL 4`

B. `2018 APRIL 30`

C. `2018 MAY 10`

D. Another date

E. The code does not compile

F. A runtime exception is thrown

<hr>

### My answer:
* **F**

<br>

## Question 9

❓What is the output of the following code?

```java
LocalDate date = LocalDate.of(2018, Month.APRIL, 30);
date.plusDays(2);
date.plusYears(3);
System.out.println(date.getYear() + " "
    + date.getMonth() + " " + date.getDayOfMonth());
```

A. `2018 APRIL 2`

B. `2018 APRIL 30`

C. `2018 MAY 2`

D. `2021 APRIL 2`

E. `2021 APRIL 30`

F. `2021 MAY 2`

G. A runtime exception is thrown

<hr>

### My answer:  
* Date is immutable
* Prints `2018 APRIL 30`
* **E**

<br>

## Question 10

❓ What is the output of the following code?

```java
LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
Period p = Period.of(1, 2, 3);
d = d.minus(p);
DateTimeFormatter f = DateTimeFormatter.
    ofLocalizedTime(FormatStyle.SHORT);
System.out.println(d.format(f));
```

A. `3/7/14 11:22 AM`

B. `5/10/14 11:22 AM`

C. `3/7/14`

D. `5/10/15`

E. `11:22 AM`

F. The code does not compile

G. A runtime exception is thrown

<hr>

### My answer:
* The period is of 1 year, 2 months, and 3 days
* d is 2014-3-7 11:22AM
* **A**

<br>


## Question 11

❓What is the output of the following code?
```java
LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
Period p = Period.ofDays(1).ofYears(2);
d = d.minus(p);
DateTimeFormatter f = DateTimeFormatter.
    ofLocalizedTime(FormatStyle.SHORT);
System.out.println(d.format(f));
```

A. 

B. Change `map(x -> x)` to `map(x -> "" + x)`

C. change `x -> x++` to `x -> ++x`

D. Add `forEach(System.out::print)` after the call to `collect()`

E. Wrap the entire line in a `System.out.print` statement

F. None of the above. The code already prints "12345"

<hr>

My answer: A - this makes no change to the result, so it works. B - this is fine and works. C - this is fine. D - yes. E - yes. F - no

**A, B, C, D, E**

Correct answer: B, C, E - the code does not compile. We need to fix it by using B, without C the stream would just contain "111...". collect() converts this to a string. So we can't use forEach()

<br>



## Question 12:

❓What functional interfaces complete the following code? (Choose all that apply)❓

```java
6: ______ x = String::new; 
7: ______ y = (a,b) -> System.out.println();
8: ______ z = a -> a+a;
```

A. `BiConsumer<String, String>`

B. `BiFunction<String, String>`

C. `BinaryConsumer<String, String>`

D. `BiFunction<String, String>`

E. `Consumer<String>`

F. `Supplier<String>`

G. `UnaryOperator<String>`

H. `UnaryOperator<String, String>` 


<hr>

My answer: F applies for line 6,  C applies to line 7, B and G apply to line 8

**B,C,F,G**

Correct answer: A, F, G - D is an invalid interface, C does not exist! A applied to line 7! `BiFunction<String, String>` is not valid. While E can work with line 6, it would be completely useless! Line 6 is creating something, so it is a supplier! So F is valid. H is completely invalid. G does apply to line 8!

<br>


## Question 13

❓Which of the following is true❓

```java
List<Integer> l1 = Arrays.asList(1,2,3);
List<Integer> l2 = Arrays.asList(4,5,6);
List<Integer> l3 = Arrays.asList();
Stream.of(l1, l2, l3).map(x -> x+1)
    .flatMap(x -> x.stream()).forEach(System.out::println);
```

A. The code compiles and prints `123456`

B. The code compiles and prints `234567`

C. The code compiles but does not print anything

D. The code compiles but prints stream references

E.  The code runs infinitely

F. The code does not compile

G. The code throws an exception

<hr>

My answer: D

**D**

Correct Answer: F - the code does not compile!!!. It fails when trying to map the elements. If `flatMap` was called first it would've worked!!!


<br>

## Question 14:

❓Which of the following is true❓

```java
4: Stream<Integer> s = Stream.of(1);
5: IntStream is = s.mapToInt(x -> x);
6: DoubleStream ds = s.mapToInt(x -> x);
7: Stream<Iteger> s2 = ds.mapToInt(x -> x);
8: s2.forEach(System.out::print);
```

A. Line 4 does not compile

B. Line 5 does not compile

C. Line 6 does not compile

D. Line 7 does not compile

E. Line 8 does not compile

F. The code throws an exception

G. The code compiles and prints 1.

<hr>

My answer: The code definitely does not compile. Line 4 is fine, line 5 is fine, line 6 is fine, line 7 does not compile, so line 8 also does not compile

**D, E**

Correct answer: D - Line 8 actually does compile!!!

<br>

## Question 15

❓The `partitioningBy()` collector creates a `Map<Boolean, List<String>>` when passed to `collect()` by default. When specific parameters are passed to `partioningBy()`, which return types can be created? (Choose all that apply)❓

A. `Map<boolean, List<String>>`

B. `Map<Boolean, Map<String>>`

C. `Map<Long, TreeSet<String>>`

D. `Map<Boolean, List<String>>`

E. `Map<Boolean, Set<String>>`

F. None of the above


<hr>

My answer: A, B

**A, B**

Correct answer: D, E - A and B are not valid!!! Option C is invalid as it partitions to true,false.  The result can be changed to List or Set, making D and E correct!

<br>


## Question 16

❓What is the output of the following❓

```java
Stream<String> s = Stream.empty();
Stream<String> s2 = Stream.empty();
Map<Boolean, List<String>> p = s.collect(
    Collectors.partitionBy(b -> b.startsWith("c")));
Map<Boolean, List<String>> g = s.collect(
    Collectors.groupBy(b -> b.startsWith("c")));
```

A. `{} {}`

B. `{} {false=[], true=[]}`

C. `{false=[], true=[]} {}`

D. `{false=[], true=[]} {false=[], true=[]}`

E. The code does not compile

F. An exception is thrown

<hr>

My answer: the first Map is partitioned, so it is grouped by false,true - so C and D seem valid. I go for C!

**C**

Correct answer: C!!! - partition will always return map with boolean key. The groupBy returns only keys which are needed

<br>

## Question 17

❓Which of the following is equivalent to this code❓

```java
UnaryOperator<Integer> u = x -> x * x;
```

A. `BiFunction<Integer> f = x -> x*x;`

B. `BiFunction<Integer, Integer> f = x -> x*x;`

C. `BinaryOperator<Interger, Integer> f = x -> x*x;`

D. `Function<Integer> f = x -> x*x;`

E. `Function<Integer, Integer> f = x -> x*x;`

F. None of these above

<hr>

My answer: A is not valid, B is not valid, C is not valid, D is not valid, E is valid!

**E**

Correct answer: E - the other options do not even compile

<br>


## Question 18

❓What is the result of the following❓

```java
DoubleStream s = DoubleStream.of(1.2, 2.4);
s.peek(System.out.::println).filter(x -> x > 2).count();
```

A. 1

B. 2

C. 2.4

D. 1.2 and 2.4

E. There is no output

F. The code does not compile

G. An exception is thrown


<hr>

My answer: C

**C**

Correct answer: D - there is a terminal operation, which means the intermediate operations DO run! The peek() comes before the filter so both numbers get printed

<br>

## Question 19

❓Which of the following return primitives❓

A. `BooleanSupplier`

B. `CharSupplier`

C. `DoubleSupplier`

D. `FloatSupplier`

E. `IntSupplier`

F. `StringSupplier`


<hr>

My answer: A, C, E

**A, C, E**

Correct answer: ACE!!!

<br>

## Question 20

❓What is the simplest way of rewriting this code❓

```java
List<Integer> l = IntStream.range(1,6)
    .mapToObj(i -> i).collect(Collectors.toList());
l.forEach(System.out::println);
```

A. 
```java
IntStream.range(1,6);
```

B. 
```java
IntStream.range(1,6)
    .forEach(System.out::println);`
```

C. 
```java
IntStream.range(1,6)
    .mapToObj(i->i)
    .forEach(System.out::println);
```

D. None of the above is equivalent

E. The provided code does not compile

<hr>

My answer: B

**B**

Correct answer - B!!!

<br>