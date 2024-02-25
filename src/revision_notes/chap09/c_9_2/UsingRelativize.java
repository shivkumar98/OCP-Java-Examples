package revision_notes.chap09.c_9_2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingRelativize {

	public static void main(String[] args) {
		// if two relative paths are given, 
		// they are treated as if they are in the same directory
		
		Path relPath1 = Paths.get("pizza.txt");
		Path absPath1 = Paths.get("/food/pizza.txt");
		Path relPath2 = Paths.get("jeans.png");
		Path absPath2 = Paths.get("/clothes/jeans.png");
		
		System.out.println(relPath1.relativize(relPath2));
		// ../jeans.png
		
		System.out.println(relPath2.relativize(relPath1));
		// ../pizza.txt
		
		System.out.println(relPath1.relativize(relPath1)); 
		// blank
		
		System.out.println(absPath1.relativize(absPath2));
		// ../../clothes/jean.png
		System.out.println(absPath2.relativize(absPath1));
		// ../../food/pizza.txt
		
		System.out.println("=======================");
		
//		System.out.println(relPath1.relativize(absPath1));
		// ^ throws IllegalArgumentException: 'other' is different type of Path
//		System.out.println(absPath1.relativize(relPath1));
		// ^ throws exception
	}
}
