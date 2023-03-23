package chapter_3.chapter_3_2_working_with_generics;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcards {
	public static void printList(List<?> list) {
		for (Object x: list) System.out.println(x);
	}
	public static void main(String[] args) {
		List<String> keywords = new ArrayList<>();
		keywords.add("Java");
		printList(keywords);
	}
}
