package revision_notes.javaCode.chapter4;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UsingPrimitiveStreams {

	public static void main(String[] args) {
		Stream<Double> stream = Stream.of(1.2);
		Stream<Double> stream2 = Stream.empty();
		
		DoubleStream doubleStream = DoubleStream.of(1.1);
		
		
		// Stream<Integer> range = Stream.range(1,2); // COMPILER ERROR
		//DoubleStream doubleRange = DoubleStream.range(1.2,1.4); // COMPILER ERROR
		IntStream intRange = IntStream.range(1, 3);
		// creates range from 1 to 2
		IntStream intRangeClosed = IntStream.rangeClosed(1, 3);
		// creates range from 1 to 3
		
		Stream<String> pizzas = Stream.of("1","22","333");
		IntStream pizzaSizes = pizzas.mapToInt(p->p.length()); // [1,2,3]
		System.out.println(pizzaSizes.collect(ArrayList::new, ArrayList::add, ArrayList::addAll));
	}
	
}
