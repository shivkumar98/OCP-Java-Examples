package revision_notes.chap09.c_9_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class UsingFiles_copy_withJavaIo {


	
	public static void main(String[] args) {
		String location = System.getProperty("user.dir")+
				"/src/revision_notes/chap09/README.md";
		try(InputStream is = new FileInputStream(location)) {
			long copied = Files.copy(is, Paths.get("src/revision_notes/chap09/c_9_1/copied.md"));
			System.out.println(copied); // 14492
		} catch (IOException e1) {
			System.out.println("exception caught");
		}
	}
}
