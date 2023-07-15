package chapter_4.revision_notes_v2;

import java.util.ArrayList;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectingUsingBasicCollectors {
	public static void main(String[] args) {
		Stream<String> str = Stream.of("shiv","hates","functional","programming");
		String string = str.collect(Collectors.joining(" "));
		System.out.println(string); // shiv hates functional programming
		
		Stream<String> strings = Stream.of("lions","tigers","bears");
		ToIntFunction<String> findLength = String::length;
		Double averageLengths = strings.collect(Collectors.averagingInt(findLength));
		System.out.println(averageLengths); // 5.333333333333333

		Stream<String> strings2 = Stream.of("lions","tigers","bears");
		ToDoubleFunction<String> toDoubleFunction = x -> x.length()/2.0;
		Double averagingLengthsDividedBy2 = strings2.collect(Collectors.averagingDouble(toDoubleFunction));
		System.out.println(averagingLengthsDividedBy2); // 2.6666666666666665

		
		Stream<String> str3 = Stream.of("lions","tiger","bears");
		ArrayList<String> result = str3.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(result); // [lions, tiger, bears]
		
	}
}
