package chapter_3.revision_notes_v2;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetImplementation {

	// TreeSet is an implementation of NavigableSet
	public static void main(String[] args) {
		NavigableSet<Integer> set = new TreeSet<>();
		for (int i=1;i<21;i++) set.add(i);
		int lower = set.lower(3); // 2
		int higher = set.higher(2); // 3
		int floor = set.floor(4); // 4
		int ceiling = set.ceiling(6); // 6
		System.out.println(set.floor(0)); // null
		System.out.println(lower);
		System.out.println(higher);
		System.out.println(floor);
		System.out.println(ceiling);
	}
}
