package review_questions.chapter_7.attempt_5.java;

import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Q14 {
	
	static void addPrintItems(BlockingDeque<Integer> deque) throws InterruptedException {
		deque.offer(103);
		deque.offerFirst(20, 1, TimeUnit.SECONDS);
		deque.offerLast(85, 7, TimeUnit.SECONDS);
		System.out.println(deque);
		System.out.println(deque.pollFirst());
		System.out.println(deque.pollLast());
	}
	
	public static void main(String[] args) throws InterruptedException {
		BlockingDeque<Integer> b = new LinkedBlockingDeque<>();
		addPrintItems(b);
		
		System.out.println("--------");
		
		BlockingDeque<Integer> q = new LinkedBlockingDeque<Integer>();
		q.offer(2);
		q.offer(3);
		System.out.println(q);
		q.offerFirst(4); // adds element to start of Deque
		System.out.println(q);
		q.offerLast(6);
		System.out.println(q);
	}
}
