package revision_notes.chap09.c_9_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingFiles_isHidden {

	public static void main(String[] args) {
		Path fake = Paths.get("fake/madeup.txt");
		try {
			boolean hidden = Files.isHidden(fake);
			System.out.println(hidden);
		} catch (IOException e) {
			System.out.println("Exception 0");
			// exception caught!!!
		}
		Path nonHidden = Paths.get("README.md");
		try {
			System.out.println(Files.isHidden(nonHidden));
			// false
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
