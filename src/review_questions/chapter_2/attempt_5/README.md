# Chapter 2 - Review Questions Attemp 5

## Results:

Date:  <br>
Score:  <br>

| Question # | Correct  |
| ---------- | -------  |
| 1          | ✅      |
| 2          | ❌      |
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
| 20         |       |

## 🟧 Question 1

❓Which of the following statements about design principles and design patterns are true (choose all which apply)❓

A.  A design principle is focused on solving a specific commonly occuring problem <br>
B.  Design principles and design patterns are the same thing <br>
C.  Design principles are often applied throught an application, whereas design patterns are applied to solve specific problems <br>
D.  Design patterns can only be applied to static classes <br>
E.  Design principles and design patterns tend to produce code that is easier to maintain and easier for other developers to read  <br>

### My Answer:
* A - false, design principles are ideas which can be applied generally
* B - false
* C - true
* D - false
* E - true
* **C,E**
<br>

<hr>

## 🟧 Question 2

❓What is the result of the following code❓

```java
1: public interface CanClimb {
2:     public abstract void climb();
3: }
4: public interface CanClimbTrees extends CanClimb {}
5: public abstract class Chipmunk implements CanClimbTrees {
6:     public abstract void chew();
7: }
8: public class EasternChipmunk extends Chipmunk {
9:     public void chew() { System.out.println("Eastern  Chipmunk is Chewing";}
10: }
```

A.  It compiles and runs without issue <br>
B.  The code will not compile because of line 2 <br>
C.  The code will not compile because of line 4 <br>
D.  The code will not compile because of line 5 <br>
E.  The code will not compile because of line 8 <br>
F.  It compiles but throws exception at runtime <br>

### My Answer:
* Chipmunk has climb and chew as abstract methods
* Therefore line 8 will not compile
* **E**
<br>

<hr>


## 🟧 Question 3

❓Which of the following are functional interrfaces❓

```java
public interface Climb {
    public int climb();
}
public abstract class Swim {
    public abstract Object swim(double speed, int duration);
}
public interface ArcticMountainClimb extends MountainClimb {
    public default int getSpeed();
}
public interface MountainClimb extends Climb {}
```

A.  `Climb` <br>
B.  `Swim` <br>
C.  `ArcticMountainClimb` <br>
D.  `MountainClimb` <br>
E.  None of these are valid functional interfaces <br>

### My Answer:
* Climb, and MountainClimb are functional interfaces
* Swim is an abstract class!
* **A,D**
<br>

<hr>


## 🟧 Question 4

❓Which of the following are valid lambda expressions (choose all that apply)❓

A.  `() -> ""` <br>
B.  `x,y -> x+y` <br>
C.  `(Coyote y) -> return 0; <br>
D.  `(Camel c) -> {return; } <br>
E.  `Wolf w -> 39` <br>
F.  `() ->` <br>
G.  `(Animal z, m)-> a` <br>

### My Answer:
* A - valid
* B - invalid, needs round brackets
* C - valid
* D - valid
* E - invalid, needs round brackets
* F - invalid, m must have a type
* **A,C,D**
<br>

<hr>


## 🟧 Question 5

❓What are some of the properties of the singleton pattern (choose all that apply)❓

A. Singleton object can be replaced with encapsulated setter method <br>
B. Requires contructor of singleton class to be private <br>
C. Singleton object must be named `instance` <br>
D. Single object may be private or protected <br>
E. Ensure that there is only one instance of an object in memory <br>
F. Required a `public static` method to retrieve the instance of the singleton

### My Answer:
* Singleton ensures that there is only a single instance in memory
* A - false
* B - true
* C - false
* D - false, must be private
* E - true
* F - true
* **B,E,F**
<br>

<hr>


## 🟧 Question 6

❓What is the result of the following class❓

```java
import java.util.function.*;
public class Panda {
    int age;
    public static void main(String[] args) {
        Panda p1 = new Panda();
        p1.age = 1;
        check(p1, p -> p.age < 5); // h1
    }
    private static void check(Panda panda, Predicate<Panda> pred) { // h2
        String result = pred.test(panda) ? "match" : "not match"; // h3
        System.out.println(result);
    }
}
```

    A.  `match`🎃
    B.  `not match`🎃
    C.  `Compiler error on line h1`🎃
    D.  `Compiler error on line h2`🎃
    E.  `Compiler error on line h3`🎃
    F.  `A runtime exception is thrown`🎃

