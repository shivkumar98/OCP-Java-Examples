<link href="../../styles.css" rel="stylesheet"></link>

# 🧠 1.3 Virtual Method Invocation

* Virtual method invocation is where a subclass's implementation is called rather than the implementation which is available in the super class
* All regular, non-static methods are virtual
* Here's an example of virtual method invocation in play:

```java
abstract class AnimalV2 {
	public void careFor() {
		play();
	}
	public void play() { // VIRTUAL METHOD
		System.out.println("pet animal");
	}
}
 
class Lion extends AnimalV2 {
	public void play() {
		System.out.println("throws steak");
	} }
// main method:		
AnimalV2 lion = new Lion();
lion.careFor(); // throws steak
```