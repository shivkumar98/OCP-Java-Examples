package chapter_3.chapter_3_6_additions_in_java_8.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;




class Duck {
	String name;
	int weight;
	public Duck(String name, int weight) {
		this.name=name;this.weight=weight;
	}
	public String getName() {
		return name;
	}
	public int getWeight() {
		return weight;
	}
	@Override
	public String toString() {
		return "Duck [name=" + name + ", weight=" + weight + "]";
	}
	
	
}

class DuckHelper {
	static int compareByWeight(Duck d1, Duck d2) {
		return d1.getWeight()-d2.getWeight();
	}
	static int compareByName(Duck d1, Duck d2) {
		return d1.getName().compareTo(d2.getName());
	}
	

}

public class MethodReferences {
	public static void main(String[] args) {
		Duck sammy = new Duck("Zoe", 4);
		Duck shiv = new Duck("J", 12);
		List<Duck> ducks = new ArrayList<>();
		ducks.add(shiv); ducks.add(sammy);
		// we want to sort by weight using comparator
		// we COULD write:
		Comparator<Duck> byWeight = (d1,d2)-> DuckHelper.compareByWeight(d1, d2);
		ducks.sort(byWeight);
		System.out.println(ducks); // [Duck [name=Zoe, weight=4], Duck [name=J, weight=12]]

		
		// its better to write using method reference
		Comparator<Duck> byName = DuckHelper::compareByName;
		ducks.sort(byName);
		System.out.println(ducks); // [Duck [name=J, weight=12], Duck [name=Zoe, weight=4]]

	}
}