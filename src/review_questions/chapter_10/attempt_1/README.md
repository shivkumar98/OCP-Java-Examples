<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 10: Review Questions - Attempt 1

## Results:

Date:  <br>
Score: <br>
❌✅
| Question # | Correct |
| ---------- | ------- |
| 1          |        |
| 2          |        |
| 3          |        |
| 4          |        |
| 5          |        |
| 6          |        |
| 7          |        |
| 8          |        |
| 9          |        |
| 10         |        |
| 11         |        |
| 12         |        |
| 13         |        |
| 14         |        |
| 15         |        |
| 16         |        |
| 17         |        |
| 18         |        |
| 19         |        |
| 20         |         |


<hr>

## 🟧 Question 1

❓ Which interfaces or classes are in a database-specific JAR file (Choose all that apply)

A. Driver <br>
B. Driver's implementation <br>
C. DriverManager <br>
D. DriverManager's implementation <br>
E. Statement <br>
F. Statement's implementation <br>


### My Answer:
* A - false, would not contain an interface
* B - true
* C - false
* D - true
* E - false
* F - true
* **B,D,F**
<hr>

## 🟧 Question 2:

❓ Which are required parts of a JDBC URL (Choose all that apply)

* A. Connection parameters <br>
* B. Database name <br>
* C. `jdbc` <br>
* D. Location of database <br>
* E. Port <br>
* F. Password <br>
  
❓

### My Answer:
* A - true
* B - true
* C - true
* D - true
* E - false, port number is optional
* F - false, password may not be needed
* **A,B,C,D**
<hr>


## 🟧 Question 3

❓ Which of the following is a valid JDBC URL?

* A. `jdbc:sybase:localhost:1234/db` <br>
* B. `jdbc::sybase::localhost::/db` <br>
* C. `jdbc::sybase:localhost::1234/db` <br>
* D. `sybase:localhost:1234/db` <br>
* E. `sybase::localhost::/db` <br>
* F. `sybase:localhost::1234/db` <br>
  
❓

### My Answer:
* D, E and F are false as they are missing the protocol
* A is the correct answer
* **A**
<hr>

## 🟧 Question 4:

❓ What file is required inside a JDBC 4.0+ driver JAR

* A. `java.sql.Driver` <br>
* B. `META-INF/java.sql.Driver` <br>
* C. `META-INF/db/java.sql.Driver` <br>
* D. `META-INF/database/java.sql.Driver` <br>
* E. `META-INF/service/java.sql.Driver` <br>
  
❓

### My Answer:
* I don't think any of these are valid!
<hr>

## 🟧 Question 5

❓ Suppose that you have a table named `animal`  with two rows. What is the result of the following code?

```java
6:   Connection conn = new Connection(url, userName, password);
7:   Statement stmt = conn.createStatement();
8:   ResultSet rs = stmt.executeQuery("select count(*) from animal");
9:   if (rs.next()) System.out.println(rs.getInt(1));
```

* A. 0 <br>
* B. 2 <br>
* C. There is a compiler error on line 6 <br>
* D. There is a compiler error on line 9 <br>
* E. There is a compiler error on another line <br>
* F. A runtime exception <br>

❓

### My Answer:
* I don't THINK line 6 compiles
* If it did compile, line 9 WOULD compile
* **C**
<hr>

## 🟧 Question 6:

❓Which of the following are true (Choose all that apply) 

* A. Calling `Class.forName()` is mandatory for JDBC 4.0 <br>
* B. `Class.forName()` throws a `ClassNotFoundException` if the driver class is not found <br>
* C. `Class.forName()` throws an SQLException if the driver class is not found <br>
* D. `DriverManager.getConnection()` throws a `ClassNotFoundException` if the driver class is not found <br>
* E. `DriverManager.getConnection()` throws a `SQLException` if the driver class is not found <br>

❓

### My Answer:
* A - false, this method is not necessary
* I THINK `Class.forName()` throws a ClassNotFoundException
* I think `DriverManager.getConnection()` throws SQLException as this was needed to be declared in the code I wrote for this chapter
* **B,E**
<hr>


## 🟧 Question 7
❓ Which of the following can fill in the blank? (Choose all that apply)

```java
public void stmt(Connection conn, int b) throws SQLException {
    Statement stmt =  conn.createStatement(________, b);
}
```
❓

* A. `ResultSet.CONCUR_READ_ONLY` <br>
* B. `ResultSet.CONCUR_UPDATABLE` <br>
* C. `ResultSet.TYPE_FORWARD_ONLY` <br>
* D. `ResultSet.TYPE_REVERSE_ONLY` <br>
* E. `ResultSet.TYPE_SCROLL_INSESNTIVE` <br>
* F. `ResultSet.TYPE_SCROLL_SENSITIVE` <br>

