package chapter_9.c_9_3_understanding_file_attributes.java.c_9_3_1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.lang.System.out;

public class ReadingCommonAttributes {
	// files class has the following 3 methods:
	/* boolean isRegularFile(Path) 
	 * boolean isDirectory(Path)
	 * boolean isSymbolicLink(Path)
	 */
	// java defines  a regular file as
	// something which is not a directory, symbolic link,
	// resource, or non-regular
	
	public static void main(String[] args) {
		Path directory = Paths.get("src//chapter_9");
		out.println(Files.isRegularFile(directory)); 
		// false
		out.println(Files.isDirectory(directory));
		// true
		out.println(Files.isSymbolicLink(directory));
		// false
		
		out.println("==========================");
		
		Path file = Paths.get("src//chapter_9//README.md");
		out.println(Files.isRegularFile(file));
		// true
		out.println(Files.isDirectory(file));
		// false
		out.println(Files.isSymbolicLink(file));
		// false
		
		Path symbolicLink = Paths.get("sym-link");
		Files.isRegularFile(symbolicLink); 
		// ^ true if symbolic link points to a regular file
		Files.isDirectory(symbolicLink);
		// ^ true if symbolic link points to a directory
		Files.isSymbolicLink(symbolicLink);
		// ^ ALWAYS true
	}
}
