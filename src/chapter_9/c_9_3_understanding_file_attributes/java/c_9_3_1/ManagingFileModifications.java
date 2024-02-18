package chapter_9.c_9_3_understanding_file_attributes.java.c_9_3_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

public class ManagingFileModifications {
	// majority of OSs support tracking the last modified datetime of a file
	// applications can use this to determine if a file needs processing 
	// if its been modified
	// this is faster than loading the content of the file.
	/* Signature:
	 * FileTime getLastModifiedTime(Path) throws IOException
	 * Path setLastModifiedTime(Path,FileTime) throws IOException
	 */
	
	public static void main(String[] args) {
		Path file = Paths
				.get("src//"
					+ "chapter_9//"
					+ "c_9_3_understanding_file_attributes//"
					+ "java//"
					+ "c_9_3_1//"
					+ "ReadingFileLength.java");
		try {
			FileTime fileTime = Files.getLastModifiedTime(file);
			System.out.println(fileTime); // 2024-02-18T14:49:56.173496Z
			long epochTime = fileTime.toMillis(); 
			System.out.println(epochTime); // 1708267796173
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileTime fileTimeNow = FileTime.fromMillis(System.currentTimeMillis());
			System.out.println("fileTimeNow: "+fileTimeNow); // 2024-02-18T15:01:47.891Z
			Files.setLastModifiedTime(file, fileTimeNow);
			System.out.println(Files.getLastModifiedTime(file)); // 2024-02-18T15:01:47.891Z
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
