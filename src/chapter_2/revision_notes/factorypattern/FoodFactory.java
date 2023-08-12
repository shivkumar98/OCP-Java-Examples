package chapter_2.revision_notes.factorypattern;

public class FoodFactory {
	
	public static Food getFood(String animalName) {
		switch(animalName) {
			case "Human": return new Pizza(2);
			case "Goat": return new Falafel(20);
			case "Whale": return new Fish(20);
		}
		throw new UnsupportedOperationException();
	}
}
