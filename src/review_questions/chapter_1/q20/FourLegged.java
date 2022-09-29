package review_questions.chapter_1.q20;
/* QUESTION: What is the result of the following code?
   OPTIONS:
	 A. toddle,toddle,
	 B. toddle,walk,
	 C. walk,toddle,
	 D. walk,walk,
	 E. The code does not compile
	 F. A runtime exception is thrown
	 
  ANSWER: C - with instance variables, the reference does not change the value
 */
public class FourLegged {
	String walk = "walk,";
	static class BabyRhino extends FourLegged {
		String walk = "toddle";
	}
	public static void main(String[] args) {
		FourLegged f = new BabyRhino();
		BabyRhino b = new BabyRhino();
		System.out.print(f.walk);
		System.out.print(b.walk);
		
		/* not part of question:*/
		// BabyRhino r = new FourLegged(); // does not compile
	}
}
