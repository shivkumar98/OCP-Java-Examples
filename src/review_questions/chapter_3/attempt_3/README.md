<link href="../../../styles.css" rel="stylesheet"></link>

# Chapter 3: Review Questions Attempt 3

## Results:

Date: 22/07/2023
Score: 13/25

| Question # | Correct  |
| ---------- | -------  |
| 1          | ✅      |
| 2          | ❌      |
| 3          | ✅      |
| 4          | ✅      |
| 5          | ✅      |
| 6          | ❌      |
| 7          | ✅      |
| 8          | ❌      |
| 9          | ✅      |
| 10         | ❌      |
| 11         | ❌      |
| 12         | ❌      |
| 13         | ❌      |
| 14         | ✅      |
| 15         | ✅      |
| 16         | ✅      |
| 17         | ✅      |
| 18         | ❌      |
| 19         | ❌      |
| 20         | ❌      |
| 21         | ✅      |
| 22         | ❌      |
| 23         | ✅      |
| 24         | ❌      |
| 25         | ✅      |

<hr>

## Question 1

❓ Suppose you have a collection of products for sale in a database and you need to display those products. The products are not unique.

Which of the following collections classes in the `java.util` package best suit your need in this scenario? ❓🎃

    A. Arrays 🎃
    B. ArrayList 🎃
    C. HashMap 🎃
    D. HashSet 🎃
    E. LinkedList 🎃

### My Answer:

* **B** ✅ - Arrays is a utility class not a Collection
* We need anything other than Set, so D is out.
* An ArrayList would be best

## Question 2:

❓Suppose that you need to work with a collection of elements that need to be sorted in their natural order, and each element has a unique string associated with its value.

Which of the following collections classes in the `java.util` package best suit your need in this scenario? ❓ 

    A. ArrayList 🎃
    B. HashMap 🎃
    C. HashSet 🎃
    D. TreeMap 🎃
    E. TreeSet 🎃
    F. Vector 🎃

### My answer:

* **A** ❌ - correct answer: D. We need a map which is in its natural order so HashMap is invalid

* We can not use maps - so B and D are out
* We need sorting so C is out
* ArrayList would be best


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

### My answer:

* **E** ✅ - line 7 SHOULD loop though objects not strings
* Compiler error on line 7 from trying to cast Object to String

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

### My answer:
* **E** ✅ - since we are using push, the elements are added to the front.
* `[Hello, hi, ola]`
* `[Hello, hi]`
* hihello is printed

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

### My Answer:

* **B,C,F** ✅ 
* A does not
* B DOES
* C DOES
* D does not compile
* E does not compile
* F DOES

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

### My answer:

* **F** ❌ - The correct answer is C, the code DOES compile but there will be a compiler warning about not using generic! Line 7 just creates the class with type `Object`
* Compiler error on line 7, we need the generic specified!

<hr>

## Question 7:

❓ Which of the following statements are true for the following code: ❓ 

```java
    Set<Number> numbers = new HashSet<>();  // LINE 3
    numbers.add(new Integer(86));
    numbers.add(75);
    numbers.add(new Integer(86));
    numbers.add(null);
    numbers.add(309L);
    Iterator iter = numbers.iterator();     // LINE 9
    while (iter.hasNext())
        System.out.print(iter.next());   
```

A. The code compiles successfully 🎃

B. Output is `8675null309` 🎃

C. Output is `56758null309` 🎃

D. The output is intermediate 🎃

E. There's a compiler error on line 3 🎃

F. Compiler error on line 9 🎃

G. An exception is thrown 🎃

### My answer:
* **A,D** ✅
* HashSet does not preserve insertion order, so output is not defined.

<hr>

## Question 8:

❓ What is the result of the following code? ❓ 

```java
TreeSet<String> tree = new TreeSet<String>();
tree.add("one");
tree.add("One");
tree.add("ONE");
System.out.println(tree.ceiling("On"));
```

A. `On` 🎃

B. `one` 🎃

C. `One` 🎃

D. `ONE` 🎃

E. The code does not compile 🎃

