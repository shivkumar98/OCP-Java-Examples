package chapter_4.c_4_2_workingWithBuiltInFunctionalInterfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionInterface {
	
	public static void main(String[] args) {
		Function<String, Integer> f1 = String::length;
		System.out.println(f1.apply("Shiv")); // 4
		Function<String, Integer> f2 = s -> s.indexOf("i");
		System.out.println(f2.apply("shiv")); // 2
		
		BiFunction<String, String, Integer> bf1 = String::indexOf;
		System.out.println(bf1.apply("Shiv Kumar", "Ku")); // 5
		
		BiFunction<String, String, String> bf2 = String::concat;
		System.out.println(bf2.apply("1+1", "=2")); // 1+1=2
	}
}
