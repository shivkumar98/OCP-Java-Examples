package chapter_4.c_4_4_streams;

import java.util.Arrays;
import java.util.*;
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
		
		// using sorted()
		Stream<String> strings = Stream.of("BBBB", "A", "CC");
		strings.sorted().forEach(System.out::println); // A BBBB CC
		
		Stream<String> strings2 = Stream.of("BBBB", "A", "CC");
		strings2.sorted((x,y) -> Integer.compare(x.length(), y.length())).forEach(System.out::println); // A CC BBBB
		
		System.out.println("PEEKING");
		Stream<String> stream3 = Stream.of("black bear", "brown bear", "grizzly");
		long count = stream3
		.peek(System.out::println).count(); // grizzly
		System.out.println(count); // 1
		
		// changing state with peek()
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		List<Character> letters = new ArrayList<>();
		letters.add('c');	
		
		Stream<List<?>> streamX = Stream.of(numbers, letters);
		streamX.map(List::size).forEach(System.out::println); // 1 1
		
		StringBuilder builder = new StringBuilder();
		Stream<List<?>> goodStream = Stream.of(numbers, letters);
		goodStream
		.peek(l -> builder.append(l))
		.map(List::size)
		.forEach(System.out::println); // 1 1
		System.out.println(builder); // [1][c]
		
		Stream<List<?>> badStream = Stream.of(numbers, letters);
		badStream
		.peek(l -> l.remove(0))
		.map(List::size)
		.forEach(System.out::println); // 0 0
		
		
		
		
		
	
	}
}
