<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 5.1 Working with Dates and Times

## 🔴 5.1.1 Creating Dates and Time
* For the exam, I must have knowledge of timezones.
* The exam has four types for storing date/time objects:
1) LocalDate - just contains date, has no timezone
2) LocalTime - just contains time, has no timezone
3) LocalDateTime - contains date and time, has no timezone
4) ZonedDateTime - contains date, time and timezone



* Each of these have a `.now()` method. If I print each one on my machine I get:

```console
2023-09-03
10:39:14.375107700
2023-09-03T10:39:14.375107700
2023-09-03T10:39:14.375107700+1:00[Europe/London]
```

* The time is displayed as `hours:minutes:seconds.fractionalseconds`
* The `+1:00` is the difference from GMT



* We have a time standard UTC - Cordinated Universal Time. UTC uses the same time zone 0 as GMT.
* The exam will give the UTC offset.

### 🟡 Example: GMT equivalent time
1) `2015-06-20T07:50+2:00[Europe/Paris]`
- A: `2015-06-20 5:50`
2) `2015–06–20T06:50+05:30[Asia/Kolkata]`
- A: `2015-06-20 1:20`
3) `2015–06–20T07:50 GMT-04:00`
- A: `2015-06-20 11:50`
4) `2015–06–20T04:50 GMT-07:00`
- A: `2015-06-20 11:50`

### 🟡 Creating LocalDate, LocalTime and LocalDateTime

* We can create a LocalDate in two ways:
```java
LocalDate date1 = LocalDate.of(2023, Month.JANUARY, 1);
LocalDate date2 = LocalDate.of(2023, 1, 1);
```

* LocalTime can be created in 3 ways:
```java
LocalTime time1 = LocalTime.of(11, 0);
LocalTime time2 = LocalTime.of(11, 0, 59); // +seconds
LocalTime time3 = LocalTime.of(11, 0, 59, 200); // +nanos
```

* LocalDateTime Hasd 4 main ways of being created:
```java
LocalDateTime.of(LocalDate date, LocalTime time);
LocalDateTime.of(int yeat, int/Month month, int day, int hour, int minute);
LocalDateTime.of(int yeat, int/Month month, int day, int hour, int minute, int seconds); // +seconds
LocalDateTime.of(int yeat, int/Month month, int day, int hour, int minute, int seconds, int nanos); // +nanos
```

### 🟡 Creating ZonedDateTime
* In order to create a ZonedDateTime, we first need to get the desired time zone.
* E.g. to use US/Eastern:
```java
LocalDate date = LocalDate.of(2023, 3, 9);
LocalTime time = LocalTime.of(11, 58);
LocalDateTime dateTime = LocalDateTime.of(date, time);
ZoneId zone = ZoneId.of("US/Eastern");
ZonedDateTime zone1 = 
    ZonedDateTime.of(date, time, zone);
ZonedDateTime zone2 = 
    ZonedDateTime.of(dateTime, zone);
ZonedDateTime zone3 =
    ZonedDateTime.of(2023,9,3,12,1,0,0, zone);
```

* Note how Month can not be supplied!
* You can find your own timezone by printing: `ZoneId.systemDefault()`.

<br>
<hr>

## 🔴 5.1.2 Manipulating Dates and Times

* Dates and time classes are immutable.
* E.g.:
```java
LocalDate date = LocalDate.of(2023, Month.SEPTEMBER, 3);
date = date.plusDays(2);   // 2023-09-05
date = date.plusWeeks(1);  // 2023-09-12
date = date.plusMonths(1); // 2023-10-12
date = date.plusYears(5);  // 2028-10-12
```

* Here's some examples of going back in time:

```java
LocalDate date = LocalDate.of(2020, 1, 20);
LocalTime time = LocalTime.of(5, 15);
LocalDateTime dateTime = LocalDateTime.of(date, time); // 2020-01-20T05:15
dateTime = dateTime.minusDays(1);    // 2020-01-19T05:15
dateTime = dateTime.minusHours(10);  // 2020-01-18T19:15
dateTime = dateTime.minusSeconds(30);      // 2020-01-18T19:14:30
```

* We can also chain methods together:
```java
LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
LocalTime time = LocalTime.of(5, 15);
LocalDateTime dateTime = LocalDateTime.of(date, time)
  .minusDays(1)
  .minusHours(10)
  .minusSeconds(30);
System.out.println(dateTime); // 2020-01-18T19:14:30
```

* What does the following print❓
```java
LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
date.plusDays(10);
System.out.println(date);
```

* It will print 2020-01-20❗

* What is wrong with the following:❓
```java
LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
date = date.plusMinutes(1); // DOES NOT COMPILE
```

<br>
<hr>

## 🔴 5.1.3 Working with Periods

* Suppose we had some code which would give some print give toys each month:

```java
public static void main(String[] args) {
  LocalDate start = LocalDate.of(2023, Month.SEPTEMBER, 1);
  LocalDate end = LocalDate.of(2023, Month.NOVEMBER, 30);
  switchToys(start, end);
  // give new toy: 2023-09-01
  // give new toy: 2023-10-01
  // give new toy: 2023-11-01
}
private static void switchToys(LocalDate start, LocalDate end) {
  LocalDate upTo = start;
  while (upTo.isBefore(end)) {
    System.out.println("give new toy: "+upTo);
    upTo = upTo.plusMonths(1);
  }
}
```

### 🟡 Converting LocalDate and LocalDateTime to Long
* LocalDate and LocalDateTime can both be converted to a long equivalent which represents the date in days/seconds in relation to 01/01/1970
* LocalDate has a `toEpochDay()` method, and LocalDateTime has a `toEpochSecond()` method

```java
LocalDate date = LocalDate.of(2023,1,1);
date.toEpochDay(); // 19358
LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.of(0, 0));
dateTime.toEpochSecond(ZoneOffset.UTC); // 1672531200
dateTime.toEpochDay() // COMPILER ERROR
```