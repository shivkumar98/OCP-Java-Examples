<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 5.2 Reviewing String Class

* The String class is final and String objects are immutable.

## 🔴 String Equality

* In order to see if two strings are equal in content, you must use `.equals()` rather than `==` which checks for reference equality.
* E.g.
```java
String s1 = "bunny";
String s2 = "bunny";
String s3 = new String("bunny");
s1 == s2; // true as string pool can reuse reference
s1 == s3; // false - using constructor creates new String in pool
s2 == s3; //false - same as above
```

## 🔴 String Concatenation
* String concatenation is achieved using `+` operator. The result creates a brand new String with the two strings concatenated.
```java
String s4 = "1" + 2 + 3; // 123
String s5 = 1 + 2 + "3"; // 33
```
* Here are some common String methods:
```java
String s = "abcde";
s.trim().length(); // 5
s.charAt(4); // e
s.indexOf('e'); // 4
s.indexOf("de"); // 3
s.substring(2,4).toUpperCase(); // CD
s.replace('a', '1'); // 1bcde
s.contains("DE"); // false
s.startsWith("a"); // true
```

## 🔴 StringBuilder
* StringBuilder is mutable, but not thread safe.
* StringBuffer is also mutable, slower but thread safe.
```java
StringBuilder b = new StringBuilder();
b.append(12345).append('-'); // 12345-
b.length();                  // 6
b.indexOf("-");              // 5
b.charAt(2);                 // 3
StringBuilder b2 = b.reverse(); 
b.toString(); // -54321
b == b2; // true
```
* The StringBuilder class does not override the equals() method. So we can only check for reference equality!

```java
StringBuilder s = StringBuilder("abcde");
s.insert(1, '-').delete(3,4) // a-bcde -> a-bde
s; // a-bde
s.substring(2,4); // bd
```