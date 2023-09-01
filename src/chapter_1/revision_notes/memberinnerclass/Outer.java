package chapter_1.revision_notes.memberinnerclass;

public class Outer {
	private String greeting ="hi";
	private class Inner {
		public void go() {
			for (int i=0;i<3;i++) 
				System.out.println(greeting);
		}	
	}
	void callInner() {
		Inner inner = new Inner();
	}
	public static void main(String[] args) {
		// Inner inner = new Inner(); // COMPILER ERROR
		new Outer().callInner();;
		Inner inner = new Outer().new Inner();
	
	}
}
