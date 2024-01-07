package review_questions.chapter_1.attempt_5.javaCode;

public class Outer {
	private int x = 24;
	public int getX() {
		String message = "x is ";
		class Inner {
			private int x = Outer.this.x;
			public void printX() {
				System.out.println(message + x);
			}
		}
		Inner inner = new Inner();
		inner.printX();
		return x;
	}
	public static void main(String[] args) {
		class Inner2 {
			
		}
		Inner2 inner = new Inner2();
	}
}
