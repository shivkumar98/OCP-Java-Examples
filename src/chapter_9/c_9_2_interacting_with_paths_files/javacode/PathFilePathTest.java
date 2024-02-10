package chapter_9.c_9_2_interacting_with_paths_files.javacode;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathFilePathTest {
	static void printInformation(Path path) {
		System.out.println("Filename is: "+path.getFileName());
		System.out.println("Root is: "+path.getRoot());
		
		
		Path currentPath = path;
		while((currentPath = currentPath.getParent()) != null) {
			System.out.println("    Current parent is: "+currentPath);
		}
	}
	
	public static void main(String[] args) {
		Path relativePath = Paths
				  .get("src/chapter_9/c_9_1_intro_nio2/javacode/file.txt");
		printInformation(relativePath);
		/* Filename is: file.txt
		 * Root is: null
		 *   Current parent is: src\chapter_9\c_9_1_intro_nio2\javacode
		 *   Current parent is: src\chapter_9\c_9_1_intro_nio2
		 *   Current parent is: src\chapter_9
		 *   Current parent is: src
		 */
		
		Path absolutePath = Paths.get("C:\\Users\\Shiv\\Documents\\GitHub");
		printInformation(absolutePath);
		/* Filename is: Github
		 * Root is: C:\
		 *   Current parent is: C:\Users\Shiv\Documents
		 *   Current parent is: C:\Users\Shiv
		 *   Current parent is: C:\Users
		 *   Current parent is: C:\
		 */
	}
}
