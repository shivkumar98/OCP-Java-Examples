package chapter_7_v2.c_7_5_workingWithParallelStreams.javaCode;

import java.util.Arrays;

public class CombiningResultsWithReduce {
	
	public static void main(String[] args) {
		
		int x = Arrays.asList(1,2,3,4,5,6)
			.stream()
			.reduce(0, (a,b)->a-b);
		// 0 - 1 - 2 - 3 - 4 - 5 - 6 
		// = -21
		System.out.println(x);
		
		int y = Arrays.asList(1,2,3,4,5,6)
			.parallelStream()
			.reduce(0, (a,b)->a-b);
		System.out.println(y);
		//  (1 op 2) op 3
		// = (1 - 2) op 3
		// = -1 op 3
		// = -4
		// 1 op (2 op 3)
		// = 1 op -1
		// = 2
		System.out.println(Arrays.asList("w","o","l","f")
    .parallelStream()
    .reduce("X", String::concat));
	}
	

}
