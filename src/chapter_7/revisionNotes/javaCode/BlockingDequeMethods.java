package chapter_7.revisionNotes.javaCode;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class BlockingDequeMethods {
	public static void main(String[] args) {
		BlockingDeque<Integer> blockingDeque
			= new LinkedBlockingDeque<>();
		try {
			blockingDeque.offer(1);
			System.out.println(blockingDeque); // [1]
			blockingDeque.offerFirst(2, 2, TimeUnit.SECONDS);
			System.out.println(blockingDeque); // [2,1]
			blockingDeque.offerLast(3, 1, TimeUnit.SECONDS);
			System.out.println(blockingDeque); // [2,1,3]
			System.out.println(blockingDeque.poll()); // 2
			System.out.println(blockingDeque.pollFirst(1, TimeUnit.SECONDS));
			// 1
			System.out.println(blockingDeque.pollLast(1,TimeUnit.SECONDS));
			// 3
		} catch (InterruptedException e) {
			
		}
	}
}
