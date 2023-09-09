<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 5.3 Adding Internationalization and Localization

## 🔴 Introduction

* Consider to the senteence "There is an event on animal behaviors on 4/1/15"
* In USA, the spelling is correct and the date would be interpreted as 1st April 2015
* In UK, the spelling is off and the date would be interpreted as 4th January 2015

* ***Internationalization*** is the process of designing your program so it can be adapted. This can involve placing strings in a properties file and using `DateFormat` so correct format is being used.

* ***Localization*** means actually supporting multiple locales (a specific geographical, cultural or political region). It can be thought of as a language and country pairing.

## 🔴 5.3.1 Picking a Locale


* The `Locale` class is in `java.util`
* You can get the users Locale by printing `Locale.getDefault()`:
```java
Locale locale = Locale.getDefault();
System.out.println(locale); // en_GB		
```
* Running this code in USA would print `en_US`!
* The country code is optional for the Locale. E.g. `fr`

<br>

* You can also get the Locale of other countries. E.g. we can print the Locale of German and Germnay:
```java
Locale.GERMAN; // de
Locale.GERMANY; // de-DE
```

* We can create our own Locale using these two constructors:
```java
new Locale("hi"); // hi
new Locale("hi", "IN"); // hi_IN
```

* We can also create a Locale using the Builder pattern:
```java
Locale customLocale = new Locale.Builder()
      .setRegion("UK")
      .setLanguage("en")
      .build();
customLocale; // en_UK
```

* We can also override the default Locale within the scope of the Java program:
```java
Locale locale = new Locale("en_RA");
Locale.setDefault(locale);
```


## 🔴 H2

### 🟡 H3


<br>
<hr>
