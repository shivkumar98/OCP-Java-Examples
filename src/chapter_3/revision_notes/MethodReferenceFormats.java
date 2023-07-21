package chapter_3.revision_notes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceFormats {
	public static void main(String[] args) {
		// static method:
		Consumer<List<String>> lam = l -> Collections.sort(l);
		Consumer<List<String>> methodRef = Collections::sort;
		lam.accept(Arrays.asList("hello","world"));
		
		// calling method on specific instance:
		String someString = "abc";
		Predicate<String> lam2 = s -> someString.startsWith(s);
		Predicate<String> methodRef2 = someString::startsWith;
		boolean test = methodRef2.test("a"); // true
		System.out.println(test);
		
		// calling method on something during runtime:
		Predicate<String> lam3 = s->s.isBlank();
		Predicate<String> methodRef3 = String::isBlank;
		boolean nonBlank = methodRef3.test("s");
		System.out.println(nonBlank); // false
		
		// constructor:
		Consumer<String> lam4 = s-> new StringBuilder(s);
		Consumer<String> methodRef4 = Constructor::new;
		methodRef4.accept("hello"); // prints hello
	}
}

class Constructor {
	public Constructor(String s) {
		System.out.println(s);
	}
	public static void main(String[] args) {
		Consumer<String> lam4 = s-> new StringBuilder(s);
		Consumer<String> methodRef4 = Constructor::new;
		methodRef4.accept("hello"); // prints hello
	}
}