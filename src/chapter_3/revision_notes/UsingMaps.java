package chapter_3.revision_notes;
import java.util.*;

public class UsingMaps {

	public static void main(String[] args) {
		Map<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(1, 101);
		hashMap.put(22, 102);
		hashMap.put(3, 103);
		hashMap.put(null, 0);
		System.out.println(hashMap); // {null=0, 1=101, 3=103, 22=102} insertion order NOT preserved
		
		Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put(1, 101);
		linkedHashMap.put(22, 102);
		linkedHashMap.put(3, 103);
		linkedHashMap.put(null, 0);
		System.out.println(linkedHashMap); // {1=101, 22=102, 3=103, null=0} insertion order IS preserved

		Map<String, Integer> treeMap = new TreeMap<>();
		treeMap.put("one", 1);
		treeMap.put("two", 2);
		treeMap.put("three", 3);
		treeMap.put("four", 4);
		// treeMap.put(null, 0); // CAN NOT USE NULL
		System.out.println(treeMap); // {four=4, one=1, three=3, two=2}
	}
	
	
}