### My Answer:
* So the first argument of the createStatement method determines the scrollability of the ResultSet
* **C,E,F**
<hr>

## 🟧 Question 8:

❓ Given a valid `conn` object of type Connection, what will happen if you run this code when the requested mode is not supported?

```java
conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
```

* A. A `ClassNotFoundException` is thrown <br>
* B. A `NoSuchTypeException` is thrown <br>
* C. A `SQLException` is thrown <br>
* D. A `TypeNoutFoundException` is thrown <br>
* E. The code will run without throwing an exception <br>
* F. None of the abopve. The code will not compile <br>

### My Answer:
* There will not be any compilation issues
* I do believe the code will still run without exception throwing as the modes will fallback to a supported mode
* **E**
<hr>


## 🟧 Question 9

❓Which of the following can we add line 5 for the code to run without error and not produce any output? (Choose all that apply)❓

```java
4:  LongStream ls = LongStream.of(1,2,3);                           
5:  OptionalLong opt = ls.map(n -> n * 10).filter(n -> n < 5).findFirst();  
```

* A. `if (opt.isPresent()) System.out.println(opt.get());` <br>
* B. `if (opt.isPresent()) System.out.println(opt.getAsLong());` <br>
* C. `opt.ifPresent(System.out.println);` <br>
* D. `opt.ifPresent(System.out::println)` <br>
* E. None of these; the code does not compile <br>
* F. None of these; line 5 throws an exception <br>

### My Answer:
* ls = [1,2,3]
* ls = [10,20,30]
* ls = []
* B - true
* D - true
* **B,D**✅✅✅✅
<hr>


## 🟧 Question 10

❓ Select from the following statements and indicate the order in which they would appear to output 10 lines:❓

```java
Stream.generate(()-> "");
L:  .filter(x -> x.length() > 1)  
M:  .forEach(System.out::println)
N:  .limit(10)                    
O:  .peek(System.out::println)
;
```

* A. `L, N` <br>
* B. `L, N, O` <br>
* C. `L, N, M` <br>
* D. `L, N, M, O` <br>
* E. `L, O, M` <br>
* F. `N, M` <br>
* G. `N, O` <br>

### My Answer:
* Anything with L will be wrong
* We need N
* F - true
* G - false, peek is intermediate
* **F**✅✅✅✅
<hr>

## 🟧 Question 11

❓What changes need to be made for this code to print the string `12345` (choose all that apply)❓
```java
Stream.iterate(1, x->x++).limit(5).map(x -> x).collect(Collectors.joining());
```

* A. Change `Collectors.joining()` to `Collectors.joining("")` <br>
* B. Change `map(x -> x)` to `map(x -> "" + x)` <br>
* C. change `x -> x++` to `x -> ++x` <br>
* D. Add `forEach(System.out::print)` after the call to `collect()` <br>
* E. Wrap the entire line in a `System.out.print` statement <br>
* F. None of the above. The code already prints "12345" <br>

### My Answer:
 * The joining needs a parameter of ""
 * We need C
 * We need to convert the number to a string so we need B
 * We need E
 * **B,C,E**✅✅✅✅
<hr>


## 🟧 Question 12:

❓What functional interfaces complete the following code? (Choose all that apply)❓

```java
6: ______ x = String::new; 
7: ______ y = (a,b) -> System.out.println();
8: ______ z = a -> a+a;
```

* A. `BiConsumer<String, String>` <br>
* B. `BiFunction<String, String>` <br>
* C. `BinaryConsumer<String, String>` <br>
* D. `BinaryFunction<String, String>` <br>
* E. `Consumer<String>` <br>
* F. `Supplier<String>` <br>
* G. `UnaryOperator<String>` <br>
* H. `UnaryOperator<String, String>`  <br>

### My Answer:
* x is a supplier so F is true
* y is a consumer with 2 arguments applied, so A
* z is a Function or UnaryOperator, so its H
* **A,F,H**❌❌❌❌
* UnaryOperator does not have 2 generic types!!!
<hr>


## 🟧 Question 13

❓Which of the following is true❓

```java
List<Integer> l1 = Arrays.asList(1,2,3);
List<Integer> l2 = Arrays.asList(4,5,6);
List<Integer> l3 = Arrays.asList();
Stream.of(l1, l2, l3).map(x -> x+1)
    .flatMap(x -> x.stream()).forEach(System.out::println);
```

