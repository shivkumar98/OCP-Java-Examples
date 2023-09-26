# Chapter 2 - Review Questions Attempt 3

## Results:

Date: 
Score: 
✅❌

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
| 20         |       |

## Question 1

❓Which of the following statements about design principles and design patterns are true (choose all which apply)❓

    A.  A design principle is focused on solving a specific commonly occuring problem🎃
    B.  Design principles and design patterns are the same thing🎃
    C.  Design principles are often applied throught an application, whereas design patterns are applied to solve specific problems🎃
    D.  Design patterns can only be applied to static classes🎃
    E. Design principles and design patterns tend to produce code that is easier to maintain and easier for other developers to read 🎃

### My Answer:
* A - true
* B - false
* C - true
* D - false
* E - true
* **A,C,E**

<hr>

## Question 2

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

    A.  It compiles and runs without issue🎃
    B.  The code will not compile because of line 2🎃
    C.  The code will not compile because of line 4🎃
    D.  The code will not compile because of line 5🎃
    E.  The code will not compile because of line 8🎃
    F. It compiles but throws exception at runtime🎃

### My Answer:
* The code does not compile at line 8 due to it not implementing `climb()`
* **E**

<hr>

## Question 3

❓Which of the following are functional interfaces❓

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

    A.  `Climb`🎃
    B.  `Swim`🎃
    C.  `ArcticMountainClimb`🎃
    D.  `MountainClimb`🎃
    E.  None of these are valid functional interfaces🎃

### My Answer:
* Climb and Swim are functional interfaces.
* MountainClimb inherits from Climb, so it is a functional interface
* ArticMountain is not valid as it has no implementation
* **A,B,D**

<hr>

## Question 4

❓Which of the following are valid lambda expressions (choose all that apply)❓

    A.  `() -> ""`🎃
    B.  `x,y -> x+y`🎃
    C.  `(Coyote y) -> return 0;🎃
    D.  `(Camel c) -> {return; }🎃
    E.  `Wolf w -> 39`🎃
    F.  `() ->`🎃
    G.  `(Animal z, m)-> a`🎃

### My Answer:
* A - valid
* B - invalid, needs brackets
* C - invalid, return must be in braces
* D - valid
* E - invalid, must be in round brackets
* F - valid, i think
* G - valid
* **A,D,F,G**

<hr>

## Question 5

❓What are some of the properties of the singleton pattern (choose all that apply)❓

    A. Singleton object can be replaced with encapsulated setter method 🎃
    B. Requires contructor of singleton class to be private 🎃
    C. Singleton object must be named `instance` 🎃
    D. Single object may be private or protected 🎃
    E. Ensures that there is only one instance of an object in memory 🎃
    F. Required a `public static` method to retrieve the instance of the singleton

### My Answer:
* A - no
* B - yes
* C - no
* D - no, it must be private
* E - yes
* F - yes
* **B,E,F**

<hr>

## Question 6

❓What is the result of the following class❓

