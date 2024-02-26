package revision_notes.chap09.c_9_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingCreateDirectory {
	public static void main(String[] args) {
		// this is equivalent to file.mkdir() and file.mkdirs()
		// this method throws checked exception
		// e.g. the directory already exists
		
		
		try {
			Path thisFolder = Paths.get("src/revision_notes/chap09");
			Path newFolder = thisFolder.resolve(Paths.get("new_folder"));
//			Path createdPath = 
//				Files.createDirectory(newFolder);
//			System.out.println("created: "+createdPath);
			Path newFolderWithExtension = thisFolder.resolve(Paths.get("new.txt"));
			Path createdPath2 = Files.createDirectory(newFolderWithExtension);
			System.out.println("created2: "+createdPath2);
		} catch (IOException e) {
			System.out.println(e.getCause());
			System.out.println("exception caught");
		}
	}
}
