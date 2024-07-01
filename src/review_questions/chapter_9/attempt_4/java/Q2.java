package review_questions.chapter_9.attempt_4.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Q2 {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("/dir");
		Files.deleteIfExists(path);
	}
}
