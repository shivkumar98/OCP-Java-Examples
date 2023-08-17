<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 1.7 Creating Nested Classes

## 🔴 1.7.1 Member Inner Classes
* This class is defined on MEMBER level, so it can be private, protected, public or default access.
* It has access to outer private methods
* It can be marked `abstract` or `final`
* Can not DECLARE static fields or methods
* E.g.
```java
public class Outer {
    private String greeting = "hello";
    class Inner {
        void foo() {
            System.out.println(greeting);
        }
    }
    void callInner() {
        Inner inner = new Inner();
        inner.go();
    }
    main() {
        Outer outer = new Outer();
        outer.callInner();
        Inner inner = outer.new Inner();
    }
}
```

* We can access the enclosing class's variable using the `this` keyword:

```java
class A {
    int sameName = 10;
    class B {
        int sameName = 20;
        void printC() {
            new C().print();
        }
        class C {
            int sameName = 30;
            void print() {
                System.out.print(sameName); // 30
                System.out.print(this.sameName); // 30
                System.out.print(B.this.sameName); // 20
                System.out.print(C.this.sameName); // 10
            }
        }
    }
    main() {
        new A2().new B2().printC(); 
    }
}
```

* We can instantiate the C class directly even if A has no scope access to it using the following syntax:

```java
A.B.C c = new A().new B().new C();
```

<hr>

## 🔴 1.7.2 Local Inner Classes

* A local inner class is a class defined in a METHOD, the class only exists when the method is called and goes out of scope when method returns.
* Like local variables, they can't have access modifier
* Cannot be marked `static` or have static methods.
* They can access members of enclosing class.
* An Inner class can only access variables which are EFFECTIVELY FINAL⚠️
* E.g.:
```java
public class Outer {
    private int length = 5;
    void calculate() {
        int width = 5; // THIS IS EFFECTIVELY FINAL
        // width = 2; // THIS WOULD BREAK BELOW
        class Inner {
            void multiply() {
                System.out.println(length*width);
            }
        }
        new Inner().multiply();
    }
    main() {
        new Outer().calculate(); // 100
    }
}
```

<hr>

## 🔴 1.7.3 Annoymous Inner Class
* Annoymous Inner classes are local classes which have no name, usually used to create an implementation of an abstract class or interface.
* E.g.:

```java
public class UsingAnnonymousClass {
	interface SaleTodayOnly {
		int priceOff();
	}
	SaleTodayOnly sale = new SaleTodayOnly() {
		public int priceOff() {
			return 50;
		}
	};
}
```