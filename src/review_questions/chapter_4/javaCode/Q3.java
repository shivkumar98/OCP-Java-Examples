package review_questions.chapter_4.javaCode;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Q3 {
	
	public static void main(String[] args) {
		// what is the output of the following?
		Predicate<? super String> predicate = s -> s.length() > 3;
		Stream<String> stream = Stream.iterate("-", (s) -> s + s);
		boolean b1 = stream.noneMatch(predicate);
		boolean b2 = stream.anyMatch(predicate);
		// ANSWER: line 13 throws exception 
	}

}
