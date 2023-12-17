package chapter_8.c_8_2_introducingStreams.javaCode;

import java.io.*;

public class MarkingTheStream {
	public static void main(String[] args) throws IOException {
	
		String location = System.getProperty("user.dir")+"\\src"+
				"\\chapter_8\\c_8_2_introducingStreams\\javaCode\\data.txt";
		InputStream inputStream = new FileInputStream(location);
		BufferedInputStream bs = new BufferedInputStream(inputStream);
		System.out.println((char) bs.read()); // A
		if (bs.markSupported()) {
			System.out.println("inside");
			bs.mark(2);
			System.out.println((char)bs.read());
			System.out.println((char)bs.read());
			System.out.println("before reset");
			bs.reset();
			System.out.println((char)bs.read());
			System.out.println((char)bs.read());
			System.out.println((char)bs.read());
			System.out.println((char)bs.read());
		}
		
	}
}
