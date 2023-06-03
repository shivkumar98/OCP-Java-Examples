package chapter_4.c_4_4_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreatingStreamSources {
	
	public static void main(String[] args) {
		Stream<String> empty = Stream.empty();
		Stream<Integer> singleElement = Stream.of(1);
		Stream<Integer> fromArray	  = Stream.of(1,2,3);
		
		// Java lets you convert list to stream:
		List<String> list = Arrays.asList("a","b","c");
		Stream<String> fromList = list.stream();
		// we can process a stream elements in paralleL
		Stream<String> fromListParallel = list.parallelStream();
		
		// the above are finite streams
		
		// we can also generate infinite streams:
		Stream<Double> randoms = Stream.generate(Math::random);
		// randoms.forEach(System.out::println);
		Stream<Double> constant = Stream.generate(() -> 1.2);
		// constant.forEach(System.out::println);
		
		Stream<Integer> oddNumbers = Stream.iterate(1, n-> n+2);
		//oddNumbers.forEach(System.out::println);
		
		Stream<Integer> nums = Stream.of(1,2,3);
		System.out.println(nums.count()); // 3
	}

}
