package revision_notes.javaCode.chapter4;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

class NumberPrinter {
	static void printNumber(int i) {
		System.out.println("number: "+i);
	}
}
class NumberMultiplier {
	static void multiply(int m, int n) {
		System.out.println("product: "+m*n);
	}
}
public class UsingFunctionalInterfaces {
	
	
	public static void main(String[] args) {
		Supplier<String> supplier = ()-> "hello";
		supplier = () -> new String("s");
		
		Consumer<Integer> c = i -> NumberPrinter.printNumber(i);
		c.accept(1); // number: 1
		
		BiConsumer<Integer,Integer> c2 = NumberMultiplier::multiply;
		c2.accept(3, 4); // product 12
		
		Predicate<String> stringIsEmpty = str->str.isEmpty();
		System.out.println(stringIsEmpty.test("")); // true
		
		BiPredicate<String, Integer> stringIsOfLength = (str,size)-> str.length()==size;
		System.out.println(stringIsOfLength.test("helo", 4)); // true
		
		Predicate<String> containsVowel = t -> t.matches(".*[aeiou].*");
		Predicate<String> containsConstant =
				t -> t.matches(".*[bcdfghjklmnpqrstvwxyz].*");
		Predicate<String> containsVowelsOnly
		= containsVowel.and(containsConstant.negate());
		Predicate<String> containsNeitherVowelsOnConstants
			= containsVowel.negate().and(containsConstant.negate());
		
		System.out.println(containsVowelsOnly.test("ae")); // true
		System.out.println(containsVowelsOnly.test("abs")); // false
		
		System.out.println(containsNeitherVowelsOnConstants.test("!")); // true
		System.out.println(containsNeitherVowelsOnConstants.test("h!")); // false
		
		Function<String, Integer> f1 = String::length;
		System.out.println(f1.apply("hello")); // 5
		Function<String, Character> f2 = str->str.charAt(0);
		System.out.println(f2.apply("hello")); // h
		
		//UnaryOperator<String> b = str-> str.charAt(0); // COMPILER ERROR
		UnaryOperator<String> b1 = str->str+" world";
		System.out.println(b1.apply("hello")); // hello world
		
		BinaryOperator<String> b2 = String::concat;
		System.out.println(b2.apply("hello ", "world")); // hello world
		
		
		
	}

}
