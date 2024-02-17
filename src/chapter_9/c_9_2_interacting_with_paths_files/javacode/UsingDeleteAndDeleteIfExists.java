package chapter_9.c_9_2_interacting_with_paths_files.javacode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingDeleteAndDeleteIfExists {
	
	// void delete(Path) throws IOException
	// can delete a file or empty dir
	// throws a checked IOException
	// can throw DirectoryNotEmptyException
	// can throw NoSuchFileException
	
	public static void main(String[] args) {
		Path nonExistent = Paths.get("src/fake");
		try {
			Files.delete(nonExistent);
			System.out.println("success");
		} catch (IOException e) {
			System.out.println(e.getClass()); 
			// java.nio.file.NoSuchFileException
		}
		try {
			Files.deleteIfExists(nonExistent);
			System.out.println("success"); // prints success
		} catch (IOException e) {
			System.out.println(e.getClass());
		}
		Path nonEmptyDir = Paths.get("src//chapter_9");
		try {
			Files.delete(nonEmptyDir);
		} catch (IOException e) {
			System.out.println(e.getClass());
			// java.nio.file.DirectoryNotEmptyException
		}
		Path file = Paths.get("src//chapter_9"+ "//c_9_2_interacting_with_paths_files" +
				"//javacode/file.txt");
		try {
			Files.delete(file);
			System.out.println("success");
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
