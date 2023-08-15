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