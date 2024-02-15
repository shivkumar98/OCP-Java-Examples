package chapter_9.c_9_2_interacting_with_paths_files.javacode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestingUniqueness {
	
	public static void main(String[] args){
		Path relativePathOfFile = Paths
				  .get("src/chapter_9/c_9_2_interacting_with_paths_files/javacode/file.txt");
		
		Path absolutePathOfSameFile = Paths.get("C:\\Users\\shiv.kumar\\Documents\\Github\\OCP-Java-Examples\\src\\chapter_9\\c_9_2_interacting_with_paths_files\\javacode\\file.txt");
		
		System.out.println("hello");
		try {
			boolean isSame = Files.isSameFile(relativePathOfFile, absolutePathOfSameFile);
			System.out.println(isSame);
		} catch (IOException e) {
			System.out.println("catched");
		}
		
		try {
			Path fakePath = Paths.get("fake");
			Files.isSameFile(relativePathOfFile, fakePath);
		} catch (IOException e) {
			System.out.println("IOExcetpion caught"); // this gets printed!
		}
	}

}
