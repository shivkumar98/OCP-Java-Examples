# 3.4 Comparator vs Comparable

For Strings, order is defined by Unicode mapping - numbers before letters, uppercase before lowercase.

We can also sort created objects by implementing the Comparable interface.

Comparable is a class which lets you specify a different order than the one provided by object.

We shall compare the differences between Comparable and Comparator!

<br><hr>

# 1 Comparable

The Comparable interface has only one method:

    public interface Comparable<T> {
        public int compareTo(T o);
    }

## **Example 1**

Any object can be Comparable. E.g., suppose we have ducks we want to sort by name:

```java
import java.util.*;
public class Duck implements Comparable<Duck> {
    private String name;
    public Duck(String name) {
        this.name=name;
    }
    public toString(){ return name; }
    public int compareTo(Duck d) {
        return name.compareTo(d.name); // calling String's compareTo method
    }

    public static void main(String[] args) {
        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("Quack"));
        ducks.add(new Duck("Puddles"));
        Collections.sort(ducks);    // sort by name
        System.out.println(ducks);   // [Puddles, Quack]
    }
}
```

The Duck class implements the Comparable interface and overrides the compareTo() method.

## **compareTo() method**

In order for a class to be sorted in a custom way, it must override the compareTo() method. The return of this method determines ordering:

1. Returns 0 - current object is equal to argument of compareTo() argument
2. Returns <0 - current object is less than the argument of compareTo() argument.
3. Returns >0 - current object is more than the argument of compareTo() argument.


## **Example 2**

 In this example, we shall see an implementation of compareTo() on numbers:

```java
public class Animal implements java.util.Comparable<Animal> {
    private int id;
    public int compareTo(Animal a){
        return id - a.id;
    }
    
    public static void main(String[] args){
        Animal a1 = new Animal();
        Animal a2 = new Animal();
        a1.id = 5;
        a2.id = 7;
        System.out.println(a1.compareTo(a2)); // -2
        System.out.println(a1.compareTo(a3)); // 0
        System.out.println(a2.compareTo(a1)); // 2
    }
}
```

## **Example 3**

When dealing with legacy code, the compareTo() method requires a cast since it is passed an Object:

```java
public class LegacyDuck implements java.util.Comparable {
    private String name;
    public int compareTo(Object obj) {
        LegacyDuck d = (LegacyDuck) obj;   // cast due to no generics
        return name.compareTo(d.name);
    }
}
```

## compareTo() and equals() Consistency

We *should* be consistent when implementing compareTo() so that objects which are equal also return 0 when passed to compareTo().

If they are not consistent, collection may behave unpredictably.

E.g., here is a Product class with inconsisten compareTo() method:

```java
    public class Prodcur implements Comparable<Product> {
        int id;
        String name;
        public boolean equals(Object obj) {
            if (!(obj instanceof Product)){
                return false;
            }
            Product other = (Product) obj;
            return this.id == other.id;
        }

        public int compareTo(Product obj){
            return this.name.compareTo(obj.name);
        }
    }
```

The sorting is done based on name but the compareTo method is dependent on id.

We can fix this by using Comparator to define sortr elsewhere

<br><hr>

# 2 Compator

We can sort an object without implementing Comparable by defining a **Comparator** in the main method!

The Comparator **must implement the compare() method** - Comparable implements the compareTo() method

It's common to use **Lambda syntax** for implementing Comparator interface.

## Example

Suppose we add weight to our Duck class:

```java
    public class Duck implements Comparable<Duck>{
        private String name;
        private int weight;
        public Duck(String name, int weight){
            this.name=name;
            this.weight=weight;
        }
        public String getName() { return name; }
        public int getWeight() { return weight; }
        public String toString() { return name; }
        public int compareTo(Duck d){
            return name.compareTo(d.name);
        }
    }
```

If we wish to override the sorting of Duck object, we can do this within the main method:

```java
public static void main(String[] args) {
    Comparator<Duck> byWeight = new Comparator<Duck>(){
        public int compare(Duck d1, Duck d2){
            return d1.getWeight()-d2.getWeight();
        }
    };
    List<Duck> ducks = new ArrayList<>();
    ducks.add(new Duck("Quack", 7));
    ducks.add(new Duck("Puddles", 10));
    System.out.println(ducks); [Puddles, Quack]
    Collections.sort(ducks, byWeight);
    System.out.println(ducks); // [Quack, Puddles]
}
```

We can see before the sorting, the ducks were sorted by name!

Then we used the comparator to sort the ducks by weight.

The Comparator was written with an inner class:

```java
Comparator<Duck> byWeight = new Comparator<Duck>(){
    public int compare(Duck d1, Duck d2){
        return d1.getWeight()-d2.getWeight();
    }
};
```

Since **Comparator is a functional interface**, we can rewrite it using lambda syntaxes:

```java
    Comparator<Duck> byWeight = (d1, d2) -> d1.getWeight() - d2.getWeight();
    Comparator<Duck> byWeight = (Duck d1, Duck d2) -> d1.getWeight() - d2.getWeight();
    Comparator<Duck> byWeight = (d1, d2) -> { return d1.getWeight()-d2.getWeight(); };
    Comparator<Duck> byWeight = (Duck d1, Duck d2) -> { return d1.getWeight()-d2.getWeight(); };
```

## Comparison between Comparable and Comparator

| **Difference**                                   | **Comparable** | **Comparator** |
|--------------------------------------------------|----------------|----------------|
| Package name                                     | java.lang      | java.util      |
| Interface must be implemented by Class comparing | Yes            | No             |
| Method name in interface                         | compareTo      | compare        |
| Number of parameters                             | 1              | 2              |
| Common to declare using lambda                   | No             | Yes            |


## Real World Scenario: An Easier Way of Comparing Multiple Fields

Comparator can be messy for multiple instance variables.

Suppose we have a Squirrel class where name can never be null:

```java
public class Squirrel {
    private int weight;
    private String species;
    public Squirrel(String theSpecies){
        if (theSpecies == null) throw new IllegalArgumentException();
        species = theSpecies;
    }
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight=weight;}
    public String getSpecies() { return species; }
}
```

**We want to write a Comparator to sort by species name. If same species, then sort by weight.**

We can achieve this with:

```java
public class MultiFieldComparator implements Comparator<Squirrel> {
    public int compate(Squirrel s1, Squirrel s2){
        int result = s1.getSpecies().compareTo(s2.getSpecies());
        if (result != 0) return result;
        return s1.getWeight()-s2.getWeight();
    }
}
```

This code is hard to read! Java has helper methods on Comparator:

```java
public class ChainingComparator implements Comparator<Squirrel> {
    public int compare(Squirrel s1, Squirrel s2){
        Comparator<Squirrel> c = Comparator.comparing(s -> s.getSpecies());
        c = c.thenComparingInt(s -> s.getWeight());
        return c.compare(s1,s2);
    }
}
```