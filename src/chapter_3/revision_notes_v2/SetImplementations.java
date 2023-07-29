package chapter_3.revision_notes_v2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class SetImplementations {
	public static void main(String[] args) {
		
		Person p1 = new Person("shiv", 128);
		Person p2 = new Person("sam", 80);
		TreeSet<Person> treeSet = new TreeSet<>();
		treeSet.add(p1); treeSet.add(p2);
		System.out.println(treeSet);
		System.out.println("gello");
		
		HashSet<Person> hashSet = new HashSet<>();
		hashSet.add(p1);
		hashSet.add(p2);
		System.out.println(hashSet); // [[fullName=shiv, weight=128.0], [fullName=sam, weight=80.0]]

		
	}
}

class Person implements Comparable<Person> {
	String fullName;
	double weight;
	public Person(String fullName, double weight) {
		this.fullName = fullName;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "[fullName=" + fullName + ", weight=" + weight + "]";
	}

	public int compareTo(Person p) {
		return Double.compare(weight, p.weight);
	}
	
}
