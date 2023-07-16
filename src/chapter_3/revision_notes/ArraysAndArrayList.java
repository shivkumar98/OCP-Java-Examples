package chapter_3.revision_notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAndArrayList {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("hello", "world");
		String[] arr =  list.toArray(new String[0]);
		System.out.println(Arrays.toString(arr)); // [hello, world]
		
		// list is now backed
		list.remove(0); // throws UnsupportedOperationException
		
		
	}
}
