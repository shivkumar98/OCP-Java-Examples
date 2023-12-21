package chapter_8.c_8_4_interactingWithUsers.javaCode;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInSample {
	public static void main(String[] args) {
		try (BufferedInputStream reader = new BufferedInputStream(new InputStreamReader(System.in))) {
			String userInput = reader.readLK;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
