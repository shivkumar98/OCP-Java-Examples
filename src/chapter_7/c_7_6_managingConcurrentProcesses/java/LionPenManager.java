package chapter_7.c_7_6_managingConcurrentProcesses.java;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionPenManager {

	void removeLion() {
		System.out.println(Thread.currentThread().getId()+" Removing Lion");
	}
	void cleanCage() {
		System.out.println(Thread.currentThread().getId()+" Cleaning cage");
	}
	void addLion() {
		System.out.println(Thread.currentThread().getId()+" Adds Lion");
	}
	public void performTasks(CyclicBarrier c1, CyclicBarrier c2) {
		try {
			removeLion();
			c1.await();
			cleanCage();
			c2.await();
			addLion();
		} catch (Exception e) {
			// handle exception
		}
		
	}
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(4);
		LionPenManager manager = new LionPenManager();
		CyclicBarrier c1 = new CyclicBarrier(4);
		CyclicBarrier c2 = new CyclicBarrier(4);
		try {
			for(int i=0;i<4;i++)
				service.submit(() -> manager.performTasks(c1,c2));
			
		} finally {
			if(service!=null) service.shutdown();
		}
	}
}
