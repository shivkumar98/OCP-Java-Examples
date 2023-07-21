package chapter_3.revision_notes;

import java.util.Arrays;
import java.util.List;
import java.util.*;

public class RemovingConditionally {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList("1","22","333","4444"));
		list.removeIf(s->s.length()>2);
		System.out.println(list); // [1, 22]
		
	}
}
