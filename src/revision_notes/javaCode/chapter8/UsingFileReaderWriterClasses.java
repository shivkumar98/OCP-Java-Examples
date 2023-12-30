package revision_notes.javaCode.chapter8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UsingFileReaderWriterClasses {
	public static void main(String[] args) throws IOException {
		String srcLocation = System.getProperty("user.dir")+"\\src";
		String thisPackage = srcLocation+"\\revision_notes\\javaCode\\chapter8";
		String alphabetFile = thisPackage+"\\alphabet.txt";
		

//		FileWriter writer = new FileWriter(new File(alphabetFile));
//		writer.write("h");
//		
		FileReader fileReader = new FileReader(alphabetFile);
//		int b;
//		while ((b = fileReader.read())!=-1) {
//			System.out.println((char)b); // abcd efg hijk
//		}
		
		
		BufferedReader bufferedReader
			 = new BufferedReader(fileReader);
		String line;
		while((line=bufferedReader.readLine())!=null) {
			System.out.println(line); // abcd efg hijkk
		}
	}
}
