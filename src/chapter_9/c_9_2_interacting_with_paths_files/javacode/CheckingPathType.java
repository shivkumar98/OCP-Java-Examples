package chapter_9.c_9_2_interacting_with_paths_files.javacode;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckingPathType {
	
	public static void main(String[] args) {
		Path relativePath = Paths
				.get("src/chapter_9/c_9_1_intro_nio2/javacode/file.txt");
		
		System.out.println(relativePath.isAbsolute()); // false
		
		Path relativeToAbsolute = relativePath.toAbsolutePath();
		System.out.println(relativeToAbsolute);
		/* C:\Users\Shiv\Documents\GitHub\
		 *  OCP-Java-Examples\src\chapter_9\
		 *  c_9_1_intro_nio2\javacode\file.txt */
		
		Path absolutePath = Paths
				.get("C:\\Users\\Shiv\\Documents\\GitHub");
		System.out.println(absolutePath.isAbsolute()); // true
		Path absoluteToAbsolutePath = absolutePath.toAbsolutePath();
		System.out.println(absoluteToAbsolutePath);
		// C:\Users\Shiv\Documents\GitHub

		
 
	}

}
