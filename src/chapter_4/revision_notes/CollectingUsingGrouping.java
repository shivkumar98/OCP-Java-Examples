package chapter_4.revision_notes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingUsingGrouping {
	
	public static void main(String[] args) {
		Stream<String> ohMy = Stream.of("lions","bears","tigers");
		Map<Integer, List<String>> map = ohMy.collect(Collectors.groupingBy(s-> s.length()));
		System.out.println(map); // {5=[lions, bears], 6=[tigers]}

	}
}
