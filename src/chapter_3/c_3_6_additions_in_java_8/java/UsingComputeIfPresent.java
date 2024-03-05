package chapter_3.c_3_6_additions_in_java_8.java;

import java.util.HashMap;
import java.util.Map;

public class UsingComputeIfPresent {
	public static void main(String[] args) {
		Map<String, Integer> restaurantVisits = new HashMap<>();
		restaurantVisits.put("KFC", 3);
		restaurantVisits.put("Chung Ying", 4);
		
		// using computeIfPresent:
		restaurantVisits.computeIfPresent("Chung Ying", (k,v)->k==null?0:++v);
		System.out.println(restaurantVisits); // {KFC=3, Chung Ying=5}
		
		// What if we map to null?
		restaurantVisits.computeIfPresent("KFC", (k,v)->null);
		System.out.println(restaurantVisits); // {Chung Ying=5}
		// ^ The pair was removed!
		
		restaurantVisits.computeIfPresent("McDonalds", (k,v)->null);
		System.out.println(restaurantVisits); // {Chung Ying=5}
		// ^ Nothing happens if key is not present
		Map<Integer, Integer> map = new HashMap<>(10);
		for (int i = 1; i <= 10; i++) {
		map.put(i, i * i);
		 }
		 System.out.println(map.get(4));
	}
}
