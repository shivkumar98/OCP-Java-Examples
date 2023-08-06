# Chapter 2 - Review Questions Attemp #

## Results:

Date: 
Score: 

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

## Question 1

❓Which of the following statements about design principles and design patterns are true (choose all which apply)❓

    A.  A design principle is focused on solving a specific commonly occuring problem🎃
    B.  Design principles and design patterns are the same thing🎃
    C.  Design principles are often applied throught an application, whereas design patterns are applied to solve specific problems🎃
    D.  Design patterns can only be applied to static classes🎃
    E. Design principles and design patterns tend to produce code that is easier to maintain and easier for other developers to read 🎃

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

<hr>

## Question 3

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

    A.  `Climb`🎃
    B.  `Swim`🎃
    C.  `ArcticMountainClimb`🎃
    D.  `MountainClimb`🎃
    E.  None of these are valid functional interfaces🎃

<hr>

## Question 4

❓Which of the following are valid lambda expressions (choose all that apply)❓

    A.  `() -> ""`🎃
    B.  `x,y -> x+y`🎃
    C.  `(Coyote y) -> return 0;🎃
    D.  `(Camel c) -> {return; }🎃
    E.  `Wolf w -> 39`🎃
    F.  `() ->``🎃
    G.  `(Animal z, m)-> a`🎃

<hr>

## Question 5

❓What are some of the properties of the singleton pattern (choose all that apply)❓

    A. Singleton object can be replaced with encapsulated setter method 🎃
    B. Requires contructor of singleton class to be private 🎃
    C. Singleton object must be a named instance 🎃
    D. Single object may be private or protected 🎃
    E. Ensure that there is only one instance of an object in memory 🎃
    F. Required a `public static` method to retrieve the instance of the singleton

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

<hr>

## Question 8

❓Which of the following are true of interfaces (choose all that apply)❓

    A. They can extend other classes 🎃
    B. They can not be extended 🎃
    C. They enable classes to have multiple inheritance 🎃
    D. They can only contain abstract methods 🎃
    E. They can be declared final 🎃
    F. All members of an interface are public 🎃

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

<hr>

## Question 10

❓What is the result of the following code?❓

```java
1:  public interface CanWalk {
2:      default void walk() { System.out.println1: ("Walking"); }
3:  }
4:  public interface CanRun {
5:      public default void walk() { System.out.println: ("Walking"); }
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

## Question 11

❓❓

❓ ❓

    A.  🎃
    B.  🎃
    C.  🎃
    D.  🎃
    E.  🎃

<hr>

## Question 12

❓❓

❓ ❓

    A.  🎃
    B.  🎃
    C.  🎃
    D.  🎃
    E.  🎃

<hr>

## Question 13

❓❓

❓ ❓

    A.  🎃
    B.  🎃
    C.  🎃
    D.  🎃
    E.  🎃

<hr>

## Question 14

❓❓

❓ ❓

    A.  🎃
    B.  🎃
    C.  🎃
    D.  🎃
    E.  🎃

<hr>

## Question 15

❓❓

❓ ❓

    A.  🎃
    B.  🎃
    C.  🎃
    D.  🎃
    E.  🎃

<hr>

## Question 16

❓❓

❓ ❓

    A.  🎃
    B.  🎃
    C.  🎃
    D.  🎃
    E.  🎃

<hr>

## Question 17

❓❓

❓ ❓

    A.  🎃
    B.  🎃
    C.  🎃
    D.  🎃
    E.  🎃

<hr>

## Question 18

❓❓

❓ ❓

    A.  🎃
    B.  🎃
    C.  🎃
    D.  🎃
    E.  🎃

<hr>

## Question 19

❓❓

❓ ❓

    A.  🎃
    B.  🎃
    C.  🎃
    D.  🎃
    E.  🎃

<hr>

## Question 20

❓❓

❓ ❓

    A.  🎃
    B.  🎃
    C.  🎃
    D.  🎃
    E.  🎃