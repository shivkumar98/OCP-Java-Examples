package revision_notes.chap09.c_9_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UsingFiles_readAllLines {
	public static void main(String[] args) {
		Path chap9RevNotes = Paths.get("src/revision_notes/chap09/README.md");
		try {
			List<String> lines = Files.readAllLines(chap9RevNotes);
			lines.forEach(System.out::println);
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
