package chapter_3.revision_notes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class UsingComparator {
	public static void main(String[] args) {
		Comparator<DuckV2> byWeight = new Comparator<DuckV2>() {
			public int compare(DuckV2 o1, DuckV2 o2) {
				return o1.weight - o2.weight;
			}
		};
		Comparator<DuckV2> byName = (d1,d2) -> d1.name.compareTo(d2.name);
		DuckV2 A = new DuckV2("A", 112);
		DuckV2 B = new DuckV2("B", 65);
		List<DuckV2> list = Arrays.asList(A, B);
		list.sort(byName);
		System.out.println(list); // [Duck: A-112, Duck: B-65]
		list.sort(byWeight);
		System.out.println(list); // [Duck: B-65, Duck: A-112]
	}
}

class DuckV2 {
	String name;
	int weight;
	public DuckV2(String name, int weight) {
		this.name=name; this.weight=weight;
	}
	public String toString() {
		return "Duck: "+name+ "-"+weight;
	}
}