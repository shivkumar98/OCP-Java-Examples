package chapter_4.revision_notes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello", "Shiv", "Kumar");
		Stream<String> str = list.stream();
		Stream<Integer> str2 = Stream.empty();
		Stream<Integer> str3 = Stream.of(1);
		
		Stream<String> str4 = Stream.generate(() -> "hello world");
		Stream<Double> str5 = Stream.generate(Math::random);
		Stream<Integer> str6 = Stream.iterate(1, n->n+3);
	}
}
