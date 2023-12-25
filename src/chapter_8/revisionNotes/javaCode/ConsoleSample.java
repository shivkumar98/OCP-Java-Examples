package chapter_8.revisionNotes.javaCode;

import java.io.Console;

public class ConsoleSample {
	public static void main(String[] args) {
		Console console = System.console();
		if (console!=null) {
			System.out.println("enter some text");
			 String input = console.readLine("enter some text");
			 console.writer().println("You entered: "+input);
		}
	}
}
