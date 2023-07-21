package chapter_3.revision_notes;

import java.util.Arrays;
import java.util.List;

public class UsingReplaceAll {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3);
		list.replaceAll(i->i+23);
		System.out.println(list); // [24, 25, 26]
	}
}
