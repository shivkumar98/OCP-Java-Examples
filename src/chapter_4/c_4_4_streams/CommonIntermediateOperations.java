package chapter_4.c_4_4_streams;

import java.util.stream.Stream;

public class CommonIntermediateOperations {
	public static void main(String[] args) {
		Stream<Integer> sequence = Stream.iterate(1,n-> n+2);
		sequence.limit(2).forEach(System.out::println); // 1 3
		
		Stream<Integer> sequence2 = Stream.iterate(1,n-> n+2);
		sequence2.skip(100).limit(2).forEach(System.out::println); // 201 203
		
		// using map:
		
		Stream<String> words = Stream.of("Shiv", "hates", "Java");
		words.map(x-> x.length()).forEach(System.out::println);
	}
	
	
}
