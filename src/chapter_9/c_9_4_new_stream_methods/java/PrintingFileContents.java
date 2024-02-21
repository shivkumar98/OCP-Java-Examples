package chapter_9.c_9_4_new_stream_methods.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class PrintingFileContents {

	// we know that Files.readAllLines() can cause
	// a OutOfMemoryError problem
	// NIO.2 api in Java 9 has Files.lines(Path) 
	// which returns a Stream which can be processed lazily
	// Files.lines() is equivalent to Files.readAllLines()
	public static void main(String[] args) {
		
		Path chap9_readMe = Paths.get("src//chapter_9//README.md");
		
		try {
			List<String> list = Files.readAllLines(chap9_readMe);
			System.out.println(list.size()); // 13
			Stream<String> str = Files.lines(chap9_readMe);
			System.out.println(str.count()); // 13
		} catch (IOException e) {
			
		}
		
	}
}