```java
import java.util.function.*;
public class Panda {
    int age;
    public static void main(String[] args) {
        Panda p1 = new Panda();
        p1.age = 1;
        check(p1, p-> p.age < 5); // h1
    }
    private static void check(Panda panda, Predicate<Panda> pred) { // h2
        String result = pred.test(panda) ? "match" : "not match";
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
* It will print match as p1 has an age less than 5
* **A**

<hr>

## Question 7

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

    A.  None; the immutable object pattern is properly implemented.🎃
    B.  Have Seal implement the Immutable interface🎃
    C.  Mark `name` final and private🎃
    D.  Add setters for `name` and `List<Seal> friends` 🎃
    E. Replace the getFriends() method with methods that do not give the caller direct access to the `List<Seal> friends` 🎃
    F. Change type of `List<Seal>` to `List<Object>` 🎃
    G. Make a copy of the `List<Seal> friends` in the constructor 🎃
    H. Make the `Seal` class final 🎃

### My Answer:
* A - no
* B - no, does not exist
* C - yes
* D - no
* E - yes
* F - no
* G - no
* H - yes, prevent methods from being overidden
* **C, E, H**
<hr>

## Question 8

❓Which of the following are true of interfaces (choose all that apply)❓

    A. They can extend other classes 🎃
    B. They can not be extended 🎃
    C. They enable classes to have multiple inheritance 🎃
    D. They can only contain abstract methods 🎃
    E. They can be declared final 🎃
    F. All members of an interface are public 🎃

### My Answer:
* A - no, they can extend interfaces
* B - no, an interface can
* C - yes
* D - false, can contain default
* E - yes
* F - yes
* **C,E,F**

<hr>

## Question 9

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

    A.  None; the singleton pattern is properly implemented S🎃
    B.  Rename `cheetahManager` to instance 🎃
    C.  Rename `getCheetahManager()` to `getInstance()` 🎃
    D.  Change the access modifier of `cheetahManager` from public to private 🎃
    E. Mark `cheetahManager` final 🎃
    F. Add synchronized to `getCheetahManager()` 🎃

### My Answer:
* A - no
* B - no, not essential
* C - no, not essential
* D - no
* E - no
* F - yes
* **F**
<hr>

## Question 10

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

    A. The code compiles without issue 🎃
    B. The code will not compile because of line 5 🎃
    C. The code will not compile because of line 6 🎃
    D. The code will not compile because of line 8 🎃
    E. The code will not compile because of line 9 🎃

### My Answer:
* Can an interface extend multiple interfaces. I think so
* **D** - does CanSprint inherit the defaul or abstract method? Java says no! (probna)
<hr>

## Question 11

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

    A. `caller((e) -> "Poof");` 🎃
    B. `caller((e) -> {"Poof"});` 🎃
    C. `caller((e) -> { String e = ""; "Poof"; });` 🎃
    D. `caller((e) -> { String e = ""; return "Poof"; });` 🎃
    E. `caller((e) -> { String e = ""; return "Poof" });` 🎃
    F. `caller((e) -> { String f = ""; return "Poof"; });`

### My Answer:
* A - yes
* B - no
* C, D, E - no
* F - yes
* **A,F**

<hr>

## Question 12

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

    A. `ok` 🎃
    B. `too high` 🎃
    C. Compiler error on line x1 🎃
    D. Compiler error on line x2 🎃
    E. Compiler error on a different line 🎃
    F. A runtime exception is thrown.

### My Answer:
* x1 does not compile, the lambda needs to be a predicate!
* **C**

<hr>

## Question 13

❓ Which of the following are properties of classes that define immutable objects? (Choose all tha apply)❓

    A. They don't define any getter methods 🎃
    B. All of the instance variables marked private and final 🎃
    C. They don't define any setter methods 🎃
    D. They mark all instance variables static 🎃
    E. They prevent methods from being overridden 🎃
    F. All getter methods are marked synchronized 🎃

### My Answer:

<hr>

## Question 14

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

    A. Frog 🎃
    B. TurtleFrog 🎃
    C. BrazillianHornedFrog 🎃
    D. CanHop 🎃
    E. Object 🎃
    F. Long 🎃

### My Answer:

<hr>

## Question 15

❓ Which of the following statements about polymorphism are true? (choose all that apply) ❓

    A. A reference to an object may be cast to a subclass of the object without an explicit cast.  🎃
    B. If a method takes a class that is the superclass of three different object references, then any of those object may be passed as a parameter to the method 🎃
    C. A reference to an object may be cast to a superclass of the object without an explicit cast. 🎃
    D. All cast exceptions can be detected at compile time 🎃
    E. By defining public instance method in the superclass, you guarantee that the specific method will be called in the parent class at runtime 🎃

### My Answer:

<hr>

## Question 16

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

    A. It compiles and runs without issue 🎃
    B. The code will not compile because of line 2 🎃
    C. The code will not compile because of line 3 🎃
    D. The code will not compile because of line 4 🎃
    E. The code will not compile because of line 2 and 3 🎃
    F. The code will not compile because of line 3 and 4 🎃

### My Answer:

<hr>

## Question 17

❓Which of the following are properties of classes that are properly encapsulated as a JavaBean (Choose all that apply)❓

    A. All instance variable are marked final 🎃
    B. boolean instance variables are accessed with `is` or `get` 🎃
    C. All instance variables are marked private 🎃
    D. They implement the `JavaBean` interface 🎃
    E. Variables are created using lazy instantiation 🎃
    F. The first letter of the any getter/setter, after the `get`, `set`, or `is` prefix, must be upper case 🎃

### My Answer:

<hr>

## Question 18

❓Which of the following statements about inheritance and object composition are correct? (Choose all that apply)❓

    A. Inheritance supports access to protected variables  🎃
    B. Object composition tends to promote greater code reuse than inheritance 🎃
    C. Inheritance relies on the has-a principle 🎃
    D. Object composition supports method overriding at runtime 🎃
    E. Object composition requires a class variable to be public or accessible from a public method to be used by a class in a different package 🎃
    F. Object composition is always preferred to inheritance.

### My Answer:

<hr>

## Question 19

❓Which three scenarios would best benefit from using the singleton pattern (Choose all three)❓

    A. Create read-only objects that are thread-safe 🎃
    B. Manage a reusable cache of objects 🎃
    C. Ensure that all objects are lazily instantiated 🎃
    D. Manage write access to a log file 🎃
    E. Provide central access to application configuration data 🎃
    F. Allow multiple instances of a static object to be managed in memory

### My Answer:

<hr>

## Question 20

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

    A. It compiles without issue 🎃
    B. The code will not compile because of line 2 🎃
    C. The code will not compile because of line 4 🎃
    D. The code will not compile because of line 5 🎃
    E. The code will not compile because of line 2 and 5 🎃
    F. The code will not compile because of class Falcon does not implement the interface methods🎃