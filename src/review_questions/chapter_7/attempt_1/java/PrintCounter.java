package review_questions.chapter_7.attempt_1.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class PrintCounter {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newSingleThreadExecutor();
		Runnable r= () -> counter++;
		List<Future<?>> results = new ArrayList<>();
		IntStream.iterate(0, i->i+1).limit(5)
//			.forEach(i -> results.add(service.execute(r))); // n1 
					// DOES NOT COMPILE
			.forEach(i -> results.add(service.submit(r)));
		for(Future<?> result: results) {
			System.out.println(result.get()+" ");
		}
		service.shutdown();
		
	}


	static int counter = 0;
	
}
