package chapter_4.revision_notes;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingIntoMaps2 {
	
	 public static void main(String[] args) {
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
		Map<Integer, String> map = ohMy.collect(Collectors.toMap(s->s.length(), s->s, (s1,s2)-> s1+", "+s2));
		System.out.println(map); // {5=lions, bears, 6=tigers}
		System.out.println(map.getClass()); // class java.util.HashMap


	}

}
