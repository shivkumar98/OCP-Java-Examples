package revision_notes.chap09.c_9_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingFiles_move {

	// File.move(source,target) moves a file in 
	// the file system
	// this method throws IOException in the case
	// the file cannot be found
	
	public static void main(String[] args) {
		try {
			Path source = Paths.get("src/revision_notes/chap09/new1/file.txt");
			Path destination = Paths.get("src/revision_notes/chap09/new2/file.txt");
			Path movedFile = Files.move(source, destination);
			System.out.println(movedFile);
		} catch (IOException e) {
			System.out.println("exception");
		}
	}
}
