package revision_notes.javaCode.chapter4;

import java.util.stream.Stream;

public class UsingFindAnyFirst {
	public static void main(String[] args) {
		Stream<String> infiniteLetters = Stream.generate(()->"hello");
		System.out.println(infiniteLetters.findAny().get()); // hello
		
	}
}
