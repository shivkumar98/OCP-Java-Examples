package chapter_7_v2.c_7_2_creatingThreadsWithTheExecutorService.javaCode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class invokeAnyExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(2);
			List<Callable<String>> list = 
					List.of(new CallableClass(1),
							new CallableClass(2),
							new CallableClass(3),
							new CallableClass(4)
							);
			List<Future<String>> future = service.invokeAll(list);
			for (Future<String> fut: future)
				System.out.println(fut.get());
		} finally {
			service.shutdown();
		}
	}
}

class CallableClass implements Callable<String> {
	private int i;
	public CallableClass(int i) {
		this.i = i;
	}
	
	public String call() throws Exception {
		return ""+i;
	}
	
}