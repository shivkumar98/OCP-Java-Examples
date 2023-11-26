package chapter_7.revisionNotes.javaCode;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulingTasks {
	public static void main(String[] args) {
		ScheduledExecutorService service
			= Executors.newSingleThreadScheduledExecutor();
		Future<?> f = service.schedule(()->{
			System.out.println("hello world");
		}, 10, TimeUnit.SECONDS);
	}
}
