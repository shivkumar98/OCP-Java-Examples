package chapter_4.c_4_6_working_advanced_stream_pipeline_concepts.java;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingUsingGroupingPartitioningMapping {
	
	public static void main(String[] args) {
		Stream<String> ohMy = Stream.of("lions","tigers","bears");
		Map<Integer, List<String>> map = ohMy.collect(Collectors.groupingBy(String::length));
		System.out.println(map); // {5=[lions, bears], 6=[tigers]}
		
		// changing return type to TreeMap<>:
		Stream<String> ohMy2 = Stream.of("lions","tigers","bears");
		TreeMap<Integer, Set<String>> map2 =
		    ohMy2.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
		System.out.println(map2); // {5=[lions, bears], 6=[tigers]}
		
		Stream<String> animals = Stream.of("lions", "tigers", "bears");
		Map<Boolean, List<String>> map3 = 
		    animals.collect(Collectors.partitioningBy(s->s.length()<6));
		System.out.println(map3); // {false=[tigers], true=[lions, bears]}
		
		Stream<String> ohMy4 = Stream.of("lions", "tigers", "bears");
		Map<Integer, Optional<String>> map4 = ohMy4.collect(
				Collectors.groupingBy(
				String::length,
				Collectors.mapping(s -> s,
				Collectors.minBy(Comparator.naturalOrder()))));
		System.out.println(map4); // {5=Optional[bears], 6=Optional[tigers]}

	}
}
