package exam_revision_notes.java;

import exam_revision_notes.java.Outer.Inner;

public class UsingOuterAndInner {
	public static void main(String[] args) {
		Outer outer = new Outer();
		//Inner inner = new Inner(); // COMPILER ERORR
		Inner inner = outer.new Inner();
	}
}
