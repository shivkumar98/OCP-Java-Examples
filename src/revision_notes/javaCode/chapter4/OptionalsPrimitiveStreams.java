package revision_notes.javaCode.chapter4;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class OptionalsPrimitiveStreams {
	public static void main(String[] args) {
		IntStream intStream = IntStream.of(1,2);
		OptionalDouble intStreamAvg = intStream.average();
		System.out.println(intStreamAvg.getAsDouble()); // 1.5
		
		IntStream empty = IntStream.empty();
		System.out.println(empty.average().orElseGet(()->Double.NaN));
		// 				   ^^ NAN
		
		LongStream longStream = LongStream.of(1,2,3);
		System.out.println(longStream.average().getAsDouble()); // 2.0
		
		DoubleStream doubleStream = DoubleStream.of(1,2,34);
		System.out.println(doubleStream.average().getAsDouble()); // 12.33
	}
}
