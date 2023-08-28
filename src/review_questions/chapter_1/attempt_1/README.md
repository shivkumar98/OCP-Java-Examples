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

❓Which of the following are true of interfaces❓

    A. They can extend other classes 🎃
    B. They cannot be extended 🎃
    C. They enable classes tto have multiple inheritance🎃
    D. They can only contain abstract methods 🎃
    E. They can be decalared final🎃
    F. All members of an interface are public🎃

### My Answer:
* A - false, can only extend interfaces
* B - false, they can be extended by interfaces
* C - true
* D - false, can contain default methods
* E - false
* F - true
* **C, F**

<hr>

## Question 9

❓What changes are needed to make the following singleton pattern correct❓

```java
public class CheetahManager {
    public static CheetahManager cheetahManager;
    private CheetahManager() {}
    public static CheetahManager getCheetahManager() {
        if (cheetahManager == null) {
            cheetahManager = new CheetahManager();
        }
        return cheetahManager;
    }
}
```

    A. None; the singleton pattern is properly implemented🎃
    B. Rename cheetahManager to instance🎃
    C. Rename getCheetahManager() to getInstance()🎃
    D. Change the access modifier of cheetahManager from public to private🎃
    E. Mark cheetahManager `final`🎃
    F. Add synchronized to getCheetahManager()🎃

### My Answer:
* A - false, we need synchronized to ensure threads access a single instance
* B - false, not necessary
* C - false, not necessary
* D - false
* E - false, can not be done
* F - true
* **F**

### My Answer:

<hr>


## Question 10

❓What is the result of the following code❓

```java
1: public interface CanWalk {
2:     default void walk() { System.out.println("Walking"); }
3: }
4: public interface CanRun {
5:     public default void walk() { System.out.println("Walking"); }
6:     public abstract void run();
7: }
8: public interface CanSprint extends CanWalk, CanRun {
9:     void sprint();
10: }
```

    A. The code compiles without issue 🎃
    B. The code will not compile due to line 5🎃
    C. The code will not compile due to line 6🎃
    D. The code will not compile due to line 8🎃
    E. The code will not compile due to line 9🎃

### My Answer:
* A - false
* B - false, this is fine
* C - false, this is fine
* D - true (I think so anyway)
* E - false this is fine
* **D**

<hr>

## Question 11

❓Which lambda can replace the MySecret class to return the same value (choose all that apply)❓

```java
public interface Secret {
    String magic(double d);
}
public class MySecret implements Secret {
    public String magic(double d) {
        return "Poof";
    }
}
```

    A. `caller((e) -> "Poof");` 🎃
    B. `caller((e) -> {"Poof"});` 🎃
    C. `caller((e) -> { String e =""; "Poof"; });` 🎃
    D. `caller((e) -> { String e =""; return "Poof"; }); 🎃
    E. `caller((e) -> { String e =""; return "Poof" }); 🎃
    F. `caller((e) -> { String f =""; return "Poof"; }); 🎃

### My Answer:

* **A, F**

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