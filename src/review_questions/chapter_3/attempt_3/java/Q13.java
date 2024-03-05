package review_questions.chapter_3.attempt_3.java;

import java.util.*;

public class Q13 {
	public static void main(String[] args) {
		WildCard card = new WildCard();
		ArrayDeque<?> list1 = new ArrayDeque<String>();
		// ArrayDeque is queue not List!!!
		//card.showSize(list1); // COMPILER ERROR
		
		ArrayList<? super Date> list2 = new ArrayList<Date>();
		card.showSize(list2); // 0
		
		List<?> list3 = new LinkedList<java.io.IOException>();
		card.showSize(list3); // 0
		
		//List<Exception> list4 = new LinkedList<java.io.IOException>(); // COMPILER ERROR
		
		Vector<? extends Number> list5 = new Vector<Integer>();
		card.showSize(list5); // 0
		
	}
}

class WildCard {
	public void showSize(List<?> list) {
		System.out.println(list.size());
	}
}
