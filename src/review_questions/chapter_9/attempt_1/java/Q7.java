package review_questions.chapter_9.attempt_1.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Q7 {
	
	public static void main(String[] args) throws IOException {
		Path relativeCurrentDir = Paths.get("turkey");
		Path absolutePathOfNonExistent = 
				Paths.get("C:\\"
						+ "Users\\"
						+ "Shiv\\"
						+ "Documents\\"
						+ "GitHub\\"
						+ "OCP-Java-Examples\\"
						+ "turkey");
		
		/* THROWS: EXCEPTION
		if (Files.isSameFile(relativeCurrentDir, absolutePathOfNonExistent)) {
			System.out.println("hello");
		}
		*/
		Path relFakePath = Paths.get("path/hello");
		Path relFakePath2 = Paths.get("path/hello/");
		System.out.println(Files.isSameFile(relFakePath, relFakePath2)); // true
		
	}
}
