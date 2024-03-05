package chapter_8.c_8_3_workinWithStreams.java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class WorkingWithFileOutputStream {
	public static void main(String[] args) throws IOException {
		String destination = System.getProperty("user.dir")+"\\src"+
				"\\chapter_8\\c_8_3_workinWithStreams\\javaCode\\output.txt";
		
		try (FileOutputStream out = new FileOutputStream(destination)) {
			char[] chars = new char[] {'t','i','g','e','r','s'};
			for (char c: chars) {
				out.write(c);
			}
		}
	}
}