F. An exception is thrown 🎃

### My answer:
* **B** ❌ - we need the lowest element which is greater than "On" which is "One"
* highest element which is lower than "On" - "one"

## Question 9:

❓ Which of the answer choices are valid given the following❓ 

```java
Map<String, Double> map = new HashMap<>();
```

A. 🎃
```java
map.add("pi", 3.14159);
```

B. 🎃

```java
map.add("e", 2L);
```

C. 🎃
```java
map.add("log(1)", new Double(0.0));
```

D. 🎃
```java
map.add('x', new Double(123.4));
```

E. None of the above 🎃

### My answer:

* **E** ✅ - `add()` is not a method for maps!

## Question 10:

❓ What is the result of the following: ❓ 

```java
import java.util.*;

public class MyComparator implements Comparator<String> {
    public int compare(String a, String b){
        return b.toLowerCase().compareTo(a.toLowerCase());
    }

    public void static main(String[] args){
        String[] values = { "123", "Abb", "aab" };
        Arrays.sort(values, new MyComarator());
        for (String s:values)
            System.out.print(s + " ");
    }
}
```

A. `Abb aab 123` 🎃

B. `aab Abb 123` 🎃

C. `123 Abb aab` 🎃

D. `123 aab Abb` 🎃

E. The code does not compile 🎃

F. A runtime exception is thrown 🎃

### My answer:
* **B** ❌ - answer is A! the sorting is done in a case insensitive fashion so abb > aab > 123
* reversed sorting. so `aab > Abb > 123`



## Question 11:

❓ What is the result of the following: ❓ 

```java
    Map<Integer, Integer> map = new HashMap<>(10);  // LINE 3
    for (int i = 1; i <=10; i++) {                  
        map.put(i, i*i);                            // LINE 5
    }                           
    System.out.println(map.get(4));                 // LINE 7
```

A. `16` 🎃

B. `25` 🎃

C. Compiler error on line 3 🎃

D. Compiler error on line 5 🎃

E. Compiler error on line 7 🎃

F. A runtime exception is thrown 🎃

### My Answer:
* **B** ❌ - the `get()` method on maps uses an object so 4 is casted to Integer and 4 is mapped to 16!
* Gets element at index 4, so 25


## Question 12:

❓ Which of the following statements fill in the blank so Helper compiles successfully ❓ 

```java
public class Helper {
    public static <U extends Exception> void printException(U u){
        System.out.println(u.getMessage());
    }
    public static void main(String[] args){
        ______________________
    }
}
```

A. 🎃
```java
Helper.printException(new FileNotFoundException("A"))
```

B. 🎃
```java
Helper.printException(new Exception("B"))
```

C. 🎃
```java
Helper.<Throwable>printException(new Exception("C"))
```

D. 🎃
```java
Helper.<NullPointerException>printException(new NullPointerException("D"))
```

E. 🎃
```java
Helper.printException(new Throwable("E"))
```

### My answer:
* **A,B**  ❌ Correct answer is A,B,D 0 D us explicitly listing the type
* A - works
* B - works



## Question 13:

❓ Which of these statements can fill in the blank so that the WildCard class compiles successfully ❓ 

```java
import java.util.*;

public class WildCard {
    public void showSize(List<?> list) {
        System.out.println(list.size());
    }
    public static void main(String[] args){
        Wildcard card = new WildCard();
        ________________
        card.showSize(list);
    }
}
```

A. 🎃
```java
ArrayDeque<?> list = new ArrayDeque<String>();
```

B. 🎃
```java
ArrayList<? super Date> list = new ArrayList<Date>();
```

C. 🎃
```java
List<?> list = new ArrayList<?>();
```

D. 🎃
```java
List<Exception> list = new LinkedList<java.io.IOException>();
```

E. 🎃
```java
Vector<? extends Number> list = new Vector<Integer>();
```

F. None of the above 🎃


### My answer:
* **A,B,E**❌ - correct anwser B, E. A is a queue and not a list so does not have `size()`
* A - compiles
* B - compiles
* C - does not compile
* D - does not compile
* E - compiles
* F - no


