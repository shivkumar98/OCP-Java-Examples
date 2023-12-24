package chapter_8.revisionNotes.javaCode;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UsingBufferedInputStream {
	public static void main(String[] args) throws IOException {
		String location = System.getProperty("user.dir")+"\\src"+"\\chapter_8"
				+"\\revisionNotes\\javaCode\\text2.txt";
		
		BufferedInputStream bufferedInputStream
			= new BufferedInputStream(new FileInputStream(location));
		BufferedOutputStream bufferedOutputStream
			= new BufferedOutputStream(new FileOutputStream(location));
		bufferedOutputStream.write('A');
		bufferedOutputStream.flush(); // necessary!
			
		System.out.println((char)bufferedInputStream.read());
		System.out.println(bufferedInputStream.read()); // -1
	}

}

