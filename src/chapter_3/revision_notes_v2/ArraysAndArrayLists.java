package chapter_3.revision_notes_v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAndArrayLists {
	public static void main(String[] args) {
		String[] arr = {"hello", "world", "!"};
		List<String> list  = Arrays.asList(arr);
		
		List<String> list2 = new ArrayList<>();
		list2.add("hello");
		list2.add("world");
		String[] arr2 = (String[]) list2.toArray(new String[0]);
		System.out.println(Arrays.toString(arr2)); // [hello, world]
		list2.remove(1);
	}
}
