package chapter_3.c_3_4_comparator_vs_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorClass {
	public static void main(String[] args) {
		List<Duck> ducks = new ArrayList<>();
		Duck d1 = new Duck("Puddle",   10);
		Duck d2 = new Duck("Quack", 7);
		ducks.add(d1); ducks.add(d2);
		System.out.println(ducks); // [Puddle, 10, Quack, 7]
		
		// defining a comparator
		Comparator<Duck> byWeight = new Comparator<Duck>() {
			@Override
			public int compare(Duck o1, Duck o2) {
				return o1.weight - o2.weight;
			}
		};
		Collections.sort(ducks, byWeight);
		System.out.println(ducks);
	}
}

class Duck implements Comparable<Duck> {
	String name;
	int weight;
	public Duck(String name, int weight) {
		this.name=name; this.weight=weight;
	}
	public String toString() {
		return name+ ", "+ weight;
	}
	@Override
	public int compareTo(Duck o) {
		return name.compareTo(o.name);
	}
	
}