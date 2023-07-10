package chapter_4.revision_notes;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingUsingPartitioning {

	public static void main(String[] args) {
		Stream<String> ohMy = Stream.of("lions","bears","tigers");
		Function<String, Integer> keyMapper = s-> s.length();
		Map<Boolean, List<String>> map = 
				ohMy.collect(Collectors.partitioningBy(s->s.length()<=5));
		System.out.println(map); // {false=[tigers], true=[lions, bears]}
		System.out.println(map.getClass()); // class java.util.stream.Collectors$Partition
		System.out.println(map.get(true).getClass()); //class java.util.ArrayList
	}
}
