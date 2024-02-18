package chapter_9.c_9_3_understanding_file_attributes.java.c_9_3_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingFileLength {
	// signature:
	/* long size(Path) throws IOException */
	// this returns CONCEPTUAL size which may be different from how much storage is used up
	// will throw exception if file does not exist or can 
	// not be read from the file information
	
	public static void main(String[] args) {
		Path file = Paths
				.get("src//"
					+ "chapter_9//"
					+ "c_9_3_understanding_file_attributes//"
					+ "java//"
					+ "c_9_3_1//"
					+ "ReadingFileLength.java");
		try {
			long size = Files.size(file);
			System.out.println(size); // 845
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}
	}
}
