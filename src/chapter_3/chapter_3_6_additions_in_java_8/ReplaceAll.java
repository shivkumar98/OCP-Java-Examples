package chapter_3.chapter_3_6_additions_in_java_8;

import java.util.Arrays;
import java.util.List;

public class ReplaceAll {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3);
		list.replaceAll(x->x*2);
		System.out.println(list); // [2, 4, 6]
	}
	
}
