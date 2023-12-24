package chapter_8.revisionNotes.javaCode;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UsingFilleReaderAndWriter {
	public static void main(String[] args) throws IOException {
		String location = System.getProperty("user.dir")+"\\src"+"\\chapter_8"
				+"\\revisionNotes\\javaCode\\text3.txt";
		try (
		FileWriter fileWriter = new FileWriter(location);
		FileReader fileReader = new FileReader(location)) {
			fileWriter.write("line 1");
			fileWriter.write("\nline 2");
			fileWriter.flush();
			System.out.println((char)fileReader.read()); // l
		}
		
		
	}
}
