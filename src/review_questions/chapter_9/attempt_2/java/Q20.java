package review_questions.chapter_9.attempt_2.java;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Q20 {
	
	public static void main(String[] args) {
		Path path = Paths.get(".").normalize();
		System.out.println(path);
		System.out.println(path.getNameCount());
	}
}
