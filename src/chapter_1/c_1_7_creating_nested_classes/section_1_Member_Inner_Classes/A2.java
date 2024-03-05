package chapter_1.c_1_7_creating_nested_classes.section_1_Member_Inner_Classes;

public class A2 {
	int x = 1;
	int sameName = 10;
	class B2 {
		int y = 2;
		int sameName = 20;
		void printC2(){
			new C2().print();
		}
		class C2 {
			int z = 3;
			int sameName = 30;
			void print() {
				System.out.println(x); // 1
				System.out.println(y); // 2
				System.out.println(z); // 3
				System.out.println("----");
				System.out.println(sameName); // 10
				System.out.println(this.sameName); // 10
				System.out.println(B2.this.sameName); // 10
				System.out.println(A2.this.sameName); // 10
			}
		}
	}
	public static void main(String[] args) {
		new A2().new B2().printC2();
		A2.B2.C2 c = new A2().new B2().new C2();
	}
	
}
