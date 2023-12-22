package chapter_8.c_8_4_interactingWithUsers.javaCode;

import java.io.Console;
import java.io.PrintWriter;
import java.io.Reader;

public class UsingConsole {
	public static void main(String[] args) {
		Console console = System.console();
		if (console == null) {
			throw new RuntimeException();
		} else {
			console.writer().println("Welcome to our zoo!");
			console.format("This zoo has %f animals and employs %f people", 201, 25);
		}
	}
}
