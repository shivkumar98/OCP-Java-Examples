package chapter_4.revision_notes_v2;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingIntoMaps {
	
	public static void main(String[] args) {
		Stream<String> str = Stream.of("lions","tigers","bears");
		Map<String, Integer> map = str.collect(Collectors.toMap(s->s, s->s.length()));
		System.out.println(map); // {lions=5, bears=5, tigers=6}
		
		Stream<String> str2 = Stream.of("lions","tigers","bears");
		// Map<Integer, String> map2 = str2.collect(Collectors.toMap(String::length, s->s));
		// System.out.println(map2); // Duplicate key 5 (attempted merging values lions and bears)
		
		// we can handle the merge conflicts:
		Stream<String> str3 = Stream.of("lions","tigers","bears");
		Map<Integer, String> map3 = str3.collect(
				Collectors.toMap(
						String::length,
						s->s,
						(s1,s2)->s1+","+s2)
				);
		System.out.println(map3); // {5=lions,bears, 6=tigers}
				

	}

}
