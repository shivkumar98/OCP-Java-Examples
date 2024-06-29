package review_questions.chapter_4.attempt_7.java;

import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Q11 {
	public static void main(String[] args) {
		String str = Stream.iterate(1, x->++x)
				.limit(5)
				.map(x -> ""+x)
				.collect(Collectors.joining());
		System.out.println(str);
				
		DoubleStream s = DoubleStream.of(1.2, 2.4);
		s.peek(System.out::println).filter(x -> x > 2).count();
	}
}
