package chapter_9.c_9_4_new_stream_methods.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class SearchingADirectory {
	
	// in the WalkingADirectory class's example, I applied a filter
	// to the generated Stream<Path> instance
	// There is a more direct approach:
	/* Stream<Path> find(Path,int,BiPredicate) throws IOException
	 * BiPredicate<Path, BasicFileAttributes>
	 */
	// find also supports the FOLLOW_LINK option
	
	public static void main(String[] args) {
		Path chap9 = Paths.get("src//chapter_9");
		try {
			BiPredicate<Path, BasicFileAttributes> biPred = 
					(path,basicFileAttributes) ->
					path.toString().endsWith(".java")
					&& basicFileAttributes.size()>1234;
			Stream<Path> str = Files.find(chap9, 3, biPred);
			str.forEach(System.out::println);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/* prints the following:
	 * src\chapter_9\c_9_2_interacting_with_paths_files\javacode\MakingDirectories.java
	   src\chapter_9\c_9_2_interacting_with_paths_files\javacode\PathFilePathTest.java
       src\chapter_9\c_9_2_interacting_with_paths_files\javacode\UsingDeleteAndDeleteIfExists.java
       src\chapter_9\c_9_2_interacting_with_paths_files\javacode\UsingPathObjects.java
       src\chapter_9\c_9_4_new_stream_methods\java\WalkingADirectory.java
	 */

}
