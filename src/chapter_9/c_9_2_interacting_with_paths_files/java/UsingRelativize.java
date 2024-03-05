package chapter_9.c_9_2_interacting_with_paths_files.java;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingRelativize {
	public static void main(String[] args) {
		
		Path absolutePath1 = Paths
				  .get("/Documents/pizza.txt");
		
		Path p1 = Paths.get("/Documents/pizza.txt");
		System.out.println(p1.relativize(p1)); // (BLANK)
		Path p2 = Paths.get("/Documents/Shiv/file.txt");
		System.out.println(p1.relativize(p2));
		// ..\Shiv\file.txt
		
		System.out.println(p2.relativize(p1));
		
		Path relPath1 = Paths
				.get("pizza.txt");
		Path relPath2 = Paths
				.get("poultry/chicken.txt");
		System.out.println(relPath1.relativize(relPath2));
		System.out.println(relPath2.relativize(relPath1));
		
		// relPath1.relativize(absolutePath1);
		 // absolutePath1.relativize(relPath2);
	}
}
