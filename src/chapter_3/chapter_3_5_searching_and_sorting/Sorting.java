package chapter_3.chapter_3_5_searching_and_sorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Sorting {
	public static void main(String[] args) {
		List<Rabbit> rabbits = new ArrayList<>();
		rabbits.add(new Rabbit(1));
		// Collections.sort(rabbits); // does not compile!
		Set<Rabbit> rabbit = new TreeSet<>(new Comparator<Rabbit>() {
			 public int compare(Rabbit r1, Rabbit r2) {
			 return r1.id = r2.id;
			 }
			});
			rabbit.add(new Rabbit(1)); // fine and runs without exception
			rabbit.add(new Rabbit(2));
		
	}
}

class Rabbit {
	int id;
	public Rabbit(int id) {this.id = id; }
}