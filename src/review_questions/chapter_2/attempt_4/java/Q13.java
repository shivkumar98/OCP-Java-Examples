package review_questions.chapter_2.attempt_4.java;

public class Q13 {
	
	final class ImmutableClass {
		private final String name;
		public ImmutableClass(String name) {
			this.name = name;
		}
		private void setName(String name) {
//			this.name = name; // COMPILER ERROR
		}
		
	}

}
