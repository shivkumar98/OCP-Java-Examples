package chapter_4.c_4_2_workingWithBuiltInFunctionalInterfaces;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateInterface {
	
	public static void main(String[] args) {
		
		Predicate<String> p1 = s-> s.isEmpty();
		Predicate<String> p2 = String::isEmpty;
		
		System.out.println(p1.test("")); // true
		System.out.println(p2.test("s")); // false
		
		BiPredicate<String, String> bp1 = (x,y)-> x.endsWith(y);
		BiPredicate<String, String> bp2 = String::endsWith;
		System.out.println(bp1.test("Shiv","v")); // true
		System.out.println(bp2.test("Hello", "o")); // true
	}

}
