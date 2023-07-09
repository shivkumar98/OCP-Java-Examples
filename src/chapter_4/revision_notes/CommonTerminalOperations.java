package chapter_4.revision_notes;

import java.util.stream.Stream;

public class CommonTerminalOperations {
	public static void main(String[] args) {
		Stream<Integer> infinite = Stream.generate(() -> 1);
		// infinite.count(); // PROGRAM HANGS
		Stream<String> finite = Stream.of("hello", "world");
		System.out.println(finite.count());
	}
}
