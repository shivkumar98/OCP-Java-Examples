<link href="../../styles.css" rel="stylesheet"></link>

# 📝 Chapter 5: Revision Notes

# 🧠 5.1 Working with Dates and Times

## 🟥 Creating Dates and Times

* We have LocalTime, LocalDate, LocalDateTime and ZonedLocalDateTime.
* In order to understand ZonedLocalDateTime, we need to understand how to create the GMT equivalent of dates and times.
* To get the GMT equivalent, we must reverse the addition/subtraction of hours:

```java
2015-06-20T07:50+02:00[Europe/Paris] //  GMT 2015-06-20 5:50
2016-06-20T06:50+05:30[Asia/Kolkata] //  GMT 2015-06-20 1:20
2015–06–20T07:50 GMT-04:00           //  GMT 2015-06-20 11:50
```

* There are 3 overloads for creating `LocalTime`:
```java
LocalTime of(int hour, int minute);
LocalTime of(int hour, int minute, int second);
LocalTime of(int hour, int minute, int second, int nanos);
```
* There are 4 different overloads for creating `LocalDateTime`:
```java
LocalDateTime of(LocalDate date, LocalTime time);
LocalDateTime of(int year, int month, int day,
    int minute);
LocalDateTime of(int year, int month, int day,
    int minute, int second);
LocalDateTime of(int year, int month, int day,
    int minute, int second, int nanos);
```

* There are 3 ways of creating `ZonedDateTime`:

```java
ZonedDateTime of(LocalDate date, LocalTime time, ZoneId zone);
ZonedDateTime of(LocalDateTime dateTime, ZoneId zone);
ZonedDateTime of(int year, int month, int day,
    int hour, int minute, int second, int nanos, ZoneId zone);
```

<br>

## 🟥 Manipulating Dates and Times

* 2014-02-28 is the final day of the month for February. If it were a leap year then we would have 29th February
* Attempting to add 1 month from 2014-01-29 will rollover to the next month!
```java
// LocalDate invalidDate = LocalDate.of(2014, 2, 29);
// THROWS EXCEPTION
LocalDate date = LocalDate.of(2014, 1, 29);
LocalDate notALeapDay = date.plusMonths(1);
System.out.println(notALeapDay); // 2014-02-28
```

* You can manipulate dates and times:

```java
LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
LocalTime time = LocalTime.of(5, 15);
LocalDateTime dateTime = LocalDateTime.of(date, time);
// date.plusHours(1); // COMPILER ERROR
time.plusHours(1);
dateTime.plusHours(1);
date.plusDays(1);
dateTime.plusDays(1);
// time.plusDays(1); // COMPILER ERROR
```

* You can chain these methods:

```java
LocalDateTime = dateTime = LocalDateTime.of(date, time)
				.minusDays(1)
				.minusHours(10)
				.minusSeconds(30);
```

<br>

## 🟥 Working with Periods
* Periods have the following format: `P1Y2M3D`
* You can create Periods using the following methods:
```java
Period p = Period.of(1, 2, 3);
Period p1 = Period.ofYears(1)
Period p2 = Period.ofMonths(2)
Period p3 = Period.ofDays(1);
Period p4 = Period.ofWeeks(1);
```
* Chaining the methods doesn't work as expected, only the last chained period will apply:
```java
Period p = Period.ofYears(1).ofMonths(2).ofDays(1);
System.out.println(p); // P1D
```
* We can add Period to LocalDate and LocalDateTime:
```java
LocalDate date = LocalDate.of(2015, 1, 20);
LocalTime time = LocalTime.of(6, 15);
LocalDateTime dateTime = LocalDateTime.of(date, time);
dateTime.plus(Period.ofDays(1));
date.plus(Period.ofDays(1));
// time.plus(Period.ofDays(1)); // THROWS UnsupportedTemportalTypeException 
```

# 🧠 4.2 Working with Built-in Functional Interfaces

## 🟥 H2

### 🟡 H3
