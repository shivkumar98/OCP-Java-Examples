package chapter_3.revision_notes_v2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ListImplementations {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.push(1); // CONSTANT TIME
		linkedList.push(2); // [2, 1]
		System.out.println(linkedList);
		linkedList.get(1); // LINEAR TIME
		linkedList.pop(); // LINEAR TIME
		System.out.println(linkedList); // [1]
		
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1); // LINEAR TIME
		arrayList.get(0); // CONSTANT TIME
		
		Stack<Integer> stack = new Stack<>();
		stack.push(1); // [1] // LINEAR TIME
		stack.push(2); // [1, 2]
		System.out.println(stack);
		stack.pop(); // [1] // LINEAR TIME
		System.out.println(stack); // [1]
		
	}
}
