package chapter_4.revision_notes_v2;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingUsingMapping {
	public static void main(String[] args) {
		Stream<String> str = Stream.of("tigers","lions","bears");
		Map<Integer, Optional<String>> map = str.collect(Collectors.groupingBy(
				String::length,
				Collectors.mapping(
						s->s,
						Collectors.minBy(Comparator.naturalOrder())
				)));
		System.out.println(map); // {5=Optional[bears], 6=Optional[tigers]}
			
	}
}
