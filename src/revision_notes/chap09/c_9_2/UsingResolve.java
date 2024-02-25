package revision_notes.chap09.c_9_2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingResolve {
	public static void main(String[] args) {
		// the resolve method simply appends one path to another
		// Path resolve(Path other)
		
		Path relPath1 = Paths.get("pizza.txt");
		Path absPath1 = Paths.get("/food/pizza.txt");
		Path relPath2 = Paths.get("jeans.png");

		
		System.out.println(relPath1.resolve(relPath2));
		// pizza.txt/jeans.png
		
		System.out.println(absPath1.resolve(relPath1));
		// /food/pizza.txt/pizza.txt
		
		System.out.println(relPath1.resolve(relPath1));
		// pizza.txt\pizza.txt
		
		// if other is absolute, the return is the argument
		System.out.println(relPath1.resolve(absPath1));
		// /food/pizza.txt
		
	}
}
