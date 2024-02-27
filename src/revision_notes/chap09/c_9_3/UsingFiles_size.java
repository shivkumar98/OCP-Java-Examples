package revision_notes.chap09.c_9_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingFiles_size {
	public static void main(String[] args) {
		Path path = Paths.get("README.md");
		try {
			long x = Files.size(path);
			System.out.println(x); //1580
		} catch (IOException e) {
			System.out.println("£");
	}
	}
}
