package chapter_3.chapter_3_1_reviewing_oca_collections;

import java.util.ArrayList;
import java.util.List;

public class generics {
	static void printNames(List list) {
		for (int i =0; i < list.size(); i++) {
			String name = (String) list.get(i);
			System.out.println(name);
		}
	}
	public static void main(String[] args) {
		List names = new ArrayList();
		names.add(new StringBuilder("Webby"));
		printNames(names);
	}
}

class generics2 {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add(new StringBuilder("Webby")); // does not compile
	}
}