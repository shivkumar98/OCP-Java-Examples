package chapter_4.c_4_6_working_advanced_stream_pipeline_concepts.java;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingIntoMaps {
	public static void main(String[] args) {
		Stream<String> animals = Stream.of("Ape", "Bear", "Frog", "Tiger");
		Map<String, Integer> map = animals.collect(Collectors.toMap(s->s, s->s.length()));
		System.out.println(map); // {Frog=4, Ape=3, Bear=4, Tiger=5}
		
		Stream<String> animals2 = Stream.of("Ape", "Bear", "Frog", "Tiger");
		Map<Integer, String> map2 = animals2
		.collect(Collectors
				.toMap(s->s.length(), s->s, (s1,s2)->s1+","+s2));
		System.out.println(map2);
	}
}
