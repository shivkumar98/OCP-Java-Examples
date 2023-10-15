package chapter_7.c_7_4_usingConcurrentCollections.javaCode;

import java.util.Deque;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentClasses {
	public static void main(String[] args) {
		Map<String, Integer> map = new ConcurrentHashMap<>();
		map.put("zebra", 52);
		map.put("elephant", 10);
		System.out.println(map.get("elephant")); // 10
		

		Queue<Integer> queue = new ConcurrentLinkedQueue<>();
		queue.offer(31);
		System.out.println(queue.peek()); // 31
		System.out.println(queue.poll()); // 31
		
		Deque<Integer> deque = new ConcurrentLinkedDeque<>();
		deque.offer(10);
		deque.push(4);
		System.out.println(deque.peek());
		System.out.println(deque.pop());
	}
}
