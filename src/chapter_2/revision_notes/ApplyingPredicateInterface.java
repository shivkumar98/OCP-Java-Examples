package chapter_2.revision_notes;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ApplyingPredicateInterface {

	private static void check(Climb climb, int height) {
		if (climb.isTooHigh(height, 10))
			System.out.println("too high");
		else System.out.println("ok");
	}
	
	public static void main(String[] args) {
		Climb climb = (h,l)-> true;
		check(climb, 5); // too high
	}
}

interface Climb {
	boolean isTooHigh(int height, int limit);
}
