package review_questions.chapter_1.attempt_2.q9;

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
		Inner inner = new Inner();
		inner.printX();
		return x;
	}
	public static void main(String[] args) {
		new Outer().getX(); // x is 24
	}
}
