package chapter_8.c_8_1_understandingFilesAndDirectories.java;

import java.io.*;
import java.util.Arrays;

public class CraeatingAFileObject {
	public static void main(String[] args) {
		File file = new File("\\home\\zoo.txt");
		System.out.println(file.exists()); // false
	    System.out.println("Working Directory = " + System.getProperty("user.dir"));
	    File parent = new File(System.getProperty("user.dir")+"\\src");
	    File child = new File(parent, "home\\zoo.txt");
	    System.out.println(child.exists());
	    
	    System.out.println(child.getName());
	    System.out.println(child.getAbsolutePath());
	    // C:\Users\shiv.kumar\Documents\Github\OCP-Java-Examples\src\home\zoo.txt
	    System.out.println(child.isDirectory()); // false
	    System.out.println(parent.isDirectory()); // true
	    
	    System.out.println(child.isFile()); // true
	    System.out.println(child.isFile()); // true
	    File madeup = new File("random.txt");
	    System.out.println(madeup.isFile()); // false
	    
	    File newDirectory = new File(parent, "new_directory");
	    if (!newDirectory.isDirectory())
	    	newDirectory.mkdir();
	    System.out.println(newDirectory.exists()); // true
	    System.out.println(newDirectory.mkdir()); // false as already exists
	    System.out.println(newDirectory.delete()); // true
	    
	    System.out.println(child.getParent());
	    // C:\Users\shiv.kumar\Documents\Github\OCP-Java-Examples\src\home
	    System.out.println(parent.getParent()); 
	    // C:\Users\shiv.kumar\Documents\Github\OCP-Java-Examples
	    
	    File[] files = child.listFiles();
	    System.out.println(Arrays.toString(files)); // null
	    File[] files2 = parent.listFiles();
	    System.out.println(Arrays.toString(files2)); // null


	}
}
