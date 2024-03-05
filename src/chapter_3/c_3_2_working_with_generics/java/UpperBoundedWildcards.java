package chapter_3.c_3_2_working_with_generics.java;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundedWildcards {
	public static long total(List<? extends Number> list) {
		long count = 0;
		for (Number number: list)
			count += number.longValue();
		return count;
	}
	
	public static void main(String[] args) {
		List<Float> list = new ArrayList<>();
		list.add(12.1f);
		list.add(12.3f);
		System.out.println(total(list));
	}
}
