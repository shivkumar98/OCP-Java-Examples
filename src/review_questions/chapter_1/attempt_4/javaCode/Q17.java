package review_questions.chapter_1.attempt_4.javaCode;

public class Q17 {

}

enum AnimalClasses {
	MAMMAL(true);
	public boolean hasHair;
	AnimalClasses(boolean hasHair) {
		this.hasHair = hasHair;
	}
	// the following will not compile
	/*
	public AnimalClasses(boolean hasHair) { // }
	 */
}