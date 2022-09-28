package review_questions.chapter_1.q05;
/*
 * QUESTION: Which of the following statements are true, assuming a and b are String objects? (Choose 
			 all that apply.)
OPTIONS:
A. If a.equals(b) is true, a.hashCode() == b.hashCode() is always true.
B. If a.equals(b) is true, a.hashCode() == b.hashCode() is sometimes but not 
   always true.
C. If a.equals(b) is false, a.hashCode() == b.hashCode() can never be true.
D. If a.equals(b) is false, a.hashCode() == b.hashCode() can sometimes be true.		

CORRECT ANSWER: A,D - two equal Strings will ALWAYS have the same hashCode
				Two strings may have the same hashCode but they would not be equal
 */
public class Q5 {
	
	public static void main(String[] args) {
		String one = "one";
		String two = new String(one);
		System.out.println(one.equals(two)); // true
		System.out.println(one.hashCode() + ":"+two.hashCode()); // 110182:110182
		
	}

}
