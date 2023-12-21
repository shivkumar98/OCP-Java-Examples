<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 8.4 Interacting With Users
* We shall lookk at the `java.io.Console` class which is an evolved form of the `System.in`/`System.out` methods,
<hr>

## 🟥 8.4.1 The Old Way
* Suppose we want to obtain input from the user
* We need to use `System.in` and wrap it with `InputStreamReader` class
* We then use `BufferedReader` so that the user can enter multiple characters and use termination (enter):
```java
try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
  System.out.println("Write something:");
  String userInput = reader.readLine();
  System.out.println("This is what you wrote: "+userInput);
} catch (IOException e) {
  
}
```
* Running the program:

![](screenshots/sample-program.gif)

## 🟥 8.4.2 The New Way
* Java 6 introduced `java.io.Console` which is a singleton which is accessed using `System.console()` - this can potentially return null
* Here is the previous program rewritten:
```java
Console console = System.console();
if (console!=null) {
  System.out.println("Write something:");
  String userInput = console.readLine();
  System.out.println("This is what you wrote: "+userInput);
}
```
