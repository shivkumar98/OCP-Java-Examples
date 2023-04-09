package chapter_3.chapter_3_3_using_lists_sets_maps_queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueMethods {
	public static void main(String[] args) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(1); // [1]
		System.out.println(queue); 
		queue.add(2); // [1, 2]
		System.out.println(queue);
		queue.poll(); // [2]
		System.out.println(queue);
		queue.add(3); // [ 2, 3]
		System.out.println(queue.peek()); // 2
		System.out.println(queue); // [2, 3]
		queue.push(2);
		
		Queue<Integer> arrQueue = new ArrayDeque<>();
		System.out.println(arrQueue.offer(10)); // true
		System.out.println(arrQueue); // [10]
		System.out.println(arrQueue.offer(4)); // true
		System.out.println(arrQueue); // [10, 4]
		System.out.println(arrQueue.peek()); // 10
		System.out.println(arrQueue.poll()); // 10
		System.out.println(arrQueue); // [4]
		System.out.println(arrQueue.poll()); // 4
		System.out.println(arrQueue); // []
		System.out.println(arrQueue.poll()); // null
		
		System.out.println("*************");
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(10);
		stack.push(4);
		System.out.println(stack.peek()); // 4
		System.out.println(stack.poll()); // 4
		System.out.println(stack); // [10]
		System.out.println(stack.poll()); // 10
		System.out.println(stack.peek()); // null
		
	}
}
