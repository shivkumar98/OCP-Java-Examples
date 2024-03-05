package chapter_7.c_7_2_creatingThreadsWithTheExecutorService.java;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CheckResults {
	private static int counter = 0;
	public static void main(String[] args) throws
	InterruptedException, ExecutionException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<?> future =
					service.submit(() -> {
						for(int i=0;i<500;i++) CheckResults.counter++;
					});
			future.get(1, TimeUnit.NANOSECONDS);
			System.out.println("reached");
		} catch (TimeoutException e) {
			System.out.println("not reached in time");
		} finally {
			if(service!=null) service.shutdown();
		}

	}

}
