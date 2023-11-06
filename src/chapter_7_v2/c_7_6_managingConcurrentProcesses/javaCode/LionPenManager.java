package chapter_7_v2.c_7_6_managingConcurrentProcesses.javaCode;

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
	public void performTasks(CyclicBarrier c1) {
		try {
			removeLion();
			c1.await();
			cleanCage();
			addLion();
		} catch (Exception e) {
			// handle exception
		}
		
	}
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(4);
		LionPenManager manager = new LionPenManager();
		CyclicBarrier c1 = new CyclicBarrier(2);
		try {
			for(int i=0;i<4;i++)
				service.submit(() -> manager.performTasks(c1));
			
		} finally {
			if(service!=null) service.shutdown();
		}
	}

}
