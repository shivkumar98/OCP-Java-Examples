package chapter_9.c_9_1_intro_nio2.javacode;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingPaths {

	public static void main(String[] args) {
		Path path = Paths.get("src/chapter_9/c_9_1_intro_nio2/javacode/file.txt");
		System.out.println(path.getFileName());
		System.out.println(path.isAbsolute()); // false
		System.out.println(Files.exists(path));
		
		Path path2 = Paths.get("C:\\Users\\Shiv\\Downloads\\SlackSetup.exe");
		System.out.println(path2.getFileName()); // SlackSetup.exe
		System.out.println(path2.isAbsolute()); // true
		
		Path nonExistentFile 
			= Paths.get("chapter_9","c_9_1_intro_nio2","doe-not-exist.txt");
		System.out.println(Files.exists(nonExistentFile)); // false
		
		Path pathUsingList = Paths.get("src", "chapter_9", "c_9_1_intro_nio2","javacode", "file.txt");
		System.out.println(Files.exists(pathUsingList));

	}
}
