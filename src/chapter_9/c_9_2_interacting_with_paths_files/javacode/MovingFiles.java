package chapter_9.c_9_2_interacting_with_paths_files.javacode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MovingFiles {
	// move(Path source, Path target) throws IOException
	
	public static void main(String[] args) {
		Path pathOfFile = Paths
			.get("src//chapter_9//file.txt");
		Path targetPath = Paths
			.get("src//chapter_9//output//file.txt");
		
		try {
			Files.move(pathOfFile, targetPath);
			System.out.println("move successful");
		} catch (IOException e) {
			System.out.println("unsuccessful");
		}
		
	}
}
