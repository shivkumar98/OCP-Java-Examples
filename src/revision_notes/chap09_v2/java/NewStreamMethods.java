package revision_notes.chap09_v2.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewStreamMethods {
	
	public static void main(String[] args) {
		// walking a directory is when you start at the PARENT
		// directory and iterate over ALL of its descendants until
		// some condition is met or no more elements to iterate over
		
		// Files.walk(Path) traverses over a directory in a 
		// DEPTH FIRST and LAZY manner
		// the depthLimit is an overload, which when 
		// not specified uses `Integer.MAX_VALUE` as the maximum depth
		// this method will walk too
		
		 Path p = Paths.get("src/revision_notes/chap09_v2");
		 try {
			Stream<Path> stream = Files.walk(p);
			stream.map(s->s.toString())
			.forEach(System.out::println);
			/* this prints the following:
			 * src/revision_notes/chap09_v2
			 * src/revision_notes/chap09_v2/file.txt
			 * src/revision_notes/chap09_v2/README.md
			 * src/revision_notes/chap09_v2/java
			 * src/revision_notes/chap09_v2/java/AttributesAndViews.java
			 * src/revision_notes/chap09_v2/java/BasicFileAttributes.java
			 * src/revision_notes/chap09_v2/java/NewStreamMethods.java
			 * src/revision_notes/chap09_v2/java/PathFileMethods.java
			 * src/revision_notes/chap09_v2/java/PathObjectMethods.java
			 */
			
			System.out.println("\n------------------------\n\n");
			Files.walk(p, 1)
			.forEach(System.out::println);
			/*
			 * src/revision_notes/chap09_v2
			 * src/revision_notes/chap09_v2/file.txt
			 * src/revision_notes/chap09_v2/java
			 * src/revision_notes/chap09_v2/README.md
			 */
			
			System.out.println("\n======================\n");
			Files.walk(p, 0)
			.forEach(System.out::println);
			// src/revision_notes/chap09_v2
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 // we can use Files.find() which takes a 
		 // BiPredicate of (Path,BasicFileAttribute)
		 try {
			Stream<Path> stream = Files.find(p, 2, (path,attr)->true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 // we can obtain a Stream<String> of the lines whichh
		 // make up a file:
		 try {
			Stream<String> stream = Files.lines(Paths.get("README.md"));
			System.out.println(stream.collect(Collectors.toList()));
			// [, # ☕️ OCP Java Examples, , I started .... ]
			// thhis method can help avoid out of memory errors
			// whichh Files.readAllLines() could introduce
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
