package review_questions.chapter_9.attempt_1.java;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Q4 {
	public static void main(String[] args) {
		Path path = Paths.get("/zoo/animals/bear/koala/food.txt");
		Path subPath = path.subpath(1, 3);
		System.out.println(subPath); // animals/bear
		Path name = subPath.getName(1);
		System.out.println(name); // bear
		System.out.println(name.toAbsolutePath());
		// C:\Users\Shiv\Documents\GitHub\OCP-Java-Examples\bear
	}
}
