<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 5.3 Adding Internationalization and Localization

## 🔴 Introduction

* Consider to the senteence "There is an event on animal behaviors on 4/1/15"
* In USA, the spelling is correct and the date would be interpreted as 1st April 2015
* In UK, the spelling is off and the date would be interpreted as 4th January 2015

* ***Internationalization*** is the process of designing your program so it can be adapted. This can involve placing strings in a properties file and using `DateFormat` so correct format is being used.

* ***Localization*** means actually supporting multiple locales (a specific geographical, cultural or political region). It can be thought of as a language and country pairing.

<br>

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


<br>

## 🔴 5.3.2 Using a Resource Bundle
* A ***resource bundle*** contains the local specific object to be used by the program. This can be a properties file or Java class
* In order for localisation, we must externalise storing of Strings rather than being contained in the program.
- We can use a property file or resource bundle.


### 🟡 Property File Format
* Key-value properties can have the following syntaxes:
```properties
animal=rat
animal:rat
animat rat
```
* If line begins with `!` or `#` => it's a comment.
* Spaces between seperator characters are ignored.
* Spaces at end of a line are NOT ignored⚠️ (beginning ones are!)
* You can break a line for readability using `\`


<hr>

* Suppose we have a Zoo program which needs to support multuiiple locales at once. We create 4 Locales to support this:
```java
Locale us = new Locale("en", "US");
Locale france = new Locale("fr", "FR"):
Locale englishCananda = new Locale("en", "CA");
Locale frenchCanada = new Locale("fr", "CA");
```

<br><br>

### 🟡 Creating a Property File Resource Bundle

* We need an English and French property file resource bundle by creating two property files:
* `Zoo_en.properties`: 
```properties
hello=Hello
open=The zoo is open.
```
* `Zoo_fr.properties`:
```properties
hello=Bonjour
open=Le zoo est ouvert
```
* ⚠️These properties files must be in the classpath (i.e. root of src) in order for program to work!⚠️
* Here is the clas which uses the resource bundle:
```java
public class ZooOpen {
    public static void main(String[] args) {
      Locale us = new Locale("en", "US");
      Locale france = new Locale("fr", "FR");
      printProperties(us);
      System.out.println("----------");
      printProperties(france);
    }
    public static void printProperties(Locale locale) {
      ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
      System.out.println(rb.getString("hello"));
      System.out.println(rb.getString("open"));
    }
}
```
* The output is:
```console
Hello
The zoop is open.
----------
Bonjour
Le zoo est ouvert
```

#### 🍏 ResourceBundle Keyset

* The resource bundle is essentially a map so we can extract all the keys:
```java
ResourceBundle rb = ResourceBundle.getBundle("Zoo", us);
      Set<String> keys = rb.keySet();
      keys.stream().map(k -> k + " "+rb.getString(k))
            .forEach(System.out::println);
      // hello Hello
      // open The zoop is open.
```

#### 🍏 Properties Class
* Java has a class called `Properties` which is like a Map
* Properties enables us to specify a default value when calling `getProperty()`!
* We can **convert a ResourceBundle into a Properties instance**:
```java
Properties properties = new Properties();
rb.keySet().stream()
      .forEach(k -> properties.put(k, rb.getString(k)));
```
* Here's how we call a property with a fallback default value:
```java
properties.getProperty("someMadeUpKey"); // null is returned
properties.getProperty("someMadeUpKey", "default"); // "default" is returned!
```

<br><br>

### 🟡 Creating a Java Class Resource Bundle
* A property file resource bundle allows only String values.
* A Java class can allow any datatype, keys are still Strings regardless.
* In order to implement a resource bundle in Java, you create a class with the same name as a property file.
* Here's a property class with the same content as the properties file:
```java
public class ZooJava_en extends ListResourceBundle {
    protected Object[][] {
        return new Object[][] {
            {"hello","hello sir"},{"open", "zoo is open sir"}
        }
    }
}
```
* And here is a program which uses this as a resource bundle:
```java
public class ZooOpenUsingJava {
      public static void main(String[] args) {
            Locale locale = new Locale("en", "US");
            ResourceBundle rb = new ResourceBundle.getBundle("ZooJava");
            rb.keySet().stream()
                  .forEach(k -> Sytem.out.println(k+": "+rb.getString(k)));
            // hello: hello sir
            // open: zoo is open, sir
      }
}
```
* Using a Java based resource bundle means you can create values of the properties at runtime, as well as using any data type you wish😊
<hr>
