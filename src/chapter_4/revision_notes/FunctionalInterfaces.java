package chapter_4.revision_notes;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaces {
	public static void main(String[] args) {
		Supplier<String> s = () -> "hello world";
		s.get(); // "hello world"
		Supplier<String> s2 = String::new;
		s2.get(); //new String();
		
		Consumer<String> c = System.out::println;
		c.accept("hello world"); // hello world
		// c.accept(1); // DOES NOT COMPILE
		Consumer<String> c2 = (x) -> new String(x);
		// System.out.println(c2.accept("hello")); // DOES NOT COMPILE
		
		BiConsumer<Integer, Integer> bc = (x,y) -> Math.addExact(x,y); 
		// While above does compile, its not useful
		// BiConsumer<String, String> bc2 = (x,y) -> x + y; // VOID METHODS CANNOT RETURN VALUE
		BiConsumer<String, String> printName = (x,y)-> System.out.println(x + " "+y);
		printName.accept("Shiv", "Kumar"); // Shiv Kumar
		
		Predicate<String> isLengthEqualTo4 = x-> x.length()==4;
		System.out.println(isLengthEqualTo4.test("hell")); // true		
		System.out.println(isLengthEqualTo4.test("hello")); // false
		
		// Predicate<String> pred = String::endsWith("hello"); // DOES NOT COMPILE
		Predicate<String> pred2 = String::isBlank;
		System.out.println(pred2.test("  ")); // true
		
		BiPredicate<String, String> containsAnotherString = String::contains;
		System.out.println(containsAnotherString.test("hello", "hell")); // true
		System.out.println(containsAnotherString.test("hello", "world")); // false
		
		Function<String, Integer> getLength = String::length;
		System.out.println(getLength.apply("hello")); // 5
		
		BiFunction<String, String, Boolean> bf = String::contains;
		System.out.println(bf.apply("hello", "el")); // true
		BiFunction<String, String, String> b2 = String::concat;
		System.out.println(b2.apply("hello", " world")); // hello world
		
		UnaryOperator<String> u = String::toUpperCase;
		System.out.println(u.apply("hello")); // HELLO
		
		BinaryOperator<String> bo = String::concat;
		System.out.println(bo.apply("hello ", "world")); // hello world

		
	}
}
