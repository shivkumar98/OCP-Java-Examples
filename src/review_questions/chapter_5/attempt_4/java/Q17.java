package review_questions.chapter_5.attempt_4.java;

import java.util.Properties;

public class Q17 {
	public static void main(String[] args) {
		Properties prop = null;
		prop.get("key");
		prop.getProperty("key", "defaultvalue");
	}
}
