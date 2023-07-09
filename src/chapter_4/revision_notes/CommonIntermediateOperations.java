package chapter_4.revision_notes;

import java.util.Arrays;
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
	}
}
