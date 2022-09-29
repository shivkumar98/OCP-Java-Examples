package review_questions.chapter_1.q14;
/* 	QUESTION: Which is a statement about the following code?

	OPTIONS:
	A. The output is 0.
	B. The output is 3.
	C. The output is 7.
	D. c instanceof Mammal does not compile.
	E. l instanceof Furry does not compile.
	F. r instanceof Chipmunk does not compile.
	
	ANSWER: E, option F does cimpiler since runnable is an interface
 */
import java.util.*;
public class IsItFurry {
	static class Chipmunk {}
	public static void main(String[] args) {
		Chipmunk c = new Chipmunk();
		ArrayList<Chipmunk> l = new ArrayList<>();
		Runnable r = new Thread();
		int result = 0;
		if (c instanceof Chipmunk) result+=1;
		if (l instanceof Chipmunk) result+=2;
		if (r instanceof Chipmunk) result+=4;
		System.out.println(result);
	}
}
