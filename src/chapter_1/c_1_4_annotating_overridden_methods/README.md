<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 1.4 Annotating Overridden Methods

* We can use the `@Override` annotation to tell the compiler we are explicitly overriding a method.
* Here is an example:
```java
public class Phone {
	public static void staticMethod() {}
	private void privateMethod() {}
	public void regMethod() {}
}

class iPhone extends Phone {
	@Override
	public static void staticMethod() {} // COMPILER ERROR
	@Override
	public void privateMethod() {} // CAN NOT SEE Phone's privateMethod
	@Override
	public void regMethod() {} // WORKS FINE
}
```

