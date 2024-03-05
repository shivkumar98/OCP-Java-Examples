package chapter_1.c_1_7_creating_nested_classes.section_4_Static_Nested_Classes;

public class OuterClass {
	private static class InnerClass {
		private int instanceInt = 10;
		private void instanceMethod() {
			System.out.println("hello world");
		}
	}
	public static void main(String[] args) {
		InnerClass inner = new InnerClass();
		int x =inner.instanceInt;
		System.out.println(x);
		inner.instanceMethod(); // hello world
	}
}
