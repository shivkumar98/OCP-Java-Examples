package review_questions.chapter_3.attempt_5.javaCode;
import java.util.*;

public class Q3 {
public static void main(String[] args) {
	List list = new ArrayList();
	list.add("one");
	list.add("two");
	list.add(7);            // LINE 6
	for (String s: list)    // LINE 7
	System.out.println(s);
}
}
