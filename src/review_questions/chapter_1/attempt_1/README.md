# Chapter 2 - Review Questions Attempt 1

## Results:

Date: 
Score: /20

| Question # | Correct  |
| ---------- | -------  |
| 1          |       |
| 2          |       |
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
| 20         |      |

## Question 1

❓What is the result of the following code❓

```java
public class Employee {
    public int employeeId;
    public String firstName, lastName;
    public int yearStarted;
    @Override public int hashCode() {
        return employeeId;
    }
    public boolean equals(Employee e) {
        return this.employeeId = e.employeeId;
    }
    public static void main() {
        Employee one = new Employee();
        one.employeeId = 101;
        Employee two = new Employee();
        two.employeeId = 101;
        if (one.equals(two)) System.out.println("Success")
        else System.out.println("Failure");
    }

}
```

    A. Success🎃
    B. Failure🎃
    C. The hashCode() method fails to compile🎃
    D. The equals() method fails to compiler🎃
    E. Another line fails to compile🎃
    F. A runtime exception is thrown🎃

### My Answer:
*  I THINK it will return failure as it doesn't override the correct method in Object class
* **B**

<hr>



## Question 2
❓What is the result of the following code❓

```java
public class Book {
    private int ISBN;
    private String title, author;
    private int pageCount;
    public int hashCode() {
        return ISBN;
    }
    @Override public boolean equals(Object obj) {
        if (!(obj instanceof Book)){
            return false;
        }
        Book other = (Book) obj;
        return this.ISBN == obj.ISBN;
    }
    // imagine setters and getters
}
```

    A. The code compiles🎃
    B. The code does not compile because hashCode() is incorrect🎃
    C. The code does not compile because equals() does not override the parent method correctly🎃
    D. The code does not compile because equals() tries to refer to a private field🎃
    E. The code does not compile because the ClassCastException is not handled or declared🎃
    F. The code does not compile for another reason🎃

### My Answer:

* A - IDK
* B - false, the hashCode method is fine
* C - false, the class DOES override the right method
* D - false, you CAN access private fields
* E - false, casting is fine!
* F - I can't see why this won't compile

<hr>

## Question 3

❓What is the result of the following code❓

```java
String s1 = "Canada";
String s2 = new String(s1);
if (s1 == s2) System.out.println("s1 == s2");
if (s1.equals(s2)) System.out.println("s1.equals(s2)");
```

    A. There is no output 🎃
    B. s1 == s2 🎃
    C. s1.equals(s2) 🎃
    D. Both B and C🎃
    E. The code does not compile🎃
    F. The code throws a runtime exception🎃

### My Answer:

* s1 == s2 is false as we have instantiate a brand new string but the second if statement returns true
* **C**

<hr>

## Question 4
❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>


## Question 5

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 6

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 7

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 8

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 9

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>


## Question 10

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 12

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 13

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 14

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 15

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 16

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 17

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 18

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 19

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>

## Question 20

❓What is the result of the following code❓

    A. 🎃
    B. 🎃
    C. 🎃
    D. 🎃
    E. 🎃
    F. 🎃

### My Answer:

<hr>