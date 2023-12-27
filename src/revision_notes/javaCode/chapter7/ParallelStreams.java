package revision_notes.javaCode.chapter7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreams {
	public static void main(String[] args) {
		Arrays.asList(1,2,3,4,5,6)
			.parallelStream()
			.sorted()
			.forEach(System.out::println);
		
		List<String> list = Arrays.asList("Jackal", "Monkey", "Tiger")
			.parallelStream()
			.map(String::toUpperCase)
			.collect(Collectors.toList());
		System.out.println(list); // [JACKAL, MONKEY, TIGER]c
		int x = Arrays.asList("1234","56","789")
		.parallelStream()
		.reduce(0,
		(n,str)-> n + str.length(),
		(str1,str2)-> str1+str2);
		System.out.println(x); // 9
		
		String str = Arrays.asList("abc","de","fgh")
		.parallelStream()
		.reduce("", (result,s)->result+s.toUpperCase(), (s1,s2)->s1+s2);
		System.out.println(str); ///
	}
}
