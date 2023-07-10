package chapter_4.revision_notes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingUsingMapping {
		
	public static void main(String[] args) {
		Stream<String> str1 = Stream.of("bird", "bats", "ape", "pie");
		Map<Integer, List<String>> map = str1.collect(Collectors.groupingBy(s->s.length()));
		System.out.println(map); // {3=[ape, pie], 4=[bird, bats]}
		
		Stream<String> str2 = Stream.of("bird", "bats", "ape", "pie");
		Map<Integer, Optional<String>> map2 = str2
				.collect(Collectors.groupingBy(
						s-> s.length()
							)
						);
				

	}
	

}
