package review_questions.chapter_9.attempt_1.java;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Q18 {
	public static void main(String[] args) {
		Path path1 = Paths.get("/lizard/./").resolve(Paths.get("walking.txt"));
		System.out.println(path1); 
		// /lizard/./walking.txt
		Path path2 = Paths.get("/lizard/././actions/../walking.txt");
		System.out.println(path2);
		// /lizard/././actions/../walking.txt

		System.out.println(path1.equals(path2)); // false
		
		Path normalized1 = path1.normalize();
		System.out.println(normalized1);
		// /lizard/walking.txt
		Path normalized2 = path2.normalize();
		System.out.println(normalized2);
		// /lizard/walking.txt
		System.out.println(normalized1.equals(normalized2));
		// true
	}
}
