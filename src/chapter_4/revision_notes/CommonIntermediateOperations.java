package chapter_4.revision_notes;

import java.util.stream.Stream;

public class CommonIntermediateOperations {
	
	public static void main(String[] args) {
		Stream.of("monkey", "gorilla","chimp")
		.filter(x->x.startsWith("m")).forEach(System.out::print); // monkey
	}
}
