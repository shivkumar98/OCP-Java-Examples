package review_questions.chapter_9.attempt_1.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Q13 {
	public static void main(String[] args) throws IOException {
		Path path 
		= Paths.get("src/chapter_9/c_9_4_new_stream_methods/java");
		Files.find(path, 0, (p,a) -> true) // prints nothing if 0
			.map(p -> p.toString())
			.collect(Collectors.toList())
			.stream()
			.filter(x -> x.toString().endsWith(".java"))
			.forEach(System.out::println);
		/* prints following if depth of 1 is provided
		 * src\chapter_9\c_9_4_new_stream_methods\java\ListingADirectoryContents.java
src\chapter_9\c_9_4_new_stream_methods\java\PrintingFileContents.java
src\chapter_9\c_9_4_new_stream_methods\java\SearchingADirectory.java
src\chapter_9\c_9_4_new_stream_methods\java\WalkingADirectory.java

		 */
	}
}
