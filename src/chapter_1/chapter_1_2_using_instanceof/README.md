<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 1.2 Using instanceof

* The expression `a instanceof ClassB` wil return true if:
 - the REFERENCE of `a` is an instance of `ClassB`
 - the REFERENCE of `a` is an instance of a subclass of `ClassB`
 - the REFERENCE of `a` is a class which implements `ClassB`

 * E.g.:

 ```java
class HeavyAnimal {}
class Hippo extends HeavyAnimal {}
class Elephant extends HeavyAnimal {}
// main method:
HeavyAnimal heavyAnimal = new HeavyAnimal();
HeavyAnimal hippo = new Hippo();
hippo instanceof HeavyAnimal; // true
hippo instanceof Hippo; // true
hippo instanceof Elephant; // false
 ```

* All objects will be an instance of `Object`, provided its not null:

```java
Hippo nullHippo = null;
System.out.println(nullHippo instanceof Object); // false
```

* we saw above that we could check if an instance of `Hippo` referenced by the superclass can be compared with Elephant, if we tried to compare an instance which was referenced through `Hippo`, then a compiler error will be created:

```java
Hippo hippo = new Hippo();
hippo instanceof Elephant; // COMPILER ERROR
```

* The `instanceof` operator is typically used to check if an instance is a specific subclass before casting it to the subtype