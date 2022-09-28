package review_questions.chapter_1.q08;
/* QUESTION:  What is the result of the following code?
OPTIONS:
	A. The output is 5.
	B. The output is 10.
	C. Line 16 generates a compiler error.
	D. Line 20 generates a compiler error.
	E. Line 21 generates a compiler error.
	F. An exception is thrown

	CORRECT ANSWER: C - inner classes cannot have static members, only static nested classes can
*/
public class Outer {
	private int x = 5;
	protected class Inner {
		public static int x =10; // does not compile
		public void go() { System.out.println(x); }
	}
	public static void main(String[] args) {
		Outer out = new Outer();
		Outer.Inner in = out.new Inner();
		in.go();
	}

}
