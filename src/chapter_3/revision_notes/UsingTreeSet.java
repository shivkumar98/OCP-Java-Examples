package chapter_3.revision_notes;

import java.util.*;

class UsingTreeSet {
	public static void main(String[] args) {
		// Rabbit is comparable!
		Set<Rabbit> rabbits = new TreeSet<>();
		rabbits.add(new Rabbit("Shiv",122));
		
		// Bear is not comparable!
		Set<Bear> bears = new TreeSet<>();
		// bears.add(new Bear("Bear", 12)); // THROWS EXCEPTION
		// we can overload the constructor for tree set:
		Comparator<Bear> c = (b1,b2) -> b1.weight - b2.weight;
		Set<Bear> sortedBears = new TreeSet<>(c);
		sortedBears.add(new Bear("heavy",122));
		sortedBears.add(new Bear("light", 1));
		System.out.println(sortedBears);
		
		
	}
	

}
class Rabbit implements Comparable<Rabbit> {
	
	String name;
	int weight;
	public Rabbit(String name, int weight) {
		this.name=name; this.weight=weight;
	}
	@Override
	public int compareTo(Rabbit o) {
		return name.compareTo(o.name);
	}
	
}

class Bear {
	String name;
	int weight;
	public Bear(String name, int weight) {
		this.name=name; this.weight=weight;
	}
	@Override
	public String toString() {
		return "[" + name + ", "+ weight + "]";
	}
	
}