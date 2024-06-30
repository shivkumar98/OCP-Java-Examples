package review_questions.chapter_7.attempt_5.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q22 {
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(() -> {System.out.println("hello");});
		service.submit(() -> 1);
	}
}
