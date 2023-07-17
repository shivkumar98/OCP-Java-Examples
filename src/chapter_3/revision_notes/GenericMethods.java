package chapter_3.revision_notes;

public class GenericMethods {
	
	static <T> void method1(T t) {
		System.out.println(t);
	}
	
	public static void main(String[] args) {
		method1(new String("hello world")); // hello world

	}
}
