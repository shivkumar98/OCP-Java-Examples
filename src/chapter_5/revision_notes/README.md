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

### 🟡 Example:


# 🧠 4.2 Working with Built-in Functional Interfaces

## 🟥 H2

### 🟡 H3
