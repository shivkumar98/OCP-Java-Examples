package review_questions.chapter_1.q07;
/* QUESTION:  What is the result of the following code?
   OPTIONS:
	A. vanilla
	B. chocolate
	C. strawberry
	D. missing flavor
	E. The code does not compile.
	F. An exception is thrown..

	CORRECT ANSWER: E - the case must be an enumeration
*/
public class IceCream {
	enum Flavours {
		VANILLA, CHOCOLATE, STRAWBERRY
	}
	public static void main(String[] args) {
		Flavours f = Flavours.STRAWBERRY;
		switch(f) {
			case 0: System.out.println("vanilla"); // does not compile
			case 1: System.out.println("chocolate"); // does not compile
			case 2: System.out.println("strawberry"); // does not compile
					break;
			default: System.out.println("missing flavor");
		}
		
		switch (f) {
			case CHOCOLATE: System.out.println("chocolate"); // this works
		}
	}
}
