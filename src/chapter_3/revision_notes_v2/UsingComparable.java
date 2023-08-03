package chapter_3.revision_notes_v2;

import java.util.Arrays;
import java.util.TreeSet;

public class UsingComparable {
	public static void main(String[] args) {
		Size medium = new Size(5);
		Size small = new Size(4);
		Size large = new Size(10);
		TreeSet<Size> treeSet = new TreeSet<>();
		treeSet.addAll(Arrays.asList(medium, small, large));
		System.out.println(treeSet); // [[size=4], [size=5], [size=10]]

	}
}

class Size implements Comparable<Size> {
	int size;
	
	public Size(int size) { this.size = size; }
	public int compareTo(Size o) {
		return Integer.compare(size, o.size);
	}
	@Override
	public String toString() {
		return "[size=" + size + "]";
	}
	
	
}
