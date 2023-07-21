package chapter_3.revision_notes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingAndSearching {
	public static void main(String[] args) {
		List<UncomparableRabbit> list1 = 
				Arrays.asList(
						new UncomparableRabbit("shiv"),
						new UncomparableRabbit("andrew")
				);
		// Collections.sort(list1); // COMPILER ERROR
		Collections.sort(list1, (r1,r2)-> r1.name.compareTo(r2.name));
		System.out.println(list1); // [andrew, shiv]
		List<ComparableRabbit> lis2 = Arrays.asList(new ComparableRabbit());
		Collections.sort(lis2); // WORKS FINE
		
	}
}

class UncomparableRabbit {
	String name;
	public UncomparableRabbit(String name) {
		this.name = name;
	}
	public String toString() {
		return name;
	}
}

class ComparableRabbit implements Comparable<ComparableRabbit> {
	String name;
	public int compareTo(ComparableRabbit o) {
		return name.compareTo(o.name);
	}
	
}