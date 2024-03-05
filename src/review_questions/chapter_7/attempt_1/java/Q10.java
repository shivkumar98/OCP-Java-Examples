package review_questions.chapter_7.attempt_1.java;

import java.util.Arrays;

public class Q10 {
	public static void main(String[] args) {
		
		int x =
		Arrays.asList("duck","chicken",
				"flamingo","pelican")
		.parallelStream().parallel()
		.reduce(0,
			(partialLength,string)->partialLength+string.length(),
			(s1,s2)->s1+s2);
		System.out.println(x);
	}
}
