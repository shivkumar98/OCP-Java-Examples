package revision_notes.chap09.c_9_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

public class UsingFiles_getLastModifiedTime {
	public static void main(String[] args) {
		Path readMe = Paths.get("README.md");
		try {
			FileTime fileTime = Files.getLastModifiedTime(readMe);
			System.out.println(fileTime); // 2024-02-09T16:15:38.5052394Z

		} catch (IOException e) { }
		
		try {
			FileTime now = FileTime.fromMillis(System.currentTimeMillis());
			System.out.println(now); // 2024-02-27T09:58:35.534Z
			Path path = Files.setLastModifiedTime(readMe, now);
			System.out.println(path); // README.md
			System.out.println(Files.getLastModifiedTime(path));
			// 2024-02-27T09:58:35.534Z
		} catch (IOException e) {
		}
	}
}
