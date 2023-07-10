package chapter_4.revision_notes;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingUsingPartitioning2 {
	
	public static void main(String[] args) {
		Stream<String> ohMy = Stream.of("lions","bears","tigers");
		Function<String, Integer> keyMapper = s-> s.length();
		Map<Boolean, Set<String>> map = 
				ohMy.collect(Collectors.partitioningBy(s->s.length()<=5, Collectors.toSet()));
		System.out.println(map); // {false=[tigers], true=[lions, bears]}
		System.out.println(map.getClass()); // class java.util.stream.Collectors$Partition
		System.out.println(map.get(true).getClass()); // class java.util.HashSet

	
	}
}
