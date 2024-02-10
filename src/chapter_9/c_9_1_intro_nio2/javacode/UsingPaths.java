package chapter_9.c_9_1_intro_nio2.javacode;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingPaths {

	public static void main(String[] args) {
		Path path = Paths.get("chapter_9/c_9_1_intro_nio2/file.txt");
		System.out.println(path.getFileName());
		System.out.println(path.isAbsolute()); // false
		
		Path path2 = Paths.get("C:\\Users\\Shiv\\Downloads\\SlackSetup.exe");
		System.out.println(path2.getFileName()); // SlackSetup.exe
		System.out.println(path2.isAbsolute()); // true
		
	}
}
