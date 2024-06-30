package review_questions.chapter_6.attempt_5.java;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Q3 {
	public static void main(String[] args) {
		try {
			throw new IOException();
		} catch (IOException e) {}
		
		try {		
		} catch (FileNotFoundException | IOException e) {}
		
		try {
		} catch (IOException | FileNotFoundException e) {}
	}
	
}
