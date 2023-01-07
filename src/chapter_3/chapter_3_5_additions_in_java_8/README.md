# 3.5 Additions in Java 8

Everything seen previously was not unique to Java 8.

This section will focus on streams.

We will see how to use the new removeIf(), forEach(), merge(), computeIfPresent(), and computeIfAbsent() methods

# 1 Using Methof References

We can make code more compact using method references - simply mentioning the method name.

## Example: Using Method References to Sort

Suppose we have a Duck class with name, weight attributes.

Here is a helper class:

    public class DuckHelper {
        public static int compareByWeightr(Duck d1, Duck s2){
            return d1.getWeight()-d2.getWeight();
        }
        public static int compareByName(Duck d1, Duck d2){
            return d1.getName().compareToo(d2.getName());
        }
    }

We coiuld write a Comparator for sorting by weight:

    Comparator<Duck> byWeight = (d1,d2) -> DuckHelper.compareByWeight(d1,d2);

This is alot of redundant code!

**Java 8 has method references:**

    Compator<Duck> byWeight = DuckHelper::compareByWeight;

The : : operator instructs Java to pass the parameters tgo compareByWeight automatically. 

There are 4 formats for method references:

* Static methods
* Instance methods on a particular instance
* Instance methods on an instance to be determined at runtime
* Constructors

**Predicate takes one input and returns one output.**

**Consumer takes one input and has void return.**

**Supplier has no parameters and returns any type.**

## Static Methods:

    Consumer<List<Integer>> methodRef1 = Collections:: sort;
    Consumer<List<Integer>> lambda1 = l -> Collections.sort(l)

Top line infers which sort method to call based on context! We are using the Consumer so it looks for the implementation which only accepts one argument

## Instance methods on a particular instance:

    String str = "abc";
    Predicate<String> methodRef2 = String::startsWith;
    Predicate<String> lambda2 = s -> str.startsWith(s);

The top line calls the String.startsWith() method with a single parameter.

## Instance Method without knowling at runtime:

    Predicate<String> methodRef3 = String::startsWith;
    Predicate<String> lambda3 = s -> s.isEmpty();

## Constructors:

    Supplier<ArrayList> method4 = ArrayList::new;
    Supplier<ArrayList> lambda4 = () -> new ArraayList();

# 2 Removing Conditionally

Java 8 introduces removeIf, method signature looks like:

    boolean removeIf(Predicate<? super E> filter)

## Example: Using removeIf

    List<String> list = new ArrayList<>();
    