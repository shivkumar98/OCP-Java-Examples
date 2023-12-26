package revision_notes.javaCode.chapter7;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class SubmittedTasks {
	static int counter = 0;
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Callable<Integer> c = () -> ++counter;
		Runnable r = () -> ++counter;
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<Integer> f1 = service.submit(c);
			// Future<Integer> f2 = service.execute(r);
			Future<?> f2 = service.submit(r);
			service.execute(r);
			System.out.println(f1.get()); // 1
			System.out.println(f2.get()); // null
			System.out.println(counter); // 3
			List<Callable<Integer>> list = Arrays.asList(c,c,c);
			List<Future<Integer>> returnedList = service.invokeAll(list);
			Integer f = service.invokeAny(list);
			System.out.println(f); // 7
			List<Integer> l = getTheValuesOfFutureList( returnedList);
			System.out.println(l); // [4,5,6]
		} finally {
			if (service!=null)
				service.shutdown();
		}
	}
	private static List<Integer> getTheValuesOfFutureList(List<Future<Integer>> returnedList) {
		return returnedList.stream().map(i->{
				try {
					return i.get();
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}).collect(Collectors.toList());
	}
}
