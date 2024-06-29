package exam_revision_notes.java;

import exam_revision_notes.java.NestedMemberClassesCanNotHaveStaticMembers.StaticNestedClass;

public class NestedMemberClassesCanNotHaveStaticMembers {

	class NestedMemberClass {
		static int x = 1; // COMPILER ERROR
	}
	
	static class StaticNestedClass {
		static int staticVariable = 1;
	}
	
	public static void main(String[] args) {
		System.out.println(StaticNestedClass.staticVariable); // 1
	}
}

class Main {
	public static void main(String[] args) {
	}
}
