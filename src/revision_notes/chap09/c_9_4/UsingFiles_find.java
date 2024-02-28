package revision_notes.chap09.c_9_4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.function.BiPredicate;

public class UsingFiles_find {
	public static void main(String[] args) {
		Path path = Paths
				.get("src/revision_notes/chap09/");
		long twentTwentFourMillis = 1704067260000l;
		FileTime twentyTwentyFour = FileTime.fromMillis(twentTwentFourMillis);
		System.out.println(twentyTwentyFour); // 2024-01-01T00:01:00Z
		
		try {
			BiPredicate<Path, BasicFileAttributes> biPredicate 
			= (p,a)-> p.toString().endsWith(".java")
				&& a.lastModifiedTime().toMillis()>twentyTwentyFour.toMillis();
			Files.find(path, 2, biPredicate)
				.forEach(System.out::println);
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
src\revision_notes\chap09\c_9_4\UsingFiles_find.java
src\revision_notes\chap09\c_9_4\UsingFiles_walk.java
 */
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
