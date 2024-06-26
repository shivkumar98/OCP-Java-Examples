<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 5: Review Questions - Attempt 4

* Date: 30/06/2024
* Score: 11/20 (55%)

| Question # | Correct |
| ---------- | ------- |
| 1          |  ❌       |
| 2          |  ✅       |
| 3          |  ❌       |
| 4          |  ❌       |
| 5          |  ❌       |
| 6          |  ✅       |
| 7          |  ❌       |
| 8          |  ✅       |
| 9          |  ❌       |
| 10         |  ❌       |
| 11         |  ❌       |
| 12         |  ✅       |
| 13         |  ✅       |
| 14         |  ✅       |
| 15         |  ✅       |
| 16         |  ✅       |
| 17         |  ❌       |
| 18         |  ✅       |
| 19         |  ✅       |
| 20         |  ✅       |


<hr>

## Question 1
❓ Which of the following create valid locales, assuming that the language and country codes follow standard conventions (Choose all that apply) ❓

* A. `new Locale("hi")`
* B. `new Locale("hi, "IN")`
* C. `new Locale("IN")`
* D. `new Locale("IN", "hi")`
* E. `Locale.create("hi")`
* F. `Locale.create("IN")`
❓

<hr>

### My answer:
* A - false
* B - true
* C - false
* D - false
* E - false
* F - false
* **B**❌❌❌❌
* **CORRECT ANSWER: A,B**
* A is also valid, it defines a locale with language of hindi

## Question 2:

❓ Which of the following are common types to localize (Choose all that apply)
* A. Booleans
* B. Class names
* C. Currency
* D. Dates
* E. Numbers
* F. Variable names
❓

### My answer:
* A - false, B - false, C - true, D true, E true, F false
* **C,D,E**✅✅✅✅
<hr>

## Question 3

❓Which of the following are true (Choose all that apply)
* A. All keys must be in the same resource bundle file to be used
* B. All resource bundles are defined as Java classes can be expressed using the property file format instead
* C. All resource bundles defined as prpperty files can be expressed using the Java class list bundle format instead
* D. Changing the default locale lasts for only a single run of the program
* E. It is forbidden to have both Props_en.java and Props_en.properties in the class-path of an application
❓

### My answer:
* B - false
* C - true
* D - false
* E - false
* A - true
* **A,C**❌❌❌❌
* **CORRECT ANSWER: C,D**
* You can have multiple resource bundle files
* Changing default locale only lasts for one run because locale is only changed in memory
<hr>

## Question 4:
❓Assume that all bundles mentioned in the answers exist and define the same keys. Which one will be used to find the key in line 8?
```java
6:  Locale.setDefault(new Locale("en", "US"));
7:  ResourceBundle b = ResourceBundle.getBundle("Dolphins");
8:  b.getString("name");
```
* A. `Dolphins.properties`
* B. `Dolphins_en.java`
* C. `Dolphins_en.properties`
* D. `Whales.properties`
* E. `Whales_en_US.properties`
* F. The code does not compile

### My answer:
* Total guess it's C
* **C**❌❌❌❌
* **CORRECT ANSWER: B**
* * Java will first look for `Dophin_en_US.java`, then `Dolphin_en_US.properties`, then `Dolphin_en.java`
* Sice `Dolphin_en.java` is present, it does not bother look for `Dolphin_en.properties`
<hr>

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

* A. `Dolphins.properties` and `Dolphins.properties`
* B. `Dolphins.properties` and `Dolphins_en.properties`
* C. `Dolphins_en.properties` and `Dolphins_en.properties`
* D. `Dolphins_fr.properties` and `Dolphins.properties`
* E. `Dolphins_fr.properties` and `Dolphins_en.properties`
* F. The code does not compile
❓

### My answer:
* **B**❌❌❌❌
*  Line 7 will use `Dolphins_fr.properties`
*  line 8 looks for name in `Dolphins_fr.properties`
*  line 9 tries to look for age but it is not present, so it uses `Dolphins.properties`
*  **CORRECT ANSWER: D**
<hr>

## Question 6:
❓Which of the following can fill in the blank to create a date of June 21, 2014 (Choose all that apply)❓
```java
import java.time.*;

public class StartOfSummer {
   public static void main(String[] args) {
      LocalDate date = _______________;
}}
```

* A. `new LocalDate(2014, 5, 21);`
* B. `new LocalDate(2014, 6, 21);`
* C. `LocalDate.of(2014, 5, 21);`
* D. `LocalDate.of(2014, 6, 21);`
* E. `LocaleDate.of(2014, Calendar.JUNE, 21);`
* F. `LocaleDate.of(2014, Month.JUNE, 21);`

### My answer:
* A - false
* B - false
* C - false
* D - true
* E - false
* F - true
* **D,F** ✅✅✅✅
<hr>

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

* A. `2018 APRIL 4`
* B. `2018 APRIL 30`
* C. `2018 MAY 2`
* D. The code does not compile
* E. A runtime exception is thrown

### My answer:
* **B**❌❌❌❌
* **CORRECT ANSWER: D**
* The LocalDate class does not have a `plusHours()` method
* If the plusHours method was not present, it would print B
<hr>

## Question 8:
❓What is the output of the following code
```java
LocalDate date = LocalDate.of(2018, Month.APRIL, 40);
System.out.println(date.getYear() + " " + date.getMonth()
    + " " + date.getDayOfMonth());
```
* A. `2018 APRIL 4`
* B. `2018 APRIL 30`
* C. `2018 MAY 10`
* D. Another date
* E. The code does not compile
* F. A runtime exception is thrown

