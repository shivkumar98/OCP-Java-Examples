package chapter_1.c_1_3_virtual_method_invocation;

public class PlayWithAnimal {
	public static void main(String[] args) {
		AnimalV2 lion = new Lion();
		lion.careFor(); // throws steak
	}
}

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
	}
}