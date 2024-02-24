package review_questions.chapter_9.attempt_1.java;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Q1 {

	public static void main(String[] args) {
		Path path = Paths.get("/user/.././root", "../kodiacbear.txt");
		/* path.normalize().relativize("/lion");
		 * DOES NOT COMPILE				^^^^^
		 */
		System.out.println(path); // /user/.././root/../kodacbear.txt
		path.normalize().relativize(Paths.get("/lion"));
		System.out.println(path); // same as above
		Path normalizePath = path.normalize();
		System.out.println(normalizePath); // /kodiacbear.txt
		Path relativizedPath = normalizePath.relativize(Paths.get("/lion"));
		System.out.println(relativizedPath); // ../lion

	}
}
