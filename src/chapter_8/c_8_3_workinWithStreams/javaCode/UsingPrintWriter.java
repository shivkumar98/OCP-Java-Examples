package chapter_8.c_8_3_workinWithStreams.javaCode;

import java.io.FileNotFoundException;
import java.io.*;

public class UsingPrintWriter {
	public static void main(String[] args) throws FileNotFoundException {
		String zooLogFile = System.getProperty("user.dir")+"\\src"+
				"\\chapter_8\\c_8_3_workinWithStreams\\javaCode\\zoo.txt";
		System.out.println((new File(zooLogFile)).exists());
		PrintWriter out = new PrintWriter(zooLogFile);
		out.println(3);
		out.print(String.valueOf(4));
	}
}
