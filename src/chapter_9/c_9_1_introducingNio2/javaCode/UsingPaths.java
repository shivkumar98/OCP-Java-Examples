package chapter_9.c_9_1_introducingNio2.javaCode;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingPaths {
	public static void main(String[] args) {
		String locationOfThisPackage = System.getProperty("user.dir")+"\\src"+"\\chapter_9"
				+"\\c_9_1_introducingNio2\\javaCode";
		Path path = Paths.get(locationOfThisPackage+"\\text.txt");
		System.out.println(path.getFileName()); // text.txt
		
		Path path2 = Paths.get(
				System.getProperty("user.dir"),
				"src", "chapter_9", "c_9_1_introducingNio2",
				"javaCode", "text.txt");
		System.out.println(path2.getFileName());
	}
}
