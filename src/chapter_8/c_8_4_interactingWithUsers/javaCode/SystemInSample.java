package chapter_8.c_8_4_interactingWithUsers.javaCode;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInSample {
	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Write something:");
			String userInput = reader.readLine();
			System.out.println("This is what you wrote: "+userInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
