package chapter_9.c_9_3_understanding_file_attributes.java.c_9_3_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckingFileVisibility {
	// method signature:
	/* boolean isHidden(Path) throws IOException */
	// in linux systems, hidden files are prefixed with a .
	// in windows, you need to set the hidden property
	
	// I created a hidden file in this directory
	// hidden-file.txt
	
	// throws a checked IOException, e.g. if file does not exist
	
	public static void main(String[] args) {
		Path hiddenFile = Paths
			.get("src//"
				+ "chapter_9//"
				+ "c_9_3_understanding_file_attributes//"
				+ "java//"
				+ "c_9_3_1//"
				+ "hidden-file.txt");
		try {
			boolean x = Files.isHidden(hiddenFile);
			System.out.println(x); // prints true
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
}
