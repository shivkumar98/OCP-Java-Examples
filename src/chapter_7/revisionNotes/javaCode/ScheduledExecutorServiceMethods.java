package chapter_7.revisionNotes.javaCode;

import java.util.concurrent.*;


public class ScheduledExecutorServiceMethods {
	
	public static void main(String[] args) {
		ExecutorService service =
			Executors.newSingleThreadScheduledExecutor();
//		service.schedule(); // COMPILER ERROR
		ScheduledExecutorService scheduledService
			= Executors.newSingleThreadScheduledExecutor();
//		scheduledService.scheduleAtFixedRate(
//			()->System.out.println("hello"),
//			0, 1, TimeUnit.SECONDS);
		scheduledService.scheduleWithFixedDelay(
			()->System.out.println("hello"),
			0, 1, TimeUnit.SECONDS);
	}

}
