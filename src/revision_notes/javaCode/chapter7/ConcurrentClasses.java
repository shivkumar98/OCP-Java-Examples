package revision_notes.javaCode.chapter7;

import java.util.HashMap;
import java.util.Map;

public class ConcurrentClasses {
	public static void main(String[] args) {
		Map<String, Integer> food = new HashMap<>();
		food.putAll(Map.of("pizza", 1, "chicken", 2));
		for (String key: food.keySet()) {
			food.remove(key); // throws ConcurrentModificationException
		}
	}
}
