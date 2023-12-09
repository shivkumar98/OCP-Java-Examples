package chapter_7.revisionNotes.javaCode;

import java.util.Arrays;

public class ParallelStreams {
	public static void main(String[] args) {
		Arrays.asList("jackal","kangaroo","lemur")
		.parallelStream()
		.map(s -> s.toUpperCase())
		.forEach(System.out::println);
	}
}
