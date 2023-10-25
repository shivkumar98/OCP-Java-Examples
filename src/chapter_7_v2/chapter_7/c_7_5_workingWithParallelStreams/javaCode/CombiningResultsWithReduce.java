package chapter_7.c_7_5_workingWithParallelStreams.javaCode;

import java.util.Arrays;

public class CombiningResultsWithReduce {
	public static void main(String[] args) {
		long l = 
			Arrays.asList(1,2,3,4,5,6)
			.parallelStream()
			.reduce(0, (a,b)->a-b);
		System.out.println(l);
		
		System.out.println(
			Arrays.asList("w","o","l","f")
				.parallelStream()
				.reduce("X", String::concat));
	}
}
