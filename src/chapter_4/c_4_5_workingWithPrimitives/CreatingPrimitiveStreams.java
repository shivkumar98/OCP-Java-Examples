package chapter_4.c_4_5_workingWithPrimitives;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreatingPrimitiveStreams {

	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1,2,3);
		IntStream intStream = stream.mapToInt(x->x);
		OptionalDouble avg = intStream.average();
		System.out.println(avg.getAsDouble()); // 2.0
		
		DoubleStream random = DoubleStream.generate(Math::random);
		random.limit(3).forEach(System.out::println);
		// 0.4458924136281954 0.24499242076227645 0.7380799157851783

		DoubleStream fractions = DoubleStream.iterate(0.5, d->d/2);
		fractions.limit(4).forEach(System.out::println);
		// 0.5 0.25 0.125 0.0625
		
		// suppose we want to create a stream from 1 to 5:
		IntStream count = IntStream.iterate(1,n->n+1)
				.limit(6);
		count.forEach(System.out::println); // 1 2 3 4 5 6
		
		// we can do this in a easier way using range():
		IntStream intRange = IntStream.range(1, 7);
		System.out.println("printing int range");
		intRange.forEach(System.out::println); // 1 2 3 4 5 6 7
		LongStream longStream = LongStream.range(1L,4L);
		longStream.forEach(System.out::println); // 1 2 3
		
		// There is no range for DoubleStream:
		// DoubleStream doubleRange = DoubleStream.range(1.0, 1.2); // DOES NOT COMPILE
		
		// We can create a closed range so that the boundary is only included
		System.out.println("printing closed range:");
		IntStream closedIntRange = IntStream.rangeClosed(1,6);
		closedIntRange.forEach(System.out::println); // 1 2 3

		// we can also create a primitive stream by mapping to another stream
		//Stream<Integer> integers = Stream.of(1,2,3);
		//IntStream ints = integers.mapToInt(x->x);
		//DoubleStream doubles = integers.mapToDouble(x->x);
		//LongStream longs = integers.mapToLong(x->x);
		
		// here is a realistic example:
		Stream<String> objStream = Stream.of("Fish", "Sticks");
		IntStream lengths = objStream.mapToInt(s->s.length());

	}
}
