package chapter_3.chapter_3_6_additions_in_java_8.java;

import java.util.HashMap;
import java.util.Map;

public class MapAPI {
	public static void main(String[] args) {
		Map<String, String> favorites = new HashMap<>();
		favorites.put("Jenny", "Bus Tour");
		
		// suppose we want to update the value for Jenny
		// one way is to reinsert a key-value pair:
		favorites.put("Jenny", "Tram");
		System.out.println(favorites); // {Jenny=Tram}
		
		// the putIfAbsent method lets you set a value if it is null or absent
		favorites.put("Tom", null);
		favorites.putIfAbsent("Jenny", "Train");
		System.out.println(favorites); // {Tom=null, Jenny=Tram}
		favorites.putIfAbsent("Tom", "Tram");
		System.out.println(favorites); // {Tom=Tram, Jenny=Tram}

		

	}
}
