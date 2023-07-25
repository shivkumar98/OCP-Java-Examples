package chapter_3.revision_notes_v2;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {
	public static void main(String[] args) {
		List<String> list = GenericMethods.returnArrayList("hello world");
		System.out.println(list); // [hello world]
		List<String> list2 = GenericMethods.<String>returnArrayList("I'm a string");
		System.out.println(list2); // [I'm a string]

	}
	
	static <T> List<T> returnArrayList(T t) {
		List<T> arr = new ArrayList<>();
		arr.add(t);
		return arr;
	}
}
