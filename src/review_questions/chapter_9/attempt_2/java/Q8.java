package review_questions.chapter_9.attempt_2.java;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Q8 {
	public static void main(String[] args) {
		Path p1 = Paths
			.get("/pets/../cat.txt");
		Path p2 = Paths
			.get("./dog.txt");
		System.out.println(p1.resolve(p2));
		// /pets/../cat.txt/./dog.txt
		System.out.println(p2.resolve(p1));
		// ./dog.txt/pets/../cat.txt
	}
}
