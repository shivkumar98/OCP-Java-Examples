package revision_notes.javaCode.chapter4;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsingCollect {
	public static void main(String[] args) {
		// .collect() IS a reduction!
		
		Stream<String> strings = Stream.of("i", "hate", "java","8");
		Map<Integer, String> map = strings.collect(Collectors.toMap(str->str.length(), t -> t, (t, u)->t+u));
		System.out.println(map);
	}
}
