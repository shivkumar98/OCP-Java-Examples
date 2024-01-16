# Chapter 3 - Review Questions Attempt #

## Results:

Date: 
Score: 

| Question # | Correct  |
| ---------- | -------  |
| 1          | ✅      |
| 2          | ❌      |
| 3          |       |
| 4          |       |
| 5          |       |
| 6          |       |
| 7          |       |
| 8          |       |
| 9          |       |
| 10         |       |
| 11         |       |
| 12         |       |
| 13         |       |
| 14         |       |
| 15         |       |
| 16         |       |
| 17         |       |
| 18         |       |
| 19         |       |
| 20         |       |
| 21         |       |
| 22         |       |
| 23         |       |
| 24         |       |
| 25         |       |

## Question 1

❓ Suppose you have a collection of products for sale in a database and you need to display those products. The products are not unique.

Which of the following collections classes in the `java.util` package best suit your need in this scenario? ❓

A. Arrays <br>
B. ArrayList <br>
C. HashMap <br>
D. HashSet <br>
E. LinkedList <br>

### My Answer:

<br>

<hr>

## Question 2:

❓Suppose that you need to work with a collection of elements that need to be sorted in their natural order, and each element has a unique string associated with its value.
<br>

Which of the following collections classes in the `java.util` package best suit your need in this scenario? ❓ 

A. ArrayList <br>
B. HashMap <br>
C. HashSet <br>
D. TreeMap <br>
E. TreeSet <br>
F. Vector <br>

### My Answer:

<br>

<hr>

## Question 3:
❓ What is the result of the following statements? ❓ 
```java
3:   List list = new ArrayList();
4:   list.add("one");
5:   list.add("two");
6:   list.add(7);        
7:   for (String s: list)
8:   System.out.println(s);
```

A. `onetwo` <br>
B. `oneTwo7` <br>
C. `onetwo` followed by an exception <br>
D. Compiler error on line 6 <br>
E. Compiler error on line 7 <br>

### My Answer:

<br>

<hr>

## Question 4:
❓ What is the result of the following? ❓ 
```java
3:    ArrayDeque<String> greetings = new ArrayDeque<String>();
4:    greetings.push("hello");
5:    greetings.push("hi");
6:    greetings.push("ola");
7:    greetings.pop();
8:    greetings.peek();
9:    while(greetings.peek() != null)
10:       System.out.println(greetings.pop());
```

A. `hello` <br>
B. `hellohi` <br>
C. `hellohiola` <br>
D. `hi` <br>
E. `hihello` <br>
F. The code does not compile <br>
G. An exception is thrown <br>

### My Answer:

<br>

<hr>

## Question 5:
❓ Which of the statements compile? (Choose all that apply) ❓ 

A. `HashSet<Number> hs = new HashSet<Integer>();`
B. `HashSet<? super ClassCastException> set = new HashSet<Exception>()`
C. `List<String> list = new Vector<String>();`
D. `List<Object> values = new HashSet<Object>();`
E. `List<Object> objects = new ArrayList<? extends Object>();`
F. `Map<String, ? extends Number> hm = new HashMap<String, Integer>();`

### My Answer:

<br>

<hr>

## Question 6:

❓ What is the result of the following code: ❓ 
```java
1:  public class Hello<T> {
2:      T t;
3:      public Hello(T t) { this. t = t };
4:      public String toString() { return t.toString() };   
5:      public static void main(String[] args){
6:          System.out.print(new Hello<String>("hi"));    
7:          System.out.print(new Hello("there"));         
8:      }
9:  }
```

A. `hi` <br>
B. `hi` followed by a runtime exception <br>
C. `hithere` <br>
D. Compiler error on line 4 <br>
E. Compiler error on line 6 <br>
F. Compiler error on line 7 <br>

### My Answer:

<br>

<hr>

## Question 7:
❓ Which of the following statements are true for the following code (Select two) ❓ 
```java
3:  Set<Number> numbers = new HashSet<>(); 
4:  numbers.add(new Integer(86));
5:  numbers.add(75);
6:  numbers.add(new Integer(86));
7:  numbers.add(null);
8:  numbers.add(309L);
9:  Iterator iter = numbers.iterator(); 
10: while (iter.hasNext())
11:     System.out.print(iter.next());   
```

