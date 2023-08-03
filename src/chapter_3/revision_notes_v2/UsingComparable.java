package chapter_3.revision_notes_v2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class UsingComparable {
	public static void main(String[] args) {
		Size medium = new Size(5);
		Size small = new Size(4);
		Size large = new Size(10);
		TreeSet<Size> treeSet = new TreeSet<>();
		treeSet.addAll(Arrays.asList(medium, small, large));
		System.out.println(treeSet); // [[size=4], [size=5], [size=10]]
		
		Comparator<Size> naturalOrder = (s1, s2) -> s1.size - s2.size;
		Comparator<Size> largestToSmallest = (s1, s2) -> s2.size - s1.size;
		List<Size> sizesList = Arrays.asList(small, medium, large);
		Collections.sort(sizesList, largestToSmallest);
		System.out.println(sizesList); //; [[size=10], [size=5], [size=4]]
		int unsortedIndex = Collections.binarySearch(sizesList, small, largestToSmallest);
		System.out.println(unsortedIndex); // 1
		int sortedIndex = Collections.binarySearch(sizesList, medium, naturalOrder);
		System.out.println(sortedIndex);
		
		
	}
}

class Size implements Comparable<Size> {
	int size;
	
	public Size(int size) { this.size = size; }
	public int compareTo(Size o) {
		return Integer.compare(size, o.size);
	}
	
	@Override
	public boolean equals(Object obj) {

		Size other = (Size) obj;
		return size == other.size;
	}
	@Override
	public String toString() {
		return "[size=" + size + "]";
	}
	
	
}
