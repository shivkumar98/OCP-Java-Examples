package chapter_3.revision_notes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UsingComparable {
	
	public static void main(String[] args) {
		Duck duckA = new Duck("a");
		Duck duckZ = new Duck("z");
		Duck duckM = new Duck("m");
		List<Duck> list = Arrays.asList(duckZ, duckA, duckM);
		System.out.println(list); //[Duck=z, Duck=a, Duck=m]
		Collections.sort(list);
		System.out.println(list); // [Duck=a, Duck=m, Duck=z]

	}
	

}

class Duck implements Comparable<Duck> {
	String name;
	public Duck(String name) { this.name = name; }
	@Override
	public int compareTo(Duck d) {
		return name.compareTo(d.name);
	}
	@Override
	public String toString() {
		return "Duck=" + name;
	}
	
	
}
