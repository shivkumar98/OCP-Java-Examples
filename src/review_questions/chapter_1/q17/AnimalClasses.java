package review_questions.chapter_1.q17;
/* QUESTION: What is the result of the following code?
 * OPTIONS:
A. Compiler error on line 13
B. Compiler error on line 14
C. Compiler error on line 16
D. Compiler error on line 19
E. Compiler error on line 23

  CORRECT ANSWER: B, C - enums required a semi-colon at end, enums can't have public constructor only private
 */
public enum AnimalClasses {
	MAMMAL(true), FISH(Boolean.FALSE), BIRD(false),
	REPTILE(false), AMPHIBIAN(false), INVERTEBRATE(false) //a semi-colon is needed here
	boolean hasHair;
	AnimalClasses(boolean hasHair) {
		this.hasHair = hasHair;
	}
	public boolean hasHair() { 
		return hasHair;
	}
	public void giveWig() {
		hasHair = true;
	}
}
