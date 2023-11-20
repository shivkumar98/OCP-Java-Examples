package review_questions.chapter_7.attempt_1.javaCode;

import java.util.stream.Stream;

public class Q13 {
	public static void main(String[] args) {
		Stream<String> cats =
				Stream.of("leopard","lynx","ocelot","puma")
				.parallel();
		Stream<String> bears = Stream.of("panda","grizzly","polar")
				.parallel();
	}
}
