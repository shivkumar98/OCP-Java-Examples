package chapter_3.chapter_3_6_additions_in_java_8;

import java.util.ArrayList;
import java.util.List;

public class RemoveIf {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Magician");
		list.add("Assistant");
		// list.removeIf(String::startsWith("M")); // this does not compile
		list.removeIf(s->s.startsWith("M"));
		System.out.println(list); // [Assistant]
	}
}
