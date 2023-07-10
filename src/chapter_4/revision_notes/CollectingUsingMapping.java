package chapter_4.revision_notes;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingUsingMapping {
		
	public static void main(String[] args) {
		long x = Stream.generate(() -> "")
		.limit(10)
		.peek(System.out::print)
		.count();
				

	}
	

}
