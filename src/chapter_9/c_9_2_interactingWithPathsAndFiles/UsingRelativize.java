package chapter_9.c_9_2_interactingWithPathsAndFiles;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingRelativize {
 public static void main(String[] args) {
	Path p1 = Paths.get("C:\\Users\\Shiv\\.m2\\repository");
	Path p2 = Paths.get("C:\\Users\\Shiv\\.m2\\repository\\commons-beanutils\\commons-beanutils\\1.6");
	Path doesNotExist = Paths.get("C:\\not");
	System.out.println(Files.exists(doesNotExist)); // false
	if (Files.exists(p1) && Files.exists(p2)) {
		System.out.println(p1.relativize(p2)); // commons-beanutils\commons-beanutils\1.6
		System.out.println(p2.relativize(p1)); // ..\..\..
		System.out.println(p1.relativize(p1));
	}
	String localDir = System.getProperty("user.dir");
	Path p3 = Paths.get("pom.xml");
	System.out.println(Files.exists(p3));
 }
 
 
}
