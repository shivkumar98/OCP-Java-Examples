package revision_notes.javaCode.chapter8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class UsingPrintStreamAndWriter {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String srcLocation = System.getProperty("user.dir")+"\\src";
		String thisPackage = srcLocation+"\\revision_notes\\javaCode\\chapter8";
		FileReader fileInputReader = new FileReader(thisPackage+"\\alphabet.txt");
		String alphabetFile = thisPackage+"\\alphabet.txt";
		PrintStream printStream = new PrintStream(
					new File(alphabetFile));
		
		PrintWriter printWriter =
			new PrintWriter(new File(alphabetFile));
		
	}
}