### My Answer:
* This code compiles, and prints `match`
* **A**
<br>

<hr>


## 🟧 Question 7

❓What changes need to be made to make the following immutable object pattern correct❓

```java
import java.util.*;
public class Seal {
    String name;
    private final List<Seal> friends;
    public Seal(String name, List<Seal> friends) {
        this.name = name;
        this.friends = friends;
    }
    public String getName() { return name; }
    public List<Seal> getFriends() { return friends; }
}
```

A. None; the immutable object pattern is properly implemented. <br>
B. Have Seal implement the Immutable interface <br>
C. Mark `name` final and private <br>
D. Add setters for `name` and `List<Seal> friends`  <br>
E. Replace the getFriends() method with methods that do not give the caller direct access to the `List<Seal> friends`  <br>
F. Change type of `List<Seal>` to `List<Object>`  <br>
G. Make a copy of the `List<Seal> friends` in the constructor  <br>
H. Make the `Seal` class final  <br>

### My Answer:
* An immutable class is marked final, has private final variables, a public constructor, and no setters
* A - false, the getFriends() returns a direct reference of a mutable object
* B - false, does not exist
* C - true
* D - false
* E - true
* F - false
* G - true, although I incorrectly assumed this was false to begin with
* H - true
* **C,E,G,H**
<br>

<hr>


## 🟧 Question 8

❓Which of the following are true of interfaces (choose all that apply)❓

A. They can extend other classes <br>
B. They can not be extended <br>
C. They enable classes to have multiple inheritance <br>
D. They can only contain abstract methods <br>
E. They can be declared final <br>
F. All members of an interface are public <br>

### My Answer:
* A - true, they can extend interfaces
* B - false
* C - true
* D - false
* E - false, this will prevent implementation
* F - true
* **A,C,F**
<br>

<hr>

## 🟧 Question 9

❓What changes need to be made to make the following singleton pattern correct?❓

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

A. None; the singleton pattern is properly implemented <br>
B. Rename `cheetahManager` to instance <br>
C. Rename `getCheetahManager()` to `getInstance()` <br>
D. Change the access modifier of `cheetahManager` from public to private <br>
E. Mark `cheetahManager` final <br>
F. Add synchronized to `getCheetahManager()` <br>

### My Answer:
* The instance must be private
* The get method must be synchronized
* A - false
* B - false
* C - false
* D - true
* E - false, not necessary
* F - true
* **D,F**
<br>

<hr>


## 🟧 Question 10

❓What is the result of the following code?❓

```java
1:  public interface CanWalk {
2:      default void walk() { System.out.println("Walking"); }
3:  }
4:  public interface CanRun {
5:      public default void walk() { System.out.println("Walking"); }
6:      public abstract void run();
7:  }
8:  public interface CanSprint extends CanWalk, CanRun {
9:      void sprint();
10: }
```

A. The code compiles without issue <br>
B. The code will not compile because of line 5 <br>
C. The code will not compile because of line 6 <br>
D. The code will not compile because of line 8 <br>
E. The code will not compile because of line 9 <br>

### My Answer:
* The interface can not extend two interfaces with a default method of same signature
* **D**
<br>

<hr>


## 🟧 Question 11

❓Which lambda can replace the `MySecret` class to return the same value (choose all that apply)❓

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

A. `caller((e) -> "Poof");`  <br>
B. `caller((e) -> {"Poof"});`  <br>
C. `caller((e) -> { String e = ""; "Poof"; });`  <br>
D. `caller((e) -> { String e = ""; return "Poof"; });`  <br>
E. `caller((e) -> { String e = ""; return "Poof" });`  <br>
F. `caller((e) -> { String f = ""; return "Poof"; });` <br>

### My Answer:
* **A,F**
<br>

<hr>


## 🟧 Question 12

❓What is the result of the following code?❓

```java
public interface Climb {
    boolean isTooHigh(int height, int limit);
}
public class Climber {
    public static void main(String[] args) {
        check((h,l) -> h.toString(), 5); // x1
    }
    private static void check(Climb climb, int height) {
        if (climb.isTooHigh(height, 10)) // x2
            System.out.println("too high");
        else System.out.println("ok");
    }
}
```

A. `ok` <br>
B. `too high` <br>
C. Compiler error on line x1 <br>
D. Compiler error on line x2 <br>
E. Compiler error on a different line <br>
F. A runtime exception is thrown. <br>

