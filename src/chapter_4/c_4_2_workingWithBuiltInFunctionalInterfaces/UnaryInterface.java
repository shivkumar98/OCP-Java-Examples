package chapter_4.c_4_2_workingWithBuiltInFunctionalInterfaces;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryInterface {
	
	public static void main(String[] args) {
		
		UnaryOperator<String> u1 = String::toUpperCase;
		UnaryOperator<String> u2 = s-> s.concat(" x");
		System.out.println(u1.apply("shiv")); // SHIV
		System.out.println(u2.apply("shiv")); // shiv x
		
		BinaryOperator<String> b1 = String::concat;
		BinaryOperator<String> b2 = (x,y) -> x + " " + y;
		System.out.println(b1.apply("Shiv ", "Kumar")); // Shiv Kumar
		System.out.println(b2.apply("Shiv", "Kumar")); // Shiv Kumar
	}
}
