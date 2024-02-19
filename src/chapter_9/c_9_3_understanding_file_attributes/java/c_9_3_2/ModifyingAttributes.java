package chapter_9.c_9_3_understanding_file_attributes.java.c_9_3_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;

public class ModifyingAttributes {

	// File.readAttributes does not provide a mechanism for
	// modifying attributes
	// File.getAttributeView DOES, signature:
	/* <V extends FileAttributeView> 
	 * V getFileAttributeView(Path ,Class<V>
	 */
	
	// the BasicFileAttributeView class has a setTimes method:
	/* void setTimes(lastModifiedTime, lastAccessTime, creationTime) throws IOException  */
	
	public static void main(String[] args) {
		Path file = Paths
				.get("src//"
					+ "chapter_9//"
					+ "README.md");
		BasicFileAttributeView view = Files
			.getFileAttributeView(file, BasicFileAttributeView.class);
		
		try {
			BasicFileAttributes data = view.readAttributes();
			FileTime lastModified = data.lastModifiedTime();
			System.out.println(lastModified); // 2024-01-09T07:52:15.2344042Z
			FileTime newLastModified = FileTime.fromMillis(lastModified.toMillis()+10_000);
			view.setTimes(newLastModified, null, null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
