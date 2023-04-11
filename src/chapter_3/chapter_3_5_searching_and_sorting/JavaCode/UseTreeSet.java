package chapter_3.chapter_3_5_searching_and_sorting.JavaCode;

import java.util.*;

public class UseTreeSet {
	static class Rabbit { 
		int id;
		public Rabbit(int id) { this.id = id; }
		public String toString() {
			return "id: "+id;
		}
	}
	public static void main(String[] args) {
		Set<Rabbit> rabbit = new TreeSet<>();
		 // rabbit.add(new Rabbit()); // THROWS RUN TIME EXCEPTION
		Set<Rabbit> rabbitSorted = new TreeSet<>(new Comparator<Rabbit>() {
			@Override
			public int compare(Rabbit o1, Rabbit o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.id, o2.id);
			}			
		});
		rabbitSorted.add(new Rabbit(2));
		rabbitSorted.add(new Rabbit(3));
		rabbitSorted.add(new Rabbit(1));
		
		System.out.println(rabbitSorted); // [id: 1, id: 2, id: 3]
	}
}
