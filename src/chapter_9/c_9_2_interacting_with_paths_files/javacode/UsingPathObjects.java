package chapter_9.c_9_2_interacting_with_paths_files.javacode;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingPathObjects {
	public static void main(String[] args) {
		Path path = Paths.get("src/chapter_9/c_9_1_intro_nio2/javacode/file.txt");
		System.out.println(path.toString());
		System.out.println(path);
		
		for(int index=0;index<path.getNameCount();index++) {
			System.out.println(path.getName(index));
		}
		
		Path pathWithRoot 
			= Paths.get("/root/file.txt");
		System.out.println(pathWithRoot.getName(0)); // root
		System.out.println(pathWithRoot.getName(1)); // file.txt
		System.out.println(pathWithRoot.getName(2)); // file.txt
		
				
	}
}
