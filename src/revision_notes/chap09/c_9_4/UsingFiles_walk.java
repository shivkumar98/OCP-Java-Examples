package revision_notes.chap09.c_9_4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class UsingFiles_walk {

	
	public static void main(String[] args) {
		Path path = Paths
				.get("src/revision_notes/chap09");
		try {
			Stream<Path> stream = Files.walk(path);
//			stream.filter(p->p.toString().endsWith(".java"))
//			.forEach(System.out::println);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
src\revision_notes\chap09\c_9_1\UsingFileSystem.java
src\revision_notes\chap09\c_9_1\UsingPaths.java
src\revision_notes\chap09\c_9_2\NameMethods.java
src\revision_notes\chap09\c_9_2\PathComponentMethods.java
src\revision_notes\chap09\c_9_2\UsingCreateDirectory.java
src\revision_notes\chap09\c_9_2\UsingFilesExists.java
src\revision_notes\chap09\c_9_2\UsingFiles_copy.java
src\revision_notes\chap09\c_9_2\UsingFiles_copy_withJavaIo.java
src\revision_notes\chap09\c_9_2\UsingFiles_deleteAndDeleteIfExists.java
src\revision_notes\chap09\c_9_2\UsingFiles_move.java
src\revision_notes\chap09\c_9_2\UsingFiles_readAllLines.java
src\revision_notes\chap09\c_9_2\UsingIsAbsoluteAndToAbsolutePath.java
src\revision_notes\chap09\c_9_2\UsingIsSameFile.java
src\revision_notes\chap09\c_9_2\UsingNormalize.java
src\revision_notes\chap09\c_9_2\UsingRelativize.java
src\revision_notes\chap09\c_9_2\UsingResolve.java
src\revision_notes\chap09\c_9_2\UsingSubpath.java
src\revision_notes\chap09\c_9_2\UsingToRealPath.java
src\revision_notes\chap09\c_9_3\ReadingCommonAttributes.java
src\revision_notes\chap09\c_9_3\UsingFiles_getAttibuteView.java
src\revision_notes\chap09\c_9_3\UsingFiles_getLastModifiedTime.java
src\revision_notes\chap09\c_9_3\UsingFiles_getOwner.java
src\revision_notes\chap09\c_9_3\UsingFiles_isHidden.java
src\revision_notes\chap09\c_9_3\UsingFiles_isReadable_and_isExecutable.java
src\revision_notes\chap09\c_9_3\UsingFiles_readAttributes.java
src\revision_notes\chap09\c_9_3\UsingFiles_size.java
src\revision_notes\chap09\c_9_4\UsingFiles_walk.java
		 */
		
		try {
			Stream<Path> stream = Files.walk(path,1);
			stream.forEach(System.out::println);
			System.out.println("------------------");
			Files.walk(path, 0)
			.forEach(System.out::println);
			// src\revision_notes\chap09
			System.out.println("++++++++++++++++++");
			
			Files.walk(path, 1)
				.forEach(System.out::println);
			/*
src\revision_notes\chap09
src\revision_notes\chap09\c_9_1
src\revision_notes\chap09\c_9_2
src\revision_notes\chap09\c_9_3
src\revision_notes\chap09\c_9_4
src\revision_notes\chap09\new1
src\revision_notes\chap09\new2
src\revision_notes\chap09\README.md
			 */
			
			System.out.println("******************");
			
			Files.walk(path, 2)
				.forEach(System.out::println);
/*
src\revision_notes\chap09
src\revision_notes\chap09\c_9_1
src\revision_notes\chap09\c_9_1\UsingFileSystem.java
src\revision_notes\chap09\c_9_1\UsingPaths.java
src\revision_notes\chap09\c_9_2
src\revision_notes\chap09\c_9_2\NameMethods.java
src\revision_notes\chap09\c_9_2\PathComponentMethods.java
src\revision_notes\chap09\c_9_2\UsingCreateDirectory.java
src\revision_notes\chap09\c_9_2\UsingFilesExists.java
src\revision_notes\chap09\c_9_2\UsingFiles_copy.java
src\revision_notes\chap09\c_9_2\UsingFiles_copy_withJavaIo.java
src\revision_notes\chap09\c_9_2\UsingFiles_deleteAndDeleteIfExists.java
src\revision_notes\chap09\c_9_2\UsingFiles_move.java
src\revision_notes\chap09\c_9_2\UsingFiles_readAllLines.java
src\revision_notes\chap09\c_9_2\UsingIsAbsoluteAndToAbsolutePath.java
src\revision_notes\chap09\c_9_2\UsingIsSameFile.java
src\revision_notes\chap09\c_9_2\UsingNormalize.java
src\revision_notes\chap09\c_9_2\UsingRelativize.java
src\revision_notes\chap09\c_9_2\UsingResolve.java
src\revision_notes\chap09\c_9_2\UsingSubpath.java
src\revision_notes\chap09\c_9_2\UsingToRealPath.java
src\revision_notes\chap09\c_9_3
src\revision_notes\chap09\c_9_3\ReadingCommonAttributes.java
src\revision_notes\chap09\c_9_3\UsingFiles_getAttibuteView.java
src\revision_notes\chap09\c_9_3\UsingFiles_getLastModifiedTime.java
src\revision_notes\chap09\c_9_3\UsingFiles_getOwner.java
src\revision_notes\chap09\c_9_3\UsingFiles_isHidden.java
src\revision_notes\chap09\c_9_3\UsingFiles_isReadable_and_isExecutable.java
src\revision_notes\chap09\c_9_3\UsingFiles_readAttributes.java
src\revision_notes\chap09\c_9_3\UsingFiles_size.java
src\revision_notes\chap09\c_9_4
src\revision_notes\chap09\c_9_4\UsingFiles_walk.java
src\revision_notes\chap09\new1
src\revision_notes\chap09\new1\delete2.txt
src\revision_notes\chap09\new2
src\revision_notes\chap09\new2\file.txt
src\revision_notes\chap09\README.md
 */
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