### My Answer:
* **C**

<br>

<hr>


## 🟧 Question 13

❓ Which of the following are properties of classes that define immutable objects? (Choose all tha apply)❓

A. They don't define any getter methods  <br>
B. All of the instance variables marked private and final  <br>
C. They don't define any setter methods  <br>
D. They mark all instance variables static  <br>
E. They prevent methods from being overridden  <br>
F. All getter methods are marked synchronized  <br>

### My Answer:

<br>

<hr>


## 🟧 Question 14

❓Which of the following statements can be inserted in the blank line so that the code will compile successfully? (Choose all that apply)❓

```java
public interface CanHop {}
public class Frog implements CanHop {
    public static void main(String[] args) {
        _________ frog = new TurtleFrog();
    }
}
public class BrazillianHornedFrog extends Frog {}
public class TurtleFrog extends Frog {}
```
A. Frog <br>
B. TurtleFrog <br>
C. BrazillianHornedFrog <br>
D. CanHop <br>
E. Object <br>
F. Long <br>

### My Answer:

<br>

<hr>

## 🟧 Question 15

❓ Which of the following statements about polymorphism are true? (choose all that apply) ❓

A. A reference to an object may be cast to a subclass of the object without an explicit cast.  <br>
B. If a method takes a class that is the superclass of three different object references, then any of those object may be passed as a parameter to the method <br>
C. A reference to an object may be cast to a superclass of the object without an explicit cast. <br>
D. All cast exceptions can be detected at compile time <br>
E. By defining public instance method in the superclass, you guarantee that the specific method will be called in the parent class at runtime <br>

### My Answer:

<br>

<hr>

## 🟧 Question 16

❓Choose the correct statement about the following code:❓

```java
1: public interface Herbivore {
2:     int amount = 10;
3:     public static void eatGrass();
4:     public int chew() {
5:         return 13;
6:     }
7: }
```

A. It compiles and runs without issue <br>
B. The code will not compile because of line 2 <br>
C. The code will not compile because of line 3 <br>
D. The code will not compile because of line 4 <br>
E. The code will not compile because of line 2 and 3 <br>
F. The code will not compile because of line 3 and 4 <br>

### My Answer:

<br>

<hr>


## 🟧 Question 17

❓Which of the following are properties of classes that are properly encapsulated as a JavaBean (Choose all that apply)❓

A. All instance variable are marked final <br>
B. boolean instance variables are accessed with `is` or `get` <br>
C. All instance variables are marked private <br>
D. They implement the `JavaBean` interface <br>
E. Variables are created using lazy instantiation <br>
F. The first letter of the any getter/setter, after the `get`, `set`, or `is` prefix, must be upper case <br>

### My Answer:

<br>

<hr>


## 🟧 Question 18

❓Which of the following statements about inheritance and object composition are correct? (Choose all that apply)❓

A. Inheritance supports access to protected variables <br>
B. Object composition tends to promote greater code reuse than inheritance <br>
C. Inheritance relies on the has-a principle <br>
D. Object composition supports method overriding at runtime <br>
E. Object composition requires a class variable to be public or accessible from a public method to be used by a class in a different package <br>
F. Object composition is always preferred to inheritance. <br>

### My Answer:

<br>

<hr>


## 🟧 Question 19

❓Which three scenarios would best benefit from using the singleton pattern (Choose all three)❓

A. Create read-only objects that are thread-safe <br>
B. Manage a reusable cache of objects <br>
C. Ensure that all objects are lazily instantiated <br>
D. Manage write access to a log file <br>
E. Provide central access to application configuration data <br>
F. Allow multiple instances of a static object to be managed in memory <br>

### My Answer:

<br>

<hr>

## 🟧 Question 20

❓Choose the correct statement about the following code❓

```java
1: public interface CanFly {
2:     void fly();
3: }
4: interface HasWings {
5:     public abstract Object getWingSpan();
6: }
7: abstract class Falcon implements CanFly, HasWings {
8: }
```

A. It compiles without issue <br>
B. The code will not compile because of line 2 <br>
C. The code will not compile because of line 4 <br>
D. The code will not compile because of line 5 <br>
E. The code will not compile because of line 2 and 5 <br>
F. The code will not compile because of class Falcon does not implement the interface methods <br>

### My Answer:

<br>

<hr>

