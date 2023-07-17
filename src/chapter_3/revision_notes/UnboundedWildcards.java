package chapter_3.revision_notes;

import java.util.Arrays;
import java.util.List;

public class UnboundedWildcards {

	static void printList(List<Object> list) {
		for (Object x: list)
			System.out.println(x);
	}
	static <T> void printListWithGenerics(List<T> list) {
		for (Object x:list)
			System.out.println(x);
	}
	static void printListWithWildCar(List<?> list) {
		for (Object x:list)
			System.out.println(x);
	}
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("hello");
		// printList(list); // COMPILER ERROR
		printListWithGenerics(list); // hello
		printListWithWildCar(list);
		
	}
}
