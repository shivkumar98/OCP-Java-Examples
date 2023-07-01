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