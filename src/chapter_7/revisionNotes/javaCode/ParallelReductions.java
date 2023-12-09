package chapter_7.revisionNotes.javaCode;

import java.util.Arrays;

public class ParallelReductions {
	public static void main(String[] args) {
		int x =
			Arrays.asList(1,2,3,4,5,6)
			.parallelStream()
			.skip(5)
			.limit(2)
			.findFirst()
			.get();
		System.out.println(x);
	}
}
