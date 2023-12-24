package chapter_8.revisionNotes.javaCode;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UsingBufferedInputStream {
	public static void main(String[] args) throws FileNotFoundException {
		String location = System.getProperty("user.dir")+"\\src"+"\\chapter_8"
				+"\\revisionNotes\\javaCode\\text2.txt";
		BufferedInputStream bufferedInputStream
			= new BufferedInputStream(new FileInputStream(location));
	}
}
