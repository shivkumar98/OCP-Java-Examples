package chapter_9.c_9_3_understanding_file_attributes.java.c_9_3_1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestingFileAccessibility {

	// while a use can see a file or directory
	// they may not have access to read the contents or execute it
	/* boolean isReadable(Path)
	 * boolean isExecutable(Path)
	 */
	// a file's extension does not determine if it is executable
	
	public static void main(String[] args) {
		Path file = Paths
				.get("src//"
					+ "chapter_9//"
					+ "c_9_3_understanding_file_attributes//"
					+ "java//"
					+ "c_9_3_1//"
					+ "hidden-file.txt");
		System.out.println(Files.isReadable(file)); // true
		System.out.println(Files.isExecutable(file)); // true
		
	}
}
