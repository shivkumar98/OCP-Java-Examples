package review_questions.chapter_5.attempt_1.javaCode;

import java.util.Locale;
import java.util.ResourceBundle;

public class Q04 {
	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "US"));
		ResourceBundle b = ResourceBundle.getBundle("Dolphins");
		System.out.println(b.getString("name"));
	}
}
