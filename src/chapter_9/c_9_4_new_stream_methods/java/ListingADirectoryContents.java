package chapter_9.c_9_4_new_stream_methods.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ListingADirectoryContents {
	
	public static void main(String[] args) {
		// We saw earlier, that the File class has a listFiles()
		// method which returns File objects representing contents 
		// of the directory which are direct children of 
		// you could use File.walk() with a max depth of 1 
		// to achieve the same result
		
		// NIO.2 API includes a new stream method: Files.list(Path)
		// which does this for you
		
		Path chap9 = Paths.get("src//chapter_9");
		try {
			Stream<Path> stream = Files.list(chap9);
			stream.forEach(System.out::println);
			/* 
			src\chapter_9\c_9_1_intro_nio2
			src\chapter_9\c_9_2_interacting_with_paths_files
			src\chapter_9\c_9_3_understanding_file_attributes
			src\chapter_9\c_9_4_new_stream_methods
			src\chapter_9\README.md
			 */
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
		
		
		
	}

}
