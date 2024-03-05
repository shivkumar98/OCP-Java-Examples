package chapter_9.c_9_2_interacting_with_paths_files.java;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InteractingWithFiles {

	public static void main(String[] args) {
		boolean fileExists;
		Path relativePathOfFile = Paths
				  .get("src/chapter_9/c_9_1_intro_nio2/javacode/file.txt");
		fileExists = 
				Files.exists(relativePathOfFile);
		System.out.println(fileExists); // true
		
		
		Path relativePathOfFolder = Paths
				.get("src/chapter_9/c_9_1_intro_nio2/javacode/");
		fileExists =
				Files.exists(relativePathOfFolder);
		System.out.println(fileExists); // true
		
		Path fakeRelativePath = Paths
				.get("src/fake");
		System.out.println(Files.exists(fakeRelativePath));
	}
}