## Question 14:

❓ What is the result of the following program ❓ 

```java
    import java.util.*;
    public class Sorted implements Comparable<Sorted>, Comparator<Sorted> {
        private int num;
        private String text;

        Sorted(int n, String t) {
            this.num = n;
            this.text = t;
        }
        public String toString() { return ""+num; }
        public int compareTo(Sorted s){ return text.compareTo(s.text); }
        public int compare(Sorted s1, Sorted s2) { return s1.num - s2.num; }
        public static void main(String[] args) {
            Sorted s1 = new Sorted(88, "a");
            Sorted s2 = new Sorted(55, "b");
            TreeSet<Sorted> t1 = new TreeSet<>();
            t1.add(s1); t1.add(s2);
            TreeSet<Sorted> t2 = new TreeSet<>(s1);
            t2.add(s1); t2.add(s2);
            System.out.println(t1 + " " + t2);

        }
    }
```

A. `[55, 88] [55, 88]` 🎃

B. `[55, 88] [88, 55]` 🎃

C. `[88, 55] [55, 88]` 🎃

D. `[88, 55] [88, 55]` 🎃

E. The code does not compile 🎃

F. A runtime exception is thrown 🎃

### My Answer:
* **C**✅
* T1 is naturally sorted by the text. so a < b,. so [88, 55]
* T2 is sorted by number so  b < a. So [55, 88]


## Question 15:

❓ What is the result of the following code? ❓ 

```java
    Comparatator<Integer> c = (o1, o2) -> o2-o1;
    List<Integer> list = Arrays.asList(5, 4, 7, 1);
    Collections.sort(list, c);
    System.out.println(Collections.binarySearch(list, 1))
```

A. `0` 🎃

B. `1` 🎃

C. `2` 🎃

D. The result is undefined 🎃

E. The code does not compile 🎃

F. A runtime exception is thrown 🎃

### My answer:
* **D**✅ - gets sorted in descending order!

## Question 16:

❓ Which of the following statements are true? ❓ 

A. Comparable is in the java.util package 🎃

B. Comparator is in the java.util package 🎃

C. `compare()` is in the Comparable interface 🎃

D. `compare()` is in the Comparator interface 🎃

E. `compare()` takes one method parameter 🎃

F. `compare()` takes two method parameters 🎃

### My answer:
* **B, D, F** ✅
* Comparator is in java.util, Comparable is in java.lang.


## Question 17:

❓ Which two options can fill in the blanks so the code compiles ❓

```java
    public class Generic_____ {                     // LINE 1
        public static void main(String[] args){
            Generic<String> g = new Generic_____();  // LINE 3
            Generic<Object> g2 = new Generic();
        }
    }
```


A. Fill Line 1 with `<>` 🎃

B. Fill Line 1 with `<T>` 🎃

C. Fill Line 1 with `<?>` 🎃

D. Fill Line 3 with `<>` 🎃

E. Fill Line 3 with `<T>` 🎃

F. Fill Line 3 with `<?>` 🎃

### My answer:

* **B, D** ✅


## Question 18:

❓ Which of the following line can be inserted to make code compile? ❓

```java
class A {}
class B extends A {}
class C extends B {}

class D<C> {
    // INSERT CODE HERE
}
```

A. `A a1 = new A();` 🎃

B. `A a2 = new B();` 🎃

C. `A a3 = new C();` 🎃

D. `C c1 = new A();` 🎃

E. `C c2 = new B();` 🎃

F. `C c1 = new C();` 🎃

### My answer:
* ***A,B,C** ❌ - C no longer means class C so only A and B are valid!
* A - valid
* B - valid
* C - valid
* D - invalid
* E - invalid
* F - valid


##  Question 19:

❓ Which options are true of the following code? ❓

```java
    _______<Integer> q = new LinkedList<>();
    q.add(10);
    q.add(12);
    q.remove(1);
    System.out.println(q);
```

A. If we fill in the blank with `List`, the output is `[10]` 🎃

B. If we fill in the blank with `List`, the output is `[10, 12]` 🎃

