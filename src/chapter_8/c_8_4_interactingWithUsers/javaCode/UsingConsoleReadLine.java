package chapter_8.c_8_4_interactingWithUsers.javaCode;

import java.io.Console;

public class UsingConsoleReadLine {
	public static void main(String[] args) {
		Console console = System.console();
		console.writer().println("Enter your name: ");
		String userName = console.readLine();
		console.format("Hi %s, your name has %f characters", userName, userName.length());
	}
}
