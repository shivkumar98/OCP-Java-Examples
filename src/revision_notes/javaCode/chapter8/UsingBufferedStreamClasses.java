package revision_notes.javaCode.chapter8;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class UsingBufferedStreamClasses {
	
	public static void main(String[] args) throws IOException {
		String srcLocation = System.getProperty("user.dir")+"\\src";
		String thisPackage = srcLocation+"\\revision_notes\\javaCode\\chapter8";
		FileReader fileInputReader = new FileReader(thisPackage+"\\alphabet.txt");
		String alphabetFile = thisPackage+"\\alphabet.txt";
		
		BufferedInputStream bufferedInputStream
			= new BufferedInputStream(
				new FileInputStream(
					new File(alphabetFile)));
		int b;
		while ((b=bufferedInputStream.read()) != -1) {
			System.out.println((char)b);
		}
	}
}
