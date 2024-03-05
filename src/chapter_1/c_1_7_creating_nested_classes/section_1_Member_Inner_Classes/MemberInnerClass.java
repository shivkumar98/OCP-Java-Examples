
package chapter_1.c_1_7_creating_nested_classes.section_1_Member_Inner_Classes;

/* A Member Inner Class: a class defined at member level of class
 * This type of class has the following properties
 * 1) Can be declared public/private/protected/default(no modifier)
 * 2) Can extend any class which implements interfaces
 * 3) Can be abstract or final
 * 4) Cannot declare static fields or methods
 * 5) Can access members of the outer class including private members
 */
public class MemberInnerClass {
	private String str = "Hello World!";
	protected class InnerClass{
		public int repeat = 2;
		public void start() {
			for (int i=0; i< repeat;i++) {
				System.out.println(str);
			}
		}
	}

	public void outerCallsInner() {
		InnerClass inner = new InnerClass();
		inner.start();
	}
	public static void main(String[] args) {
		MemberInnerClass outer = new MemberInnerClass();
		outer.outerCallsInner(); // prints Hello World! twice
		/* You cannot instantiate the inner class from outside: 
		InnerClass inner = new InnerClass();
		But there is a work around: */
		InnerClass inner = outer.new InnerClass();
		inner.start(); // prints Hello World! twice
	}
}
