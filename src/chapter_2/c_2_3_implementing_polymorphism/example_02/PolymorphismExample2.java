package chapter_2.c_2_3_implementing_polymorphism.example_02;
/* 
 * Polymorphism allows objects to take on different forms
 * An object can be referenced using the same class of the object, a superclass of thwe object, the interface which the class of the object implements
 * The following example demonstrates this polymorphic property:
 */

class Primate {
	public boolean hasHair() { return true; }
}

interface HasTail {
	public boolean isTailStriped();
}

class Lemur extends Primate implements HasTail{
	public int age = 10;
	public boolean isTailStriped() { return false; }
}

public class PolymorphismExample2 {
	public static void main(String[] args) {
		Lemur lemur = new Lemur();
		HasTail lemur2 = lemur;
		System.out.println(lemur2.isTailStriped()); // false
		// lemur2.hasHair(); - does not compile
		
		Primate lemur3 = lemur;
		// lemur3.isTailStriped(); - does not compile
		System.out.println(lemur3.hasHair()); // true
	}
}
