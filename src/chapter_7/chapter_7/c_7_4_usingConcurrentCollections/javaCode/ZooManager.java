package chapter_7.c_7_4_usingConcurrentCollections.javaCode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ZooManager {
	public static void main(String[] args) {
		Map<String, Object> food = new HashMap<>();
		food.put("chicken", 21);
		food.put("beef", 12);
//		for (String key: food.keySet())
//			food.remove(key); // throws ConcurrentModification exception
		
		Map<String, Object> concurrentFood = 
				new ConcurrentHashMap<>();
		concurrentFood.put("chicken", 21);
		concurrentFood.put("beef", 12);
		for (String key: concurrentFood.keySet()) {
			System.out.println("concurrentFood:"+concurrentFood);		
			concurrentFood.remove(key);
		}
	}
}
