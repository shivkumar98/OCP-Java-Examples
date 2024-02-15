package chapter_9.c_9_2_interacting_with_paths_files.javacode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MakingDirectories {
	// legacy java.io API used mkdir(), mkdirs()
	// File.createDirectory(Path) is used to make dirs
	// will throw IOException if directory cannot be created 
	// or already exists!
	
	public static void main(String[] args) {
		Path relDirectoryAlreadyExists = Paths
		  .get("src/chapter_9/" + "c_9_2_interacting_with_paths_files"
		  		+ "/javacode/");
		
		try {
			System.out.println(Files.createDirectory(relDirectoryAlreadyExists));
		} catch (IOException e) {
			System.out.println("exception caught!!!"); // this prints!!!
		}
		
		Path relDirWhichDoesNotExist = Paths
				.get("src/chapter_9/" + "c_9_2_interacting_with_paths_files"
				  		+ "/javacode/temp_folder");
		try {
			System.out.println(Files.createDirectory(relDirWhichDoesNotExist));
		} catch (IOException e) {
			// no exceptions to catch
		}
		// src\chapter_9\c_9_2_interacting_with_paths_files\javacode\temp_folder
		
		Path nestedDirectories = Paths
				  .get("src/chapter_9/" + "c_9_2_interacting_with_paths_files"
					  		+ "/javacode/temp/nested");
		try {
			Files.createDirectory(nestedDirectories);
			System.out.println("test");
		} catch (IOException e) {
			System.out.println("exception caught 1!"); // exception was thrown
		}
	}
}
