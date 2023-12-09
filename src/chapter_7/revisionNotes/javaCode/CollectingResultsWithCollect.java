package chapter_7.revisionNotes.javaCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResultsWithCollect {
	public static void main(String[] args) {
		Stream<String> stream
			= Stream.of("w","o","l","f").parallel();
		SortedSet<String> set
			= stream.collect(
				()->new TreeSet<>(),
				(a,b)->{System.out.println("a:"+a+",b:"+b); a.add(b);},
				(t,c)->{System.out.println("t:"+t+",c:"+c); t.addAll(c);});
		System.out.println(set);
		
		System.out.println("==============================");
		
		Stream<String> ohMy = Stream.of("lions","tigers","bears")
			.parallel();
		ConcurrentMap<Integer, String> map = ohMy
			.collect(Collectors.toConcurrentMap(
				String::length, 
				k -> k,
				(s1, s2) -> s1 + "," + s2));
		System.out.println(map);
		
		System.out.println("==============================");

	}
}
