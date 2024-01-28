package revision_notes.javaCode.chapter4;

import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsingBasicCollectors {
	public static void main(String[] args) {
		Stream<String> ohMy = Stream.of("lions","tigers","bears");
		String result = ohMy.collect(Collectors.joining(","));
		System.out.println(result); // lions,tigers,bears

		Stream<String> lengths = Stream.of("1","333","7777777");
		ToIntFunction<String> mapper = s->s.length();
		Double averageLength = lengths.collect(Collectors.averagingInt(mapper));
		System.out.println(averageLength); // 3.67
		
		
		Stream<String> alphabet = Stream.of("d","a","e","c","b");
		Supplier<TreeSet<String>> collectionFactory = TreeSet::new;
		System.out.println(alphabet.collect(Collectors.toCollection(collectionFactory)));
		// [a, b, c, d, e]
	}
}
