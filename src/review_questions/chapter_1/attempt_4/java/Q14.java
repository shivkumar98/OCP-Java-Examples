package review_questions.chapter_1.attempt_4.java;

import java.util.ArrayList;
import java.util.List;

public class Q14 {
	static class Chipmunk{}
	public static void main(String[] args) {
		Chipmunk c = new Chipmunk();
		ArrayList<Chipmunk> arrayListRef = new ArrayList<>();
		List<Chipmunk> listChipmunk = new ArrayList<>();
		List<Integer> listInteger = new ArrayList<>();
		Runnable runnableRef = new Thread();
		// boolean a1 = arrayListRef instanceof Chipmunk;
		// COMPILER ERROR^^
		
		boolean a2 = listInteger instanceof Chipmunk;
		// COMPILES FINE!!!
		
		boolean a3 = listChipmunk instanceof Chipmunk;
		// COMPILES FINE!!!

	}
}
