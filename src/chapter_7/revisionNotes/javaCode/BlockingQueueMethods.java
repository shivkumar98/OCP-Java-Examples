package chapter_7.revisionNotes.javaCode;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueMethods {
	public static void main(String[] args) {
		
		try {
			BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
			blockingQueue.offer(1);
			System.out.println(blockingQueue); // [1]
			blockingQueue.offer(2, 3, TimeUnit.SECONDS);
			System.out.println(blockingQueue); // [1,2]
			int poll = blockingQueue.poll(10, TimeUnit.MICROSECONDS);
			System.out.println(poll); // 1
		} catch (InterruptedException e) {
			// handle exception
		}
	
		
	}
}
