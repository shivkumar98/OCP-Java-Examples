package review_questions.chapter_1.q06;
/* QUESTION:  What is the result of the following code?
   OPTIONS:
	A. 0
	B. 1
	C. 9
	D. CHOCOLATE
	E. The code does not compile due to a missing semicolon.
	F. The code does not compile for a different reason.

	CORRECT ANSWER: B
 */
public class FlavoursEnum {
	enum Flavours {
		VANILLA, CHOCOLATE, STRAWBERRY
	}
	public static void main(String[] args) {
		System.out.println(Flavours.CHOCOLATE.ordinal()); // 1
	}
}
