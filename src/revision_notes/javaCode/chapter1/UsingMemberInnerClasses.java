package revision_notes.javaCode.chapter1;

import revision_notes.javaCode.chapter1.UsingMemberInnerClasses.MemberInnerClasses;

class Mammal {}
public class UsingMemberInnerClasses {
	private int x = 1;
	class MemberInnerClasses {
		void printX() {
			System.out.println(x);
		}
	}
	public static void main(String[] args) {
		// MemberInnerClasses inner = new MemberInnerClasses(); // COMPILER ERROR
		MemberInnerClasses inner = new UsingMemberInnerClasses().new MemberInnerClasses();
		MemberInnerClasses inner2 = new UsingMemberInnerClasses().new MemberInnerClasses();
	}
	
	private class SubClass extends MemberInnerClasses { }
	protected interface AnInterface { }
	public class Implementation implements AnInterface{}
}

class AnotherClass {
	public static void main(String[] args) {
		MemberInnerClasses inner = new UsingMemberInnerClasses().new MemberInnerClasses();
	}
}

