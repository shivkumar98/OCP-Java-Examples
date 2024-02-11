package chapter_9.c_9_2_interacting_with_paths_files.javacode;

import java.nio.file.Path;
import java.nio.file.Paths;

public class JoiningWithResolve {
	public static void main(String[] args) {
		Path path1 = Paths.get("/cats/../panther");
		Path path2 = Paths.get("/food");
		
		System.out.println(path1.resolve(path2)); // \cats\panther\food
		System.out.println(path2.resolve(path1)); // \cats\panther
		System.out.println(path2.resolve(path1).normalize()); // \cats\panther
	}
}
