package revision_notes.javaCode.chapter7;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsingCollect {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("w","o","l","f")
				.parallel();
		System.out.println(Collectors.toSet().characteristics());
		// [UNORDERED, IDENTITY_FINISH]

		Set<String> set =
			stream.collect(Collectors.toSet());
		System.out.println(set); // [f, w, l, o]
		
		Stream<String> ohMy 
			= Stream.of("lions","tigers","bears")
			.parallel();
		ConcurrentMap<Integer,String> map = ohMy.collect(
			Collectors.toConcurrentMap(s->s.length(),
			k->k,
			(s1,s2)->s1+","+s2)
		);
		System.out.println(map); // {5=bears,lions, 6=tigers}
		
		Stream<String> parallelStream = Stream.of("lions", "tigers", "bears").parallel();
		ConcurrentMap<Integer, List<String>> groupedMap
			= parallelStream
			.collect(Collectors.groupingByConcurrent(str->str.length()));
		System.out.println(groupedMap); // {5=[lions, bears], 6=[tigers]}

	}
}
