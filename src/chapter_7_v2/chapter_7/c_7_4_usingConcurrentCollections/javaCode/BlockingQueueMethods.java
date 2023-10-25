package chapter_7.c_7_4_usingConcurrentCollections.javaCode;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueMethods {
	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
		blockingQueue.offer(39);
		try {
			blockingQueue.offer(3, 4, TimeUnit.SECONDS);
			System.out.println(blockingQueue.poll()); // 39
			System.out.println(blockingQueue.poll(10, TimeUnit.SECONDS)); // 3
		} catch (InterruptedException e) {
			
		}
	}
}
