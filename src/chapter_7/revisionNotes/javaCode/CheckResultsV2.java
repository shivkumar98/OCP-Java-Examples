package chapter_7.revisionNotes.javaCode;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CheckResultsV2 {
	private static long counter = 0;
    static long limit = 1_000_000_000_000L;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<?> result = service.submit(
				() -> {for(long i=0;i<limit;i++) counter++;}
			);
			result.get(100, TimeUnit.MILLISECONDS);
			System.out.println(counter +" limit reached");
		} catch (TimeoutException e) {
			System.out.println(counter+" not reached in time");
		} finally {
			if(service!=null) service.shutdown();
		}
	}

}
