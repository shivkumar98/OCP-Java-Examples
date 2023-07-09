package chapter_4.revision_notes;

import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class WorkingWithPrimitives {
	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1,2,3);
		// stream.sum(); DOES NOT COMPILE
		//stream.reduce(0, (s,n)->s+n); // 6
		
		// stream.reduce(0, (s,n)->s+n).sum(); // COMPILER ERROR
		stream.mapToInt(x->x).sum();
		
		IntStream ints = IntStream.of(1,2,3);
		OptionalDouble avg = ints.average(); 
		System.out.println(avg.getAsDouble()); // 2.0
		
		IntStream.range(1, 2);
		IntStream.rangeClosed(1, 3);
		LongStream.range(1, 2);
		LongStream.rangeClosed(1, 3);
		// DoubleStream.range(1,2); // COMPILER ERROR
		Stream.of(1,2).mapToDouble(x->x);
		Stream.of(1.2).mapToInt(x->1);
		Stream.of(2.1).mapToLong(x->1L);
		
		Double sum = DoubleStream.of(1,2,3)
				.sum();
		
		OptionalLong min = LongStream.of(1,2)
				.min();
	}
}
