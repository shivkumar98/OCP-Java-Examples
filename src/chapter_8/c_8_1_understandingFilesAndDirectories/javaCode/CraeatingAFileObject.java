package chapter_8.c_8_1_understandingFilesAndDirectories.javaCode;

import java.io.*;

public class CraeatingAFileObject {
	public static void main(String[] args) {
		File file = new File("\\home\\zoo.txt");
		System.out.println(file.exists()); // false
	    System.out.println("Working Directory = " + System.getProperty("user.dir"));
	    File parent = new File(System.getProperty("user.dir")+"\\src");
	    File child = new File(parent, "home\\zoo.txt");
	    System.out.println(child.exists());

	}
}
