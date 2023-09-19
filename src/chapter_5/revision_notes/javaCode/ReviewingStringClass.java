package chapter_5.revision_notes.javaCode;

public class ReviewingStringClass {
	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder("abc");
		StringBuilder sb2 = sb1.reverse();
		System.out.println(sb1 == sb2); // true
		sb1.append("d");
		System.out.println(sb1); // cbad
		System.out.println(sb2); // cbad
	}

}
