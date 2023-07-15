package chapter_4.revision_notes_v2;

import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntSupplier;
import java.util.function.ToIntFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
	public static void main(String[] args) {
		Stream<Integer> str = Stream.of(1, 2, 3);
		IntStream intStream = str.mapToInt(x -> x);
		Stream<Double> str2 = Stream.of(1.2, 1.3);
		//IntStream intStream2 = str2.mapToInt(x -> x); // does not compile
		
		LongStream range = LongStream.range(1, 100);
		
		Stream<String> objStream = Stream.of("penguin", "fish");
		// creating IntStream
		ToIntFunction<String> toLength = x -> x.length(); 
		IntStream lengthsStream = objStream.mapToInt(toLength);
		// creating DoubleStream
		Stream<String> objStream2 = Stream.of("penguin", "fish");
		DoubleStream doubleStream = objStream2.mapToDouble(x-> x.length()/2.0);
		
		int[] grades = { 1, 3, 6};
		OptionalDouble avg = IntStream.of(grades).average();
		double avgAsDouble = avg.getAsDouble();
		System.out.println(avgAsDouble); // 3.3333333333333335
		
		OptionalInt emptyOptionalInt = OptionalInt.empty();
		IntSupplier intSupplier = () -> 1;
		int x = emptyOptionalInt.orElseGet(intSupplier);
		System.out.println(x); // 1
		
		IntStream emptyIntStream = IntStream.empty();
		int intSum = emptyIntStream.sum();
		System.out.println(intSum); // 0
		
		IntStream ints = IntStream.of(1, 4, 9);
		IntSummaryStatistics intSummary = ints.summaryStatistics();
		System.out.println(intSummary); // IntSummaryStatistics{count=3, sum=14, min=1, average=4.666667, max=9}
		double average = intSummary.getAverage();
		System.out.println(average); // 4.666666666666667
		
		IntStream empty = IntStream.empty();
		System.out.println(empty.summaryStatistics());
	}
	
	
}
