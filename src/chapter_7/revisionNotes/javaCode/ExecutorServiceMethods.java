package chapter_7.revisionNotes.javaCode;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceMethods {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newSingleThreadExecutor();
		Runnable r = () -> System.out.println("runnable");
		Callable<Integer> c = () -> 1;
		service.execute(r); // runnable
		// service.execute(c); // COMPILER ERROR
		Future<?> f1 = service.submit(r); // runnable
		System.out.println(f1.get()); // null
		Future<?> f2 = service.submit(c);
		System.out.println(f2.get()); // 1
		List<Callable<Integer>> list = Arrays.asList(c, c);
		List<Future<Integer>> f3 = service.invokeAll(list);
		System.out.println(f3.get(0).get()); // 1
		System.out.println(f3.get(1).get()); // 1
	}
}
