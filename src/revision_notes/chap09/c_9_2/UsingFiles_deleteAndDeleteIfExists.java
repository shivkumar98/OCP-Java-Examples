package revision_notes.chap09.c_9_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingFiles_deleteAndDeleteIfExists {

	public static void main(String[] args) {
		// delete method deletes file/empty directory
		// can throw IOexception for:
			// directory is not empty
			// file does not exist
		
		Path p1 = Paths
			.get("src/revision_notes/chap09/new1/delete1.txt");
		try {
			Files.delete(p1);
			System.out.println("file deleted");
		} catch (IOException e) {
			System.out.println("exception");
		}
		
		try {
			boolean deleted = Files.deleteIfExists(p1);
			System.out.println(deleted); // false
		} catch (IOException e) {
			System.out.println("exception 2");
		}
	}
}
