# Chapter 2.1: Designing An Interface

## What is an Interface?

- Interface are a means of supporting multiple inheritance in Java
- An interface is not required to contain methods/variables, some are designed simply to categorise a class which it implements
- E.g. java.io.Serializable is a marker interface
- Interfaces can not be instantiated or marked final

## Purpose of an Interface 

- Interfaces allow for testing and agile development.
- We can use interfaces to mock implementations which are yet to be developed or test edge cases
 ----

 ## Example 1:
 Here is an example of an interface and a class which implements it:

    public interface Fly {
        public int getWingSpan() throws Exception;
        public static final int MAX_SPEED = 100;
        public default void land() {
            System.out.println("Animal is landing");
        }
        public static double calculateSpeed(float distance, double time) {
            return distance/time;
        }
    }

The Eagle class implements the interface:

    class Eagle implements Fly {
        public int getWingSpan() throws Exception {
            return 15;
        }
        public void land() {
            System.out.println("Eagle dives quickly");
        }
    }

- The getWingSpan override optionally throws exception
- The land() method is optionally overrided
- The calculateSpeed is a static method

----

## Example 2:

    public class Animal {}
    class Tortoise extends Animal {}
    class Hare extends Animal {}
    interface RaceManager {
        public Animal getWinner(List<Animal> animals);
    }

    /* we can mock an implementation of RaceManager */
    class DummyRaceManager implements RaceManager{
        public Animal getWinner(List<Animal> animals) {
            return animals==null || animals.size()==0 ? null : animals.get(0);
        }
    }
