package chapter_8.revisionNotes.javaCode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UsingCyclicBarrier {
	void task(int i) {
		System.out.println("Doint task "+i);
	}
	
	public static void performTasks(CyclicBarrier c1) {
        try {
    		System.out.println("Task 1");
    		c1.await();
    		System.out.println("Task 2");
	      } catch (InterruptedException | BrokenBarrierException e) {
			// handle exception
		}
	}
	
	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(4);
			UsingCyclicBarrier c = new UsingCyclicBarrier();
			CyclicBarrier c1 = new CyclicBarrier(2);
			for(int i=0;i<4;i++)
				service.submit(()->performTasks(c1));
		} finally {
			if(service!=null) service.shutdown();
		}
	}
}
