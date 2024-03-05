package review_questions.chapter_3.attempt_3.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q19 {
	public static void main(String[] args) {
		List<Integer> q1 = new LinkedList<>();
		q1.add(10); // [10]
		q1.add(12); // [10, 12]
		q1.remove(1); // [10]
		System.out.println(q1);
		
		Queue<Integer> q2 = new LinkedList<>();
		q2.add(10);
		q2.add(12); // [10,12]
		q2.remove(1); // [10,12] - remove only removes object on queue!
		System.out.println(q2);
		
	}
}
