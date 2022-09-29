package review_questions.chapter_1.q18;
/* 	QUESTION: What is the result of the following code?
	OPTIONS:
	 A. fish
	 B. FISH
	 C. 0
	 D. 1
	 E. false
	 F. true
	 G. The code does not compile
	 
	ANSWER: G - abstract enum methods must be implemented by all enum values
 */
public class Swimmer {
	enum AnimalClasses {
		MAMMAL, FISH{
			public boolean hasFins() { return true; } },
		BIRD, REPTILE, AMPHIBIAN, INVERTEBRATE;
		public abstract boolean hasFins();
		public static void main(String[] args) {
			System.out.println(AnimalClasses.FISH);
			System.out.println(AnimalClasses.FISH.ordinal());
			System.out.println(AnimalClasses.FISH.hasFins());
			System.out.println(AnimalClasses.BIRD.hasFins());
		}
		
	}
}
