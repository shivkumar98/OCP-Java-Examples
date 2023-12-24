package chapter_8.revisionNotes.javaCode;
import java.io.*;

public class StreamBaseClasses {
	
	public static void main(String[] args) throws FileNotFoundException {
		// Input Stream:
		InputStream is = new BufferedInputStream(null);
		new BufferedInputStream(is);
		new BufferedInputStream(new FileInputStream("zoo.txt"));
		// new FileInputStream(new BufferedInputStream("zoo2.txt")); // COMPILER ERROR
	}
	
	
}
