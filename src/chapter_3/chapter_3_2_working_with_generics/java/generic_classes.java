package chapter_3.chapter_3_2_working_with_generics.java;

public class generic_classes {
	
	public static void main(String[] args) {
		Elephant elephant = new Elephant();
		Crate<Elephant> crateForElephant = new Crate<>();
		crateForElephant.packCrate(elephant);
		Elephant inNewHome = crateForElephant.emptyCrate();
		
		Crate<Zebra> crateForZebra = new Crate<>();
		
		Crate<Robot> robotCrate = new Crate<>();
		Robot robotJoe = new Robot();
		robotCrate.packCrate(robotJoe);
	}

}

class Crate<T> {
	private T contents;
	public T emptyCrate() {
		return contents;
	}
	public void packCrate(T contents) {
		this.contents = contents;
	}
}

class Elephant {}

class Zebra {}

class Robot {}