package chapter_9.c_9_4_new_stream_methods.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WalkingADirectory {
	
	// In chap 4 we saw all the useful methods in
	// the Streams API
	// We shall look at the first newly newly added NIO.2 stream based method
	// The Files.walk(path) method returns Stream<Path>
	// which traverses a dir in a depth-first, lazy manner
	// the child elements of the target is not loaded for performance
	// enhancements
	// means you can process directories with a large number
	// of sub-directories
	public static void main(String[] args) {
		
		Path path = Paths.get("src//chapter_9");
		
		try {
			Files.walk(path)
			.filter(file->file.toString().endsWith(".java"))
			.forEach(System.out::println);
		} catch (IOException e) {
			// TODO: handle exception
		}
		/* prints the following:
		 * src\chapter_9\c_9_1_intro_nio2\javacode\UsingPaths.java
		 * src\chapter_9\c_9_3_understanding_file_attributes\java\c_9_3_1\ReadingFileLength.java
		 * src\chapter_9\c_9_3_understanding_file_attributes\java\c_9_3_1\TestingFileAccessibility.java
		 * src\chapter_9\c_9_3_understanding_file_attributes\java\c_9_3_2\ModifyingAttributes.java
		 * src\chapter_9\c_9_3_understanding_file_attributes\java\c_9_3_2\ReadingAttributes.java
		 * src\chapter_9\c_9_4_new_stream_methods\java\WalkingADirectory.java
		 * ...
		 */
		
		// there is an overload which lets you override
		// the default max depth of Integer.MAX_VALUE
		// you can supply a value of 0 to only retrieve files in current dir
		System.out.println("===================================\n");
		try {
			Files.walk(path, 3)
			.filter(p->p.toString().endsWith(".java"))
			.forEach(System.out::println);
		} catch (IOException e) {
			// TODO: handle exception
		}
		/* prints the following
		 * src\chapter_9\c_9_1_intro_nio2\javacode\UsingPaths.java
		 * src\chapter_9\c_9_2_interacting_with_paths_files\javacode\CheckingPathType.java
		 * src\chapter_9\c_9_2_interacting_with_paths_files\javacode\CreatingNewPathsWithSubpath.java
		 * src\chapter_9\c_9_2_interacting_with_paths_files\javacode\DuplicatingFileContents.java
		 */
	}
	
	// AVOIDING CIRCULAR PATHS
	// by default the walk method will not traverse symbolic links
	// this could easily lead to an infinite cycle where a symbolic link
	// points to an ancestor of the symbolic link
	// if we want to the walk method to follow symbolic links
	// we overload the FOLLOW_LINKS option
	// if a cycle is detected, a FileSystemLoopException will be thrown
}
