package revision_notes.javaCode.chapter1;

public class Outer {
	
	int x = 1;
	
	private class Inner {
		int x = 2;
		void printOuterX() {
			System.out.println(Outer.this.x); // 1
			System.out.println(x); // 2
		}
		void hello() {}
	}
	
	public static void main(String[] args) {
		System.out.println(new Outer().new Inner().x); // 2
		new Outer().new Inner().printOuterX(); 
	}
}
