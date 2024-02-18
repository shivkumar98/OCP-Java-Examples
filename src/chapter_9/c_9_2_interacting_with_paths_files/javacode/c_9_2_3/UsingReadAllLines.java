package chapter_9.c_9_2_interacting_with_paths_files.javacode.c_9_2_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UsingReadAllLines {
	// The files class has a readAllLines() method:
	/* List<String> readAllLines(Path) throws IOException */
	// this method can throw a OutOfMemoryError if the files is huge
	
	public static void main(String[] args) {
		Path nonExistent = Paths.get("src//fake");
		try {
			List<String> lines = Files.readAllLines(nonExistent);
			System.out.println("success");
		} catch (IOException e) {
			System.out.println(e); // NoSuchFileException
		}
		
		Path textFile = Paths.get("src//"
				+ "chapter_9//"
				+ "c_9_2_interacting_with_paths_files//"
				+ "javacode//"
				+ "file.txt");
		try {
			List<String> lines = Files.readAllLines(textFile);
			lines.forEach(System.out::println);
			// ^ prints 3 lines from the file!
		} catch (IOException e) {  }
	}

}
