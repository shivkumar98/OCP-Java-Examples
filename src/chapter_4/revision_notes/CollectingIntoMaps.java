package chapter_4.revision_notes;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingIntoMaps {
	
	public static void main(String[] args) {
		Stream<String> str = Stream.of("lions","tigers","bears");
		Function<String, String> k = s -> s;
		Function<String, Integer> v = s -> s.length();
		Map<String, Integer> map = str.collect(Collectors.toMap(k, v));
		System.out.println(map); // {lions=5, bears=5, tigers=6}
		
		Stream<String> str1 = Stream.of("lions","tigers","bears");
		Function<String, Integer> keys = s -> s.length();
		Function<String, String> values = s -> s;
		Map<String, Integer> map1 = str.collect(Collectors.toMap(k, v));
		// THROWS EXCEPTION ^^^

	}

}
