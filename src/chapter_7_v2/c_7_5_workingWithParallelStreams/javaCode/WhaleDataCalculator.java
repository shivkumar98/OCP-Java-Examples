package chapter_7_v2.c_7_5_workingWithParallelStreams.javaCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WhaleDataCalculator {
	
	private int processData(int input) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// handle exception
		} 
		return input+1;
	}
	
	private void processAllData(List<Integer> data) throws InterruptedException {
		
		data.stream().map(s -> processData(s)).count();
		//data.parallelStream().map(s -> processData(s)).count();
	}
	
	public static void main(String[] args) throws InterruptedException {
		WhaleDataCalculator calculator =
				new WhaleDataCalculator();
		// create:
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<4000;i++) list.add(i);
		// process:
		long start = System.currentTimeMillis();
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.submit(() ->{
			try {
				calculator.processAllData(list);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		double time = (System.currentTimeMillis()-start)/1000.0;
		// calculate time:
		System.out.println("task took "+time+" seconds");
		
		
	}

}
