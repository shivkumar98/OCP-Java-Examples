package chapter_4.revision_notes;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReduceTerminalOperation {
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("w","o","l","f");
		String word = strings.stream().reduce("",(s,c)->s+c);
		System.out.println(word); // wolf
		
		Stream<Integer> ints = Stream.of(1,2,3,4);
		int product = ints.reduce(1, (p,x)->p*x);
		System.out.println(product); // 24
		
		BinaryOperator<Integer> op = (a, b) -> a * b;
		Stream<Integer> empty = Stream.empty();
		Stream<Integer> oneElement = Stream.of(3);
		Stream<Integer> threeElements = Stream.of(3, 5, 6);
		empty.reduce(op).ifPresent(System.out::print); // no output
		oneElement.reduce(op).ifPresent(System.out::println); // 3
		threeElements.reduce(op).ifPresent(System.out::println); // 90
	}
}
