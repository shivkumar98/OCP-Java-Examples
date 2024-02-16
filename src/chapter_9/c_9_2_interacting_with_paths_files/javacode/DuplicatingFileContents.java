package chapter_9.c_9_2_interacting_with_paths_files.javacode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DuplicatingFileContents {
	/*
	 * Path copy(Path, Path) throw IOException
	 * This method makes a shallow copy of a path 
	 * It will NOT copy files/dirs WITHIN the path 
	 */
	
	public static void main(String[] args) {
		Path folderWithAFileAndSubFolder =

				Paths.get("src//chapter_9//c_9_2_interacting_with_paths_files//screenshots");
		Path targetPath =
				Paths.get("src//chapter_9//output");
		try {
			Files.copy(folderWithAFileAndSubFolder, targetPath, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("copy successful");
		} catch (IOException e) {
			// no exception thrown
			System.out.println("copy unsucessful");


		}
	}
	
	
}
