# Chapter 1 - Review Questions Attempt 3

## Results:

Date: 
Score: /20

| Question # | Correct  |
| ---------- | -------  |
| 1          |          |
| 2          |          |
| 3          |          |
| 4          |          |
| 5          |          |
| 6          |          |
| 7          |          |
| 8          |          |
| 9          |          |
| 10         |          |
| 11         |          |
| 12         |          |
| 13         |          |
| 14         |          |
| 15         |          |
| 16         |          |
| 17         |          |
| 18         |          |
| 19         |          |
| 20         |          |

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
        return this.employeeId == e.employeeId;
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
* Employee one and two have the same ID. The equals method checks for equality of ID, so it will print Success!
* **A**✅✅✅✅

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
* The code DOES compile! Hash code is correct!
* **A**✅✅✅✅


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
* s2 is a seperate string in String pool, so equality fails
* They share the same content!
* **C**✅✅✅✅
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
* The class does compile!
* The hashCode is improper.
* **C**✅✅✅✅

<hr>


## Question 5

❓Which of the following statements are true, assuming `a` and `b` are String objects?❓

    A. if a.equals(b) is true, a.hashCode() == b.hashCode() is always true 🎃
    B. if a.equals(b) is true, a.hashCode() == b.hashCode() is sometimes but not always true🎃
    C. if a.equals(b) is false, a.hashCode() == b.hashCode() can never be true🎃
    D. if a.equals(b) is false, a.hashCode() == b.hashCode() can sometimes be true🎃
 
### My Answer:
* A - false, two strings with same content can have to different hashCodes
* B - true, yes you can have two strings with same content and same hashCode
* C - false
* D - true
* It is not required that two different string must have two different hashcodes!
* **B,D**❌❌❌❌
* **CORRECT ANSWER: A,D**
* If two strings are equal, it must be that their hashCode is the same as seen below:
```java
String a = "a";
System.out.println(a.hashCode()); // 97
String b = new String(a);
System.out.println(b.hashCode()); // 97
```
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
* The code does not compile as case clauses are wrong
* **E**
<hr>

## Question 8

❓What is the result of the following code?❓

```java
1:  public class Outer {
2:      private int x = 5;
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
* An inner class cannot have static variables.
* **C**

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

    A. import my.sports.Football; 🎃
    B. import static my.sports.*; 🎃
    C. import static my.sports.Football; 🎃
    D. import static my.sports.Football.*; 🎃
    E. static import my.sports.*; 🎃
    F. static import my.sports.Football; 🎃
    G. static import my.sports.Football;

### My Answer:
* Football is in a seperate package
* We are importing it staticallyu
* import static my.sports.Football.*;
* **D**
<hr>

## Question 12

❓What is the result of the following code❓

```java
public class Browsers {
    static class Browser {
        public void go() {
            System.out.println("Inside Browser");
        }
    }
    static class Firefox extends Browser {
        public void go() {
            System.out.println("Inside Firefox");
        }
    }
    static class IE extends Browser {
        public void go() {
            System.out.println("Inside IE");
        }
    }
    public static void main() {
        Browser b = new Firefox();
        IE e = (IE) b;
        e.go();
    }
}
```

    A. Inside Browser 🎃
    B. Inside Firefox 🎃
    C. Inside IE 🎃
    D. The code does not compile 🎃
    E. A runtime exception is thrown 🎃

### My Answer:
* You can not cast firefox to IE
* **E**

<hr>

## Question 13

❓Which is a true statement about the following code❓

```java
public class IsItFurry {
    static interface Mammal { }
    static class Furry implements Mammal { }
    static class Chipmunk extends Furry { }
    public static void main() {
        Chipmunk c = new Chipmunk();
        Mammal m = c;
        Furry f = c;
        int result = 0;
        if (c instanceof Mammal) result += 1;
        if (c instanceof Furry) result += 2;
        if (null instanceof Chipmunk) result += 4;
        System.out.println(result);
    }
}
```

    A. The output is 0 🎃
    B. The output is 3 🎃
    C. The output is 7 🎃
    D. c instanceof Mammal does not compile 🎃
    E. c instanceof Furry does not compile🎃
    F. null instanceof Chipmunk does not compile🎃

### My Answer:
* c is an instance of mammal
* c is also an instance of Furry
* null is not an instance of Chipmunk
* **B**

<hr>

## Question 14

❓What is a true statement of the following code (choose all that apply)❓

```java
import java.util.*;
public class IsItFurry {
    static class Chipmunk { }
    public static void main() {
        Chipmunk c = new Chipmunk();
        ArrayList<Chipmunk> l = new ArrayList<>();
        Runnable r = new Thread();
        int result = 0;
        if (c instanceof Chipmunk) result += 1;
        if (l instanceof Chipmunk) result += 2;
        if (r instanceof Chipmunk) result += 4;
        System.out.println(result);
    }
}
```

    A. The code compiles, and the output is 0 🎃
    B. The code compiles, and the output is 3 🎃
    C. The code compiles, and the output is 7 🎃
    D. c instanceof Chipmunk does not compile 🎃
    E. l instanceof Chipmunk does not compile 🎃
    F. r instanceof Chipmunk does not compile 🎃

### My Answer:
* The code does no compile as r is referenced by the interface `Runnable`.
* **F**
<hr>

## Question 15

❓Which statements are true about the equals() method (choose all that apply)❓

    A. if equals(null) is called, the method should throw an exception 🎃
    B. if equals(null) is called, the method should return false 🎃
    C. if equals(null) is called, the method should return true 🎃
    D. If equals() is passed the wrong type, the method should throw an exception 🎃
    E. If equals() is passed the wrong type, the method should return false 🎃
    F. If equals() is passed the wrong type, the method should return true 🎃

### My Answer:
* equals can be passed any type
* if passed null, it returns false
* **B**
<hr>

## Question 16

❓Which of the following can be inserted in main❓

```java
public class Outer {
    class Inner { }

