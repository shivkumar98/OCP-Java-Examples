<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 5.1 Working with Dates and Times

## 🔴 5.1.1 Creating Dates and Time
* For the exam, I must have knowledge of timezones.
* The exam has four types for storing date/time objects:
1) LocalDate - just contains date, has no timezone
2) LocalTime - just contains time, has no timezone
3) LocalDateTime - contains date and time, has no timezone
4) ZonedDateTime - contains date, time and timezone

<br>

* Each of these have a `.now()` method. If I print each one on my machine I get:

```console
2023-09-03
10:39:14.375107700
2023-09-03T10:39:14.375107700
2023-09-03T10:39:14.375107700+1:00[Europe/London]
```

* The time is displayed as `hours:minutes:seconds.fractionalseconds`
* The `+1:00` is the difference from GMT

<br>

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

<br>

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

<br>

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