package review_questions.chapter_7.attempt_1.javaCode;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Q03 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(() -> {
			System.out.println("Open Zoo");
			// return null; // COMPILER ERROR
		}, 0, 1, TimeUnit.SECONDS);
		Future<?> result = service.submit(() -> System.out.println("Wake staff"));
		System.out.println(result.get());
	}
}
