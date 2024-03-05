package chapter_1.c_1_7_creating_nested_classes.section_1_Member_Inner_Classes;

class OuterClass {
	 class InnerClass {
	  static int i = 100; // compile error
	  static void f() { } // compile error
	 }
	 public static void main(String[] args) {
		System.out.println("hello");
	}
} 