package review_questions.chapter_4.attempt_5.javaCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Q7 {
	
	public static void main(String[] args) {
		List<String> letters = Arrays.asList("d","c","a","b");
		System.out.println(sort(letters)); // [d, c, b, a]
		
		System.out.println(letters
				.stream()
				.sorted((a,b)->b.compareTo(a))
				.collect(Collectors.toList())
		); // [d,c,b,a]
	}
	
	private static List<String> sort(List<String> list) {
		List<String> copy = new ArrayList<>(list);
		Collections.sort(list,(a,b)->b.compareTo(a));
		return copy;
	}
	
}


