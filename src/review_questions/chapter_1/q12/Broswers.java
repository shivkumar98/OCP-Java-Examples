package review_questions.chapter_1.q12;
/* QUESTION: What is the result of the following code?
   OPTIONS:
	A. Inside Browser
	B. Inside Firefox
	C. Inside IE
	D. The code does not compile.
	E. A runtime exception is thrown.

	ANSWER: E - IE is not a subclass of Firefox => ClassCastException
 */
public class Broswers {
	static class Browser {
		public void go() { System.out.println("Inside broswer"); }
	}
	static class Firefox extends Browser {
		public void go() { System.out.println("Inside Firefox"); }
	}
	static class IE extends Browser {
		@Override public void go() { System.out.println("Inside IE"); }
	}
	public static void main(String[] args) {
		Browser b = new Firefox();
		IE e = (IE) b;
		e.go();
	}
}
