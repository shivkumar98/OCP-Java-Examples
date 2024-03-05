package review_questions.chapter_8.attempt_3.java;

import java.io.Console;

public class Q4 {
	public static void main(String[] args) {
		Console c = System.console();
		// c.read(); // COMPILER ERROR
		c.readLine();
		c.readPassword();
	}
}
