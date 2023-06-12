package chapter_4.c_4_4_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CommonIntermediateOperations {
	public static void main(String[] args) {
		Stream<Integer> sequence = Stream.iterate(1,n-> n+2);
		sequence.limit(2).forEach(System.out::println); // 1 3
		
		Stream<Integer> sequence2 = Stream.iterate(1,n-> n+2);
		sequence2.skip(100).limit(2).forEach(System.out::println); // 201 203
		
		// using map:
		
		Stream<String> words = Stream.of("Shiv", "hates", "Java");
		words.map(x-> x.length()).forEach(System.out::println); // 4 5 4
		
		// using flat map:
		List<String> empty = Arrays.asList();
		List<String> one = Arrays.asList("Shiv");
		List<List<String>> nested = Arrays.asList(Arrays.asList("nested"));
		
		Stream<List> stream = Stream.of(empty, one, nested);
		stream.forEach(System.out::println); // [] [Shiv] [[nested]]
		
		Stream<List> stream2 = Stream.of(empty, one, nested);
		stream2.flatMap(l -> l.stream()).forEach(System.out::println); //   Shiv [nested]
		
		
	
	}
	
	
}
