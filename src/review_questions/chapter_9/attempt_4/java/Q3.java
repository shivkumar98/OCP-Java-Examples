package review_questions.chapter_9.attempt_4.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class Q3 {
	
	public static void main(String[] args) throws IOException {
		BasicFileAttributes b = Files.readAttributes(Paths.get("path"), BasicFileAttributes.class);
	}
	
}
