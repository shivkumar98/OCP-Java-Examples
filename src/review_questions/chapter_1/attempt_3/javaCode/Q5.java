package review_questions.chapter_1.attempt_3.javaCode;

public class Q5 {
	
	public static void main(String[] args) {
		String a = "a";
		System.out.println(a.hashCode());
		String b = new String(a);
		System.out.println(b.hashCode());

	}

}
