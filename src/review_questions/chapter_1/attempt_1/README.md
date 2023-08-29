# Chapter 2 - Review Questions Attempt 1

## Results:

Date: 
Score: /20

| Question # | Correct  |
| ---------- | -------  |
| 1          |       |
| 2          |       |
| 3          |       |
| 4          |       |
| 5          |       |
| 6          |       |
| 7          |       |
| 8          |       |
| 9          |       |
| 10         |       |
| 11         |       |
| 12         |       |
| 13         |       |
| 14         |       |
| 15         |       |
| 16         |       |
| 17         |       |
| 18         |       |
| 19         |       |
| 20         |      |

## Question 1

❓What is the result of the following code❓

```java
public class Employee {
    public int employeeId;
    public String firstName, lastName;
    public int yearStarted;
    @Override public int hashCode() {
        return employeeId;
    }
    public boolean equals(Employee e) {
        return this.employeeId = e.employeeId;
    }
    public static void main() {
        Employee one = new Employee();
        one.employeeId = 101;
        Employee two = new Employee();
        two.employeeId = 101;
        if (one.equals(two)) System.out.println("Success")
        else System.out.println("Failure");
    }

}
```

    A. Success🎃
    B. Failure🎃
    C. The hashCode() method fails to compile🎃
    D. The equals() method fails to compiler🎃
    E. Another line fails to compile🎃
    F. A runtime exception is thrown🎃

### My Answer:
*  I THINK it will return failure as it doesn't override the correct method in Object class
* **B**

<hr>



## Question 2
❓What is the result of the following code❓

```java
public class Book {
    private int ISBN;
    private String title, author;
    private int pageCount;
    public int hashCode() {
        return ISBN;
    }
    @Override public boolean equals(Object obj) {
        if (!(obj instanceof Book)){
            return false;
        }
        Book other = (Book) obj;
        return this.ISBN == obj.ISBN;
    }
    // imagine setters and getters
}
```

    A. The code compiles🎃
    B. The code does not compile because hashCode() is incorrect🎃
    C. The code does not compile because equals() does not override the parent method correctly🎃
    D. The code does not compile because equals() tries to refer to a private field🎃
    E. The code does not compile because the ClassCastException is not handled or declared🎃
    F. The code does not compile for another reason🎃

### My Answer:

* A - IDK
* B - false, the hashCode method is fine
* C - false, the class DOES override the right method
* D - false, you CAN access private fields
* E - false, casting is fine!
* F - I can't see why this won't compile

<hr>

## Question 3

❓What is the result of the following code❓

```java
String s1 = "Canada";
String s2 = new String(s1);
if (s1 == s2) System.out.println("s1 == s2");
if (s1.equals(s2)) System.out.println("s1.equals(s2)");
```

    A. There is no output 🎃
    B. s1 == s2 🎃
    C. s1.equals(s2) 🎃
    D. Both B and C🎃
    E. The code does not compile🎃
    F. The code throws a runtime exception🎃

### My Answer:

* s1 == s2 is false as we have instantiate a brand new string but the second if statement returns true
* **C**

<hr>

## Question 4
❓What is true about the following code❓

```java
public class BaseballTeam {
    private String city, mascot;
    private int numberOfPlayers;
    public boolean equals(Object obj) {
        if (!(obj instanceof BaseballTeam))
            return false;
        BaseballTeam other = (BaseballTeam) obj;
        return (city.equals(other.city) && mascot.equals(other.mascot));
    }
    public int hashCode() {
        return numberOfPlayers;
    }
    // imagine setters and getters
}
```

    A. The class does not compile🎃
    B. The class compiles but has an improper equals() method🎃
    C. The class compiles but has an improper hashCode() method🎃
    D. The class compiles but has proper equals() and hashCode() methods🎃

### My Answer:
* The code DOES compile but the hashCode implementation is improper!
* **C**

<hr>


## Question 5

❓Which of the following statements are true, assuming `a` and `b` are String objects?❓

    A. if a.equals(b) is true, a.hashCode() == b.hashCode() is always true 🎃
    B. if a.equals(b) is true, a.hashCode() == b.hashCode() is sometimes but not always true🎃
    C. if a.equals(b) is false, a.hashCode() == b.hashCode() can never be true🎃
    D. if a.equals(b) is false, a.hashCode() == b.hashCode() can sometimes be true🎃
 
