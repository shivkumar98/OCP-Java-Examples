package review_questions.chapter_4.attempt_5.javaCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Q13 {
	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(1,2,3);
		List<Integer> l2 = Arrays.asList(4,5,6);
		List<Integer> l3 = Arrays.asList();
		Stream.of(l1,l2,l3).flatMap(x->x.stream())
		.map(x->x+1).forEach(System.out::print);
	}
}
