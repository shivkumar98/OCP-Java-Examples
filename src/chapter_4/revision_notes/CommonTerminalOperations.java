package chapter_4.revision_notes;

import java.util.Comparator;
import java.util.stream.Stream;

public class CommonTerminalOperations {
	public static void main(String[] args) {
		Stream<Integer> infinite = Stream.generate(() -> 1);
		// infinite.count(); // PROGRAM HANGS
		Stream<String> finite = Stream.of("hello", "world");
		System.out.println(finite.count()); // 2
		
		Stream<String> str = Stream.of("z", "yy", "xxx");
		Comparator<String> comparator = (s1,s2) -> s1.compareTo(s2);
		//System.out.println(str.min(comparator)); // Optional[xxx]
		System.out.println(str.max((s1,s2)->s2.length()-s1.length()));
	}
}