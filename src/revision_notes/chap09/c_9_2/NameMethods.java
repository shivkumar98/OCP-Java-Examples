package revision_notes.chap09.c_9_2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NameMethods {

	public static void main(String[] args) {
		System.out.println(Paths.get("./")
				.toString()); // .
		System.out.println(Paths.get("/.")
				.toString()); // /.
		
		System.out.println(Paths.get("/./")
				.toString()); // /.
		
		System.out.println(Paths.get("src/../"));
		// src/..
		
		System.out.println(Paths.get("/home/zoo")
				.toString()); // /home/zoo
		
		
		System.out.println("\n=======================\n");
		
		Path currentPath = Paths.get("./");
		System.out.println(
			currentPath.getNameCount()
				); // 1
		System.out.println(currentPath.getName(0)); // .
//		System.out.println(currentPath.getName(1)); // throws exception
		
		Path path = Paths.get("/home/..");
		System.out.println(path.getNameCount()); // 2
		System.out.println(path.getName(0)); // home
		System.out.println(path.getName(1)); // ..
	}
}
