package review_questions.chapter_1.attempt_1.java.Q12;

public class Browsers {
	static class Browser {
		public void go() {
			System.out.println("inside browser");
		}
	}
	static class Firefox extends Browser{
		public void go() {
			System.out.println("inside browser");
		}
	}
	static class IE extends Browser {
		public void go() {
			System.out.println("inside IE");
		}
	}
	public static void main(String[] args) {
		Browser b = new Firefox();
		IE e = (IE) b; // throws class cast exception
		
	}
}
