package chapter_7.revisionNotes.javaCode;

import java.util.Arrays;

public class ParallelStreams {
	public static void main(String[] args) {
		Arrays.asList("1","2","3",
					  "4", "5", "6",
					  "7", "8", "9")
		.parallelStream()
		.map(s -> s.toUpperCase())
		.forEach(System.out::println);
	}
}
