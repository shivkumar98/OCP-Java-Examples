# Encapsulation
- Encapsulation is a fundamental design principle.

**QUESTION:** What is encapsulation?

 **ANSWER:** This is the idea of combining fields and methods in a class so that they operate on data and not direct user input
 
 - This is achieved by using private instance members and public methods
 - Encapsulation means that the class has direct access to data and thus can invalidate incorrect data being supplied.
 - The class maintains INVARIANTS about its internal data,
  
## Example 1
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

## Example 2
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