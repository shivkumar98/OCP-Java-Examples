package chapter_3.revision_notes_v2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MapAPIs {
	public static void main(String[] args) {
		Map<String, Integer> restaurantRatings = new HashMap<>();
		BiFunction<Integer, Integer, Integer> updateIfOldValueIsSmaller
		= (v1,v2) -> v1>v2?v1:v2;
		restaurantRatings.merge("KFC", 7, updateIfOldValueIsSmaller);
		System.out.println(restaurantRatings);
		restaurantRatings.merge("KFC", 6, updateIfOldValueIsSmaller);
		System.out.println(restaurantRatings); // NO CHANGE
		restaurantRatings.merge("KFC", 8, updateIfOldValueIsSmaller);
		System.out.println(restaurantRatings); // {KFC=8}
		
		BiFunction<String, Integer, Integer> incrementIfPresent = (k,v)->v==null?0:++v; 
		restaurantRatings.computeIfPresent("KFC", incrementIfPresent);
		System.out.println(restaurantRatings); // {KFC=9}
		restaurantRatings.computeIfPresent("McD", incrementIfPresent);
		System.out.println(restaurantRatings); // NO CHANGE
	}
}
