package chapter_8.c_8_3_workinWithStreams.javaCode;

import java.io.File;
import java.io.IOException;
import java.io.*;

public class WorkingWithBufferedInputStream {
	public static void copy(File source, File destination) throws IOException {
		try (
			InputStream in = new BufferedInputStream(new FileInputStream(source));
			OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))
		) {
			byte[] buffer = new byte[1024];
			int lengthRead;
			while((lengthRead = in.read(buffer))>0) {
				System.out.println(lengthRead);
				out.write(buffer, 0, lengthRead);
				out.flush();
			}
		}
	}
	public static void main(String[] args) throws IOException {
		String source = System.getProperty("user.dir")+"\\src"+
				"\\chapter_8\\c_8_3_workinWithStreams\\javaCode\\data.txt";
		String destination = System.getProperty("user.dir")+"\\src"+
				"\\chapter_8\\c_8_3_workinWithStreams\\javaCode\\Returned-data.txt";
		File sourceFile = new File(source);
		File destinationFile = new File(destination);
		copy(sourceFile, destinationFile);
	}

}
