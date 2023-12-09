package chapter_7.revisionNotes.javaCode;

import java.util.Arrays;

public class NonAssociativeAccumulator {
	public static void main(String[] args) {
		int x = 
		Arrays.asList(1,2,3,4,5,6)
		.stream()
		.reduce(0, (a,b)-> {System.out.println("a:"+a+" ,b:"+b); return a-b;});
		System.out.println(x);
	}
}
