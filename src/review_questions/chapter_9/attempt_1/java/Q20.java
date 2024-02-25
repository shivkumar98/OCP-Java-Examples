package review_questions.chapter_9.attempt_1.java;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Q20 {
	public static void main(String[] args) {
		Path path = Paths.get(".");
		System.out.println(path); // .
		Path normalized = path.normalize();
		System.out.println("norm: " +normalized);  
		System.out.println(normalized.getNameCount()); // 1
	}
}
