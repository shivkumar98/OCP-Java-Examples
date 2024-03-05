package chapter_3.c_3_3_using_lists_sets_maps_queues;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapMethods {
	
	public static void main(String[] args) {
		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("first", 1);
		map.put("second", 2);
		map.put("third", 3);	
		System.out.println(map); // {first=1, second=2, third=3}

		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("first", 1);
		hashMap.put("second", 2);
		hashMap.put("third", 3);
		System.out.println(hashMap); // {third=3, first=1, second=2}
	}

}