A. The code compiles successfully <br>
B. Output is `8675null309` <br>
C. Output is `56758null309` <br>
D. The output is intermediate <br>
E. There's a compiler error on line 3 <br>
F. Compiler error on line 9 <br>
G. An exception is thrown <br>

### My Answer:

<br>

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

A. `On` <br>
B. `one` <br>
C. `One` <br>
D. `ONE` <br>
E. The code does not compile <br>
F. An exception is thrown <br>

### My Answer:

<br>

<hr>

## Question 9:
❓ Which of the answer choices are valid given the following❓ 
```java
Map<String, Double> map = new HashMap<>();
```
A. `map.add("pi", 3.14159);`
B. `map.add("e", 2L);`
C. `map.add("log(1)", new Double(0.0));`
D. `map.add('x', new Double(123.4));`
E. None of the above 🎃

### My Answer:

<br>

<hr>

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
        Arrays.sort(values, new MyComparator());
        for (String s:values)
            System.out.print(s + " ");
    }
}
```

A. `Abb aab 123` <br>
B. `aab Abb 123` <br>
C. `123 Abb aab` <br>
D. `123 aab Abb` <br>
E. The code does not compile <br>
F. A runtime exception is thrown <br>

### My Answer:

<br>

<hr>

## Question 11:
❓ What is the result of the following: ❓ 
```java
3:    Map<Integer, Integer> map = new HashMap<>(10);  
4:    for (int i = 1; i <=10; i++) {                 
5:        map.put(i, i*i);                            
6:    }                           
7:    System.out.println(map.get(4));                 
```

A. `16` <br>
B. `25` <br>
C. Compiler error on line 3 <br>
D. Compiler error on line 5 <br>
E. Compiler error on line 7 <br>
F. A runtime exception is thrown <br>

### My Answer:

<br>

<hr>

## Question 12:
❓ Which of the following statements fill in the blank so Helper compiles successfully (Choose all that apply) ❓ 
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
A. `Helper.printException(new FileNotFoundException("A"))`
B. `Helper.printException(new Exception("B"))`
C. `Helper.<Throwable>printException(new Exception("C"))`
D. `Helper.<NullPointerException>printException(new NullPointerException("D"))`
E. `Helper.printException(new Throwable("E"))`

### My Answer:

<br>

<hr>

## Question 13:
❓ Which of these statements can fill in the blank so that the WildCard class compiles successfully (Choose all that apply) ❓ 
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

A. `ArrayDeque<?> list = new ArrayDeque<String>();` <br>
B. `ArrayList<? super Date> list = new ArrayList<Date>()` <br>
C. `List<?> list = new LinkedList<java.io.IOException>();` <br>
D. `List<Exception> list = new LinkedList<java.io.IOException>();` <br>
E. `Vector<? extends Number> list = new Vector<Integer>();` <br>
F. None of the above <br>

### My Answer:

<br>

<hr>

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

A. `[55, 88] [55, 88]` <br>
B. `[55, 88] [88, 55]` <br>
C. `[88, 55] [55, 88]` <br>
D. `[88, 55] [88, 55]` <br>
E. The code does not compile <br>
F. A runtime exception is thrown <br>

### My Answer:

<br>

<hr>

## Question 15:
❓ What is the result of the following code? ❓ 
```java
Comparatator<Integer> c = (o1, o2) -> o2-o1;
List<Integer> list = Arrays.asList(5, 4, 7, 1);
Collections.sort(list, c);
System.out.println(Collections.binarySearch(list, 1))
```

A. `0` <br>
B. `1` <br>
C. `2` <br>
D. The result is undefined <br>
E. The code does not compile <br>
F. A runtime exception is thrown <br>

### My Answer:

<br>

<hr>

## Question 16:

❓ Which of the following statements are true? (Choose all that apply)❓ 

A. Comparable is in the java.util package <br>
B. Comparator is in the java.util package <br>
C. `compare()` is in the Comparable interface <br>
D. `compare()` is in the Comparator interface <br>
E. `compare()` takes one method parameter <br>
F. `compare()` takes two method parameters <br>

### My Answer:

<br>

<hr>

## Question 17:

❓ Which two options can fill in the blanks so the code compiles (Choose all that apply) ❓

```java
1: public class Generic_____ {                     
2:     public static void main(String[] args){
3:         Generic<String> g = new Generic_____(); 
4:         Generic<Object> g2 = new Generic();
5:     }
6: }
```

A. Fill Line 1 with `<>` <br>
B. Fill Line 1 with `<T>` <br>
C. Fill Line 1 with `<?>` <br>
D. Fill Line 3 with `<>` <br>
E. Fill Line 3 with `<T>` <br>
F. Fill Line 3 with `<?>` <br>

### My Answer:

<br>

<hr>

## Question 18:

❓ Which of the following line can be inserted to make code compile? (Choose all that apply)❓
```java
class A {}
class B extends A {}
class C extends C {}

