package revision_notes.chap09.c_9_4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class UsingFiles_lines {
	public static void main(String[] args) {
		Path path = Paths.get("src");
		try {
			Stream<String> stream = Files.lines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
