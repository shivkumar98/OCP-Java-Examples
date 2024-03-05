package chapter_4.c_4_2_workingWithBuiltInFunctionalInterfaces.java;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateInterface {
	
	public static void main(String[] args) {
		
		Predicate<String> p1 = s-> s.isEmpty();
		Predicate<String> p2 = s -> s.contains("h"); // COMPILER ERROR
		
		
		System.out.println(p1.test("")); // true
		System.out.println(p2.test("hello")); // true
		
		BiPredicate<String, String> bp1 = String::contains;
		BiPredicate<String, String> bp2 = (x,y)->x.contains(y);
		System.out.println(bp1.test("Shiv","v")); // true
		System.out.println(bp2.test("Hello", "o")); // true
		
		// using default methods on Predicate:
		Predicate<String> egg = s->s.contains("egg");
		Predicate<String> brown = s->s.contains("brown");
		
		Predicate<String> brownEgg = egg.and(brown);
		System.out.println(brownEgg.test("I hate brown eggs!")); // true
		System.out.println(brownEgg.test("eggs")); // false
		
		// we also have the negate method
		Predicate<String> eggsWhichAreNotBrown = egg.and(brown.negate());
		System.out.println(eggsWhichAreNotBrown.test("I like eggs which are not brown")); // false
		
	}

}
