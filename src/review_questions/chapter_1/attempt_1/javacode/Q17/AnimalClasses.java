package review_questions.chapter_1.attempt_1.javacode.Q17;

public enum AnimalClasses {
	MAMMAL(true), FISH(Boolean.FALSE),
	BIRD(false), REPTILE(false), AMPHIBIAN(false),
	INVERTEBRATE(false);
	boolean hasHair;
	AnimalClasses(boolean hasHair) {
		this.hasHair = hasHair;
	}
	public void giveWig() {
		hasHair = true;
	}
}
