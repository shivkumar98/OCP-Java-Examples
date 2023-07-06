package review_questions.chapter_4.javaCode;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q11 {
	public static void main(String[] args) {
		// what changes are needed to made this code print 12345
		String str = Stream.iterate(1, x->++x).limit(5).map(x->""+x).collect(Collectors.joining());
		System.out.println(str);
		// the code does not compile
	}

}