* A. The code compiles and prints `123456` <br>
* B. The code compiles and prints `234567` <br>
* C. The code compiles but does not print anything <br>
* D. The code compiles but prints stream references <br>
* E. The code runs infinitely <br>
* F. The code does not compile <br>
* G. The code throws an exception <br>

### My Answer:
* The map does not compile so F
* **F**✅✅✅✅
<hr>

## 🟧 Question 14: 

❓Which of the following is true❓

```java
4: Stream<Integer> s = Stream.of(1);
5: IntStream is = s.mapToInt(x -> x);
6: DoubleStream ds = is.mapToDouble(x -> x);
7: Stream<Iteger> s2 = ds.mapToInt(x -> x);
8: s2.forEach(System.out::print);
```
(The book has a typo!!!)

* A. Line 4 does not compile <br>
* B. Line 5 does not compile <br>
* C. Line 6 does not compile <br>
* D. Line 7 does not compile <br>
* E. Line 8 does not compile <br>
* F. The code throws an exception <br>
* G. The code compiles and prints 1. <br>

### My Answer:
* Line 7 does not compile
* **D**✅✅✅✅
<hr>

## 🟧 Question 15 

❓The `partitioningBy()` collector creates a `Map<Boolean, List<String>>` when passed to `collect()` by default. When specific parameters are passed to `partioningBy()`, which return types can be created? (Choose all that apply)❓

* A. `Map<boolean, List<String>>` <br>
* B. `Map<Boolean, Map<String>>` <br>
* C. `Map<Long, TreeSet<String>>` <br>
* D. `Map<Boolean, List<String>>` <br>
* E. `Map<Boolean, Set<String>>` <br>
* F. None of the above <br>

### My Answer:
* Only D and E look right
* **D,E**✅✅✅✅
<hr>

## 🟧 Question 16 

❓What is the output of the following❓

```java
Stream<String> s = Stream.empty();
Stream<String> s2 = Stream.empty();
Map<Boolean, List<String>> p = s.collect(
    Collectors.partitionBy(b -> b.startsWith("c")));
Map<Boolean, List<String>> g = s.collect(
    Collectors.groupBy(b -> b.startsWith("c")));
System.out.println(p + " " + g);
```

* A. `{} {}`
* B. `{} {false=[], true=[]}`
* C. `{false=[], true=[]} {}`
* D. `{false=[], true=[]} {false=[], true=[]}`
* E. The code does not compile
* F. An exception is thrown

### My Answer:
* **C**✅✅✅✅
<hr>

## 🟧 Question 17

❓Which of the following is equivalent to this code❓

```java
UnaryOperator<Integer> u = x -> x * x;
```

* A. `BiFunction<Integer> f = x -> x*x;`
* B. `BiFunction<Integer, Integer> f = x -> x*x;`
* C. `BinaryOperator<Interger, Integer> f = x -> x*x;`
* D. `Function<Integer> f = x -> x*x;`
* E. `Function<Integer, Integer> f = x -> x*x;`
* F. None of these above

### My Answer:
* **E**✅✅✅✅
<hr>

## 🟧 Question 18

❓What is the result of the following❓

```java
DoubleStream s = DoubleStream.of(1.2, 2.4);
s.peek(System.out.::println).filter(x -> x > 2).count();
```

* A. 1
* B. 2
* C. 2.4
* D. 1.2 and 2.4
* E. There is no output
* F. The code does not compile
* G. An exception is thrown

### My Answer:
* 1.2 and 2.4 will come through
* **D**✅✅✅✅
<hr>

## 🟧 Question 19

❓Which of the following return primitives❓

* A. `BooleanSupplier`
* B. `CharSupplier`
* C. `DoubleSupplier`
* D. `FloatSupplier`
* E. `IntSupplier`
* F. `StringSupplier`

### My Answer:
* **A,C,E**✅✅✅✅
<hr>

## 🟧 Question 20

❓What is the simplest way of rewriting this code❓

```java
List<Integer> l = IntStream.range(1,6)
    .mapToObj(i -> i).collect(Collectors.toList());
l.forEach(System.out::println);
```

* A. 
```java
IntStream.range(1,6);
```
* B. 
```java
IntStream.range(1,6)
    .forEach(System.out::println);`
```
* C. 
```java
IntStream.range(1,6)
    .mapToObj(i->i)
    .forEach(System.out::println);
```
* D. None of the above is equivalent
* E. The provided code does not compile

### My Answer:
* The range is not closed so A and B are false
* C is correct
* **C**❌❌❌❌
* I misread the question, B is the simplest!
<hr>