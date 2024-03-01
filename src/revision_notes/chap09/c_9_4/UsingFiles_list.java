package revision_notes.chap09.c_9_4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class UsingFiles_list {
	// we know of file.listFiles() method
	// which lists the contents of a directory
	// which are a direct child of the parent file
	
	public static void main(String[] args) {
		String src = System.getProperty("user.dir")
				+ "/src";
		File file = new File(src);
		System.out.println(file.exists());
		
		File[] files = file.listFiles();
		Stream.of(files)
			.forEach(System.out::println);
/* returns only CHILDREN of source:
~src\.classpath
~src\.project
~src\.settings
~src\bin
~src\chapter_1
~src\chapter_10
~src\chapter_2
~src\chapter_3
~src\chapter_4
~src\chapter_5
~src\chapter_6
~src\chapter_7
~src\chapter_8
~src\chapter_9
~src\Dolphins.properties
~src\Dolphins_en.properties
~src\Dolphins_fr.properties
~src\goat.txt
~src\mule.png
~src\pom.xml
~src\review_questions
~src\revision_notes
~src\styles.css
~src\target
~src\ZooJava_en.java
~src\Zoo_en.properties
~src\Zoo_fr.properties

 */
		Path path = Paths
				.get("src");
		try {
			System.out.println("--------");
			Stream<Path> list = Files.list(path);
			list.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
/* Files.list() returns the same number of results
 * but in the form of a stream which can enable you to do
 * stream operations directly!!!
src\.classpath
src\.project
src\.settings
src\bin
src\chapter_1
src\chapter_10
src\chapter_2
src\chapter_3
src\chapter_4
src\chapter_5
src\chapter_6
src\chapter_7
src\chapter_8
src\chapter_9
src\Dolphins.properties
src\Dolphins_en.properties
src\Dolphins_fr.properties
src\goat.txt
src\mule.png
src\pom.xml
src\review_questions
src\revision_notes
src\styles.css
src\target
src\ZooJava_en.java
src\Zoo_en.properties
src\Zoo_fr.properties
 */
		}
		
		
		
	}

}
