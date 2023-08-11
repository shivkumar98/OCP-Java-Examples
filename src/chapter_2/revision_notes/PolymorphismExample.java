package chapter_2.revision_notes;

public class PolymorphismExample {

	public static void main(String[] args) {
		Animal animal = new Lemur();
		Lemur lemur = new Lemur();
		HasTail hasTail = new Lemur();
		
		System.out.println(lemur.age); // 10
		// System.out.println(animal.age); // COMPILER ERROR
		// System.out.println(hasTail.age); // COMPILER ERROR
		
		System.out.println(lemur.hasHair()); // true
		System.out.println(animal.hasHair()); // true
		// System.out.println(hasTail.hasHair()); // COMPILER ERROR
		
		
		System.out.println(lemur.isTailStriped()); // false
		// System.out.println(animal.isTailStriped()); // COMPILER ERROR
		System.out.println(hasTail.isTailStriped()); // false
	}
	
}

class Animal {
	public boolean hasHair() {
		return true;
	}
}

interface HasTail {
	boolean isTailStriped();
}

class Lemur extends Animal implements HasTail {
	public int age = 10;
	public boolean isTailStriped() {
		return false;
	}
	
}