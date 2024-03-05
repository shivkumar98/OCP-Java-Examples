package chapter_3.chapter_3_5_searching_and_sorting.java;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Searching {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Fluffy", "Hoppy");
		Comparator<String> c = Comparator.reverseOrder();
		int index = Collections.binarySearch(names, "Hoppy", c);
		System.out.println(index); // -1
	}

}
