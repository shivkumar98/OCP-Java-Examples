package chapter_7.revisionNotes.javaCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.*;

public class SynchronizedCollectionMethods {
	public static void main(String[] args) {
		List<Integer> list = Collections.synchronizedList(
			new ArrayList<>(Arrays.asList(4,3,52)));
		for(int data:list) {
			System.out.print(data+" ");
			 // list.add(9); // throws ConcurrentModificationException
		}
		System.out.println(list); // [4, 3, 52]
		synchronized(list) {
			for(int data:list) {
				System.out.print(data+" ");
			}
		}
		System.out.println(list);
	}
}
