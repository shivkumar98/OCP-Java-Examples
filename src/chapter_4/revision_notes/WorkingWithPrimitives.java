package chapter_4.revision_notes;

import java.util.OptionalDouble;
import java.util.stream.IntStream;
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
		
	}
}
