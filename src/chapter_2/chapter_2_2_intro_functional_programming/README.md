# Chapter 2.2: Defining Functional Interface

**DEFINITION:** A functional interface is an interface with a single abstract method

Functional interfaces are used as a basis for lambda expressions. I.e. we can pass a lambda expression as an implementation for a functional interface

This chapter will cover the following design principles:
1) [Defining an Interface](#1-defining-an-interface) 
2) [Implementing Functional Interfaces With Lambdas](#2-implementing-functional-interfaces-with-lambdas) 
3) [Applying the Predicate Interface](#3-applying-the-is-a-relationship) 





## 1. Defining an Interface
<hr style="border:none;background-color:gray; height:0.5px">

### Example 1:
We can optionally use the @FunctionalInterface to explicitly define a functional interface:

    @FunctionalInterface
    public interface Sprint {
        public void sprint(Animal animal);
    }

Implementation of functional interface:

    class Tiger implements Sprint {
        public void sprint(Animal animal) {
            System.out.println("The animal: "+animal.toString()+ " is sprinting");;
        }
    }

<hr style="border:none;background-color:gray; height:1px">


### Example 2:

**QUESTION:** Which of the following interfaces are valid functional interfaces?

    // interface 1
    interface Run extends Sprint{}
    // interface 2
    interface SprintFaster extends Sprint{
        public void sprint(Animal animal);
    }
    // interface 3
    interface Skip extends Sprint{
        public default int getHopCount(Kangaroo kangaroo) {	return 10; }
        public static void skip(int speed) {}
    }

**ANSWER:** All three are valid functional interfaces
- Interface 1 inherits from a functional interfaces
- Interface 2 overrides the sprint() method with an abstract methhod
- Interface 3 inherits from functional interface and has 2 implemented methods, it therefore satifies the criteria for functional interface

<hr style="border:none;background-color:gray; height:1px">

### Example 3:
Here are some counter examples which are not functional interfaces:


    interface Walk{}

There are no abstract methods defined

    interface Dance extends Sprint {
	    public void dance(Animal animal);
    }
    
This interface inherits an abstract method giving a total of two

    interface Crawl {
        public void crawl();
        public int getCount();
    }

Two abstract methods are defined!

<hr style="border:none;background-color:white; height:3px">

## 2. Implementing Functional Interfaces With Lambdas