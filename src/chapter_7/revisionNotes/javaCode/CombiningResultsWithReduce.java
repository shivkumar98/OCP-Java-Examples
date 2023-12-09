package chapter_7.revisionNotes.javaCode;

import java.util.stream.Stream;

public class CombiningResultsWithReduce {
	public static void main(String[] args) {
//		Stream<Character> str
//			= Stream.of('1','2','3','4','5');
//		String string 
//		= str.reduce("", 
//				(String s, Character c)->{System.out.println("s:"+s+",c:"+c); return s+c;},
//				(String t, String u)->{System.out.println("t:"+t+",u:"+u); return t+u;} );
//		System.out.println(string);
		
		// ==============================================================
		
		Stream<Character> parallelStr
		= Stream.of('1','2','3','4','5').parallel();
		String parallelString 
		= parallelStr.reduce("", 
				(String s, Character c)->{System.out.println("s:"+s+", c:"+c); return s+c;},
				(String t, String u)->{System.out.println("t:"+t+", u:"+u); return t+u;} );
//		System.out.println(parallelString);
	}
}
