package chapter_7.revisionNotes.javaCode;

import java.util.Arrays;
import java.util.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UnderstandingCopyOnWriteArrayList {
	public static void main(String[] args) {
		List<Integer> list 
		= new CopyOnWriteArrayList<>(Arrays.asList(4,3,52));
		for(Integer i:list) {
			System.out.print(i+" ");
			list.add(9);
		}
		
		System.out.println(list);
		
		List<Integer> list2 = new ArrayList<>(Arrays.asList(5,8,9));
		for (Integer i: list2) {
			System.out.print(i+" ");
			//list2.add(3); // not allowed due to concurrent modification being thrown
		}
		System.out.println("\n"+list2);
		
	}
	
}
