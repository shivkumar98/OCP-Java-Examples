package revision_notes.javaCode.chapter8;

import java.io.Console;
import java.io.PrintWriter;
import java.io.Writer;

public class UsingConsole {
	public static void main(String[] args) {
		Console console = System.console();
		console.printf("My name is %s", "shiv");
		// ^ Prints My name is shiv to console
		PrintWriter writer = console.writer();
		writer.print("hello");
	}
}
