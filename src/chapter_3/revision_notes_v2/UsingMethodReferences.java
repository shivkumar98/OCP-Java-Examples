package chapter_3.revision_notes_v2;

import java.util.Comparator;
import java.util.function.Predicate;

public class UsingMethodReferences {
	public static void main(String[] args) {
		Comparator<Size> c = Helper::compareBySize;
		
		String digits = "01";
		Predicate<String> pred = digits::contains;
		System.out.println(pred.test("1")); // true
		
		Predicate<String> pred2 = String::isBlank;
		System.out.println(pred2.test("    ")); // true
		
	}
}

class Helper {
	static int compareBySize(Size x, Size y) {
		return Integer.compare(x.size, y.size);
	}
}
