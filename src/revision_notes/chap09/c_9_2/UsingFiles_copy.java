package revision_notes.chap09.c_9_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingFiles_copy {
	public static void main(String[] args) {
		// Files.copy(source, target) makes shallow copies 
		// (it can not copy the contents of a folder)
		
		Path readMeFile = Paths
			.get("src/revision_notes/README.md");
		Path targetFile = Paths
			.get("src/revision_notes/chap09/new_folder/README.md");
		try {
			Path copiedPath = Files
					.copy(readMeFile, targetFile);
			System.out.println("copy: "+copiedPath);
		} catch (IOException e) {
			System.out.println("exception caught");
		}
		
	}
}
