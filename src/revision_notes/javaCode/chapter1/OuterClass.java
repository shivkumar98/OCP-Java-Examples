package revision_notes.javaCode.chapter1;

public class OuterClass {
	String x = "outer";
	public static void main(String[] args) {
		int localInt = 1;
		localInt = 2; // if you modify the variable it is no longer effectively final
		class Inner {
			String x = "inner";
			void printX() {
				OuterClass outer = new OuterClass();
				System.out.println(outer.x); // outer
				System.out.println(x); // inner
//				System.out.println(localInt); // compiler error
			}
		}
		Inner inner = new Inner();
		System.out.println(inner.x); // inner
		inner.printX();
		
	}
}
