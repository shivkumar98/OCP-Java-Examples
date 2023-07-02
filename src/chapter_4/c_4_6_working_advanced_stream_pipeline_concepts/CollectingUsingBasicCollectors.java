package chapter_4.c_4_6_working_advanced_stream_pipeline_concepts;

import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingUsingBasicCollectors {
	
	public static void main(String[] args) {
		Stream<String> animals = Stream.of("lion","bear","tiger");
		Double avgLength = animals.collect(Collectors.averagingInt(String::length));
		System.out.println(avgLength); // 4.333333333333333
		
		Stream<String> animals1 = Stream.of("turtoise", "tiger", "lion");
		TreeSet<String> result = animals1.filter(s -> s.startsWith("t"))
		                                .collect(Collectors.toCollection(TreeSet::new));
		System.out.println(result);
	}
}
