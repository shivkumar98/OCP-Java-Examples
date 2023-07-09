package chapter_4.revision_notes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class CommonIntermediateOperations {
	
	public static void main(String[] args) {
		Stream.of("monkey", "gorilla","chimp")
		.filter(x->x.startsWith("m")).forEach(System.out::print); // monkey
		
		Stream.of("duck", "duck", "Duck", "goose", "goose")
		.distinct().forEach(System.out::print); // duckDuckgoose
		
		System.out.println("-----------------------");
		
		Stream.of("duck", "duck", "Duck", "goose", "goose")
		.skip(2).forEach(System.out::print); // Duckgoosegoose
		
		Stream.iterate(1, n->n+1)
			.limit(5)
			.skip(2)
			.forEach(System.out::println); // 3 4 5
		
		System.out.println("-------------------");
		
		Stream.of("monkey", "gorilla", "chimp")
		.map(x->x.length())
		.map(x->x+2)
		.forEach(System.out::println); // 8 9 7
		
		System.out.println("---------------------");
		Stream.of(Arrays.asList(1,2,3))
		.flatMap(l->l.stream())
		.forEach(System.out::println); // 1 2 3
		
		System.out.println("---------------------");
		
		Stream.of("brown bear", "grizzly bear")
		.sorted()
		.forEach(System.out::println); // brown bear grizzly bear
		
		Stream.of("brown bear", "grizzly bear")
		.sorted(Comparator.reverseOrder())
		.forEach(System.out::println); // grizzly bear brown bear
		
		System.out.println("------------------------");
		
		long count = Stream.of("black bear", "brown bear", "grizzly")
		.filter(x->x.startsWith("b"))
		.peek(System.out::println) // black bear brown bear
		.count();
		System.out.println(count); // 2

	}
}
