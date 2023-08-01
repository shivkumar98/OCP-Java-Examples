package chapter_3.revision_notes_v2;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueImplementations {
	public static void main(String[] args) {
		ArrayDeque<Integer> queue = new ArrayDeque();
		queue.offer(1); // offer() adds element to back of queue
		queue.offer(2);
		System.out.println(queue); // [1, 2]
		queue.push(68);
		System.out.println(queue); // [68,1,2]
		System.out.println(queue.element()); // 68
		System.out.println(queue); // [68,1,2] 
		// element() retrieves head
		System.out.println(queue.remove()); // 68
		System.out.println(queue); // [1, 2]
		// remove() retrieves head and removes it
		// poll() also retrieves head and removes it but does not throw exception
		
		System.out.println(queue.peekLast()); 
		Queue<Integer> emptyQueue = new ArrayDeque<>();
		Integer pollResult = emptyQueue.poll();
		System.out.println(pollResult); // null
		System.out.println(queue); // [1,2]
		queue.offer(3);
		System.out.println(queue); // [1,2,3]
		queue.pop();
		System.out.println(queue); // [2,3]
	}
}
