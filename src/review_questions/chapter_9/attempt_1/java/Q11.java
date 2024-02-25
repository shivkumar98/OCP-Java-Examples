package review_questions.chapter_9.attempt_1.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Q11 {
	public static void main(String[] args) throws IOException {
		Path path1 = Paths.get("src/./goat.txt");
		Path path2 = Paths.get("src/mule.png");
		Path copiedTarget = Files.copy(path1,path2,StandardCopyOption.COPY_ATTRIBUTES);
		System.out.println(Files.isSameFile(path1, path2)); // false
	}
}
