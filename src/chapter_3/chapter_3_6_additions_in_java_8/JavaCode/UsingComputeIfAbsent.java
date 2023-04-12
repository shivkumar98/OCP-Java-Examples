package chapter_3.chapter_3_6_additions_in_java_8.JavaCode;
import java.util.*;

public class UsingComputeIfAbsent {
	
	public static void main(String[] args) {
		Map<String, String> favorites = new HashMap<>();
		favorites.put("Jenny", "Bus Tour");
		
		// updating a value using put:
		favorites.put("Jenny", "Tram");
		
		// using putIfAbsent which updates value if null
		System.out.println(favorites);
		// adding pair with null value:
		favorites.put("ShivHatesNulls", null);
		System.out.println(favorites); //{ShivHatesNulls=null, Jenny=Tram}
		
		favorites.putIfAbsent("ShivHatesNulls", "Car");
		System.out.println(favorites); // {ShivHatesNulls=Car, Jenny=Tram}
		// putIfAbsent does nothing for non-null values
		favorites.putIfAbsent("ShivHatesNulls", "Donkey");
		
		// we can also use putIfAbsent where the key is not present
		favorites.putIfAbsent("Sammy", "Rollercoaster");
		System.out.println(favorites); // {Sammy=Rollercoaster, ShivHatesNulls=Car, Jenny=Tram}

	}

}
