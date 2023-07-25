package chapter_3.revision_notes_v2;

import java.util.List;

import javax.management.RuntimeErrorException;

import java.util.*;

public class Bounds {
	public static void main(String[] args) {
		printList(new ArrayList<String>()); // []
		List<Exception> list = Arrays.asList(new Exception("error1"));
		List<RuntimeException> list2 = Arrays.asList(new RuntimeErrorException(null, "error2"));
		List<Throwable> list3 = Arrays.asList(new Throwable("error3"));
		printException(list); // error1
		printException(list2); // error2
		//printException(list3); // COMPILER ERROR
	}
	
	static void printList(List<?> list) {
		System.out.println(list);
	}
	static void printException(List<? extends Exception> list) {
		System.out.println(list.get(0).getMessage());
		
	}
}
