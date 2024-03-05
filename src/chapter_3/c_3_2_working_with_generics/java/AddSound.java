package chapter_3.c_3_2_working_with_generics.java;
import java.util.List;
import java.util.ArrayList;
public class AddSound {
	
	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		strings.add("tweet");
		List<Object> objects = new ArrayList<Object>(strings);
		addSound(strings);
		addSound(objects);
		addSound2(strings);
		addSound2(objects);
		// addSound3(strings); // does not compile with List<String>
		addSound3(objects);
		addSound4(strings);
		// addSound4(objects); // does not compile with List<Object>
		addSound5(strings);
		addSound5(objects);
	}

	private static void addSound(List<?> list) {
			// list.add("quack"); // does not compile
	}
	private static void addSound2(List<? extends Object> list) {
		// list.add("quack"); // does not compile
	}
	private static void addSound3(List<Object> list) {
		list.add("quack"); // does not compile
	}
	private static void addSound4(List<String> list) {
		list.add("quack");
	}
	private static void addSound5(List<? super String> list) {
		list.add("quack");
	}

}
