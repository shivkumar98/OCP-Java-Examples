package review_questions.chapter_9.attempt_1.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class Q3 {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("sloth.schedule");
		BasicFileAttributes attributes
			= Files.readAttributes(path, BasicFileAttributes.class);
		if (attributes.size()>0 && attributes.creationTime().toMillis()>0)) {
			attributes.set(null,null,null); // COMPILER ERROR
		}
	}
}