class D<C> {
    // INSERT CODE HERE
}
```

A. `A a1 = new A();` <br>
B. `A a2 = new B();` <br>
C. `A a3 = new C();` <br>
D. `C c1 = new A();` <br>
E. `C c2 = new B();` <br>
F. `C c1 = new C();` <br>

### My Answer:

<br>

<hr>

##  Question 19:

❓ Which options are true of the following code? (Choose all that apply) ❓
```java
3:  _______<Integer> q = new LinkedList<>();
4:  q.add(10);
5:  q.add(12);
6:  q.remove(1);
7:  System.out.println(q);
```

A. If we fill in the blank with `List`, the output is `[10]` <br>
B. If we fill in the blank with `List`, the output is `[10, 12]` <br>
C. If we fill in the blank with `Queue`, the output is `[10]` <br>
D. If we fill in the blank with `Queue`, the output is `[10, 12]` <br>
E. The code does not compile in either scenario <br>
F. A runtime exception is thrown <br>

### My Answer:

<br>

<hr>

##  Question 20:

❓ What is the result of the following code? ❓
```java
4:  Map m = new HashMap();                  
5:  m.put(123, "456");                      
6:  m.put("abc", "def");                   
7:  System.out.println(m.contains("123"));  
```

A. `false` <br>
B. `true` <br>
C. Compiler error on line 4 <br>
D. Compiler error on line 5 <br>
E. Compiler error on line 7 <br>
F. A runtime exception is thrown <br>

### My Answer:

<br>

<hr>


##  Question 21:

❓ Fill in the blanks to make this code compile and print `123` (Choose all that apply) ❓

```java
4:    List<String> list = Arrays.asList("1", "2", "3");
5:    Iterator iter = list.iterator();
6:    while (iter.______())
7:        System.out.println(iter._____());
```

A. On line 6, fill blank with `hasNext()` <br>
B. On line 6, fill blank with `isNext()` <br>
C. On line 6, fill blank with `next()` <br>
D. On line 7, fill blank with `getNext()` <br>
E. On line 7, fill blank with `hasNext()` <br>
F. On line 7, fill blank with `next()` <br>

### My Answer:

<br>

<hr>


## Question 22:

❓ What code change is needed to make the method compile? ❓
```java
public static T identity(T t){
    return t;
}
```
A. Add `<T>` after the public keyword <br>
B. Add `<T>` after the static keyword <br>
C. Add `<T>` after T <br>
D. Add `<?>` after the public keyword <br>
E. Add `<?>` after the static keyword <br>
F. No change required the code already compiles <br>

### My Answer:

<br>

<hr>



## Question 23:

❓ Which of the answer make sense to implement with lambda (choose all which apply) ❓

A. Comparable interface <br>
B. Comparator interface <br>
C. remove() method on Collection <br>
D. removeAll() method on a Collection <br>
E. removeIf() method on a Collection <br>

### My Answer:

<br>

<hr>



## Question 24:
❓ Which of the following compiles and prints out the entire set? (Choose all that apply)❓
```java
Set<String> s = new HashSet<>();
s.add("lion");
s.add("tiger");
s.add("bear");
s.forEach(________);
```

A. `() -> System.out.println(s)` <br>
B. `s -> System.out.println(s)` <br>
C. `(s) -> System.out.println(s)` <br>
D. `System.out.println(s)` <br>
E. `System::out::println` <br>
F. `System.out::println` <br>

### My Answer:

<br>

<hr>


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

A. {1=10, 2=20} <br>
B. {1=10, 2=20, 3=null} <br>
C. {1=10, 2=20, 3=3} <br>
D. {1=13, 2=20} <br>
E. {1=13, 2=20, 3=null} <br>
F. {1=13, 2=20, 3=3} <br>
G. The code does not compile <br>
H. An exception is thrown <br>


### My Answer:

<br>

<hr>