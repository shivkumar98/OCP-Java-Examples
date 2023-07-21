package chapter_3.revision_notes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
	public static void main(String[] args) {
		List<String> unsorted = Arrays.asList("x","a","p","m");
		System.out.println(Collections.binarySearch(unsorted, "x")); // -5
	}
}
