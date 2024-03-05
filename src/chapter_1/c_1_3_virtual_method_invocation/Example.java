package chapter_1.c_1_3_virtual_method_invocation;

/* What is a virtual method invocation?
 * A: Oracle refers to methods whose implementations which are not static at runtime
 */

public class Example extends Animal {
	public void feed(Animal animal) {
		animal.feed(animal); // this is a virtual method invocation
	}
}

abstract class Animal {
	public abstract void feed(Animal animal);
}
class Cow extends Animal {
	public void feed(Animal animal) {addHay();}
	private void addHay() {}
}
class Bird extends Animal {
	public void feed(Animal animal) { addSeed();}
	private void addSeed() {}
}