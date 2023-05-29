package chapter_4.c_4_3_returningAnOptional;

import java.util.Optional;
import java.util.function.Supplier;

public class ReturningOptional {

	public static Optional<Double> average(int... grades){
		if (grades.length==0) return Optional.empty();
		double sum = 0;
		for (int grade: grades) sum += grade;
		return Optional.of(sum/grades.length);
	}
	
	public static void main(String[] args) {
		
		System.out.println(average(95, 28).get()); // 61.5
		// average().get(); // throws exception "no value present"
		
		// Using ifPresent(Supplier s)
		average(100).ifPresent(System.out::println); // 100.0
		
		Optional<Double> nullOpt = average();
		System.out.println(nullOpt.orElse(Double.NaN)); // NaN
		System.out.println(nullOpt.orElseGet(Math::random)); // 0.48081772172470216
		System.out.println(nullOpt.orElseThrow(() -> new IllegalArgumentException()));
	}
}
