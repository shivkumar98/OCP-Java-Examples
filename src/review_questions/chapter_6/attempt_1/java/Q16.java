package review_questions.chapter_6.attempt_1.java;

public class Q16 {
	static class Walk implements AutoCloseable {
		public void close() {
			throw new RuntimeException("snow");
		}
	}
	public static void main(String[] args) {
		try (Walk walk1 = new Walk(); Walk walk2 = new Walk();) {
			throw new RuntimeException("rain");
		} catch (Exception e) {
			System.out.println(e.getMessage()
				+ " " +e.getSuppressed().length);
		}
	}
	// rain 2
}
