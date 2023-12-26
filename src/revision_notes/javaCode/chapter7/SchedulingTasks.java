package revision_notes.javaCode.chapter7;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulingTasks {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService serviceUsingWrongReference = Executors.newSingleThreadScheduledExecutor();
		//serviceUsingWrongReference.schedule(); // COMPILER ERROR
		ScheduledExecutorService scheduledService
			= Executors.newSingleThreadScheduledExecutor();
		Callable<Integer> c = () -> 1;
		Runnable r = () -> System.out.println("hello");
		Future<Integer> f = scheduledService.schedule(c, 1, TimeUnit.SECONDS);
		Future<?> f2 = scheduledService.schedule(r, 1, TimeUnit.SECONDS);
		// prints hello
		System.out.println(f.get()); // 1
		System.out.println(f2.get()); // null
		
		Future<?> f3 = scheduledService.scheduleAtFixedRate(r, 1, 1, TimeUnit.SECONDS);
		
		
	}
}