### My Answer:

* **B,D**

<hr>

## Question 6

❓What is the result of the following code❓

```java
public class FlavorsEnum {
    enum Flavors {
        VANILLA, CHOCOLATE, STRAWBERRY
    }
    public static void main() {
        System.out.println(Flavors.CHOCOLATE.ordinal());
    }
}
```

    A. 0 🎃
    B. 1 🎃
    C. 9 🎃
    D. CHOCOLATE 🎃
    E. The code does not compile due to a missing semi-colon🎃
    F. The code does not compile for a different reason 🎃

### My Answer:

* **B**

<hr>

## Question 7

❓What is the result of the following code❓

```java
public class IceCream {
    enum Flavors {
        VANILLA, CHOCOLATE, STRAWBERRY
    }
    public static void main() {
        Flavors f = Flavors.STRAWBERRY;
        switch (f) {
            case 0: System.out.println("vanilla");
            case 1: System.out.println("chocolate");
            case 2: System.out.println("strawberry");
                break;
            default: System.out.println("missing flavor");
        }
    }
}
```

    A. vanilla 🎃
    B. chocolate 🎃
    C. strawberry 🎃
    D. missing flavor 🎃
    E. The code does not compile 🎃
    F. An exception is thrown 🎃

### My Answer:

* The code does not compile!
* **E**

<hr>

## Question 8

❓What is the result of the following code?❓

```java
1:  public class Outer {
2:      private int x =5;
3:      protected class Inner {
4:          public static int x = 10;
5:          public void go() { System.out.println(x); }
6:      }
7:      public static void main(String[] args) {
8:          Outer out = new Outer();
9:          Outer.Inner in = out.new Inner();
10:          in.go();
11:      }
12:  }
```

    A. The output is 5. 🎃
    B. The output is 10. 🎃
    C. Line 4 generates a compiler error. 🎃
    D. Line 8 generates a compiler error. 🎃
    E. Line 9 generates a compiler error. 🎃
    F. An exception is thrown. 🎃

### My Answer:
* **B**

<hr>

## Question 9

❓What is the result of the following code?❓

```java
1:  public class Outer {
2:      private int x = 24;
3:      public int getX() {
4:          String message = "x is ";
5:          class Inner {
6:              private int x = Outer.this.x;
7:              public void printX() {
8:                  System.out.println(message + x);
9:              }
10:         }
11:         Inner in = new Inner();
12:         in.printX();
13:         return x;
14:     }
15:     public static void main(String[] args) {
16:         new Outer.getX();
17:     }}
```
    A. x is 10 🎃
    B. x is 24 🎃
    C. Line 6 generates a compiler error🎃
    D. Line 8 generates a compiler error🎃
    E. Line 11 generates a compiler error🎃
    F. An exception is thrown🎃

### My Answer:
* **B**

<hr>


## Question 10

❓The following code appears in the file named `Book.java`. What is the result of compiling the source file❓

```java
1: public class Book {
2:     private int pageNumber;
3:     private class BookReader {
4:         public int getPage() {
5:             return pageNumber;
6: } } }
```

    A. The code compiles successfully, and one bytecode file is generated: `Book.class` 🎃
    B. The code compiles successfully, and two bytecode files are generated: `Book.class` and `BookReader.class` 🎃
    C. The code compiles successfully, and two bytecode files are generated: `Book.class` and `Book$BookReader.class` 🎃
    D. A compiler error occurs on line 3 🎃
    E. A compiler error occurs on line 5 🎃
    
### My Answer:
* A - false
* B - false
* C - true
* **C**

<hr>

## Question 11

❓Which of the following statements can be inserted to make `FootballGame` compile?❓

```java
package my.sports;
public class Football {
    public static final int TEAM_SIZE = 11;
}
package my.apps;
// INSERT CODE HERE
public class FootballGame {
    public int getTeamSize() { return TEAM_SIZE; }
}
```

### My Answer:


<hr>



## Question 12

❓What is the result of the following code❓


    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 13

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 14

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 15

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 16

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 17

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 18

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 19

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 20

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>