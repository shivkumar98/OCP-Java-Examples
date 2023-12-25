package chapter_8.revisionNotes.javaCode;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class UsingPrintWriterAndReader {
	
	public static void main(String[] args) throws FileNotFoundException {
		String location = System.getProperty("user.dir")+"\\src"+"\\chapter_8"
				+"\\revisionNotes\\javaCode\\usingPrintWriter.txt";
		PrintWriter printWriter = new PrintWriter(location);
		Animal animal = new Animal("Tiger",1,'m');
		printWriter.print(animal);
		printWriter.print("\n line 2");
		printWriter.print(5);
		printWriter.format("It is %f degrees today",1/3.0);
		
		printWriter.flush();
		
//		PrintStream printStream = new PrintStream(location);
//		printStream.print(animal);
//		printStream.flush();
	}

}
