# 2.4 - Understanding Design Principles

**What is a deisgn principle?**

This is an established principle used to facilitate software design principle
 Following deisgn principles leads to:
 - More logical code
 - Code is easier to understand as people can research the deisgn principle
 - Allows code to be easier to modify with respect to requirements

This chapter will cover the following design principles:
1) [Encapsulation](#1-encapsulation) 
2) [Creating JavaBeans](#2-creating-javabeans) 
3) [Applying the is-a Relationship](#3-applying-the-is-a-relationship) 
4) [Applying the has-a Relationship](#4-applying-the-has-a-relationship) 
5) [Composing Objects](#5-composing-objects) 


----

## **1. Encapsulation**

**What is encapsulation?**

A fundamental design principle - an idea of combining fields and methods in a class so that they operate on data and not direct user input
 
 - This is achieved by using private instance members and public methods
 - Encapsulation means that the class has direct access to data and thus can invalidate incorrect data being supplied.
 - The class maintains INVARIANTS about its internal data,
  
### Example 1
E.g. suppose we deisgn an Animal class with the following design requirements:
1) Each animal has a non-null, non-empty species field
2) Each animal has an age >= 0
 
Consider the following example which is NOT encapsulated:

    public class Animal {
            public String species;
            public int age;
        
            public static void main(String[] args) {
                Animal animal = new Animal(); // this violates requirement 1
                animal.age = -100; // this violates requirement 2
            }
    }   

### Example 2
Consider the following class which *is* encapsulated

    public class Employee {
        private String name;
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }

 * We have no validation on the public methods, so in theory this would be equivalent to have a public field
 * But encapsulation IS actually better than leaving the field public!
 * Why? Because we can change the implementation of this methods without forcing users to recompile their code
 * If we originally had the name a public field and then changed it to private => recompilation is required!

----
## 2. Creating JavaBeans

**What is a JavaBean?**
JavaBean is another word for encapsulated Jaca class. A JavaBean is a design principle for encapsulating data in a object in java JavaBeans must obide certain properties
    
**Rules for JavaBeans:**

1) properties are private
2) getters for non boolean properties are prefixed with "get"
3) getters for boolean properties may begin with "get" or "is"
4) setters begin with "set"
5) the first letter past the prefix of setter/getter is uppercase character of property

### Example 1:

Suppose a class has the following properties:
    private boolean playing;
    private boolean dancing;
 
 Which of the following would be correctly defined in a JavaBean?
    
    public boolean isPlaying() { return playing; } // valid
    
    public boolean getPlaying() { return playing; } // valid
    
    public Boolean isDancing() { return dancing; } // invalid - this is returning a wrapper class object so should be prefixed with "get"

----


## 3. Applying the is-a Relationship

### What is the Is-a Relationship?

- The is-a test is used to determine if an object is a subclass of another class.
- It is also known as an inheritance test
- Knowing that A is-a B means we can TREAT A exactly as we TREAT B.
- This is very important when we decide the inheritance hierarchy between classes

#### Example 1
Suppose we have a Pet class: 
    
    class Pet {}
  
 We can then create a Cat subclass:
    
    class Cat extends Pet {}
 
This is valid as Cat IS A Pet
 We could also create a Tiger subclass:
    
    class Tiger extends Pet {}
 
While this compiles, it violates the design principle. We can not treata Tiger object the same way we can treat a Pet

We can work around hierarchal relationships by using interfaces as a way to achieve multiple inheritance


----

## 4. Applying the has-a Relationship

The has-a test is another object-oriented design. It is also known as composition test

The has-a test checks if an object contains a particular property or value.

This is different from inheritance, we qare now analysing the COMPOSITION of a class

### Example

Bird HAS-A Beak:

    public class Bird {
        Beak beak;
    }
    class Beak  {}

Composition enforces that child classes of Bird must also have a Beak

----

## 5. Composing Objects

**What is object-composition?**

This is the property of creating a class which references another class in order to use its functionality

Instead of relying on inheritance, composition allows for more complex relationships between classes

### Eample

    public class Penguin {
        Flippers flipper;
        WebbedFeet webbedFeet;
        public Penguin() {
            this.flipper = new Flippers();
            this.webbedFeet = new WebbedFeet();
        }
        public void flap() { this.flipper.flap(); }
        public void kick() { this.webbedFeet.kick(); }
    }

    class Flippers {
        public void flap() { System.out.println("The flippers go back and forth"); }
    }
    class WebbedFeet {
        public void kick() { System.out.println("the webbed feet kick to and from"); }
    }