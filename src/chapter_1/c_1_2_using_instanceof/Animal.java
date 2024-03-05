package chapter_1.c_1_2_using_instanceof;

public class Animal {

	public static void main(String[] args) {
		Animal cow = new Cow();
		Animal bird = new Bird();
		feedAnimal(bird); // birds fed
		feedAnimal(cow); // cows fed
	}
	private static void feedAnimal(Animal animal) {
		if (animal instanceof Cow) {
			((Cow) animal).addHay();
		} else {
			((Bird) animal).addSeed();
		}
	}
}
class Cow extends Animal {
	void addHay() {System.out.println("cows fed");}

}
class Bird extends Animal {
	void addSeed() {System.out.println("birds fed");}
}
