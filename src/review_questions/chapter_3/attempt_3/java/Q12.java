package review_questions.chapter_3.attempt_3.java;

import java.io.FileNotFoundException;

public class Q12 {
	public static void main(String[] args) {
		Helper.printException(new FileNotFoundException("error1")); // error1
		Helper.printException(new Exception("error2")); // error2
		//Helper.<NullPointerException>printException(new Exception("error3")); // COMPILER ERROR
		Helper.<NullPointerException>printException(new NullPointerException("error4")); // error4 
		
	}
}

class Helper {
	static <U extends Exception> void printException(U u) {
		System.out.println(u.getMessage());
	}
}