C. If we fill in the blank with `Queue`, the output is `[10]` 🎃

D. If we fill in the blank with `Queue`, the output is `[10, 12]` 🎃

E. The code does not compile in either scenario 🎃

F. A runtime exception is thrown 🎃

### My answer:
* **C** ❌ - correct answer is A and D! Queues have a remove() method which takes an object not index!
* A - false
* B - false
* C - true
* D - false
* E - false
* F false

##  Question 20:

❓ What is the result of the following code? ❓

```java
    Map m = new HashMap();                  // LINE 4
    m.put(123, "456");                      // LINE 5
    m.put("abc", "def");                    
    System.out.println(m.contains("123"));  // LINE 7
```

A. `false` 🎃

B. `true` 🎃

C. Compiler error on line 4 🎃

D. Compiler error on line 5 🎃

E. Compiler error on line 7 🎃

F. A runtime exception is thrown 🎃

### My answer:

* **A**❌ - Maps do not have a `contains()` method!!!

##  Question 21:

❓ Fill in the blanks to make this code compile and print `123`❓

```java
    List<String> list = Arrays.asList("1", "2", "3");
    Iterator iter = list.iterator();
    while (iter.______())
        System.out.println(iter._____());
```

A. On line 6, fill blank with `hasNext()` 🎃

B. On line 6, fill blank with `isNext()` 🎃

C. On line 6, fill blank with `next()` 🎃

D. On line 7, fill blank with `getNext()` 🎃

E. On line 7, fill blank with `hasNext()` 🎃

F. On line 7, fill blank with `next()` 🎃

### My answer:

* **A, F**✅

## Question 22:

❓ What code change is needed to make the method compile? ❓

```java
    public static T identity(T t){
        return t;
    }
```

A. Add `<T>` after the public keyword 🎃

B. Add `<T>` after the static keyword 🎃

C. Add `<T>` after T 🎃

D. Add `<?>` after the public keyword 🎃

E. Add `<?>` after the static keyword 🎃

F. No change required the code already compiles 🎃

### My answer:

* **A, B**❌ - correct answer is B - the generic specification goes before return type

## Question 23:

❓ Which of the answer make sense to implement with lambda (choose all which apply) ❓

A. Comparable interface 🎃

B. Comparator interface 🎃

C. remove() method on Collection 🎃

D. removeAll() method on a Collection 🎃

E. removeIf() method on a Collection 🎃

### My answer:
* **B,E**✅
* B is valid
* C - makes no sense
* D - makes no sense
* E is valid


## Question 24:

❓ Which of the following compiles and prints out the entire set?❓

```java
    Set<String> s = new HashSet<>();
    s.add("lion");
    s.add("tiger");
    s.add("bear");
    s.forEach(________);
```

A. 🎃
```java
() -> System.out.println(s)
```

B. 🎃
```java
s -> System.out.println(s)
```

C. 🎃
```java
(s) -> System.out.println(s)
```

D. 🎃
```java
System.out.println(s)
```

E. 🎃
```java
System::out::println
```

F. 🎃
```java
System.out::println
```

### My Answer:
* **B,C,F**❌ B and C are wrong because they use `s` in the lambda! Only F is valid!!!
* A-invalid, B-valid,C-valid, F-valid

## Question 25:

❓ What is the result of the following? ❓

```java
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 10);
    map.put(2, 20);
    map.put(3, null);

    map.merge(1, 3, (a,b)-> a + b);
    map.merge(3, 3 (a,b) -> a + b);

    System.out.println(map);
```

A. {1=10, 2=20} 🎃

B. {1=10, 2=20, 3=null} 🎃

C. {1=10, 2=20, 3=3} 🎃

D. {1=13, 2=20} 🎃

E. {1=13, 2=20, 3=null} 🎃

F. {1=13, 2=20, 3=3} 🎃

G. The code does not compile 🎃

H. An exception is thrown 🎃

### My answer:
* **F**✅
* 1 is mapped to 13
* 3 is mapped to 3
* 2 sticks to 20