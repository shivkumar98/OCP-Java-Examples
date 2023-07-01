<link href="../../styles.css" rel="stylesheet"></link>

# 🟪 4.6 Working with Advanced Stream Pipeline Concepts

## 📜 Contents 📜

- [🌸 Introduction 🌸]()
- [🔴 4.6.1 Linking Streams to the Underlying Data ]()
- [🔴 4.6.2 Chaining Optionals]()
- [🔴 4.6.3 Collecting Results]()


## 🌸 Introduction 🌸

* Here we will see thew relationship between streams and underlying data, chaining Optional and grouping collectors.

## 🔴 4.6.1 Linking Streams to the Underlying Data

* What do you think the following outputs

```java
List<String> cats = new ArrayList<>();
cats.add("Annie");
cats.add("Ripley");
Stream<String> stream = cats.stream(); // LINE 28
cats.add("KC");
System.out.println(stream.count());
```

* My answer: 2❌

* The correct answer is 3✅ Streams are lazily-evaluated, which means the stream is not actually created on line 28! The final line where we evaluate `stream.count()` is only where the Stream is created!


## 🔴 4.6.2 Chaining Optionals

* Optionals have a few intermediate stream operations.  

* ❓Suppose you are given an `Optional<Integer>` and asked to print the value, ONLY IF its a 3 digit method❓

* WITHOUT functional programming, it could be done as:

```java
private static void threeDigit(Optional<Integer> optional) {
    if (optional.isPresent()) {
        Integer num = optional.get();
        String str = "" + num;
        if (str.length()==3)
            System.out.println(str)
    }
}
```

* WITH functional programming:

```java
private static void threeDigit(Optional<Integer> optional) {
    optional.map(n->""+n)
            .filter(s->s.length()==3)
            .ifPresent(System.out::println);
}
```

* Suppose we have the following method:

```java
public class ChainingOptionals {
	static Optional<Integer> calculator(String s){
		return Optional.of(1);
	}
}
```

* and suppose we have an `Optional<Integer>` storing the length of an optional String:

```java
Optional<String> optional = Optional.of("Shiv");
// we map the to lengths:
Optional<Integer> result = optional.map(String::length);
```

* We can NOT write the following:

```java
Optional<Integer> result2 = optional.map(ChainingOptionals::calculator);  // ^^ DOES NOT COMPILE
```

* We can however write the following:

```java
Optional<Optional<Integer>> result2 = optional.map(ChainingOptionals::calculator);
```

* To get what we want we can call `flatMap()`:

```java
Optional<Integer> result optional.flatMap(ChainingOptionals::calculator);
```

### ⭐ Checked exceptions and Functional interfaces ⭐

* What if the method we have a method which throws an exception:

```java
class ExceptionCaseStudy {
    private static List<String> create() throws IOException {
        throw new IOException();
    }
}
```

* We can use it within a stream: `ExceptionCaseStudy.create().stream().count();`

* However we can not write the following without a compiler error:

```java
Supplier<List<String>> s = ExceptionCaseStudy::create; // DOES NOT COMPILE
```

* We can create a wrapper method with a try/catch:

```java
class ExceptionCaseStudy {
    private static List<String> create() throws IOException { /**/ }
    private static List<String> createSafe() {
        try {
            return ExceptionCaseStudy.create();
        } catch (IOException e) {
            throw new RunTimeException();
        }
    }
}
```

* Here is the safe wrapper version:

```java
Supplier<List<String>> s2 = ExceptionCaseStudy::createSafe;
```