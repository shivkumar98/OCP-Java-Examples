package chapter_7.c_7_4_usingConcurrentCollections.javaCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class ObtainingSynchronizedCollections {
	public static void main(String[] args) {
		List<Integer> list = Collections.synchronizedList(
				new ArrayList<>(Arrays.asList(4,3,52)));
		
		synchronized(list) {
			for (int data: list) {
				System.out.println(data);
				list.remove(data);
				
			}
		}
		
			
	}
}
