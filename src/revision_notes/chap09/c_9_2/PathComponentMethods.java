package revision_notes.chap09.c_9_2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathComponentMethods {

	public static void main(String[] args) {
		Path absolutePath = Paths.get("/home/zoo");
		Path relPathToFile = Paths.get("src/chap9/folder/java/helloworld.txt");
		// Path getFileName() returns a path furthest away from root
		
		System.out.println(absolutePath.getFileName());
		// zoo
		System.out.println(relPathToFile.getFileName());
		// helloworld.txt
		
		System.out.println(absolutePath.getParent());
		// /home
		
		System.out.println(Paths.get("src/..")
				.getParent()); // src
		System.out.println(relPathToFile.getParent());
		// src/chap9/folder/java
		
		System.out.println(Paths.get(".").getParent());
		// null
		
		System.out.println(Paths.get("/home/root/..")
				.getParent()); 
		System.out.println(Paths.get("/home/root/../apple")
				.getParent());
		// /home/root/..
		
		System.out.println(Paths.get("file.txt")
				.getParent());
		// null
		
		System.out.println(
				Paths.get("src/folder1/../../../../..").getParent());
		
		System.out.println("\n==================\n");
		
		System.out.println(
			Paths.get("relative-file.txt").getRoot()
				);
		// null
		
		System.out.println(
			Paths.get("src/folder/random").getRoot()
				);
		// null
		System.out.println(
			Paths.get("/src/folder/random").getRoot()
					);
		// /
		
		
	}
}
