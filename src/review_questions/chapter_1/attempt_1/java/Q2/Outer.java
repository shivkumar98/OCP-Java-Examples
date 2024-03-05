package review_questions.chapter_1.attempt_1.java.Q2;

public class Outer {
	private int x = 24;
	public int getX() {
		String message = "x is ";
		class Inner {
			private int x = Outer.this.x;
			void printX() {
				System.out.println(message + x);
			}
		}
		Inner in = new Inner();
		in.printX();
		return x;
	}
	public static void main(String[] args) {
		// new Outer.getX();
	}
}
