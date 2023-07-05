package review_questions.chapter_4.javaCode;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Q2 {
	public static void main(String[] args) {
		// what is the output
		Predicate<? super String> pred = s -> s.startsWith("g");
		Stream<String> stream1 = Stream.generate(() -> "growl");
		Stream<String> stream2 = Stream.generate(() -> "growl");
		boolean b1 = stream1.anyMatch(pred);
		boolean b2 = stream2.allMatch(pred);
		System.out.println(b1 +" "+ b2);
		
		// ANSWER: program hangs!
	}
}