    public static void main(String[] args) {
        // INSERT CODE HERE
    }
}
```

    A. Inner in = new Inner(); 🎃
    B. Inner in = Outer.new Inner(); 🎃
    C. Outer.Inner in = new Outer.Inner(); 🎃
    D. Outer.Inner in = new Outer().Inner(); 🎃
    E. Outer.Inner in = new Outer().new Inner(); 🎃
    F. Outer.Inner in = Outer.new Inner(); 🎃

### My Answer:
* Inner can not be instantiated directly
* **E**

<hr>

## Question 17

❓What is the result of the following code (choose all that apply)❓

```java
1:  public enum AnimalClasses {
2:      MAMMAL(true), FISH(Boolean.FALSE), BIRD(false),
3:      REPTILE(false), AMPHIBIAN(false), INVERTEBRATE(false)
4:      boolean hasHair;
5:      pubic AnimalClasses(boolean hasHair) {
6:          this.hasHair = hasHair;
7:      }
8:      public boolean hasHair() {
9:          return hasHair;
10:     }
11:     public void giveWig() {
12:         hasHair = true; 
13:     }}
```

    A. Compiler error on line 2 🎃
    B. Compiler error on line 3 🎃
    C. Compiler error on line 5 🎃
    D. Compiler error on line 8 🎃
    E. Compiler error on line 12 🎃
    F. Compiler error on another line 🎃
    G. The code compiles successfully 🎃

### My Answer:
* Enum can not have public constructor
* **C**
<hr>

## Question 18

❓What is the result of the following code (choose all that apply)❓

```java
public class Swimmer {
    enum AnimalClasses {
    MAMMAL, FISH {
        public boolean hasFins() { return true; }},
    BIRD, REPTILE, AMPHIBIAN, INVERTEBRATE;
    public abstract boolean hasFins();    
    }
    public static void main() {
        System.out.println(AnimalClasses.FISH);
        System.out.println(AnimalClasses.FISH.ordinal());
        System.out.println(AnimalClasses.FISH.hasFins());
        System.out.println(AnimalClasses.BIRD.hasFins());
    }
}
```

    A. fish 🎃
    B. FISH 🎃
    C. 0 🎃
    D. 1 🎃
    E. false 🎃
    F. true 🎃
    G. The code does not compile

### My Answer:
* All enums must implement the abstract method
* **G**
<hr>

## Question 19

❓Which of the following can be inserted to override the superclass method (choose all that apply)❓

```java
public class LearnToWalk {
    public void toddle() {}
    class BabyRhino extends LearnToWalk {
        // INSERT CODE HERE
    }
}
```

    A. `public void toddle() {}` 🎃
    B. `public void Toddle() {}` 🎃
    C. `public final void toddle() {}` 🎃
    D. `public static void toddle() {}` 🎃
    E. `public void toddle() throws Exception {}` 🎃
    F. `public void toddle(boolean fall)` 🎃

### My Answer:
* A - valid
* C - valid
* **A,C**

<hr>

## Question 20

❓What is the result of the following code❓

```java
public class FourLegged {
    String walk = "walk,";
    static class BabyRhino extends FourLegged {
        String walk = "toddle,";
    }
    public static void main() {
        FourLegged f = new BabyRhino();
        BabyRhino b  = new BabyRhino();
        System.out.print(f.walk);
        System.out.print(b.walk);
    }}
```

    A. toddle,toddle, 🎃
    B. toddle,walk, 🎃
    C. walk,toddle, 🎃
    D. walk,walk, 🎃
    E. The code does not compile. 🎃
    F. A runtime exception is thrown 🎃

### My Answer:
* **C**
<hr>