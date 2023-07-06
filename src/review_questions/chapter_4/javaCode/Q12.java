package review_questions.chapter_4.javaCode;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Q12 {
	public static void main(String[] args) {
		
		// BiConsumer<String, String> s = (x,y) -> x+y;
		BiConsumer<String, String> y = (a,b) -> System.out.println();
		Consumer<String> x = String::new;
		x.accept("hello" );
		
		UnaryOperator<String, String> z = null;
	}
}
