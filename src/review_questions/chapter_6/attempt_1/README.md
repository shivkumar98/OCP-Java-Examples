<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 6: Review Questions - Attempt 1

## Results:

Date: 27/09/2023
Score: 
✅  ❌ 
| Question # | Correct |
| ---------- | ------- |
| 1          |       |
| 2          |       |
| 3          |       |
| 4          |       |
| 5          |       |
| 6          |       |
| 7          |       |
| 8          |       |
| 9          |       |
| 10         |       |
| 11         |       |
| 12         |       |
| 13         |       |
| 14         |       |
| 15         |       |
| 16         |       |
| 17         |       |
| 18         |       |
| 19         |       |
| 20         |       |


<hr>

## Question 1
❓ Which of the following pairs fills in the blanks to make this code compile❓

```java
5: public void read() _________ SQLException {
6:     ________ new SQLException();
7: }
```

A. throw on line 5 and throw on line 6 <br>
B. throw on line 5 and throws on line 6 <br>
C. throws on line 5 and throw on line 6 <br>
D. throws on line 5 and throws on line 6 <br>
E. None of the above. SQLException is a checked exception and cannot be thrown <br>
F. None of the above. SQLException is a runtime exception and cannot be thrown <br>
❓

### My answer:
* **C**

<hr>

## Question 2:

❓ Which of the following changes when made independently would make this code compile (choose all that apply)

```java
1 : public class StuckTurkeyCage implements AutoCloseable {
2 :     public void close() throws Exception {
3 :         throw new Exception("Cage door does not close");
4 :     }
5 :     public static void main(String[] args) {
6 :         try (StuckTurkeyCage t = new StuckTurkeyCage()) {
7 :             System.out.println("put turkeys in");
8 :         }
9 :     }
10: }
```
A. Remove throws Exception from the declaration on line 2 <br>
B. Add throws Exception to the declaration on line 5 <br>
C. Change line 8 to } catch (Exception e) {} <br>
D. Change line 8 to } finally {} <br>
E. None of the above will make the code compile <br>
F. The code already compiles as is <br>
❓

### My answer:
* The code does NOT compile as is!
* We need to catch the checled exception!
* **B, C**
<hr>

## Question 3
❓ Which of the following fills in the blank to make the code compile? (Choose all that apply)

```java
public static void main(String[] args) {
    try {
        throw new IOException();
    } catch (___________________) { }
}
```

A. `FileNotFoundException | IOException e` <br>
B. `FileNotFoundException e | IOException e` <br>
C. `FileNotFoundException | RuntimeException e` <br>
D. `FileNotFoundException e | RuntimeException e` <br>
E. `IOException | RuntimeException e` <br>
F. `IOException e | RuntimeException e` <br>
❓

### My answer:
* A - false, FileNotFoundException is a IOException
* B - false, invalid syntax
* C - true
* D - false, invalid syntax
* E - true
* F - false, invalid syntax
* **C,E**
<hr>

## Question 4:
❓Which of the following are true statements (choose all that apply)

A. A traditional `try` statement without a catch block requires a finally block <br>
B. A traditional `try` statement without a finally block requires a catch block <br>
C. A traditional `try` statement with only one state with only one statement can omit {} <br>
D. A try-with-resources statement without a catch block requires a finally block <br>
E. A try-with-resources statement without a finally block requires a catch block <br>
F. A try-with-resources statement with only one statement can omit the {}

### My answer:
* A - true
* B - true
* C - I don't THINK so
* D - true
* E - false
* F - I don't THINK so
<hr>


## Question 5
❓ What is the output of the following code?
```java
import java.io.*;
public class AutocloseableFlow {
    static class Door implements AutoCloseable {
        public void close() {
            System.out.println("D");
        }
    }
    static class Window implements Closeable {
        public void close() {
            System.out.println("W");
            throw new RuntimeException();
        }
    }
    public static void main(String[] args) {
        try (Door d = new Door(); Window w = new Window()) {
            System.out.print("T");
        } catch (Exception e) {
            System.out.print("E");
        } finally {
            System.out.print("F");
        } } }
```

