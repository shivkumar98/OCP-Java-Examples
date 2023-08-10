package chapter_2.revision_notes;

import java.util.function.Consumer;

public class LambdaExpressions {
	public static void main(String[] args) {
		// Consumer<String> lambda = x->; // COMPILER ERROR
		Consumer<String> lambda2 = x -> {};
		Consumer<String> lambda3 = x -> {return;};
	}
}
