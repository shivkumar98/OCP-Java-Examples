# Chapter 2.2: Defining Functional Interface

**DEFINITION:** A functional interface is an interface with a single abstract method

Functional interfaces are used as a basis for lambda expressions. I.e. we can pass a lambda expression as an implementation for a functional interface

This chapter will cover the following design principles:
1) [Defining an Interface](#1-defining-an-interface) 
2) [Implementing Functional Interfaces With Lambdas](#2-implementing-functional-interfaces-with-lambdas) 
3) [Applying the Predicate Interface](#3-applying-the-predicate-interface) 





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
Here are some **counter examples which are not functional interfaces:**


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

### Example 1
Consider the following Animal class:

    class Animal {
        private String species; private boolean canHop, canSwin;
        public Animal(String species, boolean canHop, boolean canSwim) {
            this.species = species; this.canHop = canHop; this.canSwin = canSwim;
        }
        public boolean canHop() { return canHop; }
        public boolean canSwim() { return canSwin; }
        public String toString() { return species; }
    }

We define a functional interface as:

    public interface CheckTrait {
        public boolean test(Animal a);
    }

We can now use lambda syntax to create a simple program which prints an animal if it has a certain trait:

    class FindMatchingAnimal{
        public static void print(Animal animal, CheckTrait trait) {
            if (trait.test(animal)) {
                System.out.println(animal);
            }
        }
        public static void main(String[] args) {
            FindMatchingAnimal.print(new Animal("fish", false, true), a -> a.canHop());  
            FindMatchingAnimal.print(new Animal("Kangaroo", true, false), a-> a.canHop()); // Kangaroo
        }
    }

Java uses context to determine what a lambda expression means.

The lamda syntax is passed as a interface parameter, therefore Java treats the interface as a functional interface

<hr style="border:none;background-color:gray; height:0.5px">

### Understanding Lambda Syntax

The following lambda expressions are equivalent:

    a -> a.canHop()
    (Animal a) -> {return a.canHop();}

Here are some rules for Lambda syntax:
1) Round brackets are optional for 1 parameter, but mandatory for 0 or >1 parameters
2) If curly braces are used, a return and semicolon are required
3) If the lambda does not return anything you can write (int y) -> { return; } or (int z) -> { }

Here are some examples of **valid lambda syntax:**

    () -> new Duck()
    d -> { return d.quack(); }
    (Duck d) -> d.quack();
    (Animal a, Duck d) -> d.quack()
    (int x) -> {}
    (int y) -> { return; }
    () -> true
    (x,y) -> {}
    (a, b) -> { int c = 0; return 5; }


Here are some examples of **invalid lambda syntax:**

    a,b -> a.startsWith("test")
    c -> return 10;
    a -> { return a.startsWith("test"); }
    (int x) -> { int x=1; return x+1; } // you can not redeclare variable
    (int x, y) -> {} // if you declare type of one parameter you must provide for all

<hr style="border:none;background-color:white; height:3px">

## 3. Applying the Predicate Interface


