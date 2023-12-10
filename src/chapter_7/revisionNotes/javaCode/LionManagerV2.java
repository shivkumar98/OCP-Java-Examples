package chapter_7.revisionNotes.javaCode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionManagerV2 {
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
		        System.out.println("c2 barrier limit surpassed");
				addLion();
	        } catch (InterruptedException | BrokenBarrierException e) {
				// handle exception
			}
		}
		
		public static void main(String[] args) {
			ExecutorService service = null;
			try {
			    service = Executors.newFixedThreadPool(4);
			    LionManagerV2 manager = new LionManagerV2();
			    CyclicBarrier c1 = new CyclicBarrier(4);
			    CyclicBarrier c2 = new CyclicBarrier(4,
			        ()->System.out.println("*** Pen cleaned!!"));
			    for(int i=0;i<4;i++){
			        service.submit(()->manager.performTasks(c1,c2));
			    }
			} finally {
			    if(service!=null) service.shutdown();
			}
		}
}
