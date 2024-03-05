package chapter_4.c_4_4_streams.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CommonTerminalOperations {
	
	
	
	public static void main(String[] args) {
		Comparator<String> byLength = (x,y) -> x.length()-y.length();
		Stream<String> strings = Stream.of("1", "4444", "666666");
		System.out.println(strings.max(byLength)); // Optional[666666]
		// System.out.println(strings.max()); // COMPILER ERROR

		Stream<Integer> nonEmpty = Stream.of(1);
		Stream<Integer> empty	 = Stream.empty();
		System.out.println(nonEmpty.findFirst()); // Optional[1]
		System.out.println(empty.findAny()); // Optional.empty
		
		Stream<String> monkies = Stream.generate(()-> "monkey");
		System.out.println(monkies.findAny()); // Optional[monkey]
		// System.out.println(monkies.findFirst()); // throws exception
		
		List<String> list 	    = Arrays.asList("monkey", "2", "chimp");
		Stream<String> infinite = Stream.generate(()->"chimp");
		Predicate<String> pred  = x -> Character.isLetter(x.charAt(0));
		
		System.out.println(list.stream().anyMatch(pred)); // true
		System.out.println(list.stream().allMatch(pred)); // false
		// System.out.println(infinite.anyMatch(pred)); 	  // true
		// System.out.println("infi" + infinite.allMatch(pred));  // does not terminate
		
		// using reduce: 
		String[] arr = {"Shiv ", "hates ", "Java "};
		Stream<String> stream = Stream.of(arr);
		String reduction = stream.reduce("", (x,y) -> x.concat(y));
		System.out.println(reduction); // "Shiv hates Java " 
		
		// using method ref:
		Stream<String> stream2 = Stream.of(arr);
		String red = stream2.reduce("", String::concat);
		System.out.println(red);  // "Shiv hates Java " 
		
		Integer[] nums = {3,4,2};
		Stream<Integer> intStream = Stream.of(nums);
		int product = intStream.reduce(1, (a,b) -> a*b);
		System.out.println(product);
		
	}
}
 