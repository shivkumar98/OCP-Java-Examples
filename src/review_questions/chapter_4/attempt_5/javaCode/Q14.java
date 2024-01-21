package review_questions.chapter_4.attempt_5.javaCode;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Q14 {
	public static void main(String[] args) {
		Stream<Integer> s = Stream.of(1);
		IntStream is = s.mapToInt(x->x);
		DoubleStream ds = is.mapToInt(x->x); // COMPILER ERROR
		ds.forEach(i->System.out.println("ds: "+i));
		
	}
}
