package review_questions.chapter_8.attempt_2.java;

import java.io.*;

public class Q5 {
	public static void main(String[] args) throws IOException {
		String line;
		Console c = System.console();
		Writer w  = c.writer();
		if((line = c.readLine()) != null) {
			w.append(line);
		}
	}
		
}
