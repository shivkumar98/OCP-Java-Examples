package chapter_8.revisionNotes.javaCode;

import java.io.*;

public class SystemInSample {
	public static void main(String[] args) throws IOException {
		 try (BufferedReader reader = 
				 new BufferedReader(new InputStreamReader(System.in))) {
			 System.out.println("enter some text: ");
			 String input = reader.readLine();
			 System.out.println("You entered: "+input);
			 
		 }
	}
}
