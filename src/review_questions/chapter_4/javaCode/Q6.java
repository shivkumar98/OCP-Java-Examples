package review_questions.chapter_4.javaCode;

import java.util.stream.Stream;

public class Q6 {
	
	public static void main(String[] args) {
		Stream<String> s = Stream.generate(() -> "meow");
		boolean match = s.allMatch(String::isEmpty);
		System.out.println(match);
	}
}
