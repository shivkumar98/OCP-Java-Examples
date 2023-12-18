package chapter_8.c_8_3_workinWithStreams.javaCode;

import java.io.*;
import java.io.IOException;
import java.util.List;
import java.util.*;

public class WorkingWithBufferedReaderWriterClasses {
	static List<String> readFile(File source) throws IOException {
		List<String> data = new ArrayList<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(source))) {
			 String s;
			 while ((s=reader.readLine()) != null) {
				 data.add(s);
			 }
		}
		return data;
	}
	
	public static void main(String[] args) throws IOException {
		String source = System.getProperty("user.dir")+"\\src"+
				"\\chapter_8\\c_8_3_workinWithStreams\\javaCode\\text.txt";
		List<String> data = readFile(new File(source));
		System.out.println(data); 
		// [Line 1, Line 2, Line 3]

	}
}
