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
* The Period units will not rollover, e.g. 12 months prints: `P12M`

<br>

## 🟥 Working with Durations
* A period is always atleast one day
* Duration offers smaller units of time.
* Duration has the following format: `PT1H2M3S`
* We can create a Duration through the following:
```java
Duration d = Duration.ofDays(1); // PT24H
Duration d1 = Duration.ofHours(24); // PT24H
Duration d2 = Duration.ofMinutes(1); // PT1M
Duration sixtySeconds = Duration.ofSeconds(60); // PT1M
Duration sixtyMins = Duration.ofMinutes(60); // PT1H
Duration d4 = Duration.ofMillis(1); // PT0.001S
Duration d5 = Duration.ofNanos(1); // PT0.000000001S
```
* Again you can NOT chain these methods
* You can also use `ChronoUnits` to generate a Duration
* You can add/subtract Durations to LocalDateTime and LocalTime instances:
```java
LocalDate date = LocalDate.of(2023, 9, 18);
LocalTime time = LocalTime.of(12, 15);
LocalDateTime dateTime = LocalDateTime.of(date, time);
Duration duration = Duration.ofHours(6);
date.plus(duration); // THROWS EXCEPTION
time.plus(duration); // 18:15
System.out.println(dateTime.plus(duration)); // 2023-09-18 18:15
```

### 🟡 Working with Instants
* An instant represents a specific moment in time in GMT timezone.
* You can generate an Instant in three ways:
```java
Instant now = Instant.now();
ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zoneId);
Instant usingZone = zonedDateTime.toInstant();
Instant usingEpochSeconds = Instant.ofEpochSecond(epochSecond);
```
* Instant lets you add/subtract temporal units of a day or smaller.
```java
Instant instant = Instant.now().plus(1, ChronoUnit.WEEKS); // THROWS EXCEPTION
```
<br>

## 🟥 Accounting for Daylight Savings Time
* In USA the times spring forward one hour in March and pulled back in November.
* In March, the times transition as:

    `1:00 am - 1:59 am` -> `3:00 am - 4:00 am`

* In November, the times transition as:

    `1:00 am - 1:59 am` -> `1:00 am - 1:59 am` -> `2:00 am - 4:00 am`

* We can see this in action in Java code:
```java
LocalDate date = LocalDate.of(2016, 3, 13);
LocalTime time = LocalTime.of(1, 30);
ZoneId zone = ZoneId.of("US/Eastern");
ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zone);
System.out.println(zonedDateTime); 
// 2016-03-13T01:30-05:00[US/Eastern]
System.out.println(zonedDateTime.plusHours(1));
// 2016-03-13T03:30-04:00[US/Eastern]

// trying to make a time which is not possible:
System.out.println(ZonedDateTime.of(date, time.plusHours(1), zone));
// 2016-03-13T03:30-04:00[US/Eastern]
// Java automatically rolls over
```

## 🟥 Accounting for Daylight Savings Time

* In USA the times spring forward one hour in March and pulled back in November.
* In March, the times transition as:

```java
LocalDate dateWhenHoursMoveBack = LocalDate.of(2016, Month.NOVEMBER, 6);
ZonedDateTime zonedDateTime2 = ZonedDateTime.of(dateWhenHoursMoveBack, time, zone);
System.out.println(zonedDateTime2); // 2016-11-06T01:30-04:00[US/Eastern]
System.out.println(zonedDateTime2.plusHours(1)); // 2016-11-06-01:30-05:00[US/Eastern]
```
<hr>

# 🧠 5.2 Reviewing String Class
* Here's some Java class which shows the equality behaviour of Strings:
```java
String s1 = "bunny";
String s2 = "bunny";
s1 == s2; // true 
s1.equals(s2); // true
String s3 = new String("bunny");
s1 == s3; // false
s2 == s3; // false
s1.equals(s3); // true
```
* StringBuilder is a mutable, non-thread safe version of String:
```java
StringBuilder sb1 = new StringBuilder("abc");
StringBuilder sb2 = sb1.reverse();
sb1 == sb2; // true
sb1.append("d");
sb1 == sb2; // true
```

<hr>

# 🧠 5.3 Adding Internationalization and Localization
## 🟥 Getting a Locale
* You can get the default Locale of the computer the application is running on:
```java
Locale locale = Locale.getDefault();
System.out.println(locale); // en_GB
```
* There are 3 ways of creating a Locale:
```java
// using a constant from Locale class:
Locale.GERMAN; // de
Locale.GERMANY; // de_DE
// using a constructor:
new Locale("fr"); // fr
new Locale("hi", "IN"); // hi_IN
// using builder:
Locale customLocale = new Locale.Builder()
    .setLanguage("en");
    .setRegion("US")
    .build();
```

# 🧠 H1

## 🟥 H2

### 🟡 H3
