# Chapter 3: Review Questions

## Question 1

❓ Suppose you have a collection of products for sale in a database and you need to display those products. The products are not unique.

Which of the following collections classes in the `java.util` package best suit your need in this scenario? ❓🎃

    A. Arrays 🎃
    B. ArrayList 🎃
    C. HashMap 🎃
    D. HashSet 🎃
    E. LinkedList 🎃

My Answer: `D`

- We need to display each product but exclude duplicates. This would suggest a set. Hence HashSet seems applicable

## Question 2:

❓Suppose that yuou need to work with a collection of elements that need to be sorted in their natural order, and each element has a unique string associated with its value.

Which of the following collections classes in the `java.util` package best suit your need in this scenario? ❓ 

    A. ArrayList 🎃
    B. HashMap 🎃
    C. HashSet 🎃
    D. TreeMap 🎃
    E. TreeSet 🎃
    F. Vector 🎃

My Answer: `D`

- We need a key-value mapping so it is a map
- Since we need a natural ordering, we need a TreeMap

## Question 3:

❓ What is the result of the following statements? ❓ 

```java
    List list = new ArrayList();
    list.add("one");
    list.add("two");
    list.add(7);            // LINE 6
    for (String s: list)    // LINE 7
    System.out.println(s);
```

    A. `onetwo` 🎃
    B. `oneTwo7` 🎃
    C. `onetwo` followed by an exception 🎃
    D. Compiler error on line 6 🎃
    E. Compiler error on line 7 🎃

My answer: `D`

- I think line 7 will cause an error!

## Question 4:

❓ What is the result of the following? ❓ 

```java
    ArrayDeque<String> greetings = new ArrayDeque<String>();
    greetings.push("hello");
    greetings.push("hi");
    greetings.push("ola");
    greetings.pop();
    greetings.peek();
    while(greetings.peek() != null)
        System.out.println(greetings.pop);
```

    A. `hello` 🎃
    B. `hellohi` 🎃
    C. `hellohiola` 🎃
    D. `hi` 🎃
    E. `hihello` 🎃
    F. The code does not compile 🎃
    G. An exception is thrown 🎃

My answer: `E`

## Question 5:

❓ Which of the statements compile? (Choose all that apply) ❓ 

A. 🎃
```java
HashSet<Number> hs = new HashSet<Integer>();
```

B. 🎃

```java
HashSet<? super ClassCastException> set = new HashSet<Exception>()
```

C. 🎃
```java
List<String> list = new Vector<String>();
```

D. 🎃
```java
List<Object> values = new HashSet<Object>();
```

E. 🎃
```java
List<Object> objects = new ArrayList<? extends Object>();
```

F. 🎃
```java
Map<String, ? extends Number> hm = new HashMap<String, Integer>();
```

My answer: `C`

- A does not seem to compile as the generics do not match

- B would not compile due to generic does not match

- C does compile as List is an interface of Vector

- D does not compile as List is not a interface/superclass of Vector

- E does not compile due to generic mismatch

- F again does not compile due to generic mismatch

## Question 6:

❓ What is the result of the following code: ❓ 

```java
    public class Hello<T> {
        T t;
        public Hello(T t) { this. t = t };
        public String toString() { return t.toString() };   // LINE 4
        public static void main(String[] args){
            System.out.println(new Hello<String>("hi"));    // LINE 6
            System.out.println(new Hello("there"));         // LINE 7
        }
    }
```

A. `hi` 🎃

B. `hi` followed by a runtime exception 🎃

C. `hithere` 🎃

D. Compiler error on line 4 🎃

E. Compiler error on line 6 🎃

F. Compiler error on line 🎃

My answer: `C`


## Question 7:

