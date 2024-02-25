package revision_notes.chap09.c_9_2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingFilesExists {

	// this method does not throw any exception
	// simple returns false if nothing is found
	
	public static void main(String[] args) {
		Path existentRelPath = Paths
			.get("src/chapter_9");
		System.out.println(Files.exists(existentRelPath));
		// true
		
		Path nonExistentRelPath = Paths
			.get("fake/madeup");
		System.out.println(Files.exists(nonExistentRelPath));
		// false
		
		Path nonExistentAbsPath = Paths
			.get("/home/zoo");
		System.out.println(Files.exists(nonExistentAbsPath));
		// false
		
		Path existenAbsPath = Paths
			.get("C:/Users/Shiv/Documents/GitHub");
		System.out.println(Files.exists(existenAbsPath));
		// true
	}
	
}
