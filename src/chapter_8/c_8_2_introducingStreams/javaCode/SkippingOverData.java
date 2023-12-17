package chapter_8.c_8_2_introducingStreams.javaCode;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SkippingOverData {
	public static void main(String[] args) throws FileNotFoundException {
		String location = System.getProperty("user.dir")+"\\src"+
				"\\chapter_8\\c_8_2_introducingStreams\\javaCode\\data.txt";
		InputStream inputStream = new FileInputStream(location);
		BufferedInputStream bs = new BufferedInputStream(inputStream);	
	}
	
}
