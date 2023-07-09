package chapter_4.revision_notes;

import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectTerminalOperation {
	public static void main(String[] args) {
		Stream<String> str = Stream.of("w","o","l","f");
		//StringBuilder word = str.collect(()->new StringBuilder(), (x,y)->x.append(y), (a,b)->a.append(b));
		//System.out.println(word); // wolf
		
		//TreeSet<String> set = str.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
		//System.out.println(set); // [f, l, o, w]
		TreeSet<String> set = str.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(set); // [f, l, o, w]
	}
}
