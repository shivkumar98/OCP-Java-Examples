package chapter_3.revision_notes;

import java.util.*;
import java.util.ArrayDeque;
public class Queues {
	
	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<>();
		//System.out.println(deque.element()); // THROWS EXCEPTION
		System.out.println(deque.peek()); // null
		deque.add(1); deque.add(2); deque.add(3);
		System.out.println(deque.peek()); // 1
		System.out.println(deque.element()); // 1
		System.out.println(deque); // [1, 2, 3]
		System.out.println(deque.offer(4)); // true
		System.out.println(deque); // [1,2,3,4]
		System.out.println(deque.pop()); // 1
		System.out.println(deque); // [2, 3, 4]
		System.out.println(deque.poll()); // 2
		System.out.println(deque); // [3,4]
		deque.push(999);
		System.out.println(deque); // [999,3,4]
	}

}
