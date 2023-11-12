package chapter_7.c_7_5_workingWithParallelStreams.javaCode;

import java.util.Arrays;

public class IndependentOperations {
	public static void main(String[] args) {
//		Arrays.asList("jackal","kangaroo","lemur")
//	    .parallelStream()
//	    .map(s -> s.toUpperCase())
//	    .forEach(System.out::println);
				
		Arrays.asList("jackal","kangaroo","lemur")
	    .parallelStream()
	    .map(s -> {System.out.println(s); return s.toUpperCase();})
	    .forEach(System.out::println);
	}

}
