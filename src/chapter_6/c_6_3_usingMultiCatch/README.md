<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 6.3 Using Multi-catch

* A common a approach for dealing with something going wrong in a program, is to log the error and convert it to a different exception type.
* E.g. here we print the stack trace (rather than log), andd then throw a runtime exception:
```java
public static void main(String[] args) {
    try {
        Path path = Paths.get("dolphinBirthDate");
        String text = 
                new String(Files.readAllBytes(path));
        LocalDate date = LocalDate.parse(text);
        System.out.println(date);
    } catch (DateTimeParseException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    } catch (IOException e)  {
        e.printStackTrace();
        throw new RuntimeException();
    }
}
```
* The first 2 lines can throw an `IOException`, the parsing of the date can throw a `DateTimeParseException`.
* The catches print the stack trace and thrown a `RuntimeException`

<br>

* We have duplicated code, in Java 7 we could workaround this in 2 ways:
1) We would just catch Exception so both are wrapped in one catch clause:
```java
public static void main(String[] args) {
    try {
        Path path = Paths.get("dolphinBirthDate");
        String text = 
                new String(Files.readAllBytes(path));
        LocalDate date = LocalDate.parse(text);
        System.out.println(date);
    } catch (Exception e) { // BAD APPROACH
        e.printStackTrace();
        throw new RuntimeException(e);
    }
}
```
* This is bad because it will catch other exceptions like NullPointerException😢

2) We can extract the duplicated code into a method:
```java
public static void main(String[] args) {
    try {
        Path path = Paths.get("dolphinBirthDate");
        String text = 
                new String(Files.readAllBytes(path));
        LocalDate date = LocalDate.parse(text);
        System.out.println(date);
    } catch (DateTimeParseException e) {
        handleException(e);
    } catch (IOException e)  {
        handleException(e);
    }
}

static void handleException(Exception e) {
    e.printStackTrace();
    throw new RuntimeException();
}
```
* We still have duplicated code!😢 Java 8 has multi-catch clauses where multiple exceptions can be caught in a single catch clause✅:
```java
public static void main(String[] args) {
    try {
        Path path = Paths.get("dolphinBirthDate");
        String text = 
                new String(Files.readAllBytes(path));
        LocalDate date = LocalDate.parse(text);
        System.out.println(date);
    } catch (DateTimeParseException | IOException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    } 
}
```

* See the following legal/illegal syntaxes:
```java
catch(Exception1 e | Exception2 e | Exception3 e) /* DOES NOT COMPILE */
catch(Exception1 e1 | Exception2 e2 | Exception3 e3) /* DOES NOT COMPILE */
catch(Exception1 | Exception2 | Exception3 e) // WORKS FINE!
```

<br>

* Java intends for multi-catch to be used for UNRELATED EXCEPTIONS.🤔 
* The following will not compile❌:
```java
try {
    throw new IOException();
} catch (FileNotFoundException | IOException e) {} // COMPILER ERROR
```
* FileNotFoundException is caught by IOException, so it is redundant and the compile will complain. We can fix the above by removing FileNotFoundException:
```java
try {
    throw new IOException();
} catch (IOException e ) {}
```

## 🟥 Multi-catch is Effectively Final

* Reassign variable in a regular catch block is LEGAL but NOT for MULT-CATCH!⚠️
```java
try {
    // do some work
} catch (RuntimeException e) {
    e = new RuntimeException(); // LEGAL
}
```
```java
try {
    // do some work
} catch (IOException | RuntimeException e) {
    e = new RuntimeException(); // COMPILER ERROR
}
```

## Review
* How many errors are in this code:
```java
void doesNotCompile() { // METHOD DOES NOT COMPILE
    try {
        mightThrow();
    } catch (FileNotFoundException | IllegalStateException e) {
    } catch (InputMismatchException e | MissingResourceException e) {
    } catch (SQLException | ArrayIndexOutOfBoundsException e) {
    } catch (FileNotFoundException | IllegalArgumentException e) {
    } catch (Exception e) {
    } catch (IOException e) {
    }
}
void mightThrow() throws DateTimeParseException, IOException {}
```

* MY ANSWER:
- The last catch is unreachable
- The fourth catch is unreachable as its a duplicate of the first catch clause
- The second catch has illegal syntax

* CORRECT ANSWER:
- All of the above!
- Also you can not catch SQLException (checked) because it can not be thrown by the `mightThrow()` method