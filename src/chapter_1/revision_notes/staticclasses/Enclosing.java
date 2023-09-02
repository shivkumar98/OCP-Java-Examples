package chapter_1.revision_notes.staticclasses;

public class Enclosing {
	int x = 1;
	private static class Nested {
		static int price = 2;
	}
	public static void main(String[] args) {
		Nested nested = new Nested();
		System.out.println(nested.price); // 2
	}
}
