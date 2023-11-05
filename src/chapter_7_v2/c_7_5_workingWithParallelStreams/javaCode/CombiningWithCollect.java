package chapter_7_v2.c_7_5_workingWithParallelStreams.javaCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CombiningWithCollect {
	public static void main(String[] args) {
		TreeSet<Integer> r = Arrays.asList(1,2,3,4,5)
		.stream()
		.collect(TreeSet::new, Set::add, Set::addAll);
		System.out.println(r); // 1 2 3 4 5
		
		TreeSet<Integer> s = Arrays.asList(1,2,3,4,5)
				.parallelStream()
				.collect(TreeSet::new, Set::add, Set::addAll);
		System.out.println(s);
		
		Stream<String> str = Stream.of("w","o","l","f")
				.parallel();
		SortedSet<String> set = 
			str.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
		System.out.println(set);
		
		Stream<String> stream = Stream.of("lions","tigers", "bears");
		
		Map<Integer,String> map = stream
				.collect(Collectors.toMap(String::length,
						k -> k, (s1,s2)->s1+","+s2));
		System.out.println(map); // {5=lions,bears, 6=tigers}
		System.out.println(map.getClass()); // HashMap
		
		Stream<String> parallelStream = 
				Stream.of("lions","tigers", "bears")
				.parallel();

		
		Map<Integer,String> map2 =
				parallelStream
				.collect(
					Collectors.toConcurrentMap(
							String::length,
							k->k,
							(s1,s2)->s1+","+s2
					)
				);
		System.out.println(map2);
		
		Stream<String> parallelStr =
				Stream.of(
						"lions",
						"tigers",
						"bears"
				).parallel();
//		Map<Integer,List<String>> map3 
//			= parallelStr
//				.collect(Collectors.groupingBy(String::length));
//		System.out.println(map3); // {5=[lions, bears], 6=[tigers]}
//		System.out.println(map3.getClass());
		ConcurrentMap<Integer,List<String>> map4
		 	= parallelStr.collect(
		 			Collectors.groupingByConcurrent(String::length)
		 		);
		System.out.println(map4);
		System.out.println(map4.getClass());
		// {5=[lions, bears], 6=[tigers]}
	}
}
