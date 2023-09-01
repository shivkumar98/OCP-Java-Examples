package chapter_1.revision_notes.memberinnerclass;

public class A {
	int x = 11;
	class B {
		int x = 22;
		class C {
			int x = 33;
			int y = 456;
			void printAll() {
				System.out.println(x); // 33
				System.out.println(this.x); //33
				System.out.println(B.this.x); // 22
				System.out.println(A.this.x); // 11
			}
		}
	}
	public static void main(String[] args) {
		int aX = new A().x;
		int bX = new A().new B().x;
		int cX = new A().new B().new C().x;
		new A().new B().new C().printAll();
	}

}
