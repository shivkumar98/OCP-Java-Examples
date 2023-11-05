package chapter_7_v2.c_7_5_workingWithParallelStreams.javaCode;

import java.util.Arrays;
import java.util.List;

public class ProcessingParallelReductions {
	public static void main(String[] args) {
//		int x = Arrays.asList(1,2,3,4,5,6)
//				.stream()
//				.findAny()
//				.get();
//		System.out.println(x);
//		
//		int y = Arrays.asList(1,2,3,4,5,6)
//				.parallelStream()
//				.findAny()
//				.get();
//		System.out.println(y);
		

		List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
		String result = letters
		  .stream()
		  .reduce("", (partialString, element) -> partialString + element);
		
		
		String str = Arrays.asList("w","o","l","f")
			.stream()
			.reduce("initial",(partial,c)->partial+c+" ");
		System.out.println(str);
		
		String str2 = Arrays.asList('w','o','l','f')
			.stream()
			.reduce("x", (c,d)->c+d+"1",(x,y)->x+y+2);
		System.out.println(str2);
		
		String str3 = Arrays.asList('w','o','l','f')
				.parallelStream()
				.reduce("", (p,c)->p+c,
				(x,y)->x+y);
		System.out.println(str3);
		

	}
}
