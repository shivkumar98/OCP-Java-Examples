package chapter_3.revision_notes;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class LowerBoundedWildcards {
	static void addSound(List<? extends Object> list) {
		// list.add("hello"); // COMPILER ERROR
	}
	static void adddSoundUpperBounded(List<? super String> list) {
		list.add("hello");
	}
	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("hello", "world");
		List<Object> objectList = Arrays.asList("hello",2,null);
		// adddSound(stringList); // COMPILER ERROR
		addSound(objectList);     // WORKS FINE!
		adddSoundUpperBounded(stringList); // WORKS FINE!
		adddSoundUpperBounded(objectList); // WORKS FINE!
	}
}
