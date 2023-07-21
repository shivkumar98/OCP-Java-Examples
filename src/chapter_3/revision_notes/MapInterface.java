package chapter_3.revision_notes;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapInterface {
	public static void main(String[] args) {
		Map<String, Integer> restaurantVisits = new HashMap<>();
		restaurantVisits.putIfAbsent("China Court", 1);
		restaurantVisits.putIfAbsent("China Court", 2);
		System.out.println(restaurantVisits); // {China Court=1}
		
		BiFunction<Integer,Integer, Integer> replaceIfSmaller = (v1,v2)->v1>v2?v1:v2;
		restaurantVisits.merge("China Court", 2, replaceIfSmaller); // {China Court=2} UPDATED
		System.out.println(restaurantVisits);
		restaurantVisits.merge("China Court", 1, replaceIfSmaller);
		System.out.println(restaurantVisits); // {China Court=2} NO CHANGE
		
		restaurantVisits.merge("McDonalds", 100, replaceIfSmaller);
		System.out.println(restaurantVisits); // {McDonalds=100, China Court=2} VALUE IS MERGED
		
		restaurantVisits.put("KFC", null);
		restaurantVisits.merge("KFC", 1, replaceIfSmaller);
		System.out.println(restaurantVisits); // {McDonalds=100, KFC=1, China Court=2} 
		
		BiFunction<Integer,Integer,Integer> mapsToNull = (v1,v2)-> null;
		restaurantVisits.merge("China Court", 999999, mapsToNull);
		System.out.println(restaurantVisits); // {McDonalds=100, KFC=1}
		
		Map<String, Integer> skills = new HashMap<>();
		skills.put("driving", 6);
		skills.put("coding", 7);
		BiFunction<String, Integer, Integer> increaseSkill = (k,v)->++v;
		skills.computeIfPresent("driving", increaseSkill);
		skills.computeIfPresent("hockey", increaseSkill); // does nothing if absent
		System.out.println(skills); // {driving=7, coding=7}
		
		Function<String,Integer> initialiseSkill = s->0;
		skills.computeIfAbsent("walking", initialiseSkill);
		skills.computeIfAbsent("walking", s->6999); // does nothing if present
		System.out.println(skills);  // {driving=7, coding=7, walking=0}
		
		skills.computeIfPresent("walking", (k,v)->null);
		System.out.println(skills);
		

	}
}
