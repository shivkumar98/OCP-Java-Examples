package revision_notes.javaCode.chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class ReadInputUsingInputStreamReader {
	public static void main(String[] args) throws IOException {
		Reader reader = new InputStreamReader(System.in);
//		System.out.println("Enter a character");
//		int input = reader.read();
//		System.out.println("You entered: "+(char)input);
		
		BufferedReader bufferedReader = 
			new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter a string:");
		String input = bufferedReader.readLine();
		System.out.printf("You entered: %s", input);
		
	}
}