A. `TWF` <br>
B. `TWDF`<br>
C. `TWDEF` <br>
D. `TWF` followed by an exception <br>
E. `TWDF` followed by an exception <br>
F. `TWEF` followed by an exception <br>
G. The code does not compile <br>
❓

### My answer:
* The code DOES compile
* TWDEF is printed
* **C**
<hr>

## Question 6
❓ What is the output of the following code?
```java
import java.io.*;
public class AutocloseableFlow {
    static class Door implements AutoCloseable {
        public void close() {
            System.out.println("D");
        }
    }
    static class Window implements Closeable {
        public void close() {
            System.out.println("W");
            throw new RuntimeException();
        }
    }
    public static void main(String[] args) {
        try {
            Door d = new Door(); Window w = new Window()
        }
        {
            System.out.print("T");
        } catch (Exception e) {
            System.out.print("E");
        } finally {
            System.out.print("F");
        } } }
```

A. `TWF` <br>
B. `TWDF`<br>
C. `TWDEF` <br>
D. `TWF` followed by an exception <br>
E. `TWDF` followed by an exception <br>
F. `TWEF` followed by an exception <br>
G. The code does not compile <br>
❓

### My answer:
* Code does not compile due to missing semi-colon:
* **G**
<hr>

## Question 7
❓ What is the result of running `java EchoInput hi there` with the following code?
```java
public class EchoInput {
    public static void main(String [] args) {
        id(args.length <= 3) assert false;
        System.out.println(args[0] + args[1] + args[2]);
    }
}
```

A. `hithere` <br>
B. The `assert` statement throws an AssertionError <br>
C. The code throws an `ArrayIndexOutOfBoundsException` <br>
D. The code compiles and runs successfully, but there is not output <br>
E. The code does not compile <br>

### My answer:
* The command does not enable the assertions, so no assertion exception is thrown
* Therefore it prints nothing an ArrayIndexOutOfBoundsException is thrown
* **C**
<hr>

## Question 8:
❓Which of the following command lines cause this program to fail on the assertion (Choose all that apply)
```java
public class On {
    public static void main(String[] args) {
        String s = null;
        assert s != null;
    }
}
``` 
A. `java -da On` <br>
B. `java -ea On` <br>
C. `java -da -ea:On On` <br>
D. `java -ea -da:On on` <br>
E. The code does not compile <br>

### My answer:
* The code DOES compile
* **B**
<hr>

## Question 9
❓Which of the following prints `OhNo` with the assertion failure when the number is negative? (Choose all that apply)

A. `assert n < 0: "OhNo2";` <br>
B. `assert n < 0; "OhNo";` <br>
C. `assert n < 0 ("OhNo");` <br>
D. `assert(n < 0): "OhNo";` <br>
E. `assert(n < 0, "OhNo");` <br>

### My answer:
* A - valid
* D - valid
* **A, D**
<hr>

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

### My answer:

<hr>

## Question 11
❓What is the output of the following code?
```java
LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
Period p = Period.ofMonths(1).ofYears(2);
d = d.minus(p);
DateTimeFormatter f = DateTimeFormatter.
    ofLocalizedDateTime(FormatStyle.SHORT);
System.out.println(d.format(f));
```
    A. `5/9/13 11:22 AM`
    B. `5/10/13 11:22 AM`
    C. `5/9/14`
    D. `5/10/14 11:22 AM`
    E. The code does not compile.
    F. A runtime exception is thrown.

### My answer:

<hr>

## Question 12:

❓Which of the answer choices is true given the following code (choose all that apply)
```console
2016-08-28T05:00 GMT-4:00
2016-08-28T09:00 GMT-6:00
```
A. The first date/time is earlier
B. The second date/time is earlier
C. Both date/times are the same
D. The date/times are 2 hours apart
E. The date/times are 6 hours apart

### My answer:

<hr>

