package chapter_3.chapter_3_6_additions_in_java_8.java;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class computeIfPresentandAbsent {
	
	public static void main(String[] args) {
		Map<String, Integer> counts = new HashMap<>();
		counts.put("Jenny", 1);
		BiFunction<String, Integer, Integer> mapper = (k, v) -> v + 1;

		// If the key is present, the value is updated according to mapper
		System.out.println(counts.computeIfPresent("Jenny", mapper)); // 2
		System.out.println(counts.computeIfPresent("Sammy", mapper)); // null
		System.out.println(counts); // {Jenny=2}
		
		Map<String, Integer> counts2 = new HashMap<>();
		Function<String,Integer> mapper2 = (k) -> 1;
		counts2.put("Jenny", 15);
		counts2.put("Tom", null);
		
		// if the key is absent, then its value 
		counts2.computeIfAbsent("Jenny", mapper2);
		counts2.computeIfAbsent("Sam", mapper2);
		System.out.println(counts2); // {Tom=null, Jenny=15, Sam=1}
		
	}

}
