package revision_notes.chap09.c_9_2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingSubpath {
	
	// you can create a new path using subpath(int,int)
	
	public static void main(String[] args) {
		Path path = Paths.get("/mammal/carnivore/racoon.image");
		System.out.println(path.getNameCount()); // 3
		System.out.println(path.getName(0)); // mammal
		System.out.println(path.getName(2)); // racoon.image
//		System.out.println(path.subpath(0, 0)); // THROWS illegalArgException
		System.out.println(path.subpath(0, 3));
		// mammal/carnivore/racoon.image
		System.out.println(path.subpath(1, 2)); // carnivore
		
		
		// relative path returns same result
		Path relPath = Paths.get("mammal/carnivore/racoon.image");
		System.out.println(relPath.subpath(0, 3)); 
	}

}
