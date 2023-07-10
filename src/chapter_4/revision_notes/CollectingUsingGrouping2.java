package chapter_4.revision_notes;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingUsingGrouping2 {
	public static void main(String[] args) {
		Stream<String> ohMy = Stream.of("lions","bears","tigers");
		Function<String, Integer> keyMapper = s-> s.length();
		Map<Integer, Set<String>> map = 
				ohMy.collect(Collectors.groupingBy(keyMapper, Collectors.toSet()));
		System.out.println(map); // {5=[lions, bears], 6=[tigers]}
		System.out.println(map.get(5).getClass()); // class java.util.HashSet

	}
}
