package revision_notes.javaCode.chapter8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

public class UsingPrintStreamAndWriter {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String srcLocation = System.getProperty("user.dir")+"\\src";
		String thisPackage = srcLocation+"\\revision_notes\\javaCode\\chapter8";
		FileReader fileInputReader = new FileReader(thisPackage+"\\alphabet.txt");
		String alphabetFile = thisPackage+"\\alphabet.txt";
		PrintStream printStream = new PrintStream(
					new File(alphabetFile));
		printStream.format("my name is %s!", "shiv");
		printStream.printf("hello", 1);
		printStream.flush();
		Writer printWriter =
			new PrintWriter(new File(alphabetFile));
		
	}
}
