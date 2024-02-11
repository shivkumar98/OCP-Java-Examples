package chapter_9.c_9_2_interacting_with_paths_files.javacode;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingExists {
	public static void main(String[] args) {
		Path relativePath = Paths
				  .get("src/chapter_9/c_9_1_intro_nio2/javacode/file.txt");
		
		Path absolutePath = Paths.get("C:\\Users");
		System.out.println(Files.exists(relativePath)); // true
		System.out.println(Files.exists(absolutePath)); // true
		Path fae
		
	}
}
