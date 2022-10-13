# Chapter 2.3: Implementing Polymorphism

**DEFINITION:** Polymorphism is the ability of an object to take on different forms. Java suppoorts polymorphism, meangin an object can be reference by the class, superclass or interface implementeed by the class of the object.

The consequences of polymorphism means we have method overriding in which a subclass overwrites the implementation of its parent class. This is known as dynamic polymorphism because implementation of a virtual method is dependent on the type of object which calls the method

Note: method overloading is a form of polymorphism but this is not the same type of polymorphism of the above



This chapter will cover the following topics:
1) [Distinguishing between an Object and a Reference](#1-distinguishing-between-an-object-and-a-reference) 
2) [Casting Object References](#2-casting-object-references) 



<hr style="border:none;background-color:gray; height:3px">


### Example 1:
    interface LivesInSea { public void makeSound();}

    class Whales implements LivesInSea {
        public void makeSound() { System.out.println("pulse");	}
    }

    class Dolphin implements LivesInSea {
        public void makeSound() { System.out.println("sing");	}
    }

    public class Oceonographer {
        public void checkSound(LivesInSea animal) {
            animal.makeSound();
        }
        public static void main(String[] args) {
            Oceonographer o = new Oceonographer();
            o.checkSound(new Dolphin()); // sing
            o.checkSound(new Whales()); // pulse
        }
    }

<hr style="border:none;background-color:gray; height:3px">

## 1. Distinguishing between an Object and a Reference
    

In java, objects can only be accessed via reference. There is no direct memory access
 
Regardless of type, the object in memory does not change.

For example, we can instantiate a Lemur object and reference it via Object.

If we reference the lemur as Object, we no longer have access to the Lemur properties unless we cast it back to Lemur

Hence, we have two rules for polymorphism:

1) Type of object determines which properties exist in memory
2) Type of reference to object determines which variables and methofds are accessible to Java program
 
<hr style="border:none;background-color:gray; height:1px">


### Example 2:

    class Primate {
        public boolean hasHair() { return true; }
    }

    interface HasTail {
        public boolean isTailStriped();
    }

    class Lemur extends Primate implements HasTail{
        public int age = 10;
        public boolean isTailStriped() { return false; }
    }

    public class PolymorphismExample2 {
        public static void main(String[] args) {
            Lemur lemur = new Lemur();
            HasTail lemur2 = lemur;
            System.out.println(lemur2.isTailStriped()); // false
            lemur2.hasHair(); - does not compile
            
            Primate lemur3 = lemur;
            lemur3.isTailStriped(); - does not compile
            System.out.println(lemur3.hasHair()); // true
        }
    }


<hr style="border:none;background-color:gray; height:3px">

## 2. Casting Object References
