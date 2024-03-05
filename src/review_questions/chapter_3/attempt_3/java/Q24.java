package review_questions.chapter_3.attempt_3.java;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Q24 {
	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		s.add("lion");
		s.add("tiger");
		s.add("bear");
        s.forEach(x->System.out.println(x));
	}
}
