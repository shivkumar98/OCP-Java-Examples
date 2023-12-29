package revision_notes.javaCode.chapter8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UsingInputStreamReader {
	public static void main(String[] args) throws IOException {
		String srcLocation = System.getProperty("user.dir")+"\\src";
		String thisPackage = srcLocation+"\\revision_notes\\javaCode\\chapter8";
		FileReader fileInputReader = new FileReader(thisPackage+"\\alphabet.txt");
		String alphabetFile = thisPackage+"\\alphabet.txt";
		
		InputStreamReader inputStreamReader
			= new InputStreamReader(new FileInputStream(new File(alphabetFile)));
		
		System.out.println((char)inputStreamReader.read()); // a
		
		// COMPILER ERROR BELOW:
		// inputStreamReader = new InputStreamReader(new FileReader(new File(alphabetFile)));
	}
}
