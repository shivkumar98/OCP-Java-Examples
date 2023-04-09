package chapter_3.chapter_3_3_using_lists_sets_maps_queues;
import java.util.TreeMap;
import java.util.Map;

public class WorkingWithMaps {
	
	public static void main(String[] args) {
		Map<String, String> map = new TreeMap<>();
		map.put("koala", "bamboo");
		map.put("lion", "meat");
		map.put("giraffee", "leaf");
		for (String key: map.keySet())
			System.out.println(key);
	}

}
