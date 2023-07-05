package review_questions.chapter_4.javaCode;

import java.util.stream.Stream;

public class Q1 {
	public static void main(String[] args) {
		// What is the output of the following:
		Stream<String> stream = Stream.iterate("", (s)->s+"1");
		System.out.println(stream.limit(2).map(x -> x + "2")); // java.util.stream.ReferencePipeline$3@5679c6c6

	}
}
