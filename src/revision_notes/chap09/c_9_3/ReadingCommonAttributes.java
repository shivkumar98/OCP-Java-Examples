package revision_notes.chap09.c_9_3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingCommonAttributes {

	// Files class has three methods for determining file type
	// a regular file is defined as something which is NOT
	// a resource, directory, or symbolic link
	
	// isSymbolicLink() being true could mean that either isDirectory()
	// or isRegular file is true too, depending on where
	// the symbolic link points too
	
	public static void main(String[] args) {
		Path thisDirectory = Paths
			.get("src/revision_notes/chap09/c_9_3");
		System.out.println(Files.isDirectory(thisDirectory));
		// true
		System.out.println(Files.isRegularFile(thisDirectory) );
		// false
		System.out.println(Files.isSymbolicLink(thisDirectory));
		// false
		
		System.out.println("=-----------------------------------=");
		
		Path readMe = Paths
				.get("src/revision_notes/chap09/README.md");
		System.out.println(Files.isRegularFile(readMe));
		// true
		System.out.println(Files.isDirectory(readMe));
		// false
		System.out.println(Files.isSymbolicLink(readMe));
		// false
	}
}