### My answer:
* **F**✅✅✅✅
<hr>

## Question 9
❓What is the output of the following code?
```java
LocalDate date = LocalDate.of(2018, Month.APRIL, 30);
date.plusDays(2);
date.plusYears(3);
System.out.println(date.getYear() + " "
    + date.getMonth() + " " + date.getDayOfMonth());
```
* A. `2018 APRIL 2`
* B. `2018 APRIL 30`
* C. `2018 MAY 2`
* D. `2021 APRIL 2`
* E. `2021 APRIL 30`
* F. `2021 MAY 2`
* G. A runtime exception is thrown

### My answer:
* **G**❌❌❌❌❌
* **CORRECT ANSWER: B**
* I thought April only had 29 days
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
* A. `7/3/14 11:22 AM`
* B. `5/10/14 11:22 AM`
* C. `7/3/14`
* D. `5/10/15`
* E. `11:22 AM`
* F. The code does not compile
* G. A runtime exception is thrown

### My answer:
* p = 1 year 2 months 3 days
* d = 2015-05-10-11:22:33
* d.minus(p) = 2014-04-7 11:22:33
* Total guess its A
* **A**❌❌❌❌
* **CORRECT ANSWER: E**
* A would be correct if it was `DateTimeFormatter.ofLocalizedTime`
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
* A. `5/9/13 11:22 AM`
* B. `5/10/13 11:22 AM`
* C. `5/9/14`
* D. `5/10/14 11:22 AM`
* E. The code does not compile.
* F. A runtime exception is thrown.

### My answer:
* **A**❌❌❌❌
* **CORRECT ANSWER: B**
* Period methods cannot be chained, if attempted only the last method will apply
<hr>

## Question 12:

❓Which of the answer choices is true given the following code (choose all that apply)
```console
2016-08-28T05:00 GMT-4:00
2016-08-28T09:00 GMT-6:00
```
* A. The first date/time is earlier
* B. The second date/time is earlier
* C. Both date/times are the same
* D. The date/times are 2 hours apart
* E. The date/times are 6 hours apart

### My answer:
* A - true
* E - true
* **A,E**✅✅✅✅
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
* A. 1,1,2
* B. 1,1,3
* C. 2,1,2
* D. 2,1,3
* E. The code does not compile
* F. A runtime exception is thrown
<hr>

### My answer:
* hours is 1
* clock1 is 1
* clock2 is 3
* **B**✅✅✅✅
<hr>

## Question 14:
❓Note that March 13, 2016, is the weekend that we spring forward, and November 6, 2016, is when we fall back for daylight savings time. Which of the following can be inserted in the blank without the code throwing an exception?

```java
ZoneId zone = ZoneId.of("US/Eastern");
LocalDate date = _____________________;
LocalTime time1 = LocalTime.of(2, 15);
ZonedDateTime a = ZonedDateTime.of(date, time1, zone);
```

* A. LocalDate.of(2016, 3, 13);
* B. LocalDate.of(2016, 3, 40);
* C. LocalDate.of(2016, 11, 6);
* D. LocalDate.of(2016, 11, 7);
* E. LocalDate.of(2017, 2, 29);

### My answer:
* A - true
* B - false
* C - true
* D - true
* E - false
* **A,C,D**✅✅✅✅
<hr>

## Question 15
❓Given the following code, which of the answer choices can fill in the blank to print true (choose all that apply)?
```java
String m1 = Duration.of(1, ChronoUnit.MINUTES).toString();
String m2 = Duration.ofMinutes(1).toString();
String s = Duration.of(60, ChronoUnit.SECONDS).toString();

String d = Duration.ofDays(1).toString();
String p = Period.ofDays(1).toString();

System.out.println(_______);
```
* A. m1 == m2
* B. m1.equals(m2)
* C. m1.equals(s)
* D. d == p
* E. d.equals(p)

### My answer:
* A - false
* B - true
* C - true
* D - false
* E - false
* **B,C**✅✅✅✅
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
* A. `Instant.now()`
* B. `Instant.ofEpcochSecond(epochSeconds)`
* C. `date.toInstant()`
* D. `dateTime.toInstant()`
* E. `time.toInstant()`
* F. `zonedDateTime.toInstant()`

### My answer:
* A - true
* B - true
* C - false
* D - false
* E - false
* F - true
* **A,B,F**✅✅✅✅
<hr>

## Question 17
❓What is the output of the following method if props contains `{veggies=brontosaurus, meat=velociraptor}`
```java
private static void print(Properties props) {
   System.out.println(props.get("veggies", "none")
      + " " + props.get("omini", "none"));
}
```
* A. `brontosaurus none`
* B. `brontosaurus null`
* C. `none none`
* D. `none null`
* E. The codes not compile
* F. A runtime exception is thrown

### My answer:
* brontosaurus and none is printed
* **A**❌❌❌❌
* The Properties `get()` method does not have an overload!!!
* **CORRECT ANSWER: E**
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
* **D**✅✅✅✅
<hr>

## Question 19
❓ Which of the following are stored in a Period object (Choose all that apply)
* A. Year
* B. Month
* C. Day
* D. Hour
* E. Minute
* F. Second

### My answer:
* Year month days
* **A,B,C**✅✅✅✅
<hr>

## Question 20
❓Which of the following objects could contain the information "eastern standard time"? (Choose all that apply)
* A. Instant
* B. LocalDate
* C. LocalDateTijme
* D. LocalTime
* E. ZonedDateTime

### My answer:
* **E**✅✅✅✅
<hr>