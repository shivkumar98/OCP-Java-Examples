package chapter_8.revisionNotes.javaCode;

import java.io.*;

public class UsingBufferedReaderAndBufferedWriter {
	public static void main(String[] args) throws IOException {
		String location = System.getProperty("user.dir")+"\\src"+"\\chapter_8"
				+"\\revisionNotes\\javaCode\\text4.txt";
		try (
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(location));
		BufferedReader bufferedReader = new BufferedReader(new FileReader(location))) {
			bufferedWriter.write("line 1");
			bufferedWriter.write("\nline 2");
			bufferedWriter.flush();
			System.out.println(bufferedReader.readLine()); // line 1
			System.out.println(bufferedReader.readLine()); // line 2
			System.out.println(bufferedReader.readLine()); // null
		}
		
		
	}
}
