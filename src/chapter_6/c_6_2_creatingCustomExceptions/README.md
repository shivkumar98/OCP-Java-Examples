<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 6.2 Creating Custom Exceptions

* You can create your own exception. You must decide whether it is checked or unchecked exception.
* While you CAN extend ANY exception class, you typically exten `Exception` for checked and `RuntimeException` for unchecked.
* Here is an example:
```java
class CanNotSwimException extends Exception {}
class DangerInTheWater extends RuntimeException {}
public class Dolphin {
    void swim() throws CanNotSwimException {
        // if logic:
        throw new CanNotSwimException();
    }
    
    public static void main(String[] args) {
       Dolphin dolphin = new Dolphin();
      // dolphin.swim(); // COMPILER ERROR
      try { 
            dolphin.swim();
      } catch (CanNotSwimException e) { // REQUIRED!
            System.out.println(e);
      } finally {
            System.out.println("FINALLY");
      }
      System.out.println("after try/catch");
      
      dolphin.swim2(); // COMPILES FINE
    }
}
```
* This code prints the following:
```console
package.CanNotSwimException
FINALLY
after try/catch
```

* We can see with `swim2()`, we are not forcing the client which calls the method to handle the exception.

* Here are some common constructors defined within the `Exception` class:
```java
class CanNotSwimExcpetion extends Exception {
      public CanNotSwimException() {
            super();
      }
      public CanNotSwimException(Exception e) {
            super(e);
      }
      public CanNotSwimException(String message) {
            super(message);
      }
}
```
* If we `throw new CanNotSwimException()`:
```console
Exception in thread "main" CanNotSwimException
      at CanNotSwimException.main(CanNotSwimException.java:18)
```
* If we `throw new CanNotSwimException(new RuntimeException())`:
```console
Exception in thread "main" CanNotSwimException: java.lang.RuntimeException
      at CanNotSwimException.main(CanNotSwimException.java:19)
Caused by: java.lang.RuntimeException
      ... 1 more
```
* If we `throw new CanNotSwimException("broken fin")`:
```console
Exception in thread "main" CanNotSwimException: broken fin
      at CanNotSwimException.main(CanNotSwimException.java:18)
```
* The above console displays are called a *stack trace*. You can print the stack trace to console using `printStackTrace()` method as so:
```java
try {
      throw new CanNotSwimException();
} catch (CanNotSwimException e) {
      e.printStackTrace();
}
```