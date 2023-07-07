<link href="../../styles.css" rel="stylesheet"></link>

# Revision Notes

# 🧠 4.1 Using Variables in Lambdas


* If you can add `final` to a variable without problems, then it is effectively final. Lambdas are inner classes and thus have the same rules

* Lambdas can access static + instance variables, effectively final method parameters, and effectively final local variables.

### 🟡 Example:

* How many accessible variables are there?

```java
interface Gorilla { String move(); }
class GorillaFamily {
    String walk = "walk";
    void everyonePlay(boolean baby) {
        String approach = "amble";
        
        play(() -> walk); // here
        play(() -> baby ? "hitch a ride" : "run"); // here
        play(() -> approach); // here
    }
    void play(Gorilla g){
        System.out.println(g.move());
    }
}
```

#### 