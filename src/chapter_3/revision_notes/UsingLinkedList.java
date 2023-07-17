package chapter_3.revision_notes;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.LinkedList;

public class UsingLinkedList {
	public static void main(String[] args) {
		List<String> linkedList = new LinkedList<>();
		linkedList.add("1"); // [1]
		linkedList.add("2"); // [1, 2]
		linkedList.add(1, "3"); // [1, 3, 2]
		// we can remove elements from beggining or end in consdtant time
		System.out.println(linkedList);  // [1, 3, 2]
		List<String> arrayList = new ArrayList<>();
		arrayList.add("1");
		arrayList.add("2");
		Stack<String> stack = new Stack<>();
		stack.add("hello");
		stack.add("world");
		System.out.println(stack.pop());
		System.out.println(stack);
		
		
	}
}
