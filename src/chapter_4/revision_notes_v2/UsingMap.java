package chapter_4.revision_notes_v2;

import java.util.stream.Stream;

public class UsingMap {
	public static void main(String[] args) {
		Stream<String> strings = Stream.of("Hello", "World!");
		Stream<Integer> lengths = strings.map(x->x.length());
	}
}
