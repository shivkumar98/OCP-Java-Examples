package chapter_4.revision_notes;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingUsingGrouping4 {

	public static void main(String[] args) {
		Stream<String> ohMy = Stream.of("lions","bears","tigers");
		Function<String, Integer> keyMapper = s-> s.length();
		Map<Integer, List<String>> map = 
				ohMy.collect(Collectors.groupingBy(keyMapper, TreeMap::new, Collectors.toList()));
		System.out.println(map); // {5=[lions, bears], 6=[tigers]}
		System.out.println(map.getClass()); // class java.util.TreeMap
		System.out.println(map.get(5).getClass()); // class java.util.ArrayList
	}
}
