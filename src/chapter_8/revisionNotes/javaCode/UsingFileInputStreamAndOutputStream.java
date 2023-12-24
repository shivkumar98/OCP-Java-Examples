package chapter_8.revisionNotes.javaCode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UsingFileInputStreamAndOutputStream {
	public static void main(String[] args) throws IOException {
		String location = System.getProperty("user.dir")+"\\src"+"\\chapter_8"
				+"\\revisionNotes\\javaCode\\text.txt";
		FileOutputStream fos = new FileOutputStream(location);
		fos.write('a');
		FileInputStream fis = new FileInputStream(location);
		System.out.println("fis.read(): "+(char)fis.read()); // a
		System.out.println(fis.read()); // -1 returned to shows end of file
	}
}
