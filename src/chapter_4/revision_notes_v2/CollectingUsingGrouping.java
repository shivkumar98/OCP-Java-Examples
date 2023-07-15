package chapter_4.revision_notes_v2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingUsingGrouping {
	public static void main(String[] args) {
		Stream<String> empty = Stream.empty();
		Map<Integer, List<String>> emptyMap = empty.collect(Collectors.groupingBy(String::length));
		System.out.println(emptyMap); // {}
		
		Stream<String> str = Stream.of("lions", "tigers", "bears");
		Map<Integer, List<String>> map = str.collect(Collectors.groupingBy(x->x.length()));
		System.out.println(map); // {5=[lions, bears], 6=[tigers]}

		// we can change the values to a set, by overloading the collect() method:
		
		Stream<String> str2 = Stream.of("lions","tigers","bears", "bears");
		Map<Integer,Set<String>> map2 = str2.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
		System.out.println(map2); // {5=[lions, bears], 6=[tigers]}

		Stream<String> str3 = Stream.of("lions","tigers","bears", "bears");
		Map<Integer, List<String>> map3 = str3.collect(Collectors.groupingBy(String::length, HashMap::new, Collectors.toList()));
		System.out.println(map3); // {5=[lions, bears, bears], 6=[tigers]}

	}
}
