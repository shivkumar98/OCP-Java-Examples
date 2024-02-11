package chapter_9.c_9_2_interacting_with_paths_files.javacode;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingNewPathsWithSubpath {

	public static void main(String[] args) {
		Path absolutePath = Paths
			    .get("\\Users\\Shiv\\Documents\\GitHub");
		// absolutePath.subpath(1, 1); // throws IllegalArgumentException
		System.out.println(absolutePath.getNameCount()); // 4
		System.out.println(absolutePath.subpath(0, 1)); // Users  
		System.out.println(absolutePath.subpath(0, 4)); // Users\Shiv\Documents\GitHub
		System.out.println(absolutePath.subpath(0, 2)); // Users\Shiv
		

		
	}
}
