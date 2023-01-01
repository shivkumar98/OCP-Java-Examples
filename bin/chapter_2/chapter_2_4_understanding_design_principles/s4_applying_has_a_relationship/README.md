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