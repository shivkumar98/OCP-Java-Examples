package review_questions.chapter_4.javaCode;

import java.util.stream.Stream;

public class Q10 {
	public static void main(String[] args) {
		Stream.generate(()-> "")
		.limit(10)
		.peek(System.out::println);
	}
}
