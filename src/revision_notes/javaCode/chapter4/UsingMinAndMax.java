package revision_notes.javaCode.chapter4;

import java.util.Optional;
import java.util.stream.Stream;

public class UsingMinAndMax {
	public static void main(String[] args) {
		Stream<String> letters = Stream.of("b","c","a","d");
		Optional<String> opt = letters.min((a,b)->a.compareTo(b));
		System.out.println(opt.get()); // a
		Stream<String> infiniteLetters
			=Stream.generate(()->"a");
		infiniteLetters.max((a,b)->a.compareTo(b)); // hangs forever
	}
}
