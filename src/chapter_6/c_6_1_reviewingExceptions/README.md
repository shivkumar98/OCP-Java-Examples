<link href="../../styles.css" rel="stylesheet"></link>


# 🧠 6.1 Reviewing Exceptions

* Here are some possibilities for a program to fail which are covered on the exam:
- Trying to read a file which does not exist
- Trying to access a database whose connections is unavailable
- Invalid SQL statement in JDBC code
- Coding errors, e.g. using wrong format specifier when using DateTimeFormatter.

## 🟥 6.1.1 Exceptions Terminology
* When creating a method, you can either deal with the exception or delegate it to method caller. 

## 🟥 6.1.2 Categories of Exceptions

* The hierarch of Exceptions is:
```
                  java.lang.Object
                        ⬆️
                java.lang.Throwable
                  ⬆️         ⬆️
        java.lang.Exception   java.lang.Error
              ⬆️
java.lang.RuntimeException     
```

* A runtime (unchecked) exceptions, can be caught but is not required to be caught
* A checked exception is any class which extends `Exception` BUT BOT `RuntimeException`
- Checked exceptions must be either caught or thrown to the caller.
* An error is fatal and should NOT be caught.

## 🟥 6.1.3 Exceptions on the OCP

## 🟥 H2

### 🟡 H3