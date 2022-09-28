package review_questions.chapter_1.q3;

/* QUESTION: What is result of following code
 * ANSWER: s1.equals(s2) 
 */

public class Q3 {
	
	public static void main(String[] args) {
		String s1 = "Canada";
		String s2 = new String(s1);
		if(s1 == s2) System.out.println("s1 == s2");
		if(s1.equals(s2)) System.out.println("s1.equals(s2)");
	}

}
