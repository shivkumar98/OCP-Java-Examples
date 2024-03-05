package chapter_7.c_7_4_usingConcurrentCollections.java;

import java.util.Arrays;
import java.util.*;

public class ObtainingSynchronizedCollections {
	public static void main(String[] args) {
		List<Integer> list 
			= new ArrayList<>(Arrays.asList(4,3,52));
		List<Integer> synchronizedList = Collections.synchronizedList(list);
		for (int i:synchronizedList) { // CONCURRENTMODIFICATIONEXCEPTION
		 
			System.out.print(i+" ");
		}
		for(int i:synchronizedList) {
			synchronized(synchronizedList) {
//				synchronizedList.add(i);
				System.out.print(i+ " ");
			}
		}
	}
}
