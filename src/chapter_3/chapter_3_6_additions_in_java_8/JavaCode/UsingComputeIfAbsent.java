package chapter_3.chapter_3_6_additions_in_java_8.JavaCode;
import java.util.*;
import java.util.function.Function;

public class UsingComputeIfAbsent {
	
	public static void main(String[] args) {
		Map<String, Integer> restaurantVisits = new HashMap<>();
		Function<String, Integer> mapper = k-> 1;
		// ^ notice how the function maps from String to Integer!
		restaurantVisits.computeIfAbsent("Chung Ying", mapper);
		// IF the key is not present, THEN the value is added using the mapper
		System.out.println(restaurantVisits); // {Chung Ying=1}
		
		restaurantVisits.put("China Court", null);
		restaurantVisits.computeIfAbsent("China Court", mapper);
		// again, IF the value is null THEN 
		System.out.println(restaurantVisits); // {Chung Ying=1, China Court=1}
		
		// what if the mapper, maps the value to null?
		restaurantVisits.computeIfAbsent("Chung Ying",k->null);
		System.out.println(restaurantVisits); // {Chung Ying=1, China Court=1}
		// NOTHING HAPPENED!
	}	

}
