package review_questions.chapter_9.attempt_4.java;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Q1 {
	public static void main(String[] args) {
		Path path = Paths.get("/user/.././root", "../kodiacbear.txt");
		path.normalize().relativize(Paths.get("/lion"));
		System.out.println(path);
	}
}
