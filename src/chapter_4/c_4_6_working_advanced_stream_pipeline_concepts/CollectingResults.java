package chapter_4.c_4_6_working_advanced_stream_pipeline_concepts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {
	public static void main(String[] args) {
		Stream<Double> s = Stream.of(1.0,2.0,4.0);
		double avg = s.collect(Collectors.averagingDouble(i->i));
		System.out.println(avg); // 2.3333333333333335
		Stream<Double> s2 = Stream.of(3.3,3.3,3.4);

		System.out.println(s2.collect(Collectors.averagingInt(i->i.intValue()))); // 3.0
		
		System.out.println(Stream.of(1,2).collect(Collectors.counting())); // 2
		
		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "strawberry");
		
		Map<String, Long> groupedItems =
				items
				.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(groupedItems); // {orange=1, banana=2, apple=3, strawberry=1}

		Stream<String> str = Stream.of("Hello!", "My", "name","is","Shiv");
		String joined = str.collect(Collectors.joining(" "));
		System.out.println(joined); // Hello! My name is Shiv
		
		// using minBy/maxBy:
		Stream<String> str2 = Stream.of("1", "22", "333");
		Comparator<String> c = (x,y) -> Integer.compare(x.length(), y.length());
		Optional<String> smallest = str2.collect(Collectors.minBy(c));
		System.out.println(smallest.get()); // 1
		
		Stream<String> str3 = Stream.of("1", "22", "333");
		Optional<String> largest = str3.collect(Collectors.maxBy(c));
		System.out.println(largest.get()); // 3

		
		// using partioningBy(Predicate p):
		Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Map<Boolean, List<Integer>> map = s1.collect(Collectors.partitioningBy(i -> i>3));
		System.out.println(map); // {false=[1, 2, 3], true=[4, 5, 6, 7, 8, 9, 10]}

		
		// using summarizingDouble(ToDoubleFunction f):
		Stream<Double> str1 = Stream.of(1.0, 2.0, 3.0);
		DoubleSummaryStatistics stats = 
				str1.collect(Collectors.summarizingDouble(i->i));
		System.out.println(stats); // DoubleSummaryStatistics{count=3, sum=6.000000, min=1.000000, average=2.000000, max=3.000000}
		
		
		// using summingDouble:
		Stream<Double> stream = Stream.of(1.0, 2.0, 3.0);
		Double sum = stream.collect(Collectors.summingDouble(i->i/2));
		System.out.println(sum); // 3.0
		
		
		// using toList:
		Stream<String> friends = Stream.of("Sammy", "Rohan");
		List<String> list = friends.collect(Collectors.toList());
		System.out.println(list); // [Sammy, Rohan]
		}
}
