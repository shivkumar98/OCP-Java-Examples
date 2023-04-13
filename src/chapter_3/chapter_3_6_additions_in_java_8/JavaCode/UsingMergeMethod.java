package chapter_3.chapter_3_6_additions_in_java_8.JavaCode;

import java.util.*;
import java.util.function.BiFunction;

public class UsingMergeMethod {
	public static void main(String[] args) {
		Map<String, String> favorites = new HashMap<>();
		favorites.put("Shiv", "Uber");
		favorites.put("Sammy", "Tram");
		
		BiFunction<String, String, String>
		mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
		
		String shiv = favorites.merge("Shiv", "Helicopter", mapper);
		System.out.println(shiv); // Helicopter
		System.out.println(favorites); // {Sammy=Tram, Shiv=Helicopter}
		// ^^^ the Helicopter was merged in
		
		// We could also use a lambda expression directly:
		String shiv2 = favorites.merge("Shiv", "A massive truck!", (v1, v2)-> v1.startsWith("a")?v1:v2);
		System.out.println(shiv2); // A massive truck!
		System.out.println(favorites); // {Sammy=Tram, Shiv=A massive truck!}
		
		Map<String, Integer> restaurantsVisited = new HashMap<>();
		restaurantsVisited.put("Chung Ying", 5);
		restaurantsVisited.put("China Court", 10);
		
		restaurantsVisited.merge("China Court", 11, (v1,v2)->null);
		System.out.println(restaurantsVisited); // {Chung Ying=5}
		// The key-value pair was removed! 😲
		restaurantsVisited.merge("KFC", 1, (v1,v2)->null);
		System.out.println(restaurantsVisited); // {KFC=1, Chung Ying=5}

	}
}
