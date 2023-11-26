package chapter_7.revisionNotes.javaCode;

import java.util.concurrent.TimeUnit;

public class CheckResults {
	private static long counter = 0L;
	static long limit = 1_000_000_000L;
	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			for(long i=0;i<limit;i++) CheckResults.counter++;
		}).start();;
		while(counter<limit) {
			System.out.println(counter+" not reached yet");
			Thread.sleep(1);
		}
		System.out.println(counter+" reached!");
	}
}
