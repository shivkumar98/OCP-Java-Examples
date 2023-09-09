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

### 🟡 Creating Periods
* The `Period` class has the following static methods:
```java
Period.ofYears(int years);
Period.ofMonths(int months);
Period.ofWeeks(int weeks);
Period.ofDays(int days);
Period.of(int years, int months, int days);
```

* You CAN supply negative arguments!

* ⚠️ You can not chain any of these methods, if you do only the last one will apply!

* The format of the Period will always be `P{years}Y{months}M{days}D` - if any are zero they are excluded!

```java
Period anually = Period.ofYears(1);
System.out.println(anually); // P1Y
Period quartly = Period.ofMonths(3);
System.out.println(quartly); // P3M
Period weekly = Period.ofWeeks(1);
System.out.println(weekly); // P7D
Period everyOtherDay = Period.ofDays(2);
System.out.println(everyOtherDay); // P2D

Period wrong = Period.ofYears(1).ofDays(1);
System.out.println(wrong); // P1D

Period correct = Period.of(1, 0, 1);
System.out.println(correct); // P1Y1D
```

* You CAN create periods in which one unit exceeds the next largest one and the printing will not do any conversion!

```java
Period period = Period.of(0, 44, 60);
System.out.println(period); // P44M60D
```

* Using Period, we can enable users to determine the length of time which should pass to give out the toys:

```java
public static void main() {
    switchToys(start, end, Period.ofMonths(1));
}
private static void switchToys(LocalDate start, LocalDate end, Period period) {
    LocalDate upTo = start;
    while (upTo.isBefore(end)) {
        System.out.println("give new toy: "+upTo);
        upTo =upTo.plus(period);
    }
}
```

<br>
<hr>

## 🔴 5.1.4 Working with Durations
* Periods are useful for creating anything for a day or more
* Duration lets you create smaller increments of time.

### 🟡 Creating Durations

* We can create a Duration using nanoS, milliS, seconds, minutes and hours:

```java
Duration nano = Duration.ofNanos(1);
System.out.println(nano); // PT0.000000001S
Duration milli = Duration.ofMillis(-1);
System.out.println(milli); // PT-0.001S
Duration second = Duration.ofSeconds(1);
System.out.println(second); // PT1S
Duration minute = Duration.ofMinutes(1);
System.out.println(minute); // PT1M
Duration hourly = Duration.ofHours(1);
System.out.println(hourly); // PT1H
```

* The `.ofSeconds()` method has an overload which lets you add/subtract nanos seconds. E.g. one nanosecond below a second would be:
```java
Duration.ofSeconds(1, -1); // PT0.000000001S
```

* The Duration class also has the following method:
```java
static Duration of(long amount, TemporalUnit unit);
```

* This method lets us create durations with far more flexibility. E.g. to create a duration of 1 nano second, we'd use:
```java
Duration.of(1, ChronoUnit.NANOS); //PT0.000000001S
```

<br>

### 🟡 ChronoUnit for Differences
* ChronoUnit is great to measure time between two temporal units (like LocalTime...)
* E.g.:
```java
LocalTime one = LocalTime.of(5,15);
LocalTime two = LocalTime.of(6,30);
System.out.println(ChronoUnit.HOURS.between(one, two)); // 1 - 15 mins is truncated!
System.out.println(ChronoUnit.MINUTES.between(one, two)); // 75
```
* ⚠️Trying to measure time between a LocalDate and LocalDateTime will give DateTimeException!⚠️

<br>

### 🟡 Manipulating Date and Time using Duration!
* Durations can be applied to `LocalDateTime` and `LocalTime` and NOT date!

```java
Duration duration = Duration.ofHours(6);
LocalDate date = LocalDate.of(2023, 9, 8);
// date.plus(duration); // throws exception

LocalTime time = LocalTime.of(23, 20);
System.out.println(time.plus(duration)); // 05:20

LocalDateTime dateTime = LocalDateTime.of(date, time);
System.out.println(dateTime.plus(duration)); // 2023-09-09T05:20
```

<br>

### 🟡 Working with Instants
* The `Instant` class captures a specific moment in time in the GMT time zone.
```java
Instant then = Instant.now();
someTimeConsumingCode();
Instant now = Instant.now();
System.out.println(Duration.between(then, now)); // PT4.677916S
```
* We can convert a ZonedDateTime into an instant:
```java
LocalDate date = LocalDate.of(2023,9,9);
ZoneId zone = ZoneId.of("Etc/UTC");
ZonedDateTime zonedDateTime = ZonedDateTime.of(date, LocalTime.now(), zone);
Instant instant = zonedDateTime.toInstant();
System.out.println(instant); // 2023-09-09T16:38:42.578524300Z
```

* You can not create an instant using `LocalDateTime` as it does NOT contain a time zone.
* An epoch does represent a specific moment in time so it can be convereted to an instant:
```java
Instant instant = Instant.ofEpochSecond(epochSeconds);
System.out.println(instant); // 2015-05-25T15:55:00Z
Instant nextHour = instant.plus(1, ChronoUnits.HOURS); // fine
Instant nextWeek = instant.plus(1, ChronoUnits.WEEKS); // throws exception!
```

<br>
<hr>

## 🔴 5.1.5 Accounting for Daylight Savings Time
* Some, not all, countries addjust the time twice a year to get more sun during the day.
* In USA, the clocks moves an hour forward in March, then move them back in November.
* The exam will inform you if a day falls on a clock change.


### 🟡 How Daylight Savings Works
* The clocks on a normal day proceed like so:
- `1:00 am-1:59 am` -> `2:00 am-3:00 am` -> `3:00 am-4:00 am`
* March change over:
- `1:00 am-1:59 am` -> `3:00 am-4:00 am`
* November change over:
- `1:00 am-1:59 am` (first time) -> `1:00am-1:59 am` (again) -> `2:00 am- 4:00 am`


### 🟡 Example 1
* On 2016-03-13, the clocks jump from 2am to 3am. Using ZonedDateTime we show the DLS coming into effect:
```java
LocalDate date = LocalDate.of(2016, 3, 13);
LocalTime time = LocalTime.of(1, 30);
ZoneId zoneId = ZoneId.of("US/Eastern");
ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zoneId);
System.out.println(zonedDateTime); // 2016-03-13T01:30-4:00[US/Eastern]
zonedDateTme.plusHours(1); // 2016-03-13T03:30-5:00[US/Eastern]
```

### 🟡 Example 2
* On 2016-11-06, the clocks jump 1 hour back at 2am to 1am:
```java
LocalDate date2 = LocalDate.of(2016, 11, 6);
LocalTime time2 = LocalTime.of(1, 30);
ZonedDateTime zonedDateTime2 = ZonedDateTime.of(date, time2, zoneId);
System.out.println(zonedTime2); // 2016-11-06T01:30-4:00[US/Eastern]
zonedDateTime2.plusMinutes(30); // 2016-11-06T01:00-5:00[US/Eastern]
zonedDateTime2.plusHours(1);    // 2016-11-06T01:30-5:00[US/Eastern]
```

### 🟡 Example 3
* Suppose we try to create a time which does not exist like 2am on 2016-03-13:
```java
// 2am does not exist:
ZonedDateTime dateTimeWhichDoesNotExist =
    ZonedDateTime.of(date, LocalTime.of(2, 0), zoneId);
System.out.println(dateTimeWhichDoesNotExist);
  // 2016-03-13T03:00-04:00[US/Eastern]		
```


<br>
<hr>

