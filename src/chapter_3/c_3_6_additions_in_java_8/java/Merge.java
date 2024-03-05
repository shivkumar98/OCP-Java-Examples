package chapter_3.c_3_6_additions_in_java_8.java;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Merge {
	public static void main(String[] args) {
		// BiFunction is functional interface which accepts 2 parameters of same type
		// and returns 1 value of same type
		BiFunction<String, String, String> mapper = (v1,v2)
				-> v1.length() > v2.length() ? v1 : v2;
		
		Map<String, String> favorites = new HashMap<>();
		favorites.put("Jenny", "Bus Tour");
		favorites.put("Tom", "Tram");
		
		// we shall merge in a pair ("Jenny", "Skyride")
		// our mapper will update the value with the largest length
		favorites.merge("Jenny", "Skyride", mapper);
		System.out.println(favorites); // {Tom=Tram, Jenny=Bus Tour}
		
		// since Skyride has a shorter length it was not updated
		// let's try with a longer word!
		favorites.merge("Jenny", "Submarine ride", mapper);
		System.out.println(favorites); // {Tom=Tram, Jenny=Submarine ride}
		
		
		// what if the bifunction returns null?
		favorites.merge("Jenny", "Helicopter", (v1,v2) -> null);
		System.out.println(favorites); // {Tom=Tram}
	}
}
