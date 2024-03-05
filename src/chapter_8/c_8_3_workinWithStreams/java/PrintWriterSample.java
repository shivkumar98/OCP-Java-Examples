package chapter_8.c_8_3_workinWithStreams.java;

import java.io.*;

public class PrintWriterSample {
	public static void main(String[] args) throws IOException {
		String destination = System.getProperty("user.dir")+"\\src"+
				"\\chapter_8\\c_8_3_workinWithStreams\\javaCode\\zoo.log";
		File source = new File(destination);
		try (PrintWriter out = new PrintWriter(new FileWriter(source))){
			out.print("Today's weather is: ");
			out.println("Sunny");
			out.println("Today's temperature is: "+1/3.0);
			out.print('C');
			out.format("It has rained %f inches this year", 1.2F);
		}
	}
}
