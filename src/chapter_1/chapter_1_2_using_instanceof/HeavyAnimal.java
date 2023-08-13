package chapter_1.chapter_1_2_using_instanceof;


public class HeavyAnimal {
	
	public static void main(String[] args) {
		
	
		HeavyAnimal heavyAnimal = new HeavyAnimal();
		HeavyAnimal hippo = new Hippo();
		System.out.println(hippo instanceof HeavyAnimal);
		System.out.println(hippo instanceof Hippo);
		System.out.println(hippo instanceof Elephant); // false
		
		System.out.println(heavyAnimal instanceof Hippo); // false
		Hippo hippoRef = new Hippo();
		System.out.println(hippoRef instanceof HeavyAnimal); // true
		System.out.println(hippoRef instanceof Hippo); // true
		Hippo notNull = new Hippo();
		System.out.println(notNull instanceof Object);
		Hippo nullHippo = null;
		System.out.println(nullHippo instanceof Object); // false
		
		Hippo hip = new Hippo();
		boolean b = hip instanceof Elephant;
	}
	
}

class Hippo extends HeavyAnimal {}
class Elephant extends HeavyAnimal {}