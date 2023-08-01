package chapter_3.revision_notes_v2;

import java.util.Map;
import java.util.TreeMap;

public class MapImplemetations {

	public static void main(String[] args) {
		Weight w1 = new Weight(46);
		Weight w2 = new Weight(69);
		Weight w3 = new Weight(23);
		Map<Weight, Integer> treeMap = new TreeMap<>();
		treeMap.put(w1, w1.weight);
		treeMap.put(w2, w2.weight);
		treeMap.put(w3, w3.weight);
		System.out.println(treeMap);
		// {[weight=23]=23, [weight=46]=46, [weight=69]=69}
	}
}

class Weight implements Comparable<Weight> {
	int weight;
	public int compareTo(Weight o) {
		return Integer.compare(weight, o.weight);
	}
	public Weight(int weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "[weight=" + weight + "]";
	}
	
}