package chapter_3.chapter_3_2_working_with_generics.java;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWildcards {
	
	/* DOES NOT COMPILE
	public static void addSound(List<?> list) {
		list.add("quack");
	}
	*/
	
	/* DOES NOT COMPILE
	public static void addSound(List<? extends Object> list) {
		list.add("quack");
	}
	*/	
	
	public static void addSound(List<Object> list) {
		list.add("quack"); // compiles fine
	}
	
	public static void addSoundLowerBound(List<? super String> list) {
		list.add("quack");
	}
	
	public static void main(String[] args) {
		List<Object> objects = new ArrayList<>();
		List<String> strings = new ArrayList<>();
		addSound(objects);
		// addSound(strings); // does not compile
		addSoundLowerBound(objects);
		addSoundLowerBound(strings);
	}
}
