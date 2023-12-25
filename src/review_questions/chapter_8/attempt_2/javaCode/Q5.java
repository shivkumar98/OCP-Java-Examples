package review_questions.chapter_8.attempt_2.javaCode;

import java.io.*;

public class Q5 {
		String line;
		Console c = System.console();
		Writer w  = c.writer();
		if((line = c.readLine()) != null) {
			w.append(line);
		}
	}
}
