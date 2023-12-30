package revision_notes.javaCode.chapter8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UsingBufferedReaderAndWriter {
	public static void main(String[] args) throws IOException {
		String srcLocation = System.getProperty("user.dir")+"\\src";
		String thisPackage = srcLocation+"\\revision_notes\\javaCode\\chapter8";
		String alphabetFile = thisPackage+"\\alphabet.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(alphabetFile));
			 BufferedReader reader = new BufferedReader(new FileReader(alphabetFile));) {
			writer.write("abcd\nefghi");
			String line;
			while((line=reader.readLine())!=null) {
				System.out.println(line);
			}
		}
	}
}
