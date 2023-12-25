package revision_notes.javaCode.chapter7;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	static int counter = 0;
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Runnable r = () -> counter++;
		Callable<Integer> c = () -> counter++;
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<?> i = service.execute(r);
			// service.execute(c); // COMPILER ERROR
			Future<?> f1 = service.submit(r);
			Future<?> f2 = service.submit(c);
			System.out.println(f1.get());
			System.out.println(f2.get());
			
		} finally {
			System.out.println(counter);
			service.shutdown();
		}
	}
}