## Question 13
❓Note that March 13, 2016, is the weekend that clocks spring ahead for daylight savings time. What is the output of the following?
```java
LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
LocalTime time = LocalTime.of(1, 30);
ZoneId zone = ZoneId.of("US/Eastern");
ZonedDateTime dateTime1 = ZonedDateTime.of(date, time, zone)
ZonedDateTime dateTime2 = dateTime1.plus(1, ChronoUnits.HOURS);

long hours = ChronoUnits.HOURS.between(dateTime1, dateTime2);
int clock1 = dateTime1.getHours();
int clock2 = dateTime2.getHours();
System.out.println(hours, "," + clock1 + clock2);
```
    A. 1,1,2
    B. 1,1,3
    C. 2,1,2
    D. 2,1,3
    E. The code does not compile
    F. A runtime exception is thrown

### My answer:

<hr>

## Question 14:
❓Note that March 13, 2016, is the weekend that we spring forward, and November 6, 2016, is when we fall back for daylight savings time. Which of the following can be inserted in the blank without the code throwing an exception?

```java
ZoneId zone = ZoneId.of("US/Eastern");
LocalDate date = _____________________;
LocalTime time1 = LocalTime.of(2, 15);
ZonedDateTime a = ZonedDateTime.of(date, time1, zone);
```

A. LocalDate.of(2016, 3, 13);
B. LocalDate.of(2016, 3, 40);
C. LocalDate.of(2016, 11, 6);
D. LocalDate.of(2016, 11, 7);
E. LocalDate.of(2017, 2, 29);

### My answer:

<hr>

## Question 15
❓Given the following code, which of the answer choices can fill in the blank to print true (choose all that apply)?
```java
String m1 = Duration.of(1, ChronoUnit.MINUTES).toString();
String m2 = Duration.ofMinutes(1).toString();
String s = Duration.of(60, ChronoUnit.SECONDS).toString();

String d = Duration.ofDays(1).toString();
String p = Period.ofDays(1).toString();
```
    A. m1 == m2
    B. m1.equals(m2)
    C. m1.equals(s)
    D. d == p
    E. d.equals(p)

### My answer:

<hr>

## Question 16
❓Given the following, which answers can correctly fill in the blank? (Choose all that apply)
```java
LocalDate date = LocalDate.now();
LocalTime time = LocalTime.now();
LocalDateTime dateTime = LocalDateTime.now();
ZoneId zoneId = ZoneId.systemDefault();
ZonedDateTime zonedDateTime - ZonedDateTime.of(dateTime, zoneId);
long epochSeconds = 0;
Instant instant = ___________________;
```
    A. `Instant.now()`
    B. `Instant.ofEpcochSecond(epochSeconds)`
    C. `date.toInstant()`
    D. `dateTime.toInstant()`
    E. `time.toInstant()`
    F. `zonedDateTime.toInstant()`

### My answer:

<hr>

## Question 17
❓What is the output of the following method if props contains `{veggies=brontosaurus, meat=velociraptor}`
```java
private static void print(Properties props) {
    System.out.println(props.get("veggies", "none")
        + " " + props.get("omini", "none"));
}
```
    A. `brontosaurus none`
    B. `brontosaurus null`
    C. `none none`
    D. `none null`
    E. The codes not compile
    F. A runtime exception is thrown

### My answer:

<hr>

## Question 18
❓Which of the following prints our all of the values in props?
A. 
```java
props.keys().stream().map(k -> k.forEach(System.out::println))
```
B. 
```java
props.keys().stream().map(k -> props.get(k))
    .forEach(System.out::println);
```
C. 
```java
props.keySet().stream().map(k -> k)
    .forEach(System.out::println);
```
D.
```java
props.keySet().stream().map(k -> props.get(k))
    .forEach(System.out::println);
```
E.
```java
props.stream().map(k -> k) .forEach(System.out::println);
```
F.
```java
props.stream().map(k -> k) .forEach(System.out::println);
```

### My answer:

<hr>

## Question 19
❓ Which of the following are stored in a Period object (Choose all that apply)
    A. Year
    B. Month
    C. Day
    D. Hour
    E. Minute
    F. Second

### My answer:

<hr>

## Question 20
❓Which of the following objects could contain the information "eastern standard time"? (Choose all that apply)
    A. Instant
    B. LocalDate
    C. LocalDateTijme
    D. LocalTime
    E. ZonedDateTime

### My answer:

<hr>