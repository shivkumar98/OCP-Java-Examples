package chapter_7.revisionNotes.javaCode;

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
	public void performTasks() {
		removeLion();
		cleanCage();
		addLion();
	}
	public static void main(String[] args) {
		ExecutorService service = null;
		try {
		    service = Executors.newFixedThreadPool(4);
		    LionPenManager manager = new LionPenManager();
		    for(int i=0;i<4;i++) {
		        service.submit(()->manager.performTasks());
		    }
		} finally {
		    if(service!=null) service.shutdown();
		}
	}
}
