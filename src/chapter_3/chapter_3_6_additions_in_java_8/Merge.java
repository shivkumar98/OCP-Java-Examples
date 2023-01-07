package chapter_3.chapter_3_5_additions_in_java_8;

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
		System.out.println(favorites.merge("Jenny", "Bus", mapper)); // Bus Tour
		System.out.println(favorites.merge("Tom", "Skyride", mapper)); // Sky ride
		// the value was only update for Tom!
		// this is because tram is shorter than Skyride
		System.out.println(favorites); // {Tom=Skyride, Jenny=Bus Tour}

	}
}
