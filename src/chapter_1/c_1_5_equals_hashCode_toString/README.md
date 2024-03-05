<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 1.5 Coding `equals`, `hashCode`, and `toString`

* As all objects extends from `java.lang.Object`, they all have the three methods.

## 🔴 1.5.1 equals
* The `equals()` method is used to check if the object calling equals is equivalent to the one in the parameter.
* String has a custom implementation while StringBuilder checks if the two varibles point to the same instance
* In the override, we typically check if the object passed is an instance of the Class:

```java
class Lion {
	private int age;
	private String name;
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Lion)) return false;
		Lion other = (Lion) obj;
		return age == other.age && name.equals(other.name);
	}	
}
```

* The parameter of the equals method MUST be Object, as we are overriding the implementation in the `java.lang.Class`.

## 🔴 1.5.2 hashCode
* When overriding the `equals()` method, it is best practice to override the `hashCode()` method too!!! This is so that when we store an instance in a HashMap,
* The JavaDoc specifies the following rules for implementing hashCode:
1) The value of `hashCode()` should remain the same within the same program
2) If two objects are equal when calling `equals()`, the two objects should share the same hashcode
3) It is not required that 2 different objects under `equals()` have the same hashcode.

* Typically, the hashing used in the override should contain the same variables as the one in equals. The above Lion class violate the JavaDoc, so here is an updated one:

```java
class Lion {
	private int id;
	private String name;
	@Override
	public equal equals(Object obj){
		if (!(obj instanceof Lion)) return false;
		Lion other = (Lion) obj;
		return this.id == other.id;
	}
	@Override
	public String hashCode() {
		return Objects.hash(id)
	}
}
```