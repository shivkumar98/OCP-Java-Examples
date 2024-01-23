package review_questions.chapter_4.attempt_5.javaCode;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q11 {

	public static void main(String[] args) {
		String string 
		= Stream.iterate(1, x->++x)
		.limit(5)
		.map(x->""+x)
		.collect(Collectors.joining(""));
		System.out.println(string);
	}
	
	
}
