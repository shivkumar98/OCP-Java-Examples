package chapter_1.chapter_1_7.creating_nested_classes.section_1.Member_Inner_Classes;
/* Inner classes can have variables of the same name as of the outer class*/
public class A {
	
	private int y = 10;
	class B {
		private int y = 20;
		class C {
			private int y = 30;
			void printAllX() {
				System.out.println("Printing y");
				System.out.println(y); // 30
				System.out.println(this.y); // 30
				System.out.println(A.this.y); // 10
				System.out.println(B.this.y); // 20
				System.out.println(C.this.y); // 30
			}
		}
	}
	
	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.y); // 10
		A.B b = a.new B();
		System.out.println(b.y); // 20
		A.B.C c = b.new C();
		System.out.println(c.y); // 30
		c.printAllX();
	}

}
