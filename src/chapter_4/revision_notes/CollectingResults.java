package chapter_4.revision_notes;

import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {
	public static void main(String[] args) {
		Stream<String> ohMy = Stream.of("lions","bears","tigers");
		ToIntFunction<String> findLength = s -> s.length();
		double result = ohMy.collect(Collectors.averagingInt(findLength));
		System.out.println(result); // 5.333333333333333
		
		Stream<String> str = Stream.of("lions","bears","tigers");
		Supplier<TreeSet<String>> s = () -> new TreeSet();
		TreeSet<String> tree = str
				.filter(x->x.length()==6)
				.collect(Collectors.toCollection(s));
		System.out.println(tree); // [tigers]
	}
}
