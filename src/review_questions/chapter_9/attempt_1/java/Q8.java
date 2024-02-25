package review_questions.chapter_9.attempt_1.java;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Q8 {
	
	public static void main(String[] args) {
		Path path1 = Paths.get("/pets/../cat.txt");
		Path path2 = Paths.get("./dog.txt");
		System.out.println(path1.resolve(path2));
		// /pets/../cat.txt/./dog.txt
		System.out.println(path2.resolve(path1));
		
	}

}
