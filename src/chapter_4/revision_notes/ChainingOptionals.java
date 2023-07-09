package chapter_4.revision_notes;

import java.util.Optional;

public class ChainingOptionals {
	
	static Optional<Integer> calculator(String s) {
		return Optional.of(s.length());
	}
	
	public static void main(String[] args) {
		Optional<String> optional = Optional.of("Hello");
		// Optional<Integer> x = optional.map(ChainingOptionals::calculator); // COMPILER ERROR
		Optional<Integer> x = optional.flatMap(ChainingOptionals::calculator);
		System.out.println(x.get()); // 5
	}
}
