package chapter_8.revisionNotes.javaCode;
import java.io.*;
public class UsingPrintWriter {
	public static void main(String[] args) throws FileNotFoundException {
		String location = System.getProperty("user.dir")+"\\src"+"\\chapter_8"
				+"\\c_8_4_interactingWithUsers\\javaCode\\text.txt";
		File file = new File(location);
		System.out.println(file.exists()); // true
		PrintWriter writer = new PrintWriter(location);
		writer.print("hello");
	}
}
