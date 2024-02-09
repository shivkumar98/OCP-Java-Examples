<link href="../../styles.css" rel="stylesheet"></link>

# 🧑‍🎨 Chapter 1 - Advanced Class Design - Revision Notes ✍️

## 🟥 1.1 Reviewing OCA Concepts
* Protected variables can be accessed in same package AND of subclass in ANY package
* Package-private variables can only be accessed in same package
<br>

## 🟥 1.2 Using instanceof
* `A instanceof B` is true if A is a subclass, implementation or instance of B
* `null instanceof X` is ALWAYS false
* If the REFERENCE of left side is a concrete class, then a compiler error will occur if the types are not compatible!
	```java
	Elephant e = new Elephant
	boolean x = e instanceof Hippo; // COMPILER ERROR
	```
* If the reference is an INTERFACE, then there will be no compilation issues!
	```java
	List l = new ArrayList();
	boolean y = l instanceof Hippo;
	```
* Java only checks if an object is an instance of an INTERFACE at runtime!
	```java
	List<String> list = new ArrayList<>(); // compiles!
	System.out.println(list instanceof Set); // false
	```
<br>

## 🟥 1.3 Coding equals() and hashCode
* The `.equals()` method can be overidden using any business logic the application requires
* The `hashCode()` method must satisfy the following requirements:
  
      1. If two objects return true when calling `.equals()`, then the hashCode() NEEDS to return the same value
      2. It is NOT required that if `.equals()` returns false that the hashCode() returns the same value
      3. The value of `hashCode()` does not change within the same program. I.e. the hashing should not rely on things which will vary
<br>

## 🟥 1.4 Working with Enums
* We can create a simple enum:
	```java
	public enum Seasons {
		SUMMER, WINTER, AUTUMN, SPRING
	}
	```
* We can add a variable to each enum:
	```java
	public enum Animals {
		DOG(true), FISH(false);
		public boolean hasHair;
		Animals(boolean hasHair) { this.hasHair = hasHair; }
	}
	```
* The only modifier which can be applied to the constructor is `private`

* You can also have an abstract class which will require all enums to implement
	```java
	enum SeasonsAbstract {
		WINTER {
			public void printHours() {}
		};
		abstract void printHours(); // can only use public/protected modifier
		// abstract keyword is REQUIRED unless a default implementation is provided
	}
	```
<br>

## 🟥 1.5 Creating Nested Classes
### 🟡 Member Inner Classes
* Member inner class are like regular classes, they can extend and implement other classes. They are defined at member level:
	```java
	class Outer {
		class MemberInnerClasses { }
		private class SubClass extends MemberInnerClasses { }
		protected interface AnInterface { }
		public class Implementation implements AnInterface{}
	}
	```
* You can apply whatever modifiers✅
* You can NOT have static fields/methods in the inner class❌
* You cannot instantiate an inner class directly!❌
	```java
	class Outer {
		class Inner {}
		public static void main(String[] args) {
			Inner inner = new Outer().new Inner();
		}
	}
	```
* You can access the enclosing class's variables:
	```java
	class Outer {
		String x = "OUTER";
		class Inner {
			String x = "INNER";
			printX() {
				System.out.println(x); // INNER
				System.out.println(this.x); // INNER
				System.out.println(Outer.this.x); // OUTER
				System.out.println(Outer.x); // COMPILER ERROR
			}
		}
	}
	```
### 🟡 Local Inner Classes
* These are classes defined within methods
* Can NOT have an access modifier specified❌
* You can NOT have static fields/methods in the inner class❌
* They can access the enclosing class's fields:
	```java
	public class OuterClass {
		String x = "outer";
		public static void main(String[] args) {
			class Inner {
				String x = "inner";
				void printX() {
					OuterClass outer = new OuterClass();
					System.out.println(outer.x); // outer
					System.out.println(x); // inner
				}
			}
			inner.printX();		
		}
	}
	```
* They can not access local variables unless they are effectively final or final
	```java
	public static void main(String[] args) {
		int effectivelyFinalVariable = 0;
		int nonEffectivelyFinalVariable = 1;
		nonEffectivelyFinalVariable = 2;
		class Inner {
			void() {
				System.out.println(effectivelyFinalVariable); // 0
				System.out.println(nonEffectivelyFinalVariable); // COMPILER ERROR
			}
		}
	}
	```
### 🟡 Anonymous Inner Class
* These are implementations/extensions of existing classes
	```java
	public class UsingAnonymousInnerClasses {
		interface Vehicle { void move(); }
		public static void main(String[] args) {
			public void move() { System.out.println("Lift clutch"); }
		}
	}
	```
### 🟡 Static Nested Classes
* This is the ONLY nested class which can have static variables
* You can use any visibility modifier
* You can instantiate the nested class directly:
	```java
	public class Outer {
		static class StaticInner {
			static int x = 1;
		}
		public static void main(String[] args) {
			System.out.println(new StaticInner().x); // 1
		}
	}
	```

---------------------------------------------------------------
