package chapter_4.c_4_4_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PuttingPipelineTogether {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
		List<String> filteredSorted = list
				.stream()
				.filter(str -> str.length()==4)
				.sorted()
				.limit(2)
				.collect(Collectors.toList());
		System.out.println(filteredSorted); // [Alex, Anna]

	}
}
