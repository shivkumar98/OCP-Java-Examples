package chapter_4.revision_notes_v2;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingUsingPartitioning {
	public static void main(String[] args) {
		Stream<String> str = Stream.of("lions", "bears", "tigers");
		Map<Boolean, List<String>> map = str.collect(Collectors.partitioningBy(s->s.startsWith("x")));
		System.out.println(map); // {false=[lions, bears, tigers], true=[]}

		Stream<String> empty = Stream.empty();
		Map<Boolean, List<String>> map2 = empty.collect(Collectors.partitioningBy(s->s.startsWith("x")));
		System.out.println(map2); // {false=[], true=[]}
		
		Stream<String> str2 = Stream.of("lions","bears","tigers","bears");
		Map<Boolean, Set<String>> map3 = str2.collect(
				Collectors.groupingBy(
						s->s.startsWith("t"),
						Collectors.toSet()
				));
		System.out.println(map3); // {false=[lions, bears], true=[tigers]}

	}
}
