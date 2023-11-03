package chapter_7_v2.c_7_5_workingWithParallelStreams.javaCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StatefulOperations {
	public static void main(String[] args) {
		List<Integer> data =
				Collections
				.synchronizedList(new ArrayList<>());
		Stream<Integer> str = Arrays.asList(1,2,3,4,5,6)
				.parallelStream();
		str
			.map(i -> {data.add(i); return i;});
		System.out.println(str);
			
		// PRINTS: 1 2 3 4 5 6 
		System.out.println(data);
		// PRINTS: 1 6 3 4 2 5
	}
}
